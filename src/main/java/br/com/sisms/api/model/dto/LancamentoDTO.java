package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoDTO implements Serializable {

    private static final long serialVersionUID = 1399706395171864005L;

    private Long id;

    private LocalDate data;

    private BigDecimal valor;

    private String observacao;

    private UsuarioDTO usuarioDTO;

    private AtendimentoDTO atendimento;

    private PacoteDTO pacote;

    private CategoriaLancamentoDTO categoriaLancamento;

    private FormaPagamentoDTO formaPagamento;

    private TipoLancamentoDTO tipoLancamento;

}
