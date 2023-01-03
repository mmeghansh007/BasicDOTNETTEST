<%@page import="com.jspiders.springmvc.POJO.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Home.jsp" />
<%
StudentPOJO student = (StudentPOJO) request.getAttribute("student");
%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: red;
	background-color: aqua;
}

body {
	background-image:
		url('https://cdn.pixabay.com/photo/2020/02/20/19/48/travel-4865665_960_720.jpg');
	background-size: 100%;
}
</style>
</head>
<body>

	<fieldset>
		<legend>Add StudentDetails</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td><input type="text" name="contact"></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><input type="text" name="city"></td>
				</tr>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="text" name="password"></td>
				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (student != null) {
	%>
	<h3 align="center">
		<%=student.getName()%>
		added successfully..!!
	</h3>
	<%
	} else if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>

</body>
</html>