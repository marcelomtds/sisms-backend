package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.AnexoExameDTO;
import br.com.sisms.api.model.mapper.AnexoExameMapper;
import br.com.sisms.api.repository.AnexoExameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AnexoExameService {

    private final AnexoExameRepository repository;
    private final AnexoExameMapper mapper;

    public void deleteAllByExameId(final Long id) {
        this.repository.deleteAllByExameId(id);
    }

    @Transactional(readOnly = true)
    public List<AnexoExameDTO> findByExameId(final Long id) {
        return mapper.toDTO(repository.findByExameId(id));
    }

}
