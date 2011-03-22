<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<sf:form action="../movie/add" method="POST" modelAttribute="newMovie">
	<table>
		<tr>
			<td>name:</td>
			<td><sf:input path="name" /></td>
		</tr>
	</table>
	<display:table list="${newMovie.allGenres}">
		<display:column property="name" />
		<display:column title="select one">
			<sf:checkbox path=""/>
		</display:column>
	</display:table>
	<input type="submit" name="saveNewMovie" value="save" />
</sf:form>

</body>
</html>