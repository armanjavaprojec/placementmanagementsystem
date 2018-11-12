<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.nacre.pms.util.StringConstants"%>
<%@page import="com.nacre.pms.util.URLConstants"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<div id="sidebar" class="sidebar responsive">
	<!--MAIN - MENU - START-->
	<ul class="nav nav-list">
		<li class=""><a
			href="${path}/<%=URLConstants._VIEW_BATCHES%>"> <i
				class="menu-icon fa fa-clock-o " style="color: Green;"></i> <span
				class="menu-text"> <b>View Batches</b></span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/<%=URLConstants._VIEW_TECHNOLOGIES%>"> <i
				class="menu-icon fa fa-pencil-square-o  " style="color: Green;"></i>
				<span class="menu-text"> <b>View Technologies</b> </span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/<%=URLConstants._ASSIGN_BATCH_TECH%>"> <i
				class="menu-icon fa fa-pencil-square-o  " style="color: Green;"></i>
				<span class="menu-text"> <b>Assign Batch to Technology</b> </span>

		</a> <b class="arrow"></b></li>
		<li class=""><a
			href="${path}/<%=URLConstants._VIEW_TRAINEES_EDIT_DELETE%>"> <i
				class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> <b>View Trainees</b> </span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/<%=URLConstants._ADD_TRAINEES%>">
				<i class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> <b>Add Trainees</b> </span>

		</a> <b class="arrow"></b></li>


		<li class=""><a
			href="${path}/jsp/hr/view_placed_option.jsp">
				<i class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> <b>View Placed Trainees</b> </span>

		</a> <b class="arrow"></b></li>
		
		
		<li class=""><a
			href="${path}/<%=URLConstants._VIEW_FEEDBACKS%>">
				<i class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> <b>View Feedbacks</b> </span>

		</a> <b class="arrow"></b></li>


</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/SendInterviewRoundController">
				<i class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> <b>Send interview details Trainees</b> </span>

		</a> <b class="arrow"></b></li>








		<br />


		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left"
				data-icon1="ace-icon fa fa-angle-double-left"
				data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>
</div>