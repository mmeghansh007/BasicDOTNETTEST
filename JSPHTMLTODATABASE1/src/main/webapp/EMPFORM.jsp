<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Registration Form</h2>
	<form action="./EMPDETAILSjsp.jsp">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</form>


</body>
</html>