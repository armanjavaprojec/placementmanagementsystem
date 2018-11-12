package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.JobTypeDTO;
import com.nacre.pms.dto.PlacementDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class MaintainRoundController
 */
@WebServlet("/maintainroundcontroller")
public class MaintainRoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaintainRoundController() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		String req = request.getParameter("req");
		if (req != null) {
			if (req.equals("status")) {
				PrintWriter write = response.getWriter();
				response.setContentType("application/json");
				// creating object of AdminDelegate class
				AdminDelegate objAdminDelegate = new AdminDelegate();

				// calling getCountries() method to get countries into map
				Map<Integer, String> mapStatus = null;
				try {
					mapStatus = objAdminDelegate.getAllStatus();
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JsonObject jsonStatus = new JsonObject();
				Iterator<Entry<Integer, String>> iteratorStatus = mapStatus.entrySet().iterator();
				while (iteratorStatus.hasNext()) {
					Entry<Integer, String> entry = iteratorStatus.next();
					Integer status_id = entry.getKey();
					String status_name = entry.getValue();
					jsonStatus.addProperty(status_id.toString(), status_name.toString());
				}
				write.println(jsonStatus);
			}
			if (req.equals("firstround")) {
				String jobPostId = request.getAttribute("jobPostingId").toString();
				String roundId = request.getAttribute("roundId").toString();
				Integer jobPost = Integer.parseInt(jobPostId);
				Integer round = Integer.parseInt(roundId);
				AdminDelegate objAdminDelegate = new AdminDelegate();
				List<UserDTO> objAllTRInfoList = null;
				try {
					objAllTRInfoList = objAdminDelegate.getInterestedTrainees(jobPost, round);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(objAllTRInfoList);
				request.setAttribute("allTRInfo", objAllTRInfoList);
			}
			if (req.equals("nextround")) {
				String jobPostId = request.getAttribute("jobPostingId").toString();
				Integer jobPost = Integer.parseInt(jobPostId);
				AdminDelegate objAdminDelegate = new AdminDelegate();
				List<UserDTO> objAllTRInfoList = null;
				try {
					objAllTRInfoList = objAdminDelegate.getPreviousShortlistedTrainees(jobPost);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(objAllTRInfoList);
				request.setAttribute("allTRInfo", objAllTRInfoList);
			}
			if (req.equals("addround")) {
				// Integer roundType=Integer.parseInt(request.getParameter("round_type"));
				String jobPost=request.getParameter("job_post");
				String actionData = request.getParameter("round_action");
				RequestDispatcher dispatchForAddRound = request.getRequestDispatcher("addroundcontroller");
				request.setAttribute("actions", actionData);
				request.setAttribute("jobPost", jobPost);
				dispatchForAddRound.include(request, response);
				String result = request.getAttribute("result").toString();
				response.setContentType("text/html");
				PrintWriter write = response.getWriter();
				write.println(result);
			}
			if (req.equals("placetrainee")) {
				Integer userId = Integer.parseInt(request.getParameter("user_id"));
				String jobPost = request.getParameter("job_post");
				String selectedDate = request.getParameter("selected_date");
				String joiningDate = request.getParameter("joining_date");
				String jobPackage = request.getParameter("job_pack");
				String jobBond = request.getParameter("job_bond");
				String jobType = request.getParameter("job_type");
				String placeStatus = request.getParameter("place_status");

				JobPostingDTO objJobPostingDTO = new JobPostingDTO();
				objJobPostingDTO.setJobPostId(Integer.parseInt(jobPost));

				PlacementDTO objPlacementDTO = new PlacementDTO();

				SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date selDate = null;
				java.util.Date joinDate = null;
				try {
					selDate = objSDF.parse(selectedDate);
					joinDate = objSDF.parse(joiningDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				java.sql.Date sqlSelctedDate = new java.sql.Date(selDate.getTime());
				java.sql.Date sqlJoiningDate = new java.sql.Date(joinDate.getTime());

				objPlacementDTO.setSelectedDate(sqlSelctedDate);
				objPlacementDTO.setJoiningDate(sqlJoiningDate);

				objPlacementDTO.setPackage(Float.parseFloat(jobPackage));
				objPlacementDTO.setBond(jobBond);

				JobTypeDTO objJobTypeDTO = new JobTypeDTO();
				objJobTypeDTO.setJobTypeId(Integer.parseInt(jobType));

				objPlacementDTO.setJobType(objJobTypeDTO);

				AdminDelegate objAdminDelegate = new AdminDelegate();

				int res = 0;
				try {
					res = objAdminDelegate.placeTrainee(objPlacementDTO, objJobPostingDTO, userId, placeStatus);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.setContentType("text/html");
				PrintWriter write = response.getWriter();
				if (res > 0) {
					write.println("Trainee Placement Information Submitted Successfully..");
				} else {
					write.println("Problem Occurred..");
				}
			}
			if (req.equals("rejecttrainee")) {
				Integer userId = Integer.parseInt(request.getParameter("user_id"));
				String jobPost = request.getParameter("job_post");
				String placeStatus = request.getParameter("place_status");

				AdminDelegate objAdminDelegate = new AdminDelegate();

				int res = 0;
				try {
					res = objAdminDelegate.rejectTrainee(userId, jobPost, placeStatus);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				response.setContentType("text/html");
				PrintWriter write = response.getWriter();
				if (res > 0) {
					write.println("Trainee Placement Information Submitted Successfully..");
				} else {
					write.println("Problem Occurred..");
				}
			}
			
			if(req.equals("jobtype"))
			{
				PrintWriter write = response.getWriter();
				response.setContentType("application/json");
				// creating object of AdminDelegate class
				AdminDelegate objAdminDelegate = new AdminDelegate();

				// calling getCountries() method to get countries into map
				Map<Integer, String> mapJobType = null;
				try {
					mapJobType = objAdminDelegate.getAllJobTypes();
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JsonObject jsonJobType = new JsonObject();
				Iterator<Entry<Integer, String>> iteratorJobType = mapJobType.entrySet().iterator();
				while (iteratorJobType.hasNext()) {
					Entry<Integer, String> entry = iteratorJobType.next();
					Integer jobtype_id = entry.getKey();
					String jobtype_name = entry.getValue();
					jsonJobType.addProperty(jobtype_id.toString(), jobtype_name.toString());
				}
				write.println(jsonJobType);
			}
			if(req.equals("companyinfo"))
			{
				/*PrintWriter write = response.getWriter();
				response.setContentType("text/html");
				// creating object of AdminDelegate class
				AdminDelegate objAdminDelegate = new AdminDelegate();

				// calling getCountries() method to get countries into map
				String compa = objAdminDelegate.getCompanyInfo();

				JsonObject jsonJobType = new JsonObject();
				Iterator<Entry<Integer, String>> iteratorJobType = mapJobType.entrySet().iterator();
				while (iteratorJobType.hasNext()) {
					Entry<Integer, String> entry = iteratorJobType.next();
					Integer jobtype_id = entry.getKey();
					String jobtype_name = entry.getValue();
					jsonJobType.addProperty(jobtype_id.toString(), jobtype_name.toString());
				}
				write.println(jsonJobType);*/
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
