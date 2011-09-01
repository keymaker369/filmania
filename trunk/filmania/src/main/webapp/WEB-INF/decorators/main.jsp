<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Filmania - <decorator:title />
</title>
<decorator:head />

</head>
<body>
	<table style="border-style: double;">
		<tr>
			<td><a href="<c:url value="/movie/add"/>"> add movie</a></td>
			<td><a href="<c:url value="/movie/movies"/>"> view movies</a></td>
			<td><a href="<c:url value="/genre/add"/>"> add genre</a></td>
			<td><a href="<c:url value="/genre/genres"/>"> view genres</a></td>
			<td><a href="<c:url value="/user/add"/>"> add user</a></td>
			<td><a href="<c:url value="/user/viewUsers"/>"> view users</a></td>
			<td><a href="<c:url value="/login"/>">login</a></td>
			<td><a href="<c:url value="/logout"/>">logout</a></td>
		</tr>
	</table>
	<br />
	<br />
	<decorator:body />
</body>
</html>