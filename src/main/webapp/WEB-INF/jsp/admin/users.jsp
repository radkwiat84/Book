<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="admin.menu.users" /></title>
</head>
<body>
	<%@include file="/WEB-INF/incl/adminMenu.incl"%>
	<br />
	<table border="1px solid black">
		<tr>
			<td><s:message code="admin.users.id" /></td>
			<td><s:message code="register.name" /></td>
			<td><s:message code="register.lastName" /></td>
			<td><s:message code="register.email" /></td>
			<td><s:message code="admin.users.active" /></td>
			<td><s:message code="admin.users.role" /></td>
			<td><s:message code="admin.users.akcje" /></td>
		</tr>

		<c:forEach var="u" items="${userList }">
			<tr>
				<td><c:out value="${u.id }" /></td>
				<td><c:out value="${u.name }" /></td>
				<td><c:out value="${u.lastName }" /></td>
				<td><c:out value="${u.email }" /></td>
				<td><c:choose>
						<c:when test="${u.active == 1 }">
							<font color="green"><s:message
									code="admin.users.active.yes" /></font>
						</c:when>
						<c:otherwise>
							<font color="red"><s:message code="admin.users.active.no" /></font>
						</c:otherwise>
					</c:choose></td>
				<td><c:choose>
						<c:when test="${u.rolaInt == 1 }">
							<font color="blue"><s:message
									code="admin.users.role.admin" /></font>
						</c:when>
						<c:when test="${u.rolaInt == 2 }">
							<s:message code="admin.users.role.mysliwy" />
						</c:when>
						<c:otherwise>
							<s:message code="admin.users.role.lowczy" />
						</c:otherwise>
					</c:choose></td>
				<td><input type="button"
					value="<s:message code="button.edit"/>"
					onclick="window.location.href='${pageContext.request.contextPath}/admin/edit/${u.id}'">
					<br /> <c:choose>
						<c:when test="${u.active == 1 }">
							<input type="button"
								value="<s:message code="button.deactivate"/>"
								onclick="window.location.href='${pageContext.request.contextPath}/admin/changeuseractivity/${u.id }'">
						</c:when>
						<c:otherwise>
							<input type="button" value="<s:message code='button.activate'/>"
								onclick="window.location.href='${pageContext.request.contextPath }/admin/changeuseractivity/${u.id }'">
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>