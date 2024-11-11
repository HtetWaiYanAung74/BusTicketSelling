package com.bus.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Driver
 *
 */
@Entity
@XmlRootElement
public class Driver implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Driver() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	private String driverName;
	private Integer driverAge;
	private String driverLicense;
	private String driverPhno;
	
	@ManyToOne
	@JoinColumn(name = "bus_fk")
	private Bus bus;

	public Driver(Integer driverId, String driverName, Integer driverAge, String driverLicense, String driverPhno) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverAge = driverAge;
		this.driverLicense = driverLicense;
		this.driverPhno = driverPhno;
	}

	public Driver(String driverName, Integer driverAge, String driverLicense, String driverPhno) {
		super();
		this.driverName = driverName;
		this.driverAge = driverAge;
		this.driverLicense = driverLicense;
		this.driverPhno = driverPhno;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Integer getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(Integer driverAge) {
		this.driverAge = driverAge;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getDriverPhno() {
		return driverPhno;
	}

	public void setDriverPhno(String driverPhno) {
		this.driverPhno = driverPhno;
	}
	   
}
