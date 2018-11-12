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
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.StatusVO;
import com.nacre.pms.vo.TechnologyVO;

@WebServlet("/EditTechnologyController")
public class EditTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("application/json");
		try {
		  List<TechnologyDTO> listedit=new ArrayList<TechnologyDTO>();
		  int tid=Integer.parseInt(request.getParameter("id"));
	      HrDelegate delegate=new HrDelegate();
	      listedit=delegate.editTechnology(tid);
	    	Gson  gson=new Gson();
	    	 String data=gson.toJson(listedit);
	    	 PrintWriter write=response.getWriter();
	    	 write.print(data);
		} catch (DatabaseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
