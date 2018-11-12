package com.nacre.pms.daoi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.ClientAddressBO;
import com.nacre.pms.bo.ClientBO;
import com.nacre.pms.bo.ProfileBO;
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
 * @author Nacre Batch 50 Java This interface is used to develop the Admin
 *         functionalities
 */
public interface AdminDaoI {
	public int updateClientDetail(ClientBO bo,Connection con) throws DatabaseException, SQLException;
	public ClientBO showClientDetailDao(int clientId,Connection con) throws DatabaseException, SQLException;
	public int deleteClientDao(int clientId,Connection con);
	public List<ClientBO> viewClientDetails(Connection con) throws DatabaseException, SQLException ;
	public Map<Integer, String> getLevel(Connection con);
	public Map<Integer, String> getCity(StateDTO stateDto,Connection con) ;
	public Map<Integer, String> getState(CountryDTO countryDto,Connection con) ;
	public int addClient(ClientBO bo,Connection con) throws DatabaseException, SQLException;
	public ClientAddressBO getClientAddresEditData(int caddrsId,Connection con);
	public List<ClientAddressBO> viewClientAddrsDetails(int clientId, Connection con);
	public int updateClientAddrsDetails(ClientAddressBO bo, Connection con) ;
	int deleteClientAddrs(int clienAddrsId, Connection con);
	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all countries from database
	 */
	public Map<Integer, String> getCountries(Connection con);

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all states associated with
	 *          country id from database
	 */
	public Map<Integer, String> getStates(int country_id,Connection con);

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to load all cities associated with
	 *          state id from database
	 */
	public Map<Integer, String> getCities(int state_id,Connection con);

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 This method is used to persist round info into database
	 * @param con 
	 */
	public int addRound(InterviewRoundDTO objInterviewRoundDTO, Connection con);
	public List<UserDTO> getInterestedTrainees(Integer jobPost, Integer round,Connection con);
	public Map<Integer, String> getAllStatus(Connection con);
	public int updatePreviousRoundStatus(int roundId, InterviewRoundDTO objInterviewRoundDTO, Connection con);
	public int updateRoundActions(String actionData, InterviewRoundDTO objInterviewRoundDTO, Connection con);
	public List<UserDTO> getPreviousShortlistedTrainees(Integer jobPost,Connection con);
	public int placeTrainee(PlacementDTO objPlacementDTO, JobPostingDTO objJobPostingDTO, Integer userId, String placeStatus,Connection con);
	public int rejectTrainee(Integer userId, String jobPost, String placeStatus,Connection con);
	public Map<Integer, String> getAllJobType(Connection con);
	Map<Integer, String> getCountry(Connection con);
	public int registerClientAddrsDetails(ClientAddressBO bo, Connection con, int cid);
	public String getUserMail(Integer userId);
	public String getClientName(String jobPost);

	
	public ProfileBO fetchUserDetails(String email,Connection con) throws DatabaseException, SQLException;
}
