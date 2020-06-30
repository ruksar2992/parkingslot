package com.example.parkingslot.service;

import com.example.parkingslot.exception.InvalidCredentialsException;

public interface EmployeeService {

	public boolean authenticateEmployee(String employeeName, String password) throws InvalidCredentialsException;

}
