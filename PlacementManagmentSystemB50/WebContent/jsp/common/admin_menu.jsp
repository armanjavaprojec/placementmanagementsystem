<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.nacre.pms.util.StringConstants"%>
<%@page import="com.nacre.pms.util.URLConstants"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<div id="sidebar" class="sidebar responsive">
	<!--MAIN - MENU - START-->
	<ul class="nav nav-list">
		<li class=""><a
			href=" ${path}/ViewClientDetails"> <i
				class="menu-icon fa fa-clock-o " style="color: Green;"></i> <span
				class="menu-text"> View Clients</span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/jsp/admin/view_job_posting_option.jsp"> <i
				class="menu-icon fa fa-pencil" aria-hidden="true"
				style="color: Green;"></i> <span class="menu-text"> view Job Postings </span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/jsp/admin/add_job_posting_option.jsp"> <i
				class="menu-icon fa fa-pencil-square-o  " style="color: Green;"></i>
				<span class="menu-text">Add Job Posting</span>

		</a>  <%-- <b class="arrow"></b></li>
		<li class=""><a
			href="${path}/<%=URLConstants.GET_SCORE %>"> <i
				class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> Link4 </span>

		</a> <b class="arrow"></b></li>

		<li class=""><a
			href="${path}/<%=URLConstants.VIEW_JOBPOSTING_STUDENT %>">
				<i class="menu-icon fa fa-graduation-cap  " style="color: Green;"></i>
				<span class="menu-text"> Link5 </span>

		</a> <b class="arrow"></b></li> --%>



		<br />


		<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
			<i class="ace-icon fa fa-angle-double-left"
				data-icon1="ace-icon fa fa-angle-double-left"
				data-icon2="ace-icon fa fa-angle-double-right"></i>
		</div>
</div>