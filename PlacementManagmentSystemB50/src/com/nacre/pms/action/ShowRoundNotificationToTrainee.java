package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.vo.ShowRoundDataTOTraineeVO;

@WebServlet("/ShowRoundNotificationToTrainee")
public class ShowRoundNotificationToTrainee extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String req= request.getParameter("req");
			HttpSession session=request.getSession();
			int id=(int)session.getAttribute(StringConstants._SESSION_USER_ID);
	        PrintWriter out=response.getWriter();    
	        System.out.println("hello");
	        List<ShowRoundDataTOTraineeVO> list=null;
		TraineeDelegate delegate=new TraineeDelegate();
		try {
		
			list=delegate.getRoundDataToShowTrainee(id);
			
			System.out.println("list--"+list);
			
			  
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
		  if(req!=null) {
    	if(req.equals("multiple")) {
	    	response.setContentType("application/json");

    		System.out.println("multiple");
    		 JSONObject js = new JSONObject();
             org.json.JSONArray data= new JSONArray(list);
        System.out.println(data);
             out.println(data);
    	}
    	
    	if(req.equals("single")) {
	    	response.setContentType("application/json");
    		int one=Integer.parseInt(request.getParameter("a"));
    		List<ShowRoundDataTOTraineeVO> lst=new ArrayList<>();
    		lst.add(list.get(one));
    		JSONObject js = new JSONObject();
            org.json.JSONArray data= new JSONArray(lst);
            System.out.println(data);
            out.println(data);
    			
    	  }
    	TraineeDelegate deligate=new TraineeDelegate();
    	if(req.equals("readed")) {
    		int read=Integer.parseInt(request.getParameter("read"));
    		//int jobpostid=Integer.parseInt(request.getParameter("jobpostid"));
    		StatusDTO sdto=new StatusDTO();
    		JobPostingDTO jdto=new JobPostingDTO();
    		//jdto.setJobPostId(jobpostid);
    		sdto.setStatusId(read);
        	try {
				deligate.setReadRoundNotification(sdto,id);
			} catch (SQLException | DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    	if(req.equals("readedPerticularTrainee")) {
    		System.out.println("hello atul");
	    	response.setContentType("text/html");

			int one=Integer.parseInt(request.getParameter("a"));
    		int read=Integer.parseInt(request.getParameter("read"));
    		int jobpostid=Integer.parseInt(request.getParameter("jobposting"));
    		int roundid=Integer.parseInt(request.getParameter("roundid"));
    		StatusDTO sdto=new StatusDTO();
    		JobPostingDTO jdto=new JobPostingDTO();
    		InterviewRoundDTO irdto=new InterviewRoundDTO();
    		irdto.setRoundNo(roundid);
    		jdto.setJobPostId(jobpostid);
    		sdto.setStatusId(read);
        	try {
				deligate.setReadRoundNotification(sdto,jdto,irdto,id);
	    		List<ShowRoundDataTOTraineeVO> lst=new ArrayList<>();
	    		lst.add(list.get(one));
	    		request.setAttribute("roundData", lst);
	    		request.getRequestDispatcher("jsp/trainee/seeSingleNotificationRelatedToRound.jsp").forward(request, response);
			} catch (SQLException | DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	}
		  
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
