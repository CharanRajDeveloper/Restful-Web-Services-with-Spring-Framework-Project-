package com.ws.demo.ui.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandling {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> getExceptionDetailsMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		Map<String, String> map = new HashMap<String, String>();
		exception.getBindingResult().getAllErrors().forEach(erd -> {
			String errorkey = ((FieldError) erd).getField();
			String errorMsg = erd.getDefaultMessage();
			map.put(errorkey, errorMsg);
		});
		return map;

	}
}
