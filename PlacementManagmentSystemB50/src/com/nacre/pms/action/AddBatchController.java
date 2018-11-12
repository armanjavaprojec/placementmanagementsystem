package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.exception.DatabaseException;

@WebServlet("/AddBatchController")
public class AddBatchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bname = req.getParameter("batch");
		String sdate = req.getParameter("bsdt");
		String edate = req.getParameter("bedt");
		//String sid = req.getParameter("sid");
		 
		System.out.println("data  is==" + bname + "----------" + sdate + "------------" + edate);
		BatchDTO dto = new BatchDTO();
		dto.setBatch(bname);
		Date date1=null;
		try {
			date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
		dto.setBatch_start_date(sqlDate);
		Date date2=null;
		try {
			date2 = new SimpleDateFormat("MM/dd/yyyy").parse(edate);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		 java.sql.Date sqlDate1 = new java.sql.Date(date2.getTime());
		dto.setBatch_end_date(sqlDate1);
		
		StatusDTO statusDTO = new StatusDTO();
		//statusDTO.setStatusId(Integer.valueOf(sid));
		dto.setStatus(statusDTO);
		System.out.println(dto+"  DTOOOOO");
		PrintWriter out=resp.getWriter();
		HrDelegate hrs = new HrDelegate();
		int recordAdded;
		try {
			recordAdded = hrs.addBatch(dto);
			Gson gson=new Gson();
			String data=gson.toJson(recordAdded);
			out.write(data);
			
		} catch (SQLException | DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

}
