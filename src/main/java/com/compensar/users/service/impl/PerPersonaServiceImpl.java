package com.compensar.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compensar.users.dto.PerPersonaDto;
import com.compensar.users.model.PerPersona;
import com.compensar.users.repository.PerPersonaDao;
import com.compensar.users.service.PerPersonaService;

@Service
public class PerPersonaServiceImpl implements PerPersonaService {

	@Autowired
	private PerPersonaDao personaDao;

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

}
