package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.ReservaDTO;
import br.com.sisms.api.model.entity.Reserva;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.ReservaMapper;
import br.com.sisms.api.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository repository;
    private final ReservaMapper mapper;
    private final PacienteService pacienteService;

    public ReservaDTO createOrUpdate(final Long id, final ReservaDTO dtoSource) {
        validateResources(dtoSource);
        validateDuplicityByPaciente(dtoSource, id);
        final Reserva entity;
        if (Objects.nonNull(id)) {
            final ReservaDTO dtoTarget = findById(id);
            dtoTarget.setObservacao(dtoSource.getObservacao());
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public ReservaDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0074.toString())));
    }

    @Transactional(readOnly = true)
    public List<ReservaDTO> findAll() {
        return mapper.toDTO(repository.findAll(Sort.by(Sort.Direction.ASC, "paciente.nomeCompleto")));
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    public void deleteByPacienteId(final Long pacienteId) {
        repository.deleteByPacienteId(pacienteId);
    }

    private void validateResources(final ReservaDTO dto) {
        pacienteService.findById(dto.getPacienteId());
    }

    private void validateDuplicityByPaciente(final ReservaDTO dto, final Long id) {
        Reserva entity = repository.findByPacienteId(dto.getPacienteId());
        if (Objects.nonNull(entity) && !entity.getId().equals(id)) {
            throw new BusinessException(MessageEnum.MSG0075.toString());
        }
    }

}
