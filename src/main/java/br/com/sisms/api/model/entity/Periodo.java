package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

    private static final long serialVersionUID = -7183153796635629587L;

    @Id
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String descricao;
}