<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment movie</title>
</head>
<body>
	${movie.name}
	<br />
	<sf:form action="/filmania/movie/addComment" method="POST" modelAttribute="addCommentCommand">
		<input type="hidden" name="movieId" value="${movie.id}"/>
		<sf:textarea path="comment"/>
		<sf:errors path="comment"/>
		<br />
		<input type="submit" name="sacuvajCommentar" value="sacuvaj"/>
	</sf:form>
</body>
</html>