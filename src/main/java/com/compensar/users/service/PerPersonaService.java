package com.compensar.users.service;

import java.util.List;

import com.compensar.users.dto.PerPersonaDto;
import com.compensar.util.GeneralResponse;

public interface PerPersonaService {

	List<PerPersonaDto> getAllPersons();
	
	PerPersonaDto getPersonById(Integer personId);
	
	GeneralResponse createPerson(PerPersonaDto persona);
	
	GeneralResponse updatePerson(PerPersonaDto persona);
	
	GeneralResponse deletePerson(Integer personId);
	
}
