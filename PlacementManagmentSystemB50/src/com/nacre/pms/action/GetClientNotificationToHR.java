package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;
import com.nacre.pms.vo.GetClientDataToHRNotificationVO;


@WebServlet("/GetClientNotificationToHR")
public class GetClientNotificationToHR extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //req is used to get request from user
	String req=request.getParameter("req");

 
   PrintWriter out=response.getWriter();
   //Object Creation
   HrServiceIMPL service=new HrServiceIMPL();
   List<Object> list=null;
   List <GetClientDataToHRNotificationVO> lst=null;
   GetClientDataToHRNotificationVO vo=null;
   JobPostingDTO post=null;
	ClientDTO client=null;
	ClientAddressDTO address=null;
	AddressDTO ad=null;
	CityDTO ct=null;
	StateDTO st=null;
	CountryDTO cntry=null;
	try {
		//calling service method
		list=service.getJobPostingRelatedDataToHR();
		//Creating list Object
		lst=new ArrayList<>();
		//iterating List Object 
		Iterator<Object> it=list.iterator();
		if(list!=null) {
			while(it.hasNext()) {
			  vo=new GetClientDataToHRNotificationVO();
			  //getting JobPostingData and setting to GetClientDataToHRNotificationVO class 
			  try {
				post=(JobPostingDTO) it.next();
				vo.setJobPostId(post.getJobPostId());
				vo.setDescription(post.getDescription());
				vo.setExpectedDate(post.getExpectedDate());
				vo.setPostDate(post.getPostDate());
				vo.setVacancies(post.getVacancies());
			  }catch(Exception e) {
				e.printStackTrace();
			  }
			//getting client DTO info
			try {
				client=(ClientDTO) it.next();
				vo.setClientName(client.getClientName());
				vo.setClientImage(client.getClientImage());
                vo.setClientDescription(client.getClientDescription());
			  }catch(Exception e) {
				e.printStackTrace();
			   }
			//getting Client Address info
				try {
					address=(ClientAddressDTO) it.next();
					vo.setClientAddressId(address.getClientAddressId());
					vo.setContactPresonName(address.getContactPresonName());
					vo.setContactPresonMobileNO(address.getContactPresonMobileNO());
					vo.setContactPresonNameEmail(address.getContactPresonNameEmail());
				}catch(Exception e) {
					e.printStackTrace();
				}
				//getting Location
				try {
					ad=(AddressDTO) it.next();
					vo.setLocation(ad.getLocation());
				}catch(Exception e) {
					e.printStackTrace();
				}
				//getting City
               try {
					ct=(CityDTO) it.next();
					vo.setCity(ct.getCity());
				}catch(Exception e) {
					e.printStackTrace();
				}
               //getting State
               try {
					st=(StateDTO) it.next();
					vo.setState(st.getState());
				}catch(Exception e) {
					e.printStackTrace();
				}
               //getting Country
               try {
					cntry=(CountryDTO) it.next();
					vo.setCountryid(cntry.getCountryId());
					vo.setCountry(cntry.getCountry());
				}catch(Exception e) {
					e.printStackTrace();
				}
				lst.add(vo);
			}
		}
	} catch (SQLException | DatabaseException e) {
		e.printStackTrace();
	}
  //checking request	
  if(req!=null)
   {
	  HrDelegate deligate=new HrDelegate();
	  //this if contion for showing all client data into the user page
	 if(req.equals("multiple"))
	 {
		response.setContentType("application/json");
		JSONObject js = new JSONObject();
		org.json.JSONArray data= new JSONArray(lst);
	    out.println(data);
	    
	 }

	 //this if condtion for setting read id into database i.e.notification viewed by HR
		if(req.equals("readed")) {
    		int read=Integer.parseInt(request.getParameter("read"));
    		System.out.println("=======  "+read);
    		StatusDTO sdto=new StatusDTO();
    		sdto.setStatusId(read);
        	try {
				deligate.setReadNotification(sdto);
			} catch (SQLException | DatabaseException e) {
				e.printStackTrace();
			}
        }
		//this if condition for setting perticular read id's that are is viewed by the HR 
    	if(req.equals("readedPerticularTrainee")) {
    		int read=Integer.parseInt(request.getParameter("read"));
    		int jobpostid=Integer.parseInt(request.getParameter("jobposting"));
			 int val=Integer.parseInt(request.getParameter("a"));

    		System.out.println("=====xxxx"+jobpostid);
    		StatusDTO sdto=new StatusDTO();
    		JobPostingDTO jdto=new JobPostingDTO();
    		jdto.setJobPostId(jobpostid);
    		sdto.setStatusId(read);
        	try {
				deligate.setReadNotification(sdto,jdto);
				 List<GetClientDataToHRNotificationVO> l=new ArrayList<>();
				 l.add(lst.get(val));
				 request.setAttribute("perticularClientData", l);
				 request.getRequestDispatcher("/jsp/hr/PerticularClientInfo.jsp").forward(request, response);
				 
			} catch (SQLException | DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
	 
  }
}//close get
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
  }