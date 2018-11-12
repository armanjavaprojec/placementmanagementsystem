package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.util.NotAllowedSpecialChar;
import com.google.gson.Gson;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.TechnologyVO;

@WebServlet("/AddTechnologyController")
public class AddTechnologyDetails extends HttpServlet{
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
    	PrintWriter out=res.getWriter();
      try {
    	  String tname=req.getParameter("technology");
   	     	boolean status=NotAllowedSpecialChar.checkForCharacter(tname);
    	      if(status==false) {
    	    		TechnologyVO tvo=new TechnologyVO();
      		        tvo.setTechnology(tname);
      		        HrDelegate hrtde = new HrDelegate();
      		        int result = hrtde.insertTech(tvo);
      				Gson gson=new Gson();
      				String data=gson.toJson(result);
      				System.out.println("add-controller DATA "+data);
     	           out.write(data);
    	      
    	          }
     	
      }catch (SQLException e) {
 			e.printStackTrace();
 		} catch (DatabaseException e) {
 			e.printStackTrace();
 		}
     }
 	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// TODO Auto-generated method stub
 		doGet(request, response);
 	}
 }
