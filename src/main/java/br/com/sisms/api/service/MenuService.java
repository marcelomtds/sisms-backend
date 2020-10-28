package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.MenuDTO;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.mapper.MenuMapper;
import br.com.sisms.api.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class MenuService {

    private final MenuRepository repository;
    private final MenuMapper mapper;
    private final UsuarioService usuarioService;

    @Transactional(readOnly = true)
    public List<MenuDTO> findAll() {
        final Usuario usuario = usuarioService.getCurrentSessionUser();
        return mapper.toDTO(repository.findAll().stream().filter(menu -> Objects.isNull(menu.getPai())).collect(Collectors.toList()));
    }

}

