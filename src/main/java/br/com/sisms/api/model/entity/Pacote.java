package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pacote")
public class Pacote implements Serializable {

    private static final long serialVersionUID = 6917071329193127800L;

    @Id
    @SequenceGenerator(name = "pacote_generator", sequenceName = "pacote_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacote_generator")
    private Long id;

    @Column(name = "data_criacao", columnDefinition = "date default current_date", nullable = false, insertable = false, updatable = false)
    private LocalDate dataCriacao;

    @Column(length = 8, precision = 8, scale = 2, nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria_atendimento", nullable = false)
    private CategoriaAtendimento categoriaAtendimento;

    @Column(nullable = false)
    private Long numero;

    @Column(name = "quantidade_sessao")
    private Long quantidadeSessao;

    @Column(nullable = false, columnDefinition = "boolean default true", insertable = false)
    private Boolean aberto;

    @Formula("(select count(*) from atendimento as a where a.id_pacote = id)")
    private Long quantidadeAtendimentos;

    @Formula("(select sum(l.valor) from lancamento as l where l.id_pacote = id)")
    private BigDecimal totalPago;

    @Formula("(select pa.data " +
            "from atendimento as a " +
            "inner join pre_atendimento as pa on pa.id = a.id_pre_atendimento " +
            "where a.id_pacote = id " +
            "order by pa.data asc " +
            "limit 1)")
    private LocalDateTime dataInicio;

}