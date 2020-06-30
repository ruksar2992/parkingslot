package com.example.parkingslot.employeeservicetest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.parkingslot.dao.LoginDao;
import com.example.parkingslot.dto.LoginDto;
import com.example.parkingslot.exception.InvalidCredentialsException;
import com.example.parkingslot.model.Employee;
import com.example.parkingslot.serviceImpl.EmployeeServiceImpl;


@ExtendWith(MockitoExtension.class)

public class EmployeeServiceImplTest {

	Employee employee;

	@Mock
	LoginDao loginDao;

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	LoginDto loginDto;

	@BeforeEach
	public void setUp() {

		loginDto = new LoginDto();
		loginDto.setEmployeeName("saru");
		loginDto.setPassword("saru");
		
	}

	

	@Test
	public void authenticateTest1() throws InvalidCredentialsException {
		// given
		Employee user = new Employee();
		user.setEmployeeName("saru");
		user.setPassword("saru");

		when(loginDao.findByEmployeeNameAndPassword("saru", "saru")).thenReturn(user);

		// when
		Boolean isExists = employeeServiceImpl.authenticateEmployee("saru", "saru");

		// then
		verify(loginDao).findByEmployeeNameAndPassword("saru", "saru");
		assertTrue(isExists);
	}

	@Test
	public void authenticateTest2() {
		// given
		Employee employee = new Employee();
		employee.setEmployeeName("saru");
		employee.setPassword("saru");

		when(loginDao.findByEmployeeNameAndPassword("saru", "saru")).thenReturn(null);

		// when

		// then
		assertThrows(InvalidCredentialsException.class, () -> employeeServiceImpl.authenticateEmployee("saru", "saru"));
	}

}
