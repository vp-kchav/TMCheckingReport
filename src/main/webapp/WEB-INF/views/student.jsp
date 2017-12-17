<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
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
                <form:form modelAttribute="student" action="studentRegistration" method="post">
                    <table class="studentregister">
                        <tr>
                            <td>First Name</td>
                            <td><form:input type="text" path="firstName"/></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td><form:input type="text" path="lastName"/></td>
                        </tr>
                        <tr>
                            <td>Student Id</td>
                            <td><form:input type="text" path="studentId"/></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><form:input type="email" path="email"/></td>
                        </tr>
                        <tr>
                            <td>Street</td>
                            <td><form:input type="text" path="studentAddress.street"/></td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><form:input type="text" path="studentAddress.city"/></td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td><form:input type="text" path="studentAddress.state"/></td>
                        </tr>
                        <tr>
                            <td>Zip Code</td>
                            <td><form:input type="text" path="studentAddress.zipCode"/></td>
                        </tr>
                        <tr>
                            <td> Gender</td>
                        </tr>
                        <tr>
                            <td><form:radiobutton path="gender" value="M" /> Male</td>
                            <td><form:radiobutton path="gender" value="F"/> Female</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Register"></td></tr>
                    </table>



                </form:form>

                    <%--<h3><spring:message code="home.about.us" text="test"/></h3>--%>
                <p>
                </p>

            </div>
        </div>
    </div>
    </tiles:putAttribute>
    </tiles:insertDefinition>
</html>
