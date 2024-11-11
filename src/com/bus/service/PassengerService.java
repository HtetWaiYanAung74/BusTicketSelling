package com.bus.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bus.entity.Bus;
import com.bus.entity.Passenger;

/**
 * Session Bean implementation class PassengerService
 */
@Stateless
@LocalBean
public class PassengerService {

    /**
     * Default constructor. 
     */
    public PassengerService() {
        
    }
    
    @PersistenceContext(unitName = "BusTicketSelling")
    private EntityManager em;
    
    public void savePassenger(Passenger passenger) {
    	em.persist(passenger);
    }
    
    public List<Passenger> findAll() {
    	
    	TypedQuery<Passenger> dQuery = em.createQuery("select p from Passenger p", Passenger.class);
    	List<Passenger> passengerList = dQuery.getResultList();
		return passengerList;
    	
    }
    
    public Passenger findOne(Integer passengerId) {
    	
    	return em.find(Passenger.class, passengerId);
    	
    }
    
    public void assignPassengerToBus(Integer passengerId, Integer busId) {
    	
    	Passenger passenger = em.find(Passenger.class, passengerId);
    	Bus bus = em.find(Bus.class, busId);
    	
    	//ManyToMany connect
    	passenger.getBuses().add(bus);
    	
    	em.persist(passenger);
    	
    }

}
