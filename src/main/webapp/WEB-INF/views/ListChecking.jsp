<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script src="<c:url value="/resources/assets/ajax.js"/>"></script>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-12 col-sm-12 col-xs-12 ">

					<div class="table-responsive">
						<table class="table table-hover">
							<tr class="active">
								<th><spring:message code="checking.studentID"   text="Student ID" /></th>
								<th><spring:message code="checking.name"   text="Name" /></th>
								<th><spring:message code="checking.date"   text="Date" /></th>
								<th><spring:message code="checking.status"   text="Status" /></th>
								<th></th>
								<th></th>
							</tr>
							<c:forEach var="checking" items="${reports}">
								<tr class="active approw">
									<td>${checking.student.studentId}</td>
									<td>${checking.student.firstName} + ${checking.student.lastName} </td>
									<td>${checking.checkingDate}</td>
									<td>${checking.status}</td>
<%-- 									<td><a href="<c:url value="/property/propertyList?id=${hotProperty.id}"/>">View</a></td> --%>
<%-- 									 <td><a href="#" class="approveRequestBtn" valId="${hotProperty.id}" >Approve</a></td> --%>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	</tiles:putAttribute>
</tiles:insertDefinition>
</html>