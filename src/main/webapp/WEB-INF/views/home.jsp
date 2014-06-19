<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<c:import url="header.jsp" />
	</div>

	<div class="menuAndContent">
		<div class="menuLeft">
			<c:import url="menuLeft.jsp" />
		</div>

		<div class="content">
			Welcome <font color="blue"><c:out
					value="${sessionScope.user.name}" /></font>!<br/>

			<!-- THE HOME PAGE VIDEO COULD BE DYNAMIC - JUST GET YOUTUBE 
			URL FROM DB OR SOMETHING AND AS BELOW AS A PARAM -->
			<iframe title="YouTube video player" class="youtube-player"
				type="text/html" width="640" height="390"
				src="http://www.youtube.com/embed/W-Q7RMpINVo" frameborder="0"
				allowFullScreen></iframe>
		</div>

		<div class="menuRight">
			<c:import url="menuRight.jsp" />
		</div>
	</div>

	<div class="footer">
		<c:import url="footer.jsp" />
	</div>
</body>
</html>