package com.example.parkingslot.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslot.dao.SlotRequestDao;
import com.example.parkingslot.dto.SlotResponeDto;
import com.example.parkingslot.model.SlotRequest;
import com.example.parkingslot.service.SlotMappingService;

@Service
public class SlotMappingServiceImpl implements SlotMappingService {

	@Autowired
	SlotRequestDao slotRequestDao;

	@Override
	public SlotResponeDto getSlotNumber(int requestSlotId) {

		SlotRequest slotRequest=slotRequestDao.findDateByRequestSlotId(requestSlotId);
		
		
		
		return null;
	}

}
