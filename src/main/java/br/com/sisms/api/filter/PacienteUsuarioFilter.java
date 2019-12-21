package br.com.sisms.api.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteUsuarioFilter {

    private String nomeCompleto;
    private String cpf;
    private Boolean ativo;
    private Long sexoId;
    private Long LocalidadeId;
    private Long ufId;
    private String celular;
    private String celularRecado;
    private String residencial;
    private String comercial;

}
