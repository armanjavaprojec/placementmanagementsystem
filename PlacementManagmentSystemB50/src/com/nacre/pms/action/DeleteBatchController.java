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
import com.google.gson.JsonObject;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
@WebServlet("/DeleteBatchControllerller")
public class DeleteBatchController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		int count;
		System.out.println("CHANDUB  B    ");
		//resp.setContentType("application/json");
		String BId=req.getParameter("id");
		System.out.println("batchId::"+BId);
		int BatchId=Integer.parseInt(BId);
		
		HrDelegate hrs= new HrDelegate();
		
		 try {
			count=hrs.sendId(BatchId);
			 Gson gson=new Gson();
				String data=gson.toJson(count);
		       out.write(data);
		} catch (SQLException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
