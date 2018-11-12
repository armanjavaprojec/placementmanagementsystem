package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.AssignVo;

/**
 * Servlet implementation class ViewAssignedBatchAndTechnology
 */
@WebServlet("/ViewAssignedBatchAndTechnology")
public class ViewAssignedBatchAndTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HrDelegate dl = null;
		// general settings
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		// use delegate
		dl = new HrDelegate();
		List<AssignVo> list;
		try {
			list = dl.getAllAssignedTechAndBatches();

			if(list.size()!=0) {
				Gson gson=new Gson();
				String data=gson.toJson(list);
		        out.write(data);   
		   }
			else {
				System.out.println("HII");
			}
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
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
