<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nacre.pms.dto.UserDTO"%>
<%@page import="java.util.List"%>

<%
	String jobPostId = request.getParameter("jobPostId");
	String roundId = request.getParameter("roundId");

	RequestDispatcher reqDispatch = request.getRequestDispatcher("/maintainroundcontroller?req=firstround");
	request.setAttribute("jobPostingId", jobPostId);
	request.setAttribute("roundId", roundId);
	reqDispatch.include(request, response);

	List<UserDTO> objAllTRInfo = (ArrayList<UserDTO>) request.getAttribute("allTRInfo");
	Iterator<UserDTO> objIterator = objAllTRInfo.iterator();

	int count = 1;
	if (objIterator.hasNext()) {
		out.println("<h4>Interested candidate-list for this job :</h4>");
%>
<table class="table table-bordered" id="table_interested_info" style="font-size: medium;">
	<tr style="background-color: skyblue;" id="tr<%=count %>">
		<th>Sr.NO</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Mail</th>
		<th>Action</th>
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
			<select id="sel_action<%=count %>" required="required" onchange="checkAction('<%out.print(objUserDTO.getUserid());%>')">
				<option value='' selected="selected">SELECT</option>
				<!-- <option value='7'>interested</option> -->
				<option value='3'>shortlisted</option>
				<option value='4'>not shortlisted</option>
				<!-- <option value='5'>on hold</option> -->
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
		out.println("<h2>First round already done..</h2>");
	}
%>
<br>

