package com.mihigo.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mihigo.main.Exception.CustomException;
import com.mihigo.main.Exception.NotFoundException;
import com.mihigo.main.model.Users;
import com.mihigo.main.repository.UsersRepositories;
import com.mihigo.main.services.UsersServicesInterface;

@RestController
@RequestMapping("/users/api/")
public class UserController {

	@Autowired
	private UsersServicesInterface userServ;
	
	@Autowired
	private UsersRepositories repo;
	
	@GetMapping("/AllUsers")
	public List<Users> getAllUser() {
		return userServ.getAllUsers();
	}
	
	@PostMapping("/createUser")
	public Users createUser(@Valid @RequestBody Users users){
		try {
			Users u=userServ.createNewUser(users.getNamez(), users.getEmail(), users.getUsername(), users.getPassword());
			return u;
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<Users> getUsersbyId(@PathVariable(value = "id") long id){
		try {
		Users u=userServ.searchById(id);
		return ResponseEntity.ok().body(u);
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@GetMapping("/getByEmail/{email}")
	public Users getByEmail(@PathVariable String email){
		return repo.findByEmail(email);
	}
}
