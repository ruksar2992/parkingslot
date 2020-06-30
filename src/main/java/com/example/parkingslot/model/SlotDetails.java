package com.example.parkingslot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SlotDetails {
	@Id

	private int slotId;
	private int slotNumber;
	private int employeeId;

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
