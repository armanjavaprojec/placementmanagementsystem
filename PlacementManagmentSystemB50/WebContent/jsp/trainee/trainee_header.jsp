<%@page import="com.nacre.pms.util.URLConstants"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="<%=application.getContextPath()%>"></c:set>
<style type="text/css">
div#sidebar li {
	height: 50px;
}
</style>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript" src="../../assets/js/jquery.2.1.1.min.js"></script>
</head>
<script type="text/javascript">
var count=0;
var clientcount=0;
$('button').click(function(){
	 var x=$(this).val();
	
});

//showing data into Notifiaction
$("document").ready(function() {
       $.get("<%=application.getContextPath()%>/GetViewNotificationTOTrainee?req=multiple",function(data) {
           var opt;
             opt="<li></li>";
                $.each(data,function(k,v){
                    if(v.countryid==1 || v.countryid==0){
                    	count++;	
                    }
                    clientcount++;
                    opt+="<li style='LINE-HEIGHT:20px;' id='li'>We have openings in "+v.clientName+" for "
                               +v.description+". Last date to apply:: "+v.expectedDate
                               +" .<button type='button' class='btn btn-link' value='"+v.countryid+"' onclick='validate(this)' id='btn"+k+"'>more..</button><div id='ntfc"+k+"' style='visibility:hidden; height:0px;'> C P Name "
                               +v.contactPresonName+" C P Mob. "+v.contactPresonMobileNO+" Email: "
                               +v.contactPresonNameEmail+". Address:: "
                               +v.location+" , "+v.city+" About Company::"
                               +v.clientDescription+"</div><button id='bn"+k+"' value='"+v.jobPostId+"' sytle='height:0px; width:0px; visibility:hidden;'></button><button id='check"+k+"' value='"+v.countryid+"' style='visibility:hidden; height:0px; width:0px;'></button><hr></li>";
                    });
                $("#notificationDetails").append(opt);
                var x=document.getElementById("mainNotificationCount").value;
                if(count>0){
               	 $("#mainNotificationCount").append(count);
                }
                if(count>0){
                $("#notificationCount").append(count);
                }
                /* +v.postDate+"----"
                +v.clientImage+"----" */
       });
});


 //show perticular Company data
function validate(r){

 var a=$(r).parents('li').index()-1;
    
 var jbpstid=document.getElementById("bn"+a).value;
 var read=2;
 window.location.href = "<%=application.getContextPath()%>/GetViewNotificationTOTrainee?req=readedPerticularTrainee&read="+read+"&jobposting="+jbpstid+"&a="+a;         
}
	


</script>

 <!-- This is about ROund  -->
<script type="text/javascript">
var cnt=0;
var roundCount=0;
//showing data into Notifiaction
$("document").ready(function() {
       $.get("<%=application.getContextPath()%>/ShowRoundNotificationToTrainee?req=multiple",function(data) {
           var opt;
             opt="<li></li>";
                $.each(data,function(k,v){
                   if(v.not_status_id==0 || v.not_status_id==1){
                	   cnt++;
                   }
                    roundCount++;
                    opt+="<li style='LINE-HEIGHT:20px;' id='li'>You are Shortlisted for "
                    +v.description+" ("+v.roundNo+" ) of "+v.clientName+" of process .<button type='button' class='btn btn-link' onclick='roundInfo(this)' id='btn"+k+"'>more..</button><button id='bn"+k+"' value='"+v.job_post_id+"' sytle='height:0px; width:0px; visibility:hidden;'></button><button id='round"+k+"' value='"+v.roundNo+"' sytle='height:0px; width:0px; visibility:hidden;'></button></li>";
                });
               
                $("#asd").append(opt);
                if(cnt>0){
                $("#main-count-noti").append(cnt);
                }
                if(cnt>0){
                $("#count-noti").append(cnt); 
                }
                /* +v.postDate+"----"
                +v.clientImage+"----" */
       });
});


//show perticular round data
 function roundInfo(r){
	    var a=$(r).parents('li').index()-1;
         var jbpstid=document.getElementById("bn"+a).value;
         var roundid=document.getElementById("round"+a).value;
        var read=2;
        
        window.location.href = "<%=application.getContextPath()%>/ShowRoundNotificationToTrainee?req=readedPerticularTrainee&a="+a+"&jobposting="+jbpstid+"&read="+read+"&roundid="+roundid;

}


</script>



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
					Trainee
			</small>
			</a>
		</div>

		<div class="navbar-buttons navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="purple">
				<a href="#" data-toggle="dropdown"
					class="dropdown-toggle"> <i
						class="ace-icon fa fa-bell icon-animated-bell"></i><sup><span
						class="badge badge-success" id="mainNotificationCount"></span></sup> 
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
							<a href="<%=application.getContextPath()%>/jsp/trainee/see_all_notification.jsp">
								See all notifications 
								</button>
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
							<span id='count-noti'>0</span> Round Notifications
						</li>

						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar" id="asd">
							</ul>
						<li class="dropdown-content">
							<ul class="dropdown-menu dropdown-navbar">

								<li class="dropdown-footer">
								<a href="<%=application.getContextPath()%>/jsp/trainee/seeAllNotificationRelatedRound.jsp">
										See all notifications <i class="ace-icon fa fa-arrow-right"></i>
								</a>
								</li>
							</ul>
						</li>
					</ul></li>


				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <img class="nav-user-photo"
						height="95%" width="100px"
						src="<%-- <%=session.getAttribute(StringConstants._SESSION_USER_IMG) %> --%>"
						alt="User Photo" /> <span class="user-info"> <small>Welcome,</small>
							<%-- <%=session.getAttribute(StringConstants._SESSION_USER_NAME) %> --%>
					</span> <i class="ace-icon fa fa-caret-down"></i>
				</a>

					<ul
						class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a
							href="<%-- ${path}/<%=URLConstants._CHANGE_PWD_URL%> --%>"> <i
								class="ace-icon fa fa-cog"></i> Change Password
						</a></li>

						<li><a
							href="${path}/get_trainee_deatails_edit"> <i
								class="ace-icon fa fa-user"></i> Profile
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

<!-- Modal -->
<div id="showFB" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">FeedBack</h4>
      </div>
      <div class="modal-body">
          <textarea class="form-control" rows="5" name='fdbk' id="fdbk"></textarea>
      </div>
      <div class="modal-footer">
        <button type="button" class='btn btn-primary' id="send" name="send" value='2'>Send</button>
        <button type="button" class='btn btn-danger' data-dismiss="modal">Close</button>
        
      </div>
    </div>

  </div>
</div>

<!--Data Not Found Modal  -->
<div id="dataNotFound" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Sorry............</h4>
      </div>
      <div class="modal-body">
          <p class="font-weight-bold">No Data Found</p>
      </div>
      <div class="modal-footer">
        <button type="button" class='btn btn-danger' data-dismiss="modal">Close</button>
        
      </div>
    </div>

  </div>
</div>