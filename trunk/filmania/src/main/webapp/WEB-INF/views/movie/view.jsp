<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Naziv: ${movie.name}</td>
	</tr>	
	<tr>	
		<td>Rank: ${movie.rank}</td>
	</tr>
	<tr>	
		<td>Datum unosa filma: ${movie.inputDate}</td>
	</tr>
	<tr>	
		<td>Dodato od strane korisnika: ${movie.user}</td>
	</tr>
	<tr>	
		<td>
			<display:table list="${movie.genres}">
				<display:column title="Zanr" property="name"/>
			</display:table>
		</td>
	</tr>
	Komentari:
	<tr>	
		<td>
			<display:table list="${movie.comments}">
			</display:table>
		</td>
	</tr>
</table>
</body>
</html>