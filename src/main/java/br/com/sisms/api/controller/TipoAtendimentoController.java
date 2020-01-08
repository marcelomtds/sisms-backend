package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.TipoAtendimentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.TipoAtendimentoService;
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

@Api(tags = "Tipo de Atendimento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/tipoAtendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoAtendimentoController {

    private final TipoAtendimentoService service;

    @ApiOperation(value = "Retorna uma lista com todos tipos de atendimento.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<TipoAtendimentoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG00028.toString()));
    }

}
