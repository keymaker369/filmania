<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all movies</title>
</head>
<body>
	<form action="/filmania/movie/movies" method="POST">
		<label>Naziv filma:</label>
		<input type="text" name="movieName">
		<input type="submit" name="searchMovie" value="search">		
	</form>
	<br/>
	<display:table id="movie" list="${movies}">
		<display:column title="id" ><a href='<c:url value="/movie/view?id=${movie.id}"/>'>${movie.id}</a></display:column>
		<display:column>|</display:column>
		<display:column property="name" />
		<display:column>|</display:column>
		<display:column title="genre">
			<c:forEach items="${movie.genres}" var="genre">
				${genre.name} <c:out value="," />
			</c:forEach>
		</display:column>
		<display:column>|</display:column>
		<display:column title="grade" property="rank"/>
		<display:column>|</display:column>
		<display:column>
			<a href="/filmania/movie/addComment?idMovie=${movie.id}">Comment movie</a>
		</display:column>
		<display:column>|</display:column>
		<display:column>
			<a href="/filmania/movie/rateMovie?idMovie=${movie.id}">Rate movie</a>
		</display:column>
	</display:table>

</body>
</html>