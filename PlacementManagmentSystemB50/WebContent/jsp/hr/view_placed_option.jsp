<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

  
  <script src="<%=application.getContextPath() %>/js/jquery.2.1.1.min.js"></script>

<script>
	$("document").ready(function() {
// 	alert("hi");
		$.get("<%=application.getContextPath()%>/ActionController?option=getAllBatch", function(data) {
			//alert("Welcome in Country"+data)
			var batch = "<option value=' '>select batch</option>";
			$.each(data, function(k, v) {
			//alert("key---"+k+"value---"+v)
				batch += "<option value='"+k+"'>" + v + "</option>";
			});
			$("#batch").html(batch);
		});
	
		$("#batch").change(function() {
// 		alert("hi2")
		  var batch_id=$("#batch").val();
// 		  alert("company id------"+company_id);
// 		  var tab="<table>";
		  var technology ="<thead><tr><th>Technology Name</th><th>Action</th></tr></thead><tbody>";
			$.get("<%=application.getContextPath()%>/ActionController?option=getTech&batchId="+batch_id, function(data) {
				$.each(data, function(k, v) {
				technology=technology+"<tr><td>"+v.techName+"</td><td><a href='../../ViewPlacedController?bid="+batch_id+"&tid="+v.techId+"'><button type='submit' class='btn btn-primary btn-sm'>View Placed</button></a></td></tr>"	
				});
				technology += "</tbody>";
				$("#technology").html(technology);
				
			});
		});	
	});
	
</script>
</head>
<body class="no-skin" style="font-family: verdana">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>
<!-- <form> -->
  <div class="form-group">
  <button type="button" class="btn btn-primary btn-block btn-sm">Select Batch From Given List</button><br/><br/>
  <select class="form-control" id="batch"></select>
  <br/>
  	<button type="button" class="btn btn-primary btn-sm">Available Technologies are ... </button>
  </div>
  <div class="container">
  <table class="table table-bordered thead-dark" id="technology" border="1"></table>
  </div>
  
<!-- </form> -->

 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>