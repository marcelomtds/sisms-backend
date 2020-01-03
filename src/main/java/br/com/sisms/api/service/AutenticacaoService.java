package br.com.sisms.api.service;

import br.com.sisms.api.exception.BusinessException;
import br.com.sisms.api.model.dto.UsuarioDTO;
import br.com.sisms.api.model.enums.MessageEnum;
import br.com.sisms.api.security.jwt.AutenticacaoDTO;
import br.com.sisms.api.security.jwt.JwtTokenUtil;
import br.com.sisms.api.security.model.CurrentAuthenticationDTO;
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
public class AutenticacaoService {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserDetailsService userDetailsService;

    private final UsuarioService usuarioService;

    public CurrentAuthenticationDTO createAuthenticationToken(final AutenticacaoDTO autenticacaoDTO) {
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(autenticacaoDTO.getCpf(), autenticacaoDTO.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(autenticacaoDTO.getCpf());
        final UsuarioDTO usuarioDTO = usuarioService.findByCpfAndAtivoIsTrue(autenticacaoDTO.getCpf());
        if (Objects.isNull(usuarioDTO)) {
            throw new BusinessException(MessageEnum.USUARIO_BLOQUEADO.toString());
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        usuarioDTO.setSenha(null);
        return new CurrentAuthenticationDTO(token, usuarioDTO);
    }

}
