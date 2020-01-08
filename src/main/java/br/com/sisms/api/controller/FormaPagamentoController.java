package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.FormaPagamentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.FormaPagamentoService;
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

@Api(tags = "Forma de Pagamento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/formaPagamento", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormaPagamentoController {

    private final FormaPagamentoService service;

    @ApiOperation(value = "Retorna uma lista com todas formas de pagamento.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<FormaPagamentoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG00028.toString()));
    }

}
