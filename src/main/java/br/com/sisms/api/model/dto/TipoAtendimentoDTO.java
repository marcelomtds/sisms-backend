package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TipoAtendimentoDTO implements Serializable {

    private static final long serialVersionUID = 6553224901322408833L;

    private Long id;

    private String descricao;

}
