package br.com.sisms.api.controller;

import br.com.sisms.api.model.dto.MenuDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Menu")
@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/menu")
public class MenuController {

    private final MenuService service;

    @ApiOperation(value = "Retorna o menu com base no perfil do usuário logado.")
    @GetMapping
    @PreAuthorize("hasAnyRole(T(br.com.sisms.api.model.enums.RoleEnum).ADMINISTRADOR.toString(), T(br.com.sisms.api.model.enums.RoleEnum).USUARIO.toString())")
    public ResponseEntity<Response<List<MenuDTO>>> findAll() {
        return ResponseEntity.ok().body(new Response(service.findAll(), MessageEnum.MSG0028.toString()));
    }

}
