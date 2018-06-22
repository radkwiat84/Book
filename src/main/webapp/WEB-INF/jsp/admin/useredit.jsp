<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="admin.users.edit.title" /></title>
</head>
<body>
	<%@include file="/WEB-INF/incl/adminmenu.incl"%>
	<p>
		<form:form id="usersForm" action="/admin/update" modelAttribute="user"
			method="POST">
			<form:hidden path="id" />
			<form:hidden path="password" />
			<form:hidden path="active" />

			<table>
				<tr>
					<td><s:message code="admin.users.edit.title" /></td>
				</tr>
				<tr>
					<td><s:message code="register.name" /></td>
					<td><form:input path="name" id="name" /></td>
				</tr>
				<tr>
					<td><s:message code="register.lastName" /></td>
					<td><form:input path="lastName" id="lastName" /></td>
				</tr>
				<tr>
					<td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td><s:message code="register.email" /></td>
					<td><form:input path="email" id="email" /></td>
				</tr>
				<tr>
					<td><form:errors path="email" /></td>
				</tr>
				<tr>
					<td><s:message code="admin.users.role" /></td>
					<td><form:select path="rolaInt" items="${roleMap }" /></td>
				</tr>
				<tr>
					<td><input type="submit"
						value="<s:message code="button.save"/>" /></td>
					<td><input type="button"
						value="<s:message code="button.cancel"/>"
						onclick="window.location.href='${pageContext.request.contextPath }/admin/users'"/></td>
				</tr>

			</table>

		</form:form>

	</p>


</body>
</html>