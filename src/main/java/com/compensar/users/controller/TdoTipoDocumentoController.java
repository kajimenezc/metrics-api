package com.compensar.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compensar.users.dto.TdoTipoDocumentoDto;
import com.compensar.users.service.TdoTipoDocumentoService;

@RestController
@RequestMapping("typedocument")
public class TdoTipoDocumentoController {

	@Autowired
	private TdoTipoDocumentoService tipoDocService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<TdoTipoDocumentoDto> getAllPersons() {

		return tipoDocService.getAllTipoDocumento();
	}

	
}
