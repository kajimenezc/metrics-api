package com.compensar.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.compensar.security.dto.UserValidate;

@Service
public class UsuarioDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		  Simulacion de tabla
		List<UserValidate> listUsuarios = new ArrayList<>();

		listUsuarios.add(new UserValidate("kevin", "test1", "USER"));
		listUsuarios.add(new UserValidate("edwin", "test2", "ADMIN"));

//		Map<String, String> usuarios = Map.of("kevin", "USER", "edwin", "ADMIN");
//		String rol = usuarios.get(username);

		String rol = "none";

		for (int i = 0; i < listUsuarios.size(); i++) {

			UserValidate user = listUsuarios.get(i);

			if (user.getUsername().equals(username)) {
				rol = user.getRol();
				break;
			}

		}

		if (rol != null) {
			User.UserBuilder userBuilder = User.withUsername(username);
			// "secreto" => [BCrypt] =>
			// $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq

			String passEncripted = "$2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq";

			userBuilder.password(passEncripted).roles(rol);
			return userBuilder.build();
		} else {
			throw new UsernameNotFoundException(username);
		}

	}
}
