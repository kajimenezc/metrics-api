package com.compensar.users.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tpe_tipopersona")
public class TpeTipoPersona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tpe_id")
	private Long tpe_id;

	@Column(name = "tpe_nombretipo")
	private String tpe_nombretipo;

	public TpeTipoPersona() {
		super();
	}

	public TpeTipoPersona(Long tpe_id, String tpe_nombretipo) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TpeTipoPersona [tpe_id=" + tpe_id + ", tpe_nombretipo=" + tpe_nombretipo + "]";
	}

}
