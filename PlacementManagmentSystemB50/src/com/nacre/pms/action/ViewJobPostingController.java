package com.nacre.pms.action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.JobPostingResultVO;

@WebServlet("/ViewJobPostingController")
public class ViewJobPostingController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HrDelegate delegate = null;
		int clientId=1,addressId=1;
		clientId = Integer.parseInt(request.getParameter("cid"));
		addressId = Integer.parseInt(request.getParameter("aid"));
		List<JobPostingResultVO> jobPostResultVOList = null;
		
		delegate = new HrDelegate();

		try {
			jobPostResultVOList = delegate.viewJobPostings(clientId,addressId);
			
			request.setAttribute("jobList", jobPostResultVOList);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/admin/view_job_posting.jsp");
			rd.forward(request, response);
		} catch (SQLException | DatabaseException | ParseException | javax.mail.internet.ParseException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
