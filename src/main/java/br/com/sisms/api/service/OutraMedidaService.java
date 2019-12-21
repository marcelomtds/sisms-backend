package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.OutraMedidaDTO;
import br.com.sisms.api.model.entity.OutraMedida;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.OutraMedidaMapper;
import br.com.sisms.api.repository.OutraMedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@Transactional
public class OutraMedidaService {

    private final OutraMedidaRepository repository;
    private final OutraMedidaMapper mapper;

    @Transactional(readOnly = true)
    public List<OutraMedidaDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public Page<OutraMedidaDTO> findByFilter(final PageableFilter pageableFilter) {
        Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public OutraMedidaDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.OUTRA_MEDIDA_NAO_ENCONTRADA.toString())));
    }

    public OutraMedidaDTO createOrUpdate(final Long id, final OutraMedidaDTO dtoSource) {
        OutraMedida entity;
        if (Objects.nonNull(id)) {
            OutraMedidaDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescription(entity);
        return mapper.toDTO(repository.save(entity));
    }

    private void validateDuplicityByDescription(final OutraMedida entity) {
        final OutraMedidaDTO dto = mapper.toDTO(repository.findByDescricaoIgnoreCase(entity.getDescricao()));
        if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.REGISTRO_JA_CADASTRADO.toString());
        }
    }

}
