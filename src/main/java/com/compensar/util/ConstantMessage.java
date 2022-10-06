package com.compensar.util;

import org.springframework.stereotype.Component;

@Component
public class ConstantMessage {

	public final String generalError = "Error Presentado en la solicitud";
	public final String nullReturn = " ";
	public final String notFoundUser = "Usuario no encontrado";
	public final String foundUser = "Ya existe un usuario con el id ";
	public final String userCrUpSucces = "Usuario procesado con exito";
	
}
