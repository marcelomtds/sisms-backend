package br.com.sisms.api.service;

import br.com.sisms.api.repository.PreAtendimentoOutraMedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PreAtendimentoOutraMedidaService {

    private final PreAtendimentoOutraMedidaRepository repository;

    public void deleteAllByPreAtendimentoId(final Long id) {
        this.repository.deleteAllByPreAtendimentoId(id);
    }

}
