package com.nacre.pms.daoi.daoimpl;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.AddressBO;
import com.nacre.pms.bo.BatchBO;
import com.nacre.pms.bo.CityBO;
import com.nacre.pms.bo.ClientAddressBO;
import com.nacre.pms.bo.ClientBO;
import com.nacre.pms.bo.CountryBO;
import com.nacre.pms.bo.EducationDetailsBO;
import com.nacre.pms.bo.EducationTypeBO;
import com.nacre.pms.bo.EducationalTypeDetailsBO;
import com.nacre.pms.bo.EligibleStudentBO;
import com.nacre.pms.bo.InterviewRoundBO;
import com.nacre.pms.bo.JobPostingBO;
import com.nacre.pms.bo.JobPostingChangeBO;
import com.nacre.pms.bo.JobPostingResultBO;
import com.nacre.pms.bo.LevelBO;
import com.nacre.pms.bo.LocationBO;
import com.nacre.pms.bo.SpecializationBO;
import com.nacre.pms.bo.StateBO;
import com.nacre.pms.bo.StreamBO;
import com.nacre.pms.bo.TechnologyBO;
import com.nacre.pms.bo.UserBO;
import com.nacre.pms.daoi.HrDaoI;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.db_util.SQLQueryConstants;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.FeedbackTypeDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.LocationDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.DateUtil;
import com.nacre.pms.util.StringConstants;
import com.nacre.pms.vo.AssignVo;
import com.nacre.pms.vo.PlacedResultVO;
import com.nacre.pms.vo.TechnologyFilterVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the HR
 *         Functionalities
 */

public class HrDaoIMPL implements HrDaoI {
	// declaring all the object References as global
	PreparedStatement ps = null;
	int result = 0;
	PreparedStatement pst = null;
	int count = 0;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Map map = null;
	private static final String ADD_JOB_POSTING = "insert into tbl_job_posting(description,expected_date,posted_date,`no_of_vacancies`,client_address_id)\r\n"
			+ "values (?,?,?,?,?)";

	private static final String VIEW_JOB_POSTING = "select tbl_job_posting.job_posting_id,tbl_client.client_name,tbl_address.location,\r\n"
			+ " tbl_client_address.contact_person_name,tbl_client_address.contact_person_mobile,\r\n"
			+ " tbl_client_address.contact_person_email,tbl_job_posting.description,tbl_job_posting.expected_date,\r\n"
			+ " tbl_job_posting.posted_date,tbl_job_posting.`no_of_vacancies`,tbl_job_posting.client_address_id\r\n"
			+ " from tbl_client,tbl_address,tbl_client_address,tbl_job_posting \r\n"
			+ " where tbl_job_posting.client_address_id= tbl_client_address.client_address_id \r\n"
			+ " AND tbl_client_address.client_id = tbl_client.client_id\r\n"
			+ " AND tbl_client_address.address_id = tbl_address.address_id\r\n" + " AND tbl_client.client_id = ? \r\n"
			+ " AND tbl_address.address_id = ?";

	private static final String DELETE_JOB_POSTING_BY_ID = "delete from tbl_job_posting where tbl_job_posting.job_posting_id = ?";

	private static final String UPDATE_JOB_POSTING_BY_ID = "UPDATE tbl_job_posting\r\n" + "SET description = ?,\r\n"
			+ "expected_date= ?,\r\n" + "posted_date= ?,\r\n" + "`no_of_vacancies` = ? \r\n"
			+ "WHERE tbl_job_posting.job_posting_id = ?";

	private static final String GET_ALL_COMPANIES = "SELECT CLIENT_ID,CLIENT_NAME FROM TBL_CLIENT";

	private static final String GET_CLIENT_LOCATIONS = "select DISTINCT tbl_address.address_id,tbl_address.location,tbl_address.pincode,\r\n"
			+ "tbl_city.city,tbl_state.state,tbl_country.country,tbl_client_address.client_address_id\r\n"
			+ "from tbl_city, tbl_address,tbl_client_address,tbl_client,tbl_state,tbl_country\r\n"
			+ "where tbl_address.city_id = tbl_city.city_id\r\n" + "AND tbl_city.state_id = tbl_state.state_id\r\n"
			+ "AND tbl_state.country_id = tbl_country.country_id\r\n"
			+ "AND tbl_address.address_id = tbl_client_address.address_id\r\n" + "AND tbl_client_address.client_id = ?";

	private static final String VIEW_PLACED = "select tbl_user.first_name,tbl_client.client_name,tbl_address.location,tbl_job_type.job_type,\r\n"
			+ "tbl_user.email,tbl_user.mobileno,tbl_placement.joining_date,tbl_placement.bond_aggrement,\r\n"
			+ "tbl_placement.package_per_anum\r\n"
			+ "from tbl_client,tbl_client_address,tbl_user,tbl_placement,tbl_batch_technology,tbl_address,tbl_job_type\r\n"
			+ "where tbl_placement.user_id = tbl_user.user_id\r\n"
			+ "AND tbl_placement.client_address_id = tbl_client_address.client_address_id\r\n"
			+ "AND tbl_user.batch_technology_id = tbl_batch_technology.batch_technology_id\r\n"
			+ "AND tbl_placement.job_type_id = tbl_job_type.job_type_id\r\n"
			+ "AND tbl_client_address.address_id = tbl_address.address_id\r\n"
			+ "AND tbl_client_address.client_id = tbl_client.client_id\r\n"
			+ "AND tbl_batch_technology.batch_id = ?\r\n"
			+ "AND tbl_batch_technology.technology_id = ?";

	private static final String GET_ALL_BATCH = "SELECT tbl_batch.batch_id,tbl_batch.batch FROM tbl_batch";

	private static final String GET_TECHNOLOGY = "SELECT DISTINCT(tbl_technology.technology_id),tbl_technology.technology \r\n"
			+ "FROM tbl_technology,tbl_batch,tbl_batch_technology\r\n"
			+ "where tbl_batch_technology.batch_id = tbl_batch.batch_id\r\n" + "AND tbl_batch.batch_id = ?";

	@Override
	public List<PlacedResultVO> viewPlaced(int batchId, int techId, Connection con)
			throws SQLException, DatabaseException {
		List<PlacedResultVO> placedResultVOList = null;
		PlacedResultVO placedResultVO = null;
		System.out.println(batchId + "---" + techId);
		if (con != null) {
			pstmt = con.prepareStatement(VIEW_PLACED);
			pstmt.setInt(1, batchId);
			pstmt.setInt(2, techId);
		}
		if (pstmt != null) {
			rs = pstmt.executeQuery();
		}
		placedResultVOList = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				placedResultVO = new PlacedResultVO();
				placedResultVO.setfName(rs.getString(1));
				placedResultVO.setcName(rs.getString(2));
				placedResultVO.setLocation(rs.getString(3));
				placedResultVO.setjType(rs.getString(4));
				placedResultVO.setuEmail(rs.getString(5));
				placedResultVO.setMobile(rs.getString(6));
				placedResultVO.setJoinDate(rs.getDate(7).toString());
				placedResultVO.setBond(String.valueOf(rs.getInt(8)));
				placedResultVO.setPack(String.valueOf(rs.getFloat(9)));
				placedResultVOList.add(placedResultVO);
			}
		}

		return placedResultVOList;
	}

	@Override
	public Map<Integer, String> getAllBatch(Connection con) throws DatabaseException, SQLException {
		Map<Integer, String> batchMap = new HashMap<>();
		if (con != null) {
			pstmt = con.prepareStatement(GET_ALL_BATCH);
		}
		if (pstmt != null) {
			rs = pstmt.executeQuery();
		}
		if (rs != null) {
			while (rs.next()) {
				batchMap.put(rs.getInt(1), rs.getString(2));
			}
		}
		return batchMap;
	}

	@Override
	public List<TechnologyFilterVO> getTechnology(int batchId, Connection con) throws SQLException, DatabaseException {
		if (con != null) {
			pstmt = con.prepareStatement(GET_TECHNOLOGY);
		}
		if (pstmt != null) {
			pstmt.setInt(1, batchId);
			rs = pstmt.executeQuery();
		}
		List<TechnologyFilterVO> list = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				TechnologyFilterVO technologyFilterVO = new TechnologyFilterVO();
				technologyFilterVO.setTechId(String.valueOf(rs.getInt(1)));
				technologyFilterVO.setTechName(rs.getString(2));

				list.add(technologyFilterVO);
			}
		}
		return list;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return batches in the form of key,value from the Database
	 */
	@Override
	public Map getBatch(Connection con) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_BATCH);
		pstmt.setInt(1, StringConstants._ACTIVE_STATUS_ID);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int bid = rs.getInt(1);
			String bname = rs.getString(2);
			map.put(bid, bname);
		}
		return map;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Technologies in the form of key,value from the Database
	 */
	@Override
	public Map getTechnology(Connection con, int batch_id) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_TECHNOLOGY);
		pstmt.setInt(1, StringConstants._ACTIVE_STATUS_ID);
		pstmt.setInt(2, batch_id);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int tid = rs.getInt(1);
			String tname = rs.getString(2);
			map.put(tid, tname);
			// System.out.println("dao implee---tech data--"+map);
		}
		return map;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Countries in the form of key,value from the Database
	 */
	@Override
	public Map getCountry(Connection con) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_COUNTRY);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int cid = rs.getInt(1);
			String cname = rs.getString(2);
			map.put(cid, cname);
		}
		return map;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return States in the form of key,value from the Database
	 */
	@Override
	public Map getState(Connection con, int country_id) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_STATE);
		pstmt.setInt(1, country_id);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int sid = rs.getInt(1);
			String sname = rs.getString(2);
			map.put(sid, sname);
		}
		return map;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Cities in the form of key,value from the Database
	 */
	@Override
	public Map getCity(Connection con, int state_id) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_CITY);
		pstmt.setInt(1, state_id);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int cid = rs.getInt(1);
			String cname = rs.getString(2);
			map.put(cid, cname);
		}
		return map;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Streams in the form of key,value from the Database
	 */
	@Override
	public Map getGraduationStream(Connection con) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_STREAM);
		pstmt.setInt(1, 3);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int sscid = rs.getInt(1);
			String sscyop = rs.getString(2);
			map.put(sscid, sscyop);
		}
		return map;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Streams in the form of key,value from the Database
	 */
	@Override
	public Map getPGraduationStream(Connection con) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_STREAM);
		pstmt.setInt(1, 4);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int sscid = rs.getInt(1);
			String sscyop = rs.getString(2);
			map.put(sscid, sscyop);
		}
		return map;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Specailizations in the form of key,value from the Database
	 */
	@Override
	public Map getGraduationSpecilization(Connection con, int gid) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_SPECILIZATION);
		pstmt.setInt(1, gid);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int sscid = rs.getInt(1);
			String sscyop = rs.getString(2);
			map.put(sscid, sscyop);
		}
		return map;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Specailizations in the form of key,value from the
	 *         Database
	 */
	@Override
	public Map getPGraduationSpecilization(Connection con, int pgid) throws SQLException, DatabaseException {
		pstmt = con.prepareStatement(SQLQueryConstants.GET_SPECILIZATION);
		pstmt.setInt(1, pgid);
		rs = pstmt.executeQuery();
		map = new HashMap();
		while (rs.next()) {
			int sscid = rs.getInt(1);
			String sscyop = rs.getString(2);
			map.put(sscid, sscyop);
		}
		return map;
	}

	/*
	 * 
	 * 
	 * @author Latha
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * @return
	 */
	@Override
	public String hrAddTraineePostGraduation(Connection con, EducationDetailsBO eduDetailsBO)
			throws SQLException, DatabaseException, FileNotFoundException {
		int batch_id = eduDetailsBO.getUserBO().getBatchTechnology().getBatch().getBatchId();
		int tech_id = eduDetailsBO.getUserBO().getBatchTechnology().getTechnology().getTechnologyId();
		String fname = eduDetailsBO.getUserBO().getFirstname();
		String lname = eduDetailsBO.getUserBO().getLastname();
		String mblno = eduDetailsBO.getUserBO().getMobileNo();
		String email = eduDetailsBO.getUserBO().getEmail();
		Date dob = eduDetailsBO.getUserBO().getDate();
		String image = eduDetailsBO.getUserBO().getImage();

		int gender = eduDetailsBO.getUserBO().getGender();
		String addrs = eduDetailsBO.getUserBO().getAddress().getLocation();
		Integer zipcode = eduDetailsBO.getUserBO().getAddress().getPincode();
		int city = eduDetailsBO.getUserBO().getAddress().getCity().getCityId();
		int state = eduDetailsBO.getUserBO().getAddress().getCity().getState().getStateId();
		int country = eduDetailsBO.getUserBO().getAddress().getCity().getState().getCountry().getCountryId();

		String msg = "";
		int count = 0;

		PreparedStatement pstmtSelectBatch = con.prepareStatement(SQLQueryConstants.SELECT_BATCH_TECHNOLOGY);
		pstmtSelectBatch.setInt(1, batch_id);
		pstmtSelectBatch.setInt(2, tech_id);

		ResultSet rsSelectBatch = pstmtSelectBatch.executeQuery();
		int btid = 0;
		if (rsSelectBatch.next()) {
			btid = rsSelectBatch.getInt(1);
		}
		try {
			con.setAutoCommit(false);
			PreparedStatement pstmtInsertAddress = con.prepareStatement(SQLQueryConstants.INSERT_ADDRESS,
					Statement.RETURN_GENERATED_KEYS);
			pstmtInsertAddress.setString(1, addrs);
			pstmtInsertAddress.setInt(2, zipcode);
			pstmtInsertAddress.setInt(3, city);
			int address_result = pstmtInsertAddress.executeUpdate();
			ResultSet rsInsertAddress = pstmtInsertAddress.getGeneratedKeys();
			int aid = 0;
			if (rsInsertAddress.next()) {
				aid = rsInsertAddress.getInt(1);
			}
			PreparedStatement pstmtInsertTrainee = con.prepareStatement(SQLQueryConstants.INSERT_TRAINEE,
					Statement.RETURN_GENERATED_KEYS);

			pstmtInsertTrainee.setString(1, fname);
			pstmtInsertTrainee.setString(2, lname);
			pstmtInsertTrainee.setString(3, email);
			pstmtInsertTrainee.setString(4, mblno);
			pstmtInsertTrainee.setString(5, mblno);
			pstmtInsertTrainee.setInt(6, gender);
			pstmtInsertTrainee.setString(7, image);
			pstmtInsertTrainee.setDate(8, (java.sql.Date) dob);
			pstmtInsertTrainee.setInt(9, StringConstants._TRAINEE_ROLE_ID);
			pstmtInsertTrainee.setInt(10, StringConstants._ACTIVE_STATUS_ID);
			pstmtInsertTrainee.setInt(11, btid);
			pstmtInsertTrainee.setInt(12, aid);
			int user_result = pstmtInsertTrainee.executeUpdate();
			ResultSet rsInsertTrainee = pstmtInsertTrainee.getGeneratedKeys();
			int uid = 0;
			if (rsInsertTrainee.next()) {
				uid = rsInsertTrainee.getInt(1);
			}
			int edutypedetailssid = 0;
			int edutypedetailshid = 0;
			int edutypedetailsgid = 0;
			int edutypedetailspgid = 0;

			int ssc_result = 0;
			int hsc_result = 0;
			int grad_result = 0;
			int pg_result = 0;

			List<EducationalTypeDetailsBO> edutBO = eduDetailsBO.getEducationalTypeDetailsBOList();

			for (Iterator iterator = edutBO.iterator(); iterator.hasNext();) {
				EducationalTypeDetailsBO educationalTypeDetailsBO = (EducationalTypeDetailsBO) iterator.next();

				int edutypeid = educationalTypeDetailsBO.getEducationTypeBO().getGraduDetailsId();

				if (edutypeid == 1) {
					PreparedStatement pstmtSSC = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtSSC.setInt(1, uid);
					pstmtSSC.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtSSC.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtSSC.setInt(4, edutypeid);
					pstmtSSC.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					ssc_result = pstmtSSC.executeUpdate();
					ResultSet rsSSC = pstmtSSC.getGeneratedKeys();
					if (rsSSC.next()) {
						edutypedetailssid = rsSSC.getInt(1);
					}
				} else if (edutypeid == 2) {
					PreparedStatement pstmtHSC = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtHSC.setInt(1, uid);
					pstmtHSC.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtHSC.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtHSC.setInt(4, edutypeid);
					pstmtHSC.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());
					hsc_result = pstmtHSC.executeUpdate();
					ResultSet rsHSC = pstmtHSC.getGeneratedKeys();
					if (rsHSC.next()) {
						edutypedetailshid = rsHSC.getInt(1);
					}

				} else if (edutypeid == 3) {
					PreparedStatement pstmtGRAD = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtGRAD.setInt(1, uid);
					pstmtGRAD.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtGRAD.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtGRAD.setInt(4, edutypeid);
					pstmtGRAD.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					grad_result = pstmtGRAD.executeUpdate();
					ResultSet rsGRAD = pstmtGRAD.getGeneratedKeys();
					if (rsGRAD.next()) {
						edutypedetailsgid = rsGRAD.getInt(1);
					}

				} else if (edutypeid == 4) {
					PreparedStatement pstmtPG = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtPG.setInt(1, uid);
					pstmtPG.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtPG.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtPG.setInt(4, edutypeid);
					pstmtPG.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					pg_result = pstmtPG.executeUpdate();
					ResultSet rsPG = pstmtPG.getGeneratedKeys();
					if (rsPG.next()) {
						edutypedetailspgid = rsPG.getInt(1);
					}
				}

			} // for each

			ArrayList al = new ArrayList<>();
			al.add(edutypedetailssid);
			al.add(edutypedetailshid);
			al.add(edutypedetailsgid);
			al.add(edutypedetailspgid);
			int etdid = 0;
			for (Object object : al) {
				Integer i = (Integer) object;
				etdid = i;
				PreparedStatement pstmtinsertedu = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
				pstmtinsertedu.setInt(1, etdid);
				pstmtinsertedu.setInt(2, uid);
				count = pstmtinsertedu.executeUpdate();

			}

			if (count > 0 && ssc_result > 0 && hsc_result > 0 && grad_result > 0 && pg_result > 0 && user_result > 0
					&& address_result > 0) {
				con.commit();
				msg = "success";
			} else {
				con.rollback();
				msg = "fail";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return
	 */
	@Override
	public String hrAddTraineeGraduation(Connection con, EducationDetailsBO eduDetailsBO)
			throws SQLException, DatabaseException, FileNotFoundException {

		int batch_id = eduDetailsBO.getUserBO().getBatchTechnology().getBatch().getBatchId();
		int tech_id = eduDetailsBO.getUserBO().getBatchTechnology().getTechnology().getTechnologyId();
		String fname = eduDetailsBO.getUserBO().getFirstname();
		String lname = eduDetailsBO.getUserBO().getLastname();
		String mblno = eduDetailsBO.getUserBO().getMobileNo();
		String email = eduDetailsBO.getUserBO().getEmail();
		Date dob = eduDetailsBO.getUserBO().getDate();
		String image = eduDetailsBO.getUserBO().getImage();

		int gender = eduDetailsBO.getUserBO().getGender();
		String addrs = eduDetailsBO.getUserBO().getAddress().getLocation();
		Integer zipcode = eduDetailsBO.getUserBO().getAddress().getPincode();
		int city = eduDetailsBO.getUserBO().getAddress().getCity().getCityId();
		int state = eduDetailsBO.getUserBO().getAddress().getCity().getState().getStateId();
		int country = eduDetailsBO.getUserBO().getAddress().getCity().getState().getCountry().getCountryId();

		String msg = "";
		int count = 0;

		PreparedStatement pstmtSelectBatch = con.prepareStatement(SQLQueryConstants.SELECT_BATCH_TECHNOLOGY);
		pstmtSelectBatch.setInt(1, batch_id);
		pstmtSelectBatch.setInt(2, tech_id);

		ResultSet rsSelectBatch = pstmtSelectBatch.executeQuery();
		int btid = 0;
		if (rsSelectBatch.next()) {
			btid = rsSelectBatch.getInt(1);
		}
		try {
			con.setAutoCommit(false);

			PreparedStatement pstmtInsertAddress = con.prepareStatement(SQLQueryConstants.INSERT_ADDRESS,
					Statement.RETURN_GENERATED_KEYS);
			pstmtInsertAddress.setString(1, addrs);
			pstmtInsertAddress.setInt(2, zipcode);
			pstmtInsertAddress.setInt(3, city);
			int address_result = pstmtInsertAddress.executeUpdate();
			ResultSet rsInsertAddress = pstmtInsertAddress.getGeneratedKeys();
			int aid = 0;
			if (rsInsertAddress.next()) {
				aid = rsInsertAddress.getInt(1);
			}
			PreparedStatement pstmtInsertTrainee = con.prepareStatement(SQLQueryConstants.INSERT_TRAINEE,
					Statement.RETURN_GENERATED_KEYS);

			pstmtInsertTrainee.setString(1, fname);
			pstmtInsertTrainee.setString(2, lname);
			pstmtInsertTrainee.setString(3, email);
			pstmtInsertTrainee.setString(4, mblno);
			pstmtInsertTrainee.setString(5, mblno);
			pstmtInsertTrainee.setInt(6, gender);
			pstmtInsertTrainee.setString(7, image);
			pstmtInsertTrainee.setDate(8, (java.sql.Date) dob);
			pstmtInsertTrainee.setInt(9, StringConstants._TRAINEE_ROLE_ID);
			pstmtInsertTrainee.setInt(10, StringConstants._ACTIVE_STATUS_ID);
			pstmtInsertTrainee.setInt(11, btid);
			pstmtInsertTrainee.setInt(12, aid);
			int user_result = pstmtInsertTrainee.executeUpdate();
			ResultSet rsInsertTrainee = pstmtInsertTrainee.getGeneratedKeys();
			int uid = 0;
			if (rsInsertTrainee.next()) {
				uid = rsInsertTrainee.getInt(1);
			}
			int edutypedetailssid = 0;
			int edutypedetailshid = 0;
			int edutypedetailsgid = 0;
			int edutypedetailspgid = 0;
			int ssc_result = 0;
			int hsc_result = 0;
			int grad_result = 0;
			int pg_result = 0;
			List<EducationalTypeDetailsBO> edutBO = eduDetailsBO.getEducationalTypeDetailsBOList();

			for (Iterator iterator = edutBO.iterator(); iterator.hasNext();) {
				EducationalTypeDetailsBO educationalTypeDetailsBO = (EducationalTypeDetailsBO) iterator.next();

				int edutypeid = educationalTypeDetailsBO.getEducationTypeBO().getGraduDetailsId();

				if (edutypeid == 1) {
					PreparedStatement pstmtSSC = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtSSC.setInt(1, uid);
					pstmtSSC.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtSSC.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtSSC.setInt(4, edutypeid);
					pstmtSSC.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					ssc_result = pstmtSSC.executeUpdate();
					ResultSet rsSSC = pstmtSSC.getGeneratedKeys();
					if (rsSSC.next()) {
						edutypedetailssid = rsSSC.getInt(1);
					}
				} else if (edutypeid == 2) {
					PreparedStatement pstmtHSC = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtHSC.setInt(1, uid);
					pstmtHSC.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtHSC.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtHSC.setInt(4, edutypeid);
					pstmtHSC.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());
					hsc_result = pstmtHSC.executeUpdate();
					ResultSet rsHSC = pstmtHSC.getGeneratedKeys();
					if (rsHSC.next()) {
						edutypedetailshid = rsHSC.getInt(1);
					}

				} else if (edutypeid == 3) {
					PreparedStatement pstmtGRAD = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtGRAD.setInt(1, uid);
					pstmtGRAD.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtGRAD.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtGRAD.setInt(4, edutypeid);
					pstmtGRAD.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					grad_result = pstmtGRAD.executeUpdate();
					ResultSet rsGRAD = pstmtGRAD.getGeneratedKeys();
					if (rsGRAD.next()) {
						edutypedetailsgid = rsGRAD.getInt(1);
					}
				} else if (edutypeid == 4) {
					PreparedStatement pstmtPGRAD = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_TYPE_DETAILS,
							Statement.RETURN_GENERATED_KEYS);
					pstmtPGRAD.setInt(1, uid);
					pstmtPGRAD.setFloat(2, educationalTypeDetailsBO.getPercentage());
					pstmtPGRAD.setInt(3, educationalTypeDetailsBO.getYop());
					pstmtPGRAD.setInt(4, edutypeid);
					pstmtPGRAD.setInt(5, educationalTypeDetailsBO.getSpecializationBO().getSpecializationId());

					pg_result = pstmtPGRAD.executeUpdate();
					ResultSet rsPGRAD = pstmtPGRAD.getGeneratedKeys();
					if (rsPGRAD.next()) {
						edutypedetailspgid = rsPGRAD.getInt(1);
					}

				}

			} // for each

			ArrayList al = new ArrayList<>();
			al.add(edutypedetailssid);
			al.add(edutypedetailshid);
			al.add(edutypedetailsgid);
			al.add(edutypedetailspgid);

			int etdid = 0;
			for (Object object : al) {
				Integer i = (Integer) object;
				etdid = i;
				PreparedStatement pstmtinsertedu = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
				pstmtinsertedu.setInt(1, etdid);
				pstmtinsertedu.setInt(2, uid);
				count = pstmtinsertedu.executeUpdate();

			}

			if (count > 0 && ssc_result > 0 && hsc_result > 0 && grad_result > 0 && pg_result > 0 && user_result > 0
					&& address_result > 0) {
				con.commit();
				msg = "success";
			} else {
				con.rollback();
				msg = "fail";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;

	}

	/**
	 * @author Atul
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java getJobPostingRelatedDataToHR() will display
	 *         Company info to HR
	 */

	@Override
	public List<Object> getJobPostingRelatedDataToHR(Connection con) throws SQLException, DatabaseException {
		// DTO Objects
		JobPostingDTO jobpost = null;
		ClientAddressDTO address = null;
		ClientDTO client = null;
		AddressDTO ad = null;
		CityDTO ct = null;
		StateDTO st = null;
		CountryDTO cntry = null;

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		// getting connection
		pst = con.prepareStatement(SQLQueryConstants.SHOW_CLIENT_INFO_TO_HR);
		pst.setDate(1, DateUtil.stringToSqlDate(date, pattern));
		rs = pst.executeQuery();
		// setting Values TO DTO
		List<Object> list = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				jobpost = new JobPostingDTO();
				address = new ClientAddressDTO();
				client = new ClientDTO();
				ad = new AddressDTO();
				ct = new CityDTO();
				st = new StateDTO();
				cntry = new CountryDTO();

				jobpost.setDescription(rs.getString(1));
				jobpost.setExpectedDate(rs.getDate(2));
				jobpost.setPostDate(rs.getDate(3));
				jobpost.setVacancies(rs.getInt(4));

				client.setClientName(rs.getString(5));
				client.setClientImage(rs.getString(6));
				client.setClientDescription(rs.getString(7));

				address.setContactPresonName(rs.getString(8));
				address.setContactPresonMobileNO(rs.getString(9));
				address.setContactPresonNameEmail(rs.getString(10));

				ad.setLocation(rs.getString(11));
				ct.setCity(rs.getString(12));
				st.setState(rs.getString(13));
				cntry.setCountry(rs.getString(14));
				jobpost.setJobPostId(rs.getInt(15));
				cntry.setCountryId(rs.getInt(16));

				// adding DTO objects to List
				list.add(jobpost);
				list.add(client);
				list.add(address);
				list.add(ad);
				list.add(ct);
				list.add(st);
				list.add(cntry);
			}
		}
		if (list != null)
			return list;
		else
			return null;
	}

	// setting read data
	/**
	 * @author Atul setReadNotification(-) method for showing notification viewed by
	 *         the HR
	 */
	@Override
	public void setReadNotification(StatusDTO sdto, Connection con) throws SQLException, DatabaseException {

		pst = con.prepareStatement(SQLQueryConstants.SET_READ_NOTIFICATION_TO_HR);
		pst.setInt(1, sdto.getStatusId());
		// hr session , hr id will be here
		pst.setInt(2, 1);
		int count = pst.executeUpdate();
	}

	/**
	 * @author Atul setReadNotification(-,-) method for showing single notification
	 *         viewed by the HR
	 */
	@Override
	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto, Connection con)
			throws SQLException, DatabaseException {
		pst = con.prepareStatement(SQLQueryConstants.SET_READ_SINGLE_NOTIFICATION_TO_HR);
		pst.setInt(1, sdto.getStatusId());
		pst.setInt(2, jdto.getJobPostId());
		int count = pst.executeUpdate();
	}

	@Override
	public String addJobPosting(JobPostingChangeBO jobPostingChangeBO, Connection con)
			throws DatabaseException, SQLException {
		if (con != null) {
			pstmt = con.prepareStatement(ADD_JOB_POSTING);
		}
		if (pstmt != null) {
			System.out.println(jobPostingChangeBO.getExpectedDate().toString());
			pstmt.setString(1, jobPostingChangeBO.getDescription());
			pstmt.setDate(2, java.sql.Date.valueOf(jobPostingChangeBO.getExpectedDate()));
			pstmt.setDate(3, java.sql.Date.valueOf(jobPostingChangeBO.getPostDate()));
			pstmt.setInt(4, jobPostingChangeBO.getNoOfVacancies());
			pstmt.setInt(5, jobPostingChangeBO.getClientAddressId());

			count = pstmt.executeUpdate();
		}

		if (count != 0) {
			return "JOB Posting Added Successfully ... :)";
		} else {
			return "JOB Posting Not Added ... try Again .. !!!";
		}
	}

	@Override
	public List<JobPostingResultBO> viewJobPostings(int clientId, int addressId, Connection con)
			throws SQLException, DatabaseException {
		List<JobPostingResultBO> jobPostResultBOList = null;
		JobPostingResultBO jobPostResultBO = null;
		if (con != null) {
			pstmt = con.prepareStatement(VIEW_JOB_POSTING);
			pstmt.setInt(1, clientId);
			pstmt.setInt(2, addressId);
		}
		if (pstmt != null) {
			rs = pstmt.executeQuery();
		}
		jobPostResultBOList = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				jobPostResultBO = new JobPostingResultBO();
				jobPostResultBO.setJobPostingId(rs.getInt(1));
				jobPostResultBO.setClientName(rs.getString(2));
				jobPostResultBO.setLocation(rs.getString(3));
				jobPostResultBO.setCpName(rs.getString(4));
				jobPostResultBO.setCpMobile(rs.getLong(5));

				jobPostResultBO.setCpEmail(rs.getString(6));
				jobPostResultBO.setDescription(rs.getString(7));
				jobPostResultBO.setExpDate(rs.getDate(8).toString());

				jobPostResultBO.setPostDate(rs.getDate(9).toString());

				jobPostResultBO.setNoOfVacancies(rs.getInt(10));
				jobPostResultBO.setClientAddressId(rs.getInt(11));

				jobPostResultBOList.add(jobPostResultBO);
			}
		}

		return jobPostResultBOList;
	}

	@Override
	public String deleteJobPostById(int jobId, Connection con) throws DatabaseException, SQLException {
		String result = null;
		int count = 0;
		if (con != null) {
			pstmt = con.prepareStatement(DELETE_JOB_POSTING_BY_ID);
			pstmt.setInt(1, jobId);
		}
		if (pstmt != null) {
			count = pstmt.executeUpdate();
		}
		if (count != 0) {
			return "JOB Posting Deleted Successfully ... :-(";
		} else {
			return "JOB Posting Not Deleted .... Try Again";
		}
	}

	@Override
	public String updateJobPostById(JobPostingChangeBO jobPostingChangeBO, Connection con)
			throws DatabaseException, SQLException {
		String result = null;
		int count = 0;

		if (con != null) {
			pstmt = con.prepareStatement(UPDATE_JOB_POSTING_BY_ID);
		}
		if (pstmt != null) {
			pstmt.setString(1, jobPostingChangeBO.getDescription());
			pstmt.setDate(2, java.sql.Date.valueOf(jobPostingChangeBO.getExpectedDate()));
			pstmt.setDate(3, java.sql.Date.valueOf(jobPostingChangeBO.getPostDate()));
			pstmt.setInt(4, jobPostingChangeBO.getNoOfVacancies());
			pstmt.setInt(5, jobPostingChangeBO.getJobPostId());

			count = pstmt.executeUpdate();
		}
		if (count != 0) {
			return "Job Posting Updated Successfully";
		} else {
			return "Job Posting Not Updated .... Try Again";
		}
	}

	@Override
	public Map<Integer, String> getAllClients(Connection con) throws DatabaseException, SQLException {
		Map<Integer, String> clientMap = new HashMap<>();
		if (con != null) {
			pstmt = con.prepareStatement(GET_ALL_COMPANIES);
		}
		if (pstmt != null) {
			rs = pstmt.executeQuery();
		}
		if (rs != null) {
			while (rs.next()) {
				clientMap.put(rs.getInt(1), rs.getString(2));
			}
		}
		return clientMap;
	}

	@Override
	public List<LocationDTO> getClientLocations(int clientId, Connection con) throws SQLException, DatabaseException {
		if (con != null) {
			pstmt = con.prepareStatement(GET_CLIENT_LOCATIONS);
		}
		if (pstmt != null) {
			pstmt.setInt(1, clientId);
			rs = pstmt.executeQuery();
		}
		List<LocationDTO> list = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				LocationBO locationBO = new LocationBO();
				LocationDTO locationDTO = new LocationDTO();
				locationBO.setAddressId(rs.getInt(1));
				locationBO.setAddress(rs.getString(2));
				locationBO.setPinCode(rs.getInt(3));
				locationBO.setCity(rs.getString(4));
				locationBO.setState(rs.getString(5));
				locationBO.setCountry(rs.getString(6));
				locationBO.setClientAddressId(rs.getInt(7));

				System.out.println(locationBO.toString());

				locationDTO.setAddressId(locationBO.getAddressId());
				locationDTO.setAddress(locationBO.getAddress());
				locationDTO.setPinCode(locationBO.getPinCode());
				locationDTO.setCity(locationBO.getCity());
				locationDTO.setState(locationBO.getState());
				locationDTO.setCountry(locationBO.getCountry());
				locationDTO.setClientAddressId(locationBO.getClientAddressId());

				list.add(locationDTO);
			}
		}
		return list;
	}

	/*
	 * Batch Functionality
	 */

	@Override
	public List viewBatch(Connection con) throws SQLException {

		// Connection con = null;
		ResultSet rs = null;
		java.sql.Statement st = null;
		List<Object> list = null;
		st = con.createStatement();
		rs = st.executeQuery(SQLQueryConstants.GET_BATCH_DETAILS);
		list = new ArrayList<Object>();
		BatchDTO dto = null;

		while (rs.next()) {
			dto = new BatchDTO();
			dto.setBatchId(rs.getInt(1));
			dto.setBatch(rs.getString(2));

			dto.setBatch_start_date(rs.getDate(3));
			dto.setBatch_end_date(rs.getDate(4));

			StatusDTO statusDTO = new StatusDTO();
			int statusId = Integer.valueOf(rs.getInt(5));
			statusDTO.setStatusId(statusId);
			dto.setStatus(statusDTO);

			list.add(dto);

		}

		return list;

	}

	// Delete Batch
	@Override
	public int sendBatchId(int batchId, Connection con) throws SQLException, DatabaseException {

		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.DELETE_Batch_DETAILS);
		ps.setInt(1, batchId);
		int count = ps.executeUpdate();

		return count;
	}

	// update Batch
	@Override
	public int updateBatch(BatchDTO dto, Connection con) throws SQLException, DatabaseException {
		String name = "";
		int count = 0;
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.BATCH_UPDATE);
		ps.setString(1, dto.getBatch());
		ps.setDate(2, (java.sql.Date) dto.getBatch_start_date());
		ps.setDate(3, (java.sql.Date) dto.getBatch_end_date());
		ps.setInt(4, dto.getBatchId());
		count = ps.executeUpdate();

		return count;

	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java insertTech method is used to insert the data into
	 * Technology table.
	 */
	@Override
	public int insertTech(TechnologyDTO tdto, Connection con) throws SQLException, DatabaseException {
		int result = 0;
		String name = "";
		String tname = tdto.getTechnology();
		PreparedStatement ps = null;
		ps = DbUtil.getConnection().prepareStatement(SQLQueryConstants.CHECK_TECHNOLOGY_NAME);
		int checkTech = 1;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			name = rs.getString(1);
			if (tname.equalsIgnoreCase(name)) {
				checkTech = 0;
				break;
			} else {
				checkTech = 1;
			}
		}
		if (checkTech == 0) {
			return checkTech;
		} else {
			ps = con.prepareStatement(SQLQueryConstants.ADD_TECHONOLGY);
			ps.setString(1, tname);
			ps.setInt(2, 1);
			result = ps.executeUpdate();
		}
		return result;

	}

	// add Batch
	@Override
	public int addBatch(BatchDTO dto, Connection con) throws SQLException, DatabaseException {

		int result = 0;
		String name = "";
		String tname = dto.getBatch();
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.CHECK_BATCH_NAME);
		int checkTech = 1;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			name = rs.getString(1);
			if (tname.equalsIgnoreCase(name)) {
				checkTech = 0;
				break;
			} else {
				checkTech = 1;
			}
		}
		if (checkTech == 0) {
			return checkTech;
		} else {
			ps = con.prepareStatement(SQLQueryConstants.BATCH_ADD);
			ps.setString(1, dto.getBatch());
			ps.setDate(2, (java.sql.Date) dto.getBatch_start_date());
			ps.setDate(3, (java.sql.Date) dto.getBatch_end_date());
			result = ps.executeUpdate();
		}
		return result;

	}

	@Override
	public List retrieveToUpdate(int bid, Connection con) throws SQLException {

		ResultSet rs = null;
		PreparedStatement ps = null;
		BatchDTO dto = null;
		List l = new ArrayList<>();
		ps = con.prepareStatement(SQLQueryConstants.GET_BATCH_DETAILS_BY_BID);
		ps.setInt(1, bid);
		rs = ps.executeQuery();
		while (rs.next()) {
			dto = new BatchDTO();
			dto.setBatchId(rs.getInt(1));
			dto.setBatch(rs.getString(2));
			dto.setBatch_start_date(rs.getDate(3));
			dto.setBatch_end_date(rs.getDate(4));
			l.add(dto);
		}

		return l;

	} // finally

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java ViewTechnology() method is used to get the data
	 * from technology table.
	 */
	@Override
	public List<TechnologyDTO> viewTechnology(Connection con) throws DatabaseException, SQLException {
		List list = new ArrayList();
		TechnologyDTO tdto = null;
		StatusDTO status = null;
		PreparedStatement pstmt = con.prepareStatement(SQLQueryConstants.VIEW_TECHNOLOGY);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			tdto = new TechnologyDTO();
			status = new StatusDTO();
			tdto.setTechnologyId(rs.getInt(1));
			tdto.setTechnology(rs.getString(2));
			status.setStatusId(rs.getInt(3));
			status.setStatus(rs.getString(4));
			tdto.setStatus(status);
			list.add(tdto);
		}
		return list;
	}

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java editTechnology() method is used to get the data
	 * from HrServiceIMPL class.
	 */
	@Override
	public List<TechnologyDTO> editTechnology(int tid, Connection con) throws SQLException {
		List list = new ArrayList();
		TechnologyDTO tdto = null;
		StatusDTO status = null;
		PreparedStatement pstmt = con.prepareStatement(SQLQueryConstants.EDIT_TECHNOLOGY);
		status = new StatusDTO();
		tdto = new TechnologyDTO();
		pstmt.setInt(1, tid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			tdto.setTechnologyId(rs.getInt(1));
			tdto.setTechnology(rs.getString(2));
			list.add(tdto);
		}
		return list;
	}

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java updateTechnology() method is used to modify the
	 * data in Technology table.
	 */
	@Override
	public int updateTechnology(int techid, String techname, Connection con) throws SQLException {
		String name = "";
		int count = 0;
		PreparedStatement ps = null;
		ps = con.prepareStatement(SQLQueryConstants.CHECK_TECHNOLOGY_NAME);
		int checkTech = 1;
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			name = rs.getString(1);
			if (techname.equalsIgnoreCase(name)) {
				checkTech = 0;
				break;
			} else {
				checkTech = 1;
			}
		}
		if (checkTech == 0) {
			return checkTech;
		} else {
			try {
				PreparedStatement pstmt = con.prepareStatement(SQLQueryConstants.UPDATE_TECHNOLOGY);
				pstmt.setString(1, techname);
				pstmt.setInt(2, techid);
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("duplicate");
			}
		}
		return count;
	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java insertTech method is used to insert the data into
	 * Technology table.
	 */

	@Override
	public Map<Integer, String> getBatches(Connection con) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmtGetBatches = null;
		ResultSet rsBatches = null;
		Map<Integer, String> mapBatches = new HashMap<Integer, String>();
		pstmtGetBatches = con.prepareStatement(SQLQueryConstants.SQL_GET_ASSIGNED_BATCHES);
		rsBatches = pstmtGetBatches.executeQuery();
		while (rsBatches.next()) {
			mapBatches.put(rsBatches.getInt(1), rsBatches.getString(2));
		}
		return mapBatches;
	}

	@Override
	public Map<Integer, String> getAssignedTechnologies(int batchKey, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetTechnologies = null;
		ResultSet rsTechnologies = null;
		Map<Integer, String> mapTechnologies = new HashMap<Integer, String>();
		pstmtGetTechnologies = con.prepareStatement(SQLQueryConstants.SQL_GET_TECHNOLOGIES_ASSIGNED_TO_BATCH);
		pstmtGetTechnologies.setInt(1, batchKey);
		rsTechnologies = pstmtGetTechnologies.executeQuery();
		while (rsTechnologies.next()) {
			mapTechnologies.put(rsTechnologies.getInt(1), rsTechnologies.getString(2));
		}
		return mapTechnologies;
	}

	@Override
	public List<UserDTO> returnTrainees(int batchId, int techId, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetTrainees = null;
		ResultSet rsTrainees = null;
		List<UserDTO> allTRinfoList = new ArrayList<>();
		pstmtGetTrainees = con.prepareStatement(SQLQueryConstants.SQL_GET_TRAINEES);
		pstmtGetTrainees.setInt(1, batchId);
		pstmtGetTrainees.setInt(2, techId);
		rsTrainees = pstmtGetTrainees.executeQuery();
		while (rsTrainees.next()) {
			UserDTO objUserDTO = new UserDTO();

			objUserDTO.setUserid(rsTrainees.getInt(1));
			objUserDTO.setFirstname(rsTrainees.getString(2));
			objUserDTO.setLastname(rsTrainees.getString(3));
			objUserDTO.setMobileNo(rsTrainees.getString(4));
			objUserDTO.setEmail(rsTrainees.getString(5));

			AddressDTO objAddressDTO = new AddressDTO();
			CityDTO objCityDTO = new CityDTO();
			StateDTO objStateDTO = new StateDTO();
			CountryDTO objCountryDTO = new CountryDTO();

			objAddressDTO.setLocation(rsTrainees.getString(6));

			objCityDTO.setCity(rsTrainees.getString(7));

			objStateDTO.setState(rsTrainees.getString(8));

			objCountryDTO.setCountry(rsTrainees.getString(9));

			objStateDTO.setCountry(objCountryDTO);
			objCityDTO.setState(objStateDTO);
			objAddressDTO.setCity(objCityDTO);

			objUserDTO.setAddress(objAddressDTO);

			allTRinfoList.add(objUserDTO);
		}
		return allTRinfoList;

	}

	@Override
	public int deleteTrainee(int userId, Connection con) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmtInactivateTrainee = null;
		int res = 0;
		pstmtInactivateTrainee = con.prepareStatement(SQLQueryConstants.SQL_INAVCTIVATE_USER);
		pstmtInactivateTrainee.setInt(1, userId);
		res = pstmtInactivateTrainee.executeUpdate();
		if (res > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Map<Integer, String> getStreams(int key, Connection con) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement pstmtGetStreams = null;
		ResultSet rsStreams = null;
		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapStreams = new HashMap<Integer, String>();
		pstmtGetStreams = con.prepareStatement(SQLQueryConstants.SQL_GET_STREAMS);
		pstmtGetStreams.setInt(1, key);
		rsStreams = pstmtGetStreams.executeQuery();
		while (rsStreams.next()) {
			// adding countries info into map object
			mapStreams.put(rsStreams.getInt(1), rsStreams.getString(2));
		}
		return mapStreams;
	}

	@Override
	public Map<Integer, String> getSpecializations(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetSpecializations = null;
		ResultSet rsSpecializations = null;
		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapSpecilalizations = new HashMap<Integer, String>();
		// getting countries data from database
		pstmtGetSpecializations = con.prepareStatement(SQLQueryConstants.SQL_GET_SPECIALIZATIONS);
		rsSpecializations = pstmtGetSpecializations.executeQuery();
		while (rsSpecializations.next()) {
			// adding countries info into map object
			mapSpecilalizations.put(rsSpecializations.getInt(1), rsSpecializations.getString(2));
		}
		// returning map of countries information
		return mapSpecilalizations;
	}

	@Override
	public Map<Integer, String> getSpecializations(int key, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetSelectedSpecializations = null;
		ResultSet rsSelectedSpecializations = null;
		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapSelectedSpecilalizations = new HashMap<Integer, String>();
		pstmtGetSelectedSpecializations = con.prepareStatement(SQLQueryConstants.SQL_GET_SELECTED_SPECIALIZATION);
		pstmtGetSelectedSpecializations.setInt(1, key);
		rsSelectedSpecializations = pstmtGetSelectedSpecializations.executeQuery();
		while (rsSelectedSpecializations.next()) {
			// adding countries info into map object
			mapSelectedSpecilalizations.put(rsSelectedSpecializations.getInt(1),
					rsSelectedSpecializations.getString(2));
		}
		// returning map of countries information
		return mapSelectedSpecilalizations;
	}

	@Override
	public Map<BatchDTO, BatchDTO> fetchBatchs(Connection con)
			throws ClassNotFoundException, SQLException, DatabaseException {

		// creating the Hashmap object
		map = new HashMap<>();

		// preparing the query
		ps = con.prepareStatement(SQLQueryConstants.Batch_Query);

		// executing the query
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				map.put(rs.getString(1), rs.getString(2));
			}
		}
		// closing all the objects
		con.close();
		return map;
	}

	@Override
	public Map<TechnologyDTO, TechnologyDTO> getTech(int bid, Connection con)
			throws ClassNotFoundException, SQLException, DatabaseException {

		// creating a map object
		map = new HashMap<>();

		// preparing the query
		ps = con.prepareStatement(SQLQueryConstants.Tech_Query);

		// set value to the query param
		ps.setInt(1, bid);

		// execute the query
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				map.put(rs.getString(1), rs.getString(2));
			}

		}
		// closing all the objects
		con.close();
		return map;
	}

	@Override
	public int storeBatchandTech(int bid, int techid, Connection con) throws SQLException {
		int result = 0;
		// preparing the query
		ps = con.prepareStatement(SQLQueryConstants.Tech_Batch_Query);
		// set value to the query param
		ps.setInt(1, bid);
		ps.setInt(2, techid);
		result = ps.executeUpdate();
		con.close();
		return result;
	}

	@Override
	public List<AssignVo> retAllBatchesAndTechnologies(Connection con) throws SQLException {
		// get the list object
		List<AssignVo> list = new ArrayList<>();
		// prepare the query
		ps = con.prepareStatement(SQLQueryConstants.Ret_Batch_Tech);
		// execute the query
		rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				AssignVo dto = new AssignVo();
				dto.setBatch(rs.getString(1));
				dto.setTechnology(rs.getString(2));

				list.add(dto);
			}
		}
		con.close();
		return list;
	}

	@Override
	public int deleteTech(TechnologyDTO tdto, Connection con) throws SQLException, DatabaseException {
		String msg = " ";

		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.DELETE_TECHNOLOGY);
		ps.setInt(1, 2);
		ps.setInt(2, tdto.getTechnologyId());
		int count = ps.executeUpdate();

		return count;

	}

	@Override
	public List<FeedbackDTO> retriveFeedbacks(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		 List<FeedbackDTO> listdto=null;
		 listdto=new ArrayList();
		pst=con.prepareStatement(SQLQueryConstants.VIEW_HR_FEEDBACKS);
		rs=pst.executeQuery();
		if(rs!=null) {
			//u.first_name,u.mobileno,u.email, f.feedback_description,f.feedback_date,ft.feedback_type,c.client_name ,ct.city,a.location
			while(rs.next()) {
				FeedbackDTO fdto=new FeedbackDTO();
				UserDTO udto=new UserDTO();
				udto.setFirstname(rs.getString("first_name"));
				udto.setMobileNo(rs.getString("mobileno"));
				udto.setEmail(rs.getString("email"));
				ClientDTO cldto=new ClientDTO();
				cldto.setClientName(rs.getString("client_name"));
				CityDTO cdto=new CityDTO();
				cdto.setCity(rs.getString("city"));
				AddressDTO adto=new AddressDTO();
				adto.setLocation(rs.getString("location"));
				adto.setCity(cdto);
				fdto.setUser(udto);
				fdto.setDate(rs.getDate("feedback_date"));
				fdto.setFeedbackMSG(rs.getString("feedback_description"));
				ClientAddressDTO cadto=new ClientAddressDTO();
				cadto.setClient(cldto);
				cadto.setAddress(adto);
				FeedbackTypeDTO ftdto=new FeedbackTypeDTO();
				ftdto.setFeedbackType(rs.getString("feedback_type"));
				fdto.setFeedbacktype(ftdto);
				fdto.setClientaddress(cadto);
				System.out.println(fdto);
				listdto.add(fdto);
			}
			
		}
		return listdto;
	}
		
		@Override
public List<BatchBO> getBatchByHr(Connection con) throws SQLException {
		List lbo= new ArrayList();
		BatchBO bo= null;
		PreparedStatement ps=con.prepareStatement(SQLQueryConstants.getbatchquery);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			bo=new BatchBO();
			bo.setBatchId(rs.getInt(1));
		    bo.setBatch(rs.getString(2));
		   lbo.add(bo);
		}
		System.out.println("batch dao-----"+lbo);
			return lbo;
	}
	

	@Override
	public List<TechnologyBO> getTechnologies(Connection con) throws SQLException {

		TechnologyBO tbo = null;
		List lto = new ArrayList();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.gettechquery);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			tbo = new TechnologyBO();
			tbo.setTechnologyId(rs.getInt(1));
			tbo.setTechnology(rs.getString(2));
			lto.add(tbo);
		}
		System.out.println("getbatch dao--" + tbo);
		return lto;
	}

	@Override
	public List<Integer> getyop(Connection con) throws SQLException {
		List<Integer> yop = new ArrayList();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.yop);
		ResultSet rs = ps.executeQuery();
		int year = 0;
		while (rs.next()) {
			year = rs.getInt(1);
			yop.add(year);
		}
		System.out.println(yop);
		return yop;
	}

	@Override
	public List<String> getSpecilization(Connection con) throws SQLException {
		List<String> special = new ArrayList();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.specialization);
		ResultSet rs = ps.executeQuery();
		String spec = null;
		while (rs.next()) {
			spec = rs.getString(1);
			special.add(spec);
		}
		System.out.println(special);
		return special;
	}

	@Override
	public List<String> getStream(Connection con) throws SQLException {
		List<String> stream = new ArrayList();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.stream);
		ResultSet rs = ps.executeQuery();
		String str = null;
		while (rs.next()) {
			str = rs.getString(1);
			stream.add(str);
		}
		System.out.println(stream);
		return stream;
	}

	@Override
	public List<EducationDetailsBO> viewTraineeDetails(BatchTechnologyDTO btdto, Connection con) throws SQLException {
		System.out.println("dao check");
		/*
		 * UserDTO udto= null; StreamDTO sdto= null; EducationDetailsDTO edto=null;
		 * EducationTypeDTO etdto= null; EducationalTypeDetailsDTO q=null;
		 * SpecializationDTO spdto=null; StreamDTO srdto=null;
		 */

		List<EducationalTypeDetailsBO> listbo = new ArrayList();
		List<EducationDetailsBO> trainee = new ArrayList();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.viewtraineequery);
		ps.setInt(1, btdto.getBatch().getBatchId());
		ps.setInt(2, btdto.getTechnology().getTechnologyId());
		ResultSet rs = ps.executeQuery();

		UserBO ubo = null;

		EducationDetailsBO sscedbo = null;
		EducationDetailsBO hscedbo = null;
		EducationDetailsBO gsedbo = null;
		EducationDetailsBO pgsedbo = null;

		EducationTypeBO sscetbo = null;
		EducationTypeBO hscetbo = null;
		EducationTypeBO gsetbo = null;
		EducationTypeBO pgsetbo = null;

		EducationalTypeDetailsBO ssc = null;
		EducationalTypeDetailsBO hsc = null;
		EducationalTypeDetailsBO graduation = null;
		EducationalTypeDetailsBO postgraduation = null;

		SpecializationBO sssc = null;
		SpecializationBO shsc = null;
		SpecializationBO sgs = null;
		SpecializationBO spgs = null;

		StreamBO ssscbo = null;
		StreamBO shscbo = null;
		StreamBO sgsdbo = null;
		StreamBO spgsbo = null;
		EducationDetailsBO edbo = null;

		Map<Integer, UserBO> dataMap = new HashMap<>();
		Map<Integer, List<EducationalTypeDetailsBO>> userCountMap = new HashMap<>();

		List<EducationalTypeDetailsBO> educationTypeDetailsBOList = null;
		while (rs.next()) {
			System.out.println("year of ---" + rs.getString(8));

			if (dataMap.containsKey(rs.getInt(1))) {
				edbo = new EducationDetailsBO();
				String eduType = rs.getString(4);
				ubo = new UserBO();
				ubo.setUserid(rs.getInt(1));
				ubo.setFirstname(rs.getString(2));
				ubo.setEmail(rs.getString(3));
				System.out.println(ubo);

				edbo.setUserBO(ubo);
				if (eduType.equals("ssc")) {

					System.out.println("ssc in if condition");
					sssc = new SpecializationBO();
					sscetbo = new EducationTypeBO();
					ssscbo = new StreamBO();

					ssc = new EducationalTypeDetailsBO();
					sscetbo.setGraduationType(rs.getString(4));
					ssc.setEducationTypeBO(sscetbo);
					sssc.setSpecialization(rs.getString(5));
					ssscbo.setStream(rs.getString(6));
					sssc.setStreamBO(ssscbo);
					ssc.setPercentage(rs.getFloat(7));
					System.out.println("year of ---" + rs.getString(8));
					ssc.setYop(rs.getInt(8));
					ssc.setEducationTypeBO(sscetbo);
					ssc.setSpecializationBO(sssc);
					// educationTypeDetailsBOList.add(ssc);

					educationTypeDetailsBOList = userCountMap.get(rs.getInt(1));
					educationTypeDetailsBOList.add(ssc);
				} // ssc
				else if (eduType.equals("hsc")) {
					shsc = new SpecializationBO();
					hscetbo = new EducationTypeBO();
					shscbo = new StreamBO();

					hsc = new EducationalTypeDetailsBO();
					hscetbo.setGraduationType(rs.getString(4));
					hsc.setEducationTypeBO(hscetbo);
					shsc.setSpecialization(rs.getString(5));
					shscbo.setStream(rs.getString(6));
					shsc.setStreamBO(shscbo);
					hsc.setPercentage(rs.getFloat(7));
					hsc.setYop(rs.getInt(8));
					hsc.setEducationTypeBO(hscetbo);
					hsc.setSpecializationBO(shsc);
					// listbo.add(hsc);
					educationTypeDetailsBOList = userCountMap.get(rs.getInt(1));
					educationTypeDetailsBOList.add(hsc);
				} // hsc
				else if (eduType.equals("graduation")) {
					sgs = new SpecializationBO();
					sgsdbo = new StreamBO();
					gsetbo = new EducationTypeBO();
					graduation = new EducationalTypeDetailsBO();
					gsetbo.setGraduationType(rs.getString(4));
					graduation.setEducationTypeBO(gsetbo);
					sgs.setSpecialization(rs.getString(5));
					sgsdbo.setStream(rs.getString(6));
					sgs.setStreamBO(sgsdbo);
					graduation.setPercentage(rs.getFloat(7));
					graduation.setYop(rs.getInt(8));
					graduation.setEducationTypeBO(gsetbo);
					graduation.setSpecializationBO(sgs);
					// listbo.add(graduation);
					educationTypeDetailsBOList = userCountMap.get(rs.getInt(1));
					educationTypeDetailsBOList.add(graduation);
				} // gread
				else if (eduType != null & eduType.equals("postgraduation")) {

					pgsetbo = new EducationTypeBO();
					spgs = new SpecializationBO();
					spgsbo = new StreamBO();
					postgraduation = new EducationalTypeDetailsBO();
					pgsetbo.setGraduationType(rs.getString(4));
					postgraduation.setEducationTypeBO(pgsetbo);
					spgs.setSpecialization(rs.getString(5));
					spgsbo.setStream(rs.getString(6));
					spgs.setStreamBO(spgsbo);
					postgraduation.setPercentage(rs.getFloat(7));
					postgraduation.setYop(rs.getInt(8));
					postgraduation.setEducationTypeBO(pgsetbo);
					postgraduation.setSpecializationBO(spgs);
					// listbo.add(postgraduation);
					educationTypeDetailsBOList = userCountMap.get(rs.getInt(1));
					educationTypeDetailsBOList.add(postgraduation);

				} // post

			} else {
				ubo = new UserBO();
				ubo.setUserid(rs.getInt(1));
				ubo.setFirstname(rs.getString(2));
				ubo.setEmail(rs.getString(3));

				educationTypeDetailsBOList = new ArrayList<>();
				edbo = new EducationDetailsBO();
				String eduType = rs.getString(4);

				/*
				 * ubo= new UserBO(); ubo.setUserid(rs.getInt(1));
				 * ubo.setFirstname(rs.getString(2)); ubo.setEmail(rs.getString(3));
				 */
				System.out.println(ubo);

				edbo.setUserBO(ubo);
				if (eduType.equals("ssc")) {

					System.out.println("ssc in else condition");
					sssc = new SpecializationBO();
					sscetbo = new EducationTypeBO();
					ssscbo = new StreamBO();

					ssc = new EducationalTypeDetailsBO();

					sscetbo.setGraduationType(rs.getString(4));
					ssc.setEducationTypeBO(sscetbo);
					sssc.setSpecialization(rs.getString(5));
					ssscbo.setStream(rs.getString(6));
					sssc.setStreamBO(ssscbo);
					ssc.setPercentage(rs.getFloat(7));
					ssc.setYop(rs.getInt(8));
					ssc.setEducationTypeBO(sscetbo);
					ssc.setSpecializationBO(sssc);
					educationTypeDetailsBOList.add(ssc);
				} // ssc
				else if (eduType.equals("hsc")) {
					shsc = new SpecializationBO();
					hscetbo = new EducationTypeBO();
					shscbo = new StreamBO();

					hsc = new EducationalTypeDetailsBO();
					hscetbo.setGraduationType(rs.getString(4));
					hsc.setEducationTypeBO(hscetbo);
					shsc.setSpecialization(rs.getString(5));
					shscbo.setStream(rs.getString(6));
					shsc.setStreamBO(shscbo);
					hsc.setPercentage(rs.getFloat(7));
					hsc.setYop(rs.getInt(8));
					hsc.setEducationTypeBO(hscetbo);
					hsc.setSpecializationBO(shsc);
					educationTypeDetailsBOList.add(hsc);
				} // hsc
				else if (eduType.equals("graduation")) {
					sgs = new SpecializationBO();
					sgsdbo = new StreamBO();
					gsetbo = new EducationTypeBO();
					graduation = new EducationalTypeDetailsBO();
					gsetbo.setGraduationType(rs.getString(4));
					graduation.setEducationTypeBO(gsetbo);
					sgs.setSpecialization(rs.getString(5));
					sgsdbo.setStream(rs.getString(6));
					sgs.setStreamBO(sgsdbo);
					graduation.setPercentage(rs.getFloat(7));
					graduation.setYop(rs.getInt(8));
					graduation.setEducationTypeBO(gsetbo);
					graduation.setSpecializationBO(sgs);
					educationTypeDetailsBOList.add(graduation);

				} // gread
				else if (eduType != null & eduType.equals("postgraduation")) {

					pgsetbo = new EducationTypeBO();
					spgs = new SpecializationBO();
					spgsbo = new StreamBO();
					postgraduation = new EducationalTypeDetailsBO();
					pgsetbo.setGraduationType(rs.getString(4));
					postgraduation.setEducationTypeBO(pgsetbo);
					spgs.setSpecialization(rs.getString(5));
					spgsbo.setStream(rs.getString(6));
					spgs.setStreamBO(spgsbo);
					postgraduation.setPercentage(rs.getFloat(7));
					postgraduation.setYop(rs.getInt(8));
					postgraduation.setEducationTypeBO(pgsetbo);
					postgraduation.setSpecializationBO(spgs);
					educationTypeDetailsBOList.add(postgraduation);
				} // post
				dataMap.put(rs.getInt(1), ubo);
				userCountMap.put(rs.getInt(1), educationTypeDetailsBOList);

			}

			/*
			 * edbo=new EducationDetailsBO(); String eduType=rs.getString(4); ubo= new
			 * UserBO(); ubo.setUserid(rs.getInt(1)); ubo.setFirstname(rs.getString(2));
			 * ubo.setEmail(rs.getString(3)); System.out.println(ubo);
			 * 
			 * edbo.setUserBO(ubo); if(eduType.equals("ssc")) {
			 * 
			 * sssc=new SpecializationBO(); sscetbo= new EducationTypeBO(); ssscbo= new
			 * StreamBO();
			 * 
			 * ssc=new EducationTypeDetailsBO();
			 * sscetbo.setEducationTypeName(rs.getString(4));
			 * ssc.setEducationTypeBO(sscetbo); sssc.setSpecialization(rs.getString(5));
			 * ssscbo.setStream(rs.getString(6)); sssc.setStreamBO(ssscbo);
			 * ssc.setPercentage(rs.getFloat(7)); ssc.setYop(rs.getDate(8));
			 * ssc.setEducationTypeBO(sscetbo); ssc.setSpecializationBO(sssc);
			 * listbo.add(ssc); }//ssc else if(eduType.equals("hsc")) { shsc=new
			 * SpecializationBO(); hscetbo= new EducationTypeBO(); shscbo= new StreamBO();
			 * 
			 * 
			 * hsc=new EducationTypeDetailsBO();
			 * hscetbo.setEducationTypeName(rs.getString(4));
			 * hsc.setEducationTypeBO(hscetbo); shsc.setSpecialization(rs.getString(5));
			 * shscbo.setStream(rs.getString(6)); shsc.setStreamBO(shscbo);
			 * hsc.setPercentage(rs.getFloat(7)); hsc.setYop(rs.getDate(8));
			 * hsc.setEducationTypeBO(hscetbo); hsc.setSpecializationBO(shsc);
			 * listbo.add(hsc); }//hsc else if(eduType.equals("graduation")) { sgs=new
			 * SpecializationBO(); sgsdbo=new StreamBO(); gsetbo= new EducationTypeBO();
			 * graduation=new EducationTypeDetailsBO();
			 * gsetbo.setEducationTypeName(rs.getString(4));
			 * graduation.setEducationTypeBO(gsetbo);
			 * sgs.setSpecialization(rs.getString(5)); sgsdbo.setStream(rs.getString(6));
			 * sgs.setStreamBO(sgsdbo); graduation.setPercentage(rs.getFloat(7));
			 * graduation.setYop(rs.getDate(8)); graduation.setEducationTypeBO(gsetbo);
			 * graduation.setSpecializationBO(sgs); listbo.add(graduation);
			 * 
			 * }//gread else if(eduType!=null & eduType.equals("postgraduation")) {
			 * 
			 * pgsetbo= new EducationTypeBO(); spgs=new SpecializationBO(); spgsbo=new
			 * StreamBO(); postgraduation=new EducationTypeDetailsBO();
			 * pgsetbo.setEducationTypeName(rs.getString(4));
			 * postgraduation.setEducationTypeBO(pgsetbo);
			 * spgs.setSpecialization(rs.getString(5)); spgsbo.setStream(rs.getString(6));
			 * spgs.setStreamBO(spgsbo); postgraduation.setPercentage(rs.getFloat(7));
			 * postgraduation.setYop(rs.getDate(8));
			 * postgraduation.setEducationTypeBO(pgsetbo);
			 * postgraduation.setSpecializationBO(spgs); listbo.add(postgraduation); }//post
			 * 
			 * }//trainee edbo.setEducationTypeDetailsBOList(listbo);
			 * 
			 * System.out.println("for user check"+edbo); trainee.add(edbo);
			 * System.out.println("dao imple data--"+trainee);
			 * System.out.println("---------------------------------");
			 *//* System.out.println("list of trainee details"+trainee); */
		}
		System.out.println("dataMap   user info " + dataMap);

		System.out.println("=============================");

		System.out.println("education map  ...." + userCountMap);

		EducationDetailsBO educationDetailsBO = null;

		Iterator iterator = dataMap.entrySet().iterator();
		Iterator iterator2 = userCountMap.entrySet().iterator();
		while (iterator.hasNext() && iterator2.hasNext()) {
			educationDetailsBO = new EducationDetailsBO();
			Map.Entry<Integer, UserBO> object = (Map.Entry<Integer, UserBO>) iterator.next();
			educationDetailsBO.setUserBO(object.getValue());

			Map.Entry<Integer, List<EducationalTypeDetailsBO>> eduData = (Map.Entry<Integer, List<EducationalTypeDetailsBO>>) iterator2
					.next();
			educationDetailsBO.setEducationalTypeDetailsBOList(eduData.getValue());
			trainee.add(educationDetailsBO);

		}

		System.out.println("trainees details in dao..." + trainee);

		return trainee;

	}// view trainees

	public Map<Integer, Integer> getEligibleUserDetails(Connection con, String[] email)
			throws DatabaseException, SQLException {
		Map usermap = new HashMap();
		con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.getintrestedtrainees);
		String eligibleemail = null;
		for (int i = 0; i < email.length; i++) {
			eligibleemail = email[i];
		}
		ps.setString(1, eligibleemail);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			usermap.put(1, rs.getInt(1));
			usermap.put(2, rs.getInt(2));
		}

		return usermap;
	}

	public InterviewRoundBO getInteviewRounds(Connection con, int jobpostid) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.interviewdetails);
		ps.setInt(1, jobpostid);
		ResultSet rs = ps.executeQuery();
		ClientBO cbo = null;
		JobPostingBO jpbo = null;
		ClientAddressBO caddbo = null;

		InterviewRoundBO interview = null;
		while (rs.next()) {
			cbo = new ClientBO();
			caddbo = new ClientAddressBO();
			jpbo = new JobPostingBO();
			interview = new InterviewRoundBO();
			cbo.setClientName(rs.getString(1));
			caddbo.setClient(cbo);
			jpbo.setClientaddress(caddbo);
			interview.setJobPost(jpbo);
			interview.setRoundNo(rs.getInt(2));
			interview.setRoundId(rs.getInt(3));

			interview.setDescription(rs.getString(4));
			interview.setDate(rs.getDate(5));
		}

		return interview;
	}

	@Override
	public UserBO getSelectedTraineeEmail(Connection con, int userid) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.shortlistedmail);
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		UserBO ubo = null;
		// List mail= new ArrayList();
		while (rs.next()) {
			ubo = new UserBO();
			ubo.setEmail(rs.getString(1));
			// mail.add(ubo);
		}
		System.out.println("dao impl mail id" + ubo);
		return ubo;
	}

	@Override
	public List<UserBO> getSelectedTraiees(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.getselectedtrainees);
		ResultSet rs = ps.executeQuery();
		int userid = 0;
		int interviewid = 0;
		EligibleStudentBO esbo = new EligibleStudentBO();
		UserBO ubo = null;
		UserBO uemails = null;
		List<UserBO> email = new ArrayList();
		InterviewRoundBO ibo = new InterviewRoundBO();
		HrDaoI hr = null;

		ubo = new UserBO();
		while(rs.next())
		{
		userid = rs.getInt(1);
		ubo=new UserBO();
		ubo.setUserid(userid);
		ibo.setRoundId(rs.getInt(2));
		
		/* id.add(ubo); */

		System.out.println("userids---" + rs.getInt(1));
		hr = new HrDaoIMPL();
		uemails = hr.getSelectedTraineeEmail(con, rs.getInt(1));
		email.add(uemails);
		System.out.println("size-----" + email.size());
		}
		for (UserBO usermail : email) {
			ubo.setEmail(usermail.getEmail());
			System.out.println("emaid---********--" + usermail.getEmail());
		}
		/*
		 * for (UserBO userBO : id) { System.out.println(); }
		 */
		System.out.println("dao imple********--" + email);
		return email;

	}

	@Override
	public List<JobPostingBO> getRequirementDetails(Connection con, int pid) throws SQLException {
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.companydetails);
		ps.setInt(1, pid);
		ResultSet rs = ps.executeQuery();
		ClientBO cbo = null;
		LevelBO lbo = null;
		ClientAddressBO cadbo = null;
		AddressBO adbo = null;
		CityBO citbo = null;
		StateBO stbo = null;
		CountryBO coubo = null;
		JobPostingBO jpbo = null;
		List<JobPostingBO> ljpbo = null;
		ljpbo = new ArrayList();
		while (rs.next()) {
			coubo = new CountryBO();
			cbo = new ClientBO();
			lbo = new LevelBO();
			cadbo = new ClientAddressBO();
			adbo = new AddressBO();
			citbo = new CityBO();
			jpbo = new JobPostingBO();
			stbo = new StateBO();

			cbo.setClientName(rs.getString(1));
			lbo.setLevel(rs.getString(2));
			cbo.setCompanyLevel(lbo);
			cbo.setClientDescription(rs.getString(3));

			adbo.setLocation(rs.getString(4));
			citbo.setCity(rs.getString(5));
			stbo.setState(rs.getString(6));
			int pin = rs.getInt(7);
			String cpin = Integer.toString(pin);
			adbo.setPincode(Integer.parseInt(cpin));
			coubo.setCountry(rs.getString(8));
			stbo.setCountry(coubo);
			citbo.setState(stbo);
			adbo.setCity(citbo);
			cadbo.setAddrs(adbo);
			cadbo.setClient(cbo);

			jpbo.setJobPostId(rs.getInt(9));
			jpbo.setClientaddress(cadbo);
			jpbo.setExpectedDate(rs.getDate(10));
			jpbo.setDescription(rs.getString(11));
			jpbo.setVacancies(rs.getInt(12));

			ljpbo.add(jpbo);

		}

		System.out.println(ljpbo);
		return ljpbo;
	}

	@Override
	public int insertEligibleTraiees(Connection con, int userid, int jobpost) throws DatabaseException, SQLException {
		Map<Integer, Integer> getusermap = null;
		int j = 0;
		PreparedStatement ps = con.prepareStatement(SQLQueryConstants.inserteligibletraieens);
		System.out.println(userid);
		ps.setInt(1, 16);
		ps.setInt(2, userid);
		ps.setInt(3, 0);
		ps.setInt(4, jobpost);
		j = ps.executeUpdate();
		System.out.println("updated---" + j);
		ps.close();
		return j;
	}

	
}
