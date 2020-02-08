package com.rest.web.services.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.web.services.dao.User;
import com.rest.web.services.exception.UserNotFoundException;
import com.rest.web.services.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return service.allUsers();
	}
	
	@GetMapping("/find/{id}")
	public User getOne(@PathVariable int id)
	{
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("filt", filter);
		User user = service.findOne(id);
		if(user == null) {
			 throw new UserNotFoundException("id -"+ id);
		}
		// hateoas
		
//		EntityModel<User> model = new EntityModel<User>(user);
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAll());
//		model.add(linkTo.withRel("all-users"));
		
		
		return user;
	}
	
	@PostMapping("/save")
	public void save(@Valid @RequestBody User user) {
		service.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id)
	{
		service.delete(id);
		
		
	}

}
