package com.bus.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.bus.entity.Passenger;
import com.bus.service.BusService;
import com.bus.service.PassengerService;

/**
 * Servlet implementation class PassengerController
 */
@WebServlet("/passenger")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PassengerService passengerService;
	
	@EJB
	private BusService busService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerController() {
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
			try {
				savePassenger(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case "LIST":
			showPassengers(request, response);
			break;
		case "ASSIGN_FORM":
			assignForm(request, response);
			break;
		case "ASSIGN":
			assign(request, response);
			break;
		case "VIEW_TICKETS":
			viewTickets(request, response);
			break;
		}
	}

	private void assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer passengerId = Integer.parseInt(request.getParameter("passengerId"));
		Integer busId = Integer.parseInt(request.getParameter("busId"));
		
		passengerService.assignPassengerToBus(passengerId, busId);
		
		showPassengers(request, response);
		
	}

	private void assignForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer passengerId = Integer.parseInt(request.getParameter("passengerId"));
		
		Passenger passenger = passengerService.findOne(passengerId);
		
		List<Bus> busList = busService.findAll();
		
		request.setAttribute("passenger", passenger);
		request.setAttribute("busList", busList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("passenger-assign-form.jsp");
		dispatcher.forward(request, response);
		
	}

	private void savePassenger(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
		
		String passengerName = request.getParameter("passengerName");
		String passengerNRC = request.getParameter("passengerNRC");
		String passengerPhno = request.getParameter("passengerPhno");
		String passengerDueDateRaw = request.getParameter("passengerDueDate");
		
		Date passengerDueDate = new SimpleDateFormat("yyyy-MM-dd").parse(passengerDueDateRaw);
	
		Passenger passenger = new Passenger(passengerName, passengerNRC, passengerPhno, passengerDueDate);
		
		passengerService.savePassenger(passenger);
		
		showPassengers(request, response);
		
	}

	private void showPassengers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Passenger> passengerList = passengerService.findAll();
		request.setAttribute("passengerList", passengerList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("passenger-list.jsp");
		dispatcher.forward(request, response);
		
	}

	private void viewTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer passengerId = Integer.parseInt(request.getParameter("passengerId"));
		
		Passenger passenger = passengerService.findOne(passengerId);
		
		List<Bus> busList = passenger.getBuses();
		
		request.setAttribute("passenger", passenger);
		request.setAttribute("busList", busList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("passenger-ticket-list.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
