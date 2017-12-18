<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
	<!-- banner -->
	<div class="container">
		<div class="spacer">
			<div class="row register">
				<div class="col-lg-6 col-lg-offset-3 col-sm-6 col-sm-offset-3 col-xs-12 ">
					<c:if test="${not empty msg}">
						<div class="alert alert-danger alert-dismissable">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>${msg}
						</div>
					</c:if>
					<form method="POST" action="login">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Enter Name" name="studentId" required="required">
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password" name="password" required="required">
						</div>
						<div class="form-group">
			    			<input type='checkbox'  name="remember-me" />Remember Me? <br/>	
			    		</div>
						<button type="submit" class="btn btn-success" name="Submit">Login</button>
						<div class="form-group">
						</div>
						<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>