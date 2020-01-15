package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@ToString(exclude = "imagens")
@Table(name = "exame")
public class Exame implements Serializable {

    private static final long serialVersionUID = 5861228389149653105L;

    public Exame(final Long id, final LocalDate data, final Paciente paciente, final CategoriaExame categoriaExame, final String observacao) {
        this.id = id;
        this.data = data;
        this.paciente = paciente;
        this.categoriaExame = categoriaExame;
        this.observacao = observacao;
    }

    @Id
    @SequenceGenerator(name = "exame_generator", sequenceName = "exame_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exame_generator")
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, updatable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_categoria_exame", nullable = false)
    private CategoriaExame categoriaExame;

    @OneToMany(mappedBy = "exame", cascade = CascadeType.ALL)
    private List<ImagemExame> imagens;

    @Column(length = 1000)
    private String observacao;

}