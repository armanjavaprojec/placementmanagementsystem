package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class GetTechnologies
 */
@WebServlet("/GetTechnologies")
public class GetTechnologies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTechnologies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		try
		{
			res.setContentType("application/json");
		PrintWriter pw= res.getWriter();
		HrDelegate hd= new HrDelegate();
		List<TechnologyDTO> tech= hd.getTechnologies();
		System.out.println("batch data--"+tech);
		Map techc=techConvert(tech);
	Gson g=new Gson();
	String data=g.toJson(techc);
	out.write(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public  static Map<Integer,String> techConvert(List<TechnologyDTO> bdto) throws DatabaseException, SQLException
	 {
		 Map<Integer,String> techmap= new  HashMap<Integer,String>();
		 for(TechnologyDTO bt:bdto)
		 {
			 techmap.put(bt.getTechnologyId(), bt.getTechnology());
		 }
		 return techmap;
	 }
}
