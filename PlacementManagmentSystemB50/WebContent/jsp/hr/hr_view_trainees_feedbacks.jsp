<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hr page</title>
</head>
<body>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Trainee Feedbacks</b>
		</h4>
	<div class="container">
		<h2 style="color: #448aff; text-align: center;"></h2>
		<table class="table table-bordered">
			<thead>
				<tr class="row-name" style="font-size: 18px; color: #448aff;">
					<th>Sno</th>
					<th>name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>ClientName</th>
					<th>Feedback</th>
					<th>Feedback type</th>
					<th>Date</th>
					<th>location</th>
					<th>city</th>
				</tr>
			</thead>
			<c:if test="${not empty feedbacklist}">
				<c:forEach var="vo" items="${feedbacklist}">
					<tbody>
						<tr>
							<td><c:out value="${vo.sno}"></c:out></td>
							<td><c:out value="${vo.name}"></c:out></td>
							<td><c:out value="${vo.email}"></c:out></td>
							<td><c:out value="${vo.mobno}"></c:out></td>
							<td><c:out value="${vo.clientName}"></c:out></td>
							<td><c:out value="${vo.feedbackMSG}"></c:out></td>
							<td><c:out value="${vo.feedbacktype}"></c:out></td>
							<td><c:out value="${vo.date}"></c:out></td>
							<td><c:out value="${vo.location}"></c:out></td>
							<td><c:out value="${vo.city}"></c:out></td>
	 			</tr>
					</tbody>
				</c:forEach>
			</c:if>
		</table>
	</div>
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>