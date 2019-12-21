package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO implements Serializable {

    private static final long serialVersionUID = -2618716820063723366L;

    private Long id;

    private String nomeCompleto;

    private LocalDate dataNascimento;

    private String rg;

    private String cpf;

    private Boolean ativo;

    private SexoDTO sexo;

    private ProfissaoDTO profissao;

    private EnderecoDTO endereco;

    private ContatoDTO contato;

}
