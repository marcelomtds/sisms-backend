package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.AgendaDTO;
import br.com.sisms.api.model.entity.Agenda;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.AgendaMapper;
import br.com.sisms.api.repository.AgendaRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AgendaService {

    private final AgendaRepository repository;
    private final AgendaMapper mapper;
    private final CategoriaAtendimentoService categoriaAtendimentoService;
    private final DiaSemanaService diaSemanaService;
    private final PacienteService pacienteService;
    private final TipoAtendimentoService tipoAtendimentoService;
    private final ReservaService reservaService;

    @Transactional(readOnly = true)
    public List<AgendaDTO> findAllByWeekDay() {
        return mapper.toDTO(repository.findAllByWeekDay());
    }

    @Transactional(readOnly = true)
    public List<AgendaDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "horarioInicio")));
    }

    @Transactional(readOnly = true)
    public AgendaDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0060.toString())));
    }

    public AgendaDTO createOrUpdate(final Long id, final AgendaDTO dtoSource) {
        validateResources(dtoSource);
        validatePeriod(dtoSource.getHorarioInicio(), dtoSource.getHorarioFim());
        Agenda entity;
        if (Objects.nonNull(id)) {
            AgendaDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        removeFromReserva(entity.getPaciente().getId());
        return mapper.toDTO(repository.save(entity));
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public void validateResources(final AgendaDTO dto) {
        categoriaAtendimentoService.findById(dto.getCategoriaAtendimentoId());
        diaSemanaService.findById(dto.getDiaSemanaId());
        pacienteService.findById(dto.getPacienteId());
        tipoAtendimentoService.findById(dto.getTipoAtendimentoId());
    }

    private void validatePeriod(final LocalTime start, final LocalTime end) {
        if (Util.isInvalidPeriod(start, end)) {
            throw new BusinessException(MessageEnum.MSG0061.toString());
        }
    }

    private void removeFromReserva(final Long pacienteId) {
        reservaService.deleteByPacienteId(pacienteId);
    }

}
