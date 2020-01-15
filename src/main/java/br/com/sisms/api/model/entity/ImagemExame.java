package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "imagem_exame")
public class ImagemExame implements Serializable {

    private static final long serialVersionUID = 7553749037087545233L;

    @Id
    @SequenceGenerator(name = "imagem_exame_generator", sequenceName = "imagem_exame_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagem_exame_generator")
    private Long id;

    @Column(length = 10485760)
    private String imagem;

    @Column(length = 200)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_exame")
    private Exame exame;

}
