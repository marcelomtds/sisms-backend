package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "menu")
@ToString(exclude = "submenus")
public class Menu implements Serializable {

    private static final long serialVersionUID = -966817955239755236L;

    public Menu(final Long id, final String descricao, final String icone, final String rota) {
        this.id = id;
        this.descricao = descricao;
        this.icone = icone;
        this.rota = rota;
    }

    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(length = 100, nullable = false)
    private String icone;

    @Column(length = 100)
    private String rota;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu pai;

    @OneToMany
    private List<Menu> submenus;

}