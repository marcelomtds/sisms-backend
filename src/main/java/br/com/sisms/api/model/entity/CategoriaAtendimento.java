package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "categoria_atendimento")
public class CategoriaAtendimento implements Serializable {

    private static final long serialVersionUID = 744952249875680445L;

    @Id
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String descricao;

}
