package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PreAtendimentoDTO implements Serializable {

    private static final long serialVersionUID = 4159381184765825859L;

    private Long id;

    private LocalDateTime data;

    private String pressaoArterial;

    private BigDecimal peso;

    private BigDecimal supraUmbilical;

    private BigDecimal linhaUmbilical;

    private BigDecimal infraUmbilical;

    private String observacao;

    private List<PreAtendimentoOutraMedidaDTO> preAtendimentoOutrasMedidas;

}
