<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${movie.name}
	<br />
	<sf:form action="/filmania/movie/rateMovie" method="POST" modelAttribute="addMarkCommand">
		<input type="hidden" name="movieId" value="${movie.id}"/>
		<sf:select path="mark">
			<sf:option value="1">1</sf:option>
			<sf:option value="2">2</sf:option>
			<sf:option value="3">3</sf:option>
			<sf:option value="4">4</sf:option>
			<sf:option value="5">5</sf:option>
			<sf:option value="6">6</sf:option>
			<sf:option value="7">7</sf:option>
			<sf:option value="8">8</sf:option>
			<sf:option value="9">9</sf:option>
			<sf:option value="10">10</sf:option>
		</sf:select>
		<br />
		<input type="submit" name="saveMark" value="sacuvaj"/>
	</sf:form>
</body>
</html>