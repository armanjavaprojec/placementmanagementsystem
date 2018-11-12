
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainee page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>

<script type="text/javascript">


//Itterating all Company Info
$("document").ready(function() {
  $.get("<%=application.getContextPath()%>/GetViewNotificationTOTrainee?req=multiple",function(data) {
      var opt;
             opt="<li style='heigth:0px;'></li>" 
              $.each(data,function(k,v){
                  opt+="<li class='nav-item' id='li"+k+"'><b>Dear "+v.firstname+" "+v.lastname+"</b> , </b> &nbsp;&nbsp <p style='margin-left:30px;'> We have openings in <b>"+v.clientName+"</b> for "
                             +v.description+". Last date to apply   "+v.expectedDate+"<br> we have total "+v.vacancies+" openings .</p> <br> <b>Company Address::</b><p style='margin-left:30px;'>"
                             +v.location+" , "+v.pincode+" ,"+v.city+" ( "+v.state+" , "+v.country+" ) ,  <p><br><b> About Company:</b><br><p style='margin-left:30px;'>"
                             +v.clientDescription
                             +".</p> <br> <b>Contact Person Info:</b><br><p style='margin-left:30px;'><b>Name:</b>  "
                             +v.contactPresonName+"<br><b>mobile no.</b> "+v.contactPresonMobileNO+"<br> <b>Email:</b> "
                             +v.contactPresonNameEmail+"</p><br><button type='button' class='btn btn-primary' style='margin-left:50px;' value='7' onclick='setStatus(this)' id='btn'>Interested</button><button id='btn' type='button' class='btn btn-danger' style='margin-left:20px;' value='8' onclick='setStatus(this)'>Not Interested</button><center><br><b>***Thank You***</b></center><button id='bttn"+k+"' value='"+v.jobPostId+"' sytle='height:0px; width:0px; visibility:hidden;'></button><hr></li>";
               });
            if(count>0){
              $("#AllNotification").append(opt); 
            }
            else{
            	document.getElementById("allDiv").style.visibility="hidden";
            	$("#dataNotFound").modal('show');
            }
              if(count>0){
                 	document.getElementById("notificationCount").style.visibility='hidden';
              	document.getElementById("mainNotificationCount").style.visibility='hidden';
              }
              /* +v.postDate+"----"
              +v.clientImage+"----" */
  });
  var read=2;
 
  $.ajax({
		url:'GetViewNotificationTOTrainee?req=readed',
		type:'Get',
		data:{
			read:read,
		},
		success:function(data){
			
		}
	}); 
});

//set  trainee interested or not
function setStatus(r){
	
	var id=$(r).val();
	
	var lival=$(r).parents('li').index()-1;
	
	if(id==7){
		
		var val=document.getElementById("bttn"+lival).value;
		
       window.location.href = "<%=application.getContextPath()%>/StatusFeedBackController?req=status&status_id="+id+"&jobpostid="+val;

	}
	/* if not interested */
	else if(id==8){
		document.getElementById("fdbk").value="";
		$("#showFB").modal('show');
		var jbpstid=document.getElementById("bttn"+lival).value;
	

		$("#send").click(function(){
		var feedback=document.getElementById('fdbk').value;
      window.location.href = "<%=application.getContextPath()%>/StatusFeedBackController?req=statusandFeedbk&status_id="+id+"&jobpostid="+jbpstid+"&feedback="+feedback;
		});
	
	}
}


</script>

<body >
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/trainee/trainee_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/trainee_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Client Deatails</b>
		</h4>
<div class="panel panel-default" style="margin-right:300px; margin-left:30px;" id="allDiv">
<div class="panel-heading">
        <i class="ace-icon fa fa-bell icon-animated-bell"></i> 
         <span id="notificationCount"></span> 
         Job posting Notifications
</div>    
<div style="margin-left:30px;">    
<ul id='AllNotification' class="list-group" class="nav nav-pills nav-stacked "style='height:400px;
  overflow-y: scroll; width:760px; margin-top:2px;'>

</ul>
</div>    
</div>
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>

