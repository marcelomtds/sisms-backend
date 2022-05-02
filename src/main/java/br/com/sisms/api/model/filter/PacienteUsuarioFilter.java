package br.com.sisms.api.model.filter;

import br.com.sisms.api.validation.constraint.CPF;
import br.com.sisms.api.validation.constraint.Telefone;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteUsuarioFilter {

    private String nomeCompleto;

    @CPF(message = "{cpf.invalido}")
    private String cpf;

    private Boolean ativo;

    private Long sexoId;

    private Long LocalidadeId;

    private Long ufId;

    @Telefone(message = "{celular.invalido}")
    private String telefone;
}
