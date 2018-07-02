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
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/incl/menu.incl"%>

	<form:form method="POST" modelAttribute="huntingPlan"
		action="/lowczy/huntingplan/created">

		<table border="1px solid black">
			<tr>
				<td><s:message code="hunting.plan.hunting.season" /></td>
				<td><form:select path="huntingSeason" items="${seasons }" />
			</tr>
			<tr>
				<td><form:errors path="huntingSeason" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.dzik" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.zwierze" /></td>
				<td><s:message code="hunting.plan.liczba" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.odyniec" /></td>
				<td><form:select path="liczbaOdyncow">
						<form:option value="" label="Wybierz liczbę zwierząt do odstrzału" />
						<form:options items="${data }" />
					</form:select></td>

			</tr>
			<tr>
				<td><form:errors path="liczbaOdyncow" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.locha" /></td>
				<td><form:select path="liczbaLoch">
						<form:option value="" label="Wybierz liczbę zwierząt do odstrzału" />
						<form:options items="${data }" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="liczbaLoch" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.warchlak" /></td>
				<td><form:select path="liczbaWarchlakow">
						<form:option value=""
							label="Wybierz liczbę zwierząt do odstrzału" />
						<form:options items="${data }" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="liczbaWarchlakow" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.przelatek" /></td>
				<td><form:select path="liczbaPrzelatkow">
					<form:option value="" label="Wybierz liczbę zwierząt do odstrzału"/>
					<form:options items="${data }"/>
				</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="liczbaPrzelatkow" /></td>
			</tr>
			<tr>
				<td><s:message code="hunting.plan.wycinek" /></td>
				<td><form:select path="liczbaWycinkow">
					<form:option value="" label="Wybierz liczbę zwierząt do odstrzału"/>
					<form:options items="${data }"/>
				</form:select></td>
			</tr>
			<tr>
				<td><form:errors path="liczbaWycinkow" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value="<s:message code="button.save"/>"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>