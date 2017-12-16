<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form action="addStudent" method="post">
                    <table>
                        <tr>
                            <td>First Name</td>
                            <td><input type="text" name="firstName"></td>
                        </tr>
                        <tr>
                            <td>Last Name</td>
                            <td><input type="text" name="lastName"></td>
                        </tr>
                        <tr>
                            <td>Student Id</td>
                            <td><input type="text" name="studentId"></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><input type="email" name="email"></td>
                        </tr>

                        <tr>
                            <td>Street</td>
                            <td><input type="text" name="studentAddress.street"></td>
                        </tr>
                        <tr>
                            <td>City</td>
                            <td><input type="text" name="studentAddress.city"></td>
                        </tr>
                        <tr>
                            <td>State</td>
                            <td><input type="text" name="studentAddress.state"></td>
                        </tr>
                        <tr>
                            <td>Zip Code</td>
                            <td><input type="text" name="studentAddress.zipCode"></td>
                        </tr>

                        <tr><td>Gender</td></tr>
                        <tr>
                            <td><input type="radio" name="gender" value="male" checked> Male</td>
                            <td><input type="radio" name="gender" value="female"> Female</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Register"></td>
                        </tr>

                    </table>

                </form>

                    <%--<h3><spring:message code="home.about.us" text="test"/></h3>--%>
                <p>
                </p>

            </div>
        </div>
    </div>
    </tiles:putAttribute>
    </tiles:insertDefinition>
</html>
