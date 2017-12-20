<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<tiles:insertDefinition name="baseLayout">
	<tiles:putAttribute name="body">
		<div class="container">
			<div class="spacer">
				<div class="row"><br/>
					<p style="font-size:30px"><spring:message code="changepassword" text="Change Password"/> </p>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<form method="post" id="passwordForm" action="changepassword">
						<input type="password" class="input-lg form-control"
							name="password" path="password"  id="password1" placeholder="New Password"
							autocomplete="off">
						<div class="row">
							<div class="col-sm-6">
								<span id="8char" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> 8 Characters Long<br> <span
									id="ucase" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Uppercase Letter
							</div>
							<div class="col-sm-6">
								<span id="lcase" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Lowercase Letter<br> <span
									id="num" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> One Number
							</div>
						</div>
						<input type="password" class="input-lg form-control"
							name="password2" id="password2" placeholder="Repeat Password"
							autocomplete="off">
						<div class="row">
							<div class="col-sm-12">
								<span id="pwmatch" class="glyphicon glyphicon-remove"
									style="color: #FF0004;"></span> Passwords Match
							</div>
						</div>
						<input type="submit" disabled="disabled"  id="submit"
							class="col-xs-12 btn btn-primary btn-load btn-lg"
							data-loading-text="Changing Password..." value="Change Password">
					</form>
				</div>
				<!--/col-sm-6-->
			</div>
			<!--/row-->
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
</html>