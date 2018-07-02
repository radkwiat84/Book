<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="page.title.login" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/incl/menu.incl"%>
	<br />
	<form action="/login" method="POST">
		<s:message code="login.email" />
		<input type="text" name="email" />
		<br />
		<s:message code="login.password" />
		<input type="password" name="password" />
		<br />
		<input type="submit" value="<s:message code="login.button.submit"/>" />
		<br />
	</form>
	<p>
		<c:if test="${not empty param.error }">
			<s:message code="login.error" />
		</c:if>
	</p>
</body>
</html>