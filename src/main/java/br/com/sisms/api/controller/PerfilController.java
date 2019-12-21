package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.PerfilDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.PerfilService;
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

@Api(tags = "Perfil")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/perfil", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerfilController {

    private final PerfilService service;

    @ApiOperation(value = "Retorna uma lista com todos perfis.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR')")
    public ResponseEntity<Response<List<PerfilDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.SUCESSO.toString()));
    }

}
