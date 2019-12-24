package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.TipoLancamentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.TipoLancamentoService;
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

@Api(tags = "Tipo de Lançamento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/tipoLancamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoLancamentoController {

    private final TipoLancamentoService service;

    @ApiOperation(value = "Retorna uma lista com todos tipos de lançamentos.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<TipoLancamentoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.SUCESSO.toString()));
    }

}
