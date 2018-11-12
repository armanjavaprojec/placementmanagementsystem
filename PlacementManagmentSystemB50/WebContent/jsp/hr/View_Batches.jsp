<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' href='<%=application.getContextPath()%>/css/jquery-ui.min.css'> 
<script type="text/javascript" src="<%=application.getContextPath()%>/js/jquery.min.js"></script>

<style>
 <header>
 background-color: #438eb9;
 </header>
div {
    margin-right: 150px;
    margin-bottom: 100px;
    margin-left: 80px;
    padding-bottom:150px;
    margin-left: 80px;
    }
.form-control{
              padding-bottom:50px;
             }
.btn-success{
             width:60px;
             border-radius:3px;
             margin-left:1005px;
             float-right;
             color:rgb(0, 77, 19);
            }
h2{
  margin-left:110px;
  text-align:center;
  float:left;
  margin-top:90px;
  }
.btn-primary{
             text-align:center;
             margin-left:150px;
             border-radius: 3px;
             margin-top:10px;
             padding-bottom:2px;
             text-color:white;
             width:60px;
            }
 .btn-default{
              text-align:center;
              margin-right:150px;
              background-color:#e62e00;
              border-radius: 3px;
              width:60px;
              color:#0040ff!important;
              text-color:white;
              border-radius: 5px;
             }
.modal-body .p1{
               text-align:center;
               font-size:20px;
               height:15px;
               }
.modal-body .p2{
                text-align:center;
                font-size:20px;
                height:15px;
               }
.modal-body .s{
             text-align:center;
             padding-bottom:10px;
           }
.modal-title{
             background-color:#438eb9!important;
             color: white;
             text-align: center;
             border-radius:5px;
            }
.button1{
         background-color: green;
         float:right;
         margin-right:115px;
         color:white;
         margin-top:-400px;
         border-radius: 5px;
        }
.btn-danger{
           border-radius: 3px;
           margin-bottom:7px;
           width:60px;
           }
tr:hover,td:hover{
                 background-color: #dddddd!important;
                 }
.inputfield:hover{
                 height:50px
                 }
.modal-body .form-control{
             padding-bottom:10px;
             width:300px;
             padding-top=5px;
             align:center;
             }
.resizedTextbox {
                width: 100px;
                height: 20px;
                padding: 1px
                }
.close{
        float: right;
        font-size: 20px;
        font-width: 700;
        line-height: 1;
        color:hsl(0, 100%, 45%);
        text-shadow: 0 1px 0 #ff3300;
        background-color:black;
        opacity: .2;
      }
.modal-header{
               border:none;
               border-bottom:0px;
             }
.d{
    width:100%;
} 
.s{
   width:100%;
}        
#btn1 {
    font-size: 20px;
    margin-right: 51px;
    margin-left: 1000px;
}
#mytable {
    width: 69%;
    font-size:20px;
}
#r {
    background-color: #438eb9!important;
    color:white;
}
#d {
    width: 80px;
}

#mytable1 {

    font-size: 20px;
    width: 69%;
    text-align: center;
    border-color: black;

}
</style>
<script type="text/javascript">
var mymonth=['01','02','03','04','05','06','07','08','09','10','11','12'];
$(document).ready(function(){

	
	//======
		

	
	$.get("<%=request.getContextPath()%>/ViewBatchController",function(data){
		var a="<tr id='r'><th>S.No</th><th>Batch</th><th>Batch Start Date</th><th>Batch End Date</th><th>Action</th></tr>";
	 if(data!='')
	 {
		var cnt=1;
		$.each(JSON.parse(data),function(k,v){
			var bid=v.batchId;
			var bname=v.batch;
			var bstartDt=v.batch_start_date;
			var bendDt=v.batch_end_date;
			a=a+"<tr><td>"+cnt+"</td><td>"+v.batch+"</td><td>"+v.batch_start_date+"</td><td>"+v.batch_end_date+"</td><td>"+"<button type='button' id='a' class='btn1 btn-primary' onclick='edit("+bid+")'>Edit</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+"<button type='button' id='d' class='btn1 btn-danger' onclick='delet("+bid+")'>Delete</button></tr>";
			cnt++;	
		});
			}
			else{
				$("#mytable1").html("Data is not available");
          }
		$("#mytable").html(a);
	});
});

 var batchid;
 function delet(bid){
 batchid=bid;
 $("#deleteModal").modal('show');
};
function deleteFunction(){
	  $.get("<%=application.getContextPath()%>/DeleteBatchControllerller?id="+batchid,function(data){
			if(data!=null){
				$( "#success_msg2" ).modal('show')
				Reload();
			}	  
			else{
				if(data==null)
					{
					 $("#empty_table").modal('show')
					  Reload();
					}
				else{
				$( "#failure_msg2" ).modal('show')
				Reload();
				}
			}
		 });
};
var mymonth=['01','02','03','04','05','06','07','08','09','10','11','12'];
function edit(bid){
	batchid=bid;
	 $.get("<%=request.getContextPath()%>/EditBatchController?id="+bid,function(data){
		 if(data!='')
		 { 
			 $.each(data,function(k,v){
			 var batch=v.batch;
			 var bstartDt=v.batch_start_date;
			 var bendDt=v.batch_end_date;
			 var d=new Date(bstartDt);
			 var d1=new Date(bendDt);
			 Date.prototype.formatMMDD=function(){
				 var tmp=this.getMonth();
				 var tmpdate=this.getDate().toString();
				 var tmplen=tmpdate.length;
				 if(tmplen==1)
					 {
					 return (this.getFullYear())+"-"+mymonth[tmp]+"-"+"0"+(this.getDate());
					 }
				 else
					 {
					 return (this.getFullYear())+"-"+mymonth[tmp]+"-"+(this.getDate());
					 }
			 }
			 var bst=d.formatMMDD();
			 var bet=d1.formatMMDD();
			 var today = new Date();
				var curr_date = today.getDate();
				var curr_month = today.getMonth() + 1;
				var curr_year = today.getFullYear();
				var today_date = curr_year + "-" + curr_month + "-" + curr_date;
				var todDate = new Date(today_date);
				var compstartDate=new Date(bst);
				var compendDate=new Date(bet);
				if(todDate>compstartDate)
					{
					document.getElementById("bsdt").disabled='disabled';
					}
			 if(todDate>compendDate)
				{
				document.getElementById("edit").disabled='disabled';
				document.getElementById("bsdt").disabled='disabled';
				document.getElementById("bedt").disabled='disabled';
				document.getElementById("id_btn_update").disabled='disabled';
				}
			 document.getElementById("edit").value=batch;
			 document.getElementById("bsdt").value=bst;
			 document.getElementById("bedt").value = bet;
			 $("#editModal").modal('show');
			});
				}
				else{
					$("#mytable1").html("Its Failed to Edit");
	          }
		});
}
function updateFunction(){
	var batch=$("#edit").val();
	var bsd=$("#bsdt").val();
	var bed=$("#bedt").val();
	$.get("<%=request.getContextPath()%>/UpdateBatchController?id="+batchid+"&edit="+batch+"&bsdt="+bsd+"&bedt="+bed,function(data){
			if(data>0){
				$( "#success_msg3" ).modal('show')
				Reload();
			}	  
			else{
				if(data==0){
		             $("#tech_name_exist").modal('show')
		             Reload();
	             }
				else{
					$( "#failure_msg3" ).modal('show')
				    Reload();
				}
			}
		});
}
function addTechValidation(){
	var sp_last=document.getElementById("sp");
	var div_last=document.getElementById("div");
    var last=document.getElementById("tech");
	var vlast=last.value;
	vlast=vlast.trim();
	var letter=/^[a-zA-Z]+$/;
	if(vlast == "")
	{
		last.style="border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		last.style.width="300px";
	}
	if(!last.value.match(letter)){
		last.style= "border-color: red;";
		div_last.className='form-group has-error has-feedback';
		sp_last.className='glyphicon glyphicon-remove form-control-feedback';
		last.style.width="300px";
	}
	else
	{
		last.style="border-color: green;";
		last.style.width="300px";
		div_last.className='form-group has-success has-feedback';
		sp_last.className='glyphicon glyphicon-ok form-control-feedback';
	}
}
function addFunction()
{
	var success=document.getElementById('success_msg');
	var batch=$("#batch").val();
	var bsdt=$("#sdt").val();
	var bedt=$("#edt").val();
	if(document.getElementById('batch').value!="" && document.getElementById('sdt').value!="" && document.getElementById('edt').value!=""){
	$.get("<%=application.getContextPath()%>/AddBatchController?batch="+batch+"&bsdt="+bsdt+"&bedt="+bedt,function(data){
		if(data!=0){
			          $( "#success_msg1" ).modal('show')
		              Reload();
		             }
		else{
			if(data!=0){
	             $("#tech_name_exist").modal('show')
	             Reload();
                  }
			else{
				$( "#failure_msg1" ).modal('show')
			    Reload();
			    }
		    }	  
       });
	 }
	else
		{
		$( "#failure_msg4" ).modal('show')
		 Reload();
		}
	
	$('#batch').val('');
	$('#sdt').val('');
	$('#edt').val('');
	
}
function ReloadPage(){
	location.reload();
};
function Reload(){
		setTimeout("ReloadPage()",1000);
};

</script>
<body>
<!--Header -->
<body class="no-skin">
<jsp:include page="../../jsp/common/common_css.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_header.jsp"></jsp:include>
<jsp:include page="../../jsp/common/hr_menu.jsp"></jsp:include>
<h4 class="pink">
			<i
				class="ace-icon fa fa-hand-o-right icon-animated-hand-pointer blue"></i>
			<b class="blue">Batch Details</b>
		</h4>

<!-- Delete Modal -->
 <div id="deleteModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <center><h4 class="modal-title">Delete Batch</h4> </center>
         </div>
       <div class="modal-body" id="t">    
         <div id="mydiv">
         <center><h3> Are you confirm to delete</h3></center>
        </div>
      </div>
      <div class="modal-footer">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <button type="button" class="btn1 btn-default" data-dismiss="modal" onclick="deleteFunction()">Yes</button>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <button type="button" class="btn2 btn-default" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>


<!-- Edit Modal -->
 <div id="editModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <center><h4 class="modal-title">Edit Batch</h4></center>
         </div>
       <center>
       <div class="modal-body" id="t">
           <center><table>
            <tr>
             <td><b>Batch :</b></td> 
              <td>
                <div id="div" class="d">
                 <input type="text" name="edit" id="edit"/></br>
               </div>
              </td>
             </tr>
              <tr>
             <td><b> Batch Start Date :</b></td> 
              <td>
                <div id="divs" class="sd">
               <input type="date" name="bsdt" id="bsdt"/></br>
               </div>
              </td>
             </tr>
              <tr>
             <td><b> Batch End Date :</b></td> 
              <td>
                <div id="dive" class="ed">
                 <input type="date" name="bedt" id="bedt"/>
               </div>
              </td>
             </tr>
         </table></center>
        </div>
      <div class="modal-footer">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <button type="button" class="btn1 btn-default" data-dismiss="modal" id="id_btn_update" onclick="updateFunction()">Update</button>
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <button type="button" class="btn2 btn-default" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>


<!--Add Modal -->
  <div class="modal fade" id="myModal2" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Batch</h4>
          </div>
          <div class="modal-body">
           <center><table>
            <tr>
             <td><b>Batch :</b></td> 
              <td>
                <div id="div" class="d">
                 <input type="text" onfocus="this.value=''" class="form-control" id="batch" name="batch" onchange='addTechValidation()' maxlength="35"/>
               </div>
              </td>
             </tr>
              <tr>
             <td><b> Batch Start Date :</b></td> 
              <td>
                <div id="divs" class="sd">
                 <input type="text" onfocus="this.value=''" class="form-control" id="sdt" name="sdt" maxlength="35"/>
               </div>
              </td>
             </tr>
              <tr>
             <td><b> Batch End Date :</b></td> 
              <td>
                <div id="dive" class="ed">
                 <input type="text" onfocus="this.value=''" class="form-control" id="edt"  name="edt" maxlength="35"/>
               </div>
              </td>
             </tr>
         </table></center>
        </div>
        <div class="modal-footer">
          <button type="button" id="add" class="btn1 btn-default" data-dismiss="modal" onclick="addFunction()">Submit</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <button type="button" class="btn2 btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
 </div>
<button type="button" id="btn1" class="btn1 btn-success" data-toggle="modal" data-target="#myModal2">ADD</button>
<center><table id="mytable" class="table1"  border="1"></table></center>
<center><table id="mytable1" class="table1" border="1" style="color:red;"></table></center>

<!--Data Inserted Successfully pop up Starts-->
<div class="modal fade" id="success_msg1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
    <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-up"></i>
        <label class="p1"><font style="padding:70px;font-size: 25px;" color='##006600'>Data Inserted Successfully!<i class="fa fa-smile-o"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

<!--Data Deleted Successfully pop up Starts-->
<div class="modal fade" id="success_msg2" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
    <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-up"></i>
        <label class="p1"><font style="padding:70px;font-size: 25px;" color='##006600'>Data Deleted Successfully!<i class="fa fa-smile-o"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

<!--Data Updated Successfully pop up Starts-->
<div class="modal fade" id="success_msg3" role="dialog">
  <div class="modal-dialog">
     <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
    <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-up"></i>
        <label class="p1"><font style="padding:70px;font-size: 25px;" color='##006600'>Data Updated Successfully!<i class="fa fa-smile-o"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

<!--Data Not Inserted Failure pop up Starts-->
<div class="modal fade" id="failure_msg1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
        <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-down"></i>
        <label class="p2"><font style="padding:70px;font-size: 25px;" color='#ff3300'>Failed! Data Is Not Inserted<i class="sentiment_very_dissatisfied"></i></font></label></h1>
      </div>
      </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

<!--Data Not Deleted Failure pop up Starts-->
<div class="modal fade" id="failure_msg2" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
        <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-down"></i>
        <label class="p2"><font style="padding:70px;font-size: 25px;" color='#ff3300'>Failed! Data Is Not Deleted<i class="sentiment_very_dissatisfied"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

<!--Data Not Updated Failure pop up Starts-->
<div class="modal fade" id="failure_msg3" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
        <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-down"></i>
        <label class="p2"><font style="padding:70px;font-size: 25px;" color='#ff3300'>Failed! Data Is Not Updated<i class="sentiment_very_dissatisfied"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->


<!--Check duplicate technology name exist pop up Starts-->
<div class="modal fade" id="tech_name_exist" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
        <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-down"></i>
        <label class="p2"><font style="padding:70px;font-size: 25px;" color='#ff3300'>Data Already Exist Please Try Again<i class="sentiment_very_dissatisfied"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->
		
<!--failure pop up Starts-->
<div class="modal fade" id="failure_msg4" role="dialog">
  <div class="modal-dialog">
     <div class="modal-content">
    <div style="    margin-left: 15px;margin-right: 15px;">
        <button type="button" class="alert2 close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h1><i class="glyphicon glyphicon-thumbs-down"></i>
        <label class="p2"><font style="padding:70px;font-size: 25px;" color='#ff3300'>Failed! Please enter the Batch details<i class="sentiment_very_dissatisfied"></i></font></label></h1>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal --><!--Success pop up ends-->

		
 <jsp:include page="../../jsp/common/main_content_end.jsp"></jsp:include>
<jsp:include page="../../jsp/common/footer.jsp"></jsp:include>
<jsp:include page="../../jsp/common/common_js.jsp"></jsp:include>
</div><!-- /.main-container -->

<script type="text/javascript" src="<%=application.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"  src="<%=application.getContextPath()%>/js/datevalidation.js"></script>
</body>
</html>