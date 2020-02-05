package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.ProfissaoDTO;
import br.com.sisms.api.model.entity.Profissao;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.ProfissaoMapper;
import br.com.sisms.api.repository.ProfissaoRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
public class ProfissaoService {

    private final ProfissaoRepository repository;
    private final ProfissaoMapper mapper;

    @Transactional(readOnly = true)
    public List<ProfissaoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public Page<ProfissaoDTO> findByFilter(final PageableFilter pageableFilter) {
        pageableFilter.setOrderBy(StringUtils.isBlank(pageableFilter.getOrderBy()) ? "id" : pageableFilter.getOrderBy());
        Pageable pageable = PageRequest.of(
                pageableFilter.getCurrentPage(),
                pageableFilter.getPageSize(),
                Direction.valueOf(pageableFilter.getDirection()),
                pageableFilter.getOrderBy());
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    @Transactional(readOnly = true)
    public ProfissaoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0050.toString())));
    }

    public ProfissaoDTO createOrUpdate(final Long id, final ProfissaoDTO dtoSource) {
        Profissao entity;
        if (Objects.nonNull(id)) {
            ProfissaoDTO dtoTarget = findById(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        validateDuplicityByDescription(entity);
        return mapper.toDTO(repository.save(entity));
    }

    private void validateDuplicityByDescription(final Profissao entity) {
        final ProfissaoDTO dto = mapper.toDTO(repository.findByDescricaoIgnoreCase(entity.getDescricao()));
        if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.MSG0033.toString());
        }
    }

}
