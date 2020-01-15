package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.OutraMedidaDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.OutraMedidaService;
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

@Api(tags = "Outra Medida")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/outraMedida", produces = MediaType.APPLICATION_JSON_VALUE)
public class OutraMedidaController {

    private final OutraMedidaService service;

    @ApiOperation(value = "Retorna uma outra medida por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<OutraMedidaDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de profissões por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<Page<OutraMedidaDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Inclui uma Outra Medida.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<OutraMedidaDTO>> create(@Valid @RequestBody final OutraMedidaDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Altera uma Outra Medida.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<OutraMedidaDTO>> update(@PathVariable final Long id, @Valid @RequestBody final OutraMedidaDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG00028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todas Outras Medidas.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<OutraMedidaDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG00028.toString()));
    }

}
