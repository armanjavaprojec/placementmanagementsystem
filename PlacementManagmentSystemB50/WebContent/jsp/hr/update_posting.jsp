<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<%=application.getContextPath() %>/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="no-skin" style="font-family: verdana">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>


<form method="get" action="<%=application.getContextPath() %>/UpdateJobPostingController">

	<div class="progress" style="height:10px">
  		<div class="progress-bar" style="width:100%;height:20px"></div>
	</div>

	<div class="alert alert-success">
  		<strong>Update JOB Posting ! </strong> Provide Below Details  to update a JOB Posting ...
	</div>
	

 	<% String pid = request.getParameter("id"); %>
 	<input type="hidden" name="jobPostId" value="<%=pid%>">
  <div class="form-group">
    <label for="exampleInputEmail1">Job Description</label><br>
    <textarea rows="5" cols="50"  name ="jobDesc1" ><%=request.getParameter("desc") %></textarea>
<%--     <input type="text" class="form-control" required name ="jobDesc1" value="<%=request.getParameter("desc") %>"> --%>
  </div>
 
  <div class="form-group">
    <label for="exampleInputEmail1">Expected Date</label>
    <%
	    String ds1 = (String)request.getParameter("expDate");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String ds2 = sdf2.format(sdf1.parse(ds1));
    %>
    <input type="date" class="form-control" required name="jobExpDate1" value= "<%=ds2%>">
  </div>
 	
  <div class="form-group">
    <label for="exampleInputEmail1">Posted Date</label>
    <%
        LocalDate cuDate=LocalDate.now();
    	request.setAttribute("currentDate", cuDate);
    %>
    <input type="date" class="form-control" readonly name="jobPostDate1" value="<%=cuDate%>">
  </div>
 
  <div class="form-group">
    <label for="exampleInputEmail1">No Of Vacancies</label>
    <input type="text" class="form-control" required name="noOfVacan1" value="<%=request.getParameter("vacancies") %>">
  </div> 
 
  <button type="submit" class="btn btn-danger" >Update Job</button>
  
</form>

 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->

  <script src="<%=application.getContextPath() %>/js/bootstrap.min.js"></script>
<script src="<%=application.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
</body>
</html>