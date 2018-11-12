package com.nacre.pms.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

/**
 * @author Tanaji
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to develop the HR
 *         Functionalities
 */
@WebServlet("/BatchAction")
public class BatchAction extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// general settings
		response.setContentType("application/Json");
		PrintWriter out = response.getWriter();

	
		/*
		 * map object for holding a batch value as key value pair.
		 */
		Map<BatchDTO, BatchDTO> map = null;
		map = new HashMap<>();


		// use service
		HrDelegate del = null;
		del = new HrDelegate();
		try {
			// calling a service method
			map = del.getBatchs();
			
			// creting a gson obj
			Gson g = new Gson();

			// converting json map data into the string
			String data = g.toJson(map);
			out.write(data);
		} catch (SQLException | ClassNotFoundException | DatabaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}