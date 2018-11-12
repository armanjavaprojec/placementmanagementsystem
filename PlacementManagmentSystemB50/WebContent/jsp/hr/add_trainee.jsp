<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>ADD Trainee</title>
<script src='<%=application.getContextPath()%>/js/jquery-3.3.1.min.js'></script>
  <link rel="stylesheet" href="<%=application.getContextPath()%>/css/multistep.css">
	<script src="<%=application.getContextPath()%>/js/add_trainee_validation.js"></script>
<link rel="stylesheet" href="<%=application.getContextPath()%>/css/multistep.css">
<script src='<%=application.getContextPath()%>/js/jquery.min.js'></script>
<style type="text/css">
.ssc_hide, .hsc_hide,.graduation_hide{
	width: 200px;
	background: #53c653;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 50px;
}
#id_submit{
	width: 200px;
	background: #0099cc;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 50px;
}
</style>
 <script type="text/javascript">
	$("document").ready(function(){
		var optY="<option value=''>Passed-Out</option>";
		for(var i=2019;i>=2001;i--)
			{
				optY+="<option >"+i+"</option>";
			}
		$("#syop_id").append(optY);
		$("#hyop_id").append(optY);
		$("#gyop_id").append(optY);
		$("#pgyop_id").append(optY);
		var batch = "<option>select batch</option>";
 		$.get("<%=application.getContextPath()%>/getBatchController",function(data) /* //in place of data enything we take this is the anonymous variable */
 		{
 			 var batch = "<option>Select Batch</option>";
 	 		$.each(data,function(k,v){
 				batch = batch+"<option value="+k+">"+v+"</option>";
 	 		});
 		 $("#batch_id").html(batch);
 		}); 
 		$("#batch_id").change(function(){
				var batch_id=$("#batch_id").val();
				//alert("batchid----"+batch_id)
				var technology = "<option>Select Technology</option>";
				$.get("<%=application.getContextPath()%>/getTechnologyController?batch_id="+batch_id,function(data){
				 	 $.each(data,function(k,v){
				 		 //alert("---------------------Inside......");
				 		 //alert(k+"--"+v)
				 	 	technology = technology+"<option value="+k+">"+v+"</option>";
				 	 });
				 	 $("#tech_id").html(technology);
				 	 
				});
			});//on change
			$("#tech_id").change(function(){
				$("#button1").show();
				});//on change
				
				$("#button2").hide();
				$("#button3").hide();
				
				$("input").change(function() {
				//	alert("change")
					//$("#button2").show();
					
				
				//	alert(checkFirstName()+ ""+ checkLastName() +""+ checkContact() +""+ checkDOB() +""+ checkMail())
		         if (checkFirstName() && checkLastName() && checkContact() && checkDOB() && checkMail()) {
		        //	alert("hi");
		             $("#button2").show();
		        } 
		    });
				
				
				
				
	});//ready
	</script>
	<script type="text/javascript">
	$("document").ready(function(){
 		$.get("<%=application.getContextPath()%>/getCountryController",function(data) 
 				{
 				 	 var country = "<option>Select Country</option>";
 				 	 $.each(data,function(k,v){
 				 		country = country+"<option value="+k+">"+v+"</option>";
 				 	 });
 				 	 $("#country_id").html(country);
 				 });
 				$("#country_id").change(function(){
 					var country_id=$("#country_id").val();
 					var state = "<option>Select State</option>";
 					$.get("<%=application.getContextPath()%>/getStateController?countryid="+country_id,function(data){
 					 	 $.each(data,function(k,v){
 					 	 	state = state+"<option value="+k+">"+v+"</option>";
 					 	 });
 					 	 $("#state_id").html(state);
 					});
 				});//on change

 				$("#state_id").change(function(){
 					var state_id=$("#state_id").val();
 					var city="<option>Select City</option>";
 					$.get("<%=application.getContextPath()%>/getCityController?state_id="+state_id,function(data){
 					 	 $.each(data,function(k,v){
 					 	 	city = city+"<option value="+k+">"+v+"</option>";
 					 	 });
 					 	 $("#city_id").html(city);	
 					});
 				});//on change
 				$("#city_id").change(function(){
 				if(checkAddrs() && checkZipcode())
 				$("#button3").show();
 				});
		}); //ready
</script>
<script type="text/javascript">
var selPG=0;
	function postgraduation()
		{
	
				$("#id_submit").hide();
				$(".graduation").hide();
				$('#pginfo').slideToggle();
				$(".ssc").hide();
				$(".hsc").hide();
				selPG=1;
				document.getElementById("pgsel_sid").style="display: none;";
		}
	function postgraduation1()
	{
		  $(".ssc").hide();
		  $(".hsc").hide();
		  $(".graduation").hide();
		  $('#pginfo').hide();
		  selPG=2;
		  document.getElementById("pgsel_sid").style="display: none;";
				if(checkSyop() && checkSPER() && checkHyop() && checkHPER() && checkGstream() && checkGspec()  )
				{
					$("#id_submit").show();
					
				}		
			
	
	}
	$("document").ready(function(){
		   $("#pginfo").hide();
			$(".ssc").hide();
	        $(".ssc_hide").show();
	   		$('.ssc_hide').click(function(){
	    		$(".ssc").slideToggle();
	    		$(".hsc").hide();
	    		$(".graduation").hide();
	  		    $('#pginfo').hide();
	    		return false;
	    	});
	   		$(".hsc").hide();
	        $(".hsc_hide").show();
	   		$('.hsc_hide').click(function(){
	    		$(".hsc").slideToggle();
	    		$(".ssc").hide();
	    		$(".graduation").hide();
	  		    $('#pginfo').hide();
	    		return false;
	    	});	
	   		$(".graduation").hide();
	        $(".graduation_hide").show();
	   		$('.graduation_hide').click(function(){
	    		$(".graduation").slideToggle();
	    		$(".hsc").hide();
	    		$(".ssc").hide();
	  		    $('#pginfo').hide();
	    		return false;
	    	});
 		$.get("<%=application.getContextPath()%>/getGraduationStreamController",function(data) 
 		{
 			 var gstream = "<option>Select Stream</option>";
 	 		$.each(data,function(k,v){
 	 			gstream = gstream+"<option value="+k+">"+v+"</option>";
 	 		});
 		 $("#gstream_id").html(gstream);
 		}); 
		$.get("<%=application.getContextPath()%>/getPGraduationStreamController",function(data){
					var pgstream = "<option>Select Stream</option>";
				 	 $.each(data,function(k,v){
				 		pgstream = pgstream+"<option value="+k+">"+v+"</option>";
				 	 });
				 	 $("#pgstream_id").html(pgstream);
				});
			$("#gstream_id").change(function(){
					var gstream_id=$("#gstream_id").val();
					var gspecilization = "<option>Select Specilization</option>";
					$.get("<%=application.getContextPath()%>/getGraduationSpecilizationController?gstream_id="+gstream_id,function(data){
						var pgstream = "<option>Select Specilization</option>";
					 	 $.each(data,function(k,v){
					 		gspecilization = gspecilization+"<option value="+k+">"+v+"</option>";
					 	 });
					 	 $("#gspecilization_id").html(gspecilization);
					});
				});//on change
				
				
				
				
				$("#pgstream_id").change(function(){
						var pgstream_id=$("#pgstream_id").val();
						var pgspecilization = "<option>Select Specilization</option>";
						$.get("<%=application.getContextPath()%>/getPGraduationSpecilizationController?pgstream_id="+pgstream_id,function(data){
							var pgstream = "<option>Select Specilization</option>";
						 	 $.each(data,function(k,v){
						 		pgspecilization = pgspecilization+"<option value="+k+">"+v+"</option>";
						 	 });
						 	 $("#pgspecilization_id").html(pgspecilization);
						});
					});//on change	
					$("#pgspecilization_id").change(function(){
		/* 		alert("ds   "+checkSyop() + checkSPER()+ checkHyop() + checkHPER() + checkGstream() + checkGspec() + checkGyop() +checkGPER() + checkPGstream() + checkPGspec() );		
		 */				if(checkSyop() && checkSPER() && checkHyop() && checkHPER() && checkGstream() && checkGspec() && checkGyop() && checkGPER() && checkPGstream() && checkPGspec() )
						{
							$("#id_submit").show();
							
						}});
						
					
					$("#id_submit").hide();
				 $("#button1").hide();
				   /*  $("input").change(function() {alert("asd");
				        if (validateBatch() && validateTech()) {
				            $("#button1").show();
				        }
				    });
				 */
	
	});//ready
	function returnValidateAll()
	{
		var resBatch=validateBatch();
		var resTech=validateTech();
		var resFirstName=checkFirstName();
		var resLastName=checkLastName();
		var resContact=checkContact();
		var resMail=checkMail();
		var resDOB=checkDOB();
		var resAddress=checkAddrs();
		var resZipCode=checkZipcode();
		var resCountry=checkCountry();
		var resState=checkState();
		var resCity=checkCity();
		var resSSCYop=checkSyop();
		var resSSCPer=checkSPER();
		var resHSCYop=checkHyop();
		var resHSCPer=checkHPER();
		var resGradStream=checkGstream();
		var resGradSpec=checkGspec();
		var resGradYop=checkGyop();
		var resGradPer=checkGPER();
		var pgRes=false;
		if(selPG==0)
			{
			document.getElementById("pgsel_sid").style="display: block;";
			document.getElementById("pgsel_sid").innerHTML="Select one choice";
			}
		else if(selPG==1)
			{
			var resPGStream=checkPGstream();
			var resPGSpec=checkPGspec();
			var resPGYop=checkPGyop();
			var resPGPer=checkPGPER();
			if(resPGStream && resPGSpec && resPGYop &&resPGPer)
				{
				pgRes=true;
				}
			}
		else if(selPG==2)
			{
			pgRes=true;
			}
		else {}
		
		if(resBatch && resTech && resFirstName && resLastName && resContact && resMail && resDOB && resAddress && resZipCode && resCountry && resState && resCity && resSSCYop && resSSCPer && resHSCYop && resHSCPer && resGradStream && resGradSpec && resGradYop && resGradPer && pgRes)
			{
				document.getElementById("id_div_err").style="display:none;";
				return true;	
			}
		else
			{
			document.getElementById("id_div_err").style="display:block;";
			document.getElementById("id_div_err").style="color: red;"
			document.getElementById("id_div_err").innerHTML="*Check all required details and submit again.";
			if(!(resSSCYop) || !(resSSCPer))
				{
				$(".ssc").slideToggle();
				}
			if(!(resHSCYop) || !(resHSCPer))
			{
			$(".hsc").slideToggle();
			}
			if(!(resGradYop) || !(resGradPer))
			{
				$(".graduation").slideToggle();
			}
			return false;
			}
	}
	</script>
	
</head>
<body>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<!-- write your code here -->
<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Add Trainee</b>
		</h4>
	<!-- multistep form -->
	<form id="msform"   enctype="multipart/form-data" action="<%=application.getContextPath()%>/hrAddTraineeController" data-toggle="validator" onsubmit="return returnValidateAll()" role="form" method="post">
		<!-- progressbar -->
		<ul id="progressbar">
			<li class="active">Select Batch & Technology</li>
			<li>Personal Details</li>
			<li>Address Details</li>
			<li>Educational Details</li>
		</ul>
		<!-- fieldsets -->
		<fieldset>
			<h2 class="fs-title">Select batch and technology</h2>
			<div id="div_batch_id">
				<select name="batch" id="batch_id" onblur="validateBatch()"> 
						<option value="Select Batch">Select Batch</option>
				</select>
				<span id="batch_sid" style="color:red"></span>
			</div>
		
			<br>
			<div id="div_tech_id">
				<select name="technology" id="tech_id" onblur="validateTech()">
						<option value="Select Technology">Select Technology</option>
				</select>
				<span id="tech_sid" style="color:red"></span>
			</div>
			
			<br> 
			<input type="button" id="button1" name="next" class="next action-button" value="Next" />
		</fieldset>
	
		<fieldset>
			<h2 class="fs-title"  >Personal Details</h2>
			<div id="fname_div_id">
                      <input class="a" type="text" id="firstName" name="firstname" placeholder="first name" onblur="checkFirstName()" />
                      <br><span id="fname_sid" style="color:red"></span>
			</div>
		
			<br>
			<div id="lname_div_id">
					<input class="a" type="text" id="lastName" name="lastname" placeholder="last name" onblur="checkLastName()" />
					<br><span id="lname_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="mbl_div_id">
				<input class="a" type="text" id="contact" name="mobileno" placeholder="mobileno" onblur="checkContact()" />
				<br><span id="mbl_sid" style="color:red"></span>
			</div>
		
			<br>
             <div id="email_div_id">
					<input class="a" type="email" id="email" name="email" placeholder="Email" onblur="checkMail()"/> 
					<br><span id="email_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="dob_div_id">
		    	<input class="a" type="date" id="dob" name="dob" placeholder="date of birth" onblur="checkDOB()"/> 
		    	<br><span id="dob_sid" style="color:red"></span>
		    </div>
		   
			<br>
		    <input class="a" type="file"  id="image" name="image" value="Browse Image"/><br>
		    <label>Gender: </label>
			<input id="gender" type="radio" name="gender" value="male"> Male
  			<input id="gender" type="radio" name="gender" value="female"> Female<br>
		    <input type="button" name="previous" class="previous action-button" value="Previous" />
		    <input type="button" id="button2" name="next" class="next action-button" value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Address Details</h2>
			<div id="addrs_div_id">
				<input class="a" type="text" id="addrsid" name="address" placeholder="address" onblur="checkAddrs()"/>
				<br><span id="addrs_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="div_zipcode_id">
				<input class="a" type="text" id="zipcode" name="pincode" placeholder="pincode" onblur="checkZipcode()" />
				<br><span id="zipcode_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="div_country_id">
				<select name="country" id="country_id" onblur="checkCountry()" >
					<option value="Select Country">Select Country</option>
				</select>
				<br><span id="country_sid" style="color:red"></span>
				</div>
				
			<br>
			<div id="div_state_id">
				<select name="state" id="state_id" onblur="checkState()" >
						<option value="Select State">Select State</option>
				</select>
				<br><span id="state_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="div_city_id">
				<select name="city" id="city_id" onblur="checkCity()" >
						<option value="Select City">Select City</option>
					</select>
					<br><span id="city_sid" style="color:red"></span>
			</div>
			
			<br>
			<input type="button" name="previous" class="previous action-button" value="Previous" />
			<input type="button" id="button3" name="next" class="next action-button" value="Next" />
		</fieldset>
		<fieldset>
			<h2 class="fs-title">Educational Details</h2>
		
		<button class="ssc_hide">SSC Details</button><br>			
		<div class="ssc">
			<div id="div_syop_id">			
				<select name="syop" id="syop_id" onblur="checkSyop()">
					
				</select>
				<br><span id="syop_sid" style="color:red"></span>
			</div>
			
			<br>
			<div id="div_sper_id">
				    <input class="a" type="text" id="spercentage_id" name="spercentage" placeholder="percentage" onchange="checkSPER()">
				   <br><span id="sper_sid" style="color:red"></span>
			 </div>
			
			<br>
		</div>
		<button class="hsc_hide">Inter/Diploma Details</button><br>
		<div class="hsc">
			<div id="div_hyop_id">  
				<select name="hyop" id="hyop_id" onchange="checkHyop()" >
				</select>
				<br><span id="hyop_sid" style="color:red"></span>
			</div>
			
			<br>
				 <div id="div_hper_id">
				    <input class="a" type="text" id="hpercentage_id" name="hpercentage" placeholder="percentage" onblur="checkHPER()">			
					<br><span id="hper_sid" style="color:red"></span>
			   </div>
			   
			<br>
			</div>
			<button class="graduation_hide">Graduation Details</button><br>
			<div class="graduation">
			    <div id="div_gstream_id">
					<select name="gstream" id="gstream_id" onblur="checkGstream()">
						<option value="Select Stream">Select Stream</option>
					</select>
					<br><span id="gstream_sid" style="color:red"></span>
				</div>
				
			<br>
				<div id="div_gspec_id">
					<select name="gspecilization" id="gspecilization_id" onblur="checkGspec()">
						<option value="Select Specilization">Select Specilization</option>
					</select>
					<br><span id="gspec_sid" style="color:red"></span>
				</div>
				
			<br>
				<div id="div_gyop_id">
					<select name="gyop" id="gyop_id" onblur="checkGyop()">
					</select>
					<br><span id="gyop_sid" style="color:red"></span>
				</div>
				
			<br>
				 <div id="div_gper_id">
				    <input class="a" type="text" id="gpercentage_id" name="gpercentage" placeholder="percentage" onblur="checkGPER()">
					<br><span id="gper_sid" style="color:red"></span>
			   </div>
			  
			<br>
			</div>
			<label>Post Graduation</label>
			
			<input class="pgraduation_hide" id="pgid" type="radio" name="pg" value="postgraduation" onclick="postgraduation()">Yes
			<input id="pg" type="radio" name="pg" value="no" onclick="postgraduation1()"> NO 
			<br>
			<span id="pgsel_sid" style="color:red"></span>
			
			<div id="pginfo">
			<div class="pgraduation">
				<div id="div_pgstream_id">
					<select name="pgstream" id="pgstream_id" onblur="checkPGstream()">
						<option value="Select Stream">Select Stream</option>
					</select>
					<br><span id="pgstream_sid" style="color:red"></span>
				</div>
				
			<br>
				<div id="div_pgspec_id">
					<select name="pgspecilization" id="pgspecilization_id" onblur="checkPGspec()">
						<option value="Select Specilization">Select Specilization</option>
					</select>
					<br><span id="pgspec_sid" style="color:red"></span>
				</div>
				
			<br>
				<div id="div_pgyop_id">
					<select name="pgyop" id="pgyop_id" onblur="checkPGyop()">
						
					</select>
					<br><span id="pgyop_sid" style="color:red"></span>
				</div>
				
			<br>
				 <div id="div_pgper_id">
				    <input class="a" type="text" id="pgpercentage_id" name="pgpercentage" placeholder="percentage" onblur="checkPGPER()" >
					 <br><span id="pgper_sid" style="color:red"></span>
			   </div>
			   
			<br>
			</div>
			 
			</div>
			<input type="button" name="previous" class="previous action-button" value="Previous" />
			 <br><br><br>
			 <input type="submit" id="id_submit" value="Submit">
			<div id="id_div_err"></div> 
		</fieldset>
	</form>
</div><!-- /.main-container -->
	
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
		<!-- <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script> -->
	<script src="<%=application.getContextPath()%>/js/jquery.easing.1.3.js"></script>
	<script src="<%=application.getContextPath()%>/js/multistep.js"></script>

<!-- <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script> -->
<script src="<%=application.getContextPath()%>/js/multistep.js"></script>
<script src="<%=application.getContextPath()%>/js/add_trainee_validation.js"></script>

</body>
</html>
