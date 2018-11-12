package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

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
import com.nacre.pms.vo.ClientVo;

@WebServlet("/update_client")
@MultipartConfig(maxFileSize = 16177216)
public class ClientUpdateContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientVo vo = null;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream is = null;
		Part part = null;
		response.setContentType("text/html");
		vo = new ClientVo();
		part = request.getPart("clientImg");
		if (part != null) {
			is = part.getInputStream();
			try {
				vo.setClientImage(ImageUtil.encodeImage(is));
			} catch (ImageStreamToByteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println((request.getParameter("client_id"))+"-------------------------id");
		vo.setClientId(request.getParameter("cid"));
		vo.setClientName(request.getParameter("clientName"));
		vo.setClientDescription(request.getParameter("description"));
		/*vo.setPersonName(request.getParameter("personName"));
		vo.setPersonMobile(request.getParameter("personMobile"));
		vo.setPersonEmail(request.getParameter("personEmail"));
		vo.setPincode(request.getParameter("pincode"));
		vo.setLocation(request.getParameter("location"));
		vo.setCountry(request.getParameter("country"));
		vo.setState(request.getParameter("state"));
		vo.setCity(request.getParameter("city"));
		*/vo.setLevel(request.getParameter("level"));
		System.out.println(vo + "...........");
		AdminDelegate aDelegate = new AdminDelegate();
		String res = null;
		try {
			res = aDelegate.updateClientDetail(vo);
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("result", res);
		request.getRequestDispatcher("ViewClientDetails").include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}