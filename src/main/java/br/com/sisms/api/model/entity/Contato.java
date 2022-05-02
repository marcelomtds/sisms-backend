package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contato")
public class Contato implements Serializable {

    private static final long serialVersionUID = -1540390518815318409L;

    @Id
    @SequenceGenerator(name = "contato_generator", sequenceName = "contato_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contato_generator")
    private Long id;

    @Column(name = "telefone_1", length = 20)
    private String telefone1;

    @Column(name = "telefone_2", length = 20)
    private String telefone2;

    @Column(name = "telefone_3", length = 20)
    private String telefone3;

    @Column(name = "telefone_4", length = 20)
    private String telefone4;

    @Column(length = 100)
    private String email;

}
