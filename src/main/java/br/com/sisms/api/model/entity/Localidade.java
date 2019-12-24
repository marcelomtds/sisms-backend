package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "localidade")
public class Localidade implements Serializable {

    private static final long serialVersionUID = -3680767186163016478L;

    @Id
    @SequenceGenerator(name = "localidade_generator", sequenceName = "localidade_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localidade_generator")
    private Long id;

    @Column(length = 100, nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_uf", nullable = false)
    private UF uf;

}
