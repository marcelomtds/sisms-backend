package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.RelatorioSerieDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.model.filter.RelatorioAtendimentoPeriodoFilter;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.RelatorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Relatório")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/relatorio", produces = MediaType.APPLICATION_JSON_VALUE)
public class RelatorioController {

    private final RelatorioService service;

    @ApiOperation(value = "Retorna o relatório de quantidade de atendimento por filtros.")
    @PostMapping(path = "/reportServiceByFilter")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<RelatorioSerieDTO>>> reportServiceByFilter(@RequestBody @Valid final RelatorioAtendimentoPeriodoFilter filter) {
        return ResponseEntity.ok().body(new Response(service.reportServiceByFilter(filter), MessageEnum.MSG0028.toString()));
    }

}
