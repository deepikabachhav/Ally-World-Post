package com.cg.demo.TestDemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue
	private Long id;
	private String reservationName;
	public Reservation(Long id, String reservationName) {
		super();
		this.id = id;
		reservationName = reservationName;
	}
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReservationName() {
		return reservationName;
	}
	public void setReservationName(String reservationName) {
		reservationName = reservationName;
	}
	
	
}
