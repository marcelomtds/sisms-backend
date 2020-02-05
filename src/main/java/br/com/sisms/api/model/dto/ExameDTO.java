package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ExameDTO implements Serializable {

    private static final long serialVersionUID = 1290440817001016897L;

    private Long id;

    @NotNull(message = "{lancamento.data.vazio}")
    private LocalDate data;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    private String pacienteNomeCompleto;

    @NotNull(message = "{categoria.exame.vazio}")
    private Long categoriaExameId;

    private String categoriaExameDescricao;

    @Valid
    private List<AnexoExameDTO> anexos;

    @Size(max = 1000, message = "{exame.observacao}")
    private String observacao;

}
