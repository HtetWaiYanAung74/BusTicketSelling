<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Form</title>
</head>
<body>
<h3>Passenger Registration Form </h3>

<form action="passenger" method="post">

<input type="hidden" name="mode" value="SAVE"> 

<label>Passenger Name</label>
<input type="text" name="passengerName" required="required"><br><br>

<label>Passenger NRC</label>
<input type="text" name="passengerNRC" required="required"><br><br>

<label>Passenger Ph No</label>
<input type="number" name="passengerPhno" required="required"><br><br>

<label>Passenger Due Date</label>
<input type="date" name="passengerDueDate" required="required"><br><br>

<input type="submit" value="Add">

</form>

</body>
</html>

