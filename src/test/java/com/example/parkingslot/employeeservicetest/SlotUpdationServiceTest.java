package com.example.parkingslot.employeeservicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.parkingslot.dao.SlotDao;
import com.example.parkingslot.dao.SlotRequestDao;
import com.example.parkingslot.dto.RequestDto;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.model.SlotRequest;
import com.example.parkingslot.model.SlotUpdation;
import com.example.parkingslot.serviceImpl.SlotServiceImpl;

@ExtendWith(MockitoExtension.class)

public class SlotUpdationServiceTest {
	SlotUpdation slotUpdation;

	@Mock
	SlotDao slotDao;

	@InjectMocks
	SlotServiceImpl slotServiceImpl;

	SlotRequestDto slotRequestDto;

	RequestDto requestDto;

	SlotRequest slotRequest;
	@Mock
	SlotRequestDao slotRequestDao;

	@BeforeEach
	public void setUp() {

		slotRequestDto = new SlotRequestDto();
		slotRequestDto.setEmployeeId(1);
		slotRequestDto.setSlotNumber(101);
		slotRequestDto.setFromDate("2020-06-27");
		slotRequestDto.setToDate("2020-06-28");

		requestDto = new RequestDto();
		requestDto.setDate("2020-06-28");
		requestDto.setEmployeeId(1);
	}

	@Test
	public void slotUpdationDetails() {
		// given
		when(slotDao.save(any(SlotUpdation.class))).thenReturn(any(SlotUpdation.class));

		// when
		slotServiceImpl.slotUpdation(slotRequestDto);

		// then
		verify(slotDao).save(any(SlotUpdation.class));

	}

	@Test
	public void requestSlotDetails() {
		// given
		when(slotRequestDao.save(any(SlotRequest.class))).thenReturn(any(SlotRequest.class));

		// when
		slotServiceImpl.slotRequest(requestDto);

		// then
		verify(slotRequestDao).save(any(SlotRequest.class));

	}

}
