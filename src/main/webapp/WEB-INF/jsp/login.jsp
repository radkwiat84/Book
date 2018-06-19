<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/resources/static/css/style.css" />
<title>Logowanie</title>
</head>
<body>

	<form id="loginForm" action="/login" method="POST">
		<table>
			<tr>
				<td>
					Email:
				</td>
				<td>
					<input type="text" name="email" id="email"/>
				</td>
			</tr>
			<tr>
				<td>Hasło:</td>
				<td>
					<input type="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Zaloguj" />
				</td>
			</tr>
		</table>
	</form>
	<p>
		<c:if test="${not empty param.error }">
			Nieprawidłowy email lub hasło
		</c:if>
	</p>
</body>
</html>