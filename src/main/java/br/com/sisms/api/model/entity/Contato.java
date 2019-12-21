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

    @Column(length = 20)
    private String celular;

    @Column(name = "celular_recado", length = 20)
    private String celularRecado;

    @Column(length = 20)
    private String residencial;

    @Column(length = 20)
    private String comercial;

    @Column(length = 100)
    private String email;

}
