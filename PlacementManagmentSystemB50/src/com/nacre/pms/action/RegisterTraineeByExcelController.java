package com.nacre.pms.action;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.servicei.serviceimpl.AdminServiceIMPL;
import com.nacre.pms.vo.TraineeVO;

/**
 * Servlet implementation class RegisterTraineeByExcelController
 */
@WebServlet("/reg_trainees_excel")
@MultipartConfig
public class RegisterTraineeByExcelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String result;
	TraineeDelegate traineeDelegate;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterTraineeByExcelController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TraineeVO> listVO = null;
		List<Map<Integer, String>> list = null;
		Map<Integer, String> map = null;
		Part p = null;
		InputStream is = null;
		Workbook book = null;
		Sheet fileSheet = null;
		Iterator<Row> rowItr = null;
		Iterator<Cell> cellItr = null;
		int cnt = 0;
		Cell cell = null;
		// read excel sheet and store in List of TraineeVO's
		list = new ArrayList<>();
		p = request.getPart("excel");
		is = p.getInputStream();
		book = new XSSFWorkbook(is);
		fileSheet = book.getSheetAt(0);
		rowItr = fileSheet.rowIterator();
		while (rowItr.hasNext()) {
			map = new HashMap<>();
			Row row = rowItr.next();
			cellItr = row.cellIterator();
			while (cellItr.hasNext()) {
				cell = cellItr.next();
				if (cnt == 4) {
					double num = cell.getNumericCellValue();
					DecimalFormat pattern = new DecimalFormat("#,#,#,#,#,#,#,#,#,#");
					NumberFormat testNumberFormat = NumberFormat.getNumberInstance();
					String mobNo = testNumberFormat.format(num);
					Number n = null;
					try {
						n = pattern.parse(mobNo);
						map.put(cnt++, n.toString());
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					map.put(cnt++, cell.toString());
				}
			}
			cnt = 0;
			list.add(map);
		}
		listVO = getListOfTrainees(list);
		// call delegate
		traineeDelegate = new TraineeDelegate();
		result = traineeDelegate.registerTraineesByList(listVO);
		request.setAttribute("result",result);
		request.getRequestDispatcher("/jsp/hr/hr.jsp").forward(request, response);
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

	public List<TraineeVO> getListOfTrainees(List<Map<Integer, String>> list) {
		List<TraineeVO> traineeListVO = new ArrayList();
		list.forEach(l -> {
			TraineeVO vo = new TraineeVO();
			l.forEach((k, v) -> {
				if (k == 0) {
					vo.setFirstName(v);
				} else if (k == 1) {
					vo.setLastName(v);
				} else if (k == 2) {
					vo.setEmail(v);
				} else if (k == 3) {
					vo.setPassword(v);
				} else if (k == 4) {
					vo.setMobno(v);
				} else if (k == 5) {
					vo.setGender(v);
				} else if (k == 6) {
					vo.setImage(null);
				} else if (k == 7) {
					vo.setDob(v);
				} else if (k == 8) {
					vo.setBatchName(v);
				} else if (k == 9) {
					vo.setTechnology(v);
				} else if (k == 10) {
					vo.setSscYop(v);
				} else if (k == 11) {
					vo.setSscPercentage(v);
				} else if (k == 12) {
					vo.setHseYop(v);
				} else if (k == 13) {
					vo.setHsePercentage(v);
				} else if (k == 14) {
					vo.setGraduationYop(v);
				} else if (k == 15) {
					vo.setGraduationPercentage(v);
				} else if (k == 16) {
					vo.setGraduationStream(v);
				} else if (k == 17) {
					vo.setGraduationSpecialization(v);
				} else if (k == 18) {
					vo.setPostGraduationYop(v);
				} else if (k == 19) {
					vo.setPostGraduationPercentage(v);
				} else if (k == 20) {
					vo.setPostGraduationStream(v);
				} else if (k == 21) {
					vo.setPostGraduationSpecialization(v);
				} else if (k == 22) {
					vo.setLocation(v);
				} else if (k == 23) {
					vo.setPincode(v);
				} else if (k == 24) {
					vo.setCity(v);
				} else if (k == 25) {
					vo.setState(v);
				} else if (k == 26) {
					vo.setCountry(v);
				}
			});
			traineeListVO.add(vo);
		});
		return traineeListVO;
	}
}