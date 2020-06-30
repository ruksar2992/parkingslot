package com.example.parkingslot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingslot.dto.LoginDto;
import com.example.parkingslot.exception.InvalidCredentialsException;
import com.example.parkingslot.service.EmployeeService;



@RestController
public class EmployeeController {

	private static Log logger = LogFactory.getLog(EmployeeController.class);
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * This method is used to authenticate the Employee
	 * 
	 * @param loginDto
	 * @return String
	 * @throws InvalidCredentialsException
	 */
	
	@PostMapping("/employee/login")
	public String authenticateUser(@RequestBody LoginDto loginDto) throws InvalidCredentialsException {
		logger.info("authenticating the employee");
		boolean isExists;
		isExists = employeeService.authenticateEmployee(loginDto.getEmployeeName(), loginDto.getPassword());
		if (isExists)
			return "logged in successfully";
		else {
			return "Credentials are incorrect";
		}
	}

}
