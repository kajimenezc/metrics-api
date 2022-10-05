package com.compensar.users.dto;

public class PerPersonaDto {

	private Long per_id;

	private String per_nombres;

	private String per_apellidos;

	private Long tdo_id;

	private String per_documento;

	private Long tpe_id;

	public PerPersonaDto() {
		super();
	}

	public PerPersonaDto(Long per_id, String per_nombres, String per_apellidos, Long tdo_id, String per_documento,
			Long tpe_id) {
		super();
		this.per_id = per_id;
		this.per_nombres = per_nombres;
		this.per_apellidos = per_apellidos;
		this.tdo_id = tdo_id;
		this.per_documento = per_documento;
		this.tpe_id = tpe_id;
	}

	public Long getPer_id() {
		return per_id;
	}

	public void setPer_id(Long per_id) {
		this.per_id = per_id;
	}

	public String getPer_nombres() {
		return per_nombres;
	}

	public void setPer_nombres(String per_nombres) {
		this.per_nombres = per_nombres;
	}

	public String getPer_apellidos() {
		return per_apellidos;
	}

	public void setPer_apellidos(String per_apellidos) {
		this.per_apellidos = per_apellidos;
	}

	public Long getTdo_id() {
		return tdo_id;
	}

	public void setTdo_id(Long tdo_id) {
		this.tdo_id = tdo_id;
	}

	public String getPer_documento() {
		return per_documento;
	}

	public void setPer_documento(String per_documento) {
		this.per_documento = per_documento;
	}

	public Long getTpe_id() {
		return tpe_id;
	}

	public void setTpe_id(Long tpe_id) {
		this.tpe_id = tpe_id;
	}

	@Override
	public String toString() {
		return "TdoTipoDocumentoDto [per_id=" + per_id + ", per_nombres=" + per_nombres + ", per_apellidos="
				+ per_apellidos + ", tdo_id=" + tdo_id + ", per_documento=" + per_documento + ", tpe_id=" + tpe_id
				+ "]";
	}

}
