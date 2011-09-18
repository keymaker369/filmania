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
<!-- <link rel="stylesheet" type="text/css" href="/style.css" media="screen,projection" /> -->
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
/* Body and tag styles */
body {
	font: 76% Verdana, Tahoma, Arial, sans-serif;
	line-height: 1.4em;
	text-align: center;
	color: #303030;
	background: #e8eaec
}

* {
	margin: 0;
	padding: 0
}

.fleft {
	float: left
}

.fright {
	float: right
}

.fcenter {
	float: none;
	text-align: center
}

.fclear {
	clear: both
}

.inner_copy {
	border: 0;
	color: #f00;
	float: right;
	width: 50% !important;
	margin: -100% 0 0 0;
	overflow: hidden;
	line-height: 0;
	padding: 0;
	font-size: 11px
}

a {
	color: #467aa7;
	font-weight: bold;
	text-decoration: none;
	background-color: inherit
}

a:hover {
	color: #2a5a8a;
	text-decoration: none;
	background-color: inherit
}

a img {
	border: none
}

p {
	padding: 0 0 1.6em 0
}

p form {
	margin-top: 0;
	margin-bottom: 20px
}

img.left,img.center,img.right {
	padding: 4px;
	border: 1px solid #a0a0a0
}

img.left {
	float: left;
	margin: 0 12px 5px 0
}

img.center {
	display: block;
	margin: 0 auto 5px auto
}

img.right {
	float: right;
	margin: 0 0 5px 12px
}

/* Header and navigation styles */
#container {
	width: 760px;
	margin: 20px auto;
	padding: 1px 0;
	text-align: left;
	background: #fff;
	color: #303030;
	border: 2px solid #a0a0a0
}

#header {
	height: 110px;
	width: 758px;
	margin: 0 1px 1px 1px;
	background: #467aa7;
	color: #fff
}

#header h1 {
	padding: 35px 0 0 20px;
	font-size: 2.4em;
	background-color: inherit;
	color: #fff;
	letter-spacing: -2px;
	font-weight: normal
}

#header h2 {
	margin: 10px 0 0 40px;
	font-size: 1.4em;
	background-color: inherit;
	color: #f0f2f4;
	letter-spacing: -1px;
	font-weight: normal
}

#navigation {
	height: 2.2em;
	line-height: 2.2em;
	width: 758px;
	margin: 0 1px;
	background: #578bb8;
	color: #fff
}

#navigation li {
	float: left;
	list-style-type: none;
	border-right: 1px solid #fff;
	white-space: nowrap
}

#navigation li a {
	display: block;
	padding: 0 10px;
	font-size: 0.8em;
	font-weight: normal;
	text-transform: uppercase;
	text-decoration: none;
	background-color: inherit;
	color: #fff
}

* html #navigation a {
	width: 1%
}

#navigation .selected,#navigation a:hover {
	background: #80b0da;
	color: #fff;
	text-decoration: none
}

/* Content styles */
#content {
	float: left;
	width: 530px;
	font-size: 0.9em;
	padding: 20px 0 0 20px
}

#content h2 {
	display: block;
	margin: 0 0 16px 0;
	font-size: 1.7em;
	font-weight: normal;
	letter-spacing: -1px;
	color: #505050;
	background-color: inherit
}

#content h2 a {
	font-weight: normal
}

#content h3 {
	margin: 0 0 5px 0;
	font-size: 1.4em;
	letter-spacing: -1px
}

#content a:hover,#subcontent a:hover {
	text-decoration: underline
}

#content ul,#content ol {
	margin: 0 5px 16px 35px
}

#content dl {
	margin: 0 5px 10px 25px
}

#content dt {
	font-weight: bold;
	margin-bottom: 5px
}

#content dd {
	margin: 0 0 10px 15px
}

/* Sidebar styles */
#subcontent {
	float: right;
	width: 170px;
	padding: 20px 20px 10px 0;
	line-height: 1.4em
}

#subcontent h2 {
	display: block;
	margin: 0 0 15px 0;
	font-size: 1.5em;
	font-weight: normal;
	text-align: left;
	letter-spacing: -1px;
	color: #505050;
	background-color: inherit
}

#subcontent p {
	margin: 0 0 16px 0;
	font-size: 0.9em
}

/* Menublock styles */
.menublock {
	margin: 0 0 20px 8px;
	font-size: 0.9em
}

.menublock li {
	list-style: none;
	display: block;
	padding: 2px;
	margin-bottom: 2px
}

.menublock li a {
	font-weight: bold;
	text-decoration: none
}

.menublock li a:hover {
	text-decoration: none
}

.menublock li ul {
	margin: 3px 0 3px 15px;
	font-size: 1em;
	font-weight: normal
}

.menublock li ul li {
	margin-bottom: 0
}

.menublock li ul a {
	font-weight: normal
}

/* Searchbar styles */
#searchbar {
	margin: 0 0 20px 0
}

#searchbar form fieldset {
	margin-left: 10px;
	border: 0 solid
}

#searchbar #s {
	height: 1.2em;
	width: 110px;
	margin: 0 5px 0 0;
	border: 1px solid #a0a0a0
}

#searchbar #searchbutton {
	width: auto;
	padding: 0 1px;
	border: 1px solid #808080;
	font-size: 0.9em;
	text-align: center
}

/* Footer styles */
#footer {
	clear: both;
	width: 757px;
	padding: 5px 0;
	margin: 1px auto;
	font-size: 0.9em;
	color: #f0f0f0;
	background: #467aa7
}

#footer p {
	padding: 0;
	margin: 0 5px
}

#footer a {
	color: #f0f0f0;
	background-color: inherit;
	font-weight: bold
}

#footer a:hover {
	color: #fff;
	background: inherit;
	text-decoration: underline
}

/* Misc classes and styles */
.splitcontentleft {
	float: left;
	width: 48%
}

.splitcontentright {
	float: right;
	width: 48%
}

.clear {
	clear: both
}

.small {
	font-size: 0.8em
}

.hide {
	display: none
}

.textcenter {
	text-align: center
}

.textright {
	text-align: right
}

.important {
	color: #f02025;
	background-color: inherit;
	font-weight: bold
}

.box {
	margin: 0 0 20px 0;
	padding: 10px;
	border: 1px solid #c0c0c0;
	background-color: #fafbfc;
	color: #505050;
	line-height: 1.5em
}
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