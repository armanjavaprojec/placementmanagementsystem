package com.nacre.pms.servicei;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.ProfileBO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.PlacementDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This Interface is used to dvelop the admin
 *         Functionalities
 */
public interface AdminServiceI {
	public String addClient(ClientAddressDTO clientAddDto);

	public Map<Integer, String> getCountry() throws DatabaseException;

	public Map<Integer, String> getState() throws DatabaseException;

	public Map<Integer, String> getLevel() throws DatabaseException;

	public List<ClientDTO> getClientDetail() throws DatabaseException;

	public String deleteClientService(int clientId) throws DatabaseException;

	public ClientDTO getEditClientDetailSer(int clientId) throws DatabaseException, SQLException;

	public String updateClientDetail(ClientDTO cAddDto) throws DatabaseException, SQLException;

	public List<ClientAddressDTO> getClientAddrsDetails(int clientId) throws DatabaseException;

	public ClientAddressDTO showClientAddrsDetails(int clientId) throws DatabaseException;

	public String updateClientAddrsClient(ClientAddressDTO clientAddDto) throws DatabaseException;

	public String deleteClientAddrsService(int parseInt) throws DatabaseException;

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call AdminDaoIMPL method to load all
	 *          countries from database
	 */
	public Map<Integer, String> getCountries() throws DatabaseException;

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call AdminDaoIMPL method to load all
	 *          states from database
	 */
	public Map<Integer, String> getStates(int country_id) throws DatabaseException;

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call AdminDaoIMPL method to load all
	 *          cities from database
	 */
	public Map<Integer, String> getCities(int state_id) throws DatabaseException;

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method is used to add round information to database
	 * @param actionData
	 * @throws SQLException 
	 */
	public int addRound(InterviewRoundDTO objInterviewRoundDTO, String actionData) throws DatabaseException, SQLException;

	public List<UserDTO> getInterestedTrainees(Integer jobPost, Integer round) throws DatabaseException;

	public Map<Integer, String> getAllStatus() throws DatabaseException;

	public List<UserDTO> getPreviousShortlistedTrainees(Integer jobPost) throws DatabaseException;

	public int placeTrainee(PlacementDTO objPlacementDTO, JobPostingDTO objJobPostingDTO, Integer userId,
			String placeStatus) throws DatabaseException;

	public int rejectTrainee(Integer userId, String jobPost, String placeStatus) throws DatabaseException;

	public Map<Integer, String> getAllJobType() throws DatabaseException;

	public String registerClientAddrsClient(ClientAddressDTO clientAddDto, int clientId) throws DatabaseException;

	
	ProfileBO getUserProfileDetails(String email) throws DatabaseException, SQLException;
}
