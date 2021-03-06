<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>

		<div class="navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">

					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
						<span class="sr-only"><spring:message code="menu.toggle" text="Toggle navigation"/></span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>

				<!-- Nav Starts -->
						<section>
							<div class="pull-left" style="padding-right:50px">
								<a href="?language=en">English</a>|<a href="?language=kh">ខ្មែរ</a>
							</div>
						</section>
				<div class="navbar-collapse  collapse">
					<ul id="mainMenu" class="nav navbar-nav navbar-right">
						<li><a href="<c:url value="/index"/>"><spring:message code="menu.home" text="Home"/></a></li>
 						<li><a href="addStudent"><spring:message code="menu.login" text="add student"/></a></li>
						<li><a href="addAdvisor"><spring:message code="menu.login" text="add advisor"/></a></li>
						<sec:authorize access ="hasRole('ROLE_USER')">
							<li><a href="requestChecking"><spring:message code="menu.request.checking" text="request TM Checking"/></a></li>
							<li><a href="listChecking"><spring:message code="menu.List.checking" text="List Checking"/></a></li>
						</sec:authorize>
						<sec:authorize access ="hasRole('ROLE_ADMIN')">
							<li><a href="listPendingChecking"><spring:message code="menu.List.checking" text="Pending List"/></a></li>
							<li><a href="listStudents"><spring:message code="menu.List.student" text="Students List"/></a></li>
						</sec:authorize>
						<c:choose>
							<c:when test="${sessionScope.currentUser != null}">
								<li>
									<a href="<c:url value="/logout"/>"><spring:message code="menu.logout" text="Log Out"/></a>
									<a href="<c:url value="/changepassword"/>"><spring:message code="menu.changepassword" text="Change Password"/></a>
								</li>
								<li>
									<span>${sessionScope.currentUser.username}</span>
								</li>
							</c:when>
							<c:otherwise>
								<li><a href="login"><spring:message code="menu.login" text="Log In"/></a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<!-- #Nav Ends -->

			</div>
		</div>
