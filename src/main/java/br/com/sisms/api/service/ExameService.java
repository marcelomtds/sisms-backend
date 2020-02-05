package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.ExameDTO;
import br.com.sisms.api.model.entity.Exame;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.ExameFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.model.mapper.ExameMapper;
import br.com.sisms.api.repository.ExameRepository;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class ExameService {

    private final ExameRepository repository;
    private final ExameMapper mapper;
    private final AnexoExameService imagemExameService;
    private final PacienteService pacienteService;
    private final CategoriaExameService categoriaExameService;

    public ExameDTO createOrUpdate(final Long id, final ExameDTO dtoSource) {
        validateResources(dtoSource);
        final Exame entity;
        if (Objects.nonNull(id)) {
            final ExameDTO dtoTarget = findById(id);
            imagemExameService.deleteAllByExameId(id);
            BeanUtils.copyProperties(dtoSource, dtoTarget, "id", "pacienteId");
            entity = mapper.toEntity(dtoTarget);
        } else {
            entity = mapper.toEntity(dtoSource);
        }
        if (!ObjectUtils.isEmpty(entity.getAnexos())) {
            entity.getAnexos().forEach(imagem -> {
                imagem.setId(null);
                imagem.setExame(entity);
            });
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional(readOnly = true)
    public ExameDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0066.toString())));
    }

    @Transactional(readOnly = true)
    public Page<ExameDTO> findByFilter(final PageableFilter<ExameFilter> filter) {
        filter.setFilter(Objects.isNull(filter.getFilter()) ? new ExameFilter() : filter.getFilter());
        validatePeriod(filter.getFilter().getDataInicio(), filter.getFilter().getDataFim());
        filter.setOrderBy(StringUtils.isBlank(filter.getOrderBy()) ? "id" : filter.getOrderBy());
        final Pageable pageable = PageRequest.of(
                filter.getCurrentPage(),
                filter.getPageSize(),
                Sort.Direction.valueOf(filter.getDirection()),
                filter.getOrderBy());
        return repository.findByFilter(
                filter.getFilter().getPacienteId(),
                filter.getFilter().getCategoriaExameId(),
                filter.getFilter().getDataInicio(),
                filter.getFilter().getDataFim(),
                pageable).map(mapper::toDTO);
    }

    public void delete(final Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private void validateResources(final ExameDTO dto) {
        pacienteService.findById(dto.getPacienteId());
        categoriaExameService.findById(dto.getCategoriaExameId());
    }

    private void validatePeriod(final LocalDate startDate, final LocalDate endDate) {
        if (Objects.nonNull(startDate) && Objects.nonNull(endDate) && Util.isInvalidPeriod(startDate, endDate)) {
            throw new BusinessException(MessageEnum.MSG0008.toString());
        }
    }

}
