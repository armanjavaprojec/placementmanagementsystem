package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.AdminServiceI;
import com.nacre.pms.servicei.serviceimpl.AdminServiceIMPL;
import com.nacre.pms.vo.ClientVo;

@WebServlet("/ClientDeleteController")
public class ClientDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String clientId = request.getParameter("clientId");
		AdminServiceI service = new AdminServiceIMPL();
		try {
			out.write(new Gson().toJson(service.deleteClientService(Integer.parseInt(clientId))));
		} catch (NumberFormatException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
