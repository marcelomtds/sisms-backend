package br.com.sisms.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import br.com.sisms.api.model.dto.UsuarioDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.sisms.api.model.entity.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {

	}

	public static JwtUser create(UsuarioDTO dto) {
		return new JwtUser(dto.getId(), dto.getCpf(), dto.getSenha(),
				mapToGranteAuthorities(dto.getPerfilRole()));
	}

	private static List<GrantedAuthority> mapToGranteAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

}
