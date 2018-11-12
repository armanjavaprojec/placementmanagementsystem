package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;
import com.nacre.pms.test.EmailUtil;

/**
 * Servlet implementation class SendMailToEligibleTrainees
 */
@WebServlet("/SendMailToEligibleTrainees")
public class SendMailToEligibleTrainees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailToEligibleTrainees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc=request.getServletContext();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
            
        System.out.println("send mail controller job post id----*******---"+request.getSession().getAttribute("jobpostid"));
        
      String jpid= (String) request.getSession().getAttribute("jobpostid");
      int pid=Integer.parseInt(jpid);
      
        Properties p=new Properties();
        InputStream is=this.getClass().getResourceAsStream("/gmail.properties");
        p.load(is);
        String from=p.getProperty("emailID");
        String password =p.getProperty("password");
        
        //for inserting eligible student details
        HttpSession emails= request.getSession();
        System.out.println("data-----"+emails.getAttribute("mail"));
        
        HrServiceI hs= new HrServiceIMPL();
        List<EducationDetailsDTO> edu= (List<EducationDetailsDTO>)emails.getAttribute("view");
    	
        System.out.println("edu list sizeee---"+edu.size());
        
        
        
        String[] email=new String[edu.size()];
        int[] uid=new int[edu.size()];
    		int i=0;
    		int j=0;
    	for(EducationDetailsDTO edudetails:edu)
    	{
    	    email[i++]=edudetails.getUserDTO().getEmail();
    	    uid[j++]= edudetails.getUserDTO().getUserid();
    		//	System.out.println("in send mail controller email"+email[i]);
    	
    	}
    	
    
    	
    	
    	HttpSession companysession= request.getSession();
    	List<JobPostingDTO> jobpost=null;
    	HrDelegate hrd= new HrDelegate();
		try {
			jobpost=hrd.getRequirementDetails(pid);
			System.out.println("company details controller----***********-------"+jobpost);
			for (int userid : uid) {
			int res=hrd.insertEligibleTraiees(userid, pid);
			System.out.println("record is updated-------------=========="+res);
			}
		} catch (DatabaseException | SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		String clientname=null;
		
		String clientDesc=null;
		
		String cmpanyleval=null;
		
		String expdate=null;
		
		String jobdesc=null;
		
		int noofvac=0;
		
		String address=null;
		
		String loc=null;
		
		int pincode=0;
		
		String country=null;
		
		String state=null;
		
		String city=null;
		
		
		
		for (JobPostingDTO jobPostingDTO : jobpost) {
			
		clientname=	jobPostingDTO.getClientaddress().getClient().getClientName();
		clientDesc=	jobPostingDTO.getClientaddress().getClient().getClientDescription();
		cmpanyleval=jobPostingDTO.getClientaddress().getClient().getCompanyLevel().getLevel();
		expdate=jobPostingDTO.getExpectedDate().toString();
		jobdesc=jobPostingDTO.getDescription();
		noofvac=jobPostingDTO.getVacancies();
		pincode=jobPostingDTO.getClientaddress().getAddress().getPincode();
		loc=jobPostingDTO.getClientaddress().getAddress().getLocation();
		city=jobPostingDTO.getClientaddress().getAddress().getCity().getCity();
		state=jobPostingDTO.getClientaddress().getAddress().getCity().getState().getState();
	    country=jobPostingDTO.getClientaddress().getAddress().getCity().getState().getCountry().getCountry();
			
			
		}
    	
    	
    	
		 // message contains HTML markups
        String message = "<i>Greetings!</i><br>";
        message += "<font color='red'><b>Company Details Are</b></font>";
        message += "<table><tr><td>Company Name : </td><td><font color='red'>"+clientname+"</font></td></tr>";
        message += "<tr><td>Company Description : </td><td>"+clientDesc+"</td></tr>";
        message += "<tr><td>Company Level : </td><td>"+cmpanyleval+"</td></tr>";
        message += "<tr><td>Comany Drive Date : </td><td>"+expdate+"</td></tr>";
        message += "<tr><td>Job Description : </td><td>"+jobdesc+"</td></tr>";
        message += "<tr><td>vacancies : </td><td>"+noofvac+"</td></tr>";
        message += "<tr><td>Address : </td><td>"+pincode+"</td></tr>";
        message += "<tr><td></td><td>"+loc+"</td></tr>";
        message += "<tr><td></td><td>"+city+"</td></tr>";
        message += "<tr><td></td><td>"+state+"</td></tr>";
        message += "<tr><td></td><td>"+country+"</td></tr>";
        
        message+="<br>";
        	 
        message+="<font color='red'>Note : IF YOU WANT MORE DETAILS CONTACT NACRE.</font></b>";
    	
        boolean mail=false;
    //	System.out.println("out send mail controller email"+email[i]);
    	System.out.println(email.toString());
    	for (String noofmaill : email) {
    		
    		
    		mail=EmailUtil.sendMail(noofmaill, "[NACRE]Company Information",message);
        	
			
		}
    	
    	String msg="Mail sent successsfully ";
    	if(mail==true)
    	{
    		request.setAttribute("sm", msg);
    		request.getRequestDispatcher("/jsp/hr/success1.jsp").forward(request, response);
    	}
    
    	
    	
    	
    	
    	
    	
    	
/*    	//System.out.println("out send mail controller email"+string);
         for(int i=0;i<=mails.length()-1;i++)
        {
        	String trainee1=[0].toString();
        	String trainee2=trainees[1].toString();
        	System.out.println(trainee1+"-------"+trainee2);
        	
        }
        String subject=p.getProperty("subject");
        String message =p.getProperty("jsp/hr/companydetailsnotification.jsp");

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");

        if (from.contains("hotmail")) {
            properties.put("mail.smtp.host", "smtp.live.com");

        } else if (from.contains("gmail")) {
            properties.put("mail.smtp.host", "smtp.gmail.com");

        } else if (from.contains("yahoo")) {
            properties.put("mail.smtp.host", "smtp.mail.yahoo.com");

        } else {
            out.println("<h2 style='color:red;'>Unknown domain name!!</h2><br>"
                    + "<p>Please use 'Yahoo or Gmail or Hotmail'</p>");
        }

        Session messageSession = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(messageSession);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress());
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            requestDispatcher = request.getRequestDispatcher("forgot.jsp");
            requestDispatcher.forward(request, response);
            out.println("<h2 style='color:green;'>Message sent successfully.</h2><br>" + "<p>check your mail.</p>");

        } catch (MessagingException e) {
            //requestDispatcher = request.getRequestDispatcher("jsp/common/forgot.jsp");
            out.println("<h2 style='color:red;'>Fatal Error!!</h2><br>" + "<p>" + e.getMessage() + "</p>");
	
	
	}*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
