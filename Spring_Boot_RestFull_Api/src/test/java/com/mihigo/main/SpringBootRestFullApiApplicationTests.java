package com.mihigo.main;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.standard.expression.Each;

import com.mihigo.main.model.Users;
import com.mihigo.main.services.UsersServicesInterface;

@SpringBootTest
class SpringBootRestFullApiApplicationTests {

	@Autowired
	private UsersServicesInterface serv;
	
	//@Test
	void contextLoads() {
	}
	
//	@Test
	public void newUsers() {
		Users u=serv.createNewUser("mihigo", "ymihigo@gmail.com", "mihigo", "daline");
		System.out.println(u.getId());
	}
	
//	@Test
	public void findAll() {
		System.out.println("hello");
		serv.getAllUsers().forEach((x)->{
			
			System.out.println(x.getId());
		});
	}
	


}
