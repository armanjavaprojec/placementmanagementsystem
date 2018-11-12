<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Round</title>
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>
<script type="text/javascript" src="../../assets/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="../../js/add_round_validation_file.js"></script>

<script type="text/javascript">
var roundType;
	function clearData() {
		/* document.getElementById("id_round_no").value="";
		document.getElementById("id_round_description").value="";
		document.getElementById("id_round_date").value="";
		document.getElementById("id_round_address").value=""; */
		window.location.href = "../../jsp/admin/admin.jsp";
	}

	function myForm() {
		 if(roundType==1)
		{
			var operations=firstRoundActions();
		}
	if(roundType==2)
		{
		var operations=nextRoundActions();
		}
	if(roundType==3)
		{
		var operations=nextRoundActions();
		} 
		//var operations=firstRoundActions();
		var res = validateAddRoundAll();
		if (res == true) {
			
			var url_string = window.location.href;
			var myurl = new URL(url_string);
			var jobPostId = myurl.searchParams.get("jobid");
			
			
			$
					.ajax({
						url : '../../maintainroundcontroller?req=addround',
						type : 'POST',
						data : {
							round_no : document.getElementById("id_round_no").value,
							round_description : document
									.getElementById("id_round_description").value,
							round_date : document
									.getElementById("id_round_date").value,
							round_address : document
									.getElementById("id_round_address").value,
							round_city : document.getElementById("id_city").value,
							round_action:operations,
							job_post :jobPostId 
						},
						success : function(data) {
							$("#myRegResModal").modal('show');
							document.getElementById("myRegModalResInfo").innerHTML = data;
						}
					});
		}
	}

	$(document)
			.ready(
					function() {
						
						var url_string = window.location.href;
						var myurl = new URL(url_string);
						var clientName = myurl.searchParams.get("client");
						document.getElementById("id_company_name").innerHTML="<b>Hiring For : <i>"+clientName+"</i></b>";
						
						
						
						
						
						$.get("../../maintainroundcontroller?req=jobtype",function(data){
							var opt;
							opt = "<option value='select'>SELECT</option>";
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_job_type_select").append(opt);
						});
						
						$.get("../../addresscontroller?req=country", function(
								data) {
							var opt;
							$.each(data, function(k, v) {
								opt += "<option value='"+k+"'>" + v
										+ "</option>";
							});
							$("#id_country").append(opt);
						});

						$("#id_country")
								.change(
										function() {
											var countryKey = $(this).children(
													":selected").attr("value");
											if (!(countryKey == "select")) {
												$("#id_state").empty();
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
																			"#id_state")
																			.append(
																					opt);
																});
											} else {
												$("#id_state").html("");
												var opt = opt = "<option value='select'>SELECT</option>";
												$("#id_state").append(opt);
											}
										});

						$("#id_state")
								.change(
										function() {
											var stateKey = $(this).children(
													":selected").attr("value");
											if (!(stateKey == "select")) {
												$("#id_city").empty();
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
																			"#id_city")
																			.append(
																					opt);
																});
											} else {
												$("#id_city").html("");
												var opt = opt = "<option value='select'>SELECT</option>";
												$("#id_city").append(opt);
											}
										});

					});
	
	
	function firstRoundActions()
	{
		var strRecords="";

		var table = document.getElementById("table_interested_info");
		var len=(table.rows.length)-1;
		for (var i = 1, row; row = table.rows[i]; i++) {
			   colMail = row.cells[3];
			   colAction =row.cells[4];
			   var selectedMail=colMail.innerHTML.trim();
			   var selectedAction=document.getElementById("sel_action"+i).value;
			   strRecords+=""+selectedMail+":"+selectedAction+" ";
		}
		return strRecords;
	}
	
	function nextRoundActions()
	{
		var strRecords="";

		var table = document.getElementById("table_previous_shortlisted_info");
		var len=(table.rows.length)-1;
		for (var i = 1, row; row = table.rows[i]; i++) {
			   colMail = row.cells[3];
			   colAction =row.cells[4];
			   var selectedMail=colMail.innerHTML.trim();
			   var selectedAction=document.getElementById("sel_action"+i).value;
			   strRecords+=""+selectedMail+":"+selectedAction+" ";
		}
		return strRecords;
	}
	
	function checkAction(uId)
	{
		var act = document.getElementById("sel_action");
		var sact = act.options[act.selectedIndex].text;
		if (sact == "SELECT") {
			act.style = "border-color: red;";
			
		} else {
			act.style = "border-color: green;";
		}
	}
	
	function selectedType()
	{
		
		var url_string = window.location.href;
		var myurl = new URL(url_string);
		var jobPostId = myurl.searchParams.get("jobid");
		
		
		var commonDiv=document.getElementById("id_common_round_div");
		var maintainDiv=document.getElementById("id_maintain_round_div");
		var selType = document.getElementById("id_maintain_type");
		var sselType = selType.options[selType.selectedIndex].text;
		if (sselType == "SELECT TYPE") {
			roundType=0;
			maintainDiv.innerHTML="";
			commonDiv.style="display:none;";
		} else if(sselType=="FIRST ROUND"){
			roundType=1;
			//maintainDiv.innerHTML="first";
			$.get("../../jsp/admin/first_round.jsp?jobPostId="+jobPostId+"&roundId="+0+"",function(data){
				maintainDiv.innerHTML=data;
				if(data.includes("First round already done.."))
				{
					commonDiv.style="display:none;";
				}
				else
				{
					commonDiv.style="display:block;";
				}
				
			});
			
			

			/* $.get("../../maintainroundcontroller?req=status",function(data){
			var opt;
			$.each(data, function(k, v) {
				opt += "<option value='"+k+"'>" + v
						+ "</option>";
			});
			//$("#id_action_interested_trainee").append(opt);
		}); */
		}else if(sselType=="NEXT ROUND"){
			roundType=2;
			//maintainDiv.innerHTML="next";
			$.get("../../jsp/admin/next_round.jsp?jobPostId="+jobPostId,function(data){
				maintainDiv.innerHTML=data;
				if(data.includes("No one shortlisted for further round.."))
				{
					commonDiv.style="display:none;";
				}
				else
				{
					commonDiv.style="display:block;";
				}
			});
		}
		else if(sselType=="UPDATE PLACEMENT INFORMATION"){
			roundType=3;
			commonDiv.style="display:none;";
			//maintainDiv.innerHTML="result";
			$.get("../../jsp/admin/result.jsp?jobPostId="+jobPostId,function(data){
				maintainDiv.innerHTML=data;
			});
		}
		else{
			roundType=4;
			maintainDiv.innerHTML="";
		}
	}
	
	function placementResult()
	{
		var commonDiv=document.getElementById("id_common_round_div");
		var maintainDiv=document.getElementById("id_maintain_round_div");
		roundType=3;
		commonDiv.style="display:none;";
		//maintainDiv.innerHTML="result";
		$.get("../../jsp/admin/result.jsp?jobPostId="+jobPostId,function(data){
			maintainDiv.innerHTML=data;
		});
	}
	
	
</script>
<script type="text/javascript">	
var selement;
var uId;
	function placeStudent(ele,userId)
	{
		selement=ele;
		uId=userId;
		var sOption = ele.options[ele.selectedIndex].text;
		if(sOption=="SELECT")
		{
			
		}
		else if(sOption=="Placed")
		{
			$("#myPlacementModal").modal('show');
		}
		else if(sOption=="Rejected")
		{
			$("#myRejectModal").modal('show');
		}
		else{}
	}
	
	function placeTrainee()
	{
		var url_string = window.location.href;
		var myurl = new URL(url_string);
		var jobPostId = myurl.searchParams.get("jobid");
		
		
		var jobTypeIdSelect=document.getElementById("id_job_type_select");
		var jobTypeSelectedValue=jobTypeIdSelect.value;
		var jobPost=jobPostId;
		var placeStatus=selement.value;
		var selDate=document.getElementById("id_selected_date").value;
		var joiningDate=document.getElementById("id_joining_date").value;
		var pack=document.getElementById("id_package").value;
		var bond=document.getElementById("id_bond").value;
		//var jobtype=document.getElementById("id_job_type").value;
		$.ajax({
			url : '../../maintainroundcontroller?req=placetrainee',
			type : 'POST',
			data : {
				user_id : uId,
				job_post : jobPost,
				selected_date : selDate,
				joining_date : joiningDate,
				job_pack : pack,
				job_bond : bond,
				job_type : jobTypeSelectedValue,
				place_status : placeStatus
			},
			success : function(data) {
				$("#myPlacementModal").modal('hide');
				$("#myPlacementResModal").modal('show');
				document.getElementById("myPlacementResInfo").innerHTML = data;
			}
		});
	}
	
	function rejectTrainee()
	{
		var url_string = window.location.href;
		var myurl = new URL(url_string);
		var jobPostId = myurl.searchParams.get("jobid");
		
		var jobPost=jobPostId;
		var placeStatus=selement.value;
		$.ajax({
			url : '../../maintainroundcontroller?req=rejecttrainee',
			type : 'POST',
			data : {
				user_id : uId,
				job_post : jobPost,
				place_status : placeStatus
			},
			success : function(data) {
				$("#myRejectModal").modal('hide');
				$("#myPlacementResModal").modal('show');
				document.getElementById("myPlacementResInfo").innerHTML = data;
			}
		});
	}
	
	function closePlacementAction()
	{
		selement.value=0;
	}
	
	function closeRejectAction()
	{
		selement.value=0;
	}
	
</script>


</head>
<body>
<body class="no-skin" style="color:black;">
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
		<!-- write your code here -->
		<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Maintain Round Information</b>
		</h4>
		<div id="id_company_name" style="font-size: large;"></div>
		<div>
			<table>
			<tr><td><h4>Select Type :</h4><select class="form-control" style="width: 300px" id="id_maintain_type"
								onchange="selectedType()">
								<option value='select'>SELECT TYPE</option>
								<option value='first'>FIRST ROUND</option>
								<option value='next'>NEXT ROUND</option>
								<option value='result'>UPDATE PLACEMENT INFORMATION</option>
								</select></td></tr>
				</table>
		</div>
		<br>
		<div id="id_maintain_round_div"></div>
		
		<div id="id_common_round_div" style="display: none">
		<h4>Round Details :</h4> 
		<table>
<tr>
					<td><h5>Enter Round No. :</h5>
						<div id="div_round_no">
							<input type="number" class="form-control" id="id_round_no"
								name="round_no" onchange="checkRoundNo()" style="width: 300px"
								placeholder="Enter Round No">
								<span id="sp_round_no"></span>
						</div></td>
				</tr>
				<tr>
					<td>
						<h5>Enter Description :</h5>
						<div id="div_round_description">
							<input type="text" class="form-control" id="id_round_description"
								name="round_description" onchange="checkRoundDescription()"
								style="width: 300px" placeholder="Decription Of Round">
							<span id="sp_round_description"></span>
						</div>
					</td>
				</tr>
				<tr>
					<td><h5>Select Round Date :</h5>
						<div id="div_round_date">
							<input type="date" onchange="checkRoundDate()" name="round_date"
								class="form-control" style="width: 300px" id="id_round_date">
							<span id="sp_round_date"></span>
						</div></td>
				</tr>
				<tr>
					<td><h5>Enter Address :</h5>
						<div id="div_round_address">
							<input type="text" style="width: 300px" onchange="checkAddress()"
								class="form-control" placeholder="Venue Location"
								name="round_address" id="id_round_address"> <span
								id="sp_round_address"></span>
						</div></td>
						</tr>
			<tr>
					<td><h5>Select Country :</h5>
						<div id="div_round_country">
							<select class="form-control" style="width: 300px" id="id_country"
								onchange="checkCountry()">
								<option value="select">SELECT</option>
							</select> <span id="sp_round_country"></span>
						</div></td>
				</tr>
				<tr>
					<td><h5>Select State :</h5>
						<div id="div_round_state">
							<select class="form-control" style="width: 300px" id="id_state"
								onchange="checkState()">
								<option value="select">SELECT</option>
							</select> <span id="sp_round_state"></span>
						</div></td>
						</tr>
			<tr>
					<td><h5>Select City :</h5>
						<div id="div_round_city">
							<select class="form-control" style="width: 300px" id="id_city"
								onchange="checkCity()" name="round_city">
								<option value="select">SELECT</option>
							</select> <span id="sp_round_city"></span>
						</div></td>
				</tr>
				<tr>
					<td>-</td>
					<td></td>
				</tr>
				<tr>
					<td><input type="submit" class="btn btn-primary"
						onclick="myForm()" id="button_submit" value="Add Round">
						<button type="button" class="btn btn-warning"
							onclick="clearData()">Clear</button></td>
					<td></td>
				</tr>
</table>
		
		</div>

		<!-- MODAL START -->
		<div class="modal fade" id="myRegResModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Info</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" id="myRegModalResInfo"></div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal"
							onclick="clearData()">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->


		<!--PLACEMENT MODAL START -->
		<div class="modal fade" id="myPlacementModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Placement Info</h4>
					</div>
					<div class="modal-body" id="myPlacementInfo" align="center">
						<table>
							<tr>
								<td>
									<h5>SELCTED DATE : </h5>
									<input type="date" class="form-control" id="id_selected_date">
								</td>
							</tr>
							<tr>
								<td>
									<h5>JOINING DATE : </h5>
									<input type="date" class="form-control" id="id_joining_date">
								</td>
							<tr>
								<td>
									<h5>Package Per Annum : </h5>
									<input type="number" class="form-control" id="id_package">
								</td>
							</tr>
							<tr>
								<td>
									<h5>Bond Agreement (in months) : </h5>
									<input type="number" class="form-control" id="id_bond">
								</td>
							</tr>
							<tr>
								<td>
									<h5>Job Type : </h5>
									<!-- <input type="text" class="form-control" id="id_job_type"> -->
									<select id="id_job_type_select" class="form-control">
									</select>
								</td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
					<button type="button" class="btn btn-primary btn-sm"
						onclick="placeTrainee()" id="button_place">Place</button>
						<button type="button" class="btn-danger btn-sm" data-dismiss="modal"
							onclick="closePlacementAction()">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->

		<!-- MODAL START -->
		<div class="modal fade" id="myPlacementResModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Info</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" id="myPlacementResInfo"></div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal"
							onclick="placementResult()">Close</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->

		<!-- MODAL START -->
		<div class="modal fade" id="myRejectModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Warning !</h4>
					</div>
					<div class="modal-body" id="myRejectModalInfo">
						Are you sure to reject trainee?
					</div>
					<div class="modal-footer">
					<button type="button" class="btn-danger"
							onclick="rejectTrainee()">Reject</button>
						<button type="button" class="btn-primary" data-dismiss="modal"
							onclick="closeRejectAction()">Cancel</button>
					</div>
				</div>

			</div>
		</div>
		<!-- MODAL END -->


		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
	<!-- /.main-container -->
</body>
</html>