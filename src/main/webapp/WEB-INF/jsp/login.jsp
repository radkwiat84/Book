<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="page.title.login" /></title>
</head>
<body>

	<form id="loginForm" action="/login" method="POST">
		<table>
			<tr>
				<td><s:message code="login.email" /></td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td><s:message code="login.password" /></td>
				<td><input type="password" name="password" id="password" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<s:message code="login.button.submit"/>" /></td>
			</tr>
		</table>
	</form>
	<p>
		<c:if test="${not empty param.error }">
			<s:message code="login.error" />
		</c:if>
	</p>
</body>
</html>