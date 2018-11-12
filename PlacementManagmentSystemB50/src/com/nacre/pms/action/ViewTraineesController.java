package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * Servlet implementation class ViewTraineesController
 */
@WebServlet("/ViewTraineesControllerurl")
public class ViewTraineesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTraineesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String bid=req.getParameter("batches");
		int batchId=Integer.parseInt(bid);
		String techid=req.getParameter("technology");
		int tid=Integer.parseInt(techid);
		BatchDTO bdto= new BatchDTO();
		TechnologyDTO tdto= new TechnologyDTO();
		BatchTechnologyDTO btdto= new BatchTechnologyDTO();
		bdto.setBatchId(batchId);
		tdto.setTechnologyId(tid);
		btdto.setBatch(bdto);
		btdto.setTechnology(tdto);
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		HttpSession batchtechid=req.getSession();
		batchtechid.setAttribute("batchtechid",btdto);
		HttpSession session= req.getSession();
		List<EducationDetailsDTO> data=null;
		
		session.setAttribute("traineeDataList",data);
		try {
			HrDelegate hrd= new HrDelegate();
			 data= hrd.viewTraineeDetails(btdto);
			 
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("view controller date------"+data);
		
		
		
		System.out.println("size of the list ..."+data.size());
		
		
		
		
		
		req.setAttribute("view",data);
		
		//RequestDispatcher rd= req.getRequestDispatcher("jsp/hr/demo.jsp");
		RequestDispatcher rd= req.getRequestDispatcher("jsp/hr/viewtraineebyhr.jsp");
		//System.out.println("controller"+data);
		rd.forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
