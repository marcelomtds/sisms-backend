package br.com.sisms.api.service;

import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.CategoriaAtendimentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.CategoriaAtendimentoMapper;
import br.com.sisms.api.repository.CategoriaAtendimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CategoriaAtendimentoService {

    private final CategoriaAtendimentoRepository repository;
    private final CategoriaAtendimentoMapper mapper;

    @Transactional(readOnly = true)
    public List<CategoriaAtendimentoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public CategoriaAtendimentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.CATEGORIA_ATENDIMENTO_NAO_ENCONTRADA.toString())));
    }

}
