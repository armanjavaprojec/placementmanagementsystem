<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>

<script type="text/javascript">
var singleNot=0;
//SHowing Perticular Cleint Info 
$('document').ready(function(){
   $.get("<%=application.getContextPath()%>/GetClientNotificationToHR?req=multiple",function(data) {
              $.each(data,function(k,v){
            	
             	 if(v.countryid==0 || v.countryid==1){
             		 singleNot++;
             	 }
               });
   
               if(singleNot>0){
                $("#notificationCount").text(singleNot);

                $("#mainNotificationCount").text(singleNot);
               }
             if(count==0){
             	
             	document.getElementById("notificationCount").style.visibility='hidden';

             	document.getElementById("mainNotificationCount").style.visibility='hidden';
             }
              /* +v.postDate+"----"
              +v.clientImage+"----" */
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
<div class="panel panel-default" style="margin-left:30px; margin-right:270px;">
<div class="panel-heading">
		<i class="ace-icon fa fa-bell icon-animated-bell"></i> 
		 <span id="notificationCount"></span> 
		 Job posting Notifications
</div>	
	
<ul id="PClient" class="list-group" class="nav nav-pills nav-stacked " style='height:367px;
    overflow-y: scroll; width:800px; margin-top:1px;'>

      <c:forEach items="${perticularClientData}" var="Pdata">
       
      <b>Dear HR , </b>  <p style='margin-left:30px;'>  We have openings in <b>  <c:out value="${Pdata.clientName}"/></b> for 
						           <c:out value="${Pdata.description}"/>. Last date to apply   <c:out value="${Pdata.expectedDate}"/> .</p> <br> <b>Company Address::</b><p style='margin-left:30px;'>
						           <c:out value="${Pdata.location}"/> , <c:out value="${Pdata.city}"/>(
						          <c:out value="${Pdata.state}"/> , <c:out value="${Pdata.country}"/><p><br><b> About Company:</b><br><p style='margin-left:30px;'>
						           <c:out value="${Pdata.clientDescription}"/>
						           .</p> <br> <b>Contact Person Info:</b><br><p style='margin-left:30px;'><b>Name:</b> 
						           <c:out value="${Pdata.contactPresonName}"/> <br><b> C P Mob.</b> <c:out value="${Pdata.contactPresonMobileNO}"/><br><b>Email: </b>
						          <c:out value="${Pdata.contactPresonNameEmail}"/></p><center><b><a href="<%=application.getContextPath()%>/jsp/hr/viewTrainee.jsp?id=${Pdata.jobPostId}">Send Mail To Trainee</a>
						          <br>***Thank You***</b></center><hr>
      
     
    </c:forEach>
 
</ul>
</div>

<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>