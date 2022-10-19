package com.compensar.users.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.compensar.security.dto.ConsolidadoData;

public interface ExcelService {

	List<ConsolidadoData> extractDataExcel(MultipartFile file);
	
}
