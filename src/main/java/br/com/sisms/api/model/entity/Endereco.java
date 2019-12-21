package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = -3130545473081095601L;

    @Id
    @SequenceGenerator(name = "endereco_generator", sequenceName = "endereco_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_generator")
    private Long id;

    @Column(length = 8, nullable = false)
    private String cep;

    @Column(length = 200, nullable = false)
    private String logradouro;

    @Column(length = 10, nullable = false)
    private String numero;

    @Column(length = 200)
    private String complemento;

    @Column(length = 100, nullable = false)
    private String bairro;

    @Column(name = "ponto_referencia", length = 200)
    private String pontoReferencia;

    @ManyToOne
    @JoinColumn(name = "id_localidade", nullable = false)
    private Localidade localidade;


}
