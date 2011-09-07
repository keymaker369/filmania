<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit user</title>
</head>
<body>
	<sf:form action="/filmania/user/edit" modelAttribute="user" method="POST">
		<sf:hidden path="id"/>
		<table>
			<tr>
				<td>Username:</td>
				<td>
					<sf:input path="username" />
					<sf:errors path="username" />
				</td>
			</tr>
			<tr>
				<td>email:</td>
				<td>
					<sf:input path="email" />
					<sf:errors path="email" />
				</td>
			</tr>
			<tr>
				<td>Account non expired:</td>
				<td>
					<sf:checkbox path="accountNonExpired" />
				</td>
			</tr>
			<tr>
				<td>Account non locked:</td>
				<td><sf:checkbox path="accountNonLocked" /></td>
			</tr>
			<tr>
				<td>Credentials non expired:</td>
				<td><sf:checkbox path="credentialsNonExpired" /></td>
			</tr>
			<tr>
				<td>Enabled:</td>
				<td><sf:checkbox path="enabled" /></td>
			</tr>
			<tr>
				<td>Role member:</td>
				<td><sf:checkbox path="member" /></td>
			</tr>
			<tr>
				<td>Role admin:</td>
				<td><sf:checkbox path="admin" /></td>
			</tr>
		</table>
	
		<input type="submit" name="updateUser" value="Save" />
	
	
	</sf:form>
</body>
</html>