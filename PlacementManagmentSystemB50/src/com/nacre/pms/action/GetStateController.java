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
import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

/**
 * @author Rama
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains get the State details from
 *         the database
 */
@WebServlet("/getStateController")
public class GetStateController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		Map map = null;
		TraineeDelegate traineeDelegate = null;
		traineeDelegate = new TraineeDelegate();
		Gson gson = null;
		String data = null;
		PrintWriter out = null;
		String cid = req.getParameter("countryid");
		System.out.println("countryid===" + cid);
		int countryid = Integer.parseInt(cid);
		System.out.println("countryid===" + countryid);

		map = traineeDelegate.getState(countryid);

		System.out.println("State Details in controller: " + map);
		gson = new Gson();
		data = gson.toJson(map);
		out = res.getWriter();
		System.out.println("hiii  " + data);
		out.write(data);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
