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
		<c:import url="../header.jsp" />
	</div>

	<div class="menuAndContent">
		<div class="menuLeft">
			<c:import url="menuLeft.jsp" />
		</div>

		<div class="content">
			<h3>Confirm Delete</h3>
			<p>
				Please confirm you wish to delete the following manufacturers: <br />
			<table class="dataTable">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>ContactName</th>
					<th>ContactNumber</th>
				</tr>

				<c:forEach var="manuf" items="${manufacturersToDelete}"
					varStatus="counter">
					<tr>
						<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
								value="${manuf.id}" /></td>
						<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
								value="${manuf.name}" /></td>
						<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
								value="${manuf.contactName}" /></td>
						<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
								value="${manuf.contactNumber}" /></td>
					</tr>
				</c:forEach>
			</table>

			<table>
				<tr>
					<td>
						<form action="deleteConfirmed.html">
							<input type="submit" value="Delete" />
						</form>
					</td>
					<td>
						<form action="searchForm.html">
							<input type="submit" value="Cancel" />
						</form>
					</td>
				</tr>
			</table>
		</div>


		<div class="menuRight">
			<c:import url="menuRight.jsp" />
		</div>
	</div>

	<div class="footer">
		<c:import url="../footer.jsp" />
	</div>
</body>
</html>