package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.delegate.AuthenticationDelegate;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.util.URLConstants;

@WebServlet("/ChangePasswordAction")
public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ChangePasswordAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute(StringConstants.SESSION_USERE_MAI);
		out.println(email);
		
		String oldPassword = request.getParameter("oldpwd");
		String newPassword = request.getParameter("newpwd");
		String conPassword = request.getParameter("confirmpwd");

		out.println(oldPassword);
		out.println(newPassword);
		out.println(conPassword);
		ChangeBean cb=new ChangeBean();
		cb.setEmail(email);
		UserDTO udt=new UserDTO();
		
		
		cb.setOldPassword(oldPassword);
		cb.setNewPassword(newPassword);
		cb.setConPassword(conPassword);
		
		
		 AuthenticationDelegate ad=new AuthenticationDelegate();
		 
		 
		 try {
			int effectedRow;
			effectedRow = ad.changeData(cb);
			if(effectedRow==1)
			{
				HttpSession httpSession = request.getSession();
				Object role=httpSession.getAttribute(StringConstants.SESSION_USERE_ROLE);
				System.out.println(role);
				
				if (role == StringConstants._ADMIN_ROLE_ID) {
					request.setAttribute("pwd_msg", StringConstants.PASSWORD_CHANGE);
					
					request.getRequestDispatcher(URLConstants.ADMIN_HOME_PAGE_URL).forward(request, response);;
				} else if (role == StringConstants._HR_ROLE_ID) {
					request.setAttribute("pwd_msg",StringConstants.PASSWORD_CHANGE );
					request.getRequestDispatcher( URLConstants.HR_HOME_PAGE_URL).forward(request, response);;

				} else if (role == StringConstants._TRAINEE_ROLE_ID) {
					request.setAttribute("pwd_msg", StringConstants.PASSWORD_CHANGE);

					request.getRequestDispatcher(URLConstants.TRAINEE_HOME_PAGE_URL).forward(request, response);;

				}
			} 
			else
			{
				request.getSession().setAttribute("changepwd-message3","please enter the correct password");
				response.sendRedirect(request.getContextPath()+"/jsp/ChangePassword.jsp");
			}
		} 
		 catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		
		
	}

}
}
