<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bus Form</title>
</head>
<body>
<h3>Bus Registration Form </h3>

<form action="bus" method="post" >

<input type="hidden" name="mode" value="SAVE"> 

<label>Bus Brand</label>
<input type="text" name="busBrand" required="required"><br><br>

<label>Bus Model</label>
<input type="number" name="busModel" required="required"><br><br>

<label>Bus Number</label>
<input type="text" name="busNumber" required="required"><br><br>

<label>Bus Price</label>
<input type="number" name="busPrice" required="required"><br><br>
<hr>

<h3> Bus Route Registration Form </h3>

<label> Origin </label>
<select name="origin">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</select><br><br>

<label> Destination </label>
<select name="destination">
	<option value="" disabled="disabled"> Choose City </option>
	<option value="YANGON"> Yangon </option>
	<option value="MANDALAY"> Mandalay </option>
	<option value="TAUNGGYI"> Taunggyi </option>
	<option value="BAGO"> Bago </option>
	<option value="PYINOOLWIN"> Pyinoolwin </option>
</select><br><br>

<label> Duration </label>
<input type="number" name="duration" required="required"><br><br>

<label> Price </label>
<input type="number" name="price" required="required"><br><br>

<input type="submit" value="Add">

</form>

</body>
</html>

