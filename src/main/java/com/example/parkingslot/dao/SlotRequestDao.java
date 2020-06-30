package com.example.parkingslot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingslot.model.SlotRequest;
@Repository
public interface SlotRequestDao extends CrudRepository<SlotRequest, Integer> {

	SlotRequest findDateByRequestSlotId(int requestSlotId);

	

}
