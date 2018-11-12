<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="apple-touch-icon" sizes="76x76" href="images/apple-icon.png">
<link rel="icon" type="image/png" href="images/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Client</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--     Fonts and icons     -->
<!-- 
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet">

 
<link href="../../css/bootstrap.min.css" rel="stylesheet" />
<link href="../../css/gsdk-bootstrap-wizard.css" rel="stylesheet" />

 
<link href="../../css/demo.css" rel="stylesheet" />

 -->
<!--   Core JS Files   -->
<script src="../../js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<!-- <script src="../../js/jquery.bootstrap.wizard.js" type="text/javascript"></script>
 -->
<!--  Plugin for the Wizard -->
<!-- <script src="../../js/gsdk-bootstrap-wizard.js"></script>
 -->
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
</style>


<!-- 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
<!-- <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 -->
 
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
function checkPersonNameReg()
{	
	var sp_First=document.getElementById("sp_per");
    var div_first=document.getElementById("div_per");
    
    var first=document.getElementById("id_person_name1");
    var vfirst=first.value;
	vfirst=vfirst.trim();
	 var letter=/^[a-zA-Z]+$/; 
	
	if(vfirst == "")
	{
		
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


	function checkContactReg()
	{
		var spcontect=document.getElementById("sp_cont");
		var divcontect=document.getElementById("div_cont");
		
		var ucon=document.getElementById("id_person_mobile1");
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
	
	function checkPinReg()
	{
		var sppin=document.getElementById("sp_pinCode");
		var divpin=document.getElementById("div_pinCode");
		
		var upin=document.getElementById("id_pincode1");
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
	
	function checkAddressReg() {
		
		var spadd=document.getElementById("sp_addAdd");
	    var divadd=document.getElementById("div_addAdd")
		
	    var add=document.getElementById("id_location1");
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
	function validateCountryReg()
	{ 
		//alert("1")
		var spcountry=document.getElementById("sp_countryReg");
		var divcountry=document.getElementById("div_countryReg");
		
		var country=document.getElementById("countryid");
		var scountry=country.options[country.selectedIndex].text;
		if(scountry=="Select Country" || scountry=="")
		{
			//alert("2")
			country.style="border-color: red;";
			//country.style= "border-color: red;";
			divcountry.className='form-group has-error has-feedback';
			spcountry.className='glyphicon glyphicon-remove form-control-feedback';
			//country.style.width="300px";
			return false;
		}
		else
		{
			//alert("3")
			country.style="border-color: green;";
			//add.style="border-color: green;";
			//country.style.width="300px";
			divcountry.className='form-group has-success has-feedback';
			spcountry.className='glyphicon glyphicon-ok form-control-feedback';
			return true;
		}	
	}
	
	function validateStateReg()
	{
		var spstate=document.getElementById("sp_stateReg");
		var divstate=document.getElementById("div_stateReg");
		
		var state=document.getElementById("stateid");
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
	function validateCityReg()
	{
		var spcity=document.getElementById("sp_cityReg");
		var divcity=document.getElementById("div_cityReg");
		
		var city=document.getElementById("cityid");
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
	
		
	function checkMailReg()
	{
		var spmail=document.getElementById("sp_mailReg");
		var divmail=document.getElementById("div_mailReg");
		
		var umail=document.getElementById("id_person_email1");
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

	function validateAllReg()
	{
		 var personNameReg=checkPersonNameReg();
		var contactReg=checkContactReg();
		var mailReg=checkMailReg();
		var countryReg=validateCountryReg();
		var stateReg=validateStateReg();
		var cityReg=validateCityReg();
		var addressReg=checkAddressReg();
		var pinCodeReg=checkPinReg();
		
		
		 if(personNameReg && contactReg && mailReg && countryReg 
				&& stateReg && cityReg && addressReg && pinCodeReg)
		{return true;}
		else
		{return false;} 
	}
	
	</script>
 
 
<!-- 
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
function checkPersonName()
{	
	var sp_First=document.getElementById("sp_FirstName");
    var div_first=document.getElementById("pnames");
    
    var first=document.getElementById("id_person_name");
    var vfirst=first.value;
	vfirst=vfirst.trim();
	 var letter=/^[a-zA-Z ]+$/; 
	//alert(vfirst);
	
	if(vfirst == "")
	{
		
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
		
		var ucon=document.getElementById("id_person_mobile");
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
		
		var upin=document.getElementById("id_pincode");
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
	
	function checkAddress() {
		
		var spadd=document.getElementById("sp_add");
	    var divadd=document.getElementById("div_add")
		
	    var add=document.getElementById("id_location");
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
		//alert("1")
		var spcountry=document.getElementById("sp_country");
		var divcountry=document.getElementById("div_country");
		
		var country=document.getElementById("country");
		var scountry=country.options[country.selectedIndex].text;
		if(scountry=="Select Country" || scountry=="")
		{
			//alert("2")
			country.style="border-color: red;";
			//country.style= "border-color: red;";
			divcountry.className='form-group has-error has-feedback';
			spcountry.className='glyphicon glyphicon-remove form-control-feedback';
			//country.style.width="300px";
			return false;
		}
		else
		{
			//alert("3")
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
	
		
	function checkMail()
	{
		var spmail=document.getElementById("sp_mail");
		var divmail=document.getElementById("div_mail");
		
		var umail=document.getElementById("id_person_email");
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
		var personName=checkPersonName();
		var contact=checkContact();
		var mail=checkMail();
		var country=validateCountry();
		var state=validateState();
		var city=validateCity();
		var address=checkAddress();
		var pinCode=checkPin();
		
		
		 if(personName && contact && mail && country && state && city && address && pinCode)
		{return true;}
		else
		{return false;} 
		
	}
	
</script>
	
	<!--  Resgister company Detail Validation -->
	

	
	
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
	//alert("h==================")
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




function editClientAddrs(caid)
{    //add clienpDowns();
	getDropDowns();
 	   $('#updateModal').modal('show'); 
	     $.get("<%=application.getContextPath()%>/EditClientAddrsDataController?clientAddrsId="+caid,function(data){
	    	 var ob=JSON.parse(data);
	    document.getElementById("id_person_name").value=ob.contactPresonName;
	    document.getElementById("id_person_mobile").value=ob.contactPresonMobileNO;
	    document.getElementById("id_person_email").value=ob.contactPresonNameEmail;
	    document.getElementById("id_pincode").value=ob.pincode;
	    document.getElementById("id_location").value=ob.location; 
	    document.getElementById("caddrsid").value=caid;  
	     });
}


function addClientAddrs(){
	$.get("<%=application.getContextPath()%>/CountryController", function(gsonData) {
		var a = "<option value=''>Select Country</option>";
		$.each(gsonData,
				function(k, v) {
					a += "<option value='"+k+"'>" + v
							+ "</option>";
				});
		$("#countryid").html(a);

	});

	$("#countryid")
			.change(
					function() {
						var countryid = $("#countryid").val();
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
											$("#stateid")
													.html(a);
										});

					});
	$("#stateid")
			.change(
					function() {
						var stateid = $("#stateid").val();
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
											$("#cityid")
													.html(a);
										});
					});
	 $('#registerModle').modal('show'); 
}
function viewAddress(cid){
	client_Addrs_id=cid;
	<%-- $.get("<%=application.getContextPath()%>/view_client_addrs_details?clientId="+client_Addrs_id, function(data) {	 
	}); --%>
	 window.location.href="<%=application.getContextPath()%>/view_client_addrs_details?clientId="+cid;
}	
</script>

	
<script>

</script>
<!-- <script src="alert/dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="alert/dist/sweetalert.css"> -->
</head>
<body class="no-skin">

	<div class="main-container" id="main-container">
	
	<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
	<jsp:include page="../../jsp/common/admin_header.jsp"></jsp:include>
	<jsp:include page="../../jsp/common/admin_menu.jsp"></jsp:include>
	<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
	<div class="page-content">
	<h4>
					<i class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue">
							<b class="blue" >Client Address Details</b> </i>
				</h4>
		<div style="color: :green; text-align: center; font-size: large;">
			<c:if test="${not empty result}">
	${result}
	
	
</c:if>
		</div>


		
		<!-- <button type="button" class="btn btn-primary"
			style="left: 1000px;" onclick="addClientAddrs()">Add Address</button>
 -->

<button type="button" class="btn btn-primary" style="left: 1000px;
									data-toggle="modal"
									onclick="addClientAddrs()">Add Address</button></td>

		<table class="table table-bordered">
			<thead>
				<tr class="row-name" style="font-size: 18px; color: #448aff;">
					<th>Sno</th>
					<th>Client person name</th>
					<th>Client person mobile</th>
					<th>Client person mail</th>
					<th>location</th>
					<th>pinCode</th>
					<th>city</th>
					<th>state</th>
					<th>country</th>
					<th>update</th>
					<!-- <th>Delete</th> -->
				</tr>
			</thead>
			<c:if test="${not empty addrs}">
				<c:forEach var="vo" items="${addrs}">
					<tbody>
						<tr>
							<td><c:out value="${vo.cno}"></c:out></td>
							<td><c:out value="${vo.contactPresonName}"></c:out></td>
							<td><c:out value="${vo.contactPresonMobileNO}"></c:out></td>
							<td><c:out value="${vo.contactPresonNameEmail}"></c:out></td>
							<td><c:out value="${vo.location}"></c:out></td>
							<td><c:out value="${vo.pincode}"></c:out></td>
							<td><c:out value="${vo.city}"></c:out></td>
							<td><c:out value="${vo.state}"></c:out></td>
							<td><c:out value="${vo.country}"></c:out></td>
							<td><button type="button" class="btn btn-info btn-lg"
									data-toggle="modal"
									onclick="editClientAddrs(${vo.clientAddressId})">Update</button></td>
						</tr>
					</tbody>
				</c:forEach>
			</c:if>
		</table>
	</div>
	<!-- MODAL END -->
	<form
		action="./update_client_addrs?clientId=${clientid}" method="POST" onsubmit="return validateAll()"
		enctype="multipart/form-data">
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
							<h4 class="modal-title">Update Client Address Details</h4>
						</div>
	<input type="hidden" name="caid" id="caddrsid">
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="pnames">
								<label>Person Name </label> <input name="personName" type="text"
									id="id_person_name" class="form-control"
									placeholder="Person Name..." onchange="checkPersonName()">
								<span id="sp_FirstName"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_contect">
								<label>Person Mobile </label> <input name="personMobile"
									type="text" id="id_person_mobile" maxlength="10"
									class="form-control" placeholder="Person Mobile..."
									onchange="checkContact()"> <span id="sp_contect"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_mail">
								<label>Email </label> <input name="personEmail" type="email"
									id="id_person_email" class="form-control"
									onchange="checkMail()" placeholder="Client Email..."> <span
									id="sp_mail"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_country">
								<label>Country </label> <select name="country" id="country"
									class="form-control" onchange="validateCountry()">
									<option></option>
								</select> <span id="sp_country"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_state">
								<label>State </label> <select name="state" id="state"
									class="form-control" onchange="validateState()">
									<option></option>
								</select> <span id="sp_state"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_city">
								<label>City </label> <select name="city" id="city"
									class="form-control" onchange="validateCity()">
									<option></option>
								</select> <span id="sp_city"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_add">
								<label>Location </label> <input name="location" type="text"
									id="id_location" class="form-control" onchange="checkAddress()"
									placeholder="Location..."> <span id="sp_add"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_pin">
								<label>PinCode </label> <input name="pincode" type="text"
									maxlength="6" id="id_pincode" onchange="checkPin()"
									class="form-control" placeholder="PinCode..."> <span
									id="sp_pin"></span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-default" id="yes" name="y">Update</button>
						 
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
 	 <div>
	<form
	action="<%=application.getContextPath()%>/add_client_addrs_details"
		onsubmit="return validateAllReg()" method="get"
		enctype="multipart/form-data">
		<div class="container">
			<!-- Trigger the modal with a button -->
			<!-- Modal -->
			<input type="hidden" name="cid" value="${clientid}">
			<div class="modal fade" id="registerModle" role="dialog">
				<div class="modal-dialog">
					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header"
							style="background-color: red; color: #fff">
							<button type="button" class="close" data-dismiss="modal"
								style="color: blue">&times;</button>
							<h4 class="modal-title">Register Client Address Details</h4>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_per">
								<label>Person Name </label> <input name="personName" type="text"
									id="id_person_name1" class="form-control"
									placeholder="Person Name..." onchange="checkPersonNameReg()">
								<span id="sp_per"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_cont">
								<label>Person Mobile </label> <input name="personMobile"
									type="text" id="id_person_mobile1" maxlength="10"
									class="form-control" placeholder="Person Mobile..."
									onchange="checkContactReg()"> <span id="sp_cont"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_mailReg">
								<label>Email </label> <input name="personEmail" type="email"
									id="id_person_email1" class="form-control"
									onchange="checkMailReg()" placeholder="Client Email..."> <span
									id="sp_mailReg"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_countryReg">
								<label>Country </label> <select name="country" id="countryid"
									class="form-control" onchange="validateCountryReg()">
									<option></option>
								</select> <span id="sp_countryReg"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_stateReg">
								<label>State </label> <select name="state" id="stateid"
									class="form-control" onblur="validateStateReg()">
									<option></option>
								</select> <span id="sp_stateReg"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_cityReg">
								<label>City </label> <select name="city" id="cityid"
									class="form-control" onblur="validateCityReg()">
									<option></option>
								</select> <span id="sp_cityReg"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_addAdd">
								<label>Location </label> <input name="location" type="text"
									id="id_location1" class="form-control" onchange="checkAddressReg()"
									placeholder="Location..."> <span id="sp_addAdd"></span>
							</div>
						</div>
						<div class="col-sm-10 col-sm-offset-1">
							<div class="form-group" id="div_pinCode">
								<label>PinCode </label> <input name="pincode" type="text"
									maxlength="6" id="id_pincode1" onblur="checkPinReg()"
									class="form-control" placeholder="PinCode..."> <span
									id="sp_pinCode"></span>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					  	<button type="submit" class="btn btn-default" id="yw" name="yes">Register</button>
					</div>
				</div>
			</div>
		</div>
	</form></div>
	<div>
		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
	
</body>
</html>