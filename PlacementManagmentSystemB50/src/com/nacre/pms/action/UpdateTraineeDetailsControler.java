package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.exception.ImageStreamToByteException;
import com.nacre.pms.util.ImageUtil;
import com.nacre.pms.vo.TraineeVO;

/**
 * Servlet implementation class UpdateTraineeDetailsControler
 */
@WebServlet("/update_trainee")
@MultipartConfig
public class UpdateTraineeDetailsControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTraineeDetailsControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = null;
		out = res.getWriter();
		TraineeVO vo = null;
		InputStream is = null;
		TraineeDelegate traineeDelegate = null;
		Part p = req.getPart("image");
		is = p.getInputStream();
		vo = new TraineeVO();
		vo.setEmail(req.getParameter("email"));
		vo.setFirstName(req.getParameter("firstname"));
		vo.setLastName(req.getParameter("lastname"));
		vo.setMobno(req.getParameter("mobno"));
		try {
			vo.setImage(ImageUtil.encodeImage(is));
		} catch (ImageStreamToByteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setCity(req.getParameter("city"));
		vo.setState(req.getParameter("state"));
		vo.setCountry(req.getParameter("country"));
		vo.setDob(req.getParameter("dob"));
		vo.setLocation(req.getParameter("location"));
		vo.setPincode(req.getParameter("pincode"));
		traineeDelegate = new TraineeDelegate();
		String msg = traineeDelegate.updateTrainee(vo);
		System.out.println(msg);
		 req.setAttribute("result", msg);
			RequestDispatcher rd = req.getRequestDispatcher("/jsp/trainee/trainee.jsp");
			rd.forward(req, res);
		 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}