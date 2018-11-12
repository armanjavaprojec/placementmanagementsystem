package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.DateUtil;
@WebServlet("/UpdateBatchController")
public class UpdateBatchController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bid=req.getParameter("id");
		String bname=req.getParameter("edit");
		String sdate=req.getParameter("bsdt");
		String edate=req.getParameter("bedt");
		
		System.out.println("data  is=="+bid+"-----------"+bname+"----------"+sdate+"------------"+edate);
		BatchDTO dto= new BatchDTO();
		dto.setBatch_start_date(DateUtil.stringToSqlDate(sdate, "yyyy-MM-dd"));
		dto.setBatch_end_date(DateUtil.stringToSqlDate(edate, "yyyy-MM-dd"));
		
		dto.setBatchId(Integer.parseInt(bid));
		dto.setBatch(bname);
		
		
		
		HrDelegate hrs= new HrDelegate();
		int recordUdated;
		try {
			recordUdated = hrs.updateBatch(dto);
			PrintWriter out=resp.getWriter();
			Gson gson=new Gson();
			String data=gson.toJson(recordUdated);
			out.write(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
