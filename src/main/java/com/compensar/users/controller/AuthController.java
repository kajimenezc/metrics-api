package com.compensar.users.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compensar.security.dto.AuthenticationReq;
import com.compensar.security.dto.TokenInfo;
import com.compensar.security.service.JwtUtilService;

@RestController
@RequestMapping("")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsService usuarioDetailsService;

	@Autowired
	private JwtUtilService jwtUtilService;

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@GetMapping("/admin")
	public ResponseEntity<?> getMensajeAdmin() {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("Datos del Usuario: {}", auth.getPrincipal());
		logger.info("Datos de los Permisos {}", auth.getAuthorities());
		logger.info("Esta autenticado {}", auth.isAuthenticated());

		Map<String, String> mensaje = new HashMap<>();
		mensaje.put("contenido", "Hola Admin");
		return ResponseEntity.ok(mensaje);
	}

	@GetMapping("/publico")
	public ResponseEntity<?> getMensajePublico() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("Datos del Usuario: {}", auth.getPrincipal());
		logger.info("Datos de los Permisos {}", auth.getAuthorities());
		logger.info("Esta autenticado {}", auth.isAuthenticated());

		Map<String, String> mensaje = new HashMap<>();
		mensaje.put("contenido", "Hola Public");
		return ResponseEntity.ok(mensaje);
	}

	@PostMapping("/publico/auth")
	public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
		logger.info("Autenticando al usuario {}", authenticationReq.getUsuario());

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(), authenticationReq.getClave()));

		final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(authenticationReq.getUsuario());

		final String jwt = jwtUtilService.generateToken(userDetails);

		TokenInfo tokenInfo = new TokenInfo(jwt);

		return ResponseEntity.ok(tokenInfo);
	}

}
