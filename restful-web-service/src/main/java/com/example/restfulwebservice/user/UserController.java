package com.example.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserController {

	private UserDaoService service;
	
	public UserController(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	//GET // users/1 or users/10  -> String
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
		 throw new UserNotFoundEXception(String.format("ID[%s] not found",id));
		}
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> creatUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		//사용자에게 요청값을 변환해 주기위한 기능
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		//ResponseEntity 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundEXception(String.format("ID[%s] not found",id));
		}
	}
}
