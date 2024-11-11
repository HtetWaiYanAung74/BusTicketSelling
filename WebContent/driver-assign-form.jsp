<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Assign Form</title>
</head>
<body>
<h3>Driver Assign Form</h3>

<h4> Driver Id : ${driverId } </h4>

<form action="driver" method="get">

<input type="hidden" name="mode" value="ASSIGN">
<input type="hidden" name="driverId" value="${driverId }">

<label> Bus Lists </label>
<select name="busId">
<option value="" disabled="disabled"> Choose Bus </option>
<c:forEach var="bus" items="${busList }">
<option value="${bus.busId }"> ${bus.busNumber } </option>
</c:forEach>
</select>

<input type="submit" value="Assign">

</form>
</body>
</html>