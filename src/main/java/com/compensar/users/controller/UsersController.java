package com.compensar.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String helloWorld() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		logger.info("{}", auth.toString());
		
		return "Hello World";
	}
	
}
