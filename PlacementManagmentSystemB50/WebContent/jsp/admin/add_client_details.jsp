<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
<link rel="icon" type="image/png" href="images/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Client</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--     Fonts and icons     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">

<!-- CSS Files -->
<link href="../../css/bootstrap.min.css" rel="stylesheet" />
<link href="../../css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../../css/demo.css" rel="stylesheet" />

<!--   Core JS Files   -->
	<script src="../../js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../../js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="../../js/gsdk-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
<script src="../../js/jquery.validate.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
div#cont {

    width: 1105px;

}

.wizard-card {

    min-height: 410px;
    background-color: #FFFFFF;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.15), 0 0 1px 1px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    padding: 0px 0;

}
</style>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
function checkClientName()
{	
	
	var sp_First=document.getElementById("sp_Client_Name");
    var div_first=document.getElementById("clientName");
	
    var first=document.getElementById("cName");
   	
    var vfirst=first.value;
	vfirst=vfirst.trim();
	var letter=/^[a-zA-Z ]+$/;
	
	if(vfirst == "")
	{
		
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="300px";
		return false;
	}
	if(!first.value.match(letter)){
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="300px";
		return false;
	}
	else
	{
		first.style="border-color: green;";
		//first.style.width="300px";
		div_first.className='form-group has-success has-feedback';
		sp_First.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
}

function checkPersonName()
{	
	
	var sp_First=document.getElementById("sp_FirstName");
    var div_first=document.getElementById("pnames");
	
    var first=document.getElementById("pName");
    var vfirst=first.value;
	vfirst=vfirst.trim();
	var letter=/^[a-zA-Z ]+$/;
	
	if(vfirst == "")
	{
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="300px";
		return false;
	}
	if(!first.value.match(letter)){
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		//first.style.width="300px";
		return false;
	}
	else
	{
		first.style="border-color: green;";
		//first.style.width="300px";
		div_first.className='form-group has-success has-feedback';
		sp_First.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
}
	function checkContact()
	{
		var spcontect=document.getElementById("sp_contect");
		var divcontect=document.getElementById("div_contect");
		
		var ucon=document.getElementById("contact");
		var contact=ucon.value;
		var len=contact.length;
	    var numbers = /^\(?([6-9]{1})\)?[-. ]?([0-9]{9})$/;
	   if(len==10)
		{
		   if (ucon.value.match(numbers))
		   {
			
			   ucon.style="border-color: green;";
				//ucon.style.width="300px";
				divcontect.className='form-group has-success has-feedback';
				spcontect.className='glyphicon glyphicon-ok form-control-feedback';
				return true;
				
		   }
		   else{
			   ucon.style="border-color: red;";
				divcontect.className='form-group has-error has-feedback';
				spcontect.className='glyphicon glyphicon-remove form-control-feedback';
				//ucon.style.width="300px";
				return false;
			   }
		
		}

	   else
	   {
		   ucon.style="border-color: red;";
			divcontect.className='form-group has-error has-feedback';
			spcontect.className='glyphicon glyphicon-remove form-control-feedback';
			//ucon.style.width="300px";
			return false;
		}
	}
	
	function checkPin()
	{
		var sppin=document.getElementById("sp_pin");
		var divpin=document.getElementById("div_pin");
		
		var upin=document.getElementById("pin");
		var pin=upin.value;
		var len=pin.length;
		var numbers = /^\(?([1-9]{1})\)?[-. ]?([0-9]{5})$/;
	   
	   if(len>=6)
		{
		   if (upin.value.match(numbers)){
			   upin.style="border-color: green;";
				//upin.style.width="300px";
				divpin.className='form-group has-success has-feedback';
				sppin.className='glyphicon glyphicon-ok form-control-feedback';
				return true;
		   }
		   else{
			   
			   upin.style="border-color: red;";
				divpin.className='form-group has-error has-feedback';
				sppin.className='glyphicon glyphicon-remove form-control-feedback';
				//upin.style.width="300px";
				return false;
			   
		   }
				
		 }

	   else
	   {
		   upin.style="border-color: red;";
			divpin.className='form-group has-error has-feedback';
			sppin.className='glyphicon glyphicon-remove form-control-feedback';
			//upin.style.width="300px";
			return false;
		}
	}
	function checkDesctiption() {
		var spadd=document.getElementById("sp_desctiption");
	    var divadd=document.getElementById("div_desctiption")
		
	    var add=document.getElementById("descr");
	    var vadd=add.value;
		vadd=vadd.trim();
		
		if(vadd == "")
		{
			add.style= "border-color: red;";
			divadd.className='form-group has-error has-feedback';
			spadd.className='glyphicon glyphicon-remove form-control-feedback';
			//add.style.width="300px";
			return false;
		}
		else
		{
			add.style="border-color: green;";
			//add.style.width="300px";
			divadd.className='form-group has-success has-feedback';
			spadd.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}
	}
	
	function checkAddress() {
		
		var spadd=document.getElementById("sp_add");
	    var divadd=document.getElementById("div_add")
		
	    var add=document.getElementById("address");
	    var vadd=add.value;
		vadd=vadd.trim();
		//var letter=/^[a-zA-Z]+$/;
		
		if(vadd == "")
		{
			//alert("address");
			add.style= "border-color: red;";
			divadd.className='form-group has-error has-feedback';
			spadd.className='glyphicon glyphicon-remove form-control-feedback';
			//add.style.width="300px";
			return false;
		}
		else
		{
			add.style="border-color: green;";
			//add.style.width="300px";
			divadd.className='form-group has-success has-feedback';
			spadd.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}
	}
	function validateCountry()
	{ 
		var spcountry=document.getElementById("sp_country");
		var divcountry=document.getElementById("div_country");
		
		var country=document.getElementById("country");
		var scountry=country.options[country.selectedIndex].text;
		if(scountry=="Select Country")
		{
			country.style="border-color: red;";
			//country.style= "border-color: red;";
			divcountry.className='form-group has-error has-feedback';
			spcountry.className='glyphicon glyphicon-remove form-control-feedback';
			//country.style.width="300px";
			return false;
		}
		else
		{
			country.style="border-color: green;";
			//add.style="border-color: green;";
			//country.style.width="300px";
			divcountry.className='form-group has-success has-feedback';
			spcountry.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}	
	}
	
	function validateState()
	{
		var spstate=document.getElementById("sp_state");
		var divstate=document.getElementById("div_state");
		
		var state=document.getElementById("state");
		var sstate=state.options[state.selectedIndex].text;
		if(sstate=="Select State" || sstate=="")
		{
			state.style="border-color: red;";
			divstate.className='form-group has-error has-feedback';
			spstate.className='glyphicon glyphicon-remove form-control-feedback';
			//state.style.width="300px";
			return false;
		}
		else
		{
			state.style="border-color: green;";
			//state.style.width="300px";
			divstate.className='form-group has-success has-feedback';
			spstate.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}	
	}
	function validateCity()
	{
		var spcity=document.getElementById("sp_city");
		var divcity=document.getElementById("div_city");
		
		var city=document.getElementById("city");
		var scity=city.options[city.selectedIndex].text;
		if(scity=="Select City" || scity=="")
		{
			city.style="border-color: red;";
			divcity.className='form-group has-error has-feedback';
			spcity.className='glyphicon glyphicon-remove form-control-feedback';
			//city.style.width="300px";
			return false;
		}
		else
		{
			city.style="border-color: green;";
			//state.style="border-color: green;";
			//city.style.width="300px";
			divcity.className='form-group has-success has-feedback';
			spcity.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}	
	}
	
	function validateLevel()
	 { 
	 	var spstream1=document.getElementById("sp_stream1");
	 	var divstream1=document.getElementById("div_stream1");
	 	
	 	var stream1=document.getElementById("level");
	 	var sstream=stream1.options[stream1.selectedIndex].text;
	 	if(sstream=="Select Level")
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

	
	function checkMail()
	{
		var spmail=document.getElementById("sp_mail");
		var divmail=document.getElementById("div_mail");
		
		var umail=document.getElementById("mail");
		var emailaddress=umail.value;
		var letter= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		
	 if (umail.value.match(letter)){
			   umail.style="border-color: green;";
				//upin.style.width="300px";
				divmail.className='form-group has-success has-feedback';
				spmail.className='glyphicon glyphicon-ok form-control-feedback';
				return true;
		   }
		   else{
			   
			   umail.style="border-color: red;";
				divmail.className='form-group has-error has-feedback';
				spmail.className='glyphicon glyphicon-remove form-control-feedback';
				//upin.style.width="300px";
				return false;
			   
		   }
	}

	function validateAll()
	{
		var clientName=checkClientName();
		var personName=checkPersonName();
		var contact=checkContact();
		var pinCode=checkPin();
		var description=checkDesctiption();
		var address=checkAddress();
		var country=validateCountry();
		var state=validateState();
		var city=validateCity();
		var level=validateLevel();
		var mail=checkMail();
		
		if(clientName && personName && contact && pinCode && description && address 
				&& country && state && city && level && mail)
		{return true;}
		else
		{return false;}
	}
	
	</script>

</head>

<body>
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
		<!--   Big container   -->
		<div class="container" id="cont">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-2">
					<form action="<%=request.getContextPath()%>/add_client" method="post" enctype="multipart/form-data" onsubmit="return validateAll()">
						<!--      Wizard container        -->
						<div class="wizard-container" style="margin-top: -90px;">

							<div class="card wizard-card" data-color="orange"
								id="wizardProfile">
								<!--        You can switch ' data-color="orange" '  with one of the next bright colors: "blue", "green", "orange", "red"          -->

								<div class="wizard-header">
									<h3>
										<b>CLIENT</b> PROFILE <br>
									</h3>
								</div>

								<div class="wizard-navigation">
									<ul>
										<li><a href="#about" data-toggle="tab">About</a></li>
										<!-- <li><a href="#account" data-toggle="tab">Account</a></li>
	                            <li><a href="#address" data-toggle="tab">Address</a></li> -->
									</ul>

								</div>
								 <div class="tab-content">
									 <div class="tab-pane" id="about"> 
										<div class="row">
											<div class="col-sm-4 col-sm-offset-1">
												<div class="picture-container">
													<div class="picture">
														<img src="images/default-avatar.png" class="picture-src"
															id="wizardPicturePreview" title="" /> <input type="file"
															id="wizard-picture" name="clientImg">
													</div>
													<h6>Choose Picture</h6>
									 			</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group" id="clientName">
													<label>Client Name </label> <input name="clientName"
														id="cName" onchange="checkClientName()" type="text" class="form-control"
														placeholder="Client Name...">
														<span id="sp_Client_Name"></span>
												</div>
												<div class="form-group" id="div_desctiption">
													<label>Description </label>
													<textarea rows="4" id="descr" onchange="checkDesctiption()" name="description" class="form-control"
														placeholder="fill details of company"></textarea>
														<span id="sp_desctiption"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="pnames">
													<label>Person Name </label> <input name="personName"
														type="text" id="pName" onchange="checkPersonName()" class="form-control"
														placeholder="Person Name...">
														<span id="sp_FirstName"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_contect">
													<label>Person Mobile </label> <input name="personMobile"
													id="contact" maxlength="10" onchange="checkContact()"
														type="text" class="form-control"
														placeholder="Person Mobile...">
														<span id="sp_contect"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_mail">
													<label>Email </label> <input name="personEmail" id="mail"
														onchange="checkMail()" type="email" class="form-control"
														placeholder="Client Email...">
														<span id="sp_mail"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_pin">
													<label>PinCode </label> <input name="pinNumber" maxlength="6" type="text"
														id="pin" onchange="checkPin()" class="form-control" placeholder="PinCode...">
														<span id="sp_pin"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_country">
													<label>Country </label> <select name="country"
													 onchange="validateCountry()" id="country"
														class="form-control">
														<option></option>
													</select>
													<span id="sp_country"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_state">
													<label>State </label> <select name="state" id="state"
														onchange="validateState()" class="form-control">
														<option></option>
													</select>
													<span id="sp_state"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_city">
													<label>City </label> <select name="city" id="city"
														onchange="validateCity()" class="form-control">
														<option></option>
													</select>
													<span id="sp_city"></span>
												</div>
											</div>
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_add">
													<label>Location </label> <input name="location" onchange="checkAddress()" type="text"
														id="address" class="form-control" placeholder="Location..." style="">
												</div>
												<span id="sp_add"></span>
											</div>
											
											<div class="col-sm-10 col-sm-offset-1">
												<div class="form-group" id="div_stream1">
													<label>Level </label> <select name="level" id="level"
														onchange="validateLevel()" class="form-control">
														<option></option>
													</select>
													<span id="sp_stream1"></span>
												</div>
											</div>
										</div>
									</div>
									<div class="wizard-footer height-wizard">
										<div class="pull-right">
											<input type='submit'
												class='btn btn-finish btn-fill btn-warning btn-wd btn-sm'
												value='Register' />
										</div>

										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
						<!-- wizard container -->
					</form>
				</div>

			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.get("../../CountryController", function(gsonData) {
							var a = "<option value=''>Select Country</option>";
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
															"../../StateController?countryid="
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
															"../../CityController?stateid="
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
					});

	$(document).ready(function() {
		$(document).ready(function() {
			$.get("../../LevelCompanyController", function(gsonData) {
				var a = "<option value=''>Select Level</option>";
				$.each(gsonData, function(k, v) {
					a += "<option value='"+k+"'>" + v + "</option>";
				});
				$("#level").html(a);
			});
		});
	});
</script>
</html>
