package com.compensar.users.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.compensar.security.dto.ConsolidadoData;
import com.compensar.security.dto.Test;
import com.compensar.users.controller.UsersController;
import com.compensar.users.service.ExcelService;
import com.poiji.bind.Poiji;

@Service
public class ExcelServiceImpl implements ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(ExcelServiceImpl.class);

	@Override
	public List<ConsolidadoData> extractDataExcel(MultipartFile file) {

		List<ConsolidadoData> consolidadoReturn = new ArrayList<>();

		try {
			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);

			logger.debug("Convert mmultipart request to file {}", file.getOriginalFilename());

			File fileReturn = convert(file);
			consolidadoReturn = Poiji.fromExcel(fileReturn, ConsolidadoData.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Error: {}", e.getMessage());
		}

		logger.debug("Informacion del archivo {} extraido correctamente", file.getOriginalFilename());
		return consolidadoReturn;
	}

	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
