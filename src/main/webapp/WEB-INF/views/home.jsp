<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true"%>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">

		<div class="">
			<div class="container">
				<div class="spacer">
					<div class="row">
						<h3><spring:message code="home.about.us" text="About Us"/></h3>
						<p>
							The Top Rated TV Shows list only includes TV series and TV mini
							series.<br /> The list is ranked by a formula which includes the
							number of ratings each show received from users, and value of
							ratings received from regular users. To be included on the list,
							a series or mini series must receive ratings from at least 5000
							users, and a TV series must also have aired at least 5 episodes
						</p>

					</div>
				</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>