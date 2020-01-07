package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.ProfissaoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.ProfissaoService;
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

@Api(tags = "Profissão")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/profissao", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfissaoController {

    private final ProfissaoService service;

    @ApiOperation(value = "Retorna uma lista paginada de profissões por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<Page<ProfissaoDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Inclui uma profissão.")
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<ProfissaoDTO>> create(@Valid @RequestBody final ProfissaoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Altera uma profissão.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<ProfissaoDTO>> update(@PathVariable final Long id, @Valid @RequestBody final ProfissaoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todas profissões.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<ProfissaoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG00028.toString()));
    }

}

