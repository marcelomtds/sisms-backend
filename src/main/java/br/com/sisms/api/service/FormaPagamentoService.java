package br.com.sisms.api.service;

import br.com.sisms.api.exception.ResourceNotFoundException;
import br.com.sisms.api.model.dto.FormaPagamentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.mapper.FormaPagamentoMapper;
import br.com.sisms.api.repository.FormaPagamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class FormaPagamentoService {

    private final FormaPagamentoRepository repository;
    private final FormaPagamentoMapper mapper;

    @Transactional(readOnly = true)
    public List<FormaPagamentoDTO> findAll() {
        return mapper.toDTO(repository.findAll(new Sort(Sort.Direction.ASC, "descricao")));
    }

    @Transactional(readOnly = true)
    public FormaPagamentoDTO findById(final Long id) {
        return mapper.toDTO(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MessageEnum.MSG00051.toString())));
    }

}
