package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

    private static final long serialVersionUID = -5441856589572198722L;

    @Id
    @SequenceGenerator(name = "paciente_generator", sequenceName = "paciente_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_generator")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCompleto;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 15)
    private String rg;

    @Column(length = 11, unique = true)
    private String cpf;

    @Column(columnDefinition = "boolean default true", nullable = false, insertable = false)
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "id_sexo", nullable = false)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", nullable = false)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato", nullable = false)
    private Contato contato;

}