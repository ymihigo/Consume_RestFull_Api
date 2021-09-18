package com.mihigo.main.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.context.annotation.Scope;

@Entity
@Scope("singleton")
public class Users{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String namez;
	@Email(message = "Invalid email")
	@NotNull(message = "can't not be null")
	@Column(unique = true)
	private String email;
	@NotNull(message = "can't not be null")
	private String username;
	@NotNull(message = "can't not be null")
	private String password;
	
	
	public Users() {
		super();
	}


	public Users(long id, @NotNull String namez,
			@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email,
			@NotNull(message = "can't not be null") String username,
			@NotNull(message = "can't not be null") String password) {
		super();
		this.id = id;
		this.namez = namez;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	

	public Users(@NotNull String namez,
			@Email(message = "Invalid email") @NotNull(message = "can't not be null") String email,
			@NotNull(message = "can't not be null") String username,
			@NotNull(message = "can't not be null") String password) {
		super();
		this.namez = namez;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNamez() {
		return namez;
	}


	public void setNamez(String namez) {
		this.namez = namez;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", namez=" + namez + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
	
}
