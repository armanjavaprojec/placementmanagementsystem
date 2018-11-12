package com.nacre.pms.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.daoi.HrDaoI;
import com.nacre.pms.daoi.daoimpl.HrDaoIMPL;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.FeedbackTypeDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.TraineeFeedbackVo;

/**
 * Servlet implementation class ViewFeedBacks
 */
@WebServlet("/ViewFeedBacks")
public class ViewFeedBacks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HrDaoI dao = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewFeedBacks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cnt = 0;
		dao = new HrDaoIMPL();
		List<TraineeFeedbackVo> listVo = new ArrayList<>();
		List<FeedbackDTO> fdto = null;
		Connection con = null;
		try {
			con = DbUtil.getConnection();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fdto = dao.retriveFeedbacks(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* fdto.forEach(dto -> { */
		for (FeedbackDTO dto : fdto) {
			TraineeFeedbackVo vo = new TraineeFeedbackVo();
			vo.setSno(((Integer) (++cnt)).toString());
			vo.setName(dto.getUser().getFirstname());
			vo.setMobno(dto.getUser().getMobileNo());
			vo.setEmail(dto.getUser().getEmail());
			vo.setFeedbackMSG(dto.getFeedbackMSG());
			vo.setDate(dto.getDate().toString());
			vo.setFeedbacktype(dto.getFeedbacktype().getFeedbackType());
			vo.setClientName(dto.getClientaddress().getClient().getClientName());
			vo.setCity(dto.getClientaddress().getAddress().getCity().getCity());
			vo.setLocation(dto.getClientaddress().getAddress().getLocation());
			System.out.println(vo);
			listVo.add(vo);
		}
		request.setAttribute("feedbacklist", listVo);
		request.getRequestDispatcher("/jsp/hr/hr_view_trainees_feedbacks.jsp").forward(request, response);
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
