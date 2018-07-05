<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="shooting.shooting.list" /></title>
</head>
<body>
	<%@ include file="/WEB-INF/incl/menu.incl"%>


	<table border="1px solid black">
		<tr>
			<td><s:message code="shooting.shooting.list" /></td>
		</tr>
		
		<tr>
			<td><s:message code="shooting.shooting.id" /></td>
			<td><s:message code="shooting.shooting.identity.number" /></td>
			<td><s:message code="shooting.hunter.name.last.name" /></td>
			<td><s:message code="shooting.hunter.place.of.living" /></td>
			<td><s:message code="shooting.user.action"/></td>
		</tr>
		<c:forEach var="shooting" items="${shootingList }">
			<tr>
				<td><c:out value="${shooting.id }" /></td>
				<td><c:out value="${shooting.identityNumberOfShooting }" /></td>
				<td><c:out value="${shooting.nameOfHunter } " /> <c:out
						value="${shooting.lastNameOfHunter }" /></td>
				<c:choose>
					<c:when test="${shooting.numberOfApartment == 0 }">
						<td><c:out
								value="${shooting.postCode } ${shooting.city }, ul. ${shooting.street } ${shooting.numberOfBuilding }" />
					</c:when>
					<c:otherwise>
						<td><c:out
								value="${shooting.postCode } ${shooting.city }, ul. ${shooting.street } ${shooting.numberOfBuilding } m. ${shooting.numberOfApartment }" />
						</td>
					</c:otherwise>
				</c:choose>
				<td><input type="button" value="<s:message code='button.open'/>" 
				onclick="window.location.href='${pageContext.request.contextPath}/lowczy/openshooting/${shooting.id }'">

			</tr>


		</c:forEach>


	</table>


</body>
</html>