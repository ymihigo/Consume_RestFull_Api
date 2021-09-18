package com.mihigo.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mihigo.main.Exception.CustomException;
import com.mihigo.main.model.Users;

@Repository
public interface UsersRepositories extends JpaRepository<Users, Long> {
	
	@Query("select u from Users u where email =: email")
	Users findByEmail(String email);
}
