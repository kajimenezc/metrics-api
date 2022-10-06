package com.compensar.users.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compensar.users.dto.TdoTipoDocumentoDto;
import com.compensar.users.model.TdoTipoDocumento;
import com.compensar.users.repository.TdoTipoDocumentoDao;
import com.compensar.users.service.TdoTipoDocumentoService;

@Service
public class TdoTipoDocumentoServiceImpl implements TdoTipoDocumentoService {

	@Autowired
	private TdoTipoDocumentoDao tipoDocumentoDao;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<TdoTipoDocumentoDto> getAllTipoDocumento() {
		List<TdoTipoDocumentoDto> listTipoDocDto = new ArrayList<>();

		try {
			Iterable<TdoTipoDocumento> tipoDoc = tipoDocumentoDao.findAll();

			for (TdoTipoDocumento tdoTipoDoc : tipoDoc) {

				TdoTipoDocumentoDto tipoDocDto = modelMapper.map(tdoTipoDoc, TdoTipoDocumentoDto.class);

				listTipoDocDto.add(tipoDocDto);
			}

		} catch (Exception e) {
			System.out.println("Error generado: " + e.getMessage());
		}

		return listTipoDocDto;
	}

}
