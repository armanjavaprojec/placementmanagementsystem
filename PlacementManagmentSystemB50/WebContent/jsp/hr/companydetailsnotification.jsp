<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>company details</h1>
<c:forEach var="job" items="${company}">
<li>
<ul>${job.description}
${job.expectedDate}
${job.vacancies}
</ul>
<ol><!-- 
city.state.country.country -->
${job.clientaddress.client.clientName}
${job.clientaddress.client.clientDescription}
${ job.clientaddress.address.pincode}
${job.clientaddress.address.location}
${job.clientaddress.address.city.city}
${ job.clientaddress.address.city.state.state}
${job.clientaddress.client.companyLevel.level}
</ol>
</li>
</c:forEach>
</body>
</html>