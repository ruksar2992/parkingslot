package com.example.parkingslot.dao;
import org.springframework.data.repository.CrudRepository;

import com.example.parkingslot.model.Employee;


public interface LoginDao  extends CrudRepository<Employee, Integer> {

	 /**
     * This method is used to authenticate Employee
     * 
     * @param EmployeeName
     * @param password
     * @return
     */
    public Employee findByEmployeeNameAndPassword(String employeeName, String password);
}

