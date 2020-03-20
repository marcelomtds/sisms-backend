package br.com.sisms.api.model.dto;

import br.com.sisms.api.validation.constraint.*;
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
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = -523926860249742312L;

    private Long id;

    @Senha(message = "{senha.tamanho}")
    private String senha;

    @Senha(message = "{senha.confirmacao.tamanho}")
    private String senhaConfirmacao;

    @NotBlank(message = "{nome.completo.vazio}")
    @Size(max = 200, message = "{nome.completo.tamanho}")
    private String nomeCompleto;

    @NotNull(message = "{data.nascimento.vazio}")
    private LocalDate dataNascimento;

    private LocalDate dataCadastro;

    @Size(max = 15, message = "{rg.tamanho}")
    private String rg;

    @CPF(message = "{cpf.invalido}")
    @NotBlank(message = "{cpf.vazio}")
    private String cpf;

    private Boolean ativo;

    @Size(max = 10485760, message = "{imagem.tamanho}")
    private String imagem;

    @NotNull(message = "{sexo.vazio}")
    private Long sexoId;

    private String sexoDescricao;

    @NotNull(message = "{profissao.vazio}")
    private Long profissaoId;

    private String profissaoDescricao;

    private Long perfilId;

    private String perfilDescricao;

    private String perfilRole;

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

    @Celular(message = "{celular.invalido}")
    private String contatoCelular;

    @Celular(message = "{celular.recado.invalido}")
    private String contatoCelularRecado;

    @Fixo(message = "{residencial.invalido}")
    private String contatoResidencial;

    @Fixo(message = "{comercial.invalido}")
    private String contatoComercial;

    @Email(message = "{email.invalido}")
    @Size(max = 100, message = "{email.tamanho}")
    private String contatoEmail;

    private Boolean cadastroCompleto;

}
