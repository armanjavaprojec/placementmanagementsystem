package com.nacre.pms.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.nacre.pms.delegate.HrDelegate;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Sagar
 * @version 1.0.0 2018 this controller is used to get the batch details which
 *          has assigned by technologies
 */
@WebServlet("/batchtechloadcontroller")
public class BatchTechLoadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BatchTechLoadController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// get the user request so that we can get which kind of details customer wants
		// either batch or technologies
		String req = request.getParameter("req");

		if (req != null) {
			// getting batches information
			if (req.equals("batch")) {
				// creating HrDelegate object
				HrDelegate objHrDelegate = new HrDelegate();

				// getting batches into Map<Integer,String> object by calling getBatches()
				// method of HrDelegate
				Map<Integer, String> mapBatches = null;
				try {
					mapBatches = objHrDelegate.getBatches();
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// creating JSON object to pass response to user in the form of JSON object
				JsonObject jsonBatches = new JsonObject();

				Iterator<Entry<Integer, String>> iteratorBatches = mapBatches.entrySet().iterator();
				while (iteratorBatches.hasNext()) {
					Entry<Integer, String> entry = iteratorBatches.next();
					Integer batch_id = entry.getKey();
					String batch_name = entry.getValue();
					// preparing JSON object
					jsonBatches.addProperty(batch_id.toString(), batch_name);
				}
				response.setContentType("application/json");
				PrintWriter write = response.getWriter();

				// sending batches to user
				write.println(jsonBatches);
			}
			if (req.equals("tech")) {
				// getting technologies information

				// getting selected batch key
				String batchKey = request.getParameter("key");
				int key = Integer.parseInt(batchKey);

				// creating HrDelegate object
				HrDelegate objHrDelegate = new HrDelegate();

				// getting technologies into Map<Integer,String> object by calling
				// getAssignedTechnologies() method of HrDelegate
				Map<Integer, String> mapTechnologies = null;
				try {
					mapTechnologies = objHrDelegate.getAssignedTechnologies(key);
				} catch (DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// creating JSON object to pass response to user in the form of JSON object
				JsonObject jsonTechnologies = new JsonObject();

				Iterator<Entry<Integer, String>> iteratorTechnologies = mapTechnologies.entrySet().iterator();
				while (iteratorTechnologies.hasNext()) {
					Entry<Integer, String> entry = iteratorTechnologies.next();
					Integer tech_id = entry.getKey();
					String tech_name = entry.getValue();
					// preparing JSON object
					jsonTechnologies.addProperty(tech_id.toString(), tech_name);
				}
				response.setContentType("application/json");
				PrintWriter write = response.getWriter();

				// sending technologies to user
				write.println(jsonTechnologies);
			}

			if (req.equals("trinfo")) {
				// getting trainee info information from particular batch

				// getting select batch Id
				String batchId = request.getAttribute("batchId").toString();

				// getting selected technology Id
				String techId = request.getAttribute("techId").toString();

				// creating HrDelegate object
				HrDelegate objHrDelegate = new HrDelegate();

				// getting all trainee information into List<UserDTO> format
				List<UserDTO> objAllTRInfoList = null;
				try {
					objAllTRInfoList = objHrDelegate.getAllTrInfo(Integer.parseInt(batchId), Integer.parseInt(techId));
				} catch (NumberFormatException | DatabaseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// appending List<UserDTO> response of all trainees to called JSP
				request.setAttribute("allTRInfo", objAllTRInfoList);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
