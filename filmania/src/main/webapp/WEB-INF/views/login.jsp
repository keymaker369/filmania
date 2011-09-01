<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>login page</title>
</head>
<body>
	<form action="login_to_account" method="post">
		<table align="center" class="login">
			<tr>
				<td align="right" style="padding-right: 5px;">username</td>
				<td align="left"><input type="text" id="j_username"
					name="j_username" />
				</td>
			</tr>
			<tr>
				<td align="right" style="padding-right: 5px;">password</td>
				<td align="left"><input type="password" id="j_password"
					name="j_password" />
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input name="reset" type="reset" />
					<input type="submit" value="login" />
				</td>

			</tr>
		</table>
	</form>
</body>
</html>