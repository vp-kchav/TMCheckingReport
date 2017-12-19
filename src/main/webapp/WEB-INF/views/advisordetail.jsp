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
						<h3>Update Advisor</h3>
						<form action="../advisordetail/${advisor.id}" method="post">
						<table class="table table-hover">
							<tr>
								<td>Advisor ID:</td>
								<td><input type="text" name="advisorid" value="${advisor.advisorid}" />
								</td>
							</tr>
							<tr>
								<td>First Name:</td>
								<td><input type="text" name="firstname" value="${advisor.firstname}" /> </td>
							</tr>
							<tr>
								<td>Last Name:</td>
								<td><input type="text" name="lastname" value="${advisor.lastname}" /> </td>
							</tr>
							<%-- <tr>
								<td>Gender:</td>
								<td><input type="text" name="color" value="${advisor.gender}" /> </td>
								<td>
								<form:select path="genderList" multiple="false" size="1">
								<form:options items="${genderList}" itemValue="gender" itemLabel="gender"/>
								</form:select>
								
								</td>
							</tr> --%>
							<tr>
								<td>Email:</td>
								<td><input type="text" name="email" value="${advisor.email}" /> </td>
							</tr>
							<tr>
								<td>Street:</td>
								<td><input type="text" name="address.street" value="${advisor.address.street}" /> </td>
							</tr>
							<tr>
								<td>City:</td>
								<td><input type="text" name="address.city" value="${advisor.address.city}" /> </td>
							</tr>
							<tr>
								<td>State:</td>
								<td><input type="text" name="address.state" value="${advisor.address.state}" /> </td>
							</tr>
							<tr>
								<td>Zip Code:</td>
								<td><input type="text" name="address.zipCode" value="${advisor.address.zipCode}" /> </td>
							</tr>
						</table>
						<p align=center><input type="submit" value="Update"/></p>
						</form>
					</div>
				</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>