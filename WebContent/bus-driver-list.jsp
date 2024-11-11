<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Driver List </title>
</head>
<body>

<h3> Driver Lists are as follows: </h3>

<p> BusId : ${bus.busId } </p>
<p> BusNumber : ${bus.busNumber } </p>
<p> BusRoute : ${bus.busRoute.origin } - ${bus.busRoute.destination } </p>

<table border="1">
<tr>
<th> DriverId </th>
<th> DriverName </th>
<th> DriverAge </th>
<th> DriverLicense </th>
<th> DriverPhno </th>
</tr>

<c:forEach var="driver" items="${driverList }">

<tr>
<td> ${driver.driverId } </td>
<td> ${driver.driverName } </td>
<td> ${driver.driverAge } </td>
<td> ${driver.driverLicense } </td>
<td> ${driver.driverPhno } </td>
</tr>
</c:forEach>

</table>

</body>
</html>