package com.jman.form_management_project.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<MyResponse> handleAccessDenied(AccessDeniedException a)
	{
		MyResponse res= new MyResponse();
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		res.setMessage(a.getMessage());
		
		return ResponseEntity.status(res.getStatus()).body(res);
		
	}

}
