<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Filmania - <decorator:title />
</title>
<style type="text/css">
#message {
	color: #E62020;
	font-weight: bolder;
	font-size: 1.2em;
	padding-top: 10px;
	text-align: left;
}
</style>
<decorator:head />

</head>
<body>
	<table style="border-style: double;">
		<tr>
			<sec:authorize url="/movie/add">
				<td><a href="<c:url value="/movie/add"/>"> add movie</a></td>
			</sec:authorize>
			<td><a href="<c:url value="/movie/movies"/>"> view movies</a></td>
			<sec:authorize url="/genre/add">
				<td><a href="<c:url value="/genre/add"/>"> add genre</a></td>
			</sec:authorize>
			<sec:authorize url="/genre/genres">
				<td><a href="<c:url value="/genre/genres"/>"> view genres</a></td>
			</sec:authorize>
			<sec:authorize url="/user/add">
				<td><a href="<c:url value="/user/add"/>"> add user</a></td>
			</sec:authorize>
			<sec:authorize url="/user/viewUsers">
				<td><a href="<c:url value="/user/viewUsers"/>"> view users</a></td>
			</sec:authorize>
			<sec:authorize access="not fullyAuthenticated">
				<td><a href="<c:url value="/login"/>">login</a></td>
			</sec:authorize>
			<sec:authorize access="fullyAuthenticated">
				<td><a href="<c:url value="/logout"/>">logout</a></td>
			</sec:authorize>
		</tr>
	</table>
	<br />
	<c:if test="${not empty sessionScope.message}">
		<div id="message">${sessionScope.message}</div>
		<c:remove var="message" scope="session" />
	</c:if>
	<br />
	<decorator:body />
</body>
</html>