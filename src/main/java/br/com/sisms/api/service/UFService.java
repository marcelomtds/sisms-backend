package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.UFDTO;
import br.com.sisms.api.model.entity.UF;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.UFMapper;
import br.com.sisms.api.repository.UFRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class UFService {

    private final UFRepository repository;
    private final UFMapper mapper;

    @Transactional(readOnly = true)
    public List<UFDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public Page<UFDTO> findByFilter(final PageableFilter pageableFilter) {
        pageableFilter.setOrderBy(StringUtils.isBlank(pageableFilter.getOrderBy()) ? "id" : pageableFilter.getOrderBy());
        Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Sort.Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public UFDTO createOrUpdate(final Long id, final UFDTO dtoSource) {
        UF entity;
        if (Objects.nonNull(id)) {
            UFDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescription(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public UFDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG00040.toString())));
    }

    private void validateDuplicityByDescription(final UF entity) {
        final UFDTO dtoResult = mapper.toDTO(repository.findByDescricaoIgnoreCase(entity.getDescricao()));
        if (Objects.nonNull(dtoResult) && !dtoResult.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG00034.toString());
        }
    }


}
