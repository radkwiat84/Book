<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title><s:message code="page.title.register" /></title>
</head>
<body>

	<%@ include file="/WEB-INF/incl/menu.incl"%>

	<p>
		<c:out value="${message }" />
	</p>


	<form:form action="adduser" modelAttribute="user" method="POST">

		<s:message code="register.name" />
		<form:input path="name" />
		<br />

		<form:errors path="name" />
		<br />

		<s:message code="register.lastName" />
		<form:input path="lastName" />
		<br />

		<form:errors path="lastName" />
		<br />

		<s:message code="register.email" />
		<form:input path="email" />
		<br />

		<form:errors path="email" />
		<br />

		<s:message code="register.password" />
		<form:password path="password" />
		<br />

		<form:errors path="password" />
		<br />

		<input type="submit"
			value="<s:message code="register.button.register"/>" />
		<br />
	</form:form>
</body>
</html>