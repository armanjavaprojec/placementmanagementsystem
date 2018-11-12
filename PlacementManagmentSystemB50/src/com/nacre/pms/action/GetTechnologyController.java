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
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

/**
 * @author Rama
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains get the technology details from the database
 */
@WebServlet("/getTechnologyController")
public class GetTechnologyController extends HttpServlet{
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
 	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		Map map = null;
		HrDelegate hrdeligate = null; 
		String bid=req.getParameter("batch_id");
	//	System.out.println("bid==="+bid);
		int batchid=Integer.parseInt(bid);
	//	System.out.println("batch_id==="+batchid);
		Gson gson = null;
		String data = null;
		PrintWriter out = null;
		 
		hrdeligate = new HrDelegate();
		
	
		try {
			map = hrdeligate.getTechnology(batchid);
		//System.out.println("Technology Details in controller: "+map);
		
			gson = new Gson();
			data = gson.toJson(map);
			out = res.getWriter();
			
			
			//System.out.println("json data---"+data);
			out.write(data);
		
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
		}
	
 	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);	
	}
}
