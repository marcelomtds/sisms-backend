package br.com.sisms.api.controller;

import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.response.Response;
import br.com.sisms.api.security.jwt.AuthenticationRequest;
import br.com.sisms.api.security.jwt.JwtTokenUtil;
import br.com.sisms.api.security.model.CurrentAuthentication;
import br.com.sisms.api.service.AuthenticationService;
import br.com.sisms.api.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(tags = "Autenticação")
@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @ApiOperation(value = "Realiza login no sistema.")
    @PostMapping(value = "/api/auth")
    public ResponseEntity<Response<CurrentAuthentication>> createAuthenticationToken(@RequestBody @Valid final AuthenticationRequest request) {
        return ResponseEntity.ok().body(new Response(service.createAuthenticationToken(request), MessageEnum.SUCESSO.toString()));
    }

}