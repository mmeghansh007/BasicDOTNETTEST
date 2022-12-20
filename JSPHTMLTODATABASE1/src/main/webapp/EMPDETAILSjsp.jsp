<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.lang.ClassNotFoundException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<%
String name = request.getParameter("name");
String city = request.getParameter("city");
String mobile = request.getParameter("mobile");
String dob = request.getParameter("dob");
Connection connection = null;
PreparedStatement preparedstatement = null;
int result = 0;
String INSERT_QUERY = "INSERT INTO REGISTREDUSER(NAME,CITY,MOBILE,DOB) VALUES(?,?,?,?)";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h2>Registration Form</h2>

	<table>
		<tr>
			<td>Name:</td>
			<td><%=name%></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><%=city%></td>
		</tr>
		<tr>
			<td>Mobile:</td>
			<td><%=mobile%></td>
		</tr>
		<tr>
			<td>DOB:</td>
			<td><%=dob%></td>
		</tr>

	</table>

	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weje2?", "root", "root");
		preparedstatement = connection.prepareStatement(INSERT_QUERY);
		preparedstatement.setString(1, name);
		preparedstatement.setString(2, city);
		preparedstatement.setString(3, mobile);
		preparedstatement.setString(4, dob);
		result = preparedstatement.executeUpdate();

		if (result != 0) {
	%>
	<h3><%=result%>
		row(s) affected
	</h3>
	<%
	}
	} catch (Exception e) {
	%>
	<%=e%>
	<%
	}
	%>








</body>
</html>

