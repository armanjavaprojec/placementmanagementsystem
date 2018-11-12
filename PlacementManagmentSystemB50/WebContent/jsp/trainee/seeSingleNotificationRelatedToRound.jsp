<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js">
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
			<b class="blue">Round Deatails</b>
		</h4>
<div class="panel panel-default" style="margin-right:300px; margin-left:30px;">
<div class="panel-heading">
        <i class="ace-icon fa fa-bell icon-animated-bell"></i> 
         <span id="notificationCount"></span> 
         Round Notifications
</div>    
<div  style="margin-left:30px;"   >    
<ul id='Perticular_round' class="list-group" class="nav nav-pills nav-stacked "style='height:230px;
  overflow-y: scroll; width:760px; margin-top:2px;'>
         <c:forEach items="${roundData}" var="Pdata">
       
       
        <b>Dear <c:out value="${Pdata.state}"/><c:out value="${Pdata.country}"/>, </b><br>You are Shortlisted for <b>
                     <c:out value="${Pdata.clientName}"/> </b>. You have <c:out value="${Pdata.description}"/> (<c:out value="${Pdata.roundNo}"/>) round.<br> <b> Venue:</b><br><p style='margin-left:30px;'><b>Date:</b> 
                     <c:out value="${Pdata.date}"/>. <br><b> Address:</b><c:out value="${Pdata.location}"/> <br> <b>Pincode:</b> <c:out value="${Pdata.pincode}"/><center><b>***Thank you***</b></center><hr>
     
                             
     
    </c:forEach>
 

</ul>
</div>    
</div>
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>