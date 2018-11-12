package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.daoi.daoimpl.AdminDaoIMPL;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/CityController")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, String> map=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		int state=Integer.parseInt(request.getParameter("stateid"));
		
		AdminDelegate ad=new AdminDelegate();
		Map<Integer, String> map=null;
		try {
			map=ad.getCities(state);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson obj = new Gson();
        String gsonData = obj.toJson(map);

		PrintWriter pw = response.getWriter();
		pw.write(gsonData);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
