package com.cognixia.jump;

import com.cognixia.jump.model.*;
import com.cognixia.jump.model.User.Role;
import com.cognixia.jump.repo.UserRepository;
import com.cognixia.jump.service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringPurchaseTest {
	@Autowired
	private UserService service;

	@MockBean
	private UserRepository Cusrepo;
	
	@MockBean
	private AuthenticationRequest authenticaterequest; 
	
	@MockBean
	private AuthenticationResponse authenticationresponce;
	
	@MockBean
	private AuthenticationManager authenticationManager;
	
	
	@Test
	public void addUserTest() {
		User TestUser= new User(500,"TestUser","TestPassword",Role.ROLE_ADMIN ,true,"Test@email");
		assertEquals("TestUser",service.saveUser(TestUser).getUsername());
		}
	
	
}