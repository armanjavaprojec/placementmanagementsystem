package com.nacre.pms.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.TraineeBO;
import com.nacre.pms.daoi.TraineeDaoI;
import com.nacre.pms.daoi.daoimpl.TraineeDaoIMPL;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.EducationalTypeDetailsDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.TraineeServiceI;
import com.nacre.pms.util.DateUtil;
import com.nacre.pms.vo.ShowRoundDataTOTraineeVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the Trainee
 *         Functionalities
 */
public class TraineeServiceIMPL implements TraineeServiceI {
	TraineeDaoIMPL dao;
	static Connection con;
	TraineeBO bo;
	EducationDetailsDTO educationDetailsDTO;
	UserDTO userDTO = null;
	AddressDTO addressDTO = null;
	CityDTO cityDTO = null;
	CountryDTO countryDTO = null;
	StateDTO stateDTO = null;
	List<EducationalTypeDetailsDTO> educationalTypeDetailsDTOList = null;

	@Override
	public UserDTO getTraineeForEdit(String email) {
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
		}
		bo = dao.getTraineeForEdit(email, con);
		System.out.println("bo" + bo);
		// convert bo to dto
		countryDTO = new CountryDTO();
		countryDTO.setCountry(bo.getCountry());

		stateDTO = new StateDTO();
		stateDTO.setState(bo.getState());
		stateDTO.setCountry(countryDTO);

		cityDTO = new CityDTO();
		cityDTO.setCity(bo.getCity());
		cityDTO.setState(stateDTO);

		addressDTO = new AddressDTO();
		addressDTO.setLocation(bo.getLocation());
		addressDTO.setPincode(bo.getPincode());
		addressDTO.setCity(cityDTO);

		userDTO = new UserDTO();
		userDTO.setUserid(bo.getUserId());
		userDTO.setFirstname(bo.getFirstName());
		userDTO.setLastname(bo.getLastName());
		userDTO.setMobileNo(((Long) bo.getMobno()).toString());
		userDTO.setDate(bo.getDob());
		userDTO.setAddress(addressDTO);
		return userDTO;
	}

	@Override
	public Map getCountry() {
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();

		} catch (DatabaseException e1) {

			e1.printStackTrace();
		}
		return dao.getCountry(con);
	}

	@Override
	public Map getState(int country_id) {
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();
		} catch (DatabaseException e1) {

			e1.printStackTrace();
		}
		return dao.getState(con, country_id);
	}

	@Override
	public Map getCity(int state_id) {
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
		}
		return dao.getCity(con, state_id);
	}

	@Override
	public String updateTraineeDetails(UserDTO dto) {
		String res = null;
		int cnt = 0;
		// convert dto to bo
		bo = new TraineeBO();
		bo.setEmail(dto.getEmail());
		bo.setFirstName(dto.getFirstname());
		bo.setLastName(dto.getLastname());
		bo.setImage(dto.getImage());
		bo.setMobno(Long.parseLong(dto.getMobileNo()));
		bo.setDob(DateUtil.getSQLDate(dto.getDate()));
		bo.setPincode(dto.getAddress().getPincode());
		bo.setLocation(dto.getAddress().getLocation());
		bo.setCity(dto.getAddress().getCity().getCity());
		bo.setState(dto.getAddress().getCity().getState().getState());
		bo.setCountry(dto.getAddress().getCity().getState().getCountry().getCountry());
		// call dao
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();
			cnt = dao.updateTraineeDetails(con, bo);
		} catch (DatabaseException e1) {
			e1.printStackTrace();
		}
		if (cnt >= 1)
			return "Trainee Updation Successfull";
		else
			return "Trainee Updation Failure, try Again...";
	}

	@Override
	public String registerTraineesByExcel(List<EducationDetailsDTO> listDto) {
		String result = null;
		int[] res = null;
		try {
			con = DbUtil.getConnection();
			dao = new TraineeDaoIMPL();
		} catch (DatabaseException e1) {
			e1.printStackTrace();
		}
		// convert listdto to listbo
		List<TraineeBO> listBO = new ArrayList<>();
		listDto.forEach(dto -> {
			System.out.println(dto);
			TraineeBO bo = new TraineeBO();
			bo.setFirstName(dto.getUserDTO().getFirstname());
			bo.setLastName(dto.getUserDTO().getLastname());
			bo.setEmail(dto.getUserDTO().getEmail());
			bo.setPassword(dto.getUserDTO().getPassword());
			bo.setMobno(Long.parseLong(dto.getUserDTO().getMobileNo()));
			bo.setGender(dto.getUserDTO().getGender());
			// bo.setImage();
			bo.setDob(DateUtil.getSQLDate(dto.getUserDTO().getDate()));
			bo.setBatchName(dto.getUserDTO().getBatchTechnology().getBatch().getBatch());
			bo.setTechnology(dto.getUserDTO().getBatchTechnology().getTechnology().getTechnology());
			bo.setPincode(dto.getUserDTO().getAddress().getPincode());
			bo.setLocation(dto.getUserDTO().getAddress().getLocation());
			bo.setCity(dto.getUserDTO().getAddress().getCity().getCity());
			bo.setState(dto.getUserDTO().getAddress().getCity().getState().getState());
			bo.setCountry(dto.getUserDTO().getAddress().getCity().getState().getCountry().getCountry());
			dto.getEducationalTypeDetailsDTOList().forEach(e -> {
				if (!(e.getEducationTypeDTO() == null)) {
					if (e.getEducationTypeDTO().getGraduationType().equalsIgnoreCase("ssc")) {
						bo.setSscPercentage(e.getPercentage());
						bo.setSscYop(e.getYop());
					} else if (e.getEducationTypeDTO().getGraduationType().equalsIgnoreCase("hse")) {
						bo.setHsePercentage(e.getPercentage());
						bo.setHseYop(e.getYop());
					} else if (e.getEducationTypeDTO().getGraduationType().equalsIgnoreCase("graduation")) {
						bo.setGraduationPercentage(e.getPercentage());
						bo.setGraduationYop(e.getYop());
						bo.setGraduationStream(e.getSpecializationDTO().getObjStreamDTO().getStream());
						bo.setGraduationSpecialization(e.getSpecializationDTO().getSpecialization());
					} else if (e.getEducationTypeDTO().getGraduationType().equalsIgnoreCase("postGraduation")) {
						bo.setPostGraduationPercentage(e.getPercentage());
						bo.setPostGraduationYop(e.getYop());
						bo.setPostGraduationStream(e.getSpecializationDTO().getObjStreamDTO().getStream());
						bo.setPostGraduationSpecialization(e.getSpecializationDTO().getSpecialization());
					}
				}
			});
			listBO.add(bo);
		});
		res = dao.insertTraineesByBatchProcess(listBO, con);
		System.out.println(res.length);
		if (res.length == listBO.size())
			return res.length + " No of Trainees are registered successfully";
		else {
			return "trainee Insertion failure !, try again...";
		}
	}
	@Override
	public List<Object> getClientData( int id) throws SQLException, DatabaseException {
		Connection con=DbUtil.getConnection();
		TraineeDaoI dao=new TraineeDaoIMPL();
		List<Object> list=dao.getClientData(con,id);
		
		return list;
	
	}

	
	public int setStatus(StatusDTO sdto,JobPostingDTO jdto,int uid) throws SQLException, DatabaseException {
		TraineeDaoI dao=new TraineeDaoIMPL();
	   return dao.setStatus(sdto,jdto,uid);
	}

	@Override
	public int setStatusFeedback(StatusDTO sdto,JobPostingDTO jdto,FeedbackDTO fdto,int uid) throws SQLException,DatabaseException{
		TraineeDaoI dao=new TraineeDaoIMPL();
		int a=dao.setStatusFeedback(sdto,jdto,fdto,uid);
		return a;
	}




	@Override
	public void setReadNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException {
		  TraineeDaoIMPL tdao=new TraineeDaoIMPL();
	        tdao.setReadNotification(sdto,id);		
	}


	@Override
	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto,int id) throws SQLException, DatabaseException {
		TraineeDaoIMPL tdao=new TraineeDaoIMPL();
        tdao.setReadNotification(sdto,jdto,id);			
	}



	@Override
	public List<ShowRoundDataTOTraineeVO> getRoundDataToShowTrainee(int id) throws SQLException, DatabaseException {
      TraineeDaoIMPL dao=new TraineeDaoIMPL();
       List <ShowRoundDataTOTraineeVO> list=dao.getRoundDataToShowTrainee(id);
       return list;
	}

	@Override
	public void setReadRoundNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException {
		// TODO Auto-generated method stub
		 TraineeDaoIMPL tdao=new TraineeDaoIMPL();
	        tdao.setReadRoundNotification(sdto,id);
	}

	@Override
	public void setReadRoundNotification(StatusDTO sdto, JobPostingDTO jdto,InterviewRoundDTO irdto,int id) throws SQLException, DatabaseException {
		// TODO Auto-generated method stub
		TraineeDaoIMPL tdao=new TraineeDaoIMPL();
        tdao.setReadRoundNotification(sdto,jdto,irdto,id);
	}
	public Map<Integer, String> getfeedbacktype() {

		TraineeDaoIMPL tdaoimpl=new TraineeDaoIMPL();
		 Map m=tdaoimpl.getfeedbacktype();	
		return m;
	}

	public Map<Integer, String> getClientName(int clientid) {
		TraineeDaoI tdao=new TraineeDaoIMPL();
		Map map=tdao.getClientName(clientid);
		return map;
		}

	public Map<Integer, String> getClientName(int clientid,int userId) {
		TraineeDaoI tdao=new TraineeDaoIMPL();
		Map map=tdao.getClientName(clientid,userId);
		return map;
		}
	
	@Override
	public int addFeedBack(FeedbackDTO objFeedbackDTO) {
		// TODO Auto-generated method stub
		TraineeDaoI objTraineeDaoI=new TraineeDaoIMPL();
		
		int res=objTraineeDaoI.addFeedBack(objFeedbackDTO);
		
		return res;
	}
}
