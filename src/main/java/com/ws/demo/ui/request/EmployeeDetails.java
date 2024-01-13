package com.ws.demo.ui.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeDetails {
	@NotNull(message = "FirstName cannot be Null")
	private String firstName;
	@NotNull(message = "LastName cannot be Null")
	private String lastName;
	private String empId;
	@Email
	private String email;
	@NotNull
	@Size(min = 2, max = 4, message = "minimum is 2 maximum is 4")
	private String passWord;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
