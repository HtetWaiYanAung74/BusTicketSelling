<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Assign Form</title>
</head>
<body>
<h3>Passenger Assign to Bus</h3>

<p> <strong> Passenger Id : ${passenger.passengerId } &nbsp;&nbsp; Passenger Name : ${passenger.passengerName } </strong> </p>
<p> <strong> Passenger NRC : ${passenger.passengerNRC } &nbsp;&nbsp; Passenger Phno : ${passenger.passengerPhno } </strong> </p>

<form action="passenger" method="get">

<input type="hidden" name="mode" value="ASSIGN">
<input type="hidden" name="passengerId" value="${passenger.passengerId }">

<label> Bus Lists </label>
<select name="busId">
<option value="" disabled="disabled"> Choose Bus </option>
<c:forEach var="bus" items="${busList }">
<option value="${bus.busId }"> 
	${bus.busNumber } : ${bus.busRoute.origin } - ${bus.busRoute.destination } 
</option>
</c:forEach>
</select>

<input type="submit" value="Buy">

</form>
</body>
</html>