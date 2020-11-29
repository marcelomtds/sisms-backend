package br.com.sisms.api.service;

import br.com.sisms.api.model.dto.MenuDTO;
import br.com.sisms.api.model.entity.Menu;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.PerfilEnum;
import br.com.sisms.api.model.mapper.MenuMapper;
import br.com.sisms.api.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class MenuService {

    private final MenuRepository repository;
    private final MenuMapper mapper;
    private final UsuarioService usuarioService;
    private final List<Long> RESTRICTION = Arrays.asList(6L, 33L);

    @Transactional(readOnly = true)
    public List<MenuDTO> findAll() {
        final Usuario user = usuarioService.getCurrentSessionUser();
        List<Menu> menus = repository.findAllMenus();
        if (user.getPerfil().getId().equals(PerfilEnum.USUARIO.getPerfil())) {
            menus = menus.stream().filter(x -> !RESTRICTION.contains(x.getId())).collect(Collectors.toList());
        }
        menus.forEach(it -> {
            it.setSubmenus((repository.findSubmenusByPaiId(it.getId())));
        });
        return mapper.toDTO(menus);
    }

}

