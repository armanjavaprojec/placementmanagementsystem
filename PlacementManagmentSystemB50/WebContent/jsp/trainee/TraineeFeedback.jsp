<%@page import="com.nacre.pms.util.StringConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>feedback page</title>
<style type="text/css">
select.input100 {
	height: 50px;
	border-radius: 25px;
	padding: 0 30px 0 50px;
}
</style>
<link rel="stylesheet" type="text/css" href="${path}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${path}/css/main anju.css">
<script src="${path}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
<% HttpSession hs=request.getSession();
int userid=(int)hs.getAttribute(StringConstants._SESSION_USER_ID);%>
 $(document).ready(function(data) {
	
		$.get("${path}/getFeedbackTypeController", function(data) {

			var opt="<option value='0'>select Feedback Type</option>";
		
			$.each(data, function(k,v) {
				opt+="<option value='"+k+"'>"+v+"</option>";
			});
			$("#feedback").append(opt);
		
		});
		
		$("#feedback").change(function(){
	//alert();
			var feedbackid=$('#feedback').val();
			
			
			if(feedbackid==0)
			{
				document.getElementById("id_desc_div").style="display:none";
				document.getElementById("id_client_select").style="display:none";
				document.getElementById("id_submit_div").style="display:none";
			}
			else if(feedbackid==1)
			{
				document.getElementById("id_client_select").style="display:none";
				document.getElementById("id_desc_div").style="display:block";
				document.getElementById("id_submit_div").style="display:block";
			}
			else if(feedbackid==2)
			{
				document.getElementById("id_desc_div").style="display:block";
				document.getElementById("id_client_select").style="display:block";
				document.getElementById("id_submit_div").style="display:block";
				var id="<%=session.getAttribute("uid")%>";
				//alert("userid---"+id);
				$.get("${path}/TraineeFeedbackClientNameController?feedbackid="+feedbackid+"&userId="+<%=userid%>,function(data) {
					//alert("inside---");
					
					 var a ="<option value='select'>Select Client</option>";
					$.each(data, function(k,v) {
					
						a+="<option value='"+k+"'>"+v+"</option>";
				
					});
					//$(a).prop("disabled", false);
					$("#clientid").html(a);  
			 
				});
			}
			else
			{
				document.getElementById("id_desc_div").style="display:none";
				document.getElementById("id_client_select").style="display:none";
				document.getElementById("id_submit_div").style="display:none";
			}
		});
		}); 

 
    /*  function feedbackValidate() {    	
    	 var feedback=$('#feedback').val();    	 
    	
    	 
    	 if(feedback="" || feedback=="select Feedback Type")
    	{
    		 alert("feed......");
    		   document.getElementById('feedbackError').innerHTML='please select ur Feedback type';
    	}
    	 
    	 
    	 
    	 var clientid=$('#clientid').val();
    	 if(clientid=""|| clientid=="Select Client Name")
    		 {
    		 
    		 alert("client....");
    		 document.getElementById('clientError').innerHTML='please select ur Client Name';
    	    	
    		 }
    	 
    	  */
    	 
    	 
    	// start 
    	
    	  function hello () {
    		    var x = document.forms["myform"]["feedback_type"].value;
    		    var y = document.forms["myform"]["client"].value;
    		    var z = document.forms["myform"]["feedback_description"].value;

    		      //alert("x val is "+x);
    		    
    		    var submit = true;

    		    if (x == null || x == "" ||x=="select Feedback Type") {
    		        nameError = "please select ur Feedback type";
    		        document.getElementById("feedbackError").innerHTML = nameError;
    		        submit = false;
    		    }

    		    if (y == null || y == "" ||y=="Select Client Name") {
    		        emailError = "please select ur Client Name";
    		        document.getElementById("clientError").innerHTML = emailError;
    		        submit = false;
    		    }

    		    if (z == null || z == "") {
    		        telephoneError = "Please provide Description...";
    		        document.getElementById("descriptionError").innerHTML = telephoneError;
    		        submit = false;
    		    }

    		    return submit;
    		}

    		function removeWarning() {
    			
    			
    		    document.getElementById("feedbackError").innerHTML = "";
    		}
              function removeWarning1() {
    			
    			
    		    document.getElementById("clientError").innerHTML = "";
    		}
              function removeWarning2() {
      			
      			
      		    document.getElementById("descriptionError").innerHTML = "";
      		}

              
              function submitFeedback()
              {
            	  
            	var feedbackid=$('#feedback').val();
      			
      			if(feedbackid==0)
      			{
      				
      			}
      			else if(feedbackid==1)
      			{
      				//alert("nacre");
      				
      				var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth();
					var yyyy = today.getFullYear();

					today = yyyy + "-" + mm + "-" + dd;
      				
      				var desc=document.getElementById("txtarea").value;
      				var userId=<%=userid%>;
      				//alert("ud---s"+userId)
      				desc=desc.trim();
      				
      				if(desc=="")
      				{
      					document.getElementById("txtarea").style="border-color: red;";
      				}
      				else
      				{
      					
      					$.ajax({
          					url : '../../getTraineeFeedbackController',
          					type : 'POST',
          					data : {
          						user_id : userId,
          						feed_desc : desc,
          						feed_id : feedbackid,
          						feed_date : today
          					},
          					success : function(data) {
          						$("#myResModal").modal('show');
          						document.getElementById("myResInfo").innerHTML = data;
          					}
          				}); 
      				}
      				
      				//alert(desc+""+today+feedbackid+userId);
      				 
      			}
      		
      			else if(feedbackid==2)
      			{
      				var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth();
					var yyyy = today.getFullYear();

					today = yyyy + "-" + mm + "-" + dd;
      				
      				var desc=document.getElementById("txtarea").value;
      				var userId=<%=userid%>;
      				
      				var client_id=document.getElementById("clientid").value;
      				
      				var company = document.getElementById("clientid");
      				var scompany = company.options[company.selectedIndex].text;
      				
					desc=desc.trim();
      				
      				if(desc=="" || scompany=="Select Client")
      				{

      					if(desc=="")
      					{
      						document.getElementById("txtarea").style="border-color: red;";
      					}
      					
      					if(scompany=="Select Client")
    					{
      						document.getElementById("clientid").style="border-color: red;";
      					}
      					
      				}
      				else
      				{
      					//alert("ajax uid---"+userId)
      				//alert(desc+""+today+feedbackid+userId);
      				 $.ajax({
      					 
      					url : '../../getTraineeFeedbackController',
      					type : 'POST',
      					data : {
      						user_id : userId,
      						feed_desc : desc,
      						feed_id : feedbackid,
      						feed_date : today,
      						feed_client : client_id 
      					},
      					success : function(data) {
      						$("#myResModal").modal('show');
      						//alert("data---"+data)
      						document.getElementById("myResInfo").innerHTML = data;
      					}
      				});
      				//alert("company");
      				}
      			}
      			else
      			{
      				
      			}
              }
              
              function clearFields()
              {
            	  window.location.href="../../jsp/trainee/TraineeFeedback.jsp";
              }
              
              
    		/* document.getElementById("feedback").onkeyup = removeWarning;
    		document.getElementById("clientid").onkeyup = removeWarning;
    		document.getElementById("txtarea").onkeyup = removeWarning;
    		 */
    		
    		
    		
    		//end
    	 
    	 
    	 
    	 
    	  //	 }
 
</script>
</head>
<body class="no-skin">
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/trainee_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/trainee_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
		<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Feedback</b>
		</h4>
		<!-- write your code here -->
		<center>
			<%-- <form class="contact100-form validate-form" action="<%=application.getContextPath()%>/getTraineeFeedbackController" id="myform" name="myform"> --%>
				<div class="wrap-input100 validate-input"
					data-validate="FeedBack Type">
					<select class="input100" name="feedback_type" id="feedback" required autofocus onchange="removeWarning()">
					</select> <span class="focus-input100"></span> <span class="symbol-input100">
						<i class="fa fa-user-circle-o"
						style="font-size: 20px; color: #438eb9"></i>
					</span>
					<span id="feedbackError" style='color:red'></span>
				</div>
				
					<div class="wrap-input100 validate-input" id="id_client_select"
					data-validate="FeedBack Type" style="display: none;">
					<select class="input100" name="client" id="clientid" required autofocus onchange="removeWarning1()">
					</select> <span class="focus-input100"></span> <span class="symbol-input100" >
						<i class="fa fa-user-circle-o"
						style="font-size: 20px; color: #438eb9"></i>
					</span>
					<span id="clientError" style='color:red'></span>
				</div>
				
				<div class="wrap-input100 validate-input" id="id_desc_div"
					data-validate="Message is required" style="display: none;">
					<textarea class="input100" name="feedback_description" style="border:1px solid black;"
						placeholder="Message" id="txtarea" required autofocus onchange="removeWarning2()"></textarea>
					<span class="focus-input100"> </span>
					<span id="descriptionError" style='color:red'></span>
				</div>
				<div class="container-contact100-form-btn" id="id_submit_div" style="display: none;">
					<!-- <button class="contact100-form-btn" type="submit" onclick="hello()">Send Feedback</button> -->
					<button class="contact100-form-btn" type="submit" onclick="submitFeedback()">Send Feedback</button>
				</div>
			<!-- </form> -->
			
			<!-- MODAL START -->
		<div class="modal fade" id="myResModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Info</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" id="myResInfo"></div>
					<div class="modal-footer">
						<button type="button" class="btn-danger" data-dismiss="modal"
							onclick="clearFields()">Close</button>
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