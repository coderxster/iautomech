<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="StyleSheet" href="/imechano/resources/css/styles.css" type="text/css" />
<title>iMechano!</title>
</head>

<body>
	<div class="pageHeading">
	<!-- BEST ONLY TO HAVE ONE HEADER - AND NOT A SEPERATE ONE FOR THE LOGIN PAGE -->
		<c:import url="loginHeader.jsp" />
	</div>

	<div class="menuAndContent">

		<div class="content" align="center">
			<font style='color:red;'><c:out value="${message}"/></font>			
			<form:form action="/imechano/authenticate.html" commandName="user" method="POST">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td><form:label for="username" path="username">Username:</form:label></td>
						<td><form:input path="username" /></td>
					</tr>
					<tr>
						<td><form:label for="password" path="password">Password:</form:label></td>
						<td><form:password path="password" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="right"><form:button name="loginBtn">Login</form:button></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

	<div class="footer">
		<c:import url="footer.jsp" />
	</div>


</body>
</html>