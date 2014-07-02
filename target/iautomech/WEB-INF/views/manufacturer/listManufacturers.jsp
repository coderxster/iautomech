<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="/iautomech/resources/css/styles.css"
	type="text/css" />
<title>List Manufacturer</title>

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
			<c:if test="${manufacturerList ne null}">
				<table class="dataTable">
					<tr>
						<td>Id</td>
						<td>Name</td>
						<td>ContactName</td>
						<td>ContactNumber</td>
					</tr>

					<c:forEach var="manuf" items="${manufacturerList}">
						<tr>
							<td><a href="/iautomech/manufacturer/delete/${manuf.id}">${manuf.id}</a></td>
							<td><c:out value="${manuf.name}" /></td>
							<td><c:out value="${manuf.contactName}" /></td>
							<td><c:out value="${manuf.contactNumber}" /></td>
						</tr>
					</c:forEach>

				</table>

				<table>
					<tr>
						<td><a href="doPaging.html?${query}&page=1">%lt;%lt;</a></td>
						<td><a href="doPaging.html?${query}&page=${page - 1}">%lt;</a></td>
						<td>%nbsp;</td>
						<td><a href="doPaging.html?${query}&page=${page + 1}">%gt;</a></td>
						<td><a href="doPaging.html?${query}&page=last">%gt;%gt;</a></td>						
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