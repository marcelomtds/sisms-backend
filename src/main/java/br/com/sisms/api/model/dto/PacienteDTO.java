package br.com.sisms.api.model.dto;

import br.com.sisms.api.validation.constraint.CEP;
import br.com.sisms.api.validation.constraint.CPF;
import br.com.sisms.api.validation.constraint.Telefone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PacienteDTO implements Serializable {

    private static final long serialVersionUID = -2618716820063723366L;

    private Long id;

    @NotBlank(message = "{nome.completo.vazio}")
    @Size(max = 200, message = "{nome.completo.tamanho}")
    private String nomeCompleto;

    @NotNull(message = "{data.nascimento.vazio}")
    private LocalDate dataNascimento;

    @Size(max = 15, message = "{rg.tamanho}")
    private String rg;

    @CPF(message = "{cpf.invalido}")
    private String cpf;

    private Boolean ativo;

    @NotNull(message = "{sexo.vazio}")
    private Long sexoId;

    private String sexoDescricao;

    private Long profissaoId;

    private String profissaoDescricao;

    private Long enderecoId;

    @CEP(message = "{cep.invalido}")
    @NotBlank(message = "{cep.vazio}")
    private String enderecoCep;

    @NotBlank(message = "{logradouro.vazio}")
    @Size(max = 200, message = "{logradouro.tamanho}")
    private String enderecoLogradouro;

    @NotBlank(message = "{numero.vazio}")
    @Size(max = 10, message = "{numero.tamanho}")
    private String enderecoNumero;

    @Size(max = 200, message = "{complemento.tamanho}")
    private String enderecoComplemento;

    @NotBlank(message = "{bairro.vazio}")
    @Size(max = 100, message = "{bairro.tamanho}")
    private String enderecoBairro;

    @Size(max = 200, message = "{ponto.referencia.tamanho}")
    private String enderecoPontoReferencia;

    @NotNull(message = "{localidade.vazio}")
    private Long enderecoLocalidadeId;

    private String enderecoLocalidadeDescricao;

    private Long enderecoLocalidadeUFId;

    private String enderecoLocalidadeUFDescricao;

    private Long contatoId;

    @Telefone(message = "{telefone.principal.invalido}")
    private String contatoTelefone1;

    @Telefone(message = "{telefone.2.invalido}")
    private String contatoTelefone2;

    @Telefone(message = "{telefone.3.invalido}")
    private String contatoTelefone3;

    @Telefone(message = "{telefone.4.invalido}")
    private String contatoTelefone4;

    @Email(message = "{email.invalido}")
    @Size(max = 100, message = "{email.tamanho}")
    private String contatoEmail;

}
