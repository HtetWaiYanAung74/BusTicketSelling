<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Passenger List </title>
</head>
<body>

<h3> Passenger Lists are as follows: </h3>

<p> BusId : ${bus.busId } </p>
<p> BusNumber : ${bus.busNumber } </p>
<p> BusRoute : ${bus.busRoute.origin } - ${bus.busRoute.destination } </p>

<table border="1">
<tr>
<th> PassengerId </th>
<th> PassengerName </th>
<th> PassengerNRC </th>
<th> PassengerPhno </th>
<th> PassengerDueDate </th>
<!-- <th> Action </th> -->
</tr>

<c:forEach var="passenger" items="${passengerList }">
<%-- <c:url var="assignFormLink" value="passenger">
<c:param name="mode" value="ASSIGN_FORM" />
<c:param name="passengerId" value="${passenger.passengerId }" />
</c:url>

<c:url var="viewTicketsLink" value="passenger">
<c:param name="mode" value="VIEW_TICKETS" />
<c:param name="passengerId" value="${passenger.passengerId }" />
</c:url> --%>

<tr>
<td> ${passenger.passengerId } </td>
<td> ${passenger.passengerName } </td>
<td> ${passenger.passengerNRC } </td>
<td> ${passenger.passengerPhno } </td>
<td> ${passenger.passengerDueDate } </td>
<%-- <td> 
<a href="${assignFormLink }"> Buy Ticket </a> 
<a href="${viewTicketsLink }"> Tickets </a> 
</td> --%>
</tr>
</c:forEach>

</table>

</body>
</html>