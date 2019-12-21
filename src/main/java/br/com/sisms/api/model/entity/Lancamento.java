package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

    private static final long serialVersionUID = -679224689452095879L;

    @Id
    @SequenceGenerator(name = "lancamento_generator", sequenceName = "lancamento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lancamento_generator")
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(length = 8, precision = 8, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(length = 200)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_atendimento")
    private Atendimento atendimento;

    @ManyToOne
    @JoinColumn(name = "id_pacote")
    private Pacote pacote;

    @ManyToOne
    @JoinColumn(name = "id_categoria_lancamento")
    private CategoriaLancamento categoriaLancamento;

    @ManyToOne
    @JoinColumn(name = "id_forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_lancamento", nullable = false)
    private TipoLancamento tipoLancamento;

}