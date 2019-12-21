package br.com.sisms.api.security.service;

import br.com.sisms.api.security.jwt.JwtUserFactory;
import br.com.sisms.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(final String cpf) throws UsernameNotFoundException {
        return JwtUserFactory.create(usuarioService.findByCpf(cpf));
    }

}
