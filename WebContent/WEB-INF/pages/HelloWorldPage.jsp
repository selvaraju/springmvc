<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body> 
 
 
  


	<h2>Employee List</h2>
 
	<c:if test="${not empty list}">
 
	   <table>
	   
	   <th>Name</th><th>Dept</th>
	   <c:forEach var="listValue" items="${list}">
				<tr><td>${listValue.name} </td><td>${listValue.departmentName}</td></tr>
			</c:forEach>
			
	   </table>
			
		 
 
	</c:if>
 
</body>
</html>