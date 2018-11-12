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
import com.nacre.pms.vo.JobPostingChangeVO;

@WebServlet("/AddJobPostingController")
public class AddJobPostingController extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		JobPostingChangeVO jobPostingChangeVO = null;
		HrDelegate delegate = null;

		String jobDesc = null;
		String jobExpDateS = null;
		String jobPostDateS = null;
		String noOfVacan = null;
		String clientAddressId = null;
		String result = null;

		jobDesc = req.getParameter("jobDesc");
		jobExpDateS = req.getParameter("jobExpDate");
		jobPostDateS = req.getParameter("jobPostDate");
		noOfVacan = req.getParameter("noOfVacan");
		clientAddressId = req.getParameter("caid");
		System.out.println(jobExpDateS);
		jobPostingChangeVO = new JobPostingChangeVO();
		jobPostingChangeVO.setDescription(jobDesc);
		jobPostingChangeVO.setExpectedDate(jobExpDateS);
		jobPostingChangeVO.setPostDate(jobPostDateS);
		jobPostingChangeVO.setNoOfVacancies(noOfVacan);
		jobPostingChangeVO.setClientAddressId(clientAddressId);
		
		System.out.println(jobPostingChangeVO.toString());

		delegate = new HrDelegate();

		try {
			result = delegate.addJobPosting(jobPostingChangeVO);
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}

		if (result != null) {
			rd = req.getRequestDispatcher("jsp/admin/success4.jsp?result=" + result);
			rd.forward(req, res);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
