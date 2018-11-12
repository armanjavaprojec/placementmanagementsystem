package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.ImageStreamToByteException;
import com.nacre.pms.util.ImageUtil;
import com.nacre.pms.vo.ClientAddressVo;
import com.nacre.pms.vo.ClientVo;

@WebServlet("/update_client_addrs")
@MultipartConfig(maxFileSize = 16177216)
public class ClientAddrsUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientAddressVo vo = null;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InputStream is = null;
		Part part = null;
		response.setContentType("text/html");
		vo = new ClientAddressVo();
		vo.setClientAddressId(request.getParameter("caid"));
		vo.setContactPresonName(request.getParameter("personName"));
		vo.setContactPresonMobileNO(request.getParameter("personMobile"));
		vo.setContactPresonNameEmail(request.getParameter("personEmail"));
		vo.setPincode(request.getParameter("pincode"));
		vo.setLocation(request.getParameter("location"));
		vo.setCountry(request.getParameter("country"));
		vo.setState(request.getParameter("state"));
		vo.setCity(request.getParameter("city"));
		AdminDelegate aDelegate = new AdminDelegate();
		System.out.println(vo);
		String res = null;
		try {
			res = aDelegate.updateClientAddrsDetail(vo);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("result", res);
		request.getRequestDispatcher("view_client_addrs_details").include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
