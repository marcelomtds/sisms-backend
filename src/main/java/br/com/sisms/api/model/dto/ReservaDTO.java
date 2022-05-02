package br.com.sisms.api.model.dto;

import br.com.sisms.api.validation.constraint.Telefone;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;

@Getter
@Setter
public class ReservaDTO implements Serializable {

    private static final long serialVersionUID = -3617289100806751421L;

    private Long id;

    @NotBlank(message = "{nome.completo.vazio}")
    @Size(max = 200, message = "{nome.completo.tamanho}")
    private String pacienteNomeCompleto;

    @Telefone(message = "{telefone.invalido}")
    private String telefone;

    private Long categoriaAtendimentoId;

    private String categoriaAtendimentoDescricao;

    private Long periodoId;

    private String periodoDescricao;

    private LocalTime horario;

    private Long diaSemanaId;

    private String diaSemanaDescricao;

    @Size(max = 1000, message = "{reserva.observacao}")
    private String observacao;
}