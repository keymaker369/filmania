<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
		<td>Datum unosa filma: ${movie.inputDate}</td>
	</tr>
	<tr>	
		<td>Dodato od strane korisnika: ${movie.user.username}</td>
	</tr>
	<tr>	
		<td>Proscna ocena: ${movie.rank}</td>
	</tr>
	<tr>	
		<td>
			<display:table list="${movie.genres}">
				<display:column title="Zanr" property="name"/>
			</display:table>
		</td>
	</tr>
	<tr>	
		<td>
			Komentari:
			<display:table id="comment" list="${movie.comments}">
				<display:column title="Komentar" property="content"/>
				<display:column title="Vreme unosa" property="inputDate"/>
				<display:column title="Korisnik">${comment.user.username}</display:column>
			</display:table>
		</td>
	</tr>
</table>
<br/>
<a href="/filmania/movie/addComment?idMovie=${movie.id}">Comment movie</a>
<br/>
<a href="/filmania/movie/rateMovie?idMovie=${movie.id}">Rate movie</a>
</body>
</html>