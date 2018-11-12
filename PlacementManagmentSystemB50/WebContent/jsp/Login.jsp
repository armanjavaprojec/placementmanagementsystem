<%@page import="org.apache.commons.codec.net.URLCodec"%>
<%@page import="java.net.CookieStore"%>
<%@page import="com.nacre.pms.util.URLConstants"%>
<%@page import="com.nacre.pms.util.StringConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<%!Integer role = null;
	String rememberVal = null;
	String email = "";
	String password = "";%>
<%
	Cookie[] cookies = request.getCookies();
	if (session.getAttribute(StringConstants._SESSION_USER_ROLE_ID) != null) {

		role = (Integer) (session.getAttribute(StringConstants._SESSION_USER_ROLE_ID));
		if (role == StringConstants._ADMIN_ROLE_ID) {
			request.getRequestDispatcher("/" + URLConstants.ADMIN_HOME_PAGE_URL).forward(request, response);
		} else if (role == StringConstants._HR_ROLE_ID) {
			request.getRequestDispatcher("/" + URLConstants.HR_HOME_PAGE_URL).forward(request, response);
		} else if (role == StringConstants._TRAINEE_ROLE_ID) {
			request.getRequestDispatcher("/" + URLConstants.TRAINEE_HOME_PAGE_URL).forward(request, response);
		} else {
			request.getRequestDispatcher("/" + URLConstants.LOGIN_PAGE_URL);
		}
	}

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(StringConstants._SESSION_EMAIL)) {
				email = cookie.getValue();
			}

			if (cookie.getName().equals("cookrem")) {
				rememberVal = cookie.getValue();
			}
			if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
	}
%>
<html lang="en">
<head>
<link rel="icon" href="assets/images/nacre/nacre.png" type="image/x-icon">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<meta name="description" content="Nacre Software Services Assesment" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>LOGIN</title>
<link rel="stylesheet" href="${path}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${path}/assets/font-awesome/4.2.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="${path}/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" href="${path}/assets/css/ace.min.css" />
<link rel="stylesheet" href="${path}/assets/css/ace-rtl.min.css" />
<script src="${path}/assets/js/jquery.1.11.1.min.js"></script>
<script src="${path}/assets/js/jquery.validate.min.js"></script>
<script src="${path}/assets/js/additional-methods.min.js"></script>
<script type="text/javascript" src="${path}/js/AvoidingBackButton.js"> </script>
<script type="text/javascript" src=" ${ path }/js/AvoidingForwardButton.js"> </script>
<script>
	function EmailOrPhone() {
		var NoRegexp = new RegExp(/^[789]{1}\d{9}$/);
		var eRegex = new RegExp(/^([a-zA-z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/);
		var d = document.getElementById('username').value;
		if(d==''){
			document.getElementById('msg').innerHTML = 'Please enter a valid Mobile No or Email';
		}
		else{
		if (isNaN(d)) {
			if (eRegex.test(d)) {
				document.getElementById('msg').innerHTML = '';
			} else {
				document.getElementById('msg').innerHTML = 'Please enter a valid Email';
			}
		} else {
			if (NoRegexp.test(d)) {
				document.getElementById('msg').innerHTML = '';
			} else {
				document.getElementById('msg').innerHTML = 'Please enter a valid Mobile No';
			}
		}
	}
	}
	
	
	function CheckPassword(){
		var PwRegexp = new RegExp(/^[0-9 A-Z a-z]{8}$/);
		var pass = document.getElementById('password').value;
		if (pass!='') {
				if(pass.length==8){
					document.getElementById('msg1').innerHTML = '';
				}
				else{
					document.getElementById('msg1').innerHTML = 'Password Should be 8 Characters';
				}
			}
		 else {
			document.getElementById('msg1').innerHTML = 'Please Enter Password';
		}
	}
</script>

<style type="text/css">
img.img-rounded {
	height: 100px;
	position: relative;
	top: 75px;
	right: 120px;
}

font.red {
	height: 100px;
	position: relative;
	top: -20px;
	right: -60px;
	font-size: 40px;
}

font.white {
	font-size: 28px;
	position: relative;
	top: -20px;
	right: -60px;
}

body {
	background-image:
		url("<%=application.getContextPath()%>/menu/img/bg-masthead.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: 120%;
}

.space-6 {
	padding-bottom: 30px;
}
.footer {
    padding-top: 0px;
    }
</style>
</head>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div align="center" style="color: black; margin-top: 50px">
						<h1>Placement Management System</h1>
					</div>
					<div class="login-container">
						<%
							String s = request.getParameter("regSucc");
							if (s != null) {
						%>
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Success!</strong>
							<%=s%>
						</div>

						<%
							}
						%>
						<div class="center">
							<%
								String message = (String) session.getAttribute("forgotpassword_msg");
								if (message != null) {
							%>
							<div class="alert alert-success">
								<a href="#" class="close" data-dismiss="alert"
									aria-label="close">&times;</a> <strong>CHECK YOUR MAIL
									!</strong>
								<%=message%>
							</div>
							<%
								session.removeAttribute("forgotpassword_msg");
								}
							%>



						</div>


						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="ace-icon fa fa-coffee green"></i> Please Enter Your Credentials
										</h4>
										<div class="space-6"></div>
										<form id='loginform' action="${path}/LoginAction" method="post">
											<fieldset>
												<label class="block clearfix"> 
												<span class="block input-icon input-icon-right"> <input
														type="text" class="form-control"
														placeholder="Username/Email" name="username" id='username'
														onblur='EmailOrPhone()' autocomplete="off"
														value="<%=email%>" /> <label id='msg' style="color: red"></label>
														<i class="ace-icon fa fa-user"></i>
												</span>
												</label> 
												<div class="space"></div>
												<label class="block clearfix"> 
												<span class="block input-icon input-icon-right"> <input
														type="text" class="form-control"
														placeholder="password" name="password" id='password'
														autocomplete="off" onblur='CheckPassword()' 
														value="<%=password%>" /> <label id='msg1' style="color: red"></label>
														<i class="ace-icon fa fa-lock"></i>
												</span>
												
												</label>

												<div class="space"></div>

												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														name="remember" class="ace"
														<%="on".equals(rememberVal) ? "checked=" + "checked" : ""%> />
														<span class="lbl"> Remember Me</span>
													</label> <input type="submit" value="Login"
														class="width-35 pull-right btn btn-sm btn-primary" />

												</div>


												<div class="space-4"></div>
											</fieldset>
										</form>

										<div class="social-or-login center">
											<span class="label label-danger"> 
												<%
													String msg = (String) session.getAttribute("login-msg");
													if (msg != null) {
												%> <label class='label label-danger' style="color: red"><%=msg%></label>
												<%
													session.removeAttribute("login-msg");
													}
												%>
											</span>
										</div>

									</div>
									<!-- /.widget-main -->

									<div class="toolbar clearfix">
										<div>
											
											<a href="<%=application.getContextPath() %>/jsp/ForgotPassword.jsp" class='user-signup-link'>
													<i class="ace-icon fa fa-arrow-left"></i>
											
											Forgot Password
											
											</a>
										   </div> 

											<div>
												<a href="<%=application.getContextPath()%>/index.html"  class="user-signup-link">
													Home
													<i class="ace-icon fa fa-arrow-right"></i>
												</a>
											</div>


									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.login-box -->

							
							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="ace-icon fa fa-key"></i> Retrieve Password
										</h4>

										<div class="space-6"></div>
										<p>Enter your email and to receive instructions</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="ace-icon fa fa-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="ace-icon fa fa-lightbulb-o"></i> <span
															class="bigger-110">Send Me!</span>
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /.widget-main -->

									<div class="toolbar center">
										<a href="#" data-target="#login-box"
											class="back-to-login-link"> Back to login <i
											class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.forgot-box -->

								</div>
								<!-- /.widget-body -->
							</div>
							<!-- /.signup-box -->
						</div>
						
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.main-content -->
	</div>

	<jsp:include page="../jsp/common/footer.jsp"></jsp:include>

</body>
</html>
