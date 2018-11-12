package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class StreamSpecializationController
 */
@WebServlet("/streamspecializationcontroller")
public class StreamSpecializationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StreamSpecializationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String req=request.getParameter("req");
		PrintWriter write=response.getWriter();
		 System.out.println("stream controller caller");
		 System.out.println(req);
		if(req!=null)
		{
			if(req.equals("stream"))
			{
				System.out.println("Stream loading");
				response.setContentType("application/json");
				String streamId=request.getParameter("id");
				int key=Integer.parseInt(streamId);
				//creating object of AdminDelegate class
				HrDelegate objHrDelegate=new HrDelegate();
				
				//calling getCountries() method to get countries into map
				Map<Integer, String> mapStreams = null;
				try {
					mapStreams = objHrDelegate.getStreams(key);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonStreams=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorStreams=mapStreams.entrySet().iterator();
				while(iteratorStreams.hasNext())
				{
					Entry<Integer, String> entry=iteratorStreams.next();
					Integer stream_id=entry.getKey();
					String stream_name=entry.getValue();
					jsonStreams.addProperty(stream_id.toString(), stream_name.toString());
				}
				write.println(jsonStreams);
			}
			
			if(req.equals("specialization"))
			{
				System.out.println("Specialization loading");
				/*String streamId=request.getParameter("id");
				int key=Integer.parseInt(streamId);*/
				response.setContentType("application/json");
				//creating object of AdminDelegate class
				HrDelegate objHrDelegate=new HrDelegate();
				
				//calling getCountries() method to get countries into map
				Map<Integer, String> mapSpecializations = null;
				try {
					mapSpecializations = objHrDelegate.getSpecializations();
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonSpecializations=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorSpecializations=mapSpecializations.entrySet().iterator();
				while(iteratorSpecializations.hasNext())
				{
					Entry<Integer, String> entry=iteratorSpecializations.next();
					Integer specialization_id=entry.getKey();
					String specialization_name=entry.getValue();
					jsonSpecializations.addProperty(specialization_id.toString(), specialization_name.toString());
				}
				write.println(jsonSpecializations);
			}
			
			if(req.equals("selspecialization"))
			{
				System.out.println("selected Specialization loading");
				String streamId=request.getParameter("id");
				int key=Integer.parseInt(streamId);
				response.setContentType("application/json");
				//creating object of AdminDelegate class
				HrDelegate objHrDelegate=new HrDelegate();
				
				//calling getCountries() method to get countries into map
				Map<Integer, String> mapSpecializations = null;
				try {
					mapSpecializations = objHrDelegate.getSpecializations(key);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonSpecializations=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorSpecializations=mapSpecializations.entrySet().iterator();
				while(iteratorSpecializations.hasNext())
				{
					Entry<Integer, String> entry=iteratorSpecializations.next();
					Integer specialization_id=entry.getKey();
					String specialization_name=entry.getValue();
					jsonSpecializations.addProperty(specialization_id.toString(), specialization_name.toString());
				}
				write.println(jsonSpecializations);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
