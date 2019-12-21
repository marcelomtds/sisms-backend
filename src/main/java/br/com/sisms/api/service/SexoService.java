package br.com.sisms.api.service;

import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.SexoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.SexoMapper;
import br.com.sisms.api.repository.SexoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class SexoService {

    private final SexoRepository repository;
    private final SexoMapper mapper;

    @Transactional(readOnly = true)
    public List<SexoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public SexoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.SEXO_NAO_ENCONTRADO.toString())));
    }
}
