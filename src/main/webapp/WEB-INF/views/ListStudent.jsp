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
					<form action="searchStudent" method="post">
						<input type="text" id = "sid" name = "studentId" />
						<input type="submit" value="Search"> 
					</form>
					<div class="table-responsive">
						<table class="table table-hover">
							<tr class="active">
								<th><spring:message code="student.id"   text="Student ID" /></th>
								<th><spring:message code="student.name"   text="Name" /></th>
								<th><spring:message code="student.email"   text="Email" /></th>
								<th><spring:message code="student.gender"   text="Gender" /></th>
								<th><spring:message code="student.checked"   text="TM Checked" /></th>
								<th></th>
								<th></th>
							</tr>
							<c:forEach var="student" items="${students}">
								<tr class="active approw">
									<td>${student.studentId}</td>
									<td>${student.firstName}  ${student.lastName} </td>
									<td>${student.email}</td>
									<td>${student.gender}</td>
									<td>${student.getNumberTmChecked()}</td>
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