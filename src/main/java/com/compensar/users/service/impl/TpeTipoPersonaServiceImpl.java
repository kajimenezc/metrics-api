package com.compensar.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compensar.users.dto.TpeTipoPersonaDto;
import com.compensar.users.model.TpeTipoPersona;
import com.compensar.users.repository.TpeTipoPersonaDao;
import com.compensar.users.service.TdeTipoPersonaService;

@Service
public class TpeTipoPersonaServiceImpl implements TdeTipoPersonaService {

	@Autowired
	private TpeTipoPersonaDao tipoPersonaDao;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TpeTipoPersonaDto> getAllTipoPersonas() {
		List<TpeTipoPersonaDto> listTipoPersonaDto = new ArrayList<>();

		try {
			Iterable<TpeTipoPersona> tipoPersona = tipoPersonaDao.findAll();

			for (TpeTipoPersona tdoTipoPersona : tipoPersona) {

				TpeTipoPersonaDto tipoDocDto = modelMapper.map(tdoTipoPersona, TpeTipoPersonaDto.class);

				listTipoPersonaDto.add(tipoDocDto);
			}

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
		}

		return listTipoPersonaDto;
	}

}
