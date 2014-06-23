<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="/iautomech/resources/css/styles.css"
	type="text/css" />
<title>iAutoMech!</title>
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
			Manufacturer<br /> Search Manufacturers by specifying below details.<br/><br/>
			<form:form method="POST" commandName="manufacturer"
				action="search.html">
				<table>
					<tr>
						<td><form:label path="name" for="name">Name:</form:label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="contactName" for="contactName" >Contact Name:</form:label></td>
						<td><form:input path="contactName" /></td>
					</tr>
					<tr>
						<td><form:label path="contactNumber" for="contactNumber" >Contact Number:</form:label></td>
						<td><form:input path="contactNumber" /></td>
					</tr>
					<tr>
						<td><form:button id="search" name="search">Search</form:button></td>
						<td><form:button id="create" name="create">Create</form:button></td>
					</tr>
				</table>
			</form:form>

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