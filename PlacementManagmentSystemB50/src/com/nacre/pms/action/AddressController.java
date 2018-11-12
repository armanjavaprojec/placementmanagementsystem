package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class AddressController
 */
@WebServlet("/addresscontroller")
public class AddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressController() {
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
		 
		if(req!=null)
		{
			if(req.equals("country"))
			{
				response.setContentType("application/json");
				//creating object of AdminDelegate class
				AdminDelegate objAdminDelegate=new AdminDelegate();
				
				//calling getCountries() method to get countries into map
				Map<Integer, String> mapCountries = null;
				try {
					mapCountries = objAdminDelegate.getCountries();
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonCountries=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorCountries=mapCountries.entrySet().iterator();
				while(iteratorCountries.hasNext())
				{
					Entry<Integer, String> entry=iteratorCountries.next();
					Integer country_id=entry.getKey();
					String country_name=entry.getValue();
					jsonCountries.addProperty(country_id.toString(), country_name.toString());
				}
				System.out.println(jsonCountries);
				write.println(jsonCountries);
			}
			
			if(req.equals("state"))
			{
				response.setContentType("application/json");
				//getting country key
				String country_key=request.getParameter("key");
				
				//creating object of AdminDelegate class
				AdminDelegate objAdminDelegate=new AdminDelegate();
				
				//calling getStates() method to get states into map
				Map<Integer, String> mapStates = null;
				try {
					mapStates = objAdminDelegate.getStates(Integer.parseInt(country_key));
				} catch (NumberFormatException | DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonStates=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorStates=mapStates.entrySet().iterator();
				while(iteratorStates.hasNext())
				{
					Entry<Integer, String> entry=iteratorStates.next();
					Integer state_id=entry.getKey();
					String state_name=entry.getValue();
					jsonStates.addProperty(state_id.toString(), state_name.toString());
				}
				write.println(jsonStates);
			}
			
			
			if(req.equals("city"))
			{
				response.setContentType("application/json");
				//getting country key
				String state_key=request.getParameter("key");
				
				//creating object of AdminDelegate class
				AdminDelegate objAdminDelegate=new AdminDelegate();
				
				//calling getStates() method to get states into map
				Map<Integer, String> mapCities = null;
				try {
					mapCities = objAdminDelegate.getCities(Integer.parseInt(state_key));
				} catch (NumberFormatException | DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JsonObject jsonCities=new JsonObject();
				Iterator<Entry<Integer, String>> iteratorCities=mapCities.entrySet().iterator();
				while(iteratorCities.hasNext())
				{
					Entry<Integer, String> entry=iteratorCities.next();
					Integer city_id=entry.getKey();
					String city_name=entry.getValue();
					jsonCities.addProperty(city_id.toString(), city_name.toString());
				}
				write.println(jsonCities);
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
