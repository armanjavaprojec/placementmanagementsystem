package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.servicei.serviceimpl.TraineeServiceIMPL;

@WebServlet("/TraineeFeedbackClientNameController")
public class TraineeFeedbackClientNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int clientid=Integer.parseInt(request.getParameter("feedbackid"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		response.setContentType("application/json");
		
		PrintWriter pw=response.getWriter();
		System.out.println(clientid);		
		Map<Integer, String> map=null;
		TraineeDelegate td=new TraineeDelegate();
		map=td.getClientName(clientid,userId);
		System.out.println("map===="+map);
		Gson gson=new Gson();
		
		String gsonData=gson.toJson(map);
		System.out.println("----"+gsonData);
		pw.println(gsonData);

	}
}
