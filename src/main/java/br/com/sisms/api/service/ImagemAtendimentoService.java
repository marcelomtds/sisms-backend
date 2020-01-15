package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.ImagemAtendimentoDTO;
import br.com.sisms.api.model.mapper.ImagemAtendimentoMapper;
import br.com.sisms.api.repository.ImagemAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ImagemAtendimentoService {

    private final ImagemAtendimentoRepository repository;
    private final ImagemAtendimentoMapper mapper;

    @Autowired
    private AtendimentoService atendimentoService;

    public ImagemAtendimentoService(final ImagemAtendimentoRepository repository, final ImagemAtendimentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void deleteAllByAtendimentoId(final Long id) {
        this.repository.deleteAllByAtendimentoId(id);
    }

    @Transactional(readOnly = true)
    public List<ImagemAtendimentoDTO> findByAtendimento(final Long id) {
        checkPermission(id);
        return mapper.toDTO(repository.findByAtendimentoId(id));
    }

    private void checkPermission(final Long id) {
        atendimentoService.findByIdWithPermission(id);
    }

}
