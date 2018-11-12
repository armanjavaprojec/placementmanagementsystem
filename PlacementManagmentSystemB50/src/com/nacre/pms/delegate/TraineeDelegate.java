package com.nacre.pms.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.EducationTypeDTO;
import com.nacre.pms.dto.EducationalTypeDetailsDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.SpecializationDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.StreamDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.TraineeServiceI;
import com.nacre.pms.servicei.serviceimpl.TraineeServiceIMPL;
import com.nacre.pms.util.DateUtil;
import com.nacre.pms.vo.ShowRoundDataTOTraineeVO;
import com.nacre.pms.vo.TraineeVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the Trainee
 *         Functionalities
 */
public class TraineeDelegate {
	TraineeServiceI ts = new TraineeServiceIMPL();
	EducationDetailsDTO educationDetailsDTO = null;
	UserDTO userDTO = null;
	EducationalTypeDetailsDTO educationalTypeDetailsDTO = null;
	AddressDTO addressDTO = null;
	SpecializationDTO specializationDTO = null;
	StreamDTO streamDTO = null;
	CityDTO cityDTO = null;
	StateDTO StateDTO = null;
	CountryDTO countryDTO = null;
	EducationTypeDTO educationTypeDTO = null;
	TraineeVO vo = null;
	StateDTO stateDTO;

	public TraineeVO getTraineeForEdit(String email) {
		userDTO = ts.getTraineeForEdit(email);
		vo = new TraineeVO();
		vo.setUserId(((Integer) userDTO.getUserid()).toString());
		vo.setFirstName(userDTO.getFirstname());
		vo.setLastName(userDTO.getLastname());
		vo.setMobno(String.valueOf(userDTO.getMobileNo()));
		vo.setDob(userDTO.getDate().toString());
		vo.setLocation(userDTO.getAddress().getLocation().toString());
		vo.setPincode(String.valueOf(userDTO.getAddress().getPincode()));
		vo.setCity(userDTO.getAddress().getCity().getCity().toString());
		vo.setState(userDTO.getAddress().getCity().getState().getState().toString());
		vo.setCountry(userDTO.getAddress().getCity().getState().getCountry().getCountry().toString());
		return vo;
	}

	public Map<Integer, String> getCountry() {
		return ts.getCountry();
	}

	public Map<Integer, String> getState(int country_id) {
		return ts.getState(country_id);
	}

	public Map<Integer, String> getCity(int state_id) {
		return ts.getCity(state_id);
	}

	public String updateTrainee(TraineeVO vo) {
		ts = new TraineeServiceIMPL();
		userDTO = new UserDTO();
		Date dob = DateUtil.stringToSqlDate(vo.getDob(), "yyyy-mm-dd");
		userDTO.setEmail(vo.getEmail());
		userDTO.setFirstname(vo.getFirstName());
		userDTO.setLastname(vo.getLastName());
		userDTO.setDate(dob);
		userDTO.setMobileNo(vo.getMobno());
		userDTO.setImage(vo.getImage());

		CountryDTO ctyDto = new CountryDTO();
		ctyDto.setCountry(vo.getCountry());

		StateDTO stateDTO = new StateDTO();
		stateDTO.setState(vo.getState());
		stateDTO.setCountry(ctyDto);

		CityDTO cityDTO = new CityDTO();
		cityDTO.setCity(vo.getCity());
		cityDTO.setState(stateDTO);

		addressDTO = new AddressDTO();
		addressDTO.setLocation(vo.getLocation());
		addressDTO.setPincode(Integer.parseInt(vo.getPincode()));
		addressDTO.setCity(cityDTO);

		userDTO.setAddress(addressDTO);
		String msg = ts.updateTraineeDetails(userDTO);
		return msg;
	}

	public String registerTraineesByList(List<TraineeVO> list) {
		List<EducationDetailsDTO> listEdDTO = new ArrayList<>();
		list.forEach(vo -> {
			List<EducationalTypeDetailsDTO> listDto = new ArrayList();
			EducationDetailsDTO edDto = new EducationDetailsDTO();
			BatchDTO bDto = new BatchDTO();
			bDto.setBatch(vo.getBatchName());
			TechnologyDTO tDto = new TechnologyDTO();
			tDto.setTechnology(vo.getTechnology());
			BatchTechnologyDTO btDto = new BatchTechnologyDTO();
			btDto.setBatch(bDto);
			btDto.setTechnology(tDto);
			CountryDTO ctyDto = new CountryDTO();
			ctyDto.setCountry(vo.getCountry());
			StateDTO sDto = new StateDTO();
			sDto.setState(vo.getState());
			sDto.setCountry(ctyDto);
			CityDTO cDto = new CityDTO();
			cDto.setCity(vo.getCity());
			cDto.setState(sDto);
			AddressDTO aDto = new AddressDTO();
			aDto.setLocation(vo.getLocation());
			aDto.setPincode((int) Double.parseDouble(vo.getPincode()));
			aDto.setCity(cDto);
			// user
			UserDTO uDto = new UserDTO();
			uDto.setFirstname(vo.getFirstName());
			uDto.setLastname(vo.getLastName());
			uDto.setEmail(vo.getEmail());
			uDto.setImage(vo.getImage());
			uDto.setGender((int) Double.parseDouble(vo.getGender()));
			uDto.setMobileNo(vo.getMobno());
			uDto.setDate(DateUtil.getSqlFromStringDate(vo.getDob()));
			uDto.setPassword(vo.getPassword());
			uDto.setBatchTechnology(btDto);
			uDto.setAddress(aDto);
			edDto.setUserDTO(uDto);
			// SSC
			EducationTypeDTO sscDto = new EducationTypeDTO();
			sscDto.setGraduationType("ssc");
			EducationalTypeDetailsDTO sscETDTO = new EducationalTypeDetailsDTO();
			sscETDTO.setEducationTypeDTO(sscDto);
			sscETDTO.setPercentage((int) Double.parseDouble(vo.getSscPercentage()));
			sscETDTO.setYop((int) Double.parseDouble(vo.getSscYop()));
			// HSE
			EducationTypeDTO hscDto = new EducationTypeDTO();
			hscDto.setGraduationType("hse");
			EducationalTypeDetailsDTO hseETDTO = new EducationalTypeDetailsDTO();
			hseETDTO.setEducationTypeDTO(hscDto);
			hseETDTO.setPercentage(Float.parseFloat(vo.getHsePercentage()));
			hseETDTO.setYop((int) Double.parseDouble(vo.getHseYop()));
			// graduation Details
			StreamDTO gStr = new StreamDTO();
			gStr.setStream(vo.getGraduationStream());
			SpecializationDTO gSpe = new SpecializationDTO();
			gSpe.setSpecialization(vo.getGraduationSpecialization());
			gSpe.setObjStreamDTO(gStr);
			EducationTypeDTO graDto = new EducationTypeDTO();
			graDto.setGraduationType("graduation");
			EducationalTypeDetailsDTO graduationETDTO = new EducationalTypeDetailsDTO();
			graduationETDTO.setEducationTypeDTO(graDto);
			// graduationETDTO.setUserDTO(uDto);
			graduationETDTO.setPercentage(Float.parseFloat(vo.getGraduationPercentage()));
			graduationETDTO.setSpecializationDTO(gSpe);
			graduationETDTO.setYop((int) Double.parseDouble(vo.getGraduationYop()));
			// postGraduation
			StreamDTO pgStr = new StreamDTO();
			pgStr.setStream(vo.getPostGraduationStream());
			SpecializationDTO pgSpe = new SpecializationDTO();
			pgSpe.setSpecialization(vo.getPostGraduationSpecialization());
			pgSpe.setObjStreamDTO(pgStr);
			EducationTypeDTO pgraDto = new EducationTypeDTO();
			pgraDto.setGraduationType("postGraduation");
			EducationalTypeDetailsDTO postGraduationETDTO = new EducationalTypeDetailsDTO();
			if (!vo.getPostGraduationYop().equals("null")) {
				postGraduationETDTO.setEducationTypeDTO(pgraDto);
				// postGraduationETDTO.setUserDTO(uDto);
				postGraduationETDTO.setPercentage(Float.parseFloat(vo.getPostGraduationPercentage()));
				postGraduationETDTO.setSpecializationDTO(pgSpe);
				postGraduationETDTO.setYop((int) Double.parseDouble(vo.getPostGraduationYop()));
			}
			listDto.add(sscETDTO);
			listDto.add(hseETDTO);
			listDto.add(graduationETDTO);
			listDto.add(postGraduationETDTO);
			edDto.setEducationalTypeDetailsDTOList(listDto);
			listEdDTO.add(edDto);
		});
		return ts.registerTraineesByExcel(listEdDTO);
	}

	public List<Object> getClientData(int id) throws SQLException, DatabaseException {
		List<Object> list = ts.getClientData(id);
		return list;
	}

	public void setReadNotification(StatusDTO sdto, int id) throws SQLException, DatabaseException {
		ts.setReadNotification(sdto,id);
	}

	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto, int id) throws SQLException, DatabaseException {
		ts.setReadNotification(sdto, jdto,id);
	}

	public List<ShowRoundDataTOTraineeVO> getRoundDataToShowTrainee(int id) throws SQLException, DatabaseException {
		List<ShowRoundDataTOTraineeVO> list = ts.getRoundDataToShowTrainee(id);
		return list;
	}

	public void setReadRoundNotification(StatusDTO sdto, int id) throws SQLException, DatabaseException {
		ts.setReadRoundNotification(sdto,id);
	}

	public void setReadRoundNotification(StatusDTO sdto, JobPostingDTO jdto, InterviewRoundDTO irdto,int id)
			throws SQLException, DatabaseException {
		ts.setReadRoundNotification(sdto, jdto, irdto,id);
	}

	public Map<Integer, String> getClientName(int clientid) {
		return ts.getClientName(clientid);
	}

	public Map<Integer, String> getClientName(int clientid, int userId) {
		return ts.getClientName(clientid, userId);
	}

	public int addFeedBack(FeedbackDTO objFeedbackDTO) {
		int res = ts.addFeedBack(objFeedbackDTO);
		return res;
	}
}
