package com.example.parkingslot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslot.dao.LoginDao;
import com.example.parkingslot.exception.InvalidCredentialsException;
import com.example.parkingslot.model.Employee;
import com.example.parkingslot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	LoginDao employeeDao;
	
	/**
    *
    * This method is used to register Employee
    * @param employeeDto
    */
	@Override
	public boolean authenticateEmployee(String employeeName, String password) throws InvalidCredentialsException {
		
		Employee employee = employeeDao.findByEmployeeNameAndPassword(employeeName, password);
		if (employee != null)
			return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
		
	}

}
