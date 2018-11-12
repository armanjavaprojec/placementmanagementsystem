<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%application.getContextPath(); %>css/bootstrap.min.css">
</head>
<body class="no-skin" style="font-family: verdana">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>
<form method="get" action="<%=application.getContextPath()%>/AddJobPostingController">
<div class="progress" style="height:10px">
<div class="progress-bar" style="width:100%;height:20px"></div>
</div>
<div class="alert alert-success">
<strong>Add JOB Posting ! </strong> Provide Below Details  to add a JOB Posting ...
</div>
  <div class="form-group">
    <label>Job Description</label><br>
    <% String caid = request.getParameter("caid"); System.out.println(caid);%>
    <input type="hidden" name="caid" value="<%=caid%>">
    <textarea rows="4" cols="50" name="jobDesc" placeholder="Please provide :- YOP, Percentage, Degree, Specialization, Location, Package, Stream and other necessary details ..."></textarea>
  </div>
 
  <div class="form-group">
    <label>Expected Date</label>
    <input type="date" class="form-control" name="jobExpDate" required>
  </div>
 
  <div class="form-group">
    <label>Posted Date</label>	
    <%
        LocalDate cuDate=LocalDate.now();
    	request.setAttribute("currentDate", cuDate);
    %>
    <input type="date" class="form-control" name="jobPostDate" value="<%=request.getAttribute("currentDate") %>" readonly required >
    </div>
 
  <div class="form-group">
    <label>No Of Vacancies</label>
    <input type="text" class="form-control" name="noOfVacan" required>
  </div> 
 
  <button class="btn btn-danger" type="submit">Add Job</button>	
</form>
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->

<script src="<%application.getContextPath(); %>/js/jquery-3.3.1.min.js"></script>
<script src="<%application.getContextPath(); %>/js/bootstrap.min.js"></script>
</body>
</html>