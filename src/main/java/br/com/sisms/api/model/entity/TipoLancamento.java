package br.com.sisms.api.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tipo_lancamento")
public class TipoLancamento implements Serializable {

    private static final long serialVersionUID = 6108763905978914564L;

    @Id
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String descricao;

}
