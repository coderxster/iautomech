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
			<h3>Create a Part</h3>
			<p>Please enter the required information below to create a new
				Part</p>
			<br />
			<form:form method="POST" modelAttribute="part" action="create.html">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<font color="green"><c:out value="${message}" /></font>
				<table>
					<tr>
						<td><form:label path="name" for="name">
								<font color="red">*</font>Name</form:label></td>
						<td><form:input id="name" path="name" /></td>
						<td><label><font color="red">*</font>Manufacturer</label></td>
						<td><form:select id="manufacturer" path="manufacturer">
								<option>-- Select a Manufacturer --</option>
								<c:forEach items="${manufacturerList}" var="manuf">
									<option label="${manuf.name}" value="${manuf.id}">${manuf.name}</option>
								</c:forEach>
							</form:select></td>
					</tr>
					<tr>
						<td><form:label path="sku" for="sku">
								<font color="red">*</font>Sku</form:label></td>
						<td><form:input id="sku" path="sku" /></td>
						<td><form:label path="partNo" for="partNo">Part No</form:label></td>
						<td><form:input id="partNo" path="partNo" /></td>
					</tr>
					<tr>
						<td><form:label path="modelNo" for="modelNo">Model No</form:label></td>
						<td><form:input id="modelNo" path="modelNo" /></td>
						<td><form:label path="quantity" for="quantity">Quantity</form:label></td>
						<td><form:input id="quantity" path="quantity" /></td>
					</tr>
					<tr>
						<td><form:label path="description" for="description">Description</form:label></td>
						<td><form:textarea cols="30" rows="5" id="description"
								path="description" /></td>
					</tr>
					<tr>

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