package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
public class ReservaDTO implements Serializable {

    private static final long serialVersionUID = -3617289100806751421L;

    private Long id;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    private String pacienteNomeCompleto;

    @Size(max = 1000, message = "{exame.observacao}")
    private String observacao;

}
