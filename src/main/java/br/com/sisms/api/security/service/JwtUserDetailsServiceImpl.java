package br.com.sisms.api.security.service;

import br.com.sisms.api.security.jwt.JwtUserFactory;
import br.com.sisms.api.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(final String cpf) throws UsernameNotFoundException {
        return JwtUserFactory.create(usuarioService.findByCpf(cpf));
    }

}
