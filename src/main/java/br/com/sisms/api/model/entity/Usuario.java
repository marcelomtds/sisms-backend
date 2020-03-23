package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -213376496595266089L;

    public Usuario(final Long id, final String nomeCompleto, final String cpf, final LocalDate dataNascimento, final Perfil perfil, final Sexo sexo, final Boolean ativo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.perfil = perfil;
        this.sexo = sexo;
        this.ativo = ativo;
    }

    public Usuario(final Long id, final String nomeCompleto, final String cpf, final LocalDate dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Id
    @SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_id_seq", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    private Long id;

    @Column(nullable = false, length = 10485760)
    private String senha;

    @Column(length = 200)
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_cadastro", columnDefinition = "date default current_date", nullable = false, insertable = false, updatable = false)
    private LocalDate dataCadastro;

    @Column(length = 15)
    private String rg;

    @Column(length = 11, nullable = false, updatable = false)
    private String cpf;

    @Column(columnDefinition = "boolean default true", nullable = false, insertable = false)
    private Boolean ativo;

    @Column(length = 10485760)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "id_sexo")
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_profissao")
    private Profissao profissao;

    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false, updatable = false)
    private Perfil perfil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato")
    private Contato contato;

    @Column(name = "cadastro_completo", columnDefinition = "boolean default false", nullable = false, insertable = false)
    private Boolean cadastroCompleto;

}
