package br.com.sisms.api.service;

import br.com.sisms.api.repository.PosAtendimentoOutraMedidaRepository;
import br.com.sisms.api.repository.PreAtendimentoOutraMedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PosAtendimentoOutraMedidaService {

    private final PosAtendimentoOutraMedidaRepository repository;

    public void deleteAllByPosAtendimentoId(final Long id) {
        this.repository.deleteAllByPosAtendimentoId(id);
    }

}
