package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.SenhaDTO;
import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PacienteUsuarioFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.UsuarioService;
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

@Api(tags = "Usuário")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    private final UsuarioService service;

    @ApiOperation(value = "Retorna um usuário por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<UsuarioDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByIdWithPermission(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de usuários por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<Page<UsuarioDTO>>> findByFilter(@RequestBody @Valid final PageableFilter<PacienteUsuarioFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Ativa/Inativa um usuário.")
    @PostMapping(path = "/activeOrInative/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<UsuarioDTO>> activeOrInative(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.activeOrInative(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Inclui um usuário.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<UsuarioDTO>> create(@Valid @RequestBody final UsuarioDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Altera um usuário.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<UsuarioDTO>> update(@PathVariable final Long id, @Valid @RequestBody final UsuarioDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Altera a senha do usuário.")
    @PutMapping(path = "/updatePassword")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<UsuarioDTO>> updatePassword(@Valid @RequestBody final SenhaDTO request) {
        return ResponseEntity.ok().body(new Response(service.updatePassword(request), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos usuários.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<List<UsuarioDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos usuários ativos.")
    @GetMapping(path = "/findAllActive")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<List<UsuarioDTO>>> findAllActive() {
        return ResponseEntity.ok().body(new Response(service.findAllActive(), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos usuários que fazem aniversário no mes atual.")
    @GetMapping(path = "/findAllBirthdaysMonth")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<UsuarioDTO>>> findAllBirthdaysMonth() {
        return ResponseEntity.ok().body(new Response(service.findAllBirthdaysMonth(), MessageEnum.MSG0028.toString()));
    }

}
