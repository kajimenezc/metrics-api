package com.compensar.security.dto;

public class UserValidate {

	String username;

	String rol;

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserValidate(String username, String rol) {
		super();
		this.username = username;
		this.rol = rol;
	}

}
