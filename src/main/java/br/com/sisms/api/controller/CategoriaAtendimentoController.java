package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.CategoriaAtendimentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.CategoriaAtendimentoService;
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

@Api(tags = "Categoria de Atendimento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/categoriaAtendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoriaAtendimentoController {

    private final CategoriaAtendimentoService service;

    @ApiOperation(value = "Retorna uma lista com todas categorias de atendimento.")
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMINISTRADOR', 'USUARIO')")
    public ResponseEntity<Response<List<CategoriaAtendimentoDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG00028.toString()));
    }

}
