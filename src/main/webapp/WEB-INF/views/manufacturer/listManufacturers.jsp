<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Manufacturer</title>

</head>
<body>

	<c:if test="${manufacturerList ne null}">
		<table>
			<tr>
				<td>Name</td>
				<td>ContactName</td>
				<td>ContactNumber</td>
			</tr>

			<c:forEach var="manuf" items="${manufacturerList}">
				<tr>
					<td><c:out value="${manuf.name}" /></td>
					<td><c:out value="${manuf.contactName}" /></td>
					<td><c:out value="${manuf.contactNumber}" /></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>