package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.FeedbackTypeDTO;
import com.nacre.pms.dto.UserDTO;

@WebServlet("/getTraineeFeedbackController")
public class TraineeFeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter write = response.getWriter();
		
		String feedback_type=request.getParameter("feed_id");
		FeedbackTypeDTO objFeedbackTypeDTO=new FeedbackTypeDTO();
		objFeedbackTypeDTO.setFeedbackTypeId(Integer.parseInt(feedback_type));
		
		FeedbackDTO objFeedbackDTO=new FeedbackDTO();
		objFeedbackDTO.setFeedbackMSG(request.getParameter("feed_desc"));
		objFeedbackDTO.setFeedbacktype(objFeedbackTypeDTO);
		
		UserDTO objUserDTO=new UserDTO();
		objUserDTO.setUserid(Integer.parseInt(request.getParameter("user_id")));
		objFeedbackDTO.setUser(objUserDTO);
		
		String feedDate = request.getParameter("feed_date");
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			date = objSDF.parse(feedDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlFeedDate = new java.sql.Date(date.getTime());
		objFeedbackDTO.setDate(sqlFeedDate);
		
		if(feedback_type.equals("2"))
		{
			ClientAddressDTO objClientAddressDTO=new ClientAddressDTO();
			objClientAddressDTO.setClientAddressId(Integer.parseInt(request.getParameter("feed_client")));
			objFeedbackDTO.setClientaddress(objClientAddressDTO);
		}

		TraineeDelegate objTraineeDelegate=new TraineeDelegate();
		int res=objTraineeDelegate.addFeedBack(objFeedbackDTO);
		
		if(res>0)
		{
			write.println("Thank You.. Feedback Submitted..");
		}
		else
		{
			write.println("Problem Occurred.. Try Again Later..");
		}
		
		/*
		 * String feedback_type=request.getParameter("feedback_type");
		 * 
		 * Integer feedbackTypeId=Integer.parseInt(feedback_type);
		 * System.out.println(feedbackTypeId);
		 * 
		 * 
		 * String feedback_description=request.getParameter("feedback_description");
		 * System.out.println(feedback_description);
		 * 
		 * 
		 * Date date = new Date(); System.out.println(date+"date");
		 * 
		 * 
		 * 
		 * TraineeDelegate delegate= new TraineeDelegate();
		 * 
		 * try { int
		 * send=delegate.sendfeedback(feedbackTypeId,feedback_description,date);
		 * 
		 * if(send==1){
		 * 
		 * RequestDispatcher
		 * rd=request.getRequestDispatcher("/jsp/trainee/Add_failed.jsp");
		 * rd.forward(request, response);
		 * 
		 * }else{ //response.sendRedirect("../jsp/trainee/TraineeFeedback.jsp");
		 * RequestDispatcher
		 * rd=request.getRequestDispatcher("/jsp/trainee/AddSuccess.jsp");
		 * rd.forward(request, response); } } catch (DatabaseException e) {
		 * e.printStackTrace(); }
		 */
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doGet(req, resp);
	}
}

