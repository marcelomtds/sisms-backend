package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.ReservaDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.PageableFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.ReservaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Reserva")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/reserva")
public class ReservaController {

    private final ReservaService service;

    @ApiOperation(value = "Inclui uma reserva.")
    @PostMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<ReservaDTO>> create(@Valid @RequestBody final ReservaDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(null, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Exclui uma reserva.")
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.ok().body(new Response(MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Altera uma reserva.")
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<ReservaDTO>>> update(@PathVariable final Long id, @Valid @RequestBody final ReservaDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createOrUpdate(id, dto), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma lista paginada de reservas por filtros.")
    @PostMapping(path = "/findByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<Page<ReservaDTO>>> findByFilter(@RequestBody final PageableFilter pageableFilter) {
        return ResponseEntity.ok().body(new Response(service.findByFilter(pageableFilter), MessageEnum.MSG0028.toString()));
    }

    @ApiOperation(value = "Retorna uma reserva por id.")
    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<ReservaDTO>> findById(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findById(id), MessageEnum.MSG0028.toString()));
    }

}
