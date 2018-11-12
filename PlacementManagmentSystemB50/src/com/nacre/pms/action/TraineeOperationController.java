package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Sagar
 * @version 1.0.0 2018 this controller is used to forward controller to
 *          particular service to perform operation on trainee details
 */
@WebServlet("/traineeoperationcontroller")
public class TraineeOperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TraineeOperationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// getting user operation request
		String req = request.getParameter("req");

		if (req != null) {
			// performing delete trainee operation
			if (req.equals("deleteTrainee")) {
				// getting selected user Id
				String userId = request.getParameter("userId");

				HrDelegate objHrDelegate = new HrDelegate();

				// calling deleteTrainee() method and getting result
				int res = 0;
				try {
					res = objHrDelegate.deleteTrainee(Integer.parseInt(userId));
				} catch (NumberFormatException | DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.setContentType("text/html");
				PrintWriter write = response.getWriter();
				if (res > 0) {
					// user defined message for user if trainee in activated successfully
					write.println("User Seuccessfully Deleted..");
				} else {
					// if problem occurred informed with user convenient msg
					write.println("Problem Occured Try Again..");
				}
			}
			
			if(req.equals("getTraineeData")) {
				System.out.println("Retrive data for"+request.getParameter("userId"));
				
				int userId=Integer.parseInt(request.getParameter("userId"));
				
				HrDelegate objHrDelegate = new HrDelegate();
				
				UserDTO objUserDTO=objHrDelegate.getTraineeDetails(userId);
				List<UserEducationDetailsBO> listEducation=objHrDelegate.getTraineeEduDetails(userId);
				
				if(objUserDTO!=null)
				{
					response.setContentType("application/json");
					PrintWriter write=response.getWriter();
					
					JsonObject jsonTrainee=new JsonObject();
					jsonTrainee.addProperty("firstName", objUserDTO.getFirstname());
					jsonTrainee.addProperty("lastName", objUserDTO.getLastname());
					jsonTrainee.addProperty("mobile", objUserDTO.getMobileNo());
					jsonTrainee.addProperty("mail", objUserDTO.getEmail());
					jsonTrainee.addProperty("location", objUserDTO.getAddress().getLocation());
					jsonTrainee.addProperty("city", objUserDTO.getAddress().getCity().getCity());
					jsonTrainee.addProperty("state", objUserDTO.getAddress().getCity().getState().getState());
					jsonTrainee.addProperty("country", objUserDTO.getAddress().getCity().getState().getCountry().getCountry());
					
					Iterator<UserEducationDetailsBO> iteratorEducation=listEducation.iterator();
					while(iteratorEducation.hasNext())
					{
						UserEducationDetailsBO objUserEducationDetailsBO=iteratorEducation.next();
						
						if(objUserEducationDetailsBO.getEduTypeName().equals("ssc"))
						{
							jsonTrainee.addProperty("sscEduTypeId",objUserEducationDetailsBO.getEduTypeId().toString());
							jsonTrainee.addProperty("sscEduTypeName",objUserEducationDetailsBO.getEduTypeName());
							jsonTrainee.addProperty("sscStreamId",objUserEducationDetailsBO.getStreamId().toString());
							jsonTrainee.addProperty("sscStreamName",objUserEducationDetailsBO.getStreamName());
							jsonTrainee.addProperty("sscSpecializationId",objUserEducationDetailsBO.getSpecializationId().toString());
							jsonTrainee.addProperty("sscSpecializationName",objUserEducationDetailsBO.getSpecializationName());
							jsonTrainee.addProperty("sscPercentage",objUserEducationDetailsBO.getPercentage());
							jsonTrainee.addProperty("sscYop",objUserEducationDetailsBO.getYop());

						}
						else if(objUserEducationDetailsBO.getEduTypeName().equals("hsc") || objUserEducationDetailsBO.getEduTypeName().equals("diploma"))
						{
							jsonTrainee.addProperty("hscEduTypeId",objUserEducationDetailsBO.getEduTypeId().toString());
							jsonTrainee.addProperty("hscEduTypeName",objUserEducationDetailsBO.getEduTypeName());
							jsonTrainee.addProperty("hscStreamId",objUserEducationDetailsBO.getStreamId().toString());
							jsonTrainee.addProperty("hscStreamName",objUserEducationDetailsBO.getStreamName());
							jsonTrainee.addProperty("hscSpecializationId",objUserEducationDetailsBO.getSpecializationId().toString());
							jsonTrainee.addProperty("hscSpecializationName",objUserEducationDetailsBO.getSpecializationName());
							jsonTrainee.addProperty("hscPercentage",objUserEducationDetailsBO.getPercentage());
							jsonTrainee.addProperty("hscYop",objUserEducationDetailsBO.getYop());
						}
						else if(objUserEducationDetailsBO.getEduTypeName().equals("graduation"))
						{
							jsonTrainee.addProperty("gradEduTypeId",objUserEducationDetailsBO.getEduTypeId().toString());
							jsonTrainee.addProperty("gradEduTypeName",objUserEducationDetailsBO.getEduTypeName());
							jsonTrainee.addProperty("gradStreamId",objUserEducationDetailsBO.getStreamId().toString());
							jsonTrainee.addProperty("gradStreamName",objUserEducationDetailsBO.getStreamName());
							jsonTrainee.addProperty("gradSpecializationId",objUserEducationDetailsBO.getSpecializationId().toString());
							jsonTrainee.addProperty("gradSpecializationName",objUserEducationDetailsBO.getSpecializationName());
							jsonTrainee.addProperty("gradPercentage",objUserEducationDetailsBO.getPercentage());
							jsonTrainee.addProperty("gradYop",objUserEducationDetailsBO.getYop());
						}
						else if(objUserEducationDetailsBO.getEduTypeName().equals("postgraduation"))
						{
							jsonTrainee.addProperty("pgEduTypeId",objUserEducationDetailsBO.getEduTypeId().toString());
							jsonTrainee.addProperty("pgEduTypeName",objUserEducationDetailsBO.getEduTypeName());
							jsonTrainee.addProperty("pgStreamId",objUserEducationDetailsBO.getStreamId().toString());
							jsonTrainee.addProperty("pgStreamName",objUserEducationDetailsBO.getStreamName());
							jsonTrainee.addProperty("pgSpecializationId",objUserEducationDetailsBO.getSpecializationId().toString());
							jsonTrainee.addProperty("pgSpecializationName",objUserEducationDetailsBO.getSpecializationName());
							jsonTrainee.addProperty("pgPercentage",objUserEducationDetailsBO.getPercentage());
							jsonTrainee.addProperty("pgYop",objUserEducationDetailsBO.getYop());
						}
						else
						{
							jsonTrainee.addProperty("otherEduTypeId",objUserEducationDetailsBO.getEduTypeId().toString());
							jsonTrainee.addProperty("otherEduTypeName",objUserEducationDetailsBO.getEduTypeName());
							jsonTrainee.addProperty("otherStreamId",objUserEducationDetailsBO.getStreamId().toString());
							jsonTrainee.addProperty("otherStreamName",objUserEducationDetailsBO.getStreamName());
							jsonTrainee.addProperty("otherSpecializationId",objUserEducationDetailsBO.getSpecializationId().toString());
							jsonTrainee.addProperty("otherSpecializationName",objUserEducationDetailsBO.getSpecializationName());
							jsonTrainee.addProperty("otherPercentage",objUserEducationDetailsBO.getPercentage());
							jsonTrainee.addProperty("otherYop",objUserEducationDetailsBO.getYop());
						}
					}
					
					write.print(jsonTrainee);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
