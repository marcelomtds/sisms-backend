package br.com.sisms.api.filter;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
public class PageableFilter<T> {

    @Valid
    private T filter;

    private Integer currentPage = 0;
    private Integer pageSize = 10;
    private String orderBy = "id";
    private String direction = "ASC";

}
