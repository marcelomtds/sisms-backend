package br.com.sisms.api.model.dto;

import br.com.sisms.api.validation.constraint.PressaoArterial;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AtendimentoDTO implements Serializable {

    private static final long serialVersionUID = -1911202911872889431L;

    private Long id;

    private Long pacoteId;

    private Long pacoteNumero;

    private Long usuarioId;

    private String usuarioNomeCompleto;

    @NotNull(message = "{paciente.vazio}")
    private Long pacienteId;

    private String pacienteNomeCompleto;

    private Long preAtendimentoId;

    @NotNull(message = "{pre.atendimento.data.vazio}")
    private LocalDateTime preAtendimentoData;

    @PressaoArterial(message = "{pre.atendimento.pressao.arterial.formato}")
    @Size(max = 7, message = "{pre.atendimento.pressao.arterial.tamanho}")
    private String preAtendimentoPressaoArterial;

    @DecimalMax(value = "999.9", message = "{pre.atendimento.peso.tamanho}")
    private BigDecimal preAtendimentoPeso;

    @DecimalMax(value = "999.9", message = "{pre.atendimento.supra.umbilical.tamanho}")
    private BigDecimal preAtendimentoSupraUmbilical;

    @DecimalMax(value = "999.9", message = "{pre.atendimento.linha.umbilical.tamanho}")
    private BigDecimal preAtendimentoLinhaUmbilical;

    @DecimalMax(value = "999.9", message = "{pre.atendimento.infra.umbilical.tamanho}")
    private BigDecimal preAtendimentoInfraUmbilical;

    @Size(max = 1000, message = "{pre.atendimento.observacao.tamanho}")
    private String preAtendimentoObservacao;

    @Valid
    @Size(max = 10, message = "{outra.medida.tamanho}")
    private List<PreAtendimentoOutraMedidaDTO> preAtendimentoOutrasMedidas;

    private Long posAtendimentoId;

    private LocalDateTime posAtendimentoData;

    @PressaoArterial(message = "{pos.atendimento.pressao.arterial.formato}")
    @Size(max = 7, message = "{pos.atendimento.pressao.arterial.tamanho}")
    private String posAtendimentoPressaoArterial;

    @DecimalMax(value = "999.9", message = "{pos.atendimento.peso.tamanho}")
    private BigDecimal posAtendimentoPeso;

    @DecimalMax(value = "999.9", message = "{pos.atendimento.supra.umbilical.tamanho}")
    private BigDecimal posAtendimentoSupraUmbilical;

    @DecimalMax(value = "999.9", message = "{pos.atendimento.linha.umbilical.tamanho}")
    private BigDecimal posAtendimentoLinhaUmbilical;

    @DecimalMax(value = "999.9", message = "{pos.atendimento.infra.umbilical.tamanho}")
    private BigDecimal posAtendimentoInfraUmbilical;

    @Size(max = 1000, message = "{pos.atendimento.observacao.tamanho}")
    private String posAtendimentoObservacao;

    @Valid
    @Size(max = 10, message = "{outra.medida.tamanho}")
    private List<PosAtendimentoOutraMedidaDTO> posAtendimentoOutrasMedidas;

    @NotNull(message = "{categoria.atendimento.vazio}")
    private Long categoriaAtendimentoId;

    private String categoriaAtendimentoDescricao;

    private Long tipoAtendimentoId;

    private String tipoAtendimentoDescricao;

    @Valid
    @Size(max = 10, message = "{imagem.quantidade}")
    private List<ImagemAtendimentoDTO> imagens;

    private Long numero;

    @NotNull(message = "{atendimento.aberto.vazio}")
    private Boolean aberto;

    @Size(max = 1000, message = "{atendimento.conduta.tamanho}")
    private String conduta;

}
