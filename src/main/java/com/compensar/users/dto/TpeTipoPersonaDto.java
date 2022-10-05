package com.compensar.users.dto;

public class TpeTipoPersonaDto {

	private Long tpe_id;

	private String tpe_nombretipo;

	public TpeTipoPersonaDto() {
		super();
	}

	public TpeTipoPersonaDto(Long tpe_id, String tpe_nombretipo) {
		super();
		this.tpe_id = tpe_id;
		this.tpe_nombretipo = tpe_nombretipo;
	}

	public Long getTpe_id() {
		return tpe_id;
	}

	public void setTpe_id(Long tpe_id) {
		this.tpe_id = tpe_id;
	}

	public String getTpe_nombretipo() {
		return tpe_nombretipo;
	}

	public void setTpe_nombretipo(String tpe_nombretipo) {
		this.tpe_nombretipo = tpe_nombretipo;
	}

	@Override
	public String toString() {
		return "TpeTipoPersonaDto [tpe_id=" + tpe_id + ", tpe_nombretipo=" + tpe_nombretipo + "]";
	}

}
