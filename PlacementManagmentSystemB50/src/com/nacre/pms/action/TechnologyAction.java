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
import com.itextpdf.text.log.SysoCounter;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Tanaji
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the HR
 *         Functionalities
 */
@WebServlet("/TechnologyAction")
public class TechnologyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TechnologyAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// general settings
		response.setContentType("application/Json");
		PrintWriter out = response.getWriter();

		
		//read form data
		int bid=Integer.parseInt(request.getParameter("batch_id"));
		
		System.out.println("Batch_id"+bid);
		/*
		 * map object for holding a technology value as key value pair.
		 */
		Map<TechnologyDTO, TechnologyDTO> map = null;

		// creating a obj of hashmap
		map = new HashMap<>();

				
		// use service
		HrDelegate del = null;
		del = new HrDelegate();
		try {

			// calling a delegate class method
			map = del.getTech(bid);
        System.out.println("technology details"+map);
        if(map.size()!=0) {
			// creating gson obj
			Gson g = new Gson();

			// converting gson values into string format
			String data = g.toJson(map);

			out.write(data);
        }
        else {
        	System.out.println("HIII");
        }

		} catch (SQLException |  DatabaseException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}