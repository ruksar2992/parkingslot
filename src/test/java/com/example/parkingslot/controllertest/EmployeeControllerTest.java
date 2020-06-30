package com.example.parkingslot.controllertest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.parkingslot.controller.EmployeeController;
import com.example.parkingslot.dto.LoginDto;
import com.example.parkingslot.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	ObjectMapper objectMapper;

	@Mock
	EmployeeService employeeService;

	@InjectMocks
	EmployeeController employeeController;

	MockMvc mockMvc;

	

	LoginDto loginDto;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		loginDto = new LoginDto();
		loginDto.setPassword("saru");
		loginDto.setEmployeeName("saru");

	}


	@Test
	public void loginTest() throws Exception {
		// given
		when(employeeService.authenticateEmployee("saru", "saru")).thenReturn(true);

		// when and then
		mockMvc.perform(post("/employee/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("logged in successfully")));

		verify(employeeService).authenticateEmployee("saru", "saru");
	}

	@Test
	public void loginTest1() throws Exception {
		// given
		when(employeeService.authenticateEmployee("saru", "saru")).thenReturn(false);

		// when and then
		mockMvc.perform(post("/employee/login").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(objectMapper.writeValueAsString(loginDto))).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.is("Credentials are incorrect")));

		verify(employeeService).authenticateEmployee("saru", "saru");
	}

}
