package com.bus.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bus.entity.Bus;

/**
 * Session Bean implementation class BusService
 */
@Stateless
@LocalBean
public class BusService {

    /**
     * Default constructor. 
     */
    public BusService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "BusTicketSelling")
    private EntityManager em;
    
    public void saveBus(Bus bus) {
    	em.persist(bus);
    }
    
    public List<Bus> findAll() {
    	
    	TypedQuery<Bus> bQuery = em.createQuery("select b from Bus b", Bus.class);
    	List<Bus> busList = bQuery.getResultList();
		return busList;
    	
    }
    
    public Bus findOne(Integer busId) {
    	
    	CriteriaBuilder builder = em.getCriteriaBuilder(); 
    	
    	CriteriaQuery<Bus> cqBus = builder.createQuery(Bus.class);
    	
    	Root<Bus> bRoot = cqBus.from(Bus.class);
    	
    	cqBus.select(bRoot).where(builder.equal(bRoot.get("busId").as(Integer.class), busId));
    	
    	TypedQuery<Bus> bQuery = em.createQuery(cqBus);
    	Bus bus = bQuery.getSingleResult();
    	
    	return bus;
    	
//    	TypedQuery<Bus> bQuery = em.createNamedQuery("Bus.findById", Bus.class);
//    	
//    	//parameter htae py mha alote lote mr m io
//    	bQuery.setParameter("busId", busId);
//    	Bus bus = bQuery.getSingleResult();
//    	return bus;
    	
    }
    
    public void remove(Integer busId) {
    	
    	Bus bus = em.find(Bus.class, busId);
    	em.remove(bus);
    	
    }
    
    public void update(Bus bus) {
    	
    	em.merge(bus);
    	
    }
    
    public void refresh(Bus bus) {
    	
    	em.refresh(bus);
    	
    }

}
