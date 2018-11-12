<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="<%=application.getContextPath() %>/js/jquery.2.1.1.min.js"></script>

</head>
<body class="no-skin" style="font-family: verdana">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>

<form method="get" action="<%=application.getContextPath() %>/AddBatchController">

 <div class="progress" style="height:10px">
  <div class="progress-bar" style="width:100%;height:20px"></div>
</div>

<div class="alert alert-success">
  <strong>Add New Batch ! </strong> Provide Below Details  to add a new Batch ...
</div>

  <div class="form-group">
    <label>Batch Name</label>
    <input type="hidden" name="sid" value="1">
    <input type="text" class="form-control" name ="bname" required data-minlength="6" id="inputPassword" pattern=".{5,10}"  title="10 to 100 characters">
  </div>
 
  <div class="form-group">
    <label>Start Date</label>
    <input type="date" class="form-control" name="sdate" required>
  </div>
 
  <div class="form-group">
    <label>End Date</label>	
    <input type="date" class="form-control" name="edate" required >
    </div>
 
  <button class="btn btn-danger" type="submit">Add Batch</button>	
  
</form>


 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>