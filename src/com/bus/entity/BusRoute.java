package com.bus.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BusRoute
 *
 */
@Entity

public class BusRoute implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public BusRoute() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busRouteId;

	@Enumerated(EnumType.STRING)
	private Cities origin;

	@Enumerated(EnumType.STRING)
	private Cities destination;

	private Integer duration;

	private Double price;
	
	@OneToOne(mappedBy = "busRoute")
	private Bus bus;

	public BusRoute(Integer busRouteId, Cities origin, Cities destination, Integer duration, Double price) {
		super();
		this.busRouteId = busRouteId;
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.price = price;
	}

	public BusRoute(Cities origin, Cities destination, Integer duration, Double price) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.duration = duration;
		this.price = price;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(Integer busRouteId) {
		this.busRouteId = busRouteId;
	}

	public Cities getOrigin() {
		return origin;
	}

	public void setOrigin(Cities origin) {
		this.origin = origin;
	}

	public Cities getDestination() {
		return destination;
	}

	public void setDestination(Cities destination) {
		this.destination = destination;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}	
	  
}
