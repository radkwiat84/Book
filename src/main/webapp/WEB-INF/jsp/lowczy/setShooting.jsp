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
	
	<form:form action="/lowczy/setedshooting" method="POST" modelAttribute="shooting">
	
	<form:hidden path="nameOfHunter"/>
	<form:hidden path="lastNameOfHunter"/>
	<form:hidden path="city"/>
	<form:hidden path="street"/>
	<form:hidden path="numberOfBuilding"/>
	<form:hidden path="numberOfApartment"/>
	<form:hidden path="postCode"/>
	<form:hidden path="user"/>
	
	
	<s:message code="shooting.shooting.identity.number"/>
	<form:input path="identityNumberOfShooting"/>
	<form:errors path="identityNumberOfShooting"/>
	<br/>
	
	
	<br/>
	<input type="submit" value="<s:message code='button.save'/>">
	</form:form>
	

</body>
</html>