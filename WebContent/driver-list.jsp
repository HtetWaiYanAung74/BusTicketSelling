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

<button onclick="window.location.href='driver-form.jsp'"> Driver Form </button>
<br><br>

<table border="1">
<tr>
<th> DriverId </th>
<th> DriverName </th>
<th> DriverAge </th>
<th> DriverLicense </th>
<th> DriverPhno </th>
<th> BusNumber </th>
<th> Action </th>
</tr>

<c:forEach var="driver" items="${driverList }">
<c:url var="assignFormLink" value="driver">
<c:param name="mode" value="ASSIGN_FORM" />
<c:param name="driverId" value="${driver.driverId }" />
</c:url>

<tr>
<td> ${driver.driverId } </td>
<td> ${driver.driverName } </td>
<td> ${driver.driverAge } </td>
<td> ${driver.driverLicense } </td>
<td> ${driver.driverPhno } </td>
<td> ${driver.bus.busNumber } </td>
<td> <a href="${assignFormLink }"> Assign Form </a> </td>
</tr>
</c:forEach>

</table>

</body>
</html>