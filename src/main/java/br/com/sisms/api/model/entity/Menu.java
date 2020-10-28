package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "menu")
@ToString(exclude = "submenus")
public class Menu implements Serializable {

    private static final long serialVersionUID = -966817955239755236L;

    @Id
    private Long id;

    @Column(length = 100, nullable = false)
    private String descricao;

    @Column(length = 100, nullable = false)
    private String icone;

    @Column(length = 100, nullable = false)
    private String rota;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu pai;

    @OneToMany(mappedBy = "pai")
    private List<Menu> submenus;

}