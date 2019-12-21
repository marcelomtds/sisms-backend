package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.LocalidadeDTO;
import br.com.sisms.api.model.entity.Localidade;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.LocalidadeMapper;
import br.com.sisms.api.model.request.LocalidadeRequest;
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

    public LocalidadeDTO createOrUpdate(final Long id, final LocalidadeRequest request) {
        validateResource(request);
        Localidade entity;
        if (Objects.nonNull(id)) {
            LocalidadeDTO dto = findById(id);
            BeanUtils.copyProperties(mapper.toDTO(request), dto, "id");
            entity = mapper.toEntity(dto);
        } else {
            entity = mapper.toEntity(request);
        }
        validateDuplicityByDescriptionAndUF(entity);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.LOCALIDADE_NAO_ENCONTRADA.toString())));
    }

    private void validateResource(final LocalidadeRequest request) {
        ufService.findById(request.getUfId());
    }

    private void validateDuplicityByDescriptionAndUF(final Localidade entity) {
        final LocalidadeDTO dto = mapper.toDTO(repository.findByDescricaoIgnoreCaseAndUfId(entity.getDescricao(), entity.getUf().getId()));
        if (Objects.nonNull(dto) && !dto.getId().equals(entity.getId())) {
            throw new BusinessException(MessageEnum.REGISTRO_JA_CADASTRADO.toString());
        }
    }

}
