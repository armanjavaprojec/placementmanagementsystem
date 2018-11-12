package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.exception.DatabaseException;
  @WebServlet("/EditBatchController")
  public class EditBatchController  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<BatchDTO> list=new ArrayList<BatchDTO>();
		resp.setContentType("application/json");
		String sid=req.getParameter("id");
		int bid=Integer.parseInt(sid);
		
		System.out.println(bid+"   bid");
		
		BatchDTO dto= new BatchDTO();
		 
		HrDelegate hrdelegateI = new HrDelegate();
		List l = null;
		try {
			l = hrdelegateI.getBatchData(bid);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		PrintWriter out=resp.getWriter();
		Gson gson=new Gson();
		String data=gson.toJson(l);
		System.out.println(" data"+data);
        out.write(data);  
		
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}


}

