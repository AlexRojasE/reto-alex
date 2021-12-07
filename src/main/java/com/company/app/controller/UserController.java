package com.company.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.app.models.Response;
import com.company.app.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService service;
	
	@PostMapping("/listar")
	@ResponseStatus(value = HttpStatus.OK)
	public Response listar(){
		return service.listar();
	}
}
