package com.nacre.pms.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.TraineeServiceI;
import com.nacre.pms.servicei.serviceimpl.TraineeServiceIMPL;
import com.nacre.pms.util.StringConstants;


@WebServlet("/StatusFeedBackController")
public class StatusFeedBackController extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setContentType("text/html");
		System.out.println("at==");
		String req=request.getParameter("req");
	 TraineeServiceI service=new TraineeServiceIMPL();
	 FeedbackDTO fdto=new FeedbackDTO();
	 StatusDTO sdto=new StatusDTO();
	 JobPostingDTO jdto=new JobPostingDTO();
			 if(req!=null) {
			if(req.equals("status")) {
				System.out.println("hooooo");
				int status=Integer.parseInt(request.getParameter("status_id"));
				System.out.println(status);
				int jobpostid=Integer.parseInt(request.getParameter("jobpostid"));
				System.out.println("Job Post Id "+jobpostid);
				sdto.setStatusId(status);
				jdto.setJobPostId(jobpostid);
				
				try {
					HttpSession session=request.getSession(false);
					int uid=(int)session.getAttribute(StringConstants._SESSION_USER_ID);
					int a=service.setStatus(sdto,jdto,uid);
					System.out.println("result feedback--------"+a);
					if(a==1) {
						request.getRequestDispatcher("jsp/trainee/trainee.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if(req.equals("statusandFeedbk")) {
				
			   int status=Integer.parseInt(request.getParameter("status_id"));
               int jobpostid=Integer.parseInt(request.getParameter("jobpostid"));
			   String feedback=request.getParameter("feedback");
			   System.out.println("status id "+status);
			   System.out.println("job post id "+jobpostid);
			   System.out.println("feedback "+feedback);
			    
                sdto.setStatusId(status);
                jdto.setJobPostId(jobpostid);
                fdto.setFeedbackMSG(feedback);
                try {
                	HttpSession ses=request.getSession();
                	int uid=(int) ses.getAttribute(StringConstants._SESSION_USER_ID);
                	
					int a=service.setStatusFeedback(sdto,jdto,fdto,uid);
					if(a==1) {
					request.getRequestDispatcher("jsp/trainee/trainee.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
			}
		 
	   }
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


}
