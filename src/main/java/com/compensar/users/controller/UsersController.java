package com.compensar.users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String helloWorld() {
		
		return "Hello World";
	}
	
}
