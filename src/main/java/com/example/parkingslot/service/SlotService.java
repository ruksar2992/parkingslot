package com.example.parkingslot.service;

import com.example.parkingslot.dto.RequestDto;
import com.example.parkingslot.dto.SlotRequestDto;

public interface SlotService {

	void slotUpdation(SlotRequestDto slotRequestDto);

	void slotRequest(RequestDto requestDto);
}
