package com.ws.demo.ui.Exception;

public class UserServiceException extends RuntimeException {
	private static final long serialVersionUID = 6849201718772860021L;

	public UserServiceException(String message) {
		super(message);
	}

}
