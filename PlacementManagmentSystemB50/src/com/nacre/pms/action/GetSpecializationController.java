package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;

/**
 * Servlet implementation class GetSpecializationController
 */
@WebServlet("/GetSpecializationController")
public class GetSpecializationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSpecializationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		PrintWriter out=res.getWriter();
		try
		{
			
		PrintWriter pw= res.getWriter();
		HrDelegate hd = new HrDelegate();
		 List<String> special=hd.getSpecilization();
		Map map=new HashMap();
		
		
		for (String string : special) {
			map.put(string, string);
		}
		map.put(special, special);
		 //Map specialization=GetSpecializationController.specialConvert(special);
		 System.out.println("special data--"+special);
	Gson g=new Gson();
	
	String data=g.toJson(map);
	out.write(data);
	//System.out.println(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public  static Map<Integer,String> specialConvert(List<SpecializationDTO> spdto) throws DatabaseException, SQLException
	 {
		 Map<Integer,String> spmap= new  HashMap<Integer,String>();
		 for(SpecializationDTO spt:spdto)
		 {
			 spmap.put(spt.getSpecializationId(),spt.getSpecialization());
		 }
		 return spmap;
	 }*/
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
