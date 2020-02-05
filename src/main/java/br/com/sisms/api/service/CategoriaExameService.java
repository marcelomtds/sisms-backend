package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.CategoriaExameDTO;
import br.com.sisms.api.model.entity.CategoriaExame;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.CategoriaExameMapper;
import br.com.sisms.api.repository.CategoriaExameRepository;
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
@Transactional
@AllArgsConstructor
public class CategoriaExameService {

    private final CategoriaExameRepository repository;
    private final CategoriaExameMapper mapper;

    @Transactional(readOnly = true)
    public List<CategoriaExameDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public Page<CategoriaExameDTO> findByFilter(final PageableFilter pageableFilter) {
        final Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public CategoriaExameDTO createOrUpdate(final Long id, final CategoriaExameDTO dtoSource) {
        final CategoriaExame entity;
        if (Objects.nonNull(id)) {
            final CategoriaExameDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescription(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public CategoriaExameDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0064.toString())));
    }

    private void validateDuplicityByDescription(final CategoriaExame entity) {
        final CategoriaExameDTO dtoResult = mapper.toDTO(repository.findByDescricaoIgnoreCase(entity.getDescricao()));
        if (Objects.nonNull(dtoResult) && !dtoResult.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG0065.toString());
        }
    }

}
