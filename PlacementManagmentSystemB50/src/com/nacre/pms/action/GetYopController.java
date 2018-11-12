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
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class GetYopController
 */
@WebServlet("/GetYopController")
public class GetYopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetYopController() {
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
		 List<Integer> year=hd.getyop();
		 
		 Map map=new HashMap<>();
		 String yop=null;
		 for (Integer integer : year) {
			 yop= integer.toString();
			 map.put(yop, yop);
			 System.out.println("in view ---------"+yop);
			 
			
		}
		
		 //Map batch=GetBatchesController.batchConvert(cbatch);
		 System.out.println("year of passed out--"+yop);
	Gson g=new Gson();
	
	String data=g.toJson(map);
	out.write(data);
	//System.out.println(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public  static Map<Integer,String> batchConvert(List<BatchDTO> bdto) throws DatabaseException, SQLException
	 {
		 Map<Integer,String> batchmap= new  HashMap<Integer,String>();
		 for(BatchDTO bt:bdto)
		 {
			 batchmap.put(bt.getBatchId(), bt.getBatch());
		 }
		 return batchmap;
	 }
*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
