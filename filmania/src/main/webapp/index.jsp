<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<body>
	<h2>Hello World!</h2>
	<br />
	<a href="<c:url value="/movie/add"/>"> add movie</a>
	<br />
	<a href="<c:url value="/movie/movies"/>"> view movies</a>
	<br />
	<a href="<c:url value="/genre/add"/>"> add genre</a>
	<br />
	<a href="<c:url value="/genre/view"/>"> view genres</a>
	<br />
	<a href="<c:url value="/user/add"/>"> add user</a>
	<br />
	<a href="<c:url value="/user/viewUsers"/>"> view users</a>
	
</body>
</html>
