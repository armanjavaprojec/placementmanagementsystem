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
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;
import com.nacre.pms.vo.JobPostingChangeVO;

@WebServlet("/UpdateJobPostingController")
public class UpdateJobPostingController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		JobPostingChangeVO jobPostingChangeVO = null;
		HrDelegate delegate = null;
		
		String jobPostId = null;
		String jobDesc = null;
		String jobExpDateS = null;
		String jobPostDateS = null;
		String noOfVacan = null;
		String result = null;

		jobPostId = req.getParameter("jobPostId");
		jobDesc = req.getParameter("jobDesc1");
		jobExpDateS = req.getParameter("jobExpDate1");
		jobPostDateS = req.getParameter("jobPostDate1");
		noOfVacan = req.getParameter("noOfVacan1");

		jobPostingChangeVO = new JobPostingChangeVO();
		jobPostingChangeVO.setJobPostId(jobPostId);
		jobPostingChangeVO.setDescription(jobDesc);
		jobPostingChangeVO.setExpectedDate(jobExpDateS);
		jobPostingChangeVO.setPostDate(jobPostDateS);
		jobPostingChangeVO.setNoOfVacancies(noOfVacan);
		
		System.out.println(jobPostingChangeVO.toString());

		delegate = new HrDelegate();

		try {
			result = delegate.updateJobPostById(jobPostingChangeVO);
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}

		if (result != null) {
			rd = req.getRequestDispatcher("/jsp/admin/success.jsp?result=" + result);
			rd.forward(req, res);
		} else {
			rd = req.getRequestDispatcher("/jsp/admin/failure.jsp?result=" + result);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
