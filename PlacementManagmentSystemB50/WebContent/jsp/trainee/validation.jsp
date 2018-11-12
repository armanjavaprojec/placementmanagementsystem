<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script type="text/javascript">
function checkFirstName()
{	
	
	var sp_First=document.getElementById("sp_FirstName");
    var div_first=document.getElementById("div_first_name")
	
    var first=document.getElementById("firstname");
    var vfirst=first.value;
	vfirst=vfirst.trim();
	var letter=/^[a-zA-Z]+$/;
	
	if(vfirst == "")
	{
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		first.style.width="300px";
		
	}
	if(!first.value.match(letter)){
		first.style= "border-color: red;";
		div_first.className='form-group has-error has-feedback';
		sp_First.className='glyphicon glyphicon-remove form-control-feedback';
		first.style.width="300px";
		
	}
	else
	{
		first.style="border-color: green;";
		first.style.width="300px";
		div_first.className='form-group has-success has-feedback';
		sp_First.className='glyphicon glyphicon-ok form-control-feedback';
		
	}
}
function checkLastName()
{
	alert("iiiiii")
	var sp_last=document.getElementById("sp_LastName");
	var div_last=document.getElementById("div_last_name");
	 
    var last=document.getElementById("lastname");
	var vlast=last.value;
	vlast=vlast.trim();
	var letter=/^[a-zA-Z]+$/;
	if(vlast == "")
	{
		last.style="border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		last.style.width="300px";
		
	}
	if(!last.value.match(letter)){
		last.style= "border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		last.style.width="300px";
		
	}
	
	else
	{
		last.style="border-color: green;";
		last.style.width="300px";
		div_last.className='form-group has-success has-feedback';
		sp_last.className='glyphicon glyphicon-ok form-control-feedback';
		
	}
}
function checkContact()
{
	var spcontect=document.getElementById("sp_contect");
	var divcontect=document.getElementById("div_contect");
	
	var ucon=document.getElementById("mobno");
	var contact=ucon.value;
	var len=contact.length;
    var numbers = /^\(?([6-9]{1})\)?[-. ]?([0-9]{9})$/;
   if(len==10)
	{
	   if (ucon.value.match(numbers))
	   {
		
		   ucon.style="border-color: green;";
			ucon.style.width="300px";
			divcontect.className='form-group has-success has-feedback';
			spcontect.className='glyphicon glyphicon-ok form-control-feedback';
	
			
	   }
	   else{
		   ucon.style="border-color: red;";
			divcontect.className='form-group has-error has-feedback';
			spcontect.className='glyphicon glyphicon-remove form-control-feedback';
			ucon.style.width="300px";
			
		   }
	
	}

   else
   {
	   ucon.style="border-color: red;";
		divcontect.className='form-group has-error has-feedback';
		spcontect.className='glyphicon glyphicon-remove form-control-feedback';
		ucon.style.width="300px";
		
	}
}
/* function checkMail()
{
	var spmail=document.getElementById("sp_mail");
	var divmail=document.getElementById("div_mail");
	
	var umail=document.getElementById("mail");
	var emailaddress=umail.value;
	//var letter= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(emailaddress == "")
	{
		umail.style="border-color: red;";
		divmail.className='form-group has-error has-feedback';
		spmail.className='glyphicon glyphicon-remove form-control-feedback';
		umail.style.width="300px";
		
	}
	
	
	else
	{
		if(!validateEmail(emailaddress)) 
		{ 	
			umail.style="border-color: red;";
			divmail.className='form-group has-error has-feedback';
			spmail.className='glyphicon glyphicon-remove form-control-feedback';
			umail.style.width="300px";
			
		}
		else
		{
			umail.style="border-color: green;";
			umail.style.width="300px";
			divmail.className='form-group has-success has-feedback';
			spmail.className='glyphicon glyphicon-ok form-control-feedback';
		
		}
	}
}
 */function checkDOB(){
	var sp_dob=document.getElementById("sp_dob");
    var div_dob=document.getElementById("div_dob")
	var dob=document.getElementById("dob");
    var vdob=dob.value;
	vdob=vdob.trim();
//	var letter=/^[a-zA-Z]+$/;
	
	if(vdob == "")
	{
		dob.style= "border-color: red;";
		div_dob.className='form-group has-error has-feedback';
		sp_dob.className='glyphicon glyphicon-remove form-control-feedback';
		dob.style.width="300px";
		
	}
	else
	{
		dob.style="border-color: green;";
		dob.style.width="300px";
		div_dob.className='form-group has-success has-feedback';
		sp_dob.className='glyphicon glyphicon-ok form-control-feedback';
		
	}
	
}
/* function checkPassword(){
	//alert("hello");
	var sppassword=document.getElementById("sp_password");
	var divpassword=document.getElementById("div_password");
	var spinstc=document.getElementById("sp_instrc");
	
	var psw=document.getElementById("password");
	var password=psw.value;
	var len=password.length;
	var pswletter=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,15}$/;
   if(len>=6)
	{
	   if (psw.value.match(pswletter))
	   {
		   psw.style="border-color: green;";
			psw.style.width="300px";
			divpassword.className='form-group has-success has-feedback';
			sppassword.className='glyphicon glyphicon-ok form-control-feedback';
			
			
	   }
	   else{
		//   spinstc.style.display="block;";
		    psw.style="border-color: red;";
			divpassword.className='form-group has-error has-feedback';
			sppassword.className='glyphicon glyphicon-remove form-control-feedback';
			spinstc.className='alert alert-warning';
			psw.style.width="300px";
			psw.value="";
		    
	   }
	}
   else
   {
	   psw.style="border-color: red;";
	   divpassword.className='form-group has-error has-feedback';
	   sppassword.className='glyphicon glyphicon-remove form-control-feedback';
	   spinstc.className='alert alert-warning';
	   psw.style.width="300px";
		psw.value="";
	}

}
 */function checkAddress() {
	var spadd=document.getElementById("sp_add");
    var divadd=document.getElementById("div_add")
	
    var add=document.getElementById("location");
    var vadd=add.value;
	vadd=vadd.trim();
	//var letter=/^[a-zA-Z]+$/;
	
	if(vadd == "")
	{
		add.style= "border-color: red;";
		divadd.className='form-group has-error has-feedback';
		spadd.className='glyphicon glyphicon-remove form-control-feedback';
		add.style.width="300px";
		
	}
	else
	{
		add.style="border-color: green;";
		add.style.width="300px";
		divadd.className='form-group has-success has-feedback';
		spadd.className='glyphicon glyphicon-ok form-control-feedback';
		
	}
}
function validateCountry()
{ 
	var spcountry=document.getElementById("sp_country");
	var divcountry=document.getElementById("div_country");
	
	var country=document.getElementById("country");
	var scountry=country.options[country.selectedIndex].text;
	if(scountry=="SELECT")
	{
		country.style="border-color: red;";
		//country.style= "border-color: red;";
		divcountry.className='form-group has-error has-feedback';
		spcountry.className='glyphicon glyphicon-remove form-control-feedback';
		country.style.width="300px";
		
	}
	else
	{
		country.style="border-color: green;";
		//add.style="border-color: green;";
		country.style.width="300px";
		divcountry.className='form-group has-success has-feedback';
		spcountry.className='glyphicon glyphicon-ok form-control-feedback';
		
	}	
}

function validateState()
{
	var spstate=document.getElementById("sp_state");
	var divstate=document.getElementById("div_state");
	
	var state=document.getElementById("state");
	var sstate=state.options[state.selectedIndex].text;
	if(sstate=="SELECT")
	{
		state.style="border-color: red;";
		divstate.className='form-group has-error has-feedback';
		spstate.className='glyphicon glyphicon-remove form-control-feedback';
		state.style.width="300px";

	}
	else
	{
		state.style="border-color: green;";
		state.style.width="300px";
		divstate.className='form-group has-success has-feedback';
		spstate.className='glyphicon glyphicon-ok form-control-feedback';
	}	
}

function validateCity()
{
	var spcity=document.getElementById("sp_city");
	var divcity=document.getElementById("div_city");
	
	var city=document.getElementById("city");
	var scity=city.options[city.selectedIndex].text;
	if(scity=="SELECT")
	{
		city.style="border-color: red;";
		divcity.className='form-group has-error has-feedback';
		spcity.className='glyphicon glyphicon-remove form-control-feedback';
		city.style.width="300px";
	}
	else
	{
		city.style="border-color: green;";
		//state.style="border-color: green;";
		city.style.width="300px";
		divcity.className='form-group has-success has-feedback';
		spcity.className='glyphicon glyphicon-ok form-control-feedback';
	}	
}
 
function checkPin()
{
	var sppin=document.getElementById("sp_pin");
	var divpin=document.getElementById("div_pin");
	
	var upin=document.getElementById("pincode");
	var pin=upin.value;
	var len=pin.length;
	var numbers = /^\(?([1-9]{1})\)?[-. ]?([0-9]{5})$/;
   
   if(len>=6)
	{
	   if (upin.value.match(numbers)){
		   upin.style="border-color: green;";
			upin.style.width="300px";
			divpin.className='form-group has-success has-feedback';
			sppin.className='glyphicon glyphicon-ok form-control-feedback';
	   }
	   else{
		   
		   upin.style="border-color: red;";
			divpin.className='form-group has-error has-feedback';
			sppin.className='glyphicon glyphicon-remove form-control-feedback';
			upin.style.width="300px";
			
		   
	   }
			
	 }

   else
   {
	   upin.style="border-color: red;";
		divpin.className='form-group has-error has-feedback';
		sppin.className='glyphicon glyphicon-remove form-control-feedback';
		upin.style.width="300px";
		
	}
}

/* function checksscyears(){
	 var spssc=document.getElementById("sp_ssc");
		var divssc=document.getElementById("div_ssc");
		
		var ssc=document.getElementById("ssc");
		var sssc=ssc.options[ssc.selectedIndex].text;
		if(sssc=="SELECT")
		{
			ssc.style="border-color: red;";
			divssc.className='form-group has-error has-feedback';
			spssc.className='glyphicon glyphicon-remove form-control-feedback';
			ssc.style.width="300px";
		}
		else
		{
			ssc.style="border-color: green;";
			//state.style="border-color: green;";
			ssc.style.width="300px";
			divssc.className='form-group has-success has-feedback';
			spssc.className='glyphicon glyphicon-ok form-control-feedback';
		}	
	 
	 
}
 
  

function checkMark()
{
	var spmark=document.getElementById("sp_mark");
	var divmark=document.getElementById("div_mark");
	
	var umark=document.getElementById("mark");
	var mark=umark.value;
	var len=mark.length;
   
   if(mark>=35 && mark<=100)
	{
		
		   umark.style="border-color: green;";
			umark.style.width="300px";
			divmark.className='form-group has-success has-feedback';
			spmark.className='glyphicon glyphicon-ok form-control-feedback';
	
			
	 }

   else
   {
	   umark.style="border-color: red;";
		divmark.className='form-group has-error has-feedback';
		spmark.className='glyphicon glyphicon-remove form-control-feedback';
		umark.style.width="300px";
		
	}
}

function checkMarkIntermidate()
{
	var spmark=document.getElementById("sp_mark1");
	var divmark=document.getElementById("div_mark1");
	
	var umark=document.getElementById("mark1");
	var mark=umark.value;
	var len=mark.length;
   
   if(mark>=35 && mark<=100)
	{
		
		   umark.style="border-color: green;";
			umark.style.width="300px";
			divmark.className='form-group has-success has-feedback';
			spmark.className='glyphicon glyphicon-ok form-control-feedback';
	
			
	 }

   else
   {
	   umark.style="border-color: red;";
		divmark.className='form-group has-error has-feedback';
		spmark.className='glyphicon glyphicon-remove form-control-feedback';
		umark.style.width="300px";
		
	}
}
function checkMarkGraduation()
{
	var spmark=document.getElementById("sp_mark2");
	var divmark=document.getElementById("div_mark2");
	
	var umark=document.getElementById("mark2");
	var mark=umark.value;
	var len=mark.length;
   
   if(mark>=35 && mark<=100)
	{
		
		   umark.style="border-color: green;";
			umark.style.width="300px";
			divmark.className='form-group has-success has-feedback';
			spmark.className='glyphicon glyphicon-ok form-control-feedback';
	
			
	 }

   else
   {
	   umark.style="border-color: red;";
		divmark.className='form-group has-error has-feedback';
		spmark.className='glyphicon glyphicon-remove form-control-feedback';
		umark.style.width="300px";
		
	}
}

function validateStream()
{ 
	var spstream=document.getElementById("sp_stream");
	var divstream=document.getElementById("div_stream");
	
	var stream=document.getElementById("id_stream");
	var sstream=stream.options[stream.selectedIndex].text;
	if(sstream=="SELECT")
	{
		stream.style="border-color: red;";
		//country.style= "border-color: red;";
		divstream.className='form-group has-error has-feedback';
		spstream.className='glyphicon glyphicon-remove form-control-feedback';
		stream.style.width="300px";
		
	}
	else
	{
		stream.style="border-color: green;";
		//add.style="border-color: green;";
		stream.style.width="300px";
		divstream.className='form-group has-success has-feedback';
		spstream.className='glyphicon glyphicon-ok form-control-feedback';
		
	}	
}
function validateGPost()
{
	var spgpost=document.getElementById("sp_gpost");
	var divgpost=document.getElementById("div_gpost");
	
	var post=document.getElementById("id_gpost");
	var spost=post.options[post.selectedIndex].text;
	if(spost=="SELECT")
	{
		post.style="border-color: red;";
		divgpost.className='form-group has-error has-feedback';
		spgpost.className='glyphicon glyphicon-remove form-control-feedback';
		post.style.width="300px";
	}
	else
	{
		post.style="border-color: green;";
		//state.style="border-color: green;";
		post.style.width="300px";
		divgpost.className='form-group has-success has-feedback';
		spgpost.className='glyphicon glyphicon-ok form-control-feedback';
	}	
}
 function checkPostMarkGraduation(){
	 var spmark4=document.getElementById("sp_gpost2");
		var divmark4=document.getElementById("div_gpost2");
		
		var umark=document.getElementById("gpost2");
		var mark=umark.value;
		var len=mark.length;
	   
	   if(mark>=35 && mark<=100)
		{
			
		   umark.style="border-color: green;";
			//add.style="border-color: green;";
			umark.style.width="300px";
			divmark4.className='form-group has-success has-feedback';
			spmark4.className='glyphicon glyphicon-ok form-control-feedback';
			
				
		 }

	   else
	   {
		   umark.style="border-color: red;";
			divmark.className='form-group has-error has-feedback';
			spmark.className='glyphicon glyphicon-remove form-control-feedback';
			umark.style.width="300px";
			
		}
	 
	 
 }

 function validateStream1()
 { 
 	var spstream1=document.getElementById("sp_stream1");
 	var divstream1=document.getElementById("div_stream1");
 	
 	var stream1=document.getElementById("id_stream1");
 	var sstream=stream1.options[stream1.selectedIndex].text;
 	if(sstream=="SELECT")
 	{
 		stream1.style="border-color: red;";
 		//country.style= "border-color: red;";
 		divstream1.className='form-group has-error has-feedback';
 		spstream1.className='glyphicon glyphicon-remove form-control-feedback';
 		stream1.style.width="300px";
 		
 	}
 	else
 	{
 		stream1.style="border-color: green;";
 		//add.style="border-color: green;";
 		stream1.style.width="300px";
 		divstream1.className='form-group has-success has-feedback';
 		spstream1.className='glyphicon glyphicon-ok form-control-feedback';
 		
 	}	
 }
 function checkINyears(){
	 var spiyop=document.getElementById("sp_iyop");
		var diviyop=document.getElementById("div_iyop");
		
		var iyop=document.getElementById("iyop");
		var siyop=iyop.options[iyop.selectedIndex].text;
		if(siyop=="SELECT")
		{
			iyop.style="border-color: red;";
			diviyop.className='form-group has-error has-feedback';
			spiyop.className='glyphicon glyphicon-remove form-control-feedback';
			iyop.style.width="300px";
		}
		else
		{
			iyop.style="border-color: green;";
			//state.style="border-color: green;";
			iyop.style.width="300px";
			diviyop.className='form-group has-success has-feedback';
			spiyop.className='glyphicon glyphicon-ok form-control-feedback';
		}	
	 
	 
 }
 
  
 function checkgyopyears(){
	 
	 var spgyop=document.getElementById("sp_gyop");
		var divgyop=document.getElementById("div_gyop");
		
		var gyop=document.getElementById("gyop");
		var sgyop=gyop.options[gyop.selectedIndex].text;
		if(sgyop=="SELECT")
		{
			gyop.style="border-color: red;";
			divgyop.className='form-group has-error has-feedback';
			spgyop.className='glyphicon glyphicon-remove form-control-feedback';
			gyop.style.width="300px";
		}
		else
		{
			gyop.style="border-color: green;";
			//state.style="border-color: green;";
			gyop.style.width="300px";
			divgyop.className='form-group has-success has-feedback';
			spgyop.className='glyphicon glyphicon-ok form-control-feedback';
		}	
	 
 
 } */
 
function validateAll()
{
	//var resMail=checkMail();
	var resFirstName=checkFirstName();
	var resLastName=checkLastName();
	var resContact=checkContact();
	//var resPassword=checkPassword();
	var resdob=checkDOB();
	var resCountry=validateCountry();
	var resState=validateState();
	var resCity=validateCity();
	var resAddress=checkAddress();
	var resPin=checkPin();
	//var resSSCyop1=checksscyears();
	//var ressscmark=checkMark();
	//var resINyop=checkINyears();
	//var resInmark=checkMarkIntermidate();
	//var resgyop=checkgyopyears();
	//var resgmark=checkMarkGraduation();
	//var resstream=validateStream();
	
	if(resFirstName && resLastName && resContact && resCountry 
			&& resState && resCity && resAddress && resPin  && resdob)
	{return true;}
	else
	{return false;}
}




</script>
</head>
<body>
<form onsubmit="return validateAll()"  action="/updateTraineeController?uid=${trainee.uid}"method="post">
<table>

<tr>
<td><b>Enter First Name : </b></td>
<td>
<div id="div_first_name">
<input type="text" id="firstname"  name="firstname" onchange="checkFirstName()" 
 maxlength="50" class="form-control"  value="${ trainee.firstname}"  style="width:300px">
<span id="sp_FirstName"></span>
</div>
</td>

</tr>
</div>
<tr>
<td><b>Enter Last Name : </b></td>
<td>
<div id="div_last_name">
<input type="text" id="lastname" name="lastname" onchange="checkLastName()" 
maxlength="50" class="form-control" value="${ trainee.lastname}"   style="width:300px">
<span id="sp_LastName"></span>
</div>
</td>
</tr>
<tr>
<td><b>Enter Contact : </b></td>
<td>
<div id="div_contect">
<input type="text" id="mobno" name="mobno" maxlength="10" onchange="checkContact()"
 class="form-control" value="${ trainee.mobileno}" >
 <span id="sp_contect"></span>
</div>
</td>
</tr>
<!-- <tr>
<td><b>Enter Mail : </b></td>
<td>
<div id="div_mail">
<input type="text" id="mail" name="mail" maxlength="50" onchange="checkMail()"
 class="form-control" placeholder="ENTER MAIL">
 <span id="sp_mail"></span>
</div>
</td>
</tr>
<tr>
<td><b>Enter Password : </b></td>
<td>
<div id="div_password">
<input type="password" id="password" name="password" maxlength="15" onchange="checkPassword()"
 class="form-control" placeholder="ENTER PASSWORD">
 <span id="sp_password"></span>
</div>
</td>
<td><span id="sp_instrc">
<h6>*Password must contain at least one lowercase letter, one uppercase letter, one numeric digit, and one special character</h6>
</span></td>
</tr>
<tr>
<td><b>Gender : </b></td>
<td>
<div id="div_gender">
<label for="male">Male</label>
<input type="radio" id="male" name="gender" value="male"  onchange="checkGender()" checked>
<label for="Female">Female</label>
 <input type="radio" id="female" name="gender" value="female"  onchange="checkGender()">
 <span id="sp_password"></span>
</div>
</td>
</tr>
<tr> -->
<td><b>Enter D.O.B : </b></td>
<td>
<div id="div_dob">
<input type="Date" value="${trainee.dob}" id="dob" name="dob"  onchange="checkDOB()"
 class="form-control"  >
 <span id="sp_dob"></span>
</div>
</td>
</tr>
<tr>
<td><b>Enter Address : </b></td>
<td>
<div id="div_add">
<input type="text" value="${trainee.location}" id="location" name="location" onchange="checkAddress()"
 maxlength="80" class="form-control" >
 <span id="sp_add"></span>
</div>
</td>
</tr>
<tr>
<td><b>Enter Image : </b></td>
<td>
<div id="div_add">
<input type="text" value="${trainee.image}" id="image" name="image" onchange="checkAddress()"
 maxlength="80" class="form-control" >
 <span id="sp_add"></span>
</div>
</td>
</tr>
<tr>
<td><b>Select Country : </b></td>
<td>
<div id="div_country">
	<select name="country"id="country" onchange="validateCountry()" class="form-control">
		<option value="select">SELECT</option>
		<option value="india">INDIA</option>
		<option value="usa">USA</option>
	</select>
	<span id="sp_country"></span>
</div>
</td>
</tr>

<tr>
<td><b>Select State : </b></td>
<td>
<div id="div_state">
	<select name="state" id="state" class="form-control" onchange="validateState()">
		<option value="select">SELECT</option>
		<option value="mha">Maharastra</option>
		<option value="mp" >Madhyapradesh</option>
	</select>
	<span id="sp_state"></span>
	</div>
</td>
</tr>

<tr>
<td><b>Select City : </b></td>
<td>
<div id="div_city">
	<select name="city" id="city" class="form-control" onchange="validateCity()">
		<option value="select">SELECT</option>
		<option value="aurng">Aurangabad</option>
		<option value="beed">Beed</option>
		<option value="indaur">Indore</option>
	</select>
	<span id="sp_city"></span>
</div>
</td>
</tr>
<tr>
<td><b>Enter Pin No : </b></td>
<td>
<div id="div_pin">
<input type="text" value="${trainee.pincode}"
				id="pincode"  name="pincode" maxlength="6" onchange="checkPin()"
 class="form-control" placeholder="ENTER PIN">
 <span id="sp_pin"></span>
</div>
</td>
</tr>


<!-- <tr>
<td><b>SSC Year Of Passing : </b></td>
<td>
<div id="div_ssc">
	<select name="ssc" id="ssc" onchange="checksscyears()" class="form-control">
		<option value="select">SELECT</option>
		<option value="2018">2018</option>
		<option value="2017">2017</option>
		<option value="2017">2016</option>
		<option value="2017">2015</option>
	</select>
	<span id="sp_ssc"></span>
</div>
</td>
</tr>
<tr>
<td><b>SSC Percentage : </b></td>
<td>
<div id="div_mark">
<input type="text" id="mark" name="mark" maxlength="5" onchange="checkMark()"
 class="form-control" placeholder="ENTER MARK">
 <span id="sp_mark"></span>
</div>
</td>
</tr>
<tr>
<td><b>Intermediate Year Of Passing : </b></td>
<td>
<div id="div_iyop">
	<select name="iyop" id="iyop" onchange="checkINyears()" class="form-control">
		<option value="select">SELECT</option>
		<option value="2018">2018</option>
		<option value="2017">2017</option>
		<option value="2017">2016</option>
		<option value="2017">2015</option>
	</select>
	<span id="sp_iyop"></span>
</div>
</td>
</tr>

<tr>
<td><b>Intermediate Percentage : </b></td>
<td>
<div id="div_mark1">
<input type="text" id="mark1" name="mark1" maxlength="5" onchange="checkMarkIntermidate()"
 class="form-control" placeholder="ENTER MARK">
 <span id="sp_mark1"></span>
</div>
</td>
</tr>
<tr>
<td><b>Graduation Year Of Passing : </b></td>
<td>
<div id="div_gyop">
	<select name="gyop" id="gyop" onchange="checkgyopyears()" class="form-control">
		<option value="select">SELECT</option>
		<option value="2018">2018</option>
		<option value="2017">2017</option>
		<option value="2017">2016</option>
		<option value="2017">2015</option>
	</select>
	<span id="sp_gyop"></span>
</div>
</td>
</tr>
<tr>
<td><b>Graduation Percentage : </b></td>
<td>
<div id="div_mark2">
<input type="text" id="mark2" name="mark2" maxlength="5" onchange="checkMarkGraduation()"
 class="form-control" placeholder="ENTER MARK">
 <span id="sp_mark2"></span>
</div>
</td>
</tr>
<tr>
<td><b>Select Stream : </b></td>
<td>
<div id="div_stream">
	<select name="stream" id="id_stream" onchange="validateStream()" class="form-control">
		<option value="select">SELECT</option>
		<option value="india">Information Technology</option>
		<option value="usa">Civil Engg</option>
	</select>
	<span id="sp_stream"></span>
</div>
</td>
</tr>

<tr>
<td><b>Post Graduation Year Of Passing : : </b></td>
<td>
<div id="div_gpost">
	<select name="gpost" id="id_gpost" onchange="validateGPost()" class="form-control">
		<option value="select">SELECT</option>
		<option value="2018">2018</option>
		<option value="2017">2017</option>
		<option value="2017">2016</option>
		<option value="2017">2015</option>
	</select>
	<span id="sp_gpost"></span>
</div>
</td>
<td><span id="sp_postg">
<h6>optional</h6>
</span></td>

</tr>

<tr>
<td><b>Post Graduation Percentage : </b></td>
<td>
<div id="div_gpost2">
<input type="text" id="gpost2" name="gpost2" maxlength="5" onchange="checkPostMarkGraduation()"
 class="form-control" placeholder="ENTER MARK">
 <span id="sp_gpost2"></span>
</div>
</td>
<td><span id="sp_postm">
<h6>optional</h6>
</tr> -->
<!-- <tr>
<td><b>Select Stream for Post Graduation: </b></td>
<td>
<div id="div_stream1">
	<select name="stream1" id="id_stream1" onchange="validateStream1()" class="form-control">
		<option value="select">SELECT</option>
		<option value="india">Information Technology</option>
		<option value="usa">Civil Engg</option>
	</select>
	<span id="sp_stream1"></span>
</div>
</td>
<td><span id="sp_posts">
<h6>optional</h6>
</tr>
 -->

<tr>
<td></td>
<td>
<input type="submit"  value="REGISTER" >
</td>
</tr>
<!-- class="btn-primary"   id="submitButton"-->
</table>
</form>
</body>
</html>