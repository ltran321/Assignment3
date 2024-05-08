<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<center>
		<form action="Registrationservlet" method="post">
			<table>
				<tr>
					<th style="color: red;">
						<% if (request.getParameter("error") != null) { %>
        					<%= request.getParameter("error") %>
    					<% } %>
					</th>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input type="text" name="lastName"></td>
				</tr>

				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>HireDate :</td>
					<td><input type="date" name="hireDate"></td>
				</tr>

				<tr align="center">
					<td><input type="submit" value="Register"></td>
					<td><input type="reset" value="Reset"></td>
				</tr>

			</table>
		</form>
	</center>

</body>
</html>