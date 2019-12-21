package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "profissao")
public class Profissao implements Serializable {

    private static final long serialVersionUID = 2000343063562193335L;

    @Id
    @SequenceGenerator(name = "profissao_generator", sequenceName = "profissao_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profissao_generator")
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}