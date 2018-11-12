package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ClientVo;

@WebServlet("/ViewClientDetails")
public class ViewClientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClientVo> list=null;
		AdminDelegate delegate=new AdminDelegate();
		try {
			list=delegate.viewClientDetail();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clientData",list);
		request.getRequestDispatcher("jsp/admin/client_update_delete.jsp").forward(request, response) ;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
