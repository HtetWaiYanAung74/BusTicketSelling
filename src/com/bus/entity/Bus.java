package com.bus.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bus
 *
 */
@Entity
@NamedQuery(name = "Bus.findById", query = "select b from Bus b where b.busId = :busId")
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;

	public Bus() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;

	private String busBrand;
	private Integer busModel;
	private String busNumber;
	private Integer busPrice;

	@Temporal(TemporalType.DATE)
	private Date busRegDate;

//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "busRoute_fk")
	private BusRoute busRoute;	
	
	@OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
	private List<Driver> drivers;
//	private Set<Driver> drivers = new HashSet<>();
	
	@ManyToMany(mappedBy = "buses", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
	private List<Passenger> passengers;

	public Bus(Integer busId, String busBrand, Integer busModel, String busNumber, Integer busPrice,
			Date busRegDate) {
		super();
		this.busId = busId;
		this.busBrand = busBrand;
		this.busModel = busModel;
		this.busNumber = busNumber;
		this.busPrice = busPrice;
		this.busRegDate = busRegDate;
	}

	public Bus(String busBrand, Integer busModel, String busNumber, Integer busPrice, Date busRegDate) {
		super();
		this.busBrand = busBrand;
		this.busModel = busModel;
		this.busNumber = busNumber;
		this.busPrice = busPrice;
		this.busRegDate = busRegDate;
	}
	
	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusBrand() {
		return busBrand;
	}

	public void setBusBrand(String busBrand) {
		this.busBrand = busBrand;
	}

	public Integer getBusModel() {
		return busModel;
	}

	public void setBusModel(Integer busModel) {
		this.busModel = busModel;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public Integer getBusPrice() {
		return busPrice;
	}

	public void setBusPrice(Integer busPrice) {
		this.busPrice = busPrice;
	}

	public Date getBusRegDate() {
		return busRegDate;
	}

	public void setBusRegDate(Date busRegDate) {
		this.busRegDate = busRegDate;
	}

}