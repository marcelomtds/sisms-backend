package br.com.sisms.api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RelatorioSerieDTO implements Serializable {

    private static final long serialVersionUID = -5766997454951049271L;

    private String name;

    private List<RelatorioItemSerieDTO> series;
}
