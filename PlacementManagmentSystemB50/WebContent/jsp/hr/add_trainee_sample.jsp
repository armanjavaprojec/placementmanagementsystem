<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@page import="com.nacre.pms.util.StringConstants"%>
<%@page import="com.nacre.pms.util.URLConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Trainee Sample</title>
<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>
<script type="text/javascript" src="../../assets/js/jquery-ui.min.js"></script>
<script>
function formPage(){
	window.location.href="<%=URLConstants._ADD_TRAINEE_FORM%>";
}

function excelPage(){
	window.location.href="<%=URLConstants._ADD_TRAINEE_EXCEL%>";
}

</script>
</head>
<body>
<body class="no-skin" style="color:black;">
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
		<br><br>
		<button class="btn btn-primary btn-lg" onclick="excelPage()">Add Trainees From Excel Sheet</button>
		<button class="btn btn-primary btn-lg" onclick="formPage()">Add Trainees Through Form Page</button>


		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
	<!-- /.main-container -->
</body>
</html>