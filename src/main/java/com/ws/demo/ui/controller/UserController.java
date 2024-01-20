package com.ws.demo.ui.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.demo.ui.Exception.UserServiceException;
import com.ws.demo.ui.request.EmployeeDetails;
import com.ws.demo.ui.request.UpdateEmployeeDetails;
import com.ws.demo.ui.userService.UserService;
import com.ws.demo.ui.userService.Impl.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users") // http:8080/users
public class UserController {
	Map<String, EmployeeDetails> emp;
	@Autowired
    UserService userService;
//	@GetMapping
//	public String getUsers(@RequestParam(value = "page", defaultValue = "23", required = false) int page,
//			@RequestParam(value = "limit", defaultValue = "25") int limit,
//			@RequestParam(value = "sort", required = false, defaultValue = "desc") String sort) {
//		return "Get user was called with page=" + page + " and limit=" + limit + " and sort=" + sort;
//	}

	/*
	 * @GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<EmployeeRest>
	 * getUsers(@PathVariable String userId) { EmployeeRest empDetails = new
	 * EmployeeRest(); empDetails.setName("Charan"); empDetails.setAge(28);
	 * empDetails.setDesignation("Java Developer"); return new
	 * ResponseEntity<>(empDetails, HttpStatus.BAD_REQUEST); }
	 */

	@GetMapping(path = "/{empId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })																													// data
	public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable String empId) {
		if (emp.containsKey(empId)) {
			return new ResponseEntity<EmployeeDetails>(emp.get(empId), HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeDetails>(HttpStatus.NO_CONTENT);
		}

	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeDetails> createUsers(@Valid @RequestBody EmployeeDetails empDetail) {
		EmployeeDetails empdet=new UserServiceImpl().createUser(empDetail);
		return new ResponseEntity<>(empdet, HttpStatus.ACCEPTED);
	}

	@PutMapping(path = "/{empId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<EmployeeDetails> updateUsers(@PathVariable String empId, @RequestBody UpdateEmployeeDetails updEmpdet) {
		EmployeeDetails storedEmpdet = emp.get(empId);
		if(storedEmpdet!=null) {
			storedEmpdet.setFirstName(updEmpdet.getFirstName());
			storedEmpdet.setLastName(updEmpdet.getLastName());
			emp.put(empId, storedEmpdet);
			return new ResponseEntity<EmployeeDetails>(storedEmpdet,HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<EmployeeDetails>(HttpStatus.NO_CONTENT);
		}
		
		//return storedEmpdet;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUsers(@PathVariable String id) {
		if (emp.containsKey(id)) {
			emp.remove(id);
		}else {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.noContent().build();
	}
	@GetMapping
	public void exceptionCheck() {
		if(true) {
			throw new UserServiceException("User Service exception is thrown");
		}
		String data=null;
		int stlen=data.length();
	}

}
