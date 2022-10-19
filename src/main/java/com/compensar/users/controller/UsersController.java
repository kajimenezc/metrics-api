package com.compensar.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compensar.users.service.ExcelService;

@RestController
@RequestMapping("publico/users")
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);


	@Autowired
	private ExcelService serviceExcel;
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String helloWorld() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		logger.info("{}", auth.toString());
		
		return "Hello World";
	}
	
	@GetMapping("/info")
	public String info() {
		
		return serviceExcel.infoReturn();
	}
	
}
