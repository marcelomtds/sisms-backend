package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.ImagemAtendimentoDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.ImagemAtendimentoService;
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

@Api(tags = "Imagem do Atendimento")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/imagemAtendimento", produces = MediaType.APPLICATION_JSON_VALUE)
public class ImagemAtendimentoController {

    private final ImagemAtendimentoService service;

    @ApiOperation(value = "Retorna uma lista de imagens do atendimento pelo id do atendimento.")
    @GetMapping("/findByAtendimento/{id}")
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<ImagemAtendimentoDTO>>> findByAtendimento(@PathVariable final Long id) {
        return ResponseEntity.ok().body(new Response(service.findByAtendimento(id), MessageEnum.MSG0028.toString()));
    }

}
