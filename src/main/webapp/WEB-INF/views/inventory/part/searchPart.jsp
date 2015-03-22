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
		$("#partDataTable").tablesorter({
			widgets : [ 'zebra' ]
		});
	});
	$(document).ready(function() {
		$('#partDataTable tbody tr').click(function() {
			$('#id').val($(this).children('#id').text());
			$('#name').val($(this).children('#name').text());
			$('#sku').val($(this).children('#sku').text());
			$('#modifiedDate').val($(this).children('#modifiedDate').text());
			$('#quantity').val($(this).children('#quantity').text());
			$('#partNo').val($(this).children('#partNo').text());
			$('#modelNo').val($(this).children('#modelNo').text());
			$("select #manufacturer option").each(function() { 
				this.val = (this.text == $('#partDataTable tbody tr').children('#manufacturer').text()); 
				}
			);			
		});
		
		$("#clear").click(function () {
			$('#id').val('');
			$('#name').val('');
			$('#sku').val('');
			$('#modifiedDate').val('');
			$('#quantity').val('');
			$('#partNo').val('');
			$('#modelNo').val('');
			$("select #manufacturer option").each(function() { 
				this.selected = '--Select a Manufacturer --'; 
				}
			);
		});		
		
		$('#name').keyup(function() {
			$.ajax({
				url:'http://localhost:8080/iautomech/rest/inventory/part/search/' + $('#name').val(),
				type: "GET",
				success: function(data){
					$("#sku").val(data.id);
					$("#partNo").val(data.name);
					$("#modelNo").val(data.login);
				},
				error: function(){
					alert('error');					
				}
			})
		});
		
	});
	

</script>
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
			<h3>Search Part</h3>
			<p>Please enter your search criteria in the provided fields
				(where applicable).</p>


			<form:form method="POST" modelAttribute="part" action="search.html">
				<font style="color: red"><c:out value="${message}" /></font>
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td><form:label path="id" for="id">Id</form:label></td>
						<td><form:input id="id" path="id" size="6" /></td>
						<td><form:label path="sku" for="sku">Sku</form:label></td>
						<td><form:input id="sku" path="sku" size="6" /></td>
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
						<td><form:label path="modelNo" for="modelNo">Model No.</form:label></td>
						<td><form:input id="modelNo" path="modelNo" /></td>
						<td><form:label path="partNo" for="partNo">Part No.</form:label></td>
						<td><form:input id="partNo" path="partNo" /></td>
					</tr>
					<tr>
						<td><form:label path="name" for="name">Name</form:label></td>
						<td><form:input id="name" path="name" /></td>
						<td><form:label path="modifiedDate" for="modifiedDate">Modified Date</form:label></td>
						<td><form:input id="modifiedDate" path="modifiedDate"
								type="date" /></td>
					</tr>
					<tr>
						<td><form:label for="manufacturer" path="manufacturer">Manufacturer</form:label></td>
						<td><form:select id="manufacturer" path="manufacturer">
								<option>-- Select a Manufacturer --</option>
								<c:forEach items="${manufacturerList}" var="manuf">
									<c:if test="${part.manufacturer.name eq manuf.name}">
										<option selected="selected" label="${manuf.name}"
											value="${manuf.id}">${manuf.name}</option>
									</c:if>
									<option label="${manuf.name}" value="${manuf.id}">${manuf.name}</option>
								</c:forEach>
							</form:select></td>
						<td><form:label path="quantity" for="quantity">Quantity</form:label></td>
						<td><form:input id="quantity" path="quantity" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Search" /></td>
						<td><input id="clear" type="button" value="Clear" /></td>
					</tr>
				</table>
			</form:form>

			<c:if test="${not empty partList}">

				<form action="delete.html">
					<table id="partDataTable" class="dataTable">
						<thead>
							<tr style="align:center">
								<th></th>
								<th>Id</th>
								<th>Name</th>
								<th>Sku</th>
								<th>Manufacturer</th>
								<th>Modified Date</th>
								<th>Quantity</th>
								<th>Part No.</th>
								<th>Model No.</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="part" items="${partList}" varStatus="counter">
								<tr>
									<td class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}">
										<input type="checkbox" id="selectedIds" name="selectedIds"
										value="${part.id}" />
									</td>
									<td id="id" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.id}" /></td>
									<td id="name" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.name}" /></td>
									<td id="sku" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.sku}" /></td>
									<td id="manufacturer" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.manufacturer.name}" /></td>
									<td id="modifiedDate" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.modifiedDate}" /></td>
									<td id="quantity" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.quantity}" /></td>
									<td id="partNo" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.partNo}" /></td>
									<td id="modelNo" class="${(counter.count % 2 == 0) ? 'rowOdd' : 'rowEven'}"><c:out
											value="${part.modelNo}" /></td>											
								</tr>
							</c:forEach>
						</tbody>
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
		<c:import url="../../footer.jsp" />
	</div>
</body>
</html>