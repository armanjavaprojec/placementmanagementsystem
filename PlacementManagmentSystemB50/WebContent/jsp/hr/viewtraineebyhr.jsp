<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript"   src="<%=application.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<%-- <script type="text/javascript" src="<%=application.getContextPath()%>/assets/js/jquery.dataTables.bootstrap.js"></script> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function(){
	
	
	//=======================
		$("#select-all").click(function () {
		  $('.mailCheckBox').attr('checked', this.checked);
	});

	// if all checkbox are selected, check the selectall checkbox
	// and viceversa
	$(".mailCheckBox").click(function(){

		if($(".mailCheckBox").length == $(".mailCheckBox:checked").length) {
			$("#select-all").attr("checked", "checked");
		} else {
			$("#select-all").removeAttr("checked");
		}

	});
	
	
	//================================
	
	
	$.get("<%=request.getContextPath()%>/GetYopController",function(data)
	{
		
	//alert(data)
	  var y="<option value=''>select yop</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  y+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#year").html(y);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetYopController",function(data)
	{
		
	//alert(data)
	  var y="<option value=''>select yop</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  y+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#hscyear").html(y);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetYopController",function(data)
	{
		
	//alert(data)
	  var y="<option value=''>select yop</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  y+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#gradeyear").html(y);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetYopController",function(data)
	{
		
	//alert(data)
	  var y="<option value=''>select yop</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  y+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#postyear").html(y);
	});	  
	});
$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetSpecializationController",function(data)
	{
		
	//alert(data)
	  var sp="<option value=''>select specialization</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  sp+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#gradespecial").html(sp);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetSpecializationController",function(data)
	{
		
	//alert(data)
	  var sp="<option value=''>select specialization</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  sp+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#postspecial").html(sp);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetStreamController",function(data)
	{
		
	//alert(data)
	  var sr="<option value=''>select stream</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  sr+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#gradestream").html(sr);
	});	  
	});

$(document).ready(function(){
	$.get("<%=request.getContextPath()%>/GetStreamController",function(data)
	{
		
	//alert(data)
	  var sr="<option value=''>select specialization</option>";
	  $.each(data,function(k,v){
		  //alert(k+"--"+v)
	  
		  sr+="<option value='"+k+"'>"+v+"</option>";
		  
	           });
	  
	  $("#poststream").html(sr);
	});	  
	});

/* $('#select-all').click(function(event) {   
    if(this.checked) {
        // Iterate each checkbox
        $(':checkbox').each(function() {
            this.checked = true;                        
        });
    } else {
        $(':checkbox').each(function() {
            this.checked = false;                       
        });
    }
});
 */



</script>

<!-- <SCRIPT language="javascript">
$(function(){

	// add multiple select / deselect functionality
	$("#select-all").click(function () {
		  $('.mailCheckBox').attr('checked', this.checked);
	});

	// if all checkbox are selected, check the selectall checkbox
	// and viceversa
	$(".mailCheckBox").click(function(){

		if($(".mailCheckBox").length == $(".mailCheckBox:checked").length) {
			$("#select-all").attr("checked", "checked");
		} else {
			$("#select-all").removeAttr("checked");
		}

	});
});
</SCRIPT>
 -->
<style type="text/css">
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

.submit
{
     border:none;
     background-color:white;
     align:top;
}
th {
    border: 1px solid black;
  	 text-align: centre; 
    padding: 8px;
}
td{
    border: 1px solid black;
    text-align: centre;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
button
{
   background-color: #66d9ff;
    border: none;
    color: white;
    padding: 5px 23px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
}
 
.button1
{
    border: none;
    color: white;
    padding: 5px 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    position: absolute;
}
/* div {
	border: 1px solid black;
	margin-top: 100px;
	margin-bottom: 100px;
	margin-right: 150px;
	margin-left: 80px;
	background-color: lightblue;
}
 */
.toolbar {
    float: left;
}
 #
</style>
<!-- <script type="text/javascript">
$(document).ready(function() {
	alert("hhh")
    $('#search').DataTable( {
        "dom": '<"toolbar">frtip'
    } );
 
    $("div.toolbar").html('<b>Custom tool bar! Text/images etc.</b>');
} );
</script> -->
</head>
<body>


<div class="main-container" id="main-container">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<jsp:include page="../../jsp/common/main_content_start.jsp"></jsp:include>




<div style="width: 100%">
<div style="color:red"><center><h1>Trainee Details</h1></center></div>
<form action="<%=request.getContextPath()%>/FilterTraineeDetailsController" >

<div align="right" style="width: 100%"><button type="submit" value="submit">Search</button></div>
<br>
	<div style="width:100%;overflow-x:auto;overflow-y: auto"><table class="scroll" style="text-align: center;">
<div style="text-align: center;">
		<tr style="background-color:#0099cc;color:white">	
			<th>user id</th>
			<th>trainee name</th>
			<th style="text-align:center; ">email</th>
			<th>Education</th>
			<th style="text-align:center; ">Stream</th>
			<th>Specialization</th>
			<th>percentage</th>
			<th style="text-align:center; ">yop</th>

			<th>Education</th>
			<th>specialization</th>
			<th style="text-align:center; ">stream</th>
			<th>percentage</th>
			<th style="text-align:center; ">yop</th>


			<th>Education</th>
			<th>specialization</th>
			<th style="text-align:center; ">stream</th>
			<th>percentage</th>
			<th style="text-align:center;">yop</th>
			<th>Education</th>
			<th>specialization</th>
			<th style="text-align:center; ">stream</th>
			<th>percentage</th>
			<th style="text-align:center; ">yop</th>
	<th>select</th>

		</tr>
</div>
		<tr>
           		
		
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th><input type="text" name="sscpercentage" style="width: 93%;"></th>
			<th><select id="year" name="sscyop"></select></th>		 
			 <th></th>
			<th></th>
			<th></th>
			<th><input type="text" name="hscpercentage" style="width: 93%;"></th>
			<th><select id="hscyear"   name="hscyop"></select></th>
			
			<th></th>
			<th><select id="gss" name="graduationspecialization" multiple="multiple" size="2">
			<option>cse</option>
			<option>ece</option>
			<option>it</option>
			<option>eee</option>
			<option>computers</option>
			<option>mechanical</option>
		
			
			</select>
			</th>
			<th><select id="gs" name="graduationstream" multiple="multiple" size="2">
			<option>btech</option>
			<option>bca</option>
			<option>bsc</option>
			<option>bcom</option>
			<option>na</option>
			</select>
			</th>
			<th><input type="text" name="graduationpercentage" style="width: 93%;"></th>
			<th><select id="gradeyear" name="yop" multiple="multiple" size="2">
			</select></th>
             <th></th>
			<th><select id="ps" name="postgraduationspecialization" multiple="multiple" size="2">
			<option>embededsystem</option>
			<option>networks</option>
			<option>computers</option>
			<option>finance</option>
			<option>hr</option>
			<option>na</option>
			</select>
			</th>
			<th><select id="pss" name="postgraduationstream" multiple="multiple" size="2">
			<option>mtech</option>
			<option>mca</option>
			<option>mba</option>
			<option>msc</option>
			<option>na</option>
			</select>
			</th>
			<th><input type="text" name="postgraduationpercentage" style="width: 93%;"></th>
			<th><select id="postyear" multiple name="postyop" size="2"></select></th>
                <th><input type="checkbox" name="email"
       					value="${trainee.userDTO.email}" id="select-all"></th>				
		</tr>
		
		
		<c:forEach var="trainee" items="${view}">
		
			<tr>
				
				<td>${trainee.userDTO.userid}</td>
				<td>${trainee.userDTO.firstname}</td>
				<td>${trainee.userDTO.email}</td>

                <% int count=0; 
                %>
				<c:forEach var="etdto"
					items="${trainee.educationalTypeDetailsDTOList}">               
					<td>${etdto.educationTypeDTO.graduationType}</td>
					<td>${etdto.specializationDTO.specialization}</td>
					<td>${etdto.specializationDTO.objStreamDTO.stream}
					<td>${etdto.percentage}</td>
					<td>${etdto.yop}</td>
             <%count++; %>


				</c:forEach>
             <%
               if(count<4)
               {
            	   count=0;
            	   
            	   %>
            	   
            	   <td colspan="5"> No ...Post graduation Available.. </td>
            	   <% 
            	  
               }
              
             %>
             
            
             <td><input type="checkbox"  class="mailCheckBox" name="mailCheckBox" value="${trainee.userDTO.email}" style="m"></td>
       	</tr>
			
		</c:forEach>
 

	</table>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<div class=button1 style="color: blue;"><input type="button" class="btn btn-primary"  onclick="location.href='<%=application.getContextPath()%>/SendMailToEligibleTrainees';" value="sendMail"/></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div class=button1 style="color: blue;"><input type="button" class="btn btn-danger" onclick="location.href='<%=application.getContextPath()%>/jsp/hr/viewtraineebyhr.jsp';" value="cancel"></div>
<%-- <input type="button" onclick="location.href='<%=application.getContextPath()%>/jsp/hr/viewtraineebyhr.jsp';" value="cancel"/> --%>
<%-- <a href="<%=application.getContextPath()%>/SendMailToEligibleTrainees"> send mail</a> --%>
</form>
</div>
<jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</body>


</html>