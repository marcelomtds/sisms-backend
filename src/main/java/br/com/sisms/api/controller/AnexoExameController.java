package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.AnexoExameDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.AnexoExameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Anexo do Exame")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/anexoExame", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnexoExameController {

    private final AnexoExameService service;

    @ApiOperation(value = "Retorna uma lista de anexos do exame pelo id do exame.")
    @GetMapping("/findByExame/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<AnexoExameDTO>>> findByExame(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByExameId(id), MessageEnum.MSG0028.toString()));
    }

}
