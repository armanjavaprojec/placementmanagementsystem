package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ClientVo;

/**
 * Servlet implementation class GetClientDataToEditController
 */
@WebServlet("/EditClientDataController")
public class GetClientDataToEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		 
		String clienId = request.getParameter("clientId");
		 
		AdminDelegate adminDeligate = new AdminDelegate();
		ClientVo vo = null;
		try {
			vo = adminDeligate.showClientData(Integer.parseInt(clienId));
		} catch (NumberFormatException | DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		out.write(gson.toJson(vo));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
