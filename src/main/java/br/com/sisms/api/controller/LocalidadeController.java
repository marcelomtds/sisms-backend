package br.com.sisms.api.controller;

import br.com.sisms.api.filter.PageableFilter;
import br.com.sisms.api.model.dto.LocalidadeDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.LocalidadeService;
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

@Api(tags = "Localidade")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/localidade", produces = MediaType.APPLICATION_JSON_VALUE)
public class LocalidadeController {

    private final LocalidadeService service;

    @ApiOperation(value = "Retorna uma lista paginada de localidades por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Page<LocalidadeDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Inclui uma localidade.")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<LocalidadeDTO>> create(@Valid @RequestBody final LocalidadeDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Altera uma localidade.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<LocalidadeDTO>> update(@PathVariable final Long id, @Valid @RequestBody final LocalidadeDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todas localidades.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<LocalidadeDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.SUCESSO.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todas localidades por UF.")
    @GetMapping(path = "/findByUfId/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<LocalidadeDTO>>> findByUfId(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByUfId(id), MessageEnum.SUCESSO.toString()));
    }

}