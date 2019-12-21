package br.com.sisms.api.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = -6326499940653661288L;

    @Id
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

    @Column(length = 100, nullable = false, unique = true)
    private String role;

}
