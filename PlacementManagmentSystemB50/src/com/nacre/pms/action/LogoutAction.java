package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.util.StringConstants;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/LogoutAction")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
          
         HttpSession session=request.getSession(false);  
          session.invalidate();  
   /*       Cookie uId = new Cookie(StringConstants._SESSION_USER_ID,  "");
			Cookie roleId = new Cookie(StringConstants._SESSION_USER_ROLE_ID, "");
			Cookie cUserEmail = new Cookie(StringConstants._SESSION_EMAIL, "");
			Cookie cUserName = new Cookie(StringConstants._SESSION_USER_NAME, "");
				String remember = request.getParameter("remember");
				System.out.println("remember : " + remember);
				cUserName.setMaxAge(0);// 15 days

				cUserEmail.setMaxAge(0);// 15 days
				roleId.setMaxAge(0);
				uId.setMaxAge(0);
			response.addCookie(roleId);
			response.addCookie(cUserName);
			response.addCookie(uId);
			response.addCookie(cUserEmail);

*/			
          
          response.sendRedirect(request.getContextPath()+"/jsp/Login.jsp"); 
		
	}

}
