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

@WebServlet("/ClientAddressDeleteController")
public class ClientAddressDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientVo vo = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		// vo=new ClientVo();
		String clientAddrsId = request.getParameter("clientAddrsId");
		System.out.println("Delete Client Id" + clientAddrsId);
		  
		AdminServiceI service = new AdminServiceIMPL();
		try {
			out.write(new Gson().toJson(service.deleteClientAddrsService(Integer.parseInt(clientAddrsId))));
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
