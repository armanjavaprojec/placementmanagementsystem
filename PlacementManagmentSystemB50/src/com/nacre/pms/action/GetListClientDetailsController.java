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
 * Servlet implementation class GetListClientAddressController
 */
@WebServlet("/GetListClientDetailsController")
public class GetListClientDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListClientDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //read client id
		String clientId=request.getParameter("clientId");
		List<ClientAddressVo> list=null;
		AdminDelegate delegate=new AdminDelegate();
		try {
			list=delegate.listClientAddrs(clientId);
		} catch (NumberFormatException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(list.size()+"size.....");
		request.setAttribute("clientData",list);
		request.getRequestDispatcher("jsp/admin/client_update_delete.jsp").include(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
