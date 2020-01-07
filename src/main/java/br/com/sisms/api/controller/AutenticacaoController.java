package br.com.sisms.api.controller;

import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.security.jwt.AutenticacaoDTO;
import br.com.sisms.api.security.model.CurrentAuthenticationDTO;
import br.com.sisms.api.service.AutenticacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "Autenticação")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutenticacaoController {

    private final AutenticacaoService service;

    @ApiOperation(value = "Realiza login no sistema.")
    @PostMapping
    public ResponseEntity<Response<CurrentAuthenticationDTO>> createAuthenticationToken(@RequestBody @Valid final AutenticacaoDTO dto) {
        return ResponseEntity.ok().body(new Response(service.createAuthenticationToken(dto), MessageEnum.MSG00028.toString()));
    }

}