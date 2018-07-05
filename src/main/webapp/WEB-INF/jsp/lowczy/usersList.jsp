<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="shooting.users.list" /></title>
</head>
<body>

<%@ include file="/WEB-INF/incl/menu.incl" %>
	<table>
		<tr>
			<td><s:message code="shooting.users.list" /></td>
		</tr>
		<tr>
			<td><s:message code="shooting.user.id" /></td>
			<td><s:message code="shooting.user.name" /></td>
			<td><s:message code="shooting.user.last.name" /></td>
			<td><s:message code="shooting.user.action" /></td>
		</tr>
		<c:forEach var="user" items="${usersList }">
			<tr>
				<td><c:out value="${user.id }" /></td>
				<td><c:out value="${user.name }" /></td>
				<td><c:out value="${user.lastName }" /></td>
				<td><input type="button"
					value="<s:message code='button.set.shooting'/>"
					onclick="window.location.href='${pageContext.request.contextPath}/lowczy/setshooting/${user.id}'">
			</tr>
		</c:forEach>
	</table>
</body>
</html>