package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.PacienteDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PacienteUsuarioFilter;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.PacienteService;
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

@Api(tags = "Paciente")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/paciente", produces = MediaType.APPLICATION_JSON_VALUE)
public class PacienteController {

    private final PacienteService service;

    @ApiOperation(value = "Retorna uma lista paginada de pacientes por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<Page<PacienteDTO>>> findByFilter(@RequestBody @Valid final PageableFilter<PacienteUsuarioFilter> filter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(filter), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Inclui um paciente.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacienteDTO>> create(@Valid @RequestBody final PacienteDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Altera um paciente.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacienteDTO>> update(@PathVariable final Long id, @Valid @RequestBody final PacienteDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos pacientes ativos.")
    @GetMapping(path = "/findAllActive")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<PacienteDTO>>> findAllActive() {
        return ResponseEntity.ok().body(new Response(service.findAllActive(), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos pacientes.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<PacienteDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna um paciente por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacienteDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Ativa/Inativa um paciente.")
    @PostMapping(path = "/activeOrInative/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<PacienteDTO>> activeOrInative(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.activeOrInative(id), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista com todos pacientes que fazem aniversário no mes atual.")
    @GetMapping(path = "/findAllBirthdaysMonth")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<PacienteDTO>>> findAllBirthdaysMonth() {
        return ResponseEntity.ok().body(new Response(service.findAllBirthdaysMonth(), MessageEnum.MSG0028.toString()));
    }
}
