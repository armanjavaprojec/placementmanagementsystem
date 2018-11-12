<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
<link rel="icon" type="image/png" href="images/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<title>Client</title>
<!-- <link href="../../css/bootstrap.min.css" rel="stylesheet" /> -->
<!-- <link href="../../css/gsdk-bootstrap-wizard.css" rel="stylesheet" />
<link href="../../css/demo.css" rel="stylesheet" /> -->
 <script src="<%=application.getContextPath() %>/js/bootstrap.min.js"></script>
  <script src="<%=application.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
<style type="text/css">
.table-striped>tbody>tr:nth-of-type(odd) {
	background-color: #00a1ff !important;
	color: #FFF !important;
	font-size: 13px !important;
	font-family: 'Roboto', sans-serif;
	font-weight: 500 !important;
}

tr.even {
	background: #bfbfbf !important;
	color: #000 !important;
	font-size: 13px !important;
	font-weight: 500 !important;
	font-family: 'Roboto', sans-serif;
}
/* 
.page-content {
    height: 480px;
} */

button.btn.btn-primary {
    margin-left: -58px;
}
</style>

<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
var client_id;
function checkClientName()
{	
	
	var sp_First=document.getElementById("sp_ClientName");
    var div_first=document.getElementById("div_ClientName");
	
    var first=document.getElementById("id_client_name");
    var vfirst=first.value;
	vfirst=vfirst.trim();
	var letter=/^[a-zA-Z ]+$/;
	
	if(vfirst == "")
	{
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="438px";
		return false;
	}
	if(!first.value.match(letter)){
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="438px";
		return false;
	}
	else
	{
		first.style="border-color: green;";
		//first.style.width="438px";
		div_first.className='form-group has-success has-feedback';
		sp_First.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
}
	function checkDescription() {
		var spadd=document.getElementById("sp_desctiption");
	    var divadd=document.getElementById("div_desctiption")
		
	    var add=document.getElementById("id_client_description");
	    var vadd=add.value;
		vadd=vadd.trim();
		//var letter=/^[a-zA-Z]+$/;
		
		if(vadd == "")
		{
			add.style= "border-color: red;";
			divadd.className='form-group has-error has-feedback';
			spadd.className='glyphicon glyphicon-remove form-control-feedback';
			//add.style.width="438px";
			return false;
		}
		else
		{
			add.style="border-color: green;";
			//add.style.width="438px";
			divadd.className='form-group has-success has-feedback';
			spadd.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}
	}
	 
	
	function validateLevel()
	 { 
	 	var spstream1=document.getElementById("sp_stream1");
	 	var divstream1=document.getElementById("div_stream1");
	 	
	 	var stream1=document.getElementById("level");
	 	var sstream=stream1.options[stream1.selectedIndex].text;
	 	if(sstream=="Select Level" ||sstream=="")
	 	{
	 		stream1.style="border-color: red;";
	 		//country.style= "border-color: red;";
	 		divstream1.className='form-group has-error has-feedback';
	 		spstream1.className='glyphicon glyphicon-remove form-control-feedback';
	 		//stream1.style.width="300px";
	 		return false;
	 	}
	 	else
	 	{
	 		stream1.style="border-color: green;";
	 		//add.style="border-color: green;";
	 		//stream1.style.width="300px";
	 		divstream1.className='form-group has-success has-feedback';
	 		spstream1.className='glyphicon glyphicon-ok form-control-feedback';
	 		return true;
	 	}	
	 }
	function checkImage() {
		var spadd=document.getElementById("sp_image");
	    var divadd=document.getElementById("div_image")
		
	    var add=document.getElementById("id_client_image");
	    var vadd=add.value;
		vadd=vadd.trim();
		//var letter=/^[a-zA-Z]+$/;
		
		if(vadd == "")
		{
			add.style= "border-color: red;";
			divadd.className='form-group has-error has-feedback';
			spadd.className='glyphicon glyphicon-remove form-control-feedback';
			//add.style.width="438px";
			return false;
		}
		else
		{
			add.style="border-color: green;";
			//add.style.width="438px438px";
			divadd.className='form-group has-success has-feedback';
			spadd.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}
	}
	
	function validateAll()
	{
		var clientName=checkClientName();
		var image=checkImage();
		var description=checkDescription();
		var level=validateLevel();
		
		
		
		if(clientName && image && description && level )
		{return true;}
		else
		{return false;}
	}
	
	
	
	</script>



<script type="text/javascript">
$(document)
.ready(
		function() {

		});

$(document).ready(function() {
$(document).ready(function() {
	
$.get("<%=application.getContextPath()%>/LevelCompanyController", function(gsonData) {
	var a = "<option value=''>Select Level</option>";
	$.each(gsonData, function(k, v) {
		a += "<option value='"+k+"'>" + v + "</option>";
	});
	$("#level").html(a);
});
});
});
function getDropDowns()
{
	$.get("<%=application.getContextPath()%>/CountryController", function(gsonData) {
		var a = "<option value=''>Select Country</option>";
		//alert("hi..")
		$.each(gsonData,
				function(k, v) {

					a += "<option value='"+k+"'>" + v
							+ "</option>";
				});
		$("#country").html(a);

	});

	$("#country")
			.change(
					function() {
						var countryid = $("#country").val();
						$
								.get(
										"<%=application.getContextPath()%>/StateController?countryid="
												+ countryid,
										function(gsonData) {
											var a = "<option value=''>Select State</option>";
											$
													.each(
															gsonData,
															function(
																	k,
																	v) {
																a += "<option value='"+k+"'>"
																		+ v
																		+ "</option>";
															});
											$("#state")
													.html(a);
										});

					});
	$("#state")
			.change(
					function() {
						var stateid = $("#state").val();
						$
								.get(
										"<%=application.getContextPath()%>/CityController?stateid="
												+ stateid,
										function(data) {
											var a = "<option value=''>Select City</option>";
											$
													.each(
															data,
															function(
																	k,
																	v) {
																a += "<option value='"+k+"'>"
																		+ v
																		+ "</option>";
															});
											$("#city")
													.html(a);
										});
					});
}
function editClient(cid)
{
	//alert("---cid----"+cid)
	
	getDropDowns();
	//alert("hhh"+cid);
	   $('#updateModal').modal('show'); 
	     $.get("<%=application.getContextPath()%>/EditClientDataController?clientId="+cid, function(data){
	    	 //alert(cid)
	<%-- 	window.location.href="<%=application.getContextPath()%>/ViewClientDetails";    	 
	 --%>    	 var ob=JSON.parse(data);
	    	 //alert(data)
	    	 //alert("---------data---"+ob.clientName);
	    	  
	    	document.getElementById("clientid").value=ob.clientId; 
	    	//alert(data.clientName)
	    document.getElementById("id_client_name").value=ob.clientName;
	  	//document.getElementById("id_client_name").value=data.clientName;
	  	//alert("clientname---"+x)
	  	//document.getElementById("id_client_image").value=data.clientImg;
		document.getElementById("id_client_description").value=ob.clientDescription;
	   // document.getElementById("id_person_name").value=data.personName;
	    //document.getElementById("id_person_mobile").value=data.personMobile;
	    //document.getElementById("id_person_email").value=data.personEmail;
	    //document.getElementById("id_pincode").value=data.pincode;
	    //document.getElementById("id_location").value=data.location; 
	     });
/* setTimeout("viewClient()",3000);
 */}
function viewAddress(cid){
	client_id=cid;
	<%-- $.get("<%=application.getContextPath()%>/view_client_addrs_details?clientId="+client_id, function(data) {	 
	}); --%>
	 window.location.href="<%=application.getContextPath()%>/view_client_addrs_details?clientId="+cid;
}
   function deleteClient(cid)
{
	   client_id=cid;
	   $("#myRegResModal").modal('show');
	   setTimeout('viewClient()',3000);
}  
   function addClient() {
	window.location.href="<%=application.getContextPath()%>/jsp/admin/add_client_details.jsp";

	
	setTimeout('viewClient()',3000);
}
   function viewClient() {
		window.location.href="<%=application.getContextPath()%>/ViewClientDetails";
	}
   
   
	function removeClient() {
		$.get("<%=application.getContextPath()%>/ClientDeleteController?clientId="+client_id, function(data) {
			$("#myRegResModal").modal('hide');
			$("#myInfoModal").modal('show');
			document.getElementById("myModalResInfo").innerHTML = data;
			setTimeout('viewClient()',2000);
		});
		client_id = "";
	}
</script>
<!-- <script src="alert/dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css"> -->
</head>
<body class="no-skin"><div class="main-container" id="main-container">
<!-- <div class="container"> -->
	<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
		<div style="color: :green;text-align: center;font-size:large;">
<c:if test="${not empty result}" >
</c:if>
</div>
<div class="page-content">
	<h4>
					<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue">
							<b class="blue" >Client Details</b> </i>
				</h4>
				</div>
          <button type="button"  value="Add Client" class="btn btn-primary" style="left: 1100px;" onclick="addClient()">Add Client</button>
           
		<table class="table table-bordered">
			<thead>
				<tr class="row-name" style="font-size: 18px; color: #448aff;">
					<th>Sno</th>
					<th>Client name</th>
					<th>Description</th>
					<th>Level</th>
					<th>View Address</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<c:if test="${not empty clientData}">
				<c:forEach var="vo" items="${clientData}">
					<tbody>
						<tr>
							<td><c:out value="${vo.cno}"></c:out></td>
							<td><c:out value="${vo.clientName}"></c:out></td>
							<td><c:out value="${vo.clientDescription}"></c:out></td>
							<td><c:out value="${vo.level}"></c:out></td>
							<td><button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" onclick="viewAddress(${vo.clientId})">view Addrs</button></td>
							<td><button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" onclick="editClient(${vo.clientId})">Update</button></td>
							<td><button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" onclick="deleteClient(${vo.clientId})">delete</button></td>
						</tr>
					</tbody>
				</c:forEach>
			</c:if>
		</table>
	</div>
	 <!-- MODAL START FOR CONFIRMATION -->
		<div class="modal fade" id="myRegResModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Warning!</h4>
					</div>
					<div class="modal-body" id="myRegModalResInfo">Are You Sure
						to Delete?</div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal"
							onclick="removeClient()">Delete</button>
						<button type="button" class="btn-danger" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
		<!--modle end-->
		<!-- MODAL START FOR RESULT -->
		<div class="modal fade" id="myInfoModal" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Info!</h4>
					</div>
					<div class="modal-body" id="myModalResInfo"></div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal">Ok</button>
					</div>
				</div>
				</div>
		</div>
		<!-- MODAL END -->
	<form
		action="<%=application.getContextPath()%>/update_client" onsubmit="return validateAll()"
		method="post" enctype="multipart/form-data">
		<div class="container">
			<!-- Trigger the modal with a button -->
			<!-- Modal -->
			<div class="modal fade" id="updateModal" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: red; color: #fff">
							<button type="button" class="close" data-dismiss="modal"
								style="color: blue">&times;</button>
							<h4 class="modal-title">Update Client Details</h4>
						</div>
						<div class="modal-body">
							<input type="hidden" id="clientid" name="cid">
							<!-- <button  id='clientid' name='clientid' style="width:0px; height:0px; visibility:hidden;"></button> -->
							<div class="form-group" style="margin-left: 60px;"
								id="div_ClientName">
								<label>Client Name </label> <input type="text" name="clientName"
									onchange="checkClientName()" id="id_client_name"
									class="form-control" placeholder="Client Name..."
									style="max-width: 492px;"> <span id="sp_ClientName"></span>
							</div>
							<div class="modal-body">
								<div class="form-group" style="margin-left: 46px;"
									id="div_image">
									<label>Client Image </label> <input name="clientImg"
										type="file" id="id_client_image"
										onchange="checkImage()" class="form-control" accept="image/*"
										data-type='image' style="max-width: 492px;"> <span id="sp_image"></span>
								</div>
							</div>
							<div class="modal-body">
								<div class="form-group" style="margin-left: 46px;"
									id="div_desctiption">
									<label>Description </label>
									<textarea rows="4" class="form-control"
										id="id_client_description" onchange="checkDescription()"
										placeholder="Description About Company" name="description"
										style="max-width: 492px;"></textarea>
									<span id="sp_desctiption"></span>
								</div>
							</div>
 							<div class="col-sm-10 col-sm-offset-1">
								<div class="form-group" id="div_stream1">
									<label>Level </label> <select name="level" id="level"
										class="form-control" onchange="validateLevel()" style="max-width: 492px;">
										<option></option>
									</select> <span id="sp_stream1"></span>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-default" id="y" name="yes"
								onclick="clientEditDetails()">Update</button>
						</div>
					</div>
				</div>
				</div>
			</div>
	</form>
	
	<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
</body>