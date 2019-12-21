package br.com.sisms.api.model.request;

import br.com.sisms.api.model.dto.ImagemAtendimentoDTO;
import br.com.sisms.api.model.dto.PosAtendimentoOutraMedidaDTO;
import br.com.sisms.api.model.dto.PreAtendimentoOutraMedidaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PacoteRequest implements Serializable {

    private static final long serialVersionUID = 7109781189487183967L;

    private Long id;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    @NotNull(message = "{categoria.atendimento.vazio}")
    private Long categoriaAtendimentoId;

    @NotNull(message = "{valor.vazio}")
    @DecimalMin(value = "0.0", inclusive = false, message = "{valor.tamanho}")
    @DecimalMax(value = "999999.99", message = "{valor.tamanho}")
    private BigDecimal valor;

}
