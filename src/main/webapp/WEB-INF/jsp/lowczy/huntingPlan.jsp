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
<title><s:message code="hunting.plan" /></title>
</head>
<body>

	<%@ include file="/WEB-INF/incl/menu.incl"%>

	<table border="1px solid black">
		<tr>
			<td><s:message code="hunting.plan" /> <c:out value="${huntingPlan.huntingSeason }"/></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.zwierze" /></td>
			<td><s:message code="hunting.plan.liczba" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.odyniec" /></td>
			<td><c:out value="${huntingPlan.liczbaOdyncow }" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.locha" /></td>
			<td><c:out value="${huntingPlan.liczbaLoch }" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.warchlak" /></td>
			<td><c:out value="${huntingPlan.liczbaWarchlakow }" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.przelatek" /></td>
			<td><c:out value="${huntingPlan.liczbaPrzelatkow }" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.wycinek" /></td>
			<td><c:out value="${huntingPlan.liczbaWycinkow }" /></td>
		</tr>
		<tr>
			<td><input type="button" value="<s:message code='button.edit'/>"
				onclick="window.location.href='${pageContext.request.contextPath}/lowczy/huntingplan/update/${huntingPlan.id }'"></td>
				<td><input type="button" value="<s:message code='button.return'/>"
				onclick="window.location.href='${pageContext.request.contextPath}/lowczy/huntingplans'"></td>
		</tr>
	</table>
</body>
</html>