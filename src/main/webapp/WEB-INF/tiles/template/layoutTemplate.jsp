<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<c:set var="title"><tiles:getAsString name="title" /></c:set>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="<c:url value="/resources/assets/bootstrap/css/bootstrap.css"/> "/>
	<link rel="stylesheet" href="<c:url value="/resources/assets/style.css"/> " />
	<script src="<c:url value="/resources/assets/jquery-1.9.1.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/assets/script.js"/>"></script>
</head>

<body>

	<!-- Header Starts -->
	<div class="container">
		<!-- Header Starts -->
		<tiles:insertAttribute name="header" />
	</div>
	<div class="navbar-wrapper">
		<tiles:insertAttribute name="navigation" />
	</div>
	<!-- #Header Starts -->


	<tiles:insertAttribute name="body" />

	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
