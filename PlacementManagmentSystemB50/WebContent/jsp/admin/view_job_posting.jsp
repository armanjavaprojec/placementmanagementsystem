<%-- <%@page import="java.util.List"%> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<style type="text/css">
  
 div#cont {

    width: 1086px;
}
</style>

<script src="<%=application.getContextPath() %>/js/jquery.2.1.1.min.js"></script>

</head>
<body class="no-skin">
<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>


	<div class="container" id="cont">
<%-- 		<% String s =request.getAttribute("jobList"); --%>
<%-- <%-- 		if(s.isEmpty()==true){ out.println("<h1>NO JOBS AVAILABLE</h1>");}else{%> --%>
 		
		<div class="progress" style="height:10px">
  		<div class="progress-bar btn-success" style="width:100%;height:20px"></div>
		</div>
		<button type="button" class="btn btn-primary btn-block btn-lg">Job Posting Details For Selected Location ....</button><br/><br/>
		<div class="progress" style="height:10px">
  		<div class="progress-bar btn-success" style="width:100%;height:20px"></div>
		</div>
		
		<div class="table-wrapper-scroll-y" style="overflow-x:auto;">
		<table class="table table-bordered ">
			<thead>
				<tr>
					<th>Client Name</th>
					<th>Location</th>
					<th>CP Name</th>
					<th>CP Mobile</th>
					<th>CP Email</th>
					<th>Description</th>
					<th>Expected Date</th>
					<th>Posted Date</th>
					<th>No Of Vacancies</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="jobList" items="${jobList}">
						<tr>
							<td>${jobList.clientName}</td>
							<td>${jobList.location}</td>
							<td>${jobList.cpName}</td>
							<td>${jobList.cpMobile}</td>
							<td>${jobList.cpEmail}</td>
							<td>${jobList.description}</td>
							<td>${jobList.expDate}</td>
							<td>${jobList.postDate}</td>
							<td>${jobList.noOfVacancies}</td>
							<td>
									<div><a href="<%=application.getContextPath() %>/jsp/admin/update_posting.jsp?id=${jobList.jobPostingId}&desc=${jobList.description}&expDate=${jobList.expDate}&postDate=${jobList.postDate}&vacancies=${jobList.noOfVacancies}"><button type="submit" class="btn btn-primary btn-sm btn-block" >Edit</button></a></div>
									<div><a href="<%=application.getContextPath() %>/DeleteJobPostingController?jid=${jobList.jobPostingId}"><button type="submit" class="btn btn-danger btn-sm btn-block" >Delete</button></a></div>
									<div><a href="<%=application.getContextPath() %>/jsp/admin/add_round.jsp?jobid=${jobList.jobPostingId}&client=${jobList.clientName}"><button type="button" class="btn btn-primary btn-sm btn-block" >Maintain-Rounds</button></a></div>
							</td>
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