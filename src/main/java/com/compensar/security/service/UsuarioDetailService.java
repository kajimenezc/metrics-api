package com.compensar.security.service;

import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		  Simulacion de tabla

		Map<String, String> usuarios = Map.of("kevin", "USER", "edwin", "ADMIN");
		String rol = usuarios.get(username);
		if (rol != null) {
			User.UserBuilder userBuilder = User.withUsername(username);
			// "secreto" => [BCrypt] =>
			// $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
			String encryptedPassword = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";
			userBuilder.password(encryptedPassword).roles(rol);
			return userBuilder.build();
		} else {
			throw new UsernameNotFoundException(username);
		}

	}
}
