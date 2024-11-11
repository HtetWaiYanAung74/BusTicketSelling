package com.bus.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Passenger
 *
 */
@Entity

public class Passenger implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Passenger() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passengerId;
	
	private String passengerName;
	
	private String passengerNRC;
	
	private String passengerPhno;
	
	@Temporal(TemporalType.DATE)
	private Date passengerDueDate;
	
	@ManyToMany
	@JoinTable(name = "Passenger_Bus", joinColumns = @JoinColumn(name = "passenger_fk"), 
		inverseJoinColumns = @JoinColumn(name = "bus_fk"))
	private List<Bus> buses;

	public Passenger(Integer passengerId, String passengerName, String passengerNRC, String passengerPhno,
			Date passengerDueDate) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerNRC = passengerNRC;
		this.passengerPhno = passengerPhno;
		this.passengerDueDate = passengerDueDate;
	}

	public Passenger(String passengerName, String passengerNRC, String passengerPhno, Date passengerDueDate) {
		super();
		this.passengerName = passengerName;
		this.passengerNRC = passengerNRC;
		this.passengerPhno = passengerPhno;
		this.passengerDueDate = passengerDueDate;
	}
	
	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerNRC() {
		return passengerNRC;
	}

	public void setPassengerNRC(String passengerNRC) {
		this.passengerNRC = passengerNRC;
	}

	public String getPassengerPhno() {
		return passengerPhno;
	}

	public void setPassengerPhno(String passengerPhno) {
		this.passengerPhno = passengerPhno;
	}

	public Date getPassengerDueDate() {
		return passengerDueDate;
	}

	public void setPassengerDueDate(Date passengerDueDate) {
		this.passengerDueDate = passengerDueDate;
	}
	
}
