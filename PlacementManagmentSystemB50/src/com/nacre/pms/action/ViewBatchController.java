package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
  @WebServlet("/ViewBatchController")
public class ViewBatchController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("application/json");
		PrintWriter out=resp.getWriter();
		List<Object> list=null;
		System.out.println("Hello");

		HrDelegate hrDelegate= new  HrDelegate();
	      try {
			list=hrDelegate.sendData();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      if(list.size()!=0)
		  {
			Gson gson=new Gson();
			String data=gson.toJson(list);
			System.out.println(" data"+data);
	        out.write(data);   
		  }
		else {
			
			System.out.println("Data is not there");
			
		   }
		
		
		
		

		}
			
		
		
			
		
		
		
		

		
		
		

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}


}
