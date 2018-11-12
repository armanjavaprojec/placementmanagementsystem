<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hr page</title>
  <style class="md-form">
.file-field.medium .file-path-wrapper {
  height: 3rem; }
  .file-field.medium .file-path-wrapper .file-path {
    height: 2.8rem; }

.file-field.big-2 .file-path-wrapper {
  height: 3.7rem; }
  .file-field.big-2 .file-path-wrapper .file-path {
    height: 3.5rem; }
</style>  
<script type="text/javascript">
function checkfile(sender) {
    var validExts = new Array(".xlsx", ".xls");
    var fileExt = sender.value;
    fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
    if (validExts.indexOf(fileExt) < 0) {
      alert("Invalid file selected, valid files are of " +
               validExts.toString() + " types.");
      return false;
    }
    else return true;
}
</script>
</head>
<body class="no-skin">
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>
		<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Details</b>
		</h4>
		<!-- write your code here -->
		<div class="container">
		  <form action="<%=application.getContextPath() %>/reg_trainees_excel" method="POST" enctype="multipart/form-data" accept=".xls,.xlsx" >
				<div class="form-group">
					<input type="file"  name="excel" onchange="checkfile(this)" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
				</div>
				 <div class="file-path-wrapper">
            <input class="btn btn-primary" type="submit" value="upload">
        </div>
			</form>  
		</div>
		<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
	</div>
	<!-- /.main-container -->
</body>
</html>