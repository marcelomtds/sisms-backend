package br.com.sisms.api.service;

import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.PeriodoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.PeriodoMapper;
import br.com.sisms.api.repository.PeriodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PeriodoService {

    private final PeriodoRepository repository;
    private final PeriodoMapper mapper;

    @Transactional(readOnly = true)
    public List<PeriodoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Transactional(readOnly = true)
    public PeriodoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG0088.toString())));
    }
}
