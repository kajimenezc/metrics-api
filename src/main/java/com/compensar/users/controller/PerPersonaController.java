package com.compensar.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compensar.users.dto.PerPersonaDto;
import com.compensar.users.service.PerPersonaService;

@RestController
@RequestMapping("person")
public class PerPersonaController {

	@Autowired
	private PerPersonaService personaService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<PerPersonaDto> getAllPersons() {

		return personaService.getAllPersons();
	}

}
