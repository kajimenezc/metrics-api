package com.compensar.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compensar.users.dto.PerPersonaDto;
import com.compensar.users.service.PerPersonaService;
import com.compensar.util.GeneralResponse;

@RestController
@RequestMapping("person")
public class PerPersonaController {

	@Autowired
	private PerPersonaService personaService;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<PerPersonaDto> getAllPersons() {

		return personaService.getAllPersons();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/obtener")
	public ResponseEntity<PerPersonaDto> getPersonById(@RequestParam Integer personId) {

		PerPersonaDto response = personaService.getPersonById(personId);

		return new ResponseEntity<PerPersonaDto>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public ResponseEntity<GeneralResponse> createPerson(@RequestBody PerPersonaDto person) {

		GeneralResponse response = personaService.createPerson(person);

		return new ResponseEntity<GeneralResponse>(response, response.getStatus());
	}
	

}
