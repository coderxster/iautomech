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
			<h3>Search Manufacturers</h3>
			<p>Please enter your search criteria in the provided fields (where applicable).</p>
			
			
			<form:form method="POST" modelAttribute="manufacturer"
				action="search.html">
				<font style="color:red"></font><c:out value="${message}" /></font>
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

				<form action="delete.html">
					<table class="dataTable">
						<tr>
							<th></th>
							<th>Id</th>
							<th>Name</th>
							<th>ContactName</th>
							<th>ContactNumber</th>
						</tr>

						<c:forEach var="manuf" items="${manufacturerList}"
							varStatus="counter">
							<tr>
								<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}">
									<input type="checkbox" id="selectedIds" name="selectedIds" value="${manuf.id}"/>
								</td>
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
					<input type="submit" value="Delete"/>
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