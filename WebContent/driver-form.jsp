<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Form</title>
</head>
<body>
<h3>Driver Registration Form </h3>

<form action="driver" method="post">

<input type="hidden" name="mode" value="SAVE"> 

<label>Driver Name</label>
<input type="text" name="driverName" required="required"><br><br>

<label>Driver Age</label>
<input type="number" name="driverAge" required="required"><br><br>

<label>Driver License</label>
<input type="text" name="driverLicense" required="required"><br><br>

<label>Driver Ph No</label>
<input type="number" name="driverPhno" required="required"><br><br>

<input type="submit" value="Add">

</form>

</body>
</html>

