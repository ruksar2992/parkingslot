
package com.example.parkingslot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingslot.model.SlotRequest;
import com.example.parkingslot.model.SlotUpdation;

@Repository
public interface SlotDao extends CrudRepository<SlotUpdation, Integer> {

	//void save(SlotRequest slotRequestDetails);

}
