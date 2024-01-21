package com.ws.demo.ui.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public Utils() {

	}

	public String generateEmpID() {

		return UUID.randomUUID().toString();
	}

}
