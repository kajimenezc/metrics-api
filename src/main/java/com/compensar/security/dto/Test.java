package com.compensar.security.dto;

import com.poiji.annotation.ExcelCellName;

public class Test {
	@ExcelCellName("campo1")
	private String campo1;

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	@Override
	public String toString() {
		return "Test [campo1=" + campo1 + "]";
	}

}
