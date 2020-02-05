package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.CategoriaLancamentoDTO;
import br.com.sisms.api.model.entity.CategoriaLancamento;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.CategoriaLancamentoMapper;
import br.com.sisms.api.repository.CategoriaLancamentoRepository;
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
public class CategoriaLancamentoService {

    private final CategoriaLancamentoRepository repository;
    private final CategoriaLancamentoMapper mapper;

    @Transactional(readOnly = true)
    public List<CategoriaLancamentoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public Page<CategoriaLancamentoDTO> findByFilter(final PageableFilter pageableFilter) {
        final Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public CategoriaLancamentoDTO createOrUpdate(final Long id, final CategoriaLancamentoDTO dtoSource) {
        CategoriaLancamento entity;
        if (Objects.nonNull(id)) {
            CategoriaLancamentoDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescription(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public CategoriaLancamentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0053.toString())));
    }

    private void validateDuplicityByDescription(final CategoriaLancamento entity) {
        final CategoriaLancamentoDTO dtoResult = mapper.toDTO(repository.findByDescricaoIgnoreCase(entity.getDescricao()));
        if (Objects.nonNull(dtoResult) && !dtoResult.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG0030.toString());
        }
    }

}
