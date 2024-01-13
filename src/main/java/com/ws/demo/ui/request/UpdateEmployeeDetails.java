package com.ws.demo.ui.request;

import jakarta.validation.constraints.NotNull;

public class UpdateEmployeeDetails {
	@NotNull(message = "FirstName cannot be Null")
	private String firstName;
	@NotNull(message = "LastName cannot be Null")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
