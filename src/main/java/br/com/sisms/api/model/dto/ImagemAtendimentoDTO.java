package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class ImagemAtendimentoDTO implements Serializable {

    private static final long serialVersionUID = -1544036439535614098L;

    private Long id;

    private Long atendimentoId;

    @NotBlank(message = "{imagem.nome.vazio}")
    @Size(max = 200, message = "{imagem.nome.tamanho}")
    private String nome;

    @NotBlank(message = "{imagem.imagem}")
    @Size(max = 10485760, message = "{imagem.tamanho}")
    private String imagem;

    @Size(max = 200, message = "{imagem.observacao}")
    private String observacao;

}
