<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/incl/adminmenu.incl"%>

	<form:form action="/admin/users/changedactivity" modelAttribute="user" method="POST">

		<form:hidden path="id" />
		<form:hidden path="active" /> 
		<form:hidden path="email" />
		<form:hidden path="password" />
		<form:hidden path="name" />
		<form:hidden path="lastName" />
		<form:hidden path="rolaInt" />
		<form:hidden path="roles" />

		<table>
			<tr>
				<td>
				<c:choose>
						<c:when test="${user.active==1 }">
							<s:message code="admin.user.is.active.yes" />
						</c:when>
						<c:otherwise>
							<s:message code="admin.user.is.active.no" />
						</c:otherwise>
					</c:choose>
					</td>
			</tr>
			<tr>
				<td><input type="button"
					value="<s:message code='button.return'/>"
					onclick="window.location.href='${pageContext.request.contextPath}/admin/users'">
					<c:choose>
						<c:when test="${user.active==1 }">
							<input type="submit"
								value="<s:message code='button.deactivate'/>"
								onclick="window.location.href='${pageContext.request.contextPath }/admin/users/changedactivity'">
						</c:when>
						<c:otherwise>
							<input type="submit" value="<s:message code='button.activate'/>"
								onclick="window.location.href='${pageContext.request.contextPath }/admin/users/changedactivity'">
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

	</form:form>



</body>
</html>