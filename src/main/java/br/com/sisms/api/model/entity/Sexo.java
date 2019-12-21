package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sexo")
public class Sexo implements Serializable {

    private static final long serialVersionUID = 3548497349445783129L;

    @Id
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String descricao;

}
