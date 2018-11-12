<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${path}/js/jquery.min.js"></script>
<script type="text/javascript" src="${path}/assets/js/jquery-ui.min.js"></script>
<style>
div#education {
    margin-top: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>View Trainee</title>
<script>
	$(document)
			.ready(
					function() {
						$("#id_edit_ssc_stream_select").change(function() {
							var streamKey = $(this).children(
							":selected").attr("value");
					if (!(streamKey == "select")) {
						$("#id_edit_ssc_specialization_select").html("");
						$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamKey, function(data) {
							var opt;
							opt = "<option value='select'>SELECT</option>";
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_edit_ssc_specialization_select").append(opt);
						});
						}
					else{}						
						});
						
						$("#id_edit_inter_stream_select").change(function() {
							var streamKey = $(this).children(
							":selected").attr("value");
					if (!(streamKey == "select")) {
						$("#id_edit_inter_specialization_select").html("");
						$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamKey, function(data) {
							var opt;
							opt = "<option value='select'>SELECT</option>";
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_edit_inter_specialization_select").append(opt);
						});
						}
					else{}						
						});
						
						$("#id_edit_grad_stream_select").change(function() {
							var streamKey = $(this).children(
							":selected").attr("value");
					if (!(streamKey == "select")) {
						$("#id_edit_grad_specialization_select").html("");
						$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamKey, function(data) {
							var opt;
							opt = "<option value='select'>SELECT</option>";
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_edit_grad_specialization_select").append(opt);
						});
						}
					else{}						
						});
						$("#id_edit_pg_stream_select").change(function() {
							var streamKey = $(this).children(
							":selected").attr("value");
					if (!(streamKey == "select")) {
						$("#id_edit_pg_specialization_select").html("");
						$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamKey, function(data) {
							var opt;
							opt = "<option value='select'>SELECT</option>";
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_edit_pg_specialization_select").append(opt);
						});
						}
					else{}						
						});
						
						
						$.get("<%=application.getContextPath()%>/batchtechloadcontroller?req=batch",
								function(data) {
									var opt;
									$.each(data, function(k, v) {
										opt += "<option value='"+k+"'>" + v
												+ "</option>";
									});
									$("#id_batch").append(opt);
								});

						$("#id_batch")
								.change(
										function() {
											var batchKey = $(this).children(
													":selected").attr("value");
											if (!(batchKey == "select")) {
												$("#id_tech").empty();
												$
														.get(
																"../../batchtechloadcontroller?req=tech&key="
																		+ batchKey,
																function(data) {
																	var opt;
																	opt = "<option value='select'>SELECT</option>";
																	$
																			.each(
																					data,
																					function(
																							k,
																							v) {
																						opt += "<option value='"+k+"'>"
																								+ v
																								+ "</option>";
																					});
																	$(
																			"#id_tech")
																			.append(
																					opt);
																});
											} else {
												$("#id_tech").html("");
												var opt = opt = "<option value='select'>SELECT</option>";
												$("#id_tech").append(opt);
											}
										});

						$("#id_tech")
								.change(
										function() {

											var batchId = document
													.getElementById("id_batch").value;
											var techId = document
													.getElementById("id_tech").value;

											//alert("batch="+batchId+"\t tech="+techId);

											$
													.get(
															"../../jsp/hr/trainee_details.jsp?batchId="
																	+ batchId
																	+ "&techId="
																	+ techId
																	+ "",
															function(data) {
																document
																		.getElementById("contentdiv").innerHTML = data;
															});

										});

					});
</script>

<script type="text/javascript">
function loadAddressForEdit()
{
	$("#id_edit_country").empty();
	$.get("../../addresscontroller?req=country", function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
		});
		$("#id_edit_country").append(opt);
	});

	$("#id_edit_country")
			.change(
					function() {
						var countryKey = $(this).children(
								":selected").attr("value");
						if (!(countryKey == "select")) {
							$("#id_edit_state").empty();
							
							$
									.get(
											"../../addresscontroller?req=state&key="
													+ countryKey,
											function(data) {
												var opt;
												opt = "<option value='select'>SELECT</option>";
												$
														.each(
																data,
																function(
																		k,
																		v) {
																	opt += "<option value='"+k+"'>"
																			+ v
																			+ "</option>";
																});
												$(
														"#id_edit_state")
														.append(
																opt);
											});
						} else {
							$("#id_edit_state").html("");
							$("#id_edit_city").html("");
							var opt = opt = "<option value='select'>SELECT</option>";
							$("#id_edit_state").append(opt);
							$("#id_edit_city").append(opt);
						}
					});

	$("#id_edit_state")
			.change(
					function() {
						var stateKey = $(this).children(
								":selected").attr("value");
						if (!(stateKey == "select")) {
							$("#id_edit_city").empty();
							$
									.get(
											"../../addresscontroller?req=city&key="
													+ stateKey,
											function(data) {
												var opt;
												opt = "<option value='select'>SELECT</option>";
												$
														.each(
																data,
																function(
																		k,
																		v) {
																	opt += "<option value='"+k+"'>"
																			+ v
																			+ "</option>";
																});
												$(
														"#id_edit_city")
														.append(
																opt);
											});
						} else {
							$("#id_edit_city").html("");
							var opt = opt = "<option value='select'>SELECT</option>";
							$("#id_edit_city").append(opt);
						}
					});
}

function loadStreamForEdit(eduId)
{
	if(eduId==1)
	{
		$("#id_edit_ssc_stream_select").html("");
		$.get("../../streamspecializationcontroller?req=stream&id="+eduId+"", function(data) {
			var opt;
			opt = "<option value='select'>SELECT</option>";
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
						
			});
		$("#id_edit_ssc_stream_select").append(opt);		
		});

	}
	else if(eduId==2)
	{
		$("#id_edit_inter_stream_select").html("");
		$.get("../../streamspecializationcontroller?req=stream&id="+eduId+"", function(data) {
			var opt;
			opt = "<option value='select'>SELECT</option>";
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
						
			});
		$("#id_edit_inter_stream_select").append(opt);		
		});
	}
	else if(eduId==3)
	{
		$("#id_edit_grad_stream_select").html("");
		$.get("../../streamspecializationcontroller?req=stream&id="+eduId+"", function(data) {
			var opt;
			opt = "<option value='select'>SELECT</option>";
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
						
			});
		$("#id_edit_grad_stream_select").append(opt);		
		});
	}
	else if(eduId==4)
	{
		$("#id_edit_pg_stream_select").html("");
		$.get("../../streamspecializationcontroller?req=stream&id="+eduId+"", function(data) {
			var opt;
			opt = "<option value='select'>SELECT</option>";
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
						
			});
		$("#id_edit_pg_stream_select").append(opt);		
		});
	}
	else
	{
		/* $("#id_edit_ssc_stream_select").html("");
		$.get("../../streamspecializationcontroller?req=stream&id="+eduId+"", function(data) {
			var opt;
			opt = "<option value='select'>SELECT</option>";
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
						
			});
		$("#id_edit_ssc_stream_select").append(opt);		
		}); */
	}
}

/* function loadSpecializationForEdit() 
{
	alert();
	$("#id_edit_ssc_specialization_select").html("");
	$("#id_edit_inter_specialization_select").html("");
	$("#id_edit_grad_specialization_select").html("");
	$("#id_edit_pg_specialization_select").html("");
	$.get("../../streamspecializationcontroller?req=specialization", function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
					
		});
	$("#id_edit_ssc_specialization_select").append(opt);
	$("#id_edit_inter_specialization_select").append(opt);
	$("#id_edit_grad_specialization_select").append(opt);
	$("#id_edit_pg_specialization_select").append(opt);
	});
} */


function loadSpecializationForSSC(streamId,spId)
{
	$("#id_edit_ssc_specialization_select").html("");
	$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamId, function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
		});
		$("#id_edit_ssc_specialization_select").append(opt);
		document.getElementById('id_edit_ssc_specialization_select').value=spId;
	});
	
}
function loadSpecializationForInter(streamId,spId)
{
	$("#id_edit_inter_specialization_select").html("");
	$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamId, function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
		});
		$("#id_edit_inter_specialization_select").append(opt);
		document.getElementById('id_edit_inter_specialization_select').value=spId;
	});	
}
function loadSpecializationForGrad(streamId,spId)
{
	$("#id_edit_grad_specialization_select").html("");
	$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamId, function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
		});
		$("#id_edit_grad_specialization_select").append(opt);
		document.getElementById('id_edit_grad_specialization_select').value=spId;
	});	
}
function loadSpecializationForPG(streamId,spId)
{
	$("#id_edit_pg_specialization_select").html("");
	
	$.get("../../streamspecializationcontroller?req=selspecialization&id="+streamId, function(data) {
		var opt;
		opt = "<option value='select'>SELECT</option>";
		$.each(data, function(k, v) {
			opt += "<option value='"+k+"'>" + v
					+ "</option>";
		});
		$("#id_edit_pg_specialization_select").append(opt);
		document.getElementById('id_edit_pg_specialization_select').value=spId;
	});	
}
</script>

<script type="text/javascript">
	var uId;
	var newLocation;
	var newCity;
	var newState;
	var newCountry;
	function editTrainee(userId) {
		loadAddressForEdit();
		$("#id_edit_state").html("");
		$("#id_edit_city").html("");
		$("#id_edit_state").append("<option value='select'>SELECT</option>");
		$("#id_edit_city").append("<option value='select'>SELECT</option>");
		
		loadStreamForEdit(1);
		loadStreamForEdit(2);
		loadStreamForEdit(3);
		loadStreamForEdit(4);
		//loadSpecializationForEdit();
		$("#myRegEditModal").modal('show');
		$('#myRegEditModal a[href="#ssc"]').tab('show');
		$('#myRegEditModal a[href="#personal"]').tab('show');
		
		uId = userId;
		var co='india';
		$.get("../../traineeoperationcontroller?req=getTraineeData&userId="+uId,function(data){
			document.getElementById("id_edit_first_name").value=data.firstName;
			document.getElementById("id_edit_last_name").value=data.lastName;
			document.getElementById("id_edit_mobile").value=data.mobile;
			document.getElementById("id_edit_mail").value=data.mail;
			var address=data.location+", "+data.city+", "+data.state+", "+data.country;
			document.getElementById("id_edit_all_address").value=address;
			
			document.getElementById("id_edit_ssc_percentage").value=data.sscPercentage;
			document.getElementById("id_edit_ssc_yop").value=data.sscYop;
			
			document.getElementById("id_edit_inter_percentage").value=data.hscPercentage;
			document.getElementById("id_edit_inter_yop").value=data.hscYop;
			
			document.getElementById("id_edit_grad_percentage").value=data.gradPercentage;
			document.getElementById("id_edit_grad_yop").value=data.gradYop;
			
			document.getElementById("id_edit_pg_percentage").value=data.pgPercentage;

			document.getElementById("id_edit_pg_yop").value=data.pgYop; 
			
			document.getElementById('id_edit_ssc_stream_select').value=data.sscStreamId;
			document.getElementById('id_edit_inter_stream_select').value=data.hscStreamId;
			document.getElementById('id_edit_grad_stream_select').value=data.gradStreamId;
			document.getElementById('id_edit_pg_stream_select').value=data.pgStreamId;
			
			loadSpecializationForSSC(data.sscStreamId,data.sscSpecializationId);
			loadSpecializationForInter(data.hscStreamId,data.hscSpecializationId);
			loadSpecializationForGrad(data.gradStreamId,data.gradSpecializationId);
			
			loadSpecializationForPG(data.pgStreamId,data.pgSpecializationId);
			
			document.getElementById('id_edit_ssc_specialization_select').value=data.sscSpecializationId;
			
			document.getElementById('id_edit_inter_specialization_select').value=data.hscSpecializationId;
			
			document.getElementById('id_edit_grad_specialization_select').value=data.gradSpecializationId;
			
			document.getElementById('id_edit_pg_specialization_select').value=data.pgSpecializationId;
		});
	}
	
	function validationAll()
	{
		var resSSCstream=returnSSCstream();
		var resSSCspecialization=returnSSCspecialization();
		var resSSCpercentage=returnSSCpercantage();
		var resSSCyop=returnSSCyop();
		
		var resInterstream=returnInterstream();
		var resInterspecialization=returnInterspecialization();
		var resInterpercentage=returnInterpercantage();
		var resInteryop=returnInteryop();
		
		var resGradstream=returnGradstream();
		var resGradspecialization=returnGradspecialization();
		var resGradpercentage=returnGradpercantage();
		var resGradyop=returnGradyop();
		
		var resPGstream=returnPGstream();
		var resPGspecialization=returnPGspecialization();
		var resPGpercentage=returnPGpercantage();
		var resPGyop=returnPGyop();
		
		if(resSSCstream && resSSCspecialization && resInterstream && resInterspecialization && resGradstream && resGradspecialization && resPGstream && resPGspecialization && resSSCpercentage && resInterpercentage && resGradpercentage && resPGpercentage && resSSCyop && resInteryop && resGradyop && resPGyop)
			{
			return true;
			}
		else
			{
			return false;			
			}
	}
	
	
	function editTraineeData() {
	
		var resAll=validationAll();
		if(resAll==true)
			{
			var uFName= document.getElementById("id_edit_first_name").value;
			var uLName= document.getElementById("id_edit_last_name").value;
			var uMobile= document.getElementById("id_edit_mobile").value;
			
			var sscSpecializationId=document.getElementById("id_edit_ssc_specialization_select").value;
			var interSpecializationId=document.getElementById("id_edit_inter_specialization_select").value;
			var gradSpecializationId=document.getElementById("id_edit_grad_specialization_select").value;
			var pgSpecializationId=document.getElementById("id_edit_pg_specialization_select").value;
			
			var sscStreamId=document.getElementById("id_edit_ssc_stream_select").value;
			var interStreamId=document.getElementById("id_edit_inter_stream_select").value;
			var gradStreamId=document.getElementById("id_edit_grad_stream_select").value;
			var pgStreamId=document.getElementById("id_edit_pg_stream_select").value;
			
			var sscPercentage=document.getElementById("id_edit_ssc_percentage").value;
			var interPercentage=document.getElementById("id_edit_inter_percentage").value;
			var gradPercentage=document.getElementById("id_edit_grad_percentage").value;
			var pgPercentage=document.getElementById("id_edit_pg_percentage").value;
			
			var sscYop=document.getElementById("id_edit_ssc_yop").value;
			var interYop=document.getElementById("id_edit_inter_yop").value;
			var gradYop=document.getElementById("id_edit_grad_yop").value;
			var pgYop=document.getElementById("id_edit_pg_yop").value;
			
			//var uLoc= document.getElementById("id_edit_address").value;
			//var uCountry= document.getElementById("id_edit_country").value;
			//var uState= document.getElementById("id_edit_state").value;
			//var uCity= document.getElementById("id_edit_city").value;
			
			//var res = validateAddRoundAll();
			//if (res == true) {
				$.ajax({
							url : '../../updateuserdetailscontroller',
							type : 'POST',
							data : {
								user_id : uId,
								first_name : uFName,
								last_name : uLName,
								mobile_no : uMobile,
								ssc_stream : sscStreamId,
								inter_stream : interStreamId,
								grad_stream : gradStreamId,
								pg_stream : pgStreamId,
								ssc_specialization : sscSpecializationId,
								inter_specialization : interSpecializationId,
								grad_specialization : gradSpecializationId,
								pg_specialization : pgSpecializationId,
								ssc_percentage : sscPercentage,
								inter_percentage : interPercentage,
								grad_percentage : gradPercentage,
								pg_percentage : pgPercentage,
								ssc_yop : sscYop,
								inter_yop : interYop,
								grad_yop : gradYop,
								pg_yop : pgYop 
							},
							success : function(data) {
								
								$("#myRegEditModal").modal('hide');
								cancelAllInf();
								$("#myInfoModal").modal('show');
								document.getElementById("myModalResInfo").innerHTML="<h4>"+data+"</h4>";
							}
						});
			}
		else
			{
				$("#errResDiv").html("Please check all entered details..");
			}
	}	
	

	function deleteTrainee(userId) {
		$("#myRegResModal").modal('show');
		uId = userId;
	}

	function deleteTraineeData() {
		$.get("../../traineeoperationcontroller?req=deleteTrainee&userId="
				+ uId, function(data) {
			$("#myRegResModal").modal('hide');
			$("#myInfoModal").modal('show');
			document.getElementById("myModalResInfo").innerHTML = data;

			var batchId = document.getElementById("id_batch").value;
			var techId = document.getElementById("id_tech").value;

			$.get("../../jsp/hr/trainee_details.jsp?batchId=" + batchId
					+ "&techId=" + techId + "", function(data) {
				document.getElementById("contentdiv").innerHTML = data;
			});

		});
		uId = "";
	}
	
	function changeAddressFields()
	{
		var location=document.getElementById("id_edit_address").value;
		var city=document.getElementById("id_edit_city");
		var state=document.getElementById("id_edit_state");
		var country=document.getElementById("id_edit_country");
		var scountry = country.options[country.selectedIndex].text;
		var sstate = state.options[state.selectedIndex].text;
		var scity = city.options[city.selectedIndex].text;
		
		newLocation=document.getElementById("id_edit_address").value;
		newCity=document.getElementById("id_edit_country").value;
		newState=document.getElementById("id_edit_state").value;
		newCountry=document.getElementById("id_edit_city").value;
		var newaddress=newLocation+", "+scity+", "+sstate+", "+scountry;
		document.getElementById("id_edit_all_address").value=newaddress;
		hideAddressFields();
	}
	
	function showAddressFields() 
	{
		document.getElementById("id_address_table").style.display='block';
	}

	function hideAddressFields()
	{
		$("#id_edit_state").html("");
		$("#id_edit_city").html("");
		$("#id_edit_state").append("<option value='select'>SELECT</option>");
		$("#id_edit_city").append("<option value='select'>SELECT</option>");
		document.getElementById("id_address_table").style.display='none';
	}
	
	function cancelAllInf()
	{
		$("#id_edit_state").html("");
		$("#id_edit_city").html("");
		$("#errResDiv").html("");
		$("#id_edit_state").append("<option value='select'>SELECT</option>");
		$("#id_edit_city").append("<option value='select'>SELECT</option>");
	    //myRegEditModal
	    //$("#myRegEditModal").trigger();
		
	}
</script>

</head>
<body>
<body class="no-skin" style="color: black;">
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

		<!-- write your code here -->
		<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">View Trainee</b>
		</h4>
		<br>
		<table>
			<tr>
				<td><b>Select Batch : </b></td>
				<td><select name="batch" id="id_batch" class="form-control">
						<option value="select">SELECT</option>
				</select></td>
			</tr>

			<tr>
				<td><b>Select Technology : </b></td>
				<td><select name="tech" id="id_tech" class="form-control">
						<option value="select">SELECT</option>
				</select></td>
			</tr>
		</table>
		<br> <br>

		<!-- MODAL START FOR CONFIRMATION -->
		<div class="modal fade" id="myRegResModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Warning!</h4>
					</div>
					<div class="modal-body" id="myRegModalResInfo"><h4>Are You Sure
						to Delete?</h4></div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal"
							onclick="deleteTraineeData()">Delete</button>
						<button type="button" class="btn-danger" data-dismiss="modal">Cancel</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->

		<!-- MODAL START FOR EDITION -->
		<div class="modal fade" id="myRegEditModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Update!</h4>
					</div>
					<div class="modal-body" id="myRegEditModalBody">


						<ul class="nav nav-tabs" id="tabContent">
							<li class="active"><a href="#personal" data-toggle="tab">Personal
									Details</a></li>
							<li><a href="#address" data-toggle="tab">Address
									Details</a></li>
							<li><a href="#education" data-toggle="tab">Educational
									Details</a></li>
						</ul>

						<div class="tab-content">
							<div class="tab-pane active" id="personal">
								<div class="control-group">
								<table>
									<tr>
										<td>First Name :</td>
										<td><input type="text" class="form-control" id="id_edit_first_name" readonly="readonly"></td>
									</tr>
									<tr>
										<td>Last Name :</td>
										<td><input type="text" class="form-control" id="id_edit_last_name" readonly="readonly"></td>
									</tr>
									<tr>
										<td>Mobile No :</td>
										<td><input type="text" class="form-control" id="id_edit_mobile" readonly="readonly"></td>
									</tr>
									<tr>
										<td>E-Mail :</td>
										<td><input type="text" class="form-control" id="id_edit_mail" readonly="readonly"></td>
									</tr>
								</table>
									
								</div>
							</div>

							<div class="tab-pane" id="address">
								<div class="control-group">
								Address :
									<input type="text" readonly="readonly"
												class="form-control" id="id_edit_all_address">
									<!-- <input type="submit" value="edit" class="btn btn-primary btn-xs" width="50px" onclick="showAddressFields()"> -->
									<table style="display: none" id="id_address_table">
										<tr>
											<td>Enter Address :</td>
											<td><input type="text" 
												class="form-control" id="id_edit_address" readonly="readonly"></td>
										</tr>
										<tr>
											<td>Select Country :</td>
											<td><select class="form-control"  id="id_edit_country" disabled="disabled">
											<option value="select">SELECT</option>
											</select></td>
										</tr>
										<tr>
											<td>Select State :</td>
											<td><select class="form-control"  id="id_edit_state" disabled="disabled">
											<option value="select">SELECT</option>
											</select></td>
										</tr>
										<tr>
											<td>Select City :</td>
											<td><select class="form-control"  id="id_edit_city" disabled="disabled">
											<option value="select">SELECT</option>
											</select></td>
										</tr>
										<tr>
											<td>
											
												<input type="submit" value="Update"
												class="btn btn-primary btn-xs" onclick="changeAddressFields()">
												<input type="submit" value="Cancel"
												class="btn btn-danger btn-xs" onclick="hideAddressFields()">
											</td>
											<td></td>
										</tr>
									</table>
									
								</div>
							</div>


							<div class="tab-pane" id="education">
								<div class="control-group">

									<ul class="nav nav-tabs" id="tabContent">
										<li class="active"><a href="#ssc" data-toggle="tab">X(SSC)</a></li>
										<li><a href="#inter" data-toggle="tab">INTERMEDIATE</a></li>
										<li><a href="#grad" data-toggle="tab">GRADUATION</a></li>
										<li><a href="#pg" data-toggle="tab">POST-GRADUATION</a></li>
									</ul>

									<div class="tab-content">
										<div class="tab-pane active" id="ssc">
											<div class="control-group">
												<table id="id_edit_table_ssc">
													<tr>
														<td>STREAM :</td>
														<td>
															<select id="id_edit_ssc_stream_select" onchange="returnSSCstream()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														<td>
															<span id="id_edit_ssc_stream_select_span"></span>
															</td>															
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															SPECIALIZATION :</td>
															<td><select id="id_edit_ssc_specialization_select" onchange="returnSSCspecialization()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														<td>
															<span id="id_edit_ssc_specialization_select_span"></span>
															</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															PERCENTAGE :</td> <td><input type="number" onchange="returnSSCpercantage()" class="form-control" id="id_edit_ssc_percentage">
														</td>
														<td>
															<span id="id_edit_ssc_percentage_span"></span>
															</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															Y.O.P. :</td> <td><input type="number" onchange="returnSSCyop()" class="form-control" id="id_edit_ssc_yop">
														</td>
														<td>
															<span id="id_edit_ssc_yop_span"></span>
															</td>
														</tr>
												</table>
											</div>
										</div>
									


									<div class="tab-pane" id="inter">
										<div class="control-group">
											<table id="id_edit_table_inter">
													<tr>
														<td>
															STREAM :</td>
															<td><select id="id_edit_inter_stream_select" onchange="returnInterstream()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															SPECIALIZATION :</td>
															<td><select id="id_edit_inter_specialization_select" onchange="returnInterspecialization()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															PERCENTAGE :</td> <td><input type="number" onchange="returnInterpercantage()" class="form-control" id="id_edit_inter_percentage">
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															Y.O.P. :</td> <td><input type="number" onchange="returnInteryop()" class="form-control" id="id_edit_inter_yop">
														</td>
													</tr>
												</table>
										</div>
									</div>

									<div class="tab-pane" id="grad">
										<div class="control-group">
											<table id="id_edit_table_grad">
													<tr>
														<td>
															STREAM :</td>
															<td><select id="id_edit_grad_stream_select" onchange="returnGradstream()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															SPECIALIZATION :</td>
															<td><select id="id_edit_grad_specialization_select" onchange="returnGradspecialization()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															PERCENTAGE :</td> <td><input type="number" onchange="returnGradpercantage()" class="form-control" id="id_edit_grad_percentage">
														</td>
														<tr>
														<tr><td>-</td></tr>
														<td>
															Y.O.P. :</td> <td><input type="number" onchange="returnGradyop()" class="form-control" id="id_edit_grad_yop">
														</td>
													</tr>
												</table>
										</div>
									</div>

									<div class="tab-pane" id="pg">
										<div class="control-group">
											<table id="id_edit_table_pg">
													<tr>
														<td>
															STREAM :</td>
															<td><select id="id_edit_pg_stream_select" onchange="returnPGstream()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															SPECIALIZATION :</td>
															<td><select id="id_edit_pg_specialization_select" onchange="returnPGspecialization()" class="form-control">
																<option value="select">SELECT</option>															
															</select>
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															PERCENTAGE :</td> <td><input type="number" onchange="returnPGpercantage()" class="form-control" id="id_edit_pg_percentage">
														</td>
														</tr>
														<tr><td>-</td></tr>
														<tr>
														<td>
															Y.O.P. :</td> <td><input type="number" onchange="returnPGyop()" class="form-control" id="id_edit_pg_yop">
														</td>
													</tr>
												</table>
										</div>
									</div>
									
									</div>

								</div>

							</div>
						</div>
						<div id="errResDiv" style="color: red;"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn-danger"
							onclick="editTraineeData()">Update</button>
						<button type="button" class="btn-danger" data-dismiss="modal" onclick="cancelAllInf()">Cancel</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->


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

		<!-- ACCORDING TO SELECTED OPTIONS SHOWING TABLE INTO THIS DIV BY APPENDING
		ANOTHER JSP PAGE INTO THIS DIV USING JQUERY -->
		<div id="contentdiv" align="center"></div>

		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
	<!-- /.main-container -->
	
	

<script type="text/javascript" src="../../js/add_round_validation_file.js"></script>
<script type="text/javascript" src="../../js/edu_update_validation.js"></script>
</body>
</html>