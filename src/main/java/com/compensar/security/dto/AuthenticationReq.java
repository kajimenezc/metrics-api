package com.compensar.security.dto;

import java.io.Serializable;

public class AuthenticationReq implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;

	private String clave;

	public AuthenticationReq(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "AuthenticationReq [usuario=" + usuario + ", clave=" + clave + "]";
	}

}
