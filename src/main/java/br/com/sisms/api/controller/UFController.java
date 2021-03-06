package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.UFDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.UFService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "UF")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/uf", produces = MediaType.APPLICATION_JSON_VALUE)
public class UFController {

    private final UFService service;

    @ApiOperation(value = "Retorna uma UF por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<UFDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de UFs por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<Page<UFDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Inclui uma UF.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response> create(@Valid @RequestBody final UFDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG0028.toString(), new ArrayList()));
    }

    @ApiOperation(value = "Altera uma UF.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<UFDTO>> update(@PathVariable final Long id, @Valid @RequestBody final UFDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG0028.toString(), new ArrayList()));
    }

    @ApiOperation(value = "Retorna uma lista com todas UFs.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<UFDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

}
