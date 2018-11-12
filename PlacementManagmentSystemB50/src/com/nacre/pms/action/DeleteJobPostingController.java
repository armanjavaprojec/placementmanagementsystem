package com.nacre.pms.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

@WebServlet("/DeleteJobPostingController")
public class DeleteJobPostingController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String result = null;
		int jobId = 0;
		HrDelegate delegate= null;
		RequestDispatcher rd = null;

		jobId = Integer.parseInt(request.getParameter("jid"));
		delegate = new HrDelegate();
		try {
			result = delegate.deleteJobPostById(jobId);
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}
		if (result != null) {
			rd = request.getRequestDispatcher("/jsp/admin/success.jsp?result=" + result);
			response.getWriter();
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/jsp/admin/failure.jsp?result=" + result);
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
