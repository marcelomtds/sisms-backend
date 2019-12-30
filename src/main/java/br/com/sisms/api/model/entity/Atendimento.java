package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "imagens")
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    private static final long serialVersionUID = -213944903903696401L;

    public Atendimento(final Long id, final BigDecimal totalPago, final Paciente paciente, final Usuario usuario, final Pacote pacote, final PreAtendimento preAtendimento, final PosAtendimento posAtendimento, final CategoriaAtendimento categoriaAtendimento, final TipoAtendimento tipoAtendimento, final Long numero, final Boolean aberto) {
        this.id = id;
        this.totalPago = totalPago;
        this.paciente = paciente;
        this.usuario = usuario;
        this.pacote = pacote;
        this.preAtendimento = preAtendimento;
        this.posAtendimento = posAtendimento;
        this.categoriaAtendimento = categoriaAtendimento;
        this.tipoAtendimento = tipoAtendimento;
        this.numero = numero;
        this.aberto = aberto;
    }

    @Id
    @SequenceGenerator(name = "atendimento_generator", sequenceName = "atendimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pacote")
    private Pacote pacote;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pre_atendimento", nullable = false)
    private PreAtendimento preAtendimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pos_atendimento")
    private PosAtendimento posAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_categoria_atendimento", nullable = false)
    private CategoriaAtendimento categoriaAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_atendimento", nullable = false)
    private TipoAtendimento tipoAtendimento;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<ImagemAtendimento> imagens;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false)
    private Boolean aberto;

    @Column(length = 1000)
    private String conduta;

    @Formula("(select sum(l.valor) from lancamento as l where l.id_atendimento = id)")
    private BigDecimal totalPago;

}