package com.cognixia.jump.controller;

import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.AuthenticationRequest;
import com.cognixia.jump.model.AuthenticationResponse;
import com.cognixia.jump.util.JwtUtil;

// authentication manager -> validates/authenticates user credentials
@RestController
public class AuthenticationController {

    // authentication manager -> validates/authenticates user credentials
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;


    // Create the token at http://localhost:8080/authenticate
    // send the username & password and try to generate a token as a response
    @PostMapping("/authenticate")
    public ResponseEntity<?> createJwtToken(@RequestBody AuthenticationRequest request) throws Exception{

    	// try to catch the exception for bad credentials, just so we can set our own
		// message when this doesn't work
        try{
            // make sure we have a valid user by checking username and password
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e){
            // Provide our own message on why login did't work
            throw new Exception("Incorrect user or password");
        }

        // If no exception was thrown, user is valid
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        // generate the token for user
        final String jwt = jwtUtil.generateTokens(userDetails);

        // return the token
        return ResponseEntity.status(201).body(new AuthenticationResponse(jwt));
    }


}
