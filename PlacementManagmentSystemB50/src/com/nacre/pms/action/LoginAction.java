package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.delegate.AuthenticationDelegate;
import com.nacre.pms.dto.RoleDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.util.URLConstants;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   Cookie[] cookies=request.getCookies();
			
			 if (cookies != null) {
					for (Cookie cookie : cookies) {
		   	   cookie.setMaxAge(0);
			   }
			  										   
		
			 }
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("username");
		System.out.println(email);
		String password = request.getParameter("password");
		/*HttpSession session = request.getSession(true);
		session.setAttribute("firstname", email);
		System.out.println("email-----"+session.getAttribute("firstname"));*/
		LoginBean  lbean = new LoginBean();
		lbean.setEmail(email);
		lbean.setPassword(password);
		AuthenticationDelegate ad = new AuthenticationDelegate();
		try {
			UserDTO rd = ad.login(lbean);

			System.out.println(rd.getPassword());
			RoleDTO role = rd.getRole();
			System.out.println(role);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute(StringConstants._SESSION_USER_ID, rd.getUserid());
			httpSession.setAttribute(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId());
			httpSession.setAttribute(StringConstants._SESSION_EMAIL, rd.getEmail());
			httpSession.setAttribute(StringConstants._SESSION_USER_NAME, rd.getFirstname());
			httpSession.setAttribute(StringConstants._SESSION_USER_IMG, rd.getImage());
			httpSession.setAttribute("firstname", email);
			
			Cookie psw=new Cookie("password",password);
			Cookie uId = new Cookie(StringConstants._SESSION_USER_ID, rd.getUserid() + "");
			Cookie roleId = new Cookie(StringConstants._SESSION_USER_ROLE_ID, role.getRoleId() + "");
			Cookie cUserEmail = new Cookie(StringConstants._SESSION_EMAIL, email);
			Cookie cUserName = new Cookie(StringConstants._SESSION_USER_NAME, rd.getFirstname()+""+rd.getLastname());
			/*Cookie c = new Cookie("jSessionId", httpSession.getId());
			*/Cookie rem = null;
			System.out.println(email + ":" + password+"--"+rd.getFirstname()+"---"+rd.toString());
			String remember = request.getParameter("remember");
			System.out.println("remember  value"+remember);
			if (request.getParameter("remember")!=null) {
			 
				
				remember = request.getParameter("remember");
				 rem=new Cookie("cookrem",remember);
				System.out.println("remember : " + remember);
				cUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days

				cUserEmail.setMaxAge(60 * 60 * 24 * 15);// 15 days
				roleId.setMaxAge(60 * 60 * 24 * 15);
				uId.setMaxAge(60 * 60 * 24 * 15);
				rem.setMaxAge(60 * 60 * 24 * 15);
				psw.setMaxAge(60*60*24*15);
				response.addCookie(rem);
				response.addCookie(psw);
				response.addCookie(cUserEmail);
				
				
			}
			response.addCookie(roleId);
			response.addCookie(cUserName);
			response.addCookie(uId);
			/*response.addCookie(c);
		*/	
		
			if (role.getRoleId() == StringConstants._ADMIN_ROLE_ID) {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.ADMIN_HOME_PAGE_URL);
			} else if (role.getRoleId() == StringConstants._HR_ROLE_ID) {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.HR_HOME_PAGE_URL);
			} else if (role.getRoleId() == StringConstants._TRAINEE_ROLE_ID) {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.TRAINEE_HOME_PAGE_URL);
			} else {
				response.sendRedirect(request.getContextPath() + "/" + URLConstants.LOGIN_PAGE_URL);
			}

		} catch (DatabaseException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/errpage");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/errPage");
		} catch (InvalidException e) {
			e.printStackTrace();
			request.getSession().setAttribute("login-msg", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
		}
	}
}
