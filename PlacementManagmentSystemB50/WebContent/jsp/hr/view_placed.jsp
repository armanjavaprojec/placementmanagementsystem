<%-- <%@page import="java.util.List"%> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="<%=application.getContextPath() %>/js/jquery.2.1.1.min.js"></script>

</head>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>


	<div class="container">
<%-- 		<% String s =request.getAttribute("jobList"); --%>
<%-- <%-- 		if(s.isEmpty()==true){ out.println("<h1>NO JOBS AVAILABLE</h1>");}else{%> --%>
 		
		<div class="progress" style="height:10px">
  		<div class="progress-bar btn-success" style="width:100%;height:20px"></div>
		</div>
		<button type="button" class="btn btn-primary btn-block btn-lg">Placed Student Details</button><br/><br/>
		<div class="progress" style="height:10px">
  		<div class="progress-bar btn-success" style="width:100%;height:20px"></div>
		</div>
		
		<div class="table-wrapper-scroll-y" style="overflow-x:auto;">
		<table class="table table-bordered ">
			<thead>
				<tr>
					<th>Candidate Name</th>
					<th>Company Name</th>
					<th>City</th>
					<th>Job Role</th>
					<th>Candidate Mail</th>
					<th>Mobile No</th>
					<th>Joining Date</th>
					<th>Bond</th>
					<th>Package</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="placedList" items="${placedList}">
						<tr>
							<td>${placedList.fName}</td>
							<td>${placedList.cName}</td>
							<td>${placedList.location}</td>
							<td>${placedList.jType}</td>
							<td>${placedList.uEmail}</td>
							<td>${placedList.mobile}</td>
							<td>${placedList.joinDate}</td>
							<td>${placedList.bond}</td>
							<td>${placedList.pack}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
		</div>
<%-- 		<%} %> --%>
	</div>
	

 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>