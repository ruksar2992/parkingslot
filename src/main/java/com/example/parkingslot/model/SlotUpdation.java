package com.example.parkingslot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SlotUpdation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int slotUpdationId;
	private int slotNumber;
	private int employeeId;
	private LocalDate fromDate;
	private LocalDate toDate;

	public int getSlotUpdationId() {
		return slotUpdationId;
	}

	public void setSlotUpdationId(int slotUpdationId) {
		this.slotUpdationId = slotUpdationId;
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

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

}