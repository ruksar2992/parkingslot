package com.example.parkingslot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingslot.dto.RequestDto;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.service.SlotService;

@RestController
public class SlotController {

	private static Log logger = LogFactory.getLog(SlotController.class);

	@Autowired
	SlotService slotService;

	/**
	 * This method is used to register the user
	 * 
	 * @param slotRequestDto
	 * @return String
	 */
	@PostMapping("/employee/releaseslot")
	public String releaseslotUpdation(@RequestBody SlotRequestDto slotRequestDto) {
		logger.info("executing the slotUpdationDetails  Method");
		slotService.slotUpdation(slotRequestDto);
		return "Slot release request got successfull";
	}
	
	
	@PostMapping("/employee/requestslot")
	public String requestSlotDetails(@RequestBody RequestDto requestDto) {
		logger.info("executing the slotUpdationDetails  Method");
		slotService.slotRequest(requestDto);
		return "Slot  request got successfull";
	}

}
