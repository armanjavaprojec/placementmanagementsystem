package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Sagar
 * @version 1.0.0 2018 this controller is used to forward controller to perform
 *          operation of adding round information
 */
@WebServlet("/addroundcontroller")
public class AddRoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRoundController() {
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

		// set response type
		response.setContentType("text/html");

		// create PrintWriter object
		PrintWriter write = response.getWriter();

		String actionData=request.getAttribute("actions").toString();
		// create InterviewRoundDTO to add round information
		InterviewRoundDTO objInterviewRoundDTO = new InterviewRoundDTO();

		/*
		 * we should set JobPostId forwarded by previous page
		 * objInterviewRoundDTO.setJobPostId(Integer.parseInt(request.getParameter(
		 * "job_post_id"))); tempararoy adding dummy data for JobPostingID
		 */
		String jobPost= request.getAttribute("jobPost").toString();
		int jobId=Integer.parseInt(jobPost);
		
		JobPostingDTO objJobPostingDTO = new JobPostingDTO();
		objJobPostingDTO.setJobPostId(jobId);

		// setting JobPostingDTO to InterviewRoundDTO object
		objInterviewRoundDTO.setJobPost(objJobPostingDTO);

		// setting round No to InterviewRoundDTO object
		objInterviewRoundDTO.setRoundNo(Integer.parseInt(request.getParameter("round_no")));

		// setting Job Description to InterviewRoundDTO object
		objInterviewRoundDTO.setDescription(request.getParameter("round_description"));

		// setting round date to InterviewRoundDTO object
		String roundDate = request.getParameter("round_date");
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = objSDF.parse(roundDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlRoundDate = new java.sql.Date(date.getTime());
		objInterviewRoundDTO.setDate(sqlRoundDate);

		// setting address to InterviewRoundDTO object
		AddressDTO objAddressDTO = new AddressDTO();
		CityDTO objCityDTO = new CityDTO();
		objAddressDTO.setLocation(request.getParameter("round_address"));
		objCityDTO.setCityId(Integer.parseInt(request.getParameter("round_city")));
		objAddressDTO.setCity(objCityDTO);
		objInterviewRoundDTO.setAddress(objAddressDTO);

		// creating AdminDelegate object
		AdminDelegate objAdminDelegate = new AdminDelegate();

		// calling addRound() method of AdminDelegate and getting result
		int res = 0;
		try {
			res = objAdminDelegate.addRound(objInterviewRoundDTO,actionData);
			ServletContext context=getServletContext();
			context.setAttribute("jobid", res);
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res == 1) {
			// displaying proper message to front end
			//write.print("Successfully Round Added..");
			request.setAttribute("result", "Successfully Round Added..");
		} else {
			// displaying proper message to front end
			//write.print("Some Problem Occurred.. Please Try Again..");
			request.setAttribute("result", "Some Problem Occurred.. Please Try Again..");
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
