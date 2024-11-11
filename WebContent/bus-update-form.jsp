<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Form</title>
</head>
<body>
<h3>Bus Update Form </h3>

<form action="bus" method="post" >

<input type="hidden" name="mode" value="UPDATE"> 
<input type="hidden" name="busId" value="${bus.busId }">
<input type="hidden" name="busRouteId" value="${bus.busRoute.busRouteId }">

<label>Bus Brand</label>
<input type="text" name="busBrand" required="required" value="${bus.busBrand }"><br><br>

<label>Bus Model</label>
<input type="number" name="busModel" required="required" value="${bus.busModel }"><br><br>

<label>Bus Number</label>
<input type="text" name="busNumber" required="required" value="${bus.busNumber }"><br><br>

<label>Bus Price</label>
<input type="number" name="busPrice" required="required" value="${bus.busPrice }"><br><br>
<hr>

<h3> Bus Route Update Form </h3>

<label> Origin </label>
<select name="origin">
<c:if test="${bus.busRoute.origin == 'YANGON' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON" selected="selected"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.origin == 'MANDALAY' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY" selected="selected"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.origin == 'TAUNGGYI' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI" selected="selected"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.origin == 'BAGO' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO" selected="selected"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.origin == 'PYINOOLWIN' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN" selected="selected"> Pyinoolwin </option>
</c:if>
</select><br><br>

<label> Destination </label>
<select name="destination">
	<c:if test="${bus.busRoute.destination == 'YANGON' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON" selected="selected"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.destination == 'MANDALAY' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY" selected="selected"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.destination == 'TAUNGGYI' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI" selected="selected"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.destination == 'BAGO' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO" selected="selected"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</c:if>

<c:if test="${bus.busRoute.destination == 'PYINOOLWIN' }">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN" selected="selected"> Pyinoolwin </option>
</c:if>
</select><br><br>

<label> Duration </label>
<input type="number" name="duration" required="required" value="${bus.busRoute.duration }"><br><br>

<label> Price </label>
<input type="number" name="price" required="required" value="${bus.busRoute.price }"><br><br>

<input type="submit" value="Update">

</form>

</body>
</html>

