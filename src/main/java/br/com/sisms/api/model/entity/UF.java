package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "uf")
public class UF implements Serializable {

    private static final long serialVersionUID = 3360573701016546383L;

    @Id
    @SequenceGenerator(name = "uf_generator", sequenceName = "uf_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uf_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}
