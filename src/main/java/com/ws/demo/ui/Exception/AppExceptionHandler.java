package com.ws.demo.ui.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ws.demo.ui.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		String errorDescription=ex.getLocalizedMessage();
		if(errorDescription==null) {
			errorDescription=ex.toString();
		}
		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@ExceptionHandler(value = { NullPointerException.class,UserServiceException.class })
	public ResponseEntity<Object> handleSpecificException(Exception ex, WebRequest request) {
		String errorDescription=ex.getLocalizedMessage();
		if(errorDescription==null) {
			errorDescription=ex.toString();
		}
		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorDescription);
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
//	@ExceptionHandler(value = { UserServiceException.class })
//	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest request) {
//		String errorDescription=ex.getLocalizedMessage();
//		if(errorDescription==null) {
//			errorDescription=ex.toString();
//		}
//		ErrorMessage errorMessage=new ErrorMessage(new Date(),errorDescription);
//		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}


}
