package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class GetCompanyReqirementDetails
 */
@WebServlet("/GetCompanyReqirementDetails")
public class GetCompanyReqirementDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCompanyReqirementDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		HttpSession companysession= req.getSession();
		
		List<JobPostingDTO> jobpost=null;
		HrDelegate hrd= new HrDelegate();
		
		
			
				/*try {
					jobpost=hrd.getRequirementDetails();
					System.out.println("company details controller-----------"+jobpost);
					
				} catch (DatabaseException | SQLException e) {
				
					e.printStackTrace();
				}
				
				companysession.setAttribute("company", jobpost);	
				RequestDispatcher rd= req.getRequestDispatcher("jsp/hr/companydetailsnotification.jsp");
				rd.forward(req, res);
			
				int jobpostid=0;
				for(JobPostingDTO jpdto:jobpost)
              {
					jobpostid= jpdto.getJobPostId();
					System.out.println("jobpostingid--------"+jobpostid);
	              
              }
				System.out.println("in company controller jobpost id"+jobpostid);
			HttpSession postid=req.getSession();
			postid.setAttribute("jobpostid",jobpostid);*/
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
