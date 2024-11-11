<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Bus List </title>
</head>
<body>

<h3> Bus Lists are as follows: </h3>

<p> <strong> Passenger Id : ${passenger.passengerId } &nbsp;&nbsp; Passenger Name : ${passenger.passengerName } </strong> </p>
<p> <strong> Passenger NRC : ${passenger.passengerNRC } &nbsp;&nbsp; Passenger Phno : ${passenger.passengerPhno } </strong> </p>

<table border="1">
<tr>
<th> BusId </th>
<th> BusBrand </th>
<th> BusModel </th>
<th> BusNumber </th>
<th> BusPrice </th>
<th> BusRegDate </th>
<th> Origin </th>
<th> Destination </th>
<th> Duration </th>
<th> Price </th>
<!-- <th> Action </th> -->
</tr>

<c:forEach var="bus" items="${busList }">
<%-- <c:url var="deleteLink" value="bus">
<c:param name="mode" value="DELETE" />
<c:param name="busId" value="${bus.busId }" />
</c:url>

<c:url var="viewDriversLink" value="bus">
<c:param name="mode" value="VIEW_DRIVERS" />
<c:param name="busId" value="${bus.busId }" />
</c:url> --%>

<tr>
<td> ${bus.busId } </td>
<td> ${bus.busBrand } </td>
<td> ${bus.busModel } </td>
<td> ${bus.busNumber } </td>
<td> ${bus.busPrice } </td>
<td> ${bus.busRegDate } </td>
<td> ${bus.busRoute.origin } </td>
<td> ${bus.busRoute.destination } </td>
<td> ${bus.busRoute.duration } </td>
<td> ${bus.busRoute.price } </td>
<%-- <td> <a href="${deleteLink }" onclick="return confirm('Are you sure you want to delete this item?')"> Delete </a> 
	 <a href="${viewDriversLink }"> Drivers </a> 	
</td> --%>
</tr>
</c:forEach>

</table>

</body>
</html>