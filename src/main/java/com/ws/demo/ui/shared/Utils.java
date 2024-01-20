package com.ws.demo.ui.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {
   public String userId=UUID.randomUUID().toString();;
	
	public Utils() {
		
	}






	public String generateEmpID() {
		userId=UUID.randomUUID().toString();
		return userId;
	}

}
