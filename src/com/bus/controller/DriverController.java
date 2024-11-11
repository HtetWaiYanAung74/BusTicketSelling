package com.bus.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bus.entity.Bus;
import com.bus.entity.Driver;
import com.bus.service.BusService;
import com.bus.service.DriverService;

/**
 * Servlet implementation class DriverController
 */
@WebServlet("/driver")
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DriverService driverService;
	
	@EJB
	private BusService busService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverController() {
        super();
        // TODO Auto-generated constructor stub
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
			saveDriver(request, response);
			break;
		case "LIST":
			showDrivers(request, response);
			break;
		case "ASSIGN_FORM":
			assignForm(request, response);
			break;
		case "ASSIGN":
			assign(request, response);
			break;
//		case "DELETE":
//			deleteDriver(request, response);
//			break;
		}
	}

	private void assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer driverId = Integer.parseInt(request.getParameter("driverId"));
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		driverService.assignDriverToBus(driverId, busId);
		showDrivers(request, response);
		
	}

	private void assignForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer driverId = Integer.parseInt(request.getParameter("driverId"));
		List<Bus> busList = busService.findAll();
		
		request.setAttribute("driverId", driverId);
		request.setAttribute("busList", busList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("driver-assign-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void saveDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String driverName = request.getParameter("driverName");
		Integer driverAge = Integer.parseInt(request.getParameter("driverAge"));
		String driverLicense = request.getParameter("driverLicense");
		String driverPhno = request.getParameter("driverPhno");
		Driver driver = new Driver(driverName, driverAge, driverLicense, driverPhno);
		
		driverService.saveDriver(driver);
		showDrivers(request, response);
		
	}

	private void showDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Driver> driverList = driverService.findAll();
		request.setAttribute("driverList", driverList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("driver-list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
