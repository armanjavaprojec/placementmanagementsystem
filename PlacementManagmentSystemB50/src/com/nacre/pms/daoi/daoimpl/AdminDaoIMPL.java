package com.nacre.pms.daoi.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;
import com.nacre.pms.bo.AddressBO;
import com.nacre.pms.bo.CityBO;
import com.nacre.pms.bo.ClientAddressBO;
import com.nacre.pms.bo.ClientBO;
import com.nacre.pms.bo.CountryBO;
import com.nacre.pms.bo.ProfileBO;
import com.nacre.pms.bo.StateBO;
import com.nacre.pms.daoi.AdminDaoI;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.db_util.SQLQueryConstants;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.PlacementDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to develop the Admin
 *         functionalities
 */
public class AdminDaoIMPL implements AdminDaoI {
	Connection con = null;
	ResultSet result = null;
	PreparedStatement pst = null;
	PreparedStatement level_pst = null;
	PreparedStatement status_pst = null;
	PreparedStatement country_pst = null;
	PreparedStatement state_pst = null;
	PreparedStatement city_pst = null;
	PreparedStatement reg_client_pst = null;
	PreparedStatement reg_add_pst = null;
	PreparedStatement reg_client_add_pst = null;
	PreparedStatement retrieve_client_detail = null;
	PreparedStatement update_client_pst = null;
	PreparedStatement user_profile_pst = null;
	
	int rs = 0;
	Map<Integer, String> map = null;

	@Override
	public int addClient(ClientBO bo,Connection con) throws DatabaseException, SQLException {
		int clientId = 0;
		int addId = 0;
	
		reg_client_pst = con.prepareStatement(SQLQueryConstants.CLIENT_REGISTER_DETAILS,
				Statement.RETURN_GENERATED_KEYS);
		reg_add_pst = con.prepareStatement(SQLQueryConstants.ADDRESS_REGISTER_DETAILS, Statement.RETURN_GENERATED_KEYS);
		reg_client_add_pst = con.prepareStatement(SQLQueryConstants.CLIENT_ADDRESS_REGISTER_DETAILS);
		reg_client_pst.setString(1, bo.getClientName());
		reg_client_pst.setString(2, bo.getClientImage());
		reg_client_pst.setString(3, bo.getClientDescription());
		reg_client_pst.setInt(4, Integer.parseInt(bo.getLevel()));
		reg_client_pst.setInt(5, 1);
		reg_client_pst.executeUpdate();
		ResultSet rs_client = reg_client_pst.getGeneratedKeys();
		if (rs_client.next()) {
			clientId = rs_client.getInt(1);
		}
		reg_add_pst.setString(1, bo.getLocation());
		reg_add_pst.setInt(2, bo.getPincode());
		reg_add_pst.setInt(3, Integer.parseInt(bo.getCity()));
		reg_add_pst.executeUpdate();
		ResultSet rs_addrs = reg_add_pst.getGeneratedKeys();
		if (rs_addrs.next()) {
			addId = rs_addrs.getInt(1);
		}
		reg_client_add_pst.setString(1, bo.getPersonName());
		reg_client_add_pst.setLong(2, bo.getPersonMobile());
		reg_client_add_pst.setString(3, bo.getPersonEmail());
		reg_client_add_pst.setInt(4, clientId);
		reg_client_add_pst.setInt(5, addId);
		rs = reg_client_add_pst.executeUpdate();
		return rs;
	}

	@Override
	public Map<Integer, String> getCountry(Connection con) {
		try {
			
			country_pst = con.prepareStatement(SQLQueryConstants.Country_Get_Data);
			result = country_pst.executeQuery();
			map = new HashMap<Integer, String>();
			while (result.next()) {
				map.put(result.getInt(1), result.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Integer, String> getState(CountryDTO countryDto,Connection con) {
		try {
			con = DbUtil.getConnection();
			state_pst = con.prepareStatement(SQLQueryConstants.STATE_Get_Data);
			state_pst.setInt(1, countryDto.getCountryId());
			result = state_pst.executeQuery();

			map = new HashMap<Integer, String>();

			while (result.next()) {

				System.out.println(result.getInt(1) + ":" + result.getString(2));
				map.put(result.getInt(1), result.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Integer, String> getCity(StateDTO stateDto,Connection con) {
		try {
			con = DbUtil.getConnection();
			city_pst = con.prepareStatement(SQLQueryConstants.CITY_Get_Data);
			city_pst.setInt(1, stateDto.getStateId());
			result = city_pst.executeQuery();

			map = new HashMap<Integer, String>();

			while (result.next()) {

				System.out.println(result.getInt(1) + ":" + result.getString(2));
				map.put(result.getInt(1), result.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<Integer, String> getLevel(Connection con) {
		try {
			con = DbUtil.getConnection();
			level_pst = con.prepareStatement(SQLQueryConstants.LEVEL_Get_Data);
			result = level_pst.executeQuery();

			map = new HashMap<Integer, String>();

			while (result.next()) {

				System.out.println(result.getInt(1) + ":" + result.getString(2));
				map.put(result.getInt(1), result.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<ClientBO> viewClientDetails(Connection con) throws DatabaseException, SQLException {
		List<ClientBO> list = new ArrayList<>();
		ClientBO clientBo = null;
		con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(SQLQueryConstants.RETRIEVE_CLIENT_DETAILS);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			clientBo = new ClientBO();
			clientBo.setClientId(result.getInt(1));
			clientBo.setClientName(result.getString(2));
			clientBo.setClientDescription(result.getString(3));
			clientBo.setLevel(result.getString(4));
			list.add(clientBo);

		}

		return list;
	}

	//
	@Override
	public int deleteClientDao(int clientId,Connection con) {
		// int userId = 0;
		int count = 0;
		try {
			con = DbUtil.getConnection();
			pst = con.prepareStatement(SQLQueryConstants.DELETE_CLIENT_DATA_QUERY);
			pst.setInt(1, clientId);
			count = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public ClientBO showClientDetailDao(int clientId,Connection con) throws DatabaseException, SQLException {
		ClientBO clientBo = null;
		con = DbUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(SQLQueryConstants.SHOW_CLIENT_DETAILS);
		pstmt.setInt(1, clientId);
		ResultSet result = pstmt.executeQuery();
		while (result.next()) {
			clientBo = new ClientBO();
			clientBo.setClientId(result.getInt(1));
			clientBo.setClientName(result.getString(2));
			clientBo.setClientDescription(result.getString(3));
			clientBo.setLevel(result.getString(4));
		}
		return clientBo;
	}

	@Override
	public int updateClientDetail(ClientBO bo,Connection con) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		update_client_pst = con.prepareStatement(SQLQueryConstants.UPDATE_CLIENT);
		// register client and get client id by auto generated key
		update_client_pst.setString(1, bo.getClientName());
		update_client_pst.setString(2, bo.getClientImage());
		update_client_pst.setString(3, bo.getClientDescription());
		update_client_pst.setInt(4, Integer.parseInt(bo.getLevel()));
		update_client_pst.setInt(5, bo.getClientId());
		rs = update_client_pst.executeUpdate();
		return rs;
	}

	@Override
	public List<ClientAddressBO> viewClientAddrsDetails(int clientId, Connection con) {
		List<ClientAddressBO> list = new ArrayList<>();
		ClientAddressBO addrsBo = null;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(SQLQueryConstants.GET_LIST_CLINET_ADDRS);
			pstmt.setInt(1, clientId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				addrsBo = new ClientAddressBO();
				addrsBo.setClientAddressId(result.getInt("client_address_id"));
				addrsBo.setContactPresonName(result.getString("contact_person_name"));
				addrsBo.setContactPresonMobileNO(((Long) result.getLong("contact_person_mobile")).toString());
				addrsBo.setContactPresonNameEmail(result.getString("contact_person_email"));
				CountryBO ctyBo = new CountryBO();
				ctyBo.setCountry(result.getString("country"));
				StateBO sbo = new StateBO();
				sbo.setState(result.getString("state"));
				sbo.setCountry(ctyBo);
				CityBO cityBo = new CityBO();
				cityBo.setCity(result.getString("city"));
				cityBo.setState(sbo);
				AddressBO abo = new AddressBO();
				abo.setPincode( result.getInt("pincode"));
				abo.setLocation(result.getString("location"));
				abo.setCity(cityBo);
				addrsBo.setAddrs(abo);
				list.add(addrsBo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ClientAddressBO getClientAddresEditData(int caddrsId, Connection con) {
		ClientAddressBO addrsBo = null;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(SQLQueryConstants.SHOW_CLIENT_ADDRS_DETAILS);
			pstmt.setInt(1, caddrsId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				addrsBo = new ClientAddressBO();
				addrsBo.setClientAddressId(result.getInt("client_address_id"));
				addrsBo.setContactPresonName(result.getString("contact_person_name"));
				addrsBo.setContactPresonMobileNO(((Long) result.getLong("contact_person_mobile")).toString());
				addrsBo.setContactPresonNameEmail(result.getString("contact_person_email"));
				CountryBO ctyBo = new CountryBO();
				ctyBo.setCountry(result.getString("country"));
				StateBO sbo = new StateBO();
				sbo.setState(result.getString("state"));
				sbo.setCountry(ctyBo);
				CityBO cityBo = new CityBO();
				cityBo.setCity(result.getString("city"));
				cityBo.setState(sbo);
				AddressBO abo = new AddressBO();
				abo.setPincode( result.getInt("pincode"));
				abo.setLocation(result.getString("location"));
				abo.setCity(cityBo);
				addrsBo.setAddrs(abo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addrsBo;
	}

	@Override
	public int updateClientAddrsDetails(ClientAddressBO bo, Connection con) {
		try {
			System.out.println(bo);
			pst = con.prepareStatement(SQLQueryConstants.UPDATE_CLIENT_ADDRS);
			pst.setString(1, bo.getContactPresonName());
			pst.setLong(2, Long.parseLong(bo.getContactPresonMobileNO()));
			pst.setString(3, bo.getContactPresonNameEmail());
			pst.setString(4, bo.getAddrs().getLocation());
			pst.setInt(5, bo.getAddrs().getPincode());
			pst.setInt(6, Integer.parseInt(bo.getAddrs().getCity().getCity()));
			pst.setInt(7, Integer.parseInt(bo.getAddrs().getCity().getState().getState()));
			pst.setInt(8, Integer.parseInt(bo.getAddrs().getCity().getState().getCountry().getCountry()));
			pst.setInt(9, bo.getClientAddressId());
			rs = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public int deleteClientAddrs(int clienAddrsId, Connection con) {
		int count = 0;
		System.out.println(clienAddrsId);
		try {
			pst = con.prepareStatement(SQLQueryConstants.DELETE_CLIENT_ADDRS_QUERY);
			pst.setInt(1, clienAddrsId);
			count = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all countries from database
	 */
	@Override
	public Map<Integer, String> getCountries(Connection con) {
		// TODO Auto-generated method stub

		// creating PreparedStatement and ResultSet object to perform database operation
		PreparedStatement pstmtGetCountries = null;
		ResultSet rsCountries = null;

		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapCountries = new HashMap<Integer, String>();
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtGetCountries = con.prepareStatement(SQLQueryConstants.SQL_GET_COUNTRIES);
			rsCountries = pstmtGetCountries.executeQuery();
			while (rsCountries.next()) {
				// adding countries info into map object
				mapCountries.put(rsCountries.getInt(1), rsCountries.getString(2));
			}

			// returning map of countries information
			return mapCountries;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetCountries.close();
				rsCountries.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all States from database
	 *          associated with country id
	 */
	@Override
	public Map<Integer, String> getStates(int country_id,Connection con) {
		// TODO Auto-generated method stub

		// creating PreparedStatement and ResultSet object to perform database operation
		PreparedStatement pstmtGetStates = null;
		ResultSet rsStates = null;
		// creating Map<Integer,String> object to get all states data
		Map<Integer, String> mapStates = new HashMap<Integer, String>();
		try {
			// getting states data from database
			con = DbUtil.getConnection();
			pstmtGetStates = con.prepareStatement(SQLQueryConstants.SQL_GET_STATES);
			pstmtGetStates.setInt(1, country_id);
			rsStates = pstmtGetStates.executeQuery();
			while (rsStates.next()) {
				// adding states info into map object
				mapStates.put(rsStates.getInt(1), rsStates.getString(2));
			}

			// returning map of states information
			return mapStates;
		} catch (Exception e) {
			e.printStackTrace();

			//// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetStates.close();
				rsStates.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all cities associated with
	 *          state from database
	 */
	@Override
	public Map<Integer, String> getCities(int state_id,Connection con) {
		// TODO Auto-generated method stub

		// creating PreparedStatement and ResultSet object to perform database operation
		PreparedStatement pstmtGetCities = null;
		ResultSet rsCities = null;
	
		// creating Map<Integer,String> object to get all cities data
		Map<Integer, String> mapCities = new HashMap<Integer, String>();
		try {
			// getting cities data from database
			con = DbUtil.getConnection();
			pstmtGetCities = con.prepareStatement(SQLQueryConstants.SQL_GET_CITIES);
			pstmtGetCities.setInt(1, state_id);
			rsCities = pstmtGetCities.executeQuery();
			while (rsCities.next()) {
				// adding cities info into map object
				mapCities.put(rsCities.getInt(1), rsCities.getString(2));
			}

			// returning map of cities
			return mapCities;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetCities.close();
				rsCities.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to persist round info into database
	 */
	@Override
	public int addRound(InterviewRoundDTO objInterviewRoundDTO, Connection con) {
		// TODO Auto-generated method stub

		// creating PreparedStatement object to perform database operation for
		// persisting address
		PreparedStatement pstmtAddress = null;
		// creating PreparedStatement object to perform database operation for
		// persisting round
		PreparedStatement pstmtAddRound = null;
		PreparedStatement pstmtInactivePreviousRound=null;
		PreparedStatement pstmtGetPreviousRound=null;
		try {
			// instantiating PreparedStatement objects
			pstmtGetPreviousRound=con.prepareStatement(SQLQueryConstants.SQL_GET_PREVIOS_ROUND);
			pstmtAddress = con.prepareStatement(SQLQueryConstants.SQL_INSERT_ADDRESS_QUERY,
					Statement.RETURN_GENERATED_KEYS);
			pstmtAddRound = con.prepareStatement(SQLQueryConstants.SQL_ADD_ROUND_QUERY, Statement.NO_GENERATED_KEYS);
			pstmtInactivePreviousRound=con.prepareStatement(SQLQueryConstants.SQL_INACTIVE_PREVIOUS_ROUND);
			// setting user entered address and city parameters to address PreparedStatement
			// object
			pstmtAddress.setString(1, objInterviewRoundDTO.getAddress().getLocation());
			pstmtAddress.setInt(2, objInterviewRoundDTO.getAddress().getCity().getCityId());

			// getting row updated values
			int addId = pstmtAddress.executeUpdate();

			if (addId > 0) {
				ResultSet rsVal = pstmtAddress.getGeneratedKeys();
				rsVal.next();

				// getting auto generated address_id key
				addId = rsVal.getInt(1);
			}
			
			pstmtGetPreviousRound.setInt(1, objInterviewRoundDTO.getJobPost().getJobPostId());
			ResultSet rsTemp=pstmtGetPreviousRound.executeQuery();
			if(rsTemp.next())
			{
				pstmtInactivePreviousRound.setInt(1, objInterviewRoundDTO.getJobPost().getJobPostId());
				pstmtInactivePreviousRound.executeUpdate();
			}
			rsTemp.close();
			pstmtInactivePreviousRound.close();
			
			
			// setting parameters of round information to round PreparedStatement
			pstmtAddRound.setInt(1, objInterviewRoundDTO.getRoundNo());
			pstmtAddRound.setString(2, objInterviewRoundDTO.getDescription());
			pstmtAddRound.setDate(3, objInterviewRoundDTO.getDate());
			pstmtAddRound.setInt(4, objInterviewRoundDTO.getJobPost().getJobPostId());
			pstmtAddRound.setInt(5, 1);
			pstmtAddRound.setInt(6, addId);

			int res = pstmtAddRound.executeUpdate();
			if (res > 0) {
				// returning 1 for success
				ResultSet rsKey = pstmtAddRound.getGeneratedKeys();
				rsKey.next();
				int id = rsKey.getInt(1);
				return id;
			} else {
				// returning 0 for failure
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred
			return 0;
		} finally {
			try {
				// flushing objects
				pstmtAddress.close();
				pstmtAddRound.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<UserDTO> getInterestedTrainees(Integer jobPost, Integer round,Connection con) {
		// TODO Auto-generated method stub
		System.out.println();
		PreparedStatement pstmtGetInterestedTrainees = null;
		ResultSet rsTrainees = null;
		List<UserDTO> allTRinfoList = new ArrayList<>();
		try {
			con = DbUtil.getConnection();
			pstmtGetInterestedTrainees = con.prepareStatement(SQLQueryConstants.SQL_GET_INTERESTED_TRAINEES);
			pstmtGetInterestedTrainees.setInt(1, round);
			pstmtGetInterestedTrainees.setInt(2, jobPost);
			rsTrainees = pstmtGetInterestedTrainees.executeQuery();
			while (rsTrainees.next()) {
				System.out.println("record");
				UserDTO objUserDTO = new UserDTO();

				objUserDTO.setUserid(rsTrainees.getInt(1));
				objUserDTO.setFirstname(rsTrainees.getString(2));
				objUserDTO.setLastname(rsTrainees.getString(3));
				objUserDTO.setEmail(rsTrainees.getString(4));

				/*
				 * AddressDTO objAddressDTO=new AddressDTO(); CityDTO objCityDTO=new CityDTO();
				 * StateDTO objStateDTO=new StateDTO(); CountryDTO objCountryDTO=new
				 * CountryDTO();
				 * 
				 * objAddressDTO.setLocation(rsTrainees.getString(6));
				 * 
				 * objCityDTO.setCity(rsTrainees.getString(7));
				 * 
				 * objStateDTO.setState(rsTrainees.getString(8));
				 * 
				 * objCountryDTO.setCountry(rsTrainees.getString(9));
				 * 
				 * objStateDTO.setCountry(objCountryDTO); objCityDTO.setState(objStateDTO);
				 * objAddressDTO.setCity(objCityDTO);
				 * 
				 * objUserDTO.setAddress(objAddressDTO);
				 */
				System.out.println(objUserDTO);
				allTRinfoList.add(objUserDTO);
			}
			return allTRinfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return allTRinfoList;
		} finally {
			try {
				rsTrainees.close();
				pstmtGetInterestedTrainees.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Map<Integer, String> getAllStatus(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetStatus = null;
		ResultSet rsStatus = null;

		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapStatus = new HashMap<Integer, String>();
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtGetStatus = con.prepareStatement(SQLQueryConstants.SQL_GET_ALL_STATUS);
			rsStatus = pstmtGetStatus.executeQuery();
			while (rsStatus.next()) {
				// adding countries info into map object
				mapStatus.put(rsStatus.getInt(1), rsStatus.getString(2));
			}

			// returning map of countries information
			return mapStatus;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetStatus.close();
				rsStatus.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int updatePreviousRoundStatus(int roundId, InterviewRoundDTO objInterviewRoundDTO, Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtUpdatePreviousRound = null;
		int res = 0;
		// creating Map<Integer,String> object to get all cities data
		try {
			// getting cities data from database
			pstmtUpdatePreviousRound = con.prepareStatement(SQLQueryConstants.SQL_UPDATE_PREVIOUS_ROUND_STATUS);
			pstmtUpdatePreviousRound.setInt(1, roundId);
			pstmtUpdatePreviousRound.setInt(2, objInterviewRoundDTO.getJobPost().getJobPostId());
			res = pstmtUpdatePreviousRound.executeUpdate();
			if (res > 0) {
				return 1;
			} else {
				return 0;
			}
			// returning map of cities

		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return 0;
		} finally {
			try {
				// flushing objects
				pstmtUpdatePreviousRound.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int updateRoundActions(String actionData, InterviewRoundDTO objInterviewRoundDTO, Connection con) {
		// TODO Auto-generated method stub
		// creating Map<Integer,String> object to get all cities data
		try {
			// getting cities data from database

			String records[] = actionData.split(" ");
			// Map<String, Integer> mapActions=new HashMap<>();
			for (int i = 0; i < records.length; i++) {
				PreparedStatement pstmtUpdateActions = con
						.prepareStatement(SQLQueryConstants.SQL_UPDATE_TRAINEE_ROUND_STATUS);
				String record[] = records[i].split(":");

				pstmtUpdateActions.setInt(1, Integer.parseInt(record[1]));
				pstmtUpdateActions.setInt(2, objInterviewRoundDTO.getJobPost().getJobPostId());
				pstmtUpdateActions.setString(3, record[0]);
				pstmtUpdateActions.executeUpdate();
				pstmtUpdateActions.close();
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return 0;
		}
	}

	@Override
	public List<UserDTO> getPreviousShortlistedTrainees(Integer jobPost,Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetPreviousShortlistedTrainees = null;
		ResultSet rsTrainees = null;
		List<UserDTO> allTRinfoList = new ArrayList<>();
		try {
			con = DbUtil.getConnection();
			pstmtGetPreviousShortlistedTrainees = con
					.prepareStatement(SQLQueryConstants.SQL_GET_PREVIOUS_ROUND_SHORTLISTED_TRAINEES);
			pstmtGetPreviousShortlistedTrainees.setInt(1, jobPost);
			rsTrainees = pstmtGetPreviousShortlistedTrainees.executeQuery();
			while (rsTrainees.next()) {
				System.out.println("record");
				UserDTO objUserDTO = new UserDTO();

				objUserDTO.setUserid(rsTrainees.getInt(1));
				objUserDTO.setFirstname(rsTrainees.getString(2));
				objUserDTO.setLastname(rsTrainees.getString(3));
				objUserDTO.setEmail(rsTrainees.getString(4));

				/*
				 * AddressDTO objAddressDTO=new AddressDTO(); CityDTO objCityDTO=new CityDTO();
				 * StateDTO objStateDTO=new StateDTO(); CountryDTO objCountryDTO=new
				 * CountryDTO();
				 * 
				 * objAddressDTO.setLocation(rsTrainees.getString(6));
				 * 
				 * objCityDTO.setCity(rsTrainees.getString(7));
				 * 
				 * objStateDTO.setState(rsTrainees.getString(8));
				 * 
				 * objCountryDTO.setCountry(rsTrainees.getString(9));
				 * 
				 * objStateDTO.setCountry(objCountryDTO); objCityDTO.setState(objStateDTO);
				 * objAddressDTO.setCity(objCityDTO);
				 * 
				 * objUserDTO.setAddress(objAddressDTO);
				 */
				System.out.println(objUserDTO);
				allTRinfoList.add(objUserDTO);
			}
			return allTRinfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return allTRinfoList;
		} finally {
			try {
				rsTrainees.close();
				pstmtGetPreviousShortlistedTrainees.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

/*	@Override
	public int placeStudents(String actionData) {
		// TODO Auto-generated method stub
		
		 * PreparedStatement pstmtPlacement=null; Connection con=null; try { // getting
		 * cities data from database con=DbUtil.getConnection();
		 * 
		 * String records[]=actionData.split(" "); //Map<String, Integer> mapActions=new
		 * HashMap<>(); for(int i=0;i<records.length;i++) { PreparedStatement
		 * pstmtUpdateActions =
		 * con.prepareStatement(SQLQueryConstants.SQL_UPDATE_TRAINEE_ROUND_STATUS);
		 * String record[]=records[i].split(":");
		 * 
		 * pstmtUpdateActions.setInt(1, Integer.parseInt(record[1]));
		 * pstmtUpdateActions.setInt(2,
		 * objInterviewRoundDTO.getJobPost().getJobPostId());
		 * pstmtUpdateActions.setString(3, record[0]);
		 * pstmtUpdateActions.executeUpdate(); pstmtUpdateActions.close(); } return 1; }
		 * catch (Exception e) { e.printStackTrace();
		 * 
		 * // if problem occurred returning null return 0; }
		 
		return 0;
	}*/

	@Override
	public int placeTrainee(PlacementDTO objPlacementDTO, JobPostingDTO objJobPostingDTO, Integer userId,
			String placeStatus,Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtPlaceTrainee = null;
		PreparedStatement pstmtGetClientAddressId = null;
		PreparedStatement pstmtPlacementStatus = null;
		ResultSet rsClientAddressId = null;
		try {
			// instantiating PreparedStatement objects
			con = DbUtil.getConnection();

			pstmtGetClientAddressId = con
					.prepareStatement(SQLQueryConstants.SQL_GET_CLIENT_ADDEESS_ID_FROM_JOB_POSTING_ID);
			pstmtGetClientAddressId.setInt(1, objJobPostingDTO.getJobPostId());
			rsClientAddressId = pstmtGetClientAddressId.executeQuery();
			System.out.println(rsClientAddressId);
			if (rsClientAddressId.next()) {
				pstmtPlacementStatus = con.prepareStatement(SQLQueryConstants.SQL_UPDATE_TRAINEE_PLACEMENT_STATUS);
				pstmtPlacementStatus.setInt(1, Integer.parseInt(placeStatus));
				pstmtPlacementStatus.setInt(2, userId);
				pstmtPlacementStatus.setInt(3, objJobPostingDTO.getJobPostId());
				pstmtPlacementStatus.executeUpdate();

				System.out.println(rsClientAddressId.getInt(1));
				Integer clientAddressId = rsClientAddressId.getInt(1);
				pstmtPlaceTrainee = con.prepareStatement(SQLQueryConstants.SQL_PLACE_TRAINEE_QUERY);
				pstmtPlaceTrainee.setDate(1, objPlacementDTO.getSelectedDate());
				pstmtPlaceTrainee.setDate(2, objPlacementDTO.getJoiningDate());
				pstmtPlaceTrainee.setFloat(3, objPlacementDTO.getPackage());
				pstmtPlaceTrainee.setString(4, objPlacementDTO.getBond());
				pstmtPlaceTrainee.setInt(5, objPlacementDTO.getJobType().getJobTypeId());
				pstmtPlaceTrainee.setInt(6, userId);
				pstmtPlaceTrainee.setInt(7, clientAddressId);

				int res = pstmtPlaceTrainee.executeUpdate();
				if (res > 0) {
					return 1;
				} else {
					// returning 0 for failure
					return 0;
				}
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred
			return 0;
		} finally {
			try {
				rsClientAddressId.close();
				pstmtGetClientAddressId.close();
				pstmtPlaceTrainee.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int rejectTrainee(Integer userId, String jobPost, String placeStatus,Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtPlacementStatus = null;
		// creating PreparedStatement object to perform database operation for
		// persisting round
		try {
			// instantiating PreparedStatement objects
			con = DbUtil.getConnection();

			pstmtPlacementStatus = con.prepareStatement(SQLQueryConstants.SQL_UPDATE_TRAINEE_PLACEMENT_STATUS);
			pstmtPlacementStatus.setInt(1, Integer.parseInt(placeStatus));
			pstmtPlacementStatus.setInt(2, userId);
			pstmtPlacementStatus.setInt(3, Integer.parseInt(jobPost));
			int res=pstmtPlacementStatus.executeUpdate();
			if (res > 0) {
				return 1;
			} else {
				// returning 0 for failure
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred
			return 0;
		} finally {
			try {
				pstmtPlacementStatus.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Map<Integer, String> getAllJobType(Connection con) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetJobTypes = null;
		ResultSet rsJobTypes = null;

		// creating Map<Integer,String> object to get all countries data
		Map<Integer, String> mapJobType = new HashMap<Integer, String>();
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtGetJobTypes = con.prepareStatement(SQLQueryConstants.SQL_GET_ALL_JOB_TYPES);
			rsJobTypes = pstmtGetJobTypes.executeQuery();
			while (rsJobTypes.next()) {
				// adding countries info into map object
				mapJobType.put(rsJobTypes.getInt(1), rsJobTypes.getString(2));
			}

			// returning map of countries information
			return mapJobType;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetJobTypes.close();
				rsJobTypes.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public int registerClientAddrsDetails(ClientAddressBO bo, Connection con, int cid) {
		int addId=0;
		try{
		reg_add_pst = con.prepareStatement(SQLQueryConstants.ADDRESS_REGISTER_DETAILS, Statement.RETURN_GENERATED_KEYS);
		reg_client_add_pst = con.prepareStatement(SQLQueryConstants.CLIENT_ADDRESS_REGISTER_DETAILS);
		// register client and get client id by auto generated key
		 
		// register address and get address id by auto generated key
		reg_add_pst.setString(1, bo.getAddrs().getLocation());
		reg_add_pst.setInt(2, bo.getAddrs().getPincode());
		reg_add_pst.setInt(3,Integer.parseInt( bo.getAddrs().getCity().getCity()));
		reg_add_pst.executeUpdate();
		ResultSet rs_addrs = reg_add_pst.getGeneratedKeys();
		if (rs_addrs.next()) {
			addId = rs_addrs.getInt(1);
		}

		// System.out.println(clientId + "========" + addId);
		// register client addrs
		reg_client_add_pst.setString(1, bo.getContactPresonName());
		reg_client_add_pst.setString(2, bo.getContactPresonMobileNO());
		reg_client_add_pst.setString(3, bo.getContactPresonNameEmail());
		reg_client_add_pst.setInt(4, cid);
		reg_client_add_pst.setInt(5, addId);
		rs = reg_client_add_pst.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace( );
		}
		return rs;
	}

	@Override
	public String getUserMail(Integer userId) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmtGetUserMail = null;
		ResultSet rsMail = null;

		String uMail=null;
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtGetUserMail = con.prepareStatement(SQLQueryConstants.SQL_GET_USER_MAIL);
			pstmtGetUserMail.setInt(1, userId);
			rsMail = pstmtGetUserMail.executeQuery();
			while (rsMail.next()) {
				// adding countries info into map object
				uMail=rsMail.getString(1);
			}

			// returning map of countries information
			return uMail;
		} catch (Exception e) {
			e.printStackTrace();

			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetUserMail.close();
				rsMail.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

	@Override
	public String getClientName(String jobPost) {
		// TODO Auto-generated method stub
		PreparedStatement pstmtGetClientName = null;
		ResultSet rsClientName = null;

		String uClient=null;
		try {
			// getting countries data from database
			con = DbUtil.getConnection();
			pstmtGetClientName = con.prepareStatement(SQLQueryConstants.SQL_GET_CLIENT_NAME);
			pstmtGetClientName.setInt(1, Integer.parseInt(jobPost));
			rsClientName = pstmtGetClientName.executeQuery();
			while (rsClientName.next()) {
				// adding countries info into map object
				uClient=rsClientName.getString(1);
			}

			// returning map of countries information
			return uClient;
		} catch (Exception e) {
			e.printStackTrace();
			// if problem occurred returning null
			return null;
		} finally {
			try {
				// flushing objects
				pstmtGetClientName.close();
				rsClientName.close();
				DbUtil.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ProfileBO fetchUserDetails(String email, Connection con) throws DatabaseException, SQLException {
	
		con = DbUtil.getConnection();
		ProfileBO bo=null;
		
		
		//prapare the query
		user_profile_pst=con.prepareStatement(SQLQueryConstants.User_Profile);
		
		//set the values to the query param
		user_profile_pst.setString(1, email);
		
		//execute the query
		ResultSet prs=user_profile_pst.executeQuery();
		if(prs!=null){
			while(prs.next()){
				 bo=new ProfileBO();
				
				bo.setFirstName(prs.getString(1));
				bo.setLastName(prs.getString(2));
				bo.setEmail(prs.getString(3));
				bo.setMobile(prs.getString(4));
				bo.setPic(prs.getString(5));
				bo.setAddress(prs.getString(6));
				bo.setPin(prs.getInt(7));
				bo.setCity(prs.getString(8));
				bo.setState(prs.getString(9));
				bo.setCountry(prs.getString(10));
				
				
				System.out.println("Name:"+prs.getString(1));
				System.out.println("Mobile:"+prs.getString(4));

				System.out.println("City:"+prs.getString(10));
			
			}
		}
			return bo;			
	}	
}