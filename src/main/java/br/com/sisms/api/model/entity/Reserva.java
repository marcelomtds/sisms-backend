package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

    private static final long serialVersionUID = 8017110809591592017L;

    @Id
    @SequenceGenerator(name = "reserva_generator", sequenceName = "reserva_generator_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_generator")
    private Long id;

    @Column(name = "paciente_nome_completo", length = 200, nullable = false)
    private String pacienteNomeCompleto;

    @Column(length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_categoria_atendimento")
    private CategoriaAtendimento categoriaAtendimento;

    @ManyToOne
    @JoinColumn(name = "id_periodo")
    private Periodo periodo;

    @Column
    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "id_dia_semana")
    private DiaSemana diaSemana;

    @Column(length = 1000)
    private String observacao;

}
