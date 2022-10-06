package com.compensar.users.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.compensar.users.dto.PerPersonaDto;
import com.compensar.users.model.PerPersona;
import com.compensar.users.repository.PerPersonaDao;
import com.compensar.users.service.PerPersonaService;
import com.compensar.util.ConstantMessage;
import com.compensar.util.GeneralResponse;

@Service
public class PerPersonaServiceImpl implements PerPersonaService {

	@Autowired
	private PerPersonaDao personaDao;

	@Autowired
	private ConstantMessage constM;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<PerPersonaDto> getAllPersons() {

		List<PerPersonaDto> listPersonaDto = new ArrayList<>();

		try {
			Iterable<PerPersona> persona = personaDao.findAll();

			for (PerPersona perPersona : persona) {

				PerPersonaDto newperson = modelMapper.map(perPersona, PerPersonaDto.class);

				listPersonaDto.add(newperson);
			}

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
		}

		return listPersonaDto;
	}

	@Override
	public PerPersonaDto getPersonById(final Integer personId) {

		PerPersonaDto person = new PerPersonaDto();

		try {

			Long personIdLong = (long) personId;
			Optional<PerPersona> perPersona = personaDao.findById(personIdLong);

			person = modelMapper.map(perPersona, PerPersonaDto.class);

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
		}

		return person;
	}

	@Override
	public GeneralResponse createUpdatePerson(final PerPersonaDto persona, final Boolean isCreate) {

		GeneralResponse response = new GeneralResponse(new Date(), HttpStatus.CONFLICT, constM.generalError,
				constM.nullReturn);
		try {

			Optional<PerPersona> perPersona = personaDao.findById(persona.getPer_id());

			if (perPersona.isPresent()) {
				response.setMessage(constM.foundUser);
				return response;
			}

			if (!isCreate) {
				persona.setPer_id(perPersona.get().getPer_id());
			}

			PerPersona newperson = modelMapper.map(persona, PerPersona.class);

			personaDao.save(newperson);

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
			response.setMessage("Error generado: " + e.getMessage());
		}

		response.setStatus(HttpStatus.OK);
		response.setMessage(constM.userCrUpSucces);
		return response;
	}

	@Override
	public GeneralResponse deletePerson(Integer personId) {
		
		GeneralResponse response = new GeneralResponse(new Date(), HttpStatus.CONFLICT, constM.generalError,
				constM.nullReturn);

		try {
			
			Long personIdLong = (long) personId;
			
			Optional<PerPersona> perPersona = personaDao.findById(personIdLong);

			if (!perPersona.isPresent()) {
				response.setMessage(constM.notFoundUser);
				return response;
			}

			personaDao.deleteById(personIdLong);

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
		}
		
		response.setStatus(HttpStatus.OK);
		response.setMessage(constM.userCrUpSucces);
		return response;
	}

}
