package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 4110062310530155946L;

    @Id
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String descricao;

}
