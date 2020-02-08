package com.rest.web.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.web.services.dao.HelloworldBean;

@RestController
public class RestServiceController {
	
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "hello world";
	}
	
	@GetMapping("/helloworldbean/{name}")
	public HelloworldBean hello(@PathVariable String name) {
		return new HelloworldBean(name);
		
	}

}
