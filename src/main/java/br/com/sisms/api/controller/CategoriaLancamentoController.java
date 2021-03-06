package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.CategoriaLancamentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.CategoriaLancamentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Categoria de Lançamento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/categoriaLancamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaLancamentoController {

    private final CategoriaLancamentoService service;

    @ApiOperation(value = "Retorna uma categoria de lançamento por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<CategoriaLancamentoDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de categorias de lançamento por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<Page<CategoriaLancamentoDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Inclui uma categoria de lançamento.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<CategoriaLancamentoDTO>> create(@Valid @RequestBody final CategoriaLancamentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Altera uma categoria de lançamento.")
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<CategoriaLancamentoDTO>> update(@PathVariable final Long id, @Valid @RequestBody final CategoriaLancamentoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todas categorias de lançamento.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<List<CategoriaLancamentoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

}
