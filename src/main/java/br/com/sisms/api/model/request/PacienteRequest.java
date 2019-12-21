package br.com.sisms.api.model.request;

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
public class PacienteRequest implements Serializable {

    private static final long serialVersionUID = -3751776682440466199L;

    private Long id;

    @NotBlank(message = "{nome.completo.vazio}")
    @Size(max = 200, message = "{nome.completo.tamanho}")
    private String nomeCompleto;

    @NotNull(message = "{data.nascimento.vazio}")
    private LocalDate dataNascimento;

    @Size(max = 15, message = "{rg.tamanho}")
    private String rg;

    @Size(max = 11, message = "{cpf.tamanho.maximo}")
    private String cpf;

    @NotNull(message = "{sexo.vazio}")
    private Long sexoId;

    private Long profissaoId;

    private Long enderecoId;

    @NotBlank(message = "{cep.vazio}")
    @Size(max = 10, message = "{cep.tamanho}")
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

    private Long contatoId;

    @Size(max = 20, message = "{celular.tamanho}")
    private String contatoCelular;

    @Size(max = 20, message = "{celular.recado.tamanho}")
    private String contatoCelularRecado;

    @Size(max = 20, message = "{residencial.tamanho}")
    private String contatoResidencial;

    @Size(max = 20, message = "{comercial.tamanho}")
    private String contatoComercial;

    @Email(message = "{email.invalido}")
    @Size(max = 100, message = "{email.tamanho}")
    private String contatoEmail;
}
