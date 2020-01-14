package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "categoria_exame")
public class CategoriaExame implements Serializable {

    private static final long serialVersionUID = -6016764432028864038L;

    @Id
    @SequenceGenerator(name = "categoria_exame_generator", sequenceName = "categoria_exame_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_exame_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}
