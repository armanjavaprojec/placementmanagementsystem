package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.nacre.pms.vo.LocationVO;

@WebServlet("/GetAllClients")
public class GetAllClients extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String option = req.getParameter("option");

		if (option.equals("getAllClients")) {
			res.setContentType("application/json");
			Map<Integer,String> map = new HashMap<>();
			HrDelegate delegate = new HrDelegate();
			try {
				map = delegate.getAllClients();	
			} catch (DatabaseException | SQLException e) {
				e.printStackTrace();
			}
			Gson g = new Gson();
			String data = g.toJson(map);
			System.out.println(data);
			PrintWriter pw = res.getWriter();
			pw.write(data);
		}
		
		if(option.equals("getClientLocations")) {
			res.setContentType("application/json");
			int clientId = Integer.parseInt(req.getParameter("clientId"));
			System.out.println(clientId);
			List<LocationVO> list = new ArrayList<>();
			HrDelegate delegate = new HrDelegate();
			try {
				list = delegate.getClientLocations(clientId);
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					LocationVO lvo = (LocationVO) itr.next();
					System.out.println(lvo.toString());
				}
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
