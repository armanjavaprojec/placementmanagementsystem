package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/GetBatchesControllerurl")
public class GetBatchesController extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{ 
		res.setContentType("application/json");
		PrintWriter out=res.getWriter();
		try
		{
			
		PrintWriter pw= res.getWriter();
		HrDelegate hd = new HrDelegate();
		 List<BatchDTO> cbatch=hd.getBatchByHr();
		
		 Map batch=GetBatchesController.batchConvert(cbatch);
		 System.out.println("batch data--"+cbatch);
	Gson g=new Gson();
	
	String data=g.toJson(batch);
	out.write(data);
	//System.out.println(data);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  static Map<Integer,String> batchConvert(List<BatchDTO> bdto) throws DatabaseException, SQLException
	 {
		 Map<Integer,String> batchmap= new  HashMap<Integer,String>();
		 for(BatchDTO bt:bdto)
		 {
			 batchmap.put(bt.getBatchId(), bt.getBatch());
		 }
		 return batchmap;
	 }
	
}
