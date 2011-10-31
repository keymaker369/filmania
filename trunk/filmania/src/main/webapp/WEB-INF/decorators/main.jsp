<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Your description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<meta name="author" content="Your Name" />
<link rel="stylesheet" type="text/css" href='<c:url value="/resources/style.css" />' media="screen,projection" />
<title>Filmania - <decorator:title />
</title>
<style type="text/css">

</style>
<decorator:head />

</head>
<body>
<div id="container" >
	<div id="header">
		<h1>filmania</h1>
		<h2>baza filmova i njihovih opisa ...</h2>
	</div>
	<div id="navigation">
		<ul>
			<!-- <li class="selected"><a href="#">Active page</a></li> -->
			<li><sec:authorize url="/movie/add"><a href="<c:url value="/movie/add"/>"> add movie</a></sec:authorize></li>
			<li><a href="<c:url value="/movie/movies"/>"> view movies</a></li>
			<li><sec:authorize url="/genre/add"><a href="<c:url value="/genre/add"/>"> add genre</a></sec:authorize></li>
			<li><sec:authorize url="/genre/genres"><a href="<c:url value="/genre/genres"/>"> view genres</a></sec:authorize></li>
			<li><sec:authorize url="/user/add"><a href="<c:url value="/user/add"/>"> add user</a></sec:authorize></li>
			<li><sec:authorize url="/user/viewUsers"><a href="<c:url value="/user/viewUsers"/>"> view users</a></sec:authorize></li>
			<li><sec:authorize access="not fullyAuthenticated"><a href="<c:url value="/login"/>">login</a></sec:authorize></li>
			<li><sec:authorize access="fullyAuthenticated"><a href="<c:url value="/logout"/>">logout</a></sec:authorize></li>
			<li><sec:authorize access="not fullyAuthenticated"><a href="<c:url value="/register"/>">register</a></sec:authorize></li>
		</ul>
	</div>
	<div class="inner_copy"><div class="inner_copy">Find best premium and <a href="http://www.design4magento.com/free-magento-themes/" title="Magento themes"> free Magento themes</a> at Design4Magento.com</div></div>
	<div id="content">
		<br />
		<c:if test="${not empty sessionScope.message}">
			<div id="message">${sessionScope.message}</div>
			<c:remove var="message" scope="session" />
		</c:if>
		<decorator:body />
		<br />
	</div>
		<div id="footer">
			<div class="fcenter">
				<div class="fleft"><p>Copyright 2011.</p></div>
				<div class="fright"><p>More <a href="<c:url value="/movie/movies"/>" >movies</a> at filmania.com</p></div>
				<div class="fcenter"><p>Created by: Nenad Seke </p></div>
			</div>
		</div>
	</div>
</body>
</html>