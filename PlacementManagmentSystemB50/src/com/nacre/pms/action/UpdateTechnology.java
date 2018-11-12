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
import com.itextpdf.text.log.SysoCounter;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/UpdateTechnologyController")
public class UpdateTechnology extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
    	PrintWriter out=res.getWriter();
    	RequestDispatcher rd=null;
    	try {
    		int techid=Integer.parseInt(req.getParameter("id"));
    	    String techname=req.getParameter("edit");
    	    HrDelegate delegate=new HrDelegate();
			int update1=delegate.updateTechnology(techid,techname);
			Gson gson=new Gson();
			String data=gson.toJson(update1);
			out.write(data);
		} catch (DatabaseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
