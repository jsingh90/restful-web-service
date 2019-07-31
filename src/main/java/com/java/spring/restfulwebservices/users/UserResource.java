package com.java.spring.restfulwebservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.spring.restfulwebservices.users.exceptions.UserNotFoundException;

@RestController
public class UserResource {
	
	
	
	@Autowired
	private UserDaoService service;
	
	@GetMapping(path = "/users")
	public List<User> reteriveAllUsers() {
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findUserById(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("id - %d", id));
		}
		
		
//		EntityModel<User> model = new EntityModel<>(user);
//	    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).reteriveAllUsers());
//	    model.add(linkTo.withRel("all-users"));
	    
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteById(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("User not found - %d", id));
		}
		
	}
}
