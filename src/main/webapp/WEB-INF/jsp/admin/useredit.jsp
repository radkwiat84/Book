<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="admin.users.edit.title" /></title>
</head>
<body>
	<%@include file="/WEB-INF/incl/adminMenu.incl"%>
	<p>
		<form:form action="/admin/users/update" modelAttribute="user"
			method="POST">
			<form:hidden path="id" />
			<form:hidden path="password" />
			<form:hidden path="active" />

			<table border="1px solid black">
				<tr>
					<td><s:message code="admin.users.edit.title" /></td>
				</tr>
				<tr>
					<td><s:message code="register.name" /></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td><s:message code="register.lastName" /></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><form:errors path="lastName" /></td>
				</tr>
				<tr>
					<td><s:message code="register.email" /></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:errors path="email" /></td>
				</tr>

				<tr>
					<td><s:message code="register.city" /></td>
					<td><form:input path="city" />
				</tr>
				<tr>
					<td><form:errors path="city" />
				</tr>
				<tr>
					<td><s:message code="register.street" /></td>
					<td><form:input path="street" /></td>
				</tr>
				<tr>
					<td><form:errors path="street"/></td>
				</tr>
				<tr>
					<td><s:message code="register.number.of.building"/></td>
					<td><form:input path="numberOfBuilding"/>
				</tr>
				<tr>
					<td><form:errors path="numberOfBuilding"/></td>
				</tr>
				<tr>
					<td><s:message code="register.number.of.apartment"/></td>
					<td><form:input path="numberOfApartment"/></td>
				</tr>
				<tr>
					<td><form:errors path="numberOfApartment"/></td>
				</tr>
				<tr>
					<td><s:message code="register.post.code"/></td>
					<td><form:input path="postCode"/></td>
				</tr>
				<tr>
					<td><form:errors path="postCode"/></td>
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
						onclick="window.location.href='${pageContext.request.contextPath }/admin/users'" /></td>
				</tr>

			</table>

		</form:form>

	</p>


</body>
</html>