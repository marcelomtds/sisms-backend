package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 8017110809591592017L;

    @Id
    @SequenceGenerator(name = "reserva_generator", sequenceName = "reserva_generator_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_generator")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_paciente", nullable = false, updatable = false, unique = true)
    private Paciente paciente;

    @Column(length = 1000)
    private String observacao;

}
