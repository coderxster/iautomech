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
<link href="http://mottie.github.io/tablesorter/css/theme.default.css"
	rel="stylesheet">

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>

<script>
	$(function() {
		$("#manufDataTable").tablesorter({
			widgets : [ 'zebra' ]
		});
	});
</script>
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
			<h3>Search Part</h3>
			<p>Please enter your search criteria in the provided fields
				(where applicable).</p>


			<form:form method="POST" modelAttribute="part"
				action="search.html">
				<font style="color: red"><c:out value="${message}" /></font>
				<table>
					<tr>
						<td><form:label path="name" for="name">Name</form:label></td>
						<td><form:input id="name" path="name" /></td>
						<td>&nbsp;</td>
						<td><c:out value="Results per page" /></td>
						<td><select name="rowsPerPage">
								<c:if test="${rowsPerPage eq 5}">
									<option value="5" selected="selected">5</option>
								</c:if>
								<c:if test="${rowsPerPage ne 5}">
									<option value="5">5</option>
								</c:if>
								<c:if test="${rowsPerPage eq 10}">
									<option value="10" selected="selected">10</option>
								</c:if>
								<c:if test="${rowsPerPage ne 10}">
									<option value="10">10</option>
								</c:if>
								<c:if test="${rowsPerPage eq 20}">
									<option value="20" selected="selected">20</option>
								</c:if>
								<c:if test="${rowsPerPage ne 20}">
									<option value="20">20</option>
								</c:if>
								<c:if test="${rowsPerPage eq 50}">
									<option value="50" selected="selected">50</option>
								</c:if>
								<c:if test="${rowsPerPage ne 50}">
									<option value="50">50</option>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<td><form:label path="sku" for="sku">Sku</form:label></td>
						<td><form:input id="sku" path="sku" /></td>
					</tr>
					<tr>
						<td><form:label path="modifiedDate" for="modifiedDate">Modified Date</form:label></td>
						<td><form:input id="modifiedDate" path="modifiedDate" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Search" /></td>
					</tr>
				</table>
			</form:form>


			<c:if test="${partList ne null}">

				<form action="delete.html">
					<table id="partDataTable" class="dataTable">
						<thead>
							<tr>
								<th></th>
								<th>Id</th>
								<th>Name</th>
								<th>Sku</th>
								<th>Modified Date</th>
							</tr>
						</thead>
						<c:forEach var="part" items="${partList}"
							varStatus="counter">
							<tr>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}">
									<input type="checkbox" id="selectedIds" name="selectedIds"
									value="${part.id}" />
								</td>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
										value="${part.id}" /></td>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
										value="${part.name}" /></td>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
										value="${part.sku}" /></td>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
										value="${part.modifiedDate}" /></td>
							</tr>
						</c:forEach>

					</table>
					<input type="submit" value="Delete" />
				</form>

				<table>
					<tr>
						<c:if test="${page gt 1}">
							<td><a href="doPaging.html?${query}&page=1">&lt;&lt;</a></td>
							<td>&nbsp;</td>
							<td><a href="doPaging.html?${query}&page=${page - 1}">&lt;</a></td>
						</c:if>
						<c:if test="${page eq 1}">
							<td>&lt;&lt;</td>
							<td>&nbsp;</td>
							<td>&lt;</td>
						</c:if>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>Page ${page} of ${maxpage}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<c:if test="${page lt maxpage}">
							<td><a href="doPaging.html?${query}&page=${page + 1}">&gt;</a></td>
							<td>&nbsp;</td>
							<td><a href="doPaging.html?${query}&page=${maxpage}">&gt;&gt;</a></td>
						</c:if>
						<c:if test="${page eq maxpage}">
							<td>&gt;</td>
							<td>&nbsp;</td>
							<td>&gt;&gt;</td>
						</c:if>
					</tr>
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