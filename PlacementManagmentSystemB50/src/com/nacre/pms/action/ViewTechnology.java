package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/ViewTechnologyController")
public class ViewTechnology extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HrDelegate delegate=new HrDelegate();
		List<TechnologyDTO> listdto=new ArrayList<TechnologyDTO>();
		PrintWriter out=res.getWriter();
		try {
			listdto=delegate.viewTechnology();
			if(listdto.size()!=0) {
				Gson gson=new Gson();
				String data=gson.toJson(listdto);
		        out.write(data);   
		   }
			else {
				System.out.println("HII");
			}
		}
		 catch (DatabaseException e) {
			e.printStackTrace();
		    }
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
