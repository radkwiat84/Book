<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="hunting.plans" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/incl/menu.incl"%>

	<table border="1px solid black">
		<tr>
			<td><s:message code="hunting.plans" /></td>
		</tr>
		<tr>
			<td><s:message code="hunting.plan.id" /></td>
			<td><s:message code="hunting.plan.hunting.season" /></td>
			<td><s:message code="hunting.plan.action" /></td>
		</tr>
		<c:forEach var="hP" items="${huntingPlanList }">
			<tr>
				<td><c:out value="${hP.id }" /></td>
				<td><c:out value="${hP.huntingSeason }" /></td>
				<td><input type="button"
					value="<s:message code='button.open'/>"
					onclick="window.location.href='${pageContext.request.contextPath}/lowczy/huntingplan/${hP.id }'">
					<br /> <input type="button"
					value="<s:message code='button.edit'/>"
					onclick="window.location.href='${pageContext.request.contextPath}/lowczy/huntingplan/update/${hP.id }'"></td>
			</tr>

		</c:forEach>
		
		<c:out value="${updateMessage }"/>

	</table>


</body>
</html>