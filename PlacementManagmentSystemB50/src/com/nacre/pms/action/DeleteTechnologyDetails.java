package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.TechnologyVO;



@WebServlet("/DeleteTechnologyController")
public class DeleteTechnologyDetails extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Servlet implementation class DeleteTechnologyDetails
	 * @throws IOException 
	 */
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		try {
			RequestDispatcher requestDispatcher=null;
			int techid = Integer.parseInt(req.getParameter("id"));
            TechnologyVO tvo = new TechnologyVO();
			HrDelegate hrtde = new HrDelegate();
			int count = hrtde.deleteTech(techid);
				
				Gson gson=new Gson();
				String data=gson.toJson(count);
		       out.write(data);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		

	}
	}



