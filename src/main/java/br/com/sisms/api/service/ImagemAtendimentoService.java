package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.ImagemAtendimentoDTO;
import br.com.sisms.api.model.mapper.ImagemAtendimentoMapper;
import br.com.sisms.api.repository.ImagemAtendimentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ImagemAtendimentoService {

    private final ImagemAtendimentoRepository repository;
    private final ImagemAtendimentoMapper mapper;

    public void deleteAllByAtendimentoId(final Long id) {
        this.repository.deleteAllByAtendimentoId(id);
    }

    @Transactional(readOnly = true)
    public List<ImagemAtendimentoDTO> findByAtendimento(final Long id) {
        return mapper.toDTO(repository.findByAtendimentoId(id));
    }
}
