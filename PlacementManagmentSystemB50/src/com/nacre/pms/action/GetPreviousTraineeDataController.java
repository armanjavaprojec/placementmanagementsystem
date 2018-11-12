package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.vo.TraineeVO;

/**
 * Servlet implementation class GetPreviousTraineeDataController
 */
@WebServlet("/get_trainee_deatails_edit")
public class GetPreviousTraineeDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//res.setContentType("application/json");
		System.out.println("email id controller--"+req.getSession().getAttribute(StringConstants._SESSION_EMAIL));
		String email =req.getSession().getAttribute(StringConstants._SESSION_EMAIL).toString();
		TraineeVO vo = null;
		Gson gson = null;
		TraineeDelegate traineeDelegate = null;
		PrintWriter out = null;
		traineeDelegate = new TraineeDelegate();
		vo = traineeDelegate.getTraineeForEdit(email);
		System.out.println(email+"===================");
		if(vo!=null) {
		req.setAttribute("trainee", vo);
		req.getRequestDispatcher("jsp/trainee/update_trainee_by_email.jsp").forward(req, res);
		}
		/*gson = new Gson();
		String data = gson.toJson(vo);
		out = res.getWriter();
		out.write(data);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
