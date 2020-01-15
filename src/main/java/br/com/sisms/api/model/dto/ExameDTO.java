package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ExameDTO implements Serializable {

    private static final long serialVersionUID = 1290440817001016897L;

    private Long id;

    private LocalDate data;

    private Long pacienteId;

    private String pacienteNomeCompleto;

    private Long categoriaExameId;

    private String categoriaExameDescricao;

    @Valid
    private List<ImagemExameDTO> imagens;

    @Size(max = 1000, message = "{exame.observacao}")
    private String observacao;

}
