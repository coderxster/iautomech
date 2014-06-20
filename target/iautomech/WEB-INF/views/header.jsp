<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table border="0" cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td colspan="15"><b><font style="font-style:italic; font-size: 26px">iAutoMech</font></b></td>
	</tr>
	<tr>
		<td colspan="15">&nbsp;&nbsp;&nbsp;</td>
	</tr>	
	<tr>
		<td style="padding-left:33px"><a href="/iautomech/inventory/home.html">Inventory</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="">Reference Guides</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="">Work History</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="">Admin</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="">Market</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="">Contact Us</a></td>
		<td>&nbsp;</td>
		<td style="padding-left:33px"><a href="/iautomech/logout.html">Logout</a></td>
		<td valign="bottom" align="right">
			<form:form action="/iautomech/inventory/searchPartNo.html" method="POST"
				commandName="part">
				<form:label path="partNo" for="partNo">Part No.</form:label>
				<form:input size="10" path="partNo" />
				<form:button>Search</form:button>
			</form:form>
		</td>
	</tr>
</table>