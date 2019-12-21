package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "outra_medida")
public class OutraMedida implements Serializable {

    private static final long serialVersionUID = 2348850935424074512L;

    @Id
    @SequenceGenerator(name = "outra_medida_generator", sequenceName = "outra_medida_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outra_medida_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}
