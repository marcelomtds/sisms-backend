package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "pre_atendimento_outra_medida")
public class PreAtendimentoOutraMedida implements Serializable {

    private static final long serialVersionUID = -3158270782944021010L;

    @Id
    @SequenceGenerator(name = "pre_atendimento_outra_medida_generator", sequenceName = "pre_atendimento_outra_medida_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_atendimento_outra_medida_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pre_atendimento", nullable = false)
    private PreAtendimento preAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_outra_medida", nullable = false)
    private OutraMedida outraMedida;

    @Column(length = 4, precision = 4, scale = 1)
    private BigDecimal valor;

}
