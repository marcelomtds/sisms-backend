package br.com.sisms.api.model.filter;

import br.com.sisms.api.validation.constraint.CPF;
import br.com.sisms.api.validation.constraint.Celular;
import br.com.sisms.api.validation.constraint.Fixo;
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

    @Celular(message = "{celular.invalido}")
    private String celular;

    @Celular(message = "{celular.recado.invalido}")
    private String celularRecado;

    @Fixo(message = "{residencial.invalido}")
    private String residencial;

    @Fixo(message = "{comercial.invalido}")
    private String comercial;

}
