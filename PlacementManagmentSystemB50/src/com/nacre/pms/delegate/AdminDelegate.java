package com.nacre.pms.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.ProfileBO;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.LevelDTO;
import com.nacre.pms.dto.PlacementDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.AdminServiceI;
import com.nacre.pms.servicei.serviceimpl.AdminServiceIMPL;
import com.nacre.pms.vo.ClientAddressVo;
import com.nacre.pms.vo.ClientVo;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the admin
 *         Functionalities
 */
public class AdminDelegate {
	AdminServiceI as = new AdminServiceIMPL();
	ClientDTO clientDto = null;
	LevelDTO ldto = null;
	ClientAddressDTO clientAddDto = null;
	CountryDTO countryDto = null;
	StateDTO state = null;
	CityDTO city = null;
	AddressDTO addDto = null;
	StatusDTO statusDto = null;

	public ClientVo showClientData(int clientId) throws DatabaseException, SQLException {
		ClientDTO cdto = null;
		ClientVo vo = null;
		cdto = as.getEditClientDetailSer(clientId);
		vo = new ClientVo();
		vo.setClientId(cdto.getClientId().toString());
		vo.setClientName(cdto.getClientName());
		vo.setClientDescription(cdto.getClientDescription());
		return vo;
	}

	public String addClient(ClientVo vo) {
		ldto = new LevelDTO();
		ldto.setLevel(vo.getLevel());
		statusDto = new StatusDTO();
		statusDto.setStatus(vo.getStatus());
		clientDto = new ClientDTO();
		clientDto.setClientName(vo.getClientName());
		clientDto.setClientImage(vo.getClientImage());
		clientDto.setClientDescription(vo.getClientDescription());
		clientDto.setCompanyLevel(ldto);
		countryDto = new CountryDTO();
		countryDto.setCountry(vo.getCountry());
		state = new StateDTO();
		state.setState(vo.getState());
		state.setCountry(countryDto);
		city = new CityDTO();
		city.setCity(vo.getCity());
		city.setState(state);

		addDto = new AddressDTO();
		addDto.setLocation(vo.getLocation());
		addDto.setPincode(Integer.parseInt(vo.getPincode()));
		addDto.setCity(city);

		clientAddDto = new ClientAddressDTO();
		clientAddDto.setContactPresonName(vo.getPersonName());
		clientAddDto.setContactPresonMobileNO(vo.getPersonMobile());
		clientAddDto.setContactPresonNameEmail(vo.getPersonEmail());
		clientAddDto.setClient(clientDto);
		clientAddDto.setAddress(addDto);
		String res = as.addClient(clientAddDto);
		return res;
	}

	public List<ClientVo> viewClientDetail() throws DatabaseException {
		int cnt = 0;
		List<ClientDTO> listClientDto = null;
		listClientDto = as.getClientDetail();
		List<ClientVo> listClientVo = new ArrayList<>();
		for (ClientDTO dto : listClientDto) {
			ClientVo vo = new ClientVo();
			vo.setCno(((Integer) (++cnt)).toString());
			vo.setClientId(((Integer) dto.getClientId()).toString());
			//System.out.println(dto.getClientId()+"cid..............");
			vo.setLevel(dto.getCompanyLevel().getLevel());
			vo.setClientName(dto.getClientName());
			vo.setClientDescription(dto.getClientDescription());
			listClientVo.add(vo);
		}
		return listClientVo;
	}

	public String updateClientDetail(ClientVo vo) throws DatabaseException, SQLException {
		ldto = new LevelDTO();
		clientDto = new ClientDTO();
		ldto.setLevel(vo.getLevel());
		clientDto.setClientId(Integer.parseInt(vo.getClientId()));
		clientDto.setClientName(vo.getClientName());
		clientDto.setClientImage(vo.getClientImage());
		clientDto.setClientDescription(vo.getClientDescription());
		clientDto.setCompanyLevel(ldto);
		String res = as.updateClientDetail(clientDto);
		return res;
	}

	public List<ClientAddressVo> listClientAddrs(String clientId) throws NumberFormatException, DatabaseException {
		int cnt = 0;
		List<ClientAddressDTO> listClientAddrsDto = null;
		listClientAddrsDto = as.getClientAddrsDetails(Integer.parseInt(clientId));
		List<ClientAddressVo> listClientAddrsVo = new ArrayList<>();
		for (ClientAddressDTO dto : listClientAddrsDto) {
			ClientAddressVo vo = new ClientAddressVo();
			vo.setClientAddressId(((Integer) dto.getClientAddressId()).toString());
			vo.setCno(((Integer) (++cnt)).toString());
			vo.setContactPresonName(dto.getContactPresonName());
			vo.setContactPresonMobileNO(dto.getContactPresonMobileNO());
			vo.setContactPresonNameEmail(dto.getContactPresonNameEmail());
			vo.setPincode(((Integer) dto.getAddress().getPincode()).toString());
			vo.setLocation(dto.getAddress().getLocation());
			vo.setCity(dto.getAddress().getCity().getCity());
			vo.setState(dto.getAddress().getCity().getState().getState());
			vo.setCountry(dto.getAddress().getCity().getState().getCountry().getCountry());
			listClientAddrsVo.add(vo);
		}
		return listClientAddrsVo;
	}

	public ClientAddressVo showClientAddrs(String clientAddrsId) throws NumberFormatException, DatabaseException {
		ClientAddressDTO clientAddrsDto = as.showClientAddrsDetails(Integer.parseInt(clientAddrsId));
		ClientAddressVo vo = new ClientAddressVo();
		vo.setClientAddressId(((Integer) clientAddrsDto.getClientAddressId()).toString());
		vo.setContactPresonName(clientAddrsDto.getContactPresonName());
		vo.setContactPresonMobileNO(clientAddrsDto.getContactPresonMobileNO());
		vo.setContactPresonNameEmail(clientAddrsDto.getContactPresonNameEmail());
		vo.setPincode(((Integer) clientAddrsDto.getAddress().getPincode()).toString());
		vo.setLocation(clientAddrsDto.getAddress().getLocation());
		vo.setCity(clientAddrsDto.getAddress().getCity().getCity());
		vo.setState(clientAddrsDto.getAddress().getCity().getState().getState());
		vo.setCountry(clientAddrsDto.getAddress().getCity().getState().getCountry().getCountry());
		return vo;
	}

	public String updateClientAddrsDetail(ClientAddressVo vo) throws DatabaseException {
		countryDto = new CountryDTO();
		countryDto.setCountry(vo.getCountry());

		state = new StateDTO();
		state.setState(vo.getState());
		state.setCountry(countryDto);

		city = new CityDTO();
		city.setCity(vo.getCity());
		city.setState(state);

		addDto = new AddressDTO();
		addDto.setLocation(vo.getLocation());
		addDto.setPincode(Integer.parseInt(vo.getPincode()));
		addDto.setCity(city);

		clientAddDto = new ClientAddressDTO();
		clientAddDto.setClientAddressId(Integer.parseInt(vo.getClientAddressId()));
		clientAddDto.setContactPresonName(vo.getContactPresonName());
		clientAddDto.setContactPresonMobileNO(vo.getContactPresonMobileNO());
		clientAddDto.setContactPresonNameEmail(vo.getContactPresonNameEmail());
		clientAddDto.setClient(clientDto);
		clientAddDto.setAddress(addDto);
		String res = as.updateClientAddrsClient(clientAddDto);
		return res;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method is used to call method of AdminServiceI to
	 *          load all countries from database
	 * @throws DatabaseException
	 */
	public Map<Integer, String> getCountries() throws DatabaseException {
		Map<Integer, String> mapCountries = as.getCountries();
		return mapCountries;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method is used to call method of AdminServiceI to
	 *          load all states from database
	 * @throws DatabaseException
	 */
	public Map<Integer, String> getStates(int country_id) throws DatabaseException {
		Map<Integer, String> mapStates = as.getStates(country_id);
		return mapStates;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method is used to call method of AdminServiceI to
	 *          load all cities from database
	 * @throws DatabaseException
	 */
	public Map<Integer, String> getCities(int state_id) throws DatabaseException {
		Map<Integer, String> mapCities = as.getCities(state_id);
		return mapCities;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method is used to call method of AdminServiceI to
	 *          add round information to database
	 * @param actionData
	 * @throws DatabaseException
	 * @throws SQLException 
	 */
	public int addRound(InterviewRoundDTO objInterviewRoundDTO, String actionData) throws DatabaseException, SQLException {
		int res = as.addRound(objInterviewRoundDTO, actionData);
		return res;
	}

	public List<UserDTO> getInterestedTrainees(Integer jobPost, Integer round) throws DatabaseException {
		List<UserDTO> objAllTRInfoList = as.getInterestedTrainees(jobPost, round);
		return objAllTRInfoList;
	}

	public Map<Integer, String> getAllStatus() throws DatabaseException {
		Map<Integer, String> mapStatus = as.getAllStatus();
		return mapStatus;
	}

	public List<UserDTO> getPreviousShortlistedTrainees(Integer jobPost) throws DatabaseException {
		List<UserDTO> objAllTRInfoList = as.getPreviousShortlistedTrainees(jobPost);
		return objAllTRInfoList;
	}

	public int placeTrainee(PlacementDTO objPlacementDTO, JobPostingDTO objJobPostingDTO, Integer userId,
			String placeStatus) throws DatabaseException {
		int res = as.placeTrainee(objPlacementDTO, objJobPostingDTO, userId, placeStatus);
		return res;
	}

	public int rejectTrainee(Integer userId, String jobPost, String placeStatus) throws DatabaseException {
		int res = as.rejectTrainee(userId, jobPost, placeStatus);
		return res;
	}

	public Map<Integer, String> getAllJobTypes() throws DatabaseException {
		Map<Integer, String> mapJobType = as.getAllJobType();
		return mapJobType;
	}

	public String registerClientAddrsDetails(ClientAddressVo vo, int clientId) throws DatabaseException {
		countryDto = new CountryDTO();
		countryDto.setCountry(vo.getCountry());

		state = new StateDTO();
		state.setState(vo.getState());
		state.setCountry(countryDto);

		city = new CityDTO();
		city.setCity(vo.getCity());
		city.setState(state);

		addDto = new AddressDTO();
		addDto.setLocation(vo.getLocation());
		addDto.setPincode(Integer.parseInt(vo.getPincode()));
		addDto.setCity(city);

		clientAddDto = new ClientAddressDTO();
		clientAddDto.setContactPresonName(vo.getContactPresonName());
		clientAddDto.setContactPresonMobileNO(vo.getContactPresonMobileNO());
		clientAddDto.setContactPresonNameEmail(vo.getContactPresonNameEmail());
		clientAddDto.setClient(clientDto);
		clientAddDto.setAddress(addDto);
		String res = as.registerClientAddrsClient(clientAddDto, clientId);
		return res;
	}

	public ProfileBO getUserProfile(String email) throws DatabaseException, SQLException {
			ProfileBO list = as.getUserProfileDetails(email);
			return list;
		}
}
