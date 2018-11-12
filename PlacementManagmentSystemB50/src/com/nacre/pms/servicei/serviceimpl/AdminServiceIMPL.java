package com.nacre.pms.servicei.serviceimpl;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.AddressBO;
import com.nacre.pms.bo.CityBO;
import com.nacre.pms.bo.ClientAddressBO;
import com.nacre.pms.bo.ClientBO;
import com.nacre.pms.bo.CountryBO;
import com.nacre.pms.bo.ProfileBO;
import com.nacre.pms.bo.StateBO;
import com.nacre.pms.daoi.AdminDaoI;
import com.nacre.pms.daoi.daoimpl.AdminDaoIMPL;
import com.nacre.pms.db_util.DbUtil;
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
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.AdminServiceI;
import com.nacre.pms.test.EmailUtil;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the admin
 *         Functionalities
 */
public class AdminServiceIMPL implements AdminServiceI {
	AdminDaoI ad = new AdminDaoIMPL();
	Connection con = null;

	@Override
	public String addClient(ClientAddressDTO cAddDto) {
		ClientBO clientBo = null;
		int i = 0;
		try {
			con = DbUtil.getConnection();
			clientBo = new ClientBO();
			clientBo.setClientName(cAddDto.getClient().getClientName());
			clientBo.setClientImage(cAddDto.getClient().getClientImage());
			clientBo.setClientDescription(cAddDto.getClient().getClientDescription());
			clientBo.setPersonName(cAddDto.getContactPresonName());
			clientBo.setPersonMobile(Long.parseLong(cAddDto.getContactPresonMobileNO()));
			clientBo.setPersonEmail(cAddDto.getContactPresonNameEmail());
			clientBo.setLocation(cAddDto.getAddress().getLocation());
			clientBo.setPincode(cAddDto.getAddress().getPincode());
			clientBo.setCountry(cAddDto.getAddress().getCity().getState().getCountry().getCountry());
			clientBo.setState(cAddDto.getAddress().getCity().getState().getState());
			clientBo.setCity(cAddDto.getAddress().getCity().getCity());
			clientBo.setLevel(cAddDto.getClient().getCompanyLevel().getLevel());
			i = ad.addClient(clientBo, con);
			DbUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (i >= 0)
			return "Client Addition Succesfull..";
		else
			return "Client Addition Failure..,Try Agian..";
	}

	@Override
	public Map<Integer, String> getCountry() throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> m = null;
		m = ad.getCountry(con);
		DbUtil.closeConnection(con);
		return m;
	}

	@Override
	public Map<Integer, String> getState() throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> map = null;
		map = ad.getCountry(con);
		DbUtil.closeConnection(con);
		return map;
	}

	@Override
	public Map<Integer, String> getLevel() throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> map = null;
		map = ad.getLevel(con);
		DbUtil.closeConnection(con);
		return map;
	}

	@Override
	public List<ClientDTO> getClientDetail() throws DatabaseException {
		List<ClientBO> listClientBo = null;
		con = DbUtil.getConnection();
		try {
			listClientBo = ad.viewClientDetails(con);
		} catch (DatabaseException | SQLException e) {
			e.printStackTrace();
		}
		List<ClientDTO> listClientDto = new ArrayList<>();
		listClientBo.forEach(bo -> {
			ClientDTO dto = new ClientDTO();
			dto.setClientId(bo.getClientId());
			dto.setClientName(bo.getClientName());
			dto.setClientDescription(bo.getClientDescription());
			LevelDTO ldto = new LevelDTO();
			ldto.setLevel(bo.getLevel());
			dto.setCompanyLevel(ldto);
			listClientDto.add(dto);
		});
		DbUtil.closeConnection(con);
		return listClientDto;
	}

	@Override
	public String deleteClientService(int clientId) throws DatabaseException {
		int cnt = 0;
		con = DbUtil.getConnection();
		cnt = ad.deleteClientDao(clientId, con);
		DbUtil.closeConnection(con);
		if (cnt >= 0)
			return "Client Deletion Succesfull..";
		else
			return "Client Deletion Failure..,Try Agian..";
	}

	@Override
	public ClientDTO getEditClientDetailSer(int clientId) throws DatabaseException, SQLException {
		ClientBO bo = null;
		con = DbUtil.getConnection();
		bo = ad.showClientDetailDao(clientId, con);
		DbUtil.closeConnection(con);
		LevelDTO levelDto = new LevelDTO();
		levelDto.setLevel(bo.getLevel());
		ClientDTO clientDto = new ClientDTO();
		clientDto.setClientId(bo.getClientId());
		clientDto.setClientDescription(bo.getClientDescription());
		clientDto.setClientName(bo.getClientName());
		clientDto.setCompanyLevel(levelDto);
		return clientDto;
	}

	@Override
	public String updateClientDetail(ClientDTO cDto) throws DatabaseException, SQLException {
		ClientBO clientBo = null;
		String result = null;
		int i = 0;
		clientBo = new ClientBO();
		clientBo.setClientId(cDto.getClientId());
		clientBo.setClientName(cDto.getClientName());
		clientBo.setClientImage(cDto.getClientImage());
		clientBo.setClientDescription(cDto.getClientDescription());
		clientBo.setLevel(cDto.getCompanyLevel().getLevel());
		con = DbUtil.getConnection();
		i = ad.updateClientDetail(clientBo, con);
		DbUtil.closeConnection(con);
		if (i >= 0)
			return "Client Updation Succesfull..";
		else
			return "Client Updation Failure..,Try Agian..";

	}

	@Override
	public List<ClientAddressDTO> getClientAddrsDetails(int clientId) throws DatabaseException {
		List<ClientAddressBO> listClientAddrsBo = null;
		con = DbUtil.getConnection();
		listClientAddrsBo = ad.viewClientAddrsDetails(clientId, con);
		DbUtil.closeConnection(con);
		List<ClientAddressDTO> listClientAddrsDto = new ArrayList<>();
		listClientAddrsBo.forEach(bo -> {
			ClientAddressDTO dto = new ClientAddressDTO();
			CountryDTO countryDto = new CountryDTO();
			countryDto.setCountry(bo.getAddrs().getCity().getState().getCountry().getCountry());
			StateDTO stateDto = new StateDTO();
			stateDto.setState(bo.getAddrs().getCity().getState().getState());
			stateDto.setCountry(countryDto);
			CityDTO cityDto = new CityDTO();
			cityDto.setCity(bo.getAddrs().getCity().getCity());
			cityDto.setState(stateDto);
			AddressDTO addDto = new AddressDTO();
			addDto.setLocation(bo.getAddrs().getLocation());
			addDto.setPincode(bo.getAddrs().getPincode());
			addDto.setCity(cityDto);
			dto.setAddress(addDto);
			dto.setContactPresonName(bo.getContactPresonName());
			dto.setContactPresonNameEmail(bo.getContactPresonNameEmail());
			dto.setContactPresonMobileNO(bo.getContactPresonMobileNO());
			dto.setClientAddressId(bo.getClientAddressId());
			listClientAddrsDto.add(dto);
		});
		return listClientAddrsDto;
	}

	@Override
	public ClientAddressDTO showClientAddrsDetails(int clientId) throws DatabaseException {
		ClientAddressDTO dto = null;
		con = DbUtil.getConnection();
		ClientAddressBO bo = ad.getClientAddresEditData(clientId, con);
		DbUtil.closeConnection(con);
		dto = new ClientAddressDTO();
		CountryDTO countryDto = new CountryDTO();
		countryDto.setCountry(bo.getAddrs().getCity().getState().getCountry().getCountry());
		StateDTO stateDto = new StateDTO();
		stateDto.setState(bo.getAddrs().getCity().getState().getState());
		stateDto.setCountry(countryDto);
		CityDTO cityDto = new CityDTO();
		cityDto.setCity(bo.getAddrs().getCity().getCity());
		cityDto.setState(stateDto);
		AddressDTO addDto = new AddressDTO();
		addDto.setLocation(bo.getAddrs().getLocation());
		addDto.setPincode(bo.getAddrs().getPincode());
		addDto.setCity(cityDto);
		dto.setAddress(addDto);
		dto.setContactPresonName(bo.getContactPresonName());
		dto.setContactPresonNameEmail(bo.getContactPresonNameEmail());
		dto.setContactPresonMobileNO(bo.getContactPresonMobileNO());
		dto.setClientAddressId(bo.getClientAddressId());
		return dto;
	}

	@Override
	public String updateClientAddrsClient(ClientAddressDTO cAddDto) throws DatabaseException {
		int i = 0;
		ClientAddressBO clientBo = new ClientAddressBO();
		clientBo.setClientAddressId(cAddDto.getClientAddressId());
		clientBo.setContactPresonName(cAddDto.getContactPresonName());
		clientBo.setContactPresonMobileNO(cAddDto.getContactPresonMobileNO());
		clientBo.setContactPresonNameEmail(cAddDto.getContactPresonNameEmail());
		CountryBO cbo = new CountryBO();
		cbo.setCountry(cAddDto.getAddress().getCity().getState().getCountry().getCountry());
		StateBO sbo = new StateBO();
		sbo.setState(cAddDto.getAddress().getCity().getState().getState());
		sbo.setCountry(cbo);
		CityBO cityBo = new CityBO();
		cityBo.setCity(cAddDto.getAddress().getCity().getCity());
		cityBo.setState(sbo);
		AddressBO abo = new AddressBO();
		abo.setLocation(cAddDto.getAddress().getLocation());
		abo.setPincode(cAddDto.getAddress().getPincode());
		abo.setCity(cityBo);
		clientBo.setAddrs(abo);
		con = DbUtil.getConnection();
		i = ad.updateClientAddrsDetails(clientBo, con);
		DbUtil.closeConnection(con);
		if (i >= 0)
			return "Client Address Updation Succesfull..";
		else
			return "Client Address Updation Failure..,Try Agian..";
	}

	@Override
	public String deleteClientAddrsService(int clienAddrsId) throws DatabaseException {
		int cnt = 0;
		con = DbUtil.getConnection();
		cnt = ad.deleteClientAddrs(clienAddrsId, con);
		DbUtil.closeConnection(con);
		if (cnt >= 0)
			return "Client Address Deletion Succesfull..";
		else
			return "Client Address Deletion Failure..,Try Agian..";
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call method of AdminDaoI to load all
	 *          countries from database
	 * @throws DatabaseException
	 */
	@Override
	public Map<Integer, String> getCountries() throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapCountries = ad.getCountries(con);
		DbUtil.closeConnection(con);
		return mapCountries;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call method of AdminDaoI to load all
	 *          states from database
	 * @throws DatabaseException
	 */
	@Override
	public Map<Integer, String> getStates(int country_id) throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapStates = ad.getStates(country_id, con);
		DbUtil.closeConnection(con);
		return mapStates;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call method of AdminDaoI to load all
	 *          cities from database
	 * @throws DatabaseException
	 */
	@Override
	public Map<Integer, String> getCities(int state_id) throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapCities = ad.getCities(state_id, con);
		DbUtil.closeConnection(con);
		return mapCities;
	}

	/**
	 * @author Sagar
	 * @version 1.0.0 2018 this method used to call method of AdminDaoI to add round
	 *          information into database
	 * @throws SQLException
	 * @throws DatabaseException
	 */
	@Override
	public int addRound(InterviewRoundDTO objInterviewRoundDTO, String actionData)
			throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		con.setAutoCommit(false);
		int roundId = ad.addRound(objInterviewRoundDTO, con);
		if (roundId > 0) {
			int res = ad.updatePreviousRoundStatus(roundId, objInterviewRoundDTO, con);
			if (res > 0) {
				int lastRes = ad.updateRoundActions(actionData, objInterviewRoundDTO, con);
				if (lastRes > 0) {
					con.commit();
					int jobPostId=objInterviewRoundDTO.getJobPost().getJobPostId();
					System.out.println("JJJJJJJJJJJJJJJJJJJJJJBBBBBBBBBBBBBBBBBB"+jobPostId);
					return jobPostId;
				} else {
					con.rollback();
					return 0;
				}
			} else {
				con.rollback();
				return 0;
			}
		} else {
			con.rollback();
			return 0;
		}

	}

	@Override
	public List<UserDTO> getInterestedTrainees(Integer jobPost, Integer round) throws DatabaseException {
		con = DbUtil.getConnection();
		List<UserDTO> objAllTRInfoList = ad.getInterestedTrainees(jobPost, round, con);
		DbUtil.closeConnection(con);
		return objAllTRInfoList;
	}

	@Override
	public Map<Integer, String> getAllStatus() throws DatabaseException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapStatus = ad.getAllStatus(con);
		DbUtil.closeConnection(con);
		return mapStatus;
	}

	@Override
	public List<UserDTO> getPreviousShortlistedTrainees(Integer jobPost) throws DatabaseException {
		con = DbUtil.getConnection();
		List<UserDTO> objAllTRInfoList = ad.getPreviousShortlistedTrainees(jobPost, con);
		DbUtil.closeConnection(con);
		return objAllTRInfoList;

	}

	/*
	 * @Override public int placeStudents(String actionData) { // TODO
	 * Auto-generated method stub AdminDaoI objAdminDaoI = new AdminDaoIMPL(); int
	 * res=objAdminDaoI.placeStudents(actionData); return 0; }
	 */

	@Override
	public int placeTrainee(PlacementDTO objPlacementDTO, JobPostingDTO objJobPostingDTO, Integer userId,
			String placeStatus) throws DatabaseException {
		con = DbUtil.getConnection();
		int res = ad.placeTrainee(objPlacementDTO, objJobPostingDTO, userId, placeStatus, con);
		if(res>0)
		{
			AdminDaoI objAdminDaoI=new AdminDaoIMPL();
			String mail=objAdminDaoI.getUserMail(userId);
			String jobPost=objJobPostingDTO.getJobPostId().toString();
			String clientName=objAdminDaoI.getClientName(jobPost);
			if(mail!=null)
			{
				System.out.println("mail"+mail);
				
				
				
				String message = "<i>Greetings!</i><br>";
		        message += "<font color='red'><b>You are placed..</b></font>";
		        message += "<table><tr><td>Company Name : </td><td><font color='red'>"+clientName+"</font></td></tr>";
		        message += "<tr><td>Joining Date : </td><td>"+objPlacementDTO.getJoiningDate()+"</td></tr>";
		        message += "<tr><td>Package : </td><td>"+objPlacementDTO.getPackage()+"</td></tr>";
		        message += "<tr><td>Bond Duration : </td><td>"+objPlacementDTO.getBond()+"</td></tr>";
		        
		        message+="<br>";
		        	 
		        message+="<font color='red'>Note : FOR MORE DETAILS CONTACT NACRE.</font></b>";
				
				
				boolean resMail=EmailUtil.sendMail(mail, "[NACRE]Congratulations!",message);
				System.out.println("SEND Mil=========="+resMail);
			}
			else{
				System.out.println("mail"+mail);
			}
			
		}
		DbUtil.closeConnection(con);
		return res;
	}

	@Override
	public int rejectTrainee(Integer userId, String jobPost, String placeStatus) throws DatabaseException {
		con = DbUtil.getConnection();
		int res = ad.rejectTrainee(userId, jobPost, placeStatus,con);
		
		if(res>0)
		{
			AdminDaoI objAdminDaoI=new AdminDaoIMPL();
			String mail=objAdminDaoI.getUserMail(userId);
			String clientName=objAdminDaoI.getClientName(jobPost);
			if(mail!=null)
			{
				System.out.println("mail"+mail);
				
				
				
				String message = "<i>Sorry!</i><br>";
		        message += "<font color='red'><b>You are not shortlisted.. We will consider you for further opportunities..</b></font>";
		        message += "<table><tr><td>Company Name : </td><td><font color='red'>"+clientName+"</font></td></tr>";
		        message+="<br>";
		        	 
		        message+="<font color='red'>Note : FOR MORE DETAILS CONTACT NACRE.</font></b>";
				
				
				boolean resMail=EmailUtil.sendMail(mail, "[NACRE]Regarding Interview Result!",message);
				System.out.println("SEND Mil=========="+resMail);
			}
			else{
				System.out.println("mail"+mail);
			}
			
		}
		DbUtil.closeConnection(con);
		return res;
		
	}

	@Override
	public Map<Integer, String> getAllJobType() throws DatabaseException {
		con=DbUtil.getConnection();
		Map<Integer, String> mapJobType = ad.getAllJobType(con);
		DbUtil.closeConnection(con);
		return mapJobType;
	}

	@Override
	public String registerClientAddrsClient(ClientAddressDTO cAddDto, int id) throws DatabaseException {
		int i = 0;
		ClientAddressBO clientBo = new ClientAddressBO();
		clientBo.setContactPresonName(cAddDto.getContactPresonName());
		clientBo.setContactPresonMobileNO(cAddDto.getContactPresonMobileNO());
		clientBo.setContactPresonNameEmail(cAddDto.getContactPresonNameEmail());
		CountryBO cbo = new CountryBO();
		cbo.setCountry(cAddDto.getAddress().getCity().getState().getCountry().getCountry());
		StateBO sbo = new StateBO();
		sbo.setState(cAddDto.getAddress().getCity().getState().getState());
		sbo.setCountry(cbo);
		CityBO cityBo = new CityBO();
		cityBo.setCity(cAddDto.getAddress().getCity().getCity());
		cityBo.setState(sbo);
		AddressBO abo = new AddressBO();
		abo.setLocation(cAddDto.getAddress().getLocation());
		abo.setPincode(cAddDto.getAddress().getPincode());
		abo.setCity(cityBo);
		clientBo.setAddrs(abo);
			con = DbUtil.getConnection();
		i = ad.registerClientAddrsDetails(clientBo, con, id);
		DbUtil.closeConnection(con);
		if (i >= 0)
			return "Client Address Registration Succesfull..";
		else
			return "Client Address Registration Failure..,Try Agian..";

	}

	@Override
	public ProfileBO getUserProfileDetails(String email) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		ProfileBO list = ad.fetchUserDetails(email, con);
		DbUtil.closeConnection(con);
		return list;
	}

	

}
