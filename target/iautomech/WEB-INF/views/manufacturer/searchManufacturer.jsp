<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="/iautomech/resources/css/styles.css"
	type="text/css" />
<title>Search Manufacturer</title>

</head>
<body>
	<div class="pageHeading">
		<%-- 		<c:import url="../header.jsp" /> --%>
		iAutoMech
	</div>

	<div class="menuAndContent">
		<div class="menuLeft">
			<c:import url="menuLeft.jsp" />
		</div>

		<div class="content">
			<form:form method="POST" modelAttribute="manufacturer"
				action="search.html">

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
						<td><input type="submit" value="Search" /></td>
					</tr>
				</table>
			</form:form>
						  
			<c:if test="${manufacturerList ne null}">
				<table class="dataTable">
					<tr>
						<td></td>
						<td>Id</td>
						<td>Name</td>
						<td>ContactName</td>
						<td>ContactNumber</td>
					</tr>

					<c:forEach var="manuf" items="${manufacturerList}">
						<tr>
							<td><input id="id" type="checkbox"/></td>
							<td><c:out value="${manuf.id}" /></td>
							<td><c:out value="${manuf.name}" /></td>
							<td><c:out value="${manuf.contactName}" /></td>
							<td><c:out value="${manuf.contactNumber}" /></td>
						</tr>
					</c:forEach>

				</table>
				<input type="submit" value="Delete"/>
			</c:if>
		</div>


		<div class="menuRight">
			<c:import url="menuRight.jsp" />
		</div>
	</div>

	<div class="footer">
		<%-- 		<c:import url="footer.jsp" /> --%>
		FOOTER
	</div>
</body>
</html>