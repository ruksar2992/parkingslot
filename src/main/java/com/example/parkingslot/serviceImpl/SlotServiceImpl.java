package com.example.parkingslot.serviceImpl;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslot.dao.SlotDao;
import com.example.parkingslot.dao.SlotRequestDao;
import com.example.parkingslot.dto.RequestDto;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.model.SlotRequest;
import com.example.parkingslot.model.SlotUpdation;
import com.example.parkingslot.service.SlotService;

@Service
public class SlotServiceImpl implements SlotService {

	private static Log logger = LogFactory.getLog(SlotServiceImpl.class);
	@Autowired
	SlotDao slotDao;
	
	@Autowired
	SlotRequestDao slotRequestDao;

	@Override
	public void slotUpdation(SlotRequestDto slotRequestDto) {
		logger.info("implementation of slotUpdation");
		SlotUpdation slotUpdation = new SlotUpdation();
		LocalDate date = LocalDate.parse(slotRequestDto.getFromDate());
		slotUpdation.setFromDate(date);
		LocalDate date1 = LocalDate.parse(slotRequestDto.getToDate());
		slotUpdation.setToDate(date1);
		slotUpdation.setEmployeeId(slotRequestDto.getEmployeeId());
		slotUpdation.setSlotNumber(slotRequestDto.getSlotNumber());

		slotDao.save(slotUpdation);

		
	}

	@Override
	public void slotRequest(RequestDto requestDto) {

		SlotRequest slotRequestDetails=new SlotRequest();
		LocalDate date2 = LocalDate.parse(requestDto.getDate());
		slotRequestDetails.setDate(date2);
		
		slotRequestDetails.setEmployeeId(requestDto.getEmployeeId());
		slotRequestDao.save(slotRequestDetails);
	}

	
}

