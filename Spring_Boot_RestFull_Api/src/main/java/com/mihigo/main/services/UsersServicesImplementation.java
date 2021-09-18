package com.mihigo.main.services;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mihigo.main.Exception.CustomException;
import com.mihigo.main.model.Users;
import com.mihigo.main.repository.UsersRepositories;


@Service
public class UsersServicesImplementation implements UsersServicesInterface {

	@Autowired
	private UsersRepositories repo;

	
	@Override
	public Users createNewUser(@NotNull String namez,
			@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email,
			@NotNull(message = "can't not be null") String username,
			@NotNull(message = "can't not be null") String password){
			try {
			Users u=repo.save(new Users(namez, email, username, password));
			return u;
			}catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}

	@Override
	public Users searchById(long id) throws CustomException {
		Users u=repo.findById(id).orElseThrow(()->new CustomException("invalid id"));
		return u;
	}

	
	@Override
	public Users getUsersByEmail(
			@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email){
		try {
			Users u=repo.findByEmail(email);
			return u;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public boolean deleteUsers(long id) {
		try {
			repo.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Users updateUsers(Users users) {
		try {
			Users us=repo.getById(users.getId());
			us.setId(us.getId());
			us.setEmail(users.getEmail());
			us.setNamez(users.getNamez());
			us.setPassword(users.getPassword());
			us.setUsername(users.getUsername());
			Users user=repo.save(us);
			return user;
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public List<Users> getAllUsers() {
		return repo.findAll();
	}

}
