<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>User Profile</title>

<meta name="description" content="3 styles with inline editable feature" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<script src="<%=application.getContextPath()%>/css/bootstrap.min.css"></script>

<script
	src="<%=application.getContextPath()%>/assets/js/jquery.2.1.1.min.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script
	src="<%=application.getContextPath()%>/assets/js/bootstrap.min.js"></script>

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">

</head>
<style type="text/css">
.prof-page-info {
	padding: 10px;
}

.prof-img {
	width: 100%;
	height: 300px;
	position: relative;
	border: 5px solid #666;
}

.prof-img img {
	position: absolute;
	width: 100%;
	height: 100%;
	padding: 3px;
}

.img-title {
	position: absolute;
	bottom: 0px;
	background: #666;
	color: #fff;
	width: 100%;
	text-align: center;
	padding: 5px;
	border: 1px solid #fff;
	padding: 5px 5px 5px 5px;
}

.info {
	padding: 10px;
	font-size: 14px;
	border-bottom: 1px solid #ddd;
	width: 400px;
}

.prog-page {
	border: 1px solid #ddd;
	box-shadow: 1px 1px 5px #ddd;
	position: relative;
}

.header-info {
	position: relative;
	padding-left: 25px;
	background: #666;
	color: #fff;
	padding: 1px;
}

.prof-info .info i {
	padding: 8px 9px 0px 9px;
	box-shadow: 1px 1px 5px #ddd;
	background: #0099ff;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	color: #fff;
	margin-right: 30px;
}

.header-info i {
	padding-right: 8px;
	font-size: 25px;
}

.prog-page {
	width: 650px;
	margin-left: 260px;
}

.col-xs-12.col-sm-3.center {
	padding-top: 60px;
}

.prof-info {
	padding-left: 250px;
	margin-top: -290px;
}

.col-xs-12.col-sm-3.center {
	width: 233px;
}
</style>
<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				url : '<%=application.getContextPath()%>/UserProfile',
									type : 'post',
									dataType : 'json',
									success : function(data) {
										$("#trow")
												.append(
														" <tr><td> <img src="+data.pic+" class='img-circle' alt='Red dot' width='200' height='200' /></td></tr> ");
										$("#fname")
												.append(
														"<tr><td> "
																+ data.firstName
																+ "</td></tr> <tr><td>&nbsp;"
																+ data.lastName
																+ "</td></tr>");
										$("#name").append(
												"<tr><td> " + data.firstName
														+ "</td></tr>");
										$("#lname").append(
												"<tr><td> " + data.lastName
														+ "</td></tr>");
										$("#email").append(
												"<tr><td> " + data.email
														+ "</td></tr>");
										$("#mob").append(
												"<tr><td> " + data.mobile
														+ "</td></tr>");
										$("#pin").append(
												"<tr><td> " + data.pin
														+ "</td></tr>");
										$("#country").append(
												"<tr><td> " + data.country
														+ "</td></tr>");
										$("#state").append(
												"<tr><td> " + data.state
														+ "</td></tr>");
										$("#city").append(
												"<tr><td> " + data.city
														+ "</td></tr>");
										$("#addrs").append(
												"<tr><td> " + data.address
														+ "</td></tr>");
									}
								});
					});
</script>
<body class="no-skin">
	<div class="main-container" id="main-container">
		<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
		<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>

		<!------ Include the above in your HEAD tag ---------->
		<div class="container" style="margin-top: 120px;">
			<div class="prog-page">
				<div class="header-title header-btn">
					<div class="header-info">
						<h2>
							<i class="fa fa-info-circle"></i>Profile Information
						</h2>
					</div>
				</div>

				<div id="user-profile-1" class="user-profile row">
					<div class="col-xs-12 col-sm-3 center">
						<span class="img-circle" id=trow> </span>



						<div
							class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
							<div class="inline position-relative">
								<i class="ace-icon fa fa-circle light-green"></i> &nbsp; <span
									class="white" id="fname"></span>

							</div>
						</div>
					</div>
					<div class="col-md-9">
						<div class="prof-info">

							<div class="info">
								<label><i class="fa fa-user"></i><b>First Name :</b></label> <span
									id="name"></span>
							</div>
							<div class="info">
								<label><i class="fa fa-user"></i><b>Last Name :</b></label> <span
									id="lname"></span>
							</div>
							<div class="info">
								<label><i class="fa fa-calendar"></i><b>Email :</b></label> <span
									id="email"></span>
							</div>
							<div class="info">
								<label><i class="fa fa-male"></i><b>Mobile :</b></label> <span
									id="mob"></span>
							</div>

							<div class="info">
								<label><i class="fa fa-map-marker"></i><b>Zip Code :</b></label>
								<span id="pin"></span>
							</div>


							<div class="info">
								<label><i class="fa fa-map-marker"></i><b>State :</b></label> <span
									id="state"> </span> , <span id="country"></span>
							</div>
							<div class="info">
								<label><i class="fa fa-male"></i><b>Address :</b></label> <span
									id="addrs"></span>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
	<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
	<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</body>
</html>
