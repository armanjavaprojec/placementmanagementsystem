package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.util.SystemOutLogger;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.URLConstants;

/**
 * Servlet implementation class AssignBatchAction
 */
@WebServlet("/AssignBatchAction")
public class AssignBatchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Inside asdsf");
		String result = null;
		// general settings
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// reading form values
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println(bid);
		int techid = Integer.parseInt(request.getParameter("tid"));
		System.out.println(techid);

		// useDelegate
		HrDelegate del = null;
		del = new HrDelegate();
		try {
			// calling a delegate method
			result = del.insertBatchtech(bid, techid);
			System.out.println("AssignBatchResult"+result);
			HttpSession session=request.getSession();
			session.setAttribute("result", result);
			RequestDispatcher rd=request.getRequestDispatcher("/"+URLConstants._ASSIGN_BATCH_TECH);
			rd.forward(request, response);
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}