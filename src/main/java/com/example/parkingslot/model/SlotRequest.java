package com.example.parkingslot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SlotRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestSlotId;
	private LocalDate date;
	private int employeeId;

	public int getRequestSlotId() {
		return requestSlotId;
	}

	public void setRequestSlotId(int requestSlotId) {
		this.requestSlotId = requestSlotId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
