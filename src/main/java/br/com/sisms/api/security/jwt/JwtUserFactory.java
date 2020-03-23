package br.com.sisms.api.security.jwt;

import br.com.sisms.api.model.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private JwtUserFactory() {

    }

    public static JwtUser create(final Usuario usuario) {
        return new JwtUser(usuario.getId(), usuario.getCpf(), usuario.getSenha(),
                mapToGranteAuthorities(usuario.getPerfil().getRole()));
    }

    private static List<GrantedAuthority> mapToGranteAuthorities(final String role) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

}
