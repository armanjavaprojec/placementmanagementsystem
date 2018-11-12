<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nacre.pms.dto.UserDTO"%>
<%@page import="java.util.List"%>

<%
	String jobPostId = request.getParameter("jobPostId");

	RequestDispatcher reqDispatch = request.getRequestDispatcher("/maintainroundcontroller?req=nextround");
	request.setAttribute("jobPostingId", jobPostId);
	reqDispatch.include(request, response);

	List<UserDTO> objAllTRInfo = (ArrayList<UserDTO>) request.getAttribute("allTRInfo");
	Iterator<UserDTO> objIterator = objAllTRInfo.iterator();

	int count = 1;
	if (objIterator.hasNext()) {
		out.println("<h4>Select trainees for final placement :</h4>");
%>
<table class="table table-bordered" id="table_final_shortlisted_info" style="font-size: medium;">
	<tr style="background-color: skyblue;" id="tr<%=count %>">
		<th>Sr.NO</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Mail</th>
		<th>Placement Status</th>
	</tr>
	<%
		while (objIterator.hasNext()) {
				UserDTO objUserDTO = objIterator.next();
	%>
	<tr>
		<td style="background-color: DarkGrey">
			<%
				out.println(count);
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getFirstname());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getLastname());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getEmail());
			%>
		</td>
		<td style="background-color: DarkGrey">
			<select id="sel_action<%=count %>" required="required" onchange="placeStudent(this,'<%out.print(objUserDTO.getUserid());%>')">
				<option value='0' selected="selected">SELECT</option>
				<option value='11'>Placed</option>
				<option value='6'>Rejected</option>
			</select>		
		</td>
	</tr>
	<%
		count++;
			}
	%>
</table>
<%
	} else {
		out.println("<h2>All Information upto date..</h2>");
	}
%>
<br>
<br>