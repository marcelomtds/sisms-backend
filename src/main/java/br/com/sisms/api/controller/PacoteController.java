package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.PacoteDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PacoteFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.PacoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Pacote")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/pacote", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacoteController {

    private final PacoteService service;

    @ApiOperation(value = "Retorna uma lista paginada de pacotes por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<Page<PacoteDTO>>> findByFilter(@RequestBody final PageableFilter<PacoteFilter> pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Inclui um pacote.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacoteDTO>> create(@Valid @RequestBody final PacoteDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Altera um pacote.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacoteDTO>> update(@PathVariable final Long id, @Valid @RequestBody final PacoteDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Retorna um pacote por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacoteDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Encerra um pacote.")
    @GetMapping(path = "closePackage/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacoteDTO>> closePackage(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.closePackage(id), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Retorno o último pacote por filtros.")
    @GetMapping(path = "findLastOpen/{categoriaAtendimentoId}/{pacienteId}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacoteDTO>> findLast(@PathVariable final Long categoriaAtendimentoId, @PathVariable final Long pacienteId) {
        return ResponseEntity.ok().body(new Response(service.findLastOpen(categoriaAtendimentoId, pacienteId), MessageEnum.MSG00028.toString()));
    }

}
