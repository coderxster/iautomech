<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="/iautomech/resources/css/styles.css"
	type="text/css" />
<title>Create Part</title>

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
			<form:form method="POST" modelAttribute="part" action="create">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td><form:label path="name" for="name">Name</form:label></td>
						<td><form:input id="name" path="name" /></td>
					</tr>
					<tr>
						<td><form:label path="sku" for="sku">Sku</form:label></td>
						<td><form:input id="sku" path="sku" /></td>
					</tr>
					<tr>
						<td><form:label path="manufacturer" for="manufacturer">Manufacturer</form:label></td>
						<td><form:select path="manufacturer">
						<form:option value="${manufacturer.name}"></form:option>
<%-- 								<form:options items="${manufacturerList}" itemLabel="name" itemValue="id"/> --%>
							</form:select></td>
					</tr>
					<tr>
						<td><input type="submit" value="Create" /></td>
					</tr>
				</table>

			</form:form>
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