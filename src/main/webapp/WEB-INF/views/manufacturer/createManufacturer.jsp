<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Manufacturer</title>

</head>
<body>

	<form:form method="POST" modelAttribute="manufacturer" action="create">

		<table>
			<tr>
				<td><form:label path="name" for="name">Name</form:label></td>
				<td><form:input id="name" path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="contactName" for="contactName">Contact Name</form:label></td>
				<td><form:input id="contactName" path="contactName" /></td>
			</tr>
			<tr>
				<td><form:label path="contactNumber" for="contactNumber">Contact Number</form:label></td>
				<td><form:input id="contactNumber" path="contactNumber" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create"/></td>
			</tr>			
		</table>

	</form:form>

</body>
</html>