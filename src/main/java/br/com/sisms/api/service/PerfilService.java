package br.com.sisms.api.service;

import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.PerfilDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.PerfilMapper;
import br.com.sisms.api.repository.PerfilRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;
    private final PerfilMapper mapper;

    @Transactional(readOnly = true)
    public List<PerfilDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public PerfilDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG00042.toString())));
    }

}
