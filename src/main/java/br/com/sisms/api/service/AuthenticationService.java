package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.entity.Usuario;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.security.jwt.AuthenticationRequest;
import br.com.sisms.api.security.jwt.JwtTokenUtil;
import br.com.sisms.api.security.model.CurrentAuthentication;
import br.com.sisms.api.util.Util;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    private final UsuarioService usuarioService;

    public CurrentAuthentication createAuthenticationToken(final AuthenticationRequest request) {
        validateCpf(request.getCpf());
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getCpf(), request.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getCpf());
        final UsuarioDTO dto = usuarioService.findByCpfAndAtivoIsTrue(request.getCpf());
        if (Objects.isNull(dto)) {
            throw new BusinessException(MessageEnum.USUARIO_BLOQUEADO.toString());
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new CurrentAuthentication(token, dto);
    }

    private void validateCpf(final String cpf) {
        if (StringUtils.isNotBlank(cpf) && !Util.isValidCpf(cpf)) {
            throw new BusinessException(MessageEnum.CPF_INVALIDO.toString());
        }
    }

}
