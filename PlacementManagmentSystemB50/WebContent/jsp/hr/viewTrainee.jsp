<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"   src="<%=application.getContextPath()%>/assets/js/jquery.2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	//alert("batch")
	$.get("<%=request.getContextPath()%>/GetBatchesControllerurl",function(data)
	{
		
	//alert(data)
	  var b="<option value=''>select batches</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  b+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#batch").html(b);
	});	  
	});
	</script>
<script>
$(document).ready(function(){
	//alert("technology")

	$.get("<%=request.getContextPath()%>/GetTechnologies",function(data)
	{
		
	//alert(data)
	  var t="<option value=''>select technologies</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  t+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#tech").html(t);
	  
	});
});

</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select File List</title>
</head>
<body>
<body class="no-skin">
<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>


<%session.setAttribute("jobpostid", request.getParameter("id")); %>
<!-- write your code here -->
<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Filter Trainees </b>
		</h4>
		<body bgcolor="#ffb3d9">
<center>						
<form action="<%=request.getContextPath()%>/ViewTraineesControllerurl">
<fieldset style="height: 300px ;width:300px ;align:centre">
select batch:<select id="batch" name="batches"></select><br>
		
select technology:<select id="tech" name="technology" ></select><br>
<input type="submit" value="view"/>
</fieldset>
</form>
</center>
		
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->
</body>
</html>