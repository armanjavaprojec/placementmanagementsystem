package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ClientAddressVo;

/**
 * Servlet implementation class GetClientAddressToEditController
 */
@WebServlet("/EditClientAddrsDataController")
public class GetClientAddressToEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetClientAddressToEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		AdminDelegate adminDeligate = new AdminDelegate();
		ClientAddressVo vo = null;
		try {
			vo = adminDeligate.showClientAddrs(request.getParameter("clientAddrsId"));
		} catch (NumberFormatException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		out.write(gson.toJson(vo));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
