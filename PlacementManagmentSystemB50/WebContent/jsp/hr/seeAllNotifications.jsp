<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js">
</script>
</head>


<script>
//Itterating all Company Info
$("document").ready(function() {
    $.get("<%=application.getContextPath()%>/GetClientNotificationToHR?req=multiple",function(data) {
 	   var opt;
 	   var cnt=0;
			   opt="<li style='heigth:0px; ' class='list-group'></li>" 
				$.each(data,function(k,v){
					cnt++;
					opt+="<li class='nav-item' style='margin-left:20px;' class='list-group-item' id='li"+k+"'><b>Dear HR , </b> &nbsp;&nbsp <p style='margin-left:30px;'> We have openings in <b>"+v.clientName+"</b> for "
					           +v.description+". Last date to apply   "+v.expectedDate+" .</p> <br> <b>Company Address::</b><p style='margin-left:30px;'>"
					           +v.location+" , "+v.city+"("
					           +v.state+" , "+v.country+").<p><br><b> About Company:</b><br><p style='margin-left:30px;'>"
					           +v.clientDescription
					           +".</p> <br> <b>Contact Person Info:</b><br><p style='margin-left:30px;'><b>Name:</b> "
					           +v.contactPresonName+"<br><b> C P Mob.</b> "+v.contactPresonMobileNO+" <br><b>Email: </b>"
					           +v.contactPresonNameEmail+"</p><center><b><a href='<%=application.getContextPath()%>/jsp/hr/viewTrainee.jsp?id="+v.jobPostId+"'>Send Mail To Trainee</a><br>***Thank You***</b></center><hr></li>";
				 
				});
			   if(cnt!=0){
				$("#AllNotification").append(opt); 
			   }
			   else{
				   $("#myModal").modal('show');
			   }
			   
               if(count>0){
               	count=0;
               
               	document.getElementById("notificationCount").style.visibility='hidden';

               	document.getElementById("mainNotificationCount").style.visibility='hidden';
               }
			   
			   /* +v.postDate+"----"
				+v.clientImage+"----" */
    });
    
    var read=2;
    $.ajax({
  		url:'../../GetClientNotificationToHR?req=readed',
  		type:'Get',
  		data:{
  			read:read,
  		},
  		success:function(data){
  			
  		}
  	});
}); 
</script>



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
			<b class="blue">Client Deatails</b>
		</h4>
<div class="panel panel-default" style="margin-left:30px; margin-right:300px;">
<div class="panel-heading">
		<i class="ace-icon fa fa-bell icon-animated-bell"></i> 
		 <span id="notificationCount"></span> 
		 Job posting Notifications
			 
</div>	
<div>	
<ul id='AllNotification' class="list-group" class="nav nav-pills nav-stacked "style='height:400px;
  overflow-y: scroll; width:760px; margin-top:1px; '>

</ul>
</div>	
</div>
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>