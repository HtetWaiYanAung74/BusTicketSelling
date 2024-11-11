package com.bus.webservice.restful;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.bus.entity.Driver;
import com.bus.service.DriverService;

@Path("/driver")
public class DriverWebService {

	@EJB
	private DriverService driverService;
	
	@Context
	private UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/all")
	public List<Driver> getAllDrivers() {
		
		List<Driver> driverList = driverService.findAll();
		return driverList;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{driverId}")
	public Driver getADriver(@PathParam("driverId") Integer driverId) {
		
		Driver driver = driverService.findOne(driverId);
		
		if(driver == null) {
			throw new NotFoundException("The driver with id : " + driverId + " is Not Found.");
		}
		
		return driver;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/add")
	public Response addDriver(Driver driver) {
		
		driver = driverService.saveDriver(driver);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		URI uri = builder.path(String.valueOf(driver.getDriverId())).build();
		
		return Response.created(uri).build();
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/edit/{driverId}")
	public Response updateDriver(@PathParam("driverId") Integer driverId, Driver driver) {
		
		driver.setDriverId(driverId);
		
		driver = driverService.update(driver);
		
		if(driver == null) {
			throw new NotFoundException("The driver with id : " + driverId + " is Not Found.");
		}
		
		return Response.ok(driver).build();
		
	}
	
	@DELETE
	@Path("/delete/{driverId}")
	public Response deleteDriver(@PathParam("driverId") Integer driverId) {
		
		Driver driver = driverService.findOne(driverId);
		
		if(driver == null) {
			throw new NotFoundException("The driver with id : " + driverId + " is Not Found.");
		}
		
		driverService.remove(driverId);
		
		return Response.ok().build();
		
	}
	
}
