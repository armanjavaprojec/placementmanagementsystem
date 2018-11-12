<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script>
	$("document").ready(function() {
		$.get("<%=application.getContextPath()%>/GetAllClients?option=getAllClients", function(data) {
			var company = "<option value=' '>select company</option>";
			$.each(data, function(k, v) {
				company += "<option value='"+k+"'>" + v + "</option>";
			});
			$("#company").html(company);
		});
	
		$("#company").change(function() {
		  var company_id=$("#company").val();
		  var locations =" <thead><tr><th>Address</th><th>Pin Code</th><th>City</th><th>State</th><th>Country</th><th>Action</th></tr></thead><tbody>";
			$.get("<%=application.getContextPath()%>/GetAllClients?option=getClientLocations&clientId="+company_id, function(data) {
				$.each(data, function(k, v) {
			  	locations=locations+"<tr><td>"+v.address+"</td><td>"+v.pinCode+"</td><td>"+v.city+"</td><td>"+v.state+"</td><td>"+v.country+"</td><td><a href='../../jsp/hr/add_posting.jsp?caid="+v.clientAddressId+"'><button type='submit' class='btn btn-primary btn-sm'>Add Job</button></a></td></tr>"	
				});
				locations=locations+"</tbody>"
				$("#locations").html(locations);
			});
		});	
	});
	
</script>
<style type="text/css">
	div form{font-family: Verdana;background-image: url("images/code.jpg")}
</style>
</head>
<body class="no-skin" style="font-family: verdana;">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>
<!-- <form> -->
  <div class="container">
  <div class="form-group">
  <button type="button" class="btn btn-primary btn-block btn-sm">Select Company From Given List</button><br/><br/>
  <select class="form-control" id="company"></select>
  <br/>
	  <button type="button" class="btn btn-primary btn-sm">Company Locations are ... </button>
  </div>
  
  <table class="table table-bordered" id="locations" border="1"></table>
<!-- </form> -->

 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</div>

<script src="<%=application.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<script src="<%=application.getContextPath() %>/js/bootstrap.min.js"></script>

</body>
</html>