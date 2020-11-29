package br.com.sisms.api.model.dto;

import br.com.sisms.api.model.entity.Menu;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class MenuDTO implements Serializable {

    private static final long serialVersionUID = -8547293761669448018L;

    private Long id;

    private String descricao;

    private String icone;

    private String rota;

    private Menu pai;

    private List<Menu> submenus;

}