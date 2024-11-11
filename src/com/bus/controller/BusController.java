package com.bus.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.entity.Bus;
import com.bus.entity.BusRoute;
import com.bus.entity.Cities;
import com.bus.entity.Driver;
import com.bus.entity.Passenger;
import com.bus.service.BusService;

/**
 * Servlet implementation class BusController
 */
@WebServlet("/bus")
public class BusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private BusService busService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		
		switch (mode) {
		case "SAVE":
			saveBus(request, response);
			break;
		case "LIST":
			showBuses(request, response);
			break;
		case "DELETE":
			deleteBus(request, response);
			break;
		case "VIEW_DRIVERS":
			viewDrivers(request, response);
			break;
		case "VIEW_PASSENGERS":
			viewPassengers(request, response);
			break;
		case "UPDATE_FORM":
			updateForm(request, response);
			break;
		case "UPDATE":
			updateBus(request, response);
			break;
		}
		
	}

	private void updateBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		Bus oldBus = busService.findOne(busId);
		
		String busBrand = request.getParameter("busBrand");
		Integer busModel = Integer.parseInt(request.getParameter("busModel"));
		String busNumber = request.getParameter("busNumber");
		Integer busPrice = Integer.parseInt(request.getParameter("busPrice"));
		
		Date busRegDate = oldBus.getBusRegDate();
		
		Bus bus = new Bus(busId, busBrand, busModel, busNumber, busPrice, busRegDate);
			
		Integer busRouteId = Integer.parseInt(request.getParameter("busRouteId"));
		String originRaw = request.getParameter("origin");
		String destinationRaw = request.getParameter("destination");
		Integer duration = Integer.parseInt(request.getParameter("duration"));
		Double price = Double.parseDouble(request.getParameter("price"));
		
		Cities origin = Cities.YANGON;
		switch (originRaw) {
		case "YANGON":
			origin = Cities.YANGON;
			break;
		case "BAGO":
			origin = Cities.BAGO;
			break;
		case "MANDALAY":
			origin = Cities.MANDALAY;
			break;
		case "PYINOOLWIN":
			origin = Cities.PYINOOLWIN;
			break;
		case "TAUNGGYI":
			origin = Cities.TAUNGGYI;
			break;
		}
		
		Cities destination = Cities.YANGON;
		switch (destinationRaw) {
		case "YANGON":
			destination = Cities.YANGON;
			break;
		case "BAGO":
			destination = Cities.BAGO;
			break;
		case "MANDALAY":
			destination = Cities.MANDALAY;
			break;
		case "PYINOOLWIN":
			destination = Cities.PYINOOLWIN;
			break;
		case "TAUNGGYI":
			destination = Cities.TAUNGGYI;
			break;
		}
		
		BusRoute busRoute = new BusRoute(busRouteId, origin, destination, duration, price);
		
		//OneToOne Connect
		bus.setBusRoute(busRoute);
		
//		//OneToMany Connect
//		bus.setDrivers(oldBus.getDrivers());
//				
//		//ManyToMany Connect
//		bus.setPassengers(oldBus.getPassengers());
		
		busService.update(bus);
//		busService.refresh(bus);
		showBuses(request, response);
		
	}

	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		Bus bus = busService.findOne(busId);
		
		request.setAttribute("bus", bus);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus-update-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void viewDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		Bus bus = busService.findOne(busId);
		
		List<Driver> driverList = bus.getDrivers();
		
		request.setAttribute("bus", bus);
		request.setAttribute("driverList", driverList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus-driver-list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void saveBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busBrand = request.getParameter("busBrand");
		Integer busModel = Integer.parseInt(request.getParameter("busModel"));
		String busNumber = request.getParameter("busNumber");
		Integer busPrice = Integer.parseInt(request.getParameter("busPrice"));
		Date busRegDate = new Date();
		
		String originRaw = request.getParameter("origin");
		String destinationRaw = request.getParameter("destination");
		Integer duration = Integer.parseInt(request.getParameter("duration"));
		Double price = Double.parseDouble(request.getParameter("price"));
		
		Cities origin = Cities.YANGON;
		switch (originRaw) {
		case "YANGON":
			origin = Cities.YANGON;
			break;
		case "BAGO":
			origin = Cities.BAGO;
			break;
		case "MANDALAY":
			origin = Cities.MANDALAY;
			break;
		case "PYINOOLWIN":
			origin = Cities.PYINOOLWIN;
			break;
		case "TAUNGGYI":
			origin = Cities.TAUNGGYI;
			break;
		}
		
		Cities destination = Cities.YANGON;
		switch (destinationRaw) {
		case "YANGON":
			destination = Cities.YANGON;
			break;
		case "BAGO":
			destination = Cities.BAGO;
			break;
		case "MANDALAY":
			destination = Cities.MANDALAY;
			break;
		case "PYINOOLWIN":
			destination = Cities.PYINOOLWIN;
			break;
		case "TAUNGGYI":
			destination = Cities.TAUNGGYI;
			break;
		}
		
		Bus bus = new Bus(busBrand, busModel, busNumber, busPrice, busRegDate);
		BusRoute busRoute = new BusRoute(origin, destination, duration, price);
		
		//OneToOne (connect)
		bus.setBusRoute(busRoute);
				
		busService.saveBus(bus);
		showBuses(request, response);
		
//		PrintWriter out = response.getWriter();
//		out.print("Successfully Saved Bus to Databse");
		
	}
	
	protected void showBuses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Bus> busList = busService.findAll();
		request.setAttribute("busList", busList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void deleteBus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		busService.remove(busId);
		showBuses(request, response);
		
	}
	
	private void viewPassengers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		Bus bus = busService.findOne(busId);
		
		List<Passenger> passengerList = bus.getPassengers();
		
		request.setAttribute("bus", bus);
		request.setAttribute("passengerList", passengerList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("bus-passenger-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
