package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "dia_semana")
public class DiaSemana implements Serializable {

    private static final long serialVersionUID = 5785860558210565061L;

    @Id
    private Long id;

    @Column(length = 15, nullable = false, unique = true)
    private String descricao;

}
