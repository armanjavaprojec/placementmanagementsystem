<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.nacre.pms.dto.UserDTO"%>
<%
	String batchId = request.getParameter("batchId");
	String techId = request.getParameter("techId");

	RequestDispatcher reqDispatch = request.getRequestDispatcher("/batchtechloadcontroller?req=trinfo");
	request.setAttribute("batchId", batchId);
	request.setAttribute("techId", techId);
	reqDispatch.include(request, response);

	List<UserDTO> objAllTRInfo = (ArrayList<UserDTO>) request.getAttribute("allTRInfo");
	Iterator<UserDTO> objIterator = objAllTRInfo.iterator();

	int count = 1;
	if (objIterator.hasNext()) {
%>
<table class="table table-bordered" id="table_hr_info" style="font-size: medium;">
	<tr style="background-color: skyblue;">
		<th>Sr.NO</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Contact</th>
		<th>Mail</th>
		<th>Address</th>
		<th>City</th>
		<th>State</th>
		<th>Country</th>
		<th>Details</th>
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
				out.println(objUserDTO.getMobileNo());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getEmail());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getAddress().getLocation());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getAddress().getCity().getCity());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getAddress().getCity().getState().getState());
			%>
		</td>
		<td>
			<%
				out.println(objUserDTO.getAddress().getCity().getState().getCountry().getCountry());
			%>
		</td>
		<td style="background-color: DarkGrey">
			<button type="button"
				onclick="editTrainee('<%out.print(objUserDTO.getUserid());%>')"
				class="btn btn-primary btn-sm" data-toggle="modal"
				data-target="#myModal">Edit</button>
			<button type="button"
				onclick="deleteTrainee('<%out.print(objUserDTO.getUserid());%>',this)"
				class="btn btn-danger btn-sm" data-toggle="modal"
				data-target="#myDelModal">Delete</button>
		</td>
	</tr>
	<%
		count++;
			}
	%>
</table>
<%
	} else {
		out.println("No Record Found..");
	}
%>