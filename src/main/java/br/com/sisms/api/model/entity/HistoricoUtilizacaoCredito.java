package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "historico_utilizacao_credito")
public class HistoricoUtilizacaoCredito implements Serializable {

    private static final long serialVersionUID = -1168239789413108132L;

    @Id
    @SequenceGenerator(name = "historico_utilizacao_credito_generator", sequenceName = "historico_utilizacao_credito_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historico_utilizacao_credito_generator")
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(length = 8, precision = 8, scale = 2, nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_atendimento", updatable = false)
    private Atendimento atendimento;

    @ManyToOne
    @JoinColumn(name = "id_pacote", updatable = false)
    private Pacote pacote;

    @ManyToOne
    @JoinColumn(name = "id_lancamento", nullable = false, updatable = false)
    private Lancamento lancamento;

}