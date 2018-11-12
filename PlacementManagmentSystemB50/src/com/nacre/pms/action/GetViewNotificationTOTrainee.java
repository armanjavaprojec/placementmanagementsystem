package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.vo.TraineeClientVO;
import com.nacre.pms.vo.TraineeVO;
//import com.nacre.pms.vo.GetClientDataToHRNotificationVO;


@WebServlet("/GetViewNotificationTOTrainee")
public class GetViewNotificationTOTrainee extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
   String req= request.getParameter("req");
    
 
    	response.setContentType("application/json");
        PrintWriter out=response.getWriter();    
        System.out.println("hello");
        List <TraineeClientVO> lst=new ArrayList<>();

       TraineeDelegate deligate=new TraineeDelegate();
       HttpSession ses=request.getSession();
      int id= (int) ses.getAttribute(StringConstants._SESSION_USER_ID);
        try {
            List<Object> list=deligate.getClientData(id);

            System.out.println("List  "+list);
 
        

    		JobPostingDTO jdto=null;
    		ClientAddressDTO adto=null;
    		ClientDTO cdto=null;
    		AddressDTO aadto=null;
           CityDTO ct=null;
           UserDTO udto=null; 
           StateDTO stdto=null;
           CountryDTO cntdto=null;
           
           // StateDTO st=null;
            //CountryDTO cntry=null;
    
            TraineeClientVO vo=null;
            Iterator<Object> it=list.iterator();
            if(list!=null) {
                while(it.hasNext()) {
                    vo=new TraineeClientVO();
                  //getting Client Address info
                    try {
                    	
                        adto= (ClientAddressDTO) it.next();
                        vo.setContactPresonName(adto.getContactPresonName());
                        vo.setContactPresonMobileNO(String.valueOf(adto.getContactPresonMobileNO()));
                       vo.setContactPresonNameEmail(adto.getContactPresonNameEmail());
                       //lst.add(vo)); 
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    //getting JobPostingData and setting to GetClientDataToHRNotificationVO class 
                    try {
                    	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
                    	
                        jdto=(JobPostingDTO) it.next();
                       vo.setDescription(jdto.getDescription());
                       vo.setExpectedDate(sdf.format(jdto.getExpectedDate()));
                       //vo.setPostedDate(sdf.format(jdto.getPostDate()));
                       vo.setVacancies(Integer.toString(jdto.getVacancies()));
                        vo.setJobPostId(jdto.getJobPostId());   
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                    //getting client DTO info
                    try {
                        cdto=(ClientDTO) it.next();
                     
                       vo.setClientName(cdto.getClientName());
                       vo.setClientDescription(cdto.getClientDescription());
                       
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                  
                
                
                    
                    //getting Location
                    try {
                        aadto=(AddressDTO) it.next();
                       vo.setLocation(aadto.getLocation());
                       vo.setPincode(aadto.getPincode());
                       
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                   //getting user name
                    try {
                   udto=(UserDTO) it.next();
                   vo.setFirstname(udto.getFirstname());
                   vo.setLastname(udto.getLastname());
                    	
                    }
                    catch(Exception e) {
                    	e.printStackTrace();
                    }
                    try {
                    	ct=(CityDTO) it.next();
                    	vo.setCity(ct.getCity());
                    }
                    catch(Exception e) {
                    	e.printStackTrace();
                    }
                    try {
                    	stdto=(StateDTO) it.next();
                    	vo.setState(stdto.getState());
                    }
                    catch(Exception e) {
                    	e.printStackTrace();
                    }
                    try {
                    	cntdto=(CountryDTO) it.next();
                    	vo.setCountryid(cntdto.getCountryId());
                    	System.out.println("country id "+cntdto.getCountryId());
                    	vo.setCountry(cntdto.getCountry());
                    }
                    catch(Exception e) {
                    	e.printStackTrace();
                    }
                    lst.add(vo);
                    System.out.println("list values:"+lst);
                }
                
               
            }
            
            System.out.println("after service");
            System.out.println(lst);
    
            
                
        } 

    
    catch (SQLException | DatabaseException e) {
            e.printStackTrace();
        }
   
        if(req!=null) {
        	if(req.equals("multiple")) {
            	response.setContentType("application/json");

        		 JSONObject js = new JSONObject();
                 org.json.JSONArray data= new JSONArray(lst);
            System.out.println(data);
                 out.println(data);
         	    System.out.println("My Client Notification "+data);

        
        	}
        
        	if(req.equals("readed")) {
        		int read=Integer.parseInt(request.getParameter("read"));
        		System.out.println("welcome");
        		//int jobpostid=Integer.parseInt(request.getParameter("jobpostid"));
        		StatusDTO sdto=new StatusDTO();
        		JobPostingDTO jdto=new JobPostingDTO();
        		//jdto.setJobPostId(jobpostid);
        		sdto.setStatusId(read);
            	try {
					deligate.setReadNotification(sdto,id);
				} catch (SQLException | DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        	if(req.equals("readedPerticularTrainee")) {
        		int read=Integer.parseInt(request.getParameter("read"));
        		int jobpostid=Integer.parseInt(request.getParameter("jobposting"));
				int one=Integer.parseInt(request.getParameter("a"));
                  System.out.println("=====================");
        		StatusDTO sdto=new StatusDTO();
        		JobPostingDTO jdto=new JobPostingDTO();
        		jdto.setJobPostId(jobpostid);
        		sdto.setStatusId(read);
        		System.out.println("jobpstid "+jobpostid);
        		System.out.println("status "+read);
            	try {
					deligate.setReadNotification(sdto,jdto,id);
	        		List<TraineeClientVO> l=new ArrayList<>();
	        		l.add(lst.get(one));
	        		if(l!=null) {
	        		request.setAttribute("clientdata", l);
	        		request.getRequestDispatcher("/jsp/trainee/see_single_client_info.jsp").forward(request, response);
	        		}
	        		
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

