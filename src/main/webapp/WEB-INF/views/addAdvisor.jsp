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
				  <form action="advisors" method="post">
					<div class="row">
					   <table>
					     <tr>
						    <td>Advisor ID</td><td><input type=text name="advisorid"></td>
					     </tr>
					     <tr>
						    <td>First Name</td><td><input type=text name="firstname"></td>
						</tr>
						<tr>
						    <td>Last Name</td><td><input type=text name="lastname" ></td>
						</tr>
						<tr>
						    <td>Email</td><td><input type=text name="email"></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>
							<select name="gender">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
							</td>
						</tr>
						<tr>
							<td>Address</td>
							<td></td>
						</tr>
						<tr>
							<td>Street</td><td><input type=text name="street"></td>
						</tr>
						<tr>
							<td>City</td><td><input type=text name="city"></td>
						</tr>
						<tr>
							<td>State</td><td><input type=text name="state"></td>
						</tr>
						<tr>
							<td>zipCode</td><td><input type=text name="zipCode"></td>
						</tr>
						<tr>
                             <td><input type=submit value="Submit"></td><td><input type=button value="Cancel"></td>
                        </tr>
                        </table>
					</div>
				</form>
				</div>
			</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>