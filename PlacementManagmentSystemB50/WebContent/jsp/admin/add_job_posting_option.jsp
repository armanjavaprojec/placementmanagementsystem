<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
div#cont {

    width: 1086px;
    }
.form-group {

    width: 1093px;

}

</style>
<script src="<%=application.getContextPath() %>/js/bootstrap.min.js"></script>
  <script src="<%=application.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
  
  <script src="<%=application.getContextPath() %>/js/jquery.2.1.1.min.js"></script>

<script>
	$("document").ready(function() {
//alert("hi");
		$.get("<%=application.getContextPath()%>/GetAllClients?option=getAllClients", function(data) {
			//alert("Welcome in Country"+data)
			var company = "<option value=' '>select company</option>";
			$.each(data, function(k, v) {
			//alert("key---"+k+"value---"+v)
				company += "<option value='"+k+"'>" + v + "</option>";
			});
			$("#company").html(company);
		});
	
		$("#company").change(function() {
//alert("hi2")
		  var company_id=$("#company").val();
		
 //alert("company id------"+company_id);
// 		  var tab="<table class='table table-bordered'>";
		  var locations =" <thead><tr><th>Address</th><th>Pin Code</th><th>City</th><th>State</th><th>Country</th><th>Action</th></tr></thead><tbody>";
			$.get("<%=application.getContextPath()%>/GetAllClients?option=getClientLocations&clientId="+company_id, function(data) {
//alert("Welcome in Locations"+data)
				$.each(data, function(k, v) {
// 				alert("key---"+k+"value---"+v.address+"--------"+v.pinCode+"----"+v.addressId+"---"+v.clientAddressId);
			
			  	locations=locations+"<tr><td>"+v.address+"</td><td>"+v.pinCode+"</td><td>"+v.city+"</td><td>"+v.state+"</td><td>"+v.country+"</td><td><a href='../../jsp/admin/add_posting.jsp?caid="+v.clientAddressId+"'><button type='submit' class='btn btn-primary btn-sm'>Add Job</button></a></td></tr>"	
			
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
<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<!-- write your code here -->
<h4 class="pink"><i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i><b class="blue">Details</b></h4>
<!-- <form> -->
  <div class="container" id="cont">
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
</body>
</html>