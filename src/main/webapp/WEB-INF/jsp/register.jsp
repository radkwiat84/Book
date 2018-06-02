<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title>Rejestracja</title>
</head>
<body>

	<p align="center">
		<c:out value="${message }" />
	</p>

	<form:form id="usersForm" action="adduser" modelAttribute="user"
		enctype="multipart/form-data" method="POST">

		<table width="500" border="0" cellpadding="1" align="center">
			<tr>
				<td width="130" align="right"><t:message code="register.name" />
				</td>
				<td width="270" align="right"><form:input path="name" size="28"
						id="name" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:errors path="lastName"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td width="130" align="right">Email:</td>
				<td width="270" align="left"><form:input path="email" size="28" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:errors path="email"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td width="130" align="right">Hasło:</td>
				<td width="270" align="left"><form:password path="password"
						size="28" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><form:errors path="password"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="2" align="center" bgcolor="#fff"><input
					type="submit" value="Zarejestruj" class="formButton" /></td>
			</tr>
		</table>

	</form:form>

	<p align="center">
		<a href="/login">Logowanie</a>
	</p>
</body>
</html>