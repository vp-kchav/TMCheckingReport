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
						<form:form modelAttribute="advisor" action="../advisordetail/${advisor.id}" method="post">
							<form:errors path="*" cssClass="ui-state-error" element="div"/>
							<table class="table table-hover">
								<tr>
									<td>Advisor ID:</td>
									<td><form:input type="text" path="advisorid" value="${advisor.advisorid}" /></td>
									<td><form:errors path="advisorid" cssClass="ui-state-error" /></td>
							    </tr>
							    <tr>
									<td>First Name:</td>
									<td><form:input type="text" path="firstname" value="${advisor.firstname}" /></td>
									<td><form:errors path="firstname" cssClass="ui-state-error"/></td>
							    </tr>
							    <tr>
									<td>Last Name:</td>
									<td><form:input type="text" path="lastname" value="${advisor.lastname}" /> </td>
									<td><form:errors path="lastname" cssClass="ui-state-error"/></td>
								</tr>
								<tr>
									<td>Gender:</td>
									<td>
									   <form:select path="gender">
	   									  <form:options/>
									   </form:select>
									</td>
								</tr>
								<tr>
									<td>Email:</td>
									<td><form:input type="text" path="email" value="${advisor.email}" /> </td>
									<td><form:errors path="email" cssClass="ui-state-error"/></td>
								</tr>
								<tr>
									<td>Street:</td>
									<td><form:input type="text" path="address.street" value="${advisor.address.street}" /> </td>
									<td><form:errors path="address.street" cssClass="ui-state-error"/></td>
								</tr>
								<tr>
									<td>City:</td>
									<td><form:input type="text" path="address.city" value="${advisor.address.city}" /> </td>
									<td><form:errors path="address.city" cssClass="ui-state-error"/></td>
								</tr>
								<tr>
									<td>State:</td>
									<td><form:input type="text" path="address.state" value="${advisor.address.state}" /> </td>
									<td><form:errors path="address.state" cssClass="ui-state-error"/></td>
								</tr>
								<tr>
									<td>Zip Code:</td>
									<td><form:input type="text" path="address.zipCode" value="${advisor.address.zipCode}" /> </td>
									<td><form:errors path="address.zipCode" cssClass="ui-state-error"/></td>
								</tr>
							</table>
							<p align=center><input type="submit" value="Submit"/></p>
						</form:form>
					</div>
				</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>