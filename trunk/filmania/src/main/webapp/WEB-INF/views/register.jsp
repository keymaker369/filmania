<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<sf:form action="/filmania/register" modelAttribute="newUser" method="POST">
	<table>
		<tr>
			<td>Username:</td>
			<td>
				<sf:input path="username" />
				<sf:errors path="username" />
			</td>
		</tr>
		<tr>
			<td>Password:</td>
			<td>
				<sf:password path="password" />
				<sf:errors path="password" />
			</td>
		</tr>
		<tr>
			<td>Retype password:</td>
			<td>
				<sf:password path="retypePassword" />
				<sf:errors path="retypePassword" />
			</td>
		</tr>
		<tr>
			<td>email:</td>
			<td>
				<sf:input path="email" />
				<sf:errors path="email" />
			</td>
		</tr>
	</table>

	<input type="submit" name="saveNewUser" value="register" />


</sf:form>

</body>
</html>