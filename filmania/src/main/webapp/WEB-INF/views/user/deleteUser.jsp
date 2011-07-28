<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Are you sure you wont to delete user with username: ${user.username}?
	<sf:form action="/filmania/user/deleteUser" method="POST" modelAttribute="user" >
		<sf:hidden path="username"/>
		<input type="submit" name="delete" value="Yes"/>
		<input type="submit" name="No" value="No"/>
	</sf:form>
</body>
</html>