package com.example.parkingslot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.dto.SlotResponeDto;
import com.example.parkingslot.service.SlotMappingService;

@RestController
public class SlotMapperController {
	private static Log logger = LogFactory.getLog(SlotController.class);

	@Autowired
	SlotMappingService slotMappingService;
	
	@GetMapping("/employee/{requestSlotId}/releaseslot")
	public ResponseEntity<SlotResponeDto> getSlotDetails(@PathVariable("requestSlotId") int requestSlotId ) {
		logger.info("executing the slotUpdationDetails  Method");
		
		SlotResponeDto slotResponeDto=slotMappingService.getSlotNumber(requestSlotId);
		return new ResponseEntity<SlotResponeDto>(slotResponeDto,HttpStatus.OK);
	}
}
