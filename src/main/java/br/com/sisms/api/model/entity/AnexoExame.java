package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "anexo_exame")
public class AnexoExame implements Serializable {

    private static final long serialVersionUID = 7553749037087545233L;

    @Id
    @SequenceGenerator(name = "anexo_exame_generator", sequenceName = "anexo_exame_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "anexo_exame_generator")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 10485760, nullable = false)
    private String anexo;

    @Column(length = 200)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_exame", nullable = false)
    private Exame exame;

}
