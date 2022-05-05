package br.com.sisms.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class RelatorioItemSerieDTO implements Serializable {

    private static final long serialVersionUID = 1658954397564977520L;

    private String name;

    private Long value;
}
