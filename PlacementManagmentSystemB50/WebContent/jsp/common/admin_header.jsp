<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.nacre.pms.util.StringConstants"%>
<%@page import="com.nacre.pms.util.URLConstants"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<style type="text/css">
div#sidebar li {
	height: 50px;
}
</style>

<!-- -------------------- -->
<div id="navbar" class="navbar navbar-default">
	<div class="navbar-container" id="navbar-container">
		<button type="button" class="navbar-toggle menu-toggler pull-left"
			id="menu-toggler" data-target="#sidebar">
			<span class="sr-only">Toggle sidebar</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<div class="navbar-header pull-left">
			<a href="index.jsp" class="navbar-brand"> 
			<small> 
				<img src='${path}/assets/images/nacre/nacre.png'
					title="Placement Management System" width='30px' class='img-rounded'>
					Admin
			</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="purple">
				<a href="#" data-toggle="dropdown"
					class="dropdown-toggle"> <i
						class="ace-icon fa fa-bell icon-animated-bell"></i> <span
						class="badge badge-success" id="mainNotificationCount"></span>
				</a>

				<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header">
							<i class="ace-icon fa fa-bell icon-animated-bell"></i> 
							<span id="notificationCount"></span> 
							Job posting Notifications
						</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar" id="notificationDetails">
							</ul>
							<li class="dropdown-footer">
								<a href="<%-- ${path}/jsp/student/seeAllNotifications.jsp --%>"> 
								See all notifications 
								<i class="ace-icon fa fa-arrow-right"></i>
								</a>
							</li>
					</ul></li>

				<li class="green"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <i
						class="ace-icon fa fa-pencil-square-o  icon-animated-vertical"></i>
						<span class="badge badge-success" id='main-count-noti'></span>
				</a>

					<ul
						class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">

						<li class="dropdown-header">
							<!-- <i class="ace-icon fa icon-animated-bell"></i> --> <i
							class="ace-icon fa fa-pencil-square-o icon-animated-vertical"></i>
							<span id='count-noti'>0</span> Assesment Notifications
						</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar" id="asd">
							</ul>
						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar">

								<li class="dropdown-footer"><a
									href="<%=application.getContextPath()%>/jsp/student/SeeAll.jsp">
										See all notifications <i class="ace-icon fa fa-arrow-right"></i>
								</a></li>
							</ul>
						</li>
					</ul></li>


				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <img class="nav-user-photo"
						height="95%" width="100px"
						src=" <%=session.getAttribute(StringConstants._SESSION_USER_IMG) %> "
						alt="User Photo" /> <span class="user-info"> <small>Welcome,<br>
						<%=session.getAttribute(StringConstants._SESSION_USER_NAME) %></small>
							<%-- <%=session.getAttribute(StringConstants._SESSION_USER_NAME) %> --%>
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a
							href=" ${path}/<%=URLConstants._CHANGE_PWD_URL%> "> <i
								class="ace-icon fa fa-cog"></i> Change Password
						</a></li>

							<li class="divider"></li>
						<li><a
							href=" ${path}/jsp/admin/admin_profile.jsp"> <i
								class="ace-icon fa fa-cog"></i> Profile
						</a></li>	

						<li class="divider"></li>

						<li><a href=" ${path}/<%=URLConstants.LOGOUT_URL%> ">
								<i class="ace-icon fa fa-power-off"></i> Logout
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- /.navbar-container -->
</div>