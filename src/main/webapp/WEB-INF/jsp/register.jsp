<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/static/css/style.css" />
<title>Rejestracja</title>
</head>
<body>

	<p>
		<c:out value="${message }" />
	</p>

	<form:form id="usersForm" action="adduser" modelAttribute="user" method="POST">

		<table>
			<tr>
				<td><s:message code="register.name" /></td>
				<td><form:input path="name" id="name" /></td>
			</tr>
			<tr>
				<td><form:errors path="name"/></td>
			</tr>
			
			<tr>
				<td>Nazwisko:</td>
				<td><form:input path="lastName" id="lastName"/></td>
			</tr>
			
			<tr>
				<td><form:errors path="lastName"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" id="email"/></td>
			</tr>
			<tr>
				<td><form:errors path="email"/></td>
			</tr>

			<tr>
				<td>Hasło:</td>
				<td><form:password path="password" id="password"/></td>
			</tr>
			<tr>
				<td><form:errors path="password"/></td>
			</tr>

			<tr>
				<td><input type="submit" value="Zarejestruj"/></td>
			</tr>
		</table>

	</form:form>

	<p>
		<a href="/login">Logowanie</a>
	</p>
</body>
</html>