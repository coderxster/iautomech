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
		<c:import url="../../header.jsp" />
	</div>

	<div class="menuAndContent">
		<div class="menuLeft">
			<c:import url="menuLeft.jsp" />
		</div>

		<div class="content">
			<table width="100%">
				<tr>
					<td align="left">
						<h3>Parts</h3>
					</td>
					<td align="right">
					<form:form method="POST"
							action="/iautomech/inventory/part/search.html" commandName="part">
							<form:label for="partNo" path="partNo">Part No.</form:label>
							<form:input id="partNo" path="partNo" />
							<input type="hidden" name="rowsPerPage" value="10" />
							<form:button value="Go">Go</form:button>
						</form:form>
					</td>
				</tr>
			</table>
			<br />Welcome to the Parts section!<br /> <br />
			<p>Here you will be able to do all sorts of Parts related
				activities such as create, search, update and delete.</p>
		</div>


		<div class="menuRight">
			<c:import url="menuRight.jsp" />
		</div>
	</div>

	<div class="footer">
		<c:import url="../../footer.jsp" />
	</div>
</body>
</html>