<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>
	<display:table id="user" list="${users}">
		<display:column title="id" property="id"/>
		<display:column title="username" property="username"/>
		<display:column title="email" property="email"/>
		<display:column title="acc non exp">
			<c:choose>
				<c:when test="${user.accountNonExpired}">
					yes
				</c:when>
				<c:otherwise>
					No
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column title="acc non locked">
			<c:choose>
				<c:when test="${user.accountNonLocked}">
					yes
				</c:when>
				<c:otherwise>
					No
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column title="cred non exp">
			<c:choose>
				<c:when test="${user.credentialsNonExpired}">
					yes
				</c:when>
				<c:otherwise>
					No
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column title="enabled">
			<c:choose>
				<c:when test="${user.enabled}">
					yes
				</c:when>
				<c:otherwise>
					No
				</c:otherwise>
			</c:choose>
		</display:column>
		<display:column>
			<a href='<c:url value="/user/edit?username=${user.username}"/>'>edit</a>
		</display:column>
				<display:column>
			<a href='<c:url value="/user/deleteUser?username=${user.username}"/>'>delete</a>
		</display:column>
	</display:table>

</body>
</html>