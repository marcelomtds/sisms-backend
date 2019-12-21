package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@ToString(exclude = "preAtendimentoOutrasMedidas")
@Table(name = "pre_atendimento")
public class PreAtendimento implements Serializable {

    private static final long serialVersionUID = -8875279670555144428L;

    @Id
    @SequenceGenerator(name = "pre_atendimento_generator", sequenceName = "pre_atendimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pre_atendimento_generator")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(name = "pressao_arterial", length = 7)
    private String pressaoArterial;

    @Column(columnDefinition = "numeric(4,1) default 0.0", length = 4, precision = 4, scale = 1)
    private BigDecimal peso;

    @Column(name = "supra_umbilical", columnDefinition = "numeric(4,1) default 0.0", length = 4, precision = 4, scale = 1)
    private BigDecimal supraUmbilical;

    @Column(name = "linha_umbilical", columnDefinition = "numeric(4,1) default 0.0", length = 4, precision = 4, scale = 1)
    private BigDecimal linhaUmbilical;

    @Column(name = "infra_umbilical", columnDefinition = "numeric(4,1) default 0.0", length = 4, precision = 4, scale = 1)
    private BigDecimal infraUmbilical;

    @Column(length = 1000)
    private String observacao;

    @OneToMany(mappedBy = "preAtendimento", cascade = CascadeType.ALL)
    private List<PreAtendimentoOutraMedida> preAtendimentoOutrasMedidas;

}
