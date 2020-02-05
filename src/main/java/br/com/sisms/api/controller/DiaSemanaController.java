package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.DiaSemanaDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.DiaSemanaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Dias da Semana")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/diaSemana", produces = MediaType.APPLICATION_JSON_VALUE)
public class DiaSemanaController {

    private final DiaSemanaService service;

    @ApiOperation(value = "Retorna uma lista com todos os dias da semana.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString())")
    public ResponseEntity<Response<List<DiaSemanaDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

}
