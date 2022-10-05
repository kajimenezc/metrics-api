package com.compensar.users.dto;

public class TdoTipoDocumentoDto {

	private Long tdo_id;

	private String tdo_tipodocumento;

	public TdoTipoDocumentoDto() {
		super();
	}

	public TdoTipoDocumentoDto(Long tdo_id, String tdo_tipodocumento) {
		super();
		this.tdo_id = tdo_id;
		this.tdo_tipodocumento = tdo_tipodocumento;
	}

	public Long getTdo_id() {
		return tdo_id;
	}

	public void setTdo_id(Long tdo_id) {
		this.tdo_id = tdo_id;
	}

	public String getTdo_tipodocumento() {
		return tdo_tipodocumento;
	}

	public void setTdo_tipodocumento(String tdo_tipodocumento) {
		this.tdo_tipodocumento = tdo_tipodocumento;
	}

	@Override
	public String toString() {
		return "TdoTipoDocumentoDto [tdo_id=" + tdo_id + ", tdo_tipodocumento=" + tdo_tipodocumento + "]";
	}

}
