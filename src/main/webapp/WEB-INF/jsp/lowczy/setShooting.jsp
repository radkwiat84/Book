<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="shooting.setting.shooting" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/incl/menu.incl"%>

	<form action="/lowczy/settedshooting" method="POST"
		modelAttribute="dear" modelAttribute="boar" modelAttribute="shooting">
		<table border="1px solid black">
			<thead>
				<tr>
					<td align="center" colspan="3">Odstrzał</td>
				</tr>
				<tr>
				<tr>
					<td align="center">Numer odstrzału</td>
					<td align="center">Liczba Dzików do odstrzału</td>
					<td align="center">Liczba Jeleni do odstrzału</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td align="center"><s:bind
							path="shooting.identityNumberOfShooting">
							<input type="text" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.nameOfHunter">
							<input type="hidden" name="${status.expression}"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.lastNameOfHunter">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.city">
							<input type="hidden" name="${status.expression}"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.street">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.numberOfBuilding">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.numberOfApartment">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.postCode">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="shooting.user">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind></td>
					<td align="center"><s:bind path="boar.dzikToExecute">
							<input type="number" name="${status.expression }"
								value="${status.value }">
						</s:bind> <s:bind path="boar.executedDzik">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind></td>
					<td align="center"><s:bind path="dear.jelenToExecute">
							<input type="number" name="${status.expression}"
								value=${status.value }>
						</s:bind> <s:bind path="dear.executedJelen">
							<input type="hidden" name="${status.expression }"
								value="${status.value }">
						</s:bind></td>
				</tr>
				<tr>
					<td align="center" colspan="3"><input type="submit"
						value="Wystaw odstrzał"></td>
				</tr>
			</tbody>
		</table>
	</form>


	<!--Formularz poniżej działa dla pojedyńczego modelAttribute -->
	<%-- <form:form action="/lowczy/setedshooting" method="POST"
		modelAttribute="shooting">

		<form:hidden path="nameOfHunter" />
		<form:hidden path="lastNameOfHunter" />
		<form:hidden path="city" />
		<form:hidden path="street" />
		<form:hidden path="numberOfBuilding" />
		<form:hidden path="numberOfApartment" />
		<form:hidden path="postCode" />
		<form:hidden path="user" />

		<table border="1px solid black">
			<tr>
				<td><s:message code="shooting.setting.shooting" /></td>
			</tr>
			<tr>
				<td><s:message code="shooting.shooting.identity.number" /> <form:input
						path="identityNumberOfShooting" /></td>
			</tr>
		</table>

		<input type="submit" value="<s:message code='button.save'/>">
	</form:form> --%>
</body>
</html>