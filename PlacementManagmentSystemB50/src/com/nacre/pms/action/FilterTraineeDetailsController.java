package com.nacre.pms.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.FilterTraieesDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;

/**
 * Servlet implementation class FilterTraineeDetailsController
 */
@WebServlet("/FilterTraineeDetailsController")
public class FilterTraineeDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sscPercentage = req.getParameter("sscpercentage");
		String sscYop[] = req.getParameterValues("sscyop");
		String hscPercentage = req.getParameter("hscpercentage");
		String hscyop[] = req.getParameterValues("hscyop");
		String gradPercentge = req.getParameter("graduationpercentage");
	String gradYop[] =req.getParameterValues("yop");
	


		String gradSpecialization[] = req.getParameterValues("graduationspecialization");
		String gradStream[] = req.getParameterValues("graduationstream");
		String postPercentage = req.getParameter("postgraduationpercentage");
		String postYopassing[] = req.getParameterValues("postyop");
		String postSpecialization[] = req.getParameterValues("postgraduationspecialization");
		String postStream[] = req.getParameterValues("postgraduationstream");

		
			float sscper = 0;

			// ssc percentage

			if (sscPercentage != null && sscPercentage != "") {
				sscper = Float.parseFloat(sscPercentage);
				System.out.println("in controller ssc" + sscper);
			} else {
				sscper = 0.0f;
			}
			
			
			//ssc yop
			int sscyopAr[]=null;
			if (sscYop != null) {
				sscyopAr=new int[sscYop.length];
				
				for (int i = 0; i < sscYop.length; i++) {
					if (sscYop[i] != "") {
						sscyopAr[i] = Integer.parseInt(sscYop[i]);
						System.out.println(sscyopAr[i]);
					} else {
						sscyopAr[0] = 0;
					}
				}
			} else {
				sscyopAr=new int[1];
			}
			
			
			
			//hsc percentage
			float hscper = 0;
			if (hscPercentage != null && hscPercentage != "") {
				hscper = Float.parseFloat(hscPercentage);
				System.out.println(hscper);
			} else {
				hscper = 0.0f;
			}

			//hsc yop
			int hscyopAr[] = null;

			if (hscyop != null) {
				hscyopAr = new int[hscyop.length];
				for (int i = 0; i < hscyop.length; i++) {
					if (hscyop[i] != "") {
						hscyopAr[i] = Integer.parseInt(hscyop[i]);
						System.out.println(hscyopAr[i]);
					} else {
						hscyopAr[0] = 0;
					}
				}
			}

			else {
				hscyopAr = new int[1];
				hscyopAr[0] = 0;
			}
            //gradution percentage
			float gradper = 0;
			if (gradPercentge != null && gradPercentge != "") {
				gradper = Float.parseFloat(gradPercentge);
			} else {
				gradper = 0.0f;
			}
			  //gradution yop
			int[] gradyopAr=null;

			if (gradYop != null && gradYop [0]!="") {
				gradyopAr = new int[gradYop.length];
				
				for (int i = 0; i < gradYop.length; i++) {
					
						gradyopAr[i] = Integer.parseInt(gradYop[i]);
						System.out.println("in filter yop---------"+gradyopAr[i]);
				}
			} 
			else {
				 gradyopAr= new int[1];
				 gradyopAr[0]=0;
			}
			
			float postper = 0;
			if (postPercentage != null && postPercentage != "") {
				postper = Float.parseFloat(postPercentage);
			} else {
				postper = 0.0f;
			}

			HttpSession session = req.getSession();
			BatchTechnologyDTO Batchtechid = (BatchTechnologyDTO) session.getAttribute("batchtechid");
			int[] postyopAr=null;
			if (postYopassing != null && postYopassing[0]!= "") {
				postyopAr = new int[postYopassing.length];
				for (int i = 0; i < postYopassing.length; i++) {
						postyopAr[i] = Integer.parseInt(postYopassing[i]);
						System.out.println(postyopAr[i]);
					
				}
			}
			 else {
				 postyopAr=new int[1];
				postyopAr [0]= 0;

			}
			String[] graduationspecial = null;
			if (gradSpecialization != null && gradSpecialization[0]!="") {
				graduationspecial = new String[gradSpecialization.length];
             
				for (int i = 0; i < gradSpecialization.length; i++) {
					graduationspecial[i] = gradSpecialization[i];
					System.out.println(" controller special check--------"+graduationspecial[i]);
				}
			} else {
				graduationspecial = new String[1];
				graduationspecial[0]=" ";
			}

			String[] postgraduationspecial = null;
			if (postSpecialization != null && postSpecialization[0]!="") {
				postgraduationspecial = new String[postSpecialization.length];
         
				for (int i = 0; i < postSpecialization.length; i++) {
					postgraduationspecial[i] = postSpecialization[i];
				}
			} else {
				postgraduationspecial = new String[1];
				postgraduationspecial[0]=" ";
			}

			String[] graduationstream = null;
			if (gradStream != null) {

				graduationstream = new String[gradStream.length];
				for (int i = 0; i < gradStream.length; i++) {
					graduationstream[i] = gradStream[i];
				}
			} else {
				graduationstream = new String[1];
				graduationstream[0]=" ";
			}

			String[] poststream = null;
			if (postStream != null) {
				poststream = new String[postStream.length];
				for (int i = 0; i < postStream.length; i++) {
					poststream[i] = postStream[i];
				}
			} else {
				poststream = new String[1];
				poststream[0]=" ";
				
			}
			FilterTraieesDTO filterdto = new FilterTraieesDTO();
			filterdto.setSscPercentage(sscper);
			filterdto.setSscYop(sscyopAr);
			filterdto.setHscPercentage(hscper);
			filterdto.setHscyop(hscyopAr);
			filterdto.setGradPercentge(gradper);
			filterdto.setGradYop(gradyopAr);
			filterdto.setGradSpecialization(graduationspecial);
			filterdto.setGradStream(graduationstream);
			filterdto.setPostPercentage(postper);
			filterdto.setPostYop(postyopAr);
			filterdto.setPostSpecialization(postgraduationspecial);
			filterdto.setPostStream(poststream);
			HrServiceI hs = new HrServiceIMPL();

			List<EducationDetailsDTO> edDtoList = null;
			edDtoList = new ArrayList<>();
			try {
				edDtoList = hs.filterTrainees(filterdto, Batchtechid);
				System.out.println("------------------------- inside.. control...");
				edDtoList.forEach(System.out::println);
				System.out.println("------------------------- inside.. control... end...");

				session.setAttribute("view", edDtoList);
				// RequestDispatcher rd= req.getRequestDispatcher("jsp/hr/demo.jsp");
				RequestDispatcher rd = req.getRequestDispatcher("jsp/hr/viewtraineebyhr.jsp");
				// System.out.println("controller"+data);
				rd.forward(req, res);

			} catch (DatabaseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
					
		}
	}
