package com.ws.demo.ui.userService.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ws.demo.ui.request.EmployeeDetails;
import com.ws.demo.ui.shared.Utils;
import com.ws.demo.ui.userService.UserService;

@Service
public class UserServiceImpl implements UserService {
	Map<String, EmployeeDetails> emp;
	
	Utils utils;

	public UserServiceImpl() {
	}

	@Autowired
	public UserServiceImpl(Map<String, EmployeeDetails> emp, Utils utils) {
		this.emp = emp;
		this.utils = utils;
	}

	@Override
	public EmployeeDetails createUser(EmployeeDetails empDetail) {
		EmployeeDetails empdet = new EmployeeDetails();
		empdet.setFirstName(empDetail.getFirstName());
		empdet.setLastName(empDetail.getLastName());
		empdet.setEmail(empDetail.getEmail());
		empdet.setPassWord(empDetail.getPassWord());
		String empId = new Utils().generateEmpID();
		empdet.setEmpId(empId);
		if (emp == null) {
			emp = new HashMap<>();
		}
		emp.put(empId, empdet);
		return empdet;
	}

}
