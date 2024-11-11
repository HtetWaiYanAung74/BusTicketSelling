package com.bus.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bus.entity.Bus;
import com.bus.entity.Driver;

/**
 * Session Bean implementation class DriverService
 */
@Stateless
@LocalBean
public class DriverService {	

    /**
     * Default constructor. 
     */
    public DriverService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "BusTicketSelling")
    private EntityManager em;
    
    public Driver saveDriver(Driver driver) {
    	
    	em.persist(driver);
		return driver;
		
    }
    
    public List<Driver> findAll() {
    	
    	TypedQuery<Driver> dQuery = em.createQuery("select d from Driver d", Driver.class);
    	List<Driver> driverList = dQuery.getResultList();
		return driverList;
    	
    }
    
    public Driver findOne(Integer driverId) {
    	
    	return em.find(Driver.class, driverId);
    	    	
    }
    
    public void assignDriverToBus(Integer driverId, Integer busId) {
    	
    	Driver driver = em.find(Driver.class, driverId);
    	Bus bus = em.find(Bus.class, busId);
    	
    	//ManyToOne connect
    	driver.setBus(bus);
    	
    	em.persist(driver);
    	
    }

	public Driver update(Driver driver) {
		
		em.merge(driver);
		return driver;
	}

	public void remove(Integer driverId) {
		
		Driver driver = em.find(Driver.class, driverId);
		em.remove(driver);
		
	}

}
