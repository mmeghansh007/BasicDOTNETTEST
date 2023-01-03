<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management</title>
<style type="text/css">
form {
	margin-top: 10px;
	margin: auto;
	width: 100%;
}

body {
	background-image:
		url('https://cdn.pixabay.com/photo/2015/10/21/08/22/media-998990_960_720.jpg');
	background-size: 100%;
}
</style>
</head>
<body align="center" ; topmargin="280px">

	<%
	if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>
	<h2 style="color: aqua;">Login in StudentManagement</h2>
	<form action="./login" method="post">

		<Label style="color: yellow">Username</Label> <input type="text"
			placeholder="Enter the UserName" name="username"> <br> <br>
		<Label style="color: yellow">Password</Label> <input type="password"
			placeholder="Enter the Password" name="password"> <br> <br>
		<input type="submit" value="Login">
	</form>


</body>
</html>