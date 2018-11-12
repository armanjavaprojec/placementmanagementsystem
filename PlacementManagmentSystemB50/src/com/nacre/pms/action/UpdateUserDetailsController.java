package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.EducationTypeDTO;
import com.nacre.pms.dto.SpecializationDTO;
import com.nacre.pms.dto.UserDTO;

/**
 * Servlet implementation class UpdateUserDetailsController
 */
@WebServlet("/updateuserdetailscontroller")
public class UpdateUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String user_id=request.getParameter("user_id");
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String mobile=request.getParameter("mobile_no");
		String ssc_percentage=request.getParameter("ssc_percentage");
		String inter_percentage=request.getParameter("inter_percentage");
		String grad_percentage=request.getParameter("grad_percentage");
		String pg_percentage=request.getParameter("pg_percentage");
		String ssc_yop=request.getParameter("ssc_yop");
		String inter_yop=request.getParameter("inter_yop");
		String grad_yop=request.getParameter("grad_yop");
		String pg_yop=request.getParameter("pg_yop");
		String ssc_stream=request.getParameter("ssc_stream");
		String inter_stream=request.getParameter("inter_stream");
		String grad_stream=request.getParameter("grad_stream");
		String pg_stream=request.getParameter("pg_stream");
		String ssc_specialization=request.getParameter("ssc_specialization");
		String inter_specialization=request.getParameter("inter_specialization");
		String grad_specialization=request.getParameter("grad_specialization");
		String pg_specialization=request.getParameter("pg_specialization");
		
		String sscYearArray[]=ssc_yop.split("-");
		String sscYear=sscYearArray[0];
		
		String interYearArray[]=inter_yop.split("-");
		String interYear=interYearArray[0];
		
		String gradYearArray[]=grad_yop.split("-");
		String gradYear=gradYearArray[0];
		
		String pgYearArray[]=pg_yop.split("-");
		String pgYear=pgYearArray[0];
		
		List<EducationDetailsDTO> listEducation=new ArrayList<>();
		
		UserDTO objUserDTO=new UserDTO();
		objUserDTO.setUserid(Integer.parseInt(user_id));
		objUserDTO.setFirstname(first_name);
		objUserDTO.setLastname(last_name);
		objUserDTO.setMobileNo(mobile);
		
		EducationDetailsDTO objSSCEducationDetailsDTO=new EducationDetailsDTO();
		objSSCEducationDetailsDTO.setUser(objUserDTO);
		objSSCEducationDetailsDTO.setYearOfPass(sscYear);
		objSSCEducationDetailsDTO.setPercentGrade(ssc_percentage);
		SpecializationDTO objSSCSpecializationDTO=new SpecializationDTO();
		objSSCSpecializationDTO.setSpecializationId(Integer.parseInt(ssc_specialization));
		objSSCEducationDetailsDTO.setObjSpecializationDTO(objSSCSpecializationDTO);
		EducationTypeDTO objSSCEducationTypeDTO=new EducationTypeDTO();
		objSSCEducationTypeDTO.setGraduDetailsId(1);
		objSSCEducationDetailsDTO.setEducationType(objSSCEducationTypeDTO);
		
		listEducation.add(objSSCEducationDetailsDTO);
		
		EducationDetailsDTO objInterEducationDetailsDTO=new EducationDetailsDTO();
		objInterEducationDetailsDTO.setUser(objUserDTO);
		objInterEducationDetailsDTO.setYearOfPass(interYear);
		objInterEducationDetailsDTO.setPercentGrade(inter_percentage);
		SpecializationDTO objInterSpecializationDTO=new SpecializationDTO();
		objInterSpecializationDTO.setSpecializationId(Integer.parseInt(inter_specialization));
		objInterEducationDetailsDTO.setObjSpecializationDTO(objInterSpecializationDTO);
		EducationTypeDTO objInterEducationTypeDTO=new EducationTypeDTO();
		objInterEducationTypeDTO.setGraduDetailsId(2);
		objInterEducationDetailsDTO.setEducationType(objInterEducationTypeDTO);
		
		listEducation.add(objInterEducationDetailsDTO);
		
		EducationDetailsDTO objGradEducationDetailsDTO=new EducationDetailsDTO();
		objGradEducationDetailsDTO.setUser(objUserDTO);
		objGradEducationDetailsDTO.setYearOfPass(gradYear);
		objGradEducationDetailsDTO.setPercentGrade(grad_percentage);
		SpecializationDTO objGradSpecializationDTO=new SpecializationDTO();
		objGradSpecializationDTO.setSpecializationId(Integer.parseInt(grad_specialization));
		objGradEducationDetailsDTO.setObjSpecializationDTO(objGradSpecializationDTO);
		EducationTypeDTO objGradEducationTypeDTO=new EducationTypeDTO();
		objGradEducationTypeDTO.setGraduDetailsId(3);
		objGradEducationDetailsDTO.setEducationType(objGradEducationTypeDTO);
		
		listEducation.add(objGradEducationDetailsDTO);
		
		EducationDetailsDTO objPGEducationDetailsDTO=new EducationDetailsDTO();
		objPGEducationDetailsDTO.setUser(objUserDTO);
		objPGEducationDetailsDTO.setYearOfPass(pgYear);
		objPGEducationDetailsDTO.setPercentGrade(pg_percentage);
		SpecializationDTO objPGSpecializationDTO=new SpecializationDTO();
		objPGSpecializationDTO.setSpecializationId(Integer.parseInt(pg_specialization));
		objPGEducationDetailsDTO.setObjSpecializationDTO(objPGSpecializationDTO);
		EducationTypeDTO objPGEducationTypeDTO=new EducationTypeDTO();
		objPGEducationTypeDTO.setGraduDetailsId(4);
		objPGEducationDetailsDTO.setEducationType(objPGEducationTypeDTO);
		
		listEducation.add(objPGEducationDetailsDTO);
		
		HrDelegate objHrDelegate=new HrDelegate();
		Integer userId=Integer.parseInt(user_id);
		String res=objHrDelegate.updateEducation(listEducation,userId);
		response.setContentType("text/html");
		PrintWriter write=response.getWriter();
		write.println(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
