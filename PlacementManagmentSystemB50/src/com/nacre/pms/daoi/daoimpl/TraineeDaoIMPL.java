package com.nacre.pms.daoi.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.TraineeBO;
import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.daoi.TraineeDaoI;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.db_util.SQLQueryConstants;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ShowRoundDataTOTraineeVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to develop the Trainee
 *         Functionalities
 */
public class TraineeDaoIMPL implements TraineeDaoI {
	private String VIEW_TRAINEE_CLIENT_INFO;

	public Map<Integer,String> getfeedbacktype() {
		Map <Integer, String>map=new HashMap<Integer, String>();
		System.out.println("Feedback Type");
		try
		{
			Connection con=DbUtil.getConnection();
			PreparedStatement ps=con.prepareStatement(SQLQueryConstants.GET_FEEDBACK_TYPE);
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				int feedback_type_id=rs.getInt("feedback_type_id");
				System.out.println(feedback_type_id);
				String feedback_type=rs.getString("feedback_type");
				map.put(feedback_type_id,feedback_type);
				System.out.println("dao=="+map);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
		}


	@Override
	public UserDTO getTraineeDetails(int userId) {
		// TODO Auto-generated method stub

		PreparedStatement pstmtTraineeDetails = null;
		ResultSet rsTrainee = null;
		java.sql.Connection con = null;
		// creating Map<Integer,String> object to get all countries data
		UserDTO objUserDTO = new UserDTO();
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtTraineeDetails = con.prepareStatement(SQLQueryConstants.SQL_GET_TRAINEE_BASIC_INFO);
			pstmtTraineeDetails.setInt(1, userId);
			rsTrainee = pstmtTraineeDetails.executeQuery();
			if (rsTrainee.next()) {
				// adding countries info into map object
				objUserDTO.setFirstname(rsTrainee.getString(1));
				objUserDTO.setLastname(rsTrainee.getString(2));
				objUserDTO.setMobileNo(rsTrainee.getString(3));
				objUserDTO.setEmail(rsTrainee.getString(4));

				AddressDTO objAddressDTO = new AddressDTO();
				CityDTO objCityDTO = new CityDTO();
				StateDTO objStateDTO = new StateDTO();
				CountryDTO objCountryDTO = new CountryDTO();

				objCountryDTO.setCountry(rsTrainee.getString(8));
				objStateDTO.setState(rsTrainee.getString(7));
				objCityDTO.setCity(rsTrainee.getString(6));
				objAddressDTO.setLocation(rsTrainee.getString(5));

				objStateDTO.setCountry(objCountryDTO);
				objCityDTO.setState(objStateDTO);
				objAddressDTO.setCity(objCityDTO);

				objUserDTO.setAddress(objAddressDTO);
			}

			return objUserDTO;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return objUserDTO;
		} finally {
			try {
				// flushing objects
				pstmtTraineeDetails.close();
				rsTrainee.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<UserEducationDetailsBO> getTraineeEduDetails(int userId) {
		// TODO Auto-generated method stub

		PreparedStatement pstmtTraineeEduDetails = null;
		ResultSet rsEduTrainee = null;
		java.sql.Connection con = null;
		List<UserEducationDetailsBO> listEducation = new ArrayList<>();

		// creating Map<Integer,String> object to get all countries data
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtTraineeEduDetails = con.prepareStatement(SQLQueryConstants.SQL_GET_TRAINEE_EDU_INFO);
			pstmtTraineeEduDetails.setInt(1, userId);
			rsEduTrainee = pstmtTraineeEduDetails.executeQuery();
			while (rsEduTrainee.next()) {
				UserEducationDetailsBO objUserEducationDetailsBO = new UserEducationDetailsBO();
				objUserEducationDetailsBO.setEduTypeId(rsEduTrainee.getInt(1));
				objUserEducationDetailsBO.setEduTypeName(rsEduTrainee.getString(2));
				objUserEducationDetailsBO.setStreamId(rsEduTrainee.getInt(3));
				objUserEducationDetailsBO.setStreamName(rsEduTrainee.getString(4));
				objUserEducationDetailsBO.setSpecializationId(rsEduTrainee.getInt(5));
				objUserEducationDetailsBO.setSpecializationName(rsEduTrainee.getString(6));
				objUserEducationDetailsBO.setPercentage(rsEduTrainee.getString(7));
				String passedout = rsEduTrainee.getString(8);
				String fullDate[] = passedout.split("-");
				String year = fullDate[0];
				if (year.equals("0001")) {
					year = "0000";
				}
				objUserEducationDetailsBO.setYop(year);
				System.out.println("disp" + rsEduTrainee.getString(8));
				listEducation.add(objUserEducationDetailsBO);
			}
			return listEducation;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtTraineeEduDetails.close();
				rsEduTrainee.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public String updateEducation(List<EducationDetailsDTO> listEducation, Integer userId) {
		// TODO Auto-generated method stub

		PreparedStatement pstmtDeleteEducation = null;
		PreparedStatement pstmtAddEducation = null;
		PreparedStatement pstmtRemoveEducation = null;
		PreparedStatement pstmtInsertEducation = null;
		java.sql.Connection con = null;
		// creating Map<Integer,String> object to get all countries data
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			con.setAutoCommit(false);
			pstmtDeleteEducation = con.prepareStatement(SQLQueryConstants.SQL_DELETE_EDUCATION);
			pstmtRemoveEducation = con.prepareStatement(SQLQueryConstants.SQL_DELETE_EDUCATION_DETAILS);
			pstmtRemoveEducation.setInt(1, userId);
			pstmtDeleteEducation.setInt(1, userId);
			pstmtDeleteEducation.executeUpdate();
			pstmtRemoveEducation.executeUpdate();
			pstmtInsertEducation = con.prepareStatement(SQLQueryConstants.SQL_INSERT_EDUCATION,
					Statement.RETURN_GENERATED_KEYS);
			int count = 0;
			Iterator<EducationDetailsDTO> iteratorEducation = listEducation.iterator();
			while (iteratorEducation.hasNext()) {
				EducationDetailsDTO objEducationDetailsDTO = iteratorEducation.next();
				pstmtInsertEducation.setInt(1, userId);
				pstmtInsertEducation.setFloat(2, Float.parseFloat(objEducationDetailsDTO.getPercentGrade()));
				pstmtInsertEducation.setString(3, objEducationDetailsDTO.getYearOfPass());
				pstmtInsertEducation.setInt(4, objEducationDetailsDTO.getObjSpecializationDTO().getSpecializationId());
				pstmtInsertEducation.setInt(5, objEducationDetailsDTO.getEducationType().getGraduDetailsId());
				int c = pstmtInsertEducation.executeUpdate();
				System.out.println("inerting");
				if (c > 0) {
					ResultSet rsKey = pstmtInsertEducation.getGeneratedKeys();
					rsKey.next();
					int insertedId = rsKey.getInt(1);

					pstmtAddEducation = con.prepareStatement(SQLQueryConstants.SQL_INSERT_EDUCATION_DETAILS);
					pstmtAddEducation.setInt(1, insertedId);
					pstmtAddEducation.setInt(2, userId);
					int co = pstmtAddEducation.executeUpdate();
					if (co > 0) {
						count++;
					}
				}
			}
			if (count >= 0) {
				con.commit();
				System.out.println("commited");
				return "Details Updated Successfully";

			} else {
				con.rollback();
				System.out.println("rollback");
				return "Problem Occurred.. Try Again Later..";
			}
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtInsertEducation.close();
				pstmtDeleteEducation.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static Connection connection = null;

	ResultSet rs = null;
	List<Object> list = new ArrayList<>();

	@SuppressWarnings("null")
	@Override
	public List<Object> getClientData(Connection con,int id) throws SQLException, DatabaseException {
		PreparedStatement pst = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, String> map = null;

		JobPostingDTO jdto = null;
		ClientAddressDTO adto = null;
		ClientDTO cdto = null;
		AddressDTO aadto = null;
		UserDTO udto = null;
		CityDTO ct = null;
		StateDTO stdto = null;
		CountryDTO cntdto = null;

		// System.out.println("hiiiiiiii");

		try {
			pst = con.prepareStatement(SQLQueryConstants.VIEW_TRAINEE_CLIENT_INFO);
			pst.setInt(1, id);
			rs = pst.executeQuery();

			while (rs.next()) {

				jdto = new JobPostingDTO();
				adto = new ClientAddressDTO();
				cdto = new ClientDTO();
				aadto = new AddressDTO();
				udto = new UserDTO();
				ct = new CityDTO();
				stdto = new StateDTO();
				cntdto = new CountryDTO();

				cdto.setClientName(rs.getString(1));
				cdto.setClientDescription(rs.getString(2));
				jdto.setExpectedDate(rs.getDate(3));
				jdto.setDescription(rs.getString(4));
				jdto.setVacancies(rs.getInt(5));
				adto.setContactPresonName(rs.getString(6));
				adto.setContactPresonMobileNO(rs.getString(7));

				adto.setContactPresonNameEmail(rs.getString(8));
				udto.setFirstname(rs.getString(9));
				udto.setLastname(rs.getString(10));
				aadto.setLocation(rs.getString(11));
				aadto.setPincode(rs.getInt(12));
				ct.setCity(rs.getString(13));
				jdto.setJobPostId(rs.getInt(14));
				stdto.setState(rs.getString(15));
				cntdto.setCountry(rs.getString(16));
				cntdto.setCountryId(rs.getInt(17));

				// System.out.println(adto.toString());
				// System.out.println(udto.toString());
				// System.out.println(aadto.toString());
				// System.out.println(ct.toString());

				list.add(adto);
				list.add(jdto);
				list.add(cdto);
				list.add(aadto);
				list.add(udto);
				list.add(ct);
				list.add(stdto);
				list.add(cntdto);

			}

			System.out.println("dao issss" + list);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateEducationNewMethod(List<EducationDetailsDTO> listEducation, Integer userId) {
		// TODO Auto-generated method stub

		PreparedStatement pstmtUpdateEducation = null;
		java.sql.Connection con = null;
		// creating Map<Integer,String> object to get all countries data
		try {
			// getting countries data from database
			int count = 0;
			con = DbUtil.getConnection();

			Iterator<EducationDetailsDTO> iteratorEducation = listEducation.iterator();
			while (iteratorEducation.hasNext()) {
				EducationDetailsDTO objEducationDetailsDTO = iteratorEducation.next();

				pstmtUpdateEducation = con.prepareStatement(SQLQueryConstants.SQL_UPDATE_EDUCATION_NEW);
				pstmtUpdateEducation.setFloat(1, Float.parseFloat(objEducationDetailsDTO.getPercentGrade()));
				pstmtUpdateEducation.setString(2, objEducationDetailsDTO.getYearOfPass());
				pstmtUpdateEducation.setInt(3, objEducationDetailsDTO.getObjSpecializationDTO().getSpecializationId());
				pstmtUpdateEducation.setInt(4, userId);
				pstmtUpdateEducation.setInt(5, objEducationDetailsDTO.getEducationType().getGraduDetailsId());
				int c = pstmtUpdateEducation.executeUpdate();
				pstmtUpdateEducation.close();
				if (c > 0) {
					count++;
				}
			}
			System.out.println("updating");
			if (count > 0) {
				return "Details Updated Successfully";
			} else {
				return "Problem Occurred.. Try Again Later..";
			}
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				// pstmtUpdateEducation.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int  setStatusFeedback(StatusDTO sdto, JobPostingDTO jdto, FeedbackDTO fdto,int uid)
			throws SQLException, DatabaseException {
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.SET_NOT_INTRESTED_TRAINEE_DESCRIPTION);
		pst.setString(1, fdto.getFeedbackMSG());
		pst.setInt(2, sdto.getStatusId());
		// in index number 3 we have to set session id of trainee
		pst.setInt(3, uid);
		pst.setInt(4, jdto.getJobPostId());
		int count = pst.executeUpdate();
		if (count == 1) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		return count;

	}

	@Override
	public int setStatus(StatusDTO sdto, JobPostingDTO jdto,int uid) throws SQLException, DatabaseException {
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.SET_INTERESTED_TRAINEE_STATUS);
		System.out.println("UIIIDDDDDDDDDDDDDDDDCHECKING"+uid);
		System.out.println("UIIIDDDDDDDDDDDDDDDDCHECKING"+sdto.getStatusId());
		System.out.println("UIIIDDDDDDDDDDDDDDDDCHECKING"+jdto.getJobPostId());
		pst.setInt(1, sdto.getStatusId());
		pst.setInt(2, uid);
		pst.setInt(3, jdto.getJobPostId());
		int count = pst.executeUpdate();
		
		return count;
	}
	
	

	@Override
	public void setReadNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException {
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.SET_READ_NOTIFICATION);
		pst.setInt(1, sdto.getStatusId());
		pst.setInt(2, id);
		int count = pst.executeUpdate();
	}

	@Override
	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto,int id) throws SQLException, DatabaseException {
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.SET_READ_SINGLE_NOTIFICATION);
		pst.setInt(1, sdto.getStatusId());
		pst.setInt(2, id);
		pst.setInt(3, jdto.getJobPostId());
		int count = pst.executeUpdate();
	}

	PreparedStatement pst = null;

	@Override
	public List<ShowRoundDataTOTraineeVO> getRoundDataToShowTrainee(int id) throws SQLException, DatabaseException {

		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.SHOW_ROUND_NOTIFICATION_TO_TRAINEE);
		// in index one Trainee id will be in the form of session
		pst.setInt(1, id);
        pst.setInt(2, 7);
		ResultSet rs = pst.executeQuery();
		List<ShowRoundDataTOTraineeVO> list = new ArrayList<>();
		ShowRoundDataTOTraineeVO roundvo = null;
		while (rs.next()) {
			roundvo = new ShowRoundDataTOTraineeVO();

			roundvo.setRoundNo(rs.getInt(1));
			roundvo.setDescription(rs.getString(2));
			roundvo.setDate(rs.getDate(3));
			roundvo.setLocation(rs.getString(4));
			roundvo.setPincode(Integer.toString(rs.getInt(5)));
			roundvo.setCity(rs.getString(6));
			roundvo.setState(rs.getString(7));
			roundvo.setCountry(rs.getString(8));
			roundvo.setClientName(rs.getString(9));
			roundvo.setJob_post_id(rs.getInt(10));
			roundvo.setNot_status_id(rs.getInt(11));
			list.add(roundvo);

			System.out.println("clientname---" + rs.getString(9));

		}
		// System.out.println("List data "+list.size());

		return list;

	}

	@Override
	public void setReadRoundNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException {
		// TODO Auto-generated method stub
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.ROOUND_ID_ROUND_NOTIFICATION);
		// here will be session user id
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.Read_ALL_NOTIFICATION_);
			pst.setInt(1, sdto.getStatusId());
			pst.setInt(2, rs.getInt(1));
			int count = pst.executeUpdate();
		}

	}

	@Override
	public void setReadRoundNotification(StatusDTO sdto, JobPostingDTO jdto, InterviewRoundDTO irdto,int id)
			throws SQLException, DatabaseException {
		pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.GET_SINGLE_TRAINEE_ROUND_ID);
		pst.setInt(1, irdto.getRoundNo());
		pst.setInt(2, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			pst = DbUtil.getConnection().prepareStatement(SQLQueryConstants.Read_Single_ROUND_NOTIFICATION);
			pst.setInt(1, sdto.getStatusId());
			pst.setInt(2, rs.getInt(1));
			pst.setInt(3, jdto.getJobPostId());
			int count = pst.executeUpdate();
		}
	}

	public Map<Integer, String> getClientName(int clientid) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("Client Name");
		try {
			Connection con = DbUtil.getConnection();
			if (clientid == 2) {
				PreparedStatement ps = con.prepareStatement(SQLQueryConstants.GET_CLIENT_NAME);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int client_address_id = rs.getInt("client_address_id");
					System.out.println(client_address_id);
					String client_name = rs.getString("client_name");
					System.out.println("clientnamedao==" + client_name);
					map.put(client_address_id, client_name);
					System.out.println("dao==" + map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// this method is for editing trainee
	@Override
	public TraineeBO getTraineeForEdit(String email, Connection con) {
		TraineeBO bo = null;
		bo = new TraineeBO();
		try {
			con = DbUtil.getConnection();
			pst = con.prepareStatement(SQLQueryConstants.GET_PREVIOUS_TRAINEE_DETAILS);
			pst.setString(1, email);
			rs = pst.executeQuery();
			while (rs.next()) {
				bo.setUserId(rs.getInt(1));
				bo.setFirstName(rs.getString(2));
				bo.setLastName(rs.getString(3));
				bo.setMobno(rs.getLong(4));
				bo.setDob(rs.getDate(5));
				bo.setPincode(rs.getInt(6));
				bo.setLocation(rs.getString(7));
				bo.setCity(rs.getString(8));
				bo.setState(rs.getString(9));
				bo.setCountry(rs.getString(10));
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bo;
	}

	HashMap map;

	@Override
	public Map<Integer, String> getCountry(Connection con) {

		try {
			pst = con.prepareStatement(SQLQueryConstants.GET_COUNTRY);
			rs = pst.executeQuery();
			map = new HashMap();
			while (rs.next()) {
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				map.put(cid, cname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Integer, String> getState(Connection con, int country_id) {
		try {
			pst = con.prepareStatement(SQLQueryConstants.GET_STATE);
			pst.setInt(1, country_id);
			rs = pst.executeQuery();
			map = new HashMap();
			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				map.put(sid, sname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Integer, String> getCity(Connection con, int state_id) {
		try {
			pst = con.prepareStatement(SQLQueryConstants.GET_CITY);
			pst.setInt(1, state_id);
			rs = pst.executeQuery();
			map = new HashMap();
			while (rs.next()) {
				int cid = rs.getInt(1);
				String cname = rs.getString(2);
				map.put(cid, cname);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int updateTraineeDetails(Connection con, TraineeBO bo) {
		int res = 0;
		try {
			pst = con.prepareStatement(SQLQueryConstants.UPDATE_TRAINEE_DETAILS);
			pst.setString(1, bo.getFirstName());
			pst.setString(2, bo.getLastName());
			pst.setLong(3, bo.getMobno());
			pst.setString(4, bo.getImage());
			pst.setDate(5, bo.getDob());
			pst.setString(6, bo.getLocation());
			pst.setInt(7, bo.getPincode());
			pst.setInt(8, Integer.parseInt(bo.getCity()));
			pst.setInt(9, Integer.parseInt(bo.getState()));
			pst.setInt(10, Integer.parseInt(bo.getCountry()));
			pst.setString(11, bo.getEmail());
			System.out.println(pst);
			res = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int[] insertTraineesByBatchProcess(List<TraineeBO> listBO, Connection con) {
		int[] result = new int[listBO.size()];
		System.out.println(listBO);
		listBO.forEach(bo -> {
			int cnt = 0;
			int addrsId = 0, addRes = 0;
			int uid = 0, userRes = 0;
			int sscid = 0, sscRes = 0;
			int hseid = 0, hseRes = 0;
			int grdid = 0, grdRes = 0;
			int pgId = 0, pgRes = 0;
			int[] edres = null;
			try {
				con.setAutoCommit(false);
				// register addrs details
				PreparedStatement INSERT_ADDRS = con.prepareStatement(SQLQueryConstants.INSERT_ADDRESS_QUERY,
						Statement.RETURN_GENERATED_KEYS);
				INSERT_ADDRS.setString(1, bo.getLocation());
				INSERT_ADDRS.setInt(2, bo.getPincode());
				INSERT_ADDRS.setString(3, bo.getCity());
				addRes = INSERT_ADDRS.executeUpdate();
				ResultSet rs1 = INSERT_ADDRS.getGeneratedKeys();
				if (rs1.next()) {
					addrsId = rs1.getInt(1);
				}
				// register trainee data
				PreparedStatement INSERT_TRAINEE = con.prepareStatement(SQLQueryConstants.INSERT_TRAINEE_DATA,
						Statement.RETURN_GENERATED_KEYS);
				INSERT_TRAINEE.setString(1, bo.getFirstName());
				INSERT_TRAINEE.setString(2, bo.getLastName());
				INSERT_TRAINEE.setString(3, bo.getEmail());
				INSERT_TRAINEE.setString(4, bo.getPassword());
				INSERT_TRAINEE.setLong(5, bo.getMobno());
				INSERT_TRAINEE.setInt(6, bo.getGender());
				INSERT_TRAINEE.setString(7, bo.getImage());
				INSERT_TRAINEE.setDate(8, bo.getDob());
				INSERT_TRAINEE.setInt(9, 3);// roll id is 3
				INSERT_TRAINEE.setInt(10, 1);// by default active
				INSERT_TRAINEE.setInt(11, addrsId);
				INSERT_TRAINEE.setString(12, bo.getBatchName());
				INSERT_TRAINEE.setString(13, bo.getTechnology());
				userRes = INSERT_TRAINEE.executeUpdate();
				ResultSet rs2 = INSERT_TRAINEE.getGeneratedKeys();
				if (rs2.next()) {
					uid = rs2.getInt(1);
				}
				// register ssc details
				PreparedStatement INSERT_SSC_DETAILS = con.prepareStatement(
						SQLQueryConstants.INSERT_SSC_HSC_EDUCATION_DETAILS, Statement.RETURN_GENERATED_KEYS);
				INSERT_SSC_DETAILS.setInt(1, uid);
				INSERT_SSC_DETAILS.setFloat(2, bo.getSscPercentage());
				INSERT_SSC_DETAILS.setInt(3, bo.getSscYop());
				INSERT_SSC_DETAILS.setInt(4, 1);// ssc type id is 1
				INSERT_SSC_DETAILS.setInt(5,1);// ssc type id is 1
				sscRes = INSERT_SSC_DETAILS.executeUpdate();
				ResultSet rs3 = INSERT_SSC_DETAILS.getGeneratedKeys();
				if (rs3.next()) {
					sscid = rs3.getInt(1);
				}
				// register hse details
				PreparedStatement INSERT_HSE_DETAILS = con.prepareStatement(
						SQLQueryConstants.INSERT_SSC_HSC_EDUCATION_DETAILS, Statement.RETURN_GENERATED_KEYS);
				INSERT_HSE_DETAILS.setInt(1, uid);
				INSERT_HSE_DETAILS.setFloat(2, bo.getHsePercentage());
				INSERT_HSE_DETAILS.setInt(3, bo.getHseYop());
				INSERT_HSE_DETAILS.setInt(4, 2);// Hse type id is 2
				INSERT_HSE_DETAILS.setInt(5,2);// Hse type id is 2
				hseRes = INSERT_HSE_DETAILS.executeUpdate();
				ResultSet rs4 = INSERT_HSE_DETAILS.getGeneratedKeys();
				if (rs4.next()) {
					hseid = rs4.getInt(1);

				}
				// register graduation details
				PreparedStatement INSERT_GRD_DETAILS = con.prepareStatement(
						SQLQueryConstants.INSERT_G_PG_EDUCATION_DETAILS, Statement.RETURN_GENERATED_KEYS);
				INSERT_GRD_DETAILS.setInt(1, uid);
				INSERT_GRD_DETAILS.setFloat(2, bo.getGraduationPercentage());
				INSERT_GRD_DETAILS.setInt(3, bo.getGraduationYop());
				INSERT_GRD_DETAILS.setInt(4, 3);// graduation type id is 3
				INSERT_GRD_DETAILS.setString(5, bo.getGraduationSpecialization());
				grdRes = INSERT_GRD_DETAILS.executeUpdate();
				ResultSet rs5 = INSERT_GRD_DETAILS.getGeneratedKeys();
				if (rs5.next()) {
					grdid = rs5.getInt(1);
				}
				// register post graduation details
				if (!((String) bo.getPostGraduationSpecialization() == null)) {
					PreparedStatement INSERT_PG_DETAILS = con.prepareStatement(
							SQLQueryConstants.INSERT_G_PG_EDUCATION_DETAILS, Statement.RETURN_GENERATED_KEYS);
					INSERT_PG_DETAILS.setInt(1, uid);
					INSERT_PG_DETAILS.setFloat(2, bo.getPostGraduationPercentage());
					INSERT_PG_DETAILS.setInt(3, bo.getPostGraduationYop());
					INSERT_PG_DETAILS.setInt(4, 4);// postgraduation type id is 4
					INSERT_PG_DETAILS.setString(5, bo.getPostGraduationSpecialization());
					pgRes = INSERT_PG_DETAILS.executeUpdate();
					ResultSet rs6 = INSERT_PG_DETAILS.getGeneratedKeys();
					if (rs6.next()) {
						pgId = rs5.getInt(1);
					}
				}
				// add total education details
				edres = new int[4];
				PreparedStatement ps1 = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
				ps1.setInt(1, sscid);
				ps1.setInt(2, uid);				 
				edres[0] = ps1.executeUpdate();
				PreparedStatement ps2 = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
				ps2.setInt(2, uid);
				ps2.setInt(1, hseid);
				edres[1] = ps2.executeUpdate();

				PreparedStatement ps3 = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
				ps3.setInt(2, uid);
				ps3.setInt(1, grdid);
				edres[2] = ps3.executeUpdate();
				if (!(pgId == 0)) {
					PreparedStatement ps4 = con.prepareStatement(SQLQueryConstants.INSERT_EDUCATION_DETAILS);
					ps4.setInt(2, uid);
					ps4.setInt(1, pgId);
					edres[3] = ps4.executeUpdate();
				}
				if (addRes >= 0 && grdRes >= 0 && sscRes >= 0 && hseRes >= 0 && userRes >= 0 && edres[0] == 1
						&& edres[1] == 1 && edres[2] == 1) {
					con.commit();
				} else {
					// con.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return result;
	}

	public Map<Integer, String> getClientName(int clientid, int userId) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("Client Name");
		try {
			Connection con = DbUtil.getConnection();
			if (clientid == 2) {
				PreparedStatement ps = con
						.prepareStatement(SQLQueryConstants.SQL_GET_PLACEMENT_INFO_OF_USER_FOR_FEEDBACK);
				ps.setInt(1, userId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int client_address_id = rs.getInt("client_address_id");
					System.out.println(client_address_id);
					String client_name = rs.getString("client_name");
					System.out.println("clientnamedao==" + client_name);
					map.put(client_address_id, client_name);
					System.out.println("dao==" + map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int addFeedBack(FeedbackDTO objFeedbackDTO) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtAddFeedback = null;
		Connection con = null;
		try {
			con = DbUtil.getConnection();
			if (objFeedbackDTO.getFeedbacktype().getFeedbackTypeId() == 1) {
				// nacre
				pstmtAddFeedback = con.prepareStatement(SQLQueryConstants.SQL_ADD_FEEDBACK_FOR_NACRE);
				pstmtAddFeedback.setString(1, objFeedbackDTO.getFeedbackMSG());
				pstmtAddFeedback.setDate(2, objFeedbackDTO.getDate());
				pstmtAddFeedback.setInt(3, objFeedbackDTO.getFeedbacktype().getFeedbackTypeId());
				pstmtAddFeedback.setInt(4, objFeedbackDTO.getUser().getUserid());
			} else if (objFeedbackDTO.getFeedbacktype().getFeedbackTypeId() == 2) {
				// company
				pstmtAddFeedback = con.prepareStatement(SQLQueryConstants.SQL_ADD_FEEDBACK_FOR_COMPANY);
				pstmtAddFeedback.setString(1, objFeedbackDTO.getFeedbackMSG());
				pstmtAddFeedback.setDate(2, objFeedbackDTO.getDate());
				pstmtAddFeedback.setInt(3, objFeedbackDTO.getFeedbacktype().getFeedbackTypeId());
				pstmtAddFeedback.setInt(4, objFeedbackDTO.getClientaddress().getClientAddressId());
				pstmtAddFeedback.setInt(5, objFeedbackDTO.getUser().getUserid());
			} else {
			}

			int res = pstmtAddFeedback.executeUpdate();
			if (res > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred
			return 0;
		} finally {
			try {
				// flushing objects
				pstmtAddFeedback.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
