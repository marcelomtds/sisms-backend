package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.ImagemExameDTO;
import br.com.sisms.api.model.mapper.ImagemExameMapper;
import br.com.sisms.api.repository.ImagemExameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ImagemExameService {

    private final ImagemExameRepository repository;
    private final ImagemExameMapper mapper;

    public void deleteAllByExameId(final Long id) {
        this.repository.deleteAllByExameId(id);
    }

    @Transactional(readOnly = true)
    public List<ImagemExameDTO> findByExameId(final Long id) {
        return mapper.toDTO(repository.findByExameId(id));
    }

}
