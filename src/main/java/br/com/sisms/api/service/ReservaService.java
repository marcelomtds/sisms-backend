package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.ReservaDTO;
import br.com.sisms.api.model.entity.Reserva;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.ReservaMapper;
import br.com.sisms.api.repository.ReservaRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ReservaService {

    private final ReservaRepository repository;
    private final ReservaMapper mapper;

    public ReservaDTO createOrUpdate(final Long id, final ReservaDTO dtoSource) {
        validateDuplicityByPaciente(dtoSource);
        final Reserva entity;
        if (Objects.nonNull(id)) {
            final ReservaDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
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
    public Page<ReservaDTO> findByFilter(final PageableFilter pageableFilter) {
        pageableFilter.setOrderBy(StringUtils.isBlank(pageableFilter.getOrderBy()) ? "id" : pageableFilter.getOrderBy());
        Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Sort.Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private void validateDuplicityByPaciente(final ReservaDTO dto) {
        final Reserva entity = repository.findByPacienteNomeCompletoIgnoreCase(dto.getPacienteNomeCompleto());
        if (Objects.nonNull(entity) && !entity.getId().equals(dto.getId())) {
            throw new BusinessException(MessageEnum.MSG0075.toString());
        }
    }

}
