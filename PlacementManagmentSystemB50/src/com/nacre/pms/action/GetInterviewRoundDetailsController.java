package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class GetInterviewRoundDetailsController
 */
@WebServlet("/GetInterviewRoundDetailsController")
public class GetInterviewRoundDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInterviewRoundDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		HttpSession session= req.getSession();
		
		InterviewRoundDTO interviewdto=null;
		HttpSession jobpostsession= req.getSession();
		
	int	jobpostid=(Integer)jobpostsession.getAttribute("jobpostid");
		
		HrDelegate hr= new HrDelegate();
		
		int interviewid=0;
				try {
					interviewdto=hr.getinterviewRounds(jobpostid);
					
				System.out.println("interviround"+interviewdto);
				} catch (DatabaseException | SQLException e) {
				
					e.printStackTrace();
				}
				jobpostsession.setAttribute("interviewrounds", interviewdto);
				System.out.println("interview details controller"+interviewdto);
				RequestDispatcher rd= req.getRequestDispatcher("jsp/hr/interviewroundsnotification.jsp");
				rd.forward(req, res);
			
			interviewid=interviewdto.getRoundId();
				session.setAttribute("interviewroundid",interviewid );
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
