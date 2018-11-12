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
import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

/**
 * @author Rama
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains get the Country details from the database
 */
@WebServlet("/getCountryController")
public class GetCountryController extends HttpServlet{
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
 	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		Map map = null;
		TraineeDelegate traineeDelegate = null;
		traineeDelegate = new TraineeDelegate();
		Gson gson = null;
		PrintWriter out = null;
map = traineeDelegate.getCountry();
		System.out.println("Country Details in controller: " + map);
		gson = new Gson();
		String data = gson.toJson(map);
		System.out.println("CONdata:" + data);
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
