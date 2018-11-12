package com.nacre.pms.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.security.auth.login.FailedLoginException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.test.EmailUtil;

/**
 * Servlet implementation class SendInterviewRoundController
 */
@WebServlet("/SendInterviewRoundController")
public class SendInterviewRoundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendInterviewRoundController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HrDelegate hd= new HrDelegate();
		try {
			List<UserDTO> emails=hd.getSelectedTrainees();
			System.out.println("list -------data"+emails+"sizee--------***"+emails.size());
			String mails[]=new String[emails.size()];
			int i=0;
		      
		      /*String jpid= (String) request.getSession().getAttribute("jobpostid");
		      int pid=Integer.parseInt(jpid);
		      */
			
			ServletContext context=getServletContext();
			
			int jobid=Integer.parseInt(context.getAttribute("jobid").toString());
		      
		      
	         InterviewRoundDTO interview=hd.getinterviewRounds(jobid);
			System.out.println("InterviewRoundDTO details----"+interview);
			for(UserDTO udto:emails)
			{
				String email=null;
				email=udto.getEmail();
				System.out.println("email id are---"+email);
					mails[i++]=email;
			}
			
			//InterviewRoundDTO interview = new InterviewRoundDTO();
			String clientname=interview.getJobPost().getClientaddress().getClient().getClientName();
			int round=interview.getRoundNo();
			String date=interview.getDate().toString();
			String rdesc=interview.getDescription();
			
			
			String message = "<i>Greetings!</i><br>";
	        message += "<font color='red'><b>Interview Round Details Are : </font></b><br>";
	        message += "<table><tr><td>Company name : </td><td><font color='red'></font>"+clientname+"</td></tr>";
	        message += "<tr><td>Round No:</td><td>"+round+"</td></tr>";
	        message += "<tr><td>Interview Round Date:</td><td>"+date+"</td></tr>";
	        message += "<tr><td>Round Description:</td><td>"+rdesc+"</td></tr></table>";
	       message+="<br>";
	        
	        message+="<font color='red'>Note : IF YOU WANT MORE DETAILS CONTACT NACRE.</font></b>";
	        	 
			
			
			
			
			
			boolean mail=false;
			for (String no_of_mailid : mails) {
				
				mail=EmailUtil.sendMail(no_of_mailid, "InterviewRound information",message);
			}
			
			
			
			
			
			String msg="Mail sent successsfully ";
	    	if(mail==true)
	    	{
	    		System.out.println("mail is sending---");
	    		request.setAttribute("sm", msg);
	    		request.getRequestDispatcher("/jsp/hr/success1.jsp").forward(request, response);
	    	}
	    
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
