<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Employee Information</h2>
 
<c:if test="${SUCCESS_MESSAGE != null}">
  <div id="status_message">${SUCCESS_MESSAGE}</div>
</c:if> 
<form:form method="POST" action="/springmvc/addEmployee" commandName="employee">
   <table>
   
    <c:if test="${!empty employee.name}">
    <tr>
        <td>
            <form:label path="person_id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="person_id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="person_id" />
        </td> 
    </tr>
    </c:if>
    
    
    <tr>
        <td><form:label path="">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="departmentName">Dept</form:label></td>
        <td><form:input path="departmentName" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <c:if test="${!empty employee.name}">
                <input type="submit"
                    value="Edit Employee" />
            </c:if>
            <c:if test="${empty employee.name}">
                <input type="submit"
                    value="Add Employee" />
            </c:if>
    </tr>
</table>  
</form:form>


	<h2>Employee List</h2>
 
	<c:if test="${not empty list}">
 
	   <table>
	   <tr>
	   <th>Name</th><th>Dept</th> <th>Country</th> <th>Edit</th> <th>Delete</th></tr>
	   <c:forEach var="emp" items="${list}">
				<tr><td>${emp.name} </td>
				<td>${emp.departmentName}</td>
				<td>${emp.country}</td>
            	<td><a href="<c:url value='/edit/${emp.person_id}' />" >Edit</a></td>
            	<td><a href="<c:url value='/remove/${emp.person_id}' />" >Delete</a></td>
				</tr>
			</c:forEach>
			
	   </table>
			
		 
 
	</c:if>
	
 
</body>
</html>