package com.cognixia.jump.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException( ResourceNotFoundException ex, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(404).body(errorDetails);
		
	}


	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<?> usernameNotFoundException( UsernameNotFoundException ex, WebRequest request){

		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));

		return ResponseEntity.status(404).body(errorDetails);

	}

}
