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
import com.nacre.pms.servicei.serviceimpl.AdminServiceIMPL;

@WebServlet("/LevelCompanyController")
public class LevelCompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<Integer, String> map=null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		try{
			AdminServiceIMPL adminSer=new AdminServiceIMPL();
			map=adminSer.getLevel();
			
			Gson obj = new Gson();
	        String gsonData = obj.toJson(map);

			PrintWriter pw = response.getWriter();
			pw.write(gsonData);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
