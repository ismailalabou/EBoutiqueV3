<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/layout1/css/template.css"/>
</head>
<body>
	<div id="header" class="cadre">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="content" class="cadre">
	<div id="menu" class="cadre"><tiles:insertAttribute name="menu"></tiles:insertAttribute></div>
	<div id="body" class="cadre"><tiles:insertAttribute name="body"></tiles:insertAttribute></div>
	</div>
	<div id="footer" class="cadre">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>