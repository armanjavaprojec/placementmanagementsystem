package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ClientAddressVo;

/**
 * Servlet implementation class RegisterClientAddressController
 */
@WebServlet("/add_client_addrs_details")
public class RegisterClientAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterClientAddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientAddressVo vo = null;
		response.setContentType("text/html");
		vo = new ClientAddressVo();	
		System.out.println(request.getSession().getAttribute("cid")+"ID");
		int cid=Integer.parseInt( request.getParameter("cid"));
		vo.setContactPresonName(request.getParameter("personName"));
		vo.setContactPresonMobileNO(request.getParameter("personMobile"));
		vo.setContactPresonNameEmail(request.getParameter("personEmail"));
		vo.setPincode(request.getParameter("pincode"));
		vo.setLocation(request.getParameter("location"));
		vo.setCountry(request.getParameter("country"));
		vo.setState(request.getParameter("state"));
		vo.setCity(request.getParameter("city"));
		AdminDelegate aDelegate = new AdminDelegate();
		String res = null;
		try {
			res = aDelegate.registerClientAddrsDetails(vo,cid);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", res);
		request.getRequestDispatcher("view_client_addrs_details?clientId="+cid).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
