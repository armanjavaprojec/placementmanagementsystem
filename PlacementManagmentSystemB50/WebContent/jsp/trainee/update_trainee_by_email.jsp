<!DOCTYPE html>
<%@page import="com.nacre.pms.util.StringConstants"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Multi Step Form with Progress Bar using jQuery and CSS3</title>
<!-- <script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>
<script type="text/javascript" src="../../assets/js/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"> -->



<link rel="stylesheet" href="<%=application.getContextPath()%>/css/multistep.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="<%=application.getContextPath()%>/js/validations_js1.js"></script>
 <script type="text/javascript">
	$("document").ready(function(){
 		$.get("<%=application.getContextPath()%>/getCountryController",function(data) 
 				{
 				 	 var country = "<option>select country</option>";
 				 	 $.each(data,function(k,v){
 				 		country = country+"<option value="+k+">"+v+"</option>";
 				 	 });
 				 	 /* alert(country) */
 				 	 $("#country").html(country);
 				 });
 		$("input").change(function() {
				$("#next1").hide();
			
			//	alert(checkFirstName()+ ""+ checkLastName() +""+ checkContact() +""+ checkDOB() +""+ checkMail())
	         if (checkFirstName() && checkLastName() && checkContact() && checkDOB()) {
	        //	alert("hi");
	             $("#next1").show();
	        
	        } 
 		});	
	         $("input").change(function() {
	 				$("#submit1").hide();
	 				
	 			/* 	var resAddress=checkAddrs();
	 				var resZipCode=checkZipcode();
	 				var resCountry=checkCountry();
	 				var resState=checkState();
	 				var resCity=checkCity(); */
	 				
	 				
	 			
	 			//	alert(checkFirstName()+ ""+ checkLastName() +""+ checkContact() +""+ checkDOB() +""+ checkMail())
	 	         if (checkAddrs() && checkZipcode() && checkCountry() && checkState()&&checkCity()) {
	 	         
	 	             $("#submit1").show();
	 	        
	 	        } 
	         });
 				$("#country").change(function(){
 					var countryid=$("#country").val();
					/*alert(country_id); */
 					var state = "<option>select state</option>";
 					$.get("<%=application.getContextPath()%>/getStateController?countryid="+countryid,function(data){
 						/* alert(data); */
 					 	 $.each(data,function(k,v){ 
 					 	 	state = state+"<option value="+k+">"+v+"</option>";
 					 	 });
 					 	 $("#state").html(state);
 					});
 				});//on change

 				$("#state").change(function(){
 					
 					var stateid=$("#state").val();
 					var city="<option>select city</option>";
 				 
 					$.get("<%=application.getContextPath()%>/getCityController?state_id="+stateid,function(data){
 					 
 					 	 $.each(data,function(k,v){
 					 	 	city = city+"<option value="+k+">"+v+"</option>";
 					 	 });
 					 	 $("#city").html(city);	
 					});
 				}); 
 				
		}); 
		
</script>
<!-- <script>
     $(document).ready(function() {
  
$(function() {
    $('#button1').attr('disabled', 'disabled');
});
 
$('input[type=text],input[type=date],input[type=number]').keyup(function() {
        
    if ($('#firstname').val() !=''&& $('#firstname').val().length>=4 &&
    $('#lastname').val() != '' && $('#lastname').val().length>=4&&
    $('#mobno').val() != ''&&   $('#mobno').val().length==10 
    &&  $('#dob').val() != '' &&  $('#dob').val().length>=8) {
      
        $('#button1').removeAttr('disabled');
    } else {
        $('#button1').attr('disabled', 'disabled');
    }
});
    });
</script>
<script>
     $(document).ready(function() {
  
$(function() {
    $('#sbtbtn').attr('disabled', 'disabled');
});
 
$('input[type=text],input[type=number]').keyup(function() {
        
	/* var scountry=country.options[country.selectedIndex].text;
	var sstate=state.options[state.selectedIndex].text;
	var scity=city.options[city.selectedIndex].text;
	 */
    if ($('#location').val() !=''&& $('#location').val().length>=4 &&
    $('#pincode').val() != '' && $('#pincode').val().length==6 ) {
      
        $('#sbtbtn').removeAttr('disabled');
    } else {
        $('#sbtbtn').attr('disabled', 'disabled');
    }
});
     });  
</script> -->


</head>
<body>
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/trainee_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/trainee_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
<br><br><br>
	<!-- multistep form -->
	<form id="msform"    action="<%=request.getContextPath()%>/update_trainee?email=<%=session.getAttribute(StringConstants._SESSION_EMAIL)%>"  enctype="multipart/form-data" method="post"  data-toggle="validator" role="form">
		<!-- progressbar -->
		
		<ul id="progressbar" style="align-items: center;">
			<li class="active">Personal Details</li>
			<li>Address Details</li><br><br><br> 
		 <fieldset>
			<h2 class="fs-title">Personal Details</h2>
			<div id="fname_div_id">
			First Name:<input class="a" type="text" name="firstname" id="firstname" value="${trainee.firstName}"  onchange="checkFirstName()"
			 readonly="readonly"/>
			<!-- onkeyup="if(this.textLength != 0) {button1.disabled = false} else {button1.disabled = true}" -->
			<span id="fname_sid"></span>
			</div>
			<div id="lname_div_id">
			Last name:<input class="a" type="text" name="lastname" value="${trainee.lastName}" id="lastname" onchange="checkLastName()"
			 /><br> 
			<!--  onkeyup="if(this.textLength == 0 && this.textLength=="null" ) {button1.disabled = true} else {button1.disabled = false}" -->
			<span id="lname_sid"></span>
			</div>
			<div id="mbl_div_id">
			Mobile Number:<input class="a" type="number" name="mobno" value="${trainee.mobno}" id="mobno" maxlength="10" onchange="checkContact()"
			 /><br><!-- onkeyup="if(this.textLength != 0) {button1.disabled = false} else {button1.disabled = true}" -->
			<span id="mbl_sid"></span>
			</div>
			
			<%-- <input class="a" type="email" name="email" value="${trainee.email}" id="id_email" />  --%>
			<div id="dob_div_id">
			Date Of Birth:<input class="a" type="date" name="dob" value="${trainee.dob}" id="dob" onchange="checkDOB()" /> 
			<span id="dob_sid"></span>
		    </div><br>
			 Image:<input class="a" type="file" name="image" id="image" />
			 <input type="button" id="next1" name="next" class="next action-button" value="Next" />
		</fieldset>
			
		<fieldset>
			<h2 class="fs-title">Address Details</h2>
			<div id="addrs_div_id">
			Location:<input class="a" type="text" name="location" value="${trainee.location}" id="location" onchange="checkAddrs()"/><span id="addrs_sid"></span>
			</div><br>
			<div id="div_zipcode_id">
	Pincode:<input class="a" type="number" name="pincode" value="${trainee.pincode}" id="pincode" onchange="checkZipcode()"  maxlength="6" />
	<span id="zipcode_sid"></span>
			</div><br>
			<div id="div_country_id">
				Country:<select name="country" id="country" onchange="validateCountry()"><option value="Select Country">Select Country</option></select>
                  <span id="country_sid"></span>
				</div><br>
			<div id="div_state_id">
				State:<select name="state" id="state" onchange="validateState()">
				<option value="Select State">Select State</option>
			</select><span id="state_sid"></span>
			</div><br>
			<div id="div_city_id">
			City:<select name="city" id="city"  onchange="validateCity()">
				<option value="Select City">Select City</option>
			</select>
			<span id="city_sid"></span>
			</div><br>
			 <input type="button" name="previous" class="previous action-button" value="Previous" />
			 <input type="submit" value="update"  id="submit1"  style="width:30%; height:41px;color:white; background-color:#4CAF59" >
 	</form>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>
	<script src="<%=application.getContextPath()%>/js/multistepjs.js"></script>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->

 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="JS/validation.js"></script>
<script type="text/javascript">
function checkFirstName()
{	
	alert();
	var sp_First=document.getElementById("fname_sid");
    var div_first=document.getElementById("fname_div_id")
	
    var first=document.getElementById("firstname");
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
function checkLastName()
{
	var sp_last=document.getElementById("lname_sid");
	var div_last=document.getElementById("lname_div_id");
	 
    var last=document.getElementById("lastname");
	var vlast=last.value;
	vlast=vlast.trim();
	var letter=/^[a-zA-Z]+$/;
	if(vlast == "")
	{
		last.style="border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		//last.style.width="300px";
		return false;
	}
	if(!last.value.match(letter)){
		last.style= "border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		//last.style.width="300px";
		return false;
	}
	
	else
	{
		last.style="border-color: green;";
		//last.style.width="300px";
		div_last.className='form-group has-success has-feedback';
		sp_last.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
}
function checkContact()
{
	var spcontect=document.getElementById("mbl_sid");
	var divcontect=document.getElementById("mbl_div_id");
	
	var ucon=document.getElementById("mobno");
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

function checkDOB(){
	var sp_dob=document.getElementById("dob_sid");
    var div_dob=document.getElementById("dob_div_id")
	
    var dob=document.getElementById("dob");
    var vdob=dob.value;
	vdob=vdob.trim();
//	var letter=/^[a-zA-Z]+$/;
	
	if(vdob == "")
	{
		dob.style= "border-color: red;";
		div_dob.className='form-group has-error has-feedback';
		sp_dob.className='glyphicon glyphicon-remove form-control-feedback';
		//dob.style.width="300px";
		return false;
	}
	else
	{
		dob.style="border-color: green;";
		//dob.style.width="300px";
		div_dob.className='form-group has-success has-feedback';
		sp_dob.className='glyphicon glyphicon-ok form-control-feedback';
		return true;
	}
	
}

function checkZipcode()
{
	var sppin=document.getElementById("zipcode_sid");
	var divpin=document.getElementById("div_zipcode_id");
	
	var upin=document.getElementById("pincode");
	var pin=upin.value;
	var len=pin.length;
	var numbers = /^\(?([1-9]{1})\)?[-. ]?([0-9]{5})$/;
   
   if(len==6)
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

function checkAddrs() {
	var spadd=document.getElementById("addrs_sid");
    var divadd=document.getElementById("addrs_div_id")
	
    var add=document.getElementById("location");
    var vadd=add.value;
	vadd=vadd.trim();
	//var letter=/^[a-zA-Z]+$/;
	
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
function validateCountry()
{ 
	var spcountry=document.getElementById("country_sid");
	var divcountry=document.getElementById("div_country_id");
	
	var country=document.getElementById("country");
	var scountry=country.options[country.selectedIndex].text;
	if(scountry=="select country" ||scountry=="" )
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
	var spstate=document.getElementById("state_sid");
	var divstate=document.getElementById("div_state_id");
	
	var state=document.getElementById("state");
	var sstate=state.options[state.selectedIndex].text;
	if(sstate=="select state" || sstate=="")
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
	var spcity=document.getElementById("city_sid");
	var divcity=document.getElementById("div_city_id");
	
	var city=document.getElementById("city");
	var scity=city.options[city.selectedIndex].text;
	if(scity=="select city")
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
 
 function validateAll()
{
	//alert("hello");
	var resFirstName=checkFirstName();
	var resLastName=checkLastName();
	var resContact=checkContact();
	var resdob=checkDOB();
	var resPincode=checkZipcode();
	var resLocation=checkAddrs();
	var resCountry=validateCountry();
	var resState=validateState();
	var resCity=validateCity();
	
	if(resFirstName && resLastName && resContact && resdob && resPincode && resLocation && resCountry &&
			resState && resCity){
		return true;
	}
	else{
		return false;
		}
} 
  
 
</script>
</body>
</html>