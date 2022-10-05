package com.compensar.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tdo_tipodocumento")
public class TdoTipoDocumento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tdo_id")
	private Long tdo_id;

	@Column(name = "tdo_tipodocumento")
	private String tdo_tipodocumento;

	public TdoTipoDocumento() {
		super();
	}

	public TdoTipoDocumento(Long tdo_id, String tdo_tipodocumento) {
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
		return "TdoTipoDocumento [tdo_id=" + tdo_id + ", tdo_tipodocumento=" + tdo_tipodocumento + "]";
	}

}
