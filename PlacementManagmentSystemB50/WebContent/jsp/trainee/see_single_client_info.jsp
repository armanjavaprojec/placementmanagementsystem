
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
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>

<script type="text/javascript">
//set  trainee interested or not
function setStatus(r){
	
	var id=$(r).val();
	

	if(id==7){
		
		var val=document.getElementById("btttn").value;
		//var jbpstid=document.getElementById("btttn").value;

         window.location.href = "<%=application.getContextPath()%>/StatusFeedBackController?req=status&status_id="+id+"&jobpostid="+val;

	}
	/* if not interested */
	else if(id==8){
		document.getElementById("fdbk").value="";
		$("#showFB").modal('show');
		var jbpstid=document.getElementById("btttn").value;
	

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
<jsp:include page="../../jsp/common/trainee_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/trainee_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Client Deatails</b>
		</h4>
<div class="panel panel-default" style="margin-right:300px; margin-left:30px;">
<div class="panel-heading">
        <i class="ace-icon fa fa-bell icon-animated-bell"></i> 
         <span id="notificationCount"></span> 
         Job posting Notifications
</div>    
<div  style="margin-left:30px;"   >    
<ul id='PClient' class="list-group" class="nav nav-pills nav-stacked "style='height:400px;
  overflow-y: scroll; width:760px; margin-top:2px;'>
        <c:forEach items="${clientdata}" var="Pdata">
       
     <b>Dear <c:out value="${Pdata.firstname}"/> <c:out value="${Pdata.lastname}"/> , </b>  <p style='margin-left:30px;'> We have openings in <b><c:out value="${Pdata.clientName}"/>  </b> for 
                                <c:out value="${Pdata.description}"/>. Last date to apply   <c:out value="${Pdata.expectedDate}"/> .<br> we have total <c:out value="${Pdata.vacancies}"/> openings .</p> <br> <b>Company Address::</b><p style='margin-left:30px;'>
                                <c:out value="${Pdata.location}"/> , <c:out value="${Pdata.pincode}"/> , <c:out value="${Pdata.city}"/>+ ( 
                                <c:out value="${Pdata.state}"/> , <c:out value="${Pdata.country}"/> ).<p><br><b> About Company:</b><br><p style='margin-left:30px;'>
                                <c:out value="${Pdata.clientDescription}"/>
                                .</p> <br> <b>Contact Person Info:</b><br><p style='margin-left:30px;'> <b>Name:</b>  
                                <c:out value="${Pdata.contactPresonName}"/>+" <br><b>C P Mob.:</b>  <c:out value="${Pdata.contactPresonMobileNO}"/>+"<br><b> Email:</b>  
                               <c:out value="${Pdata.contactPresonNameEmail}"/> </p><br><button type='button' class='btn btn-primary' style='margin-left:50px;' value='7' onclick='setStatus(this)' id='btnnn'>Interested</button><button id='btn' type='button' class='btn btn-danger' style='margin-left:20px;' value='8' onclick='setStatus(this)'>Not Interested</button><center><br><b>***Thank You***</b></center><button id='btttn' value='<c:out value="${Pdata.jobPostId}"/>' style='height:0px; width:0px; visibility:hidden;'></button>

     
    </c:forEach>
</ul>
</div>    
</div>

<!-- write your code here -->
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>

