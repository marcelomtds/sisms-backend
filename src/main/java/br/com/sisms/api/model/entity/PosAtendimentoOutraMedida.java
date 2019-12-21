package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "pos_atendimento_outra_medida")
public class PosAtendimentoOutraMedida implements Serializable {

    private static final long serialVersionUID = 7921130575394409004L;

    @Id
    @SequenceGenerator(name = "pos_atendimento_outra_medida_generator", sequenceName = "pos_atendimento_outra_medida_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pos_atendimento_outra_medida_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pos_atendimento", nullable = false)
    private PosAtendimento posAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_outra_medida", nullable = false)
    private OutraMedida outraMedida;

    @Column(length = 4, precision = 4, scale = 1)
    private BigDecimal valor;

}
