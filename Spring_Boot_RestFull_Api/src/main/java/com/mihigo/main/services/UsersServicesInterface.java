package com.mihigo.main.services;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.mihigo.main.Exception.CustomException;
import com.mihigo.main.model.Users;

public interface UsersServicesInterface {
	
	Users createNewUser(@NotNull String namez,
			@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email,
			@NotNull(message = "can't not be null") String username,
			@NotNull(message = "can't not be null") String password);
	
	Users searchById(long id) throws CustomException;
	
	Users getUsersByEmail(@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email);
	
	boolean deleteUsers(long id);
	
	Users updateUsers(Users users);
	
	List<Users> getAllUsers();
	
}
