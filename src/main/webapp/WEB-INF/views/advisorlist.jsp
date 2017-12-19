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
			<div class="container">
				<div class="spacer">
					<div class="row">					   
					     <table class="table" >
					    <tr>
					        <th>Advisor ID</th>
					        <th>First Name</th>
					        <th>Last Name</th>
					        <th>Gender</th>
					        <th>Email</th>
					        <th>Street</th>
					        <th>City</th>
					        <th>State</th>
					        <th>Zip Code</th>
					    </tr>
					<c:forEach var="advisor" items="${advisorlist}">
					    <tr>
							<td>${advisor.advisorid}</td>
					    	<td>${advisor.firstname}</td>
					        <td>${advisor.lastname}</td>
					       <%--  <td>${advisor.gender}</td>--%>
					    	<td>${advisor.email}</td>
					        <td>${advisor.address.street}</td> 
					        <td>${advisor.address.city}</td>
					    	<td>${advisor.address.state}</td>
					        <td>${advisor.address.zipCode}</td>   
					    	<td>
					            <a href='advisordetail/${advisor.id}'>Edit</a>
					            <a href="deleteadvisor/${advisor.id}">Delete</a>
					        </td>
					    </tr>
					</c:forEach>
					</table>
					</div>
				</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>