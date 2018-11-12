package com.nacre.pms.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ClientAddressVo;
import com.nacre.pms.vo.ClientVo;

/**
 * Servlet implementation class ListClientAddrsController
 */
@WebServlet("/view_client_addrs_details")
public class ListClientAddrsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListClientAddrsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClientAddressVo> list=null;
		AdminDelegate delegate=new AdminDelegate();
		try {
			list=delegate.listClientAddrs(request.getParameter("clientId"));
			request.getSession().setAttribute("clientid", request.getParameter("clientId"));
		} catch (NumberFormatException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("addrs",list);
		request.getRequestDispatcher("jsp/admin/client_addrs_update_delete.jsp").forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}