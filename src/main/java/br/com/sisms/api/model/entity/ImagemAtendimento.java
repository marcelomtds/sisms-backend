package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "imagem_atendimento")
public class ImagemAtendimento implements Serializable {

    private static final long serialVersionUID = 6759679049131067487L;

    @Id
    @SequenceGenerator(name = "imagem_atendimento_generator", sequenceName = "imagem_atendimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_atendimento_generator")
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 10485760, nullable = false)
    private String imagem;

    @Column(length = 200)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_atendimento", nullable = false)
    private Atendimento atendimento;

}
