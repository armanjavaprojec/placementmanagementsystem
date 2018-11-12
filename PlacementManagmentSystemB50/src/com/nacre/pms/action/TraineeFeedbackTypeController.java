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
import com.nacre.pms.servicei.serviceimpl.TraineeServiceIMPL;


@WebServlet("/getFeedbackTypeController")
public class TraineeFeedbackTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		System.out.println("Feedback Type");
		PrintWriter pw=response.getWriter();
		Map<Integer, String> map=null;
	  
       TraineeServiceIMPL tsimpl=new TraineeServiceIMPL();
             map=tsimpl.getfeedbacktype();
		
		System.out.println("map===="+map);
		Gson gson=new Gson();
	
		String gsonData=gson.toJson(map);
		System.out.println("----"+gsonData);
		pw.println(gsonData);

	}
	
}
