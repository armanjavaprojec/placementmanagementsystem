package com.nacre.pms.action;
	
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.AuthenticationDelegate;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/ForgetAction")
public class ForgetAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ForgetAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**@author B.Rakesh kumar 
	  * @params request,response Accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	 * @throws ServletException occurs when problem occurs with servlet  
	  * @throws IOException occurs when dealing with the writing data or reading data. 
	  * */ 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**@author B.Rakesh kumar 
	  * @params request,response Accepts javax.servlet.HttpServletRequest,javax.servlet.HttpServletResponse
	  * @throws ServletException occurs when problem occurs with servlet  
	  * @throws IOException occurs when dealing with the writing data or reading data. 
	  * */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		out.println(email);
		/*
		ForgetBean fbean =new ForgetBean();
		fbean.setEmail(email);*/
				
		AuthenticationDelegate ado=new AuthenticationDelegate();
		
		try {
				try {
					Boolean usd =ado.forgetData(email) ;
					if(usd){
						request.getSession().setAttribute("forgotpassword_msg", "your password has been sent to ur mail");
						//out.println("updated Successfully");
						//response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
						
						response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
					}else{
						
						response.sendRedirect(request.getContextPath() + "/jsp/ErrorMsg.jsp");
					}
					
					
				} catch (DataNotFoundException e) {
					
					e.printStackTrace();
					request.getSession().setAttribute("Forgotpwd-message4","please enter the correct email");
					response.sendRedirect(request.getContextPath()+"/jsp/ForgotPassword.jsp");
			
					
				
				
				}
				
				} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
/*		
		//using mail api code to send the password to the mail through a unique mail
		
		String to=email;
		String from="javalearner25@gmail.com";
		
		
		
		 final String username1 = "javalearner25";//change accordingly
	      final String password1 = "javalearner123";//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username1, password1);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("FORGOT PASSWORD");

	         // Now set the actual message
	        // message.setText("HEY WE ARE HERE TO HELP YOU MR."+username1);
	       //  String username2=username1.toUpperCase();
	         message.setText("HEY WE ARE HERE TO HELP YOU MR."+firstname+"\nYOUR PASSWORD is :"+password);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");
	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
		
		
*/		
				
	}

}
