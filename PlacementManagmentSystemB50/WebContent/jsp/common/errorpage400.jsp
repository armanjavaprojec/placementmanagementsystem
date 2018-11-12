<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>400 Error</title>
</head>
<body>
<h1 style="color: red;text-align: center;">BAD request</h1>
<div class="error-page-wrap">
		<article class="error-page gradient">
			<hgroup>
				<h1>Internal Error</h1>
				<h1>please try again</h1>
			</hgroup>
			<a href="<%=application.getContextPath()%>/jsp/Login.jsp" title="Back to Home" class="error-back">Home</a>
		</article>
	</div>
<hr>
</body>
</html>