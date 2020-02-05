package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.LocalidadeDTO;
import br.com.sisms.api.model.entity.Localidade;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.LocalidadeMapper;
import br.com.sisms.api.repository.LocalidadeRepository;
import lombok.AllArgsConstructor;
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
public class LocalidadeService {

    private final LocalidadeRepository repository;
    private final UFService ufService;
    private final LocalidadeMapper mapper;

    @Transactional(readOnly = true)
    public List<LocalidadeDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public List<LocalidadeDTO> findByUfId(final Long id) {
        return mapper.toDTO(repository.findByUfId(id));
    }

    @Transactional(readOnly = true)
    public Page<LocalidadeDTO> findByFilter(final PageableFilter pageableFilter) {
        Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Sort.Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public LocalidadeDTO createOrUpdate(final Long id, final LocalidadeDTO dtoSource) {
        validateResource(dtoSource);
        Localidade entity;
        if (Objects.nonNull(id)) {
            LocalidadeDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescriptionAndUF(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0049.toString())));
    }

    private void validateResource(final LocalidadeDTO dto) {
        ufService.findById(dto.getUfId());
    }

    private void validateDuplicityByDescriptionAndUF(final Localidade entity) {
        final LocalidadeDTO dto = mapper.toDTO(repository.findByDescricaoIgnoreCaseAndUfId(entity.getDescricao(), entity.getUf().getId()));
        if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG0031.toString());
        }
    }

}
