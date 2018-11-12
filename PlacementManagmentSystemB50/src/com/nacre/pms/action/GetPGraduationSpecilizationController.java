package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;


/**
 * @author Latha
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains get the Post Graduation Specailizations from the database
 */
@WebServlet("/getPGraduationSpecilizationController")
public class GetPGraduationSpecilizationController extends HttpServlet{
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		Map map = null;
		HrDelegate hrdeligate = null; 
		Gson gson = null;
		String data = null;
		PrintWriter out = null;	
		String pgid = req.getParameter("pgstream_id");
		int pgid1 = Integer.parseInt(pgid);
		
		hrdeligate = new HrDelegate();
		try {
			map = hrdeligate.getPGraduationSpecilization(pgid1);
		//	System.out.println("Batch Details in controller: "+map);
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
		}
		gson = new Gson();
		data = gson.toJson(map);
		out = res.getWriter();
		out.write(data);
	
 	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);	
	}
}
