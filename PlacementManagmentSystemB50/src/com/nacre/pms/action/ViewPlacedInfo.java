package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.TechnologyFilterVO;

@WebServlet("/ActionController")
public class ViewPlacedInfo extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String option = req.getParameter("option");

		if (option.equals("getAllBatch")) {
			res.setContentType("application/json");
			Map<Integer,String> map = new HashMap<>();
			HrDelegate delegate = new HrDelegate();
			try {
				map = delegate.getAllBatch();	
			} catch (DatabaseException | SQLException e) {
				e.printStackTrace();
			}
			Gson g = new Gson();
			String data = g.toJson(map);
			System.out.println(data);
			PrintWriter pw = res.getWriter();
			pw.write(data);
		}
		
		if(option.equals("getTech")) {
			res.setContentType("application/json");
			int batchId = Integer.parseInt(req.getParameter("batchId"));
			System.out.println(batchId);
			List<TechnologyFilterVO> list = new ArrayList<>();
			HrDelegate delegate = new HrDelegate();
			try {
				list = delegate.getTechnology1(batchId);
			} catch (DatabaseException | SQLException e) {
				e.printStackTrace();
			}
			Gson g = new Gson();
			String data = g.toJson(list);
			System.out.println(data);
			PrintWriter pw = res.getWriter();
			pw.write(data);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
