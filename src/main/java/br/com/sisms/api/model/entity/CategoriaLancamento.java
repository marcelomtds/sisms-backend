package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "categoria_lancamento")
public class CategoriaLancamento implements Serializable {

    private static final long serialVersionUID = 5448463291239202957L;

    @Id
    @SequenceGenerator(name = "categoria_lancamento_generator", sequenceName = "categoria_lancamento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_lancamento_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}
