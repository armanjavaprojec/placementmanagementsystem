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
import com.nacre.pms.vo.PlacedResultVO;

@WebServlet("/ViewPlacedController")
public class ViewPlacedController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HrDelegate delegate = null;
		int batchId=0,techId=0;
		batchId = Integer.parseInt(request.getParameter("bid"));
		techId = Integer.parseInt(request.getParameter("tid"));
		List<PlacedResultVO> placedResultVOList = null;
		
		delegate = new HrDelegate();

		try {
			placedResultVOList = delegate.viewPlaced(batchId,techId);
			
			request.setAttribute("placedList", placedResultVOList);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/hr/view_placed.jsp");
			rd.forward(request, response);
		} catch (SQLException | DatabaseException | javax.mail.internet.ParseException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
