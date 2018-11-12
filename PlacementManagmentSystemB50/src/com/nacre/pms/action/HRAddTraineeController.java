package com.nacre.pms.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.ImageStreamToByteException;
import com.nacre.pms.util.ImageUtil;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.vo.HR_Add_TraineeVO;


/**
 * @author Latha
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This class contains get the trainee details from form page and send to the Delegate
 */
@MultipartConfig
@WebServlet("/hrAddTraineeController")
public class HRAddTraineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/**
		 * get the form details
		 */
		String batch= req.getParameter("batch");
		String tech= req.getParameter("technology");
		
		String fname= req.getParameter("firstname");
		String lname= req.getParameter("lastname");
		String mblno= req.getParameter("mobileno");
		String email= req.getParameter("email");
		String dob= req.getParameter("dob");

		Part part= req.getPart("image");
	String image=null;
	try {
		image = ImageUtil.encodeImage(part.getInputStream());
	} catch (ImageStreamToByteException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		String gender= req.getParameter("gender");
		
		if(gender.equals("female")) {
			gender = "1";
		}
		else {
			gender = "0";
		}
		if(image == null) {
			image = "null";
		}
		
		String addrs= req.getParameter("address");
		String pincode=req.getParameter("pincode");
		int zipcode =Integer.parseInt(pincode);
		String country= req.getParameter("country");
		String state= req.getParameter("state");
		String city= req.getParameter("city");
		
		String syop = req.getParameter("syop");
		String spercentage = req.getParameter("spercentage");
	
		String hyop = req.getParameter("hyop");
		String hpercentage = req.getParameter("hpercentage");
		
		String gstream = req.getParameter("gstream");
		String gspecilization = req.getParameter("gspecilization");
		String gyop = req.getParameter("gyop");
		String gpercentage = req.getParameter("gpercentage");
		
		String pgstream = req.getParameter("pgstream");
		String pgspecilization = req.getParameter("pgspecilization");
		String pgyop = req.getParameter("pgyop");
		String pgpercentage = req.getParameter("pgpercentage");
		
		String result=null;
		
		HR_Add_TraineeVO addtraineevo = new HR_Add_TraineeVO();
		addtraineevo.setBatch_id(batch);
		addtraineevo.setTechnology_id(tech);
		addtraineevo.setFirst_name(fname);
		addtraineevo.setLast_name(lname);
		addtraineevo.setMobileno(mblno);
		addtraineevo.setEmail(email);
		addtraineevo.setD_o_b(dob);
		addtraineevo.setImage(image);
		addtraineevo.setGender(gender);
		addtraineevo.setLocation(addrs);
		addtraineevo.setPincode(pincode);
		addtraineevo.setCity_id(city);
		addtraineevo.setState_id(state);
		addtraineevo.setCountry_id(country);
		addtraineevo.setSsc_id(StringConstants._SSC_ID);
		addtraineevo.setSyop(syop);
		addtraineevo.setSstream_id(StringConstants._SSC_STREAM_ID);
		addtraineevo.setSspecilization(StringConstants._SSC_SPECILIZATION_ID);
		addtraineevo.setSpercentage(spercentage);
		addtraineevo.setHsc_id(StringConstants._HSC_ID);
		addtraineevo.setHyop(hyop);
		addtraineevo.setHpercentage(hpercentage);
		addtraineevo.setHstream_id(StringConstants._HSC_STREAM_ID);
		addtraineevo.setHspecilization(StringConstants._HSC_SPECILIZATION_ID);
		addtraineevo.setGraduation_id(StringConstants._GRAD_ID);
		addtraineevo.setGstream_id(gstream);
		addtraineevo.setGspecilization(gspecilization);
		addtraineevo.setGyop(gyop);
		addtraineevo.setGpercentage(gpercentage);
		
		String check = req.getParameter("pg");
	//	System.out.println("check=="+check);
		
		HrDelegate hrDelegate=null;
		try {
			
			hrDelegate = new HrDelegate();
		
			if(check.equals("postgraduation")) {
				
				addtraineevo.setPgraduation_id(StringConstants._PG_ID);
				addtraineevo.setPgstream_id(pgstream);
				addtraineevo.setPgspecilization(pgspecilization);
				addtraineevo.setPgyop(pgyop);
				addtraineevo.setPgpercentage(pgpercentage);
				
				result = hrDelegate.hrAddTraineePostGraduation(addtraineevo);
				
				if(result.equals("success")) {
					result = "Trainee Added Successfully .. !!!";
				    req.getRequestDispatcher("/jsp/hr/success.jsp?result=" + result).forward(req, res);
				}
			}
			else if(check.equals("no")) {
				
				addtraineevo.setPgraduation_id(StringConstants._PG_ID);
				addtraineevo.setPgstream_id(StringConstants._PG_STREAM_ID);
				addtraineevo.setPgspecilization(StringConstants._PG_SPECILIZATION_ID);
				addtraineevo.setPgyop(StringConstants._PG_YOP);
				addtraineevo.setPgpercentage(StringConstants._PG_PERCETAGE);
				
				result = hrDelegate.hrAddTraineeGraduation(addtraineevo);
				
				if(result.equals("success")) {
					result = "Trainee Added Successfully .. !!!";
					req.getRequestDispatcher("jsp/hr/success.jsp?result=" + result).forward(req, res);
				}
			}
			
		} catch (SQLException | DatabaseException e) {
			e.printStackTrace();
		}
		
	}//doGet( )

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//dopost( )

}
