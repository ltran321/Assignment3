<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>

	<form action="Loginservlet" method="post">
		<table>
			<tr>
				<th style="color: red;">
					<%
					if (request.getParameter("message") != null) {
					%> <%=request.getParameter("message")%>
					<%
					}
					%>
					<%
					if (request.getParameter("error") != null) {
					%> <%=request.getParameter("error")%>
					<%
					}
					%>
				</th>
			</tr>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr align="center">
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
	<a href="signup.jsp">Click Here To Register</a>
</center>	
</body>
</html>