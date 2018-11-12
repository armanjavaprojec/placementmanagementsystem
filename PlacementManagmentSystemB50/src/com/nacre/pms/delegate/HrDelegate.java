package com.nacre.pms.delegate;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.ParseException;

import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.daoi.HrDaoI;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.EducationTypeDTO;
import com.nacre.pms.dto.EducationalTypeDetailsDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingChangeDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.JobPostingResultDTO;
import com.nacre.pms.dto.LocationDTO;
import com.nacre.pms.dto.SpecializationDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.StreamDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.servicei.serviceimpl.HrServiceIMPL;
import com.nacre.pms.util.DateUtil;
import com.nacre.pms.vo.AssignVo;
import com.nacre.pms.vo.HR_Add_TraineeVO;
import com.nacre.pms.vo.JobPostingChangeVO;
import com.nacre.pms.vo.JobPostingResultVO;
import com.nacre.pms.vo.LocationVO;
import com.nacre.pms.vo.PlacedResultVO;
import com.nacre.pms.vo.TechnologyFilterVO;
import com.nacre.pms.vo.TechnologyVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to dvelop the HR
 *         Functionalities
 */
public class HrDelegate {
	HrServiceI hs = new HrServiceIMPL();

	public List<PlacedResultVO> viewPlaced(int clientId, int addressId)
			throws SQLException, DatabaseException, ParseException {
		List<PlacedResultVO> placedResultVOList = null;
		placedResultVOList = hs.viewPlaced(clientId, addressId);
		return placedResultVOList;
	}

	public Map<Integer, String> getAllBatch() throws DatabaseException, SQLException {
		Map<Integer, String> map = new HashMap<>();
		map = hs.getAllBatch();
		return map;
	}

	public List<TechnologyFilterVO> getTechnology1(int batchId) throws DatabaseException, SQLException {
		List<TechnologyFilterVO> techFilterVO = new ArrayList<>();
		techFilterVO = hs.getTechnology1(batchId);
		return techFilterVO;
	}

	public void setReadNotification(StatusDTO sdto) throws SQLException, DatabaseException {
		hs.setReadNotification(sdto);
	}

	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto) throws SQLException, DatabaseException {
		hs.setReadNotification(sdto, jdto);
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return batches in the form of key,value from the service
	 */
	public Map getBatch() throws SQLException, DatabaseException {
		return hs.getBatch();
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return technologies in the form of key,value from the service
	 */
	public Map getTechnology(int batch_id) throws SQLException, DatabaseException {
		return hs.getTechnology(batch_id);
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return countries in the form of key,value from the service
	 */
	public Map getCountry() throws SQLException, DatabaseException {
		return hs.getCountry();
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return States in the form of key,value from the service
	 */
	public Map getState(int country_id) throws SQLException, DatabaseException {
		return hs.getState(country_id);
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Cities in the form of key,value from the service
	 */
	public Map getCity(int state_id) throws SQLException, DatabaseException {
		return hs.getCity(state_id);
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Streams in the form of key,value from the service
	 */
	public Map getGraduationStream() throws SQLException, DatabaseException {
		return hs.getGraduationStream();
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Streams in the form of key,value from the service
	 */
	public Map getPGraduationStream() throws SQLException, DatabaseException {
		return hs.getPGraduationStream();
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Specailization in the form of key,value from the service
	 */
	public Map getGraduationSpecilization(int gid) throws SQLException, DatabaseException {
		return hs.getGraduationSpecilization(gid);
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Specailization in the form of key,value from the
	 *         service
	 */
	public Map getPGraduationSpecilization(int pgid) throws SQLException, DatabaseException {
		return hs.getGraduationSpecilization(pgid);
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return
	 */
	public String hrAddTraineePostGraduation(HR_Add_TraineeVO addtraineevo)
			throws SQLException, DatabaseException, FileNotFoundException {
		int bid = Integer.parseInt(addtraineevo.getBatch_id());
		int tid = Integer.parseInt(addtraineevo.getTechnology_id());
		String mblno = addtraineevo.getMobileno();
		int countryid = Integer.parseInt(addtraineevo.getCountry_id());
		int stateid = Integer.parseInt(addtraineevo.getState_id());
		int cityid = Integer.parseInt(addtraineevo.getCity_id());
		Date dob = DateUtil.stringToSqlDate(addtraineevo.getD_o_b(), "yyyy-mm-dd");
		BatchDTO bdto = new BatchDTO();
		bdto.setBatchId(bid);
		TechnologyDTO tdto = new TechnologyDTO();
		tdto.setTechnologyId(tid);
		BatchTechnologyDTO btdto = new BatchTechnologyDTO();
		btdto.setBatch(bdto);
		btdto.setTechnology(tdto);

		CountryDTO countrydto = new CountryDTO();
		countrydto.setCountryId(countryid);

		StateDTO statedto = new StateDTO();
		statedto.setStateId(stateid);
		statedto.setCountry(countrydto);

		CityDTO citydto = new CityDTO();
		citydto.setCityId(cityid);
		citydto.setState(statedto);

		AddressDTO adddto = new AddressDTO();
		adddto.setLocation(addtraineevo.getLocation());
		adddto.setPincode(Integer.parseInt(addtraineevo.getPincode()));
		adddto.setCity(citydto);

		UserDTO udto = new UserDTO();
		udto.setFirstname(addtraineevo.getFirst_name());
		udto.setLastname(addtraineevo.getLast_name());
		udto.setMobileNo(mblno);
		udto.setEmail(addtraineevo.getEmail());
		udto.setDate(dob);
		udto.setImage(addtraineevo.getImage());
		udto.setGender(Integer.parseInt(addtraineevo.getGender()));
		udto.setAddress(adddto);
		udto.setBatchTechnology(btdto);

		List<EducationalTypeDetailsDTO> etdList = new ArrayList();

		EducationTypeDTO essc = new EducationTypeDTO();
		essc.setGraduDetailsId(Integer.parseInt(addtraineevo.getSsc_id()));

		EducationTypeDTO ehsc = new EducationTypeDTO();
		ehsc.setGraduDetailsId(Integer.parseInt(addtraineevo.getHsc_id()));

		EducationTypeDTO eg = new EducationTypeDTO();
		eg.setGraduDetailsId(Integer.parseInt(addtraineevo.getGraduation_id()));

		EducationTypeDTO epg = new EducationTypeDTO();
		epg.setGraduDetailsId(Integer.parseInt(addtraineevo.getPgraduation_id()));

		StreamDTO sstream = new StreamDTO();
		sstream.setStreamId(Integer.parseInt(addtraineevo.getSstream_id()));

		StreamDTO hstream = new StreamDTO();
		hstream.setStreamId(Integer.parseInt(addtraineevo.getHstream_id()));

		StreamDTO gstream = new StreamDTO();
		gstream.setStreamId(Integer.parseInt(addtraineevo.getGstream_id()));

		StreamDTO pgstream = new StreamDTO();
		pgstream.setStreamId(Integer.parseInt(addtraineevo.getPgstream_id()));

		SpecializationDTO sspecilization = new SpecializationDTO();
		sspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getSspecilization()));
		sspecilization.setObjStreamDTO(sstream);

		SpecializationDTO hspecilization = new SpecializationDTO();
		hspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getHspecilization()));
		hspecilization.setObjStreamDTO(hstream);

		SpecializationDTO gspecilization = new SpecializationDTO();
		gspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getGspecilization()));
		gspecilization.setObjStreamDTO(gstream);

		SpecializationDTO pgspecilization = new SpecializationDTO();
		pgspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getPgspecilization()));
		pgspecilization.setObjStreamDTO(pgstream);

		EducationalTypeDetailsDTO edssc = new EducationalTypeDetailsDTO();
		edssc.setPercentage(Float.parseFloat(addtraineevo.getSpercentage()));
		edssc.setYop(Integer.parseInt(addtraineevo.getSyop()));
		edssc.setEducationTypeDTO(essc);
		edssc.setUserDTO(udto);
		edssc.setSpecializationDTO(sspecilization);

		EducationalTypeDetailsDTO edhsc = new EducationalTypeDetailsDTO();
		edhsc.setPercentage(Float.parseFloat(addtraineevo.getHpercentage()));
		edhsc.setYop(Integer.parseInt(addtraineevo.getHyop()));
		edhsc.setEducationTypeDTO(ehsc);
		edhsc.setUserDTO(udto);
		edhsc.setSpecializationDTO(hspecilization);

		EducationalTypeDetailsDTO egn = new EducationalTypeDetailsDTO();
		egn.setPercentage(Float.parseFloat(addtraineevo.getGpercentage()));
		egn.setYop(Integer.parseInt(addtraineevo.getGyop()));
		egn.setEducationTypeDTO(eg);
		egn.setUserDTO(udto);
		egn.setSpecializationDTO(gspecilization);

		EducationalTypeDetailsDTO etpg = new EducationalTypeDetailsDTO();
		etpg.setPercentage(Float.parseFloat(addtraineevo.getPgpercentage()));
		etpg.setYop(Integer.parseInt(addtraineevo.getPgyop()));
		etpg.setEducationTypeDTO(epg);
		etpg.setUserDTO(udto);
		etpg.setSpecializationDTO(pgspecilization);

		etdList.add(edssc);
		etdList.add(edhsc);
		etdList.add(egn);
		etdList.add(etpg);

		EducationDetailsDTO eduDetailsDto = new EducationDetailsDTO();

		eduDetailsDto.setUserDTO(udto);
		eduDetailsDto.setEducationalTypeDetailsDTOList(etdList);

		return hs.hrAddTraineePostGraduation(eduDetailsDto);
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return
	 */
	public String hrAddTraineeGraduation(HR_Add_TraineeVO addtraineevo)
			throws SQLException, DatabaseException, FileNotFoundException {
		int bid = Integer.parseInt(addtraineevo.getBatch_id());
		int tid = Integer.parseInt(addtraineevo.getTechnology_id());
		String mblno = addtraineevo.getMobileno();
		int countryid = Integer.parseInt(addtraineevo.getCountry_id());
		int stateid = Integer.parseInt(addtraineevo.getState_id());
		int cityid = Integer.parseInt(addtraineevo.getCity_id());
		Date dob = DateUtil.stringToSqlDate(addtraineevo.getD_o_b(), "yyyy-mm-dd");
		BatchDTO bdto = new BatchDTO();
		bdto.setBatchId(bid);
		TechnologyDTO tdto = new TechnologyDTO();
		tdto.setTechnologyId(tid);
		BatchTechnologyDTO btdto = new BatchTechnologyDTO();
		btdto.setBatch(bdto);
		btdto.setTechnology(tdto);

		CountryDTO countrydto = new CountryDTO();
		countrydto.setCountryId(countryid);

		StateDTO statedto = new StateDTO();
		statedto.setStateId(stateid);
		statedto.setCountry(countrydto);

		CityDTO citydto = new CityDTO();
		citydto.setCityId(cityid);
		citydto.setState(statedto);

		AddressDTO adddto = new AddressDTO();
		adddto.setLocation(addtraineevo.getLocation());
		adddto.setPincode(Integer.parseInt(addtraineevo.getPincode()));
		adddto.setCity(citydto);

		UserDTO udto = new UserDTO();
		udto.setFirstname(addtraineevo.getFirst_name());
		udto.setLastname(addtraineevo.getLast_name());
		udto.setMobileNo(mblno);
		udto.setEmail(addtraineevo.getEmail());
		udto.setDate(dob);
		udto.setImage(addtraineevo.getImage());
		udto.setGender(Integer.parseInt(addtraineevo.getGender()));
		udto.setAddress(adddto);
		udto.setBatchTechnology(btdto);

		List<EducationalTypeDetailsDTO> etdList = new ArrayList();

		EducationTypeDTO essc = new EducationTypeDTO();
		essc.setGraduDetailsId(Integer.parseInt(addtraineevo.getSsc_id()));

		EducationTypeDTO ehsc = new EducationTypeDTO();
		ehsc.setGraduDetailsId(Integer.parseInt(addtraineevo.getHsc_id()));

		EducationTypeDTO eg = new EducationTypeDTO();
		eg.setGraduDetailsId(Integer.parseInt(addtraineevo.getGraduation_id()));

		EducationTypeDTO epg = new EducationTypeDTO();
		epg.setGraduDetailsId(Integer.parseInt(addtraineevo.getPgraduation_id()));

		StreamDTO sstream = new StreamDTO();
		sstream.setStreamId(Integer.parseInt(addtraineevo.getSstream_id()));

		StreamDTO hstream = new StreamDTO();
		hstream.setStreamId(Integer.parseInt(addtraineevo.getHstream_id()));

		StreamDTO gstream = new StreamDTO();
		gstream.setStreamId(Integer.parseInt(addtraineevo.getGstream_id()));

		StreamDTO pgstream = new StreamDTO();
		pgstream.setStreamId(Integer.parseInt(addtraineevo.getPgstream_id()));

		SpecializationDTO sspecilization = new SpecializationDTO();
		sspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getSspecilization()));
		sspecilization.setObjStreamDTO(sstream);

		SpecializationDTO hspecilization = new SpecializationDTO();
		hspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getHspecilization()));
		hspecilization.setObjStreamDTO(hstream);

		SpecializationDTO gspecilization = new SpecializationDTO();
		gspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getGspecilization()));
		gspecilization.setObjStreamDTO(gstream);

		SpecializationDTO pgspecilization = new SpecializationDTO();
		pgspecilization.setSpecializationId(Integer.parseInt(addtraineevo.getPgspecilization()));
		pgspecilization.setObjStreamDTO(pgstream);

		EducationalTypeDetailsDTO edssc = new EducationalTypeDetailsDTO();
		edssc.setPercentage(Float.parseFloat(addtraineevo.getSpercentage()));
		edssc.setYop(Integer.parseInt(addtraineevo.getSyop()));
		edssc.setEducationTypeDTO(essc);
		edssc.setUserDTO(udto);
		edssc.setSpecializationDTO(sspecilization);

		EducationalTypeDetailsDTO edhsc = new EducationalTypeDetailsDTO();
		edhsc.setPercentage(Float.parseFloat(addtraineevo.getHpercentage()));
		edhsc.setYop(Integer.parseInt(addtraineevo.getHyop()));
		edhsc.setEducationTypeDTO(ehsc);
		edhsc.setUserDTO(udto);
		edhsc.setSpecializationDTO(hspecilization);

		EducationalTypeDetailsDTO egn = new EducationalTypeDetailsDTO();
		egn.setPercentage(Float.parseFloat(addtraineevo.getGpercentage()));
		egn.setYop(Integer.parseInt(addtraineevo.getGyop()));
		egn.setEducationTypeDTO(eg);
		egn.setUserDTO(udto);
		egn.setSpecializationDTO(gspecilization);

		EducationalTypeDetailsDTO epgn = new EducationalTypeDetailsDTO();
		epgn.setPercentage(Float.parseFloat(addtraineevo.getPgpercentage()));
		epgn.setYop(Integer.parseInt(addtraineevo.getPgyop()));
		epgn.setEducationTypeDTO(epg);
		epgn.setUserDTO(udto);
		epgn.setSpecializationDTO(pgspecilization);

		etdList.add(edssc);
		etdList.add(edhsc);
		etdList.add(egn);
		etdList.add(epgn);

		EducationDetailsDTO eduDetailsDto = new EducationDetailsDTO();

		eduDetailsDto.setUserDTO(udto);
		eduDetailsDto.setEducationalTypeDetailsDTOList(etdList);

		return hs.hrAddTraineeGraduation(eduDetailsDto);
	}

	public String addJobPosting(JobPostingChangeVO jobPostingChangeVO) throws DatabaseException, SQLException {
		JobPostingChangeDTO jobPostingChangeDTO = null;
		String result = null;
		jobPostingChangeDTO = new JobPostingChangeDTO();
		jobPostingChangeDTO.setDescription(jobPostingChangeVO.getDescription());
		jobPostingChangeDTO.setExpectedDate(jobPostingChangeVO.getExpectedDate());
		jobPostingChangeDTO.setPostDate(jobPostingChangeVO.getPostDate());
		jobPostingChangeDTO.setNoOfVacancies(Integer.valueOf(jobPostingChangeVO.getNoOfVacancies()));
		jobPostingChangeDTO.setClientAddressId(Integer.parseInt(jobPostingChangeVO.getClientAddressId()));
		result = hs.addJobPosting(jobPostingChangeDTO);
		return result;
	}

	public Map<Integer, String> getBatches() throws DatabaseException, SQLException {
		Map<Integer, String> mapBatches = hs.getBatches();
		return mapBatches;
	}

	public Map<Integer, String> getAssignedTechnologies(int batchKey) throws DatabaseException, SQLException {
		Map<Integer, String> mapTechnologies = hs.getAssignedTechnologies(batchKey);
		return mapTechnologies;
	}

	public List<UserDTO> getAllTrInfo(int batchId, int techId) throws DatabaseException, SQLException {
		List<UserDTO> objAllTRInfo = hs.returnTR(batchId, techId);
		return objAllTRInfo;
	}

	public int deleteTrainee(int userId) throws DatabaseException, SQLException {
		int res = hs.deleteTrainee(userId);
		return res;
	}

	public UserDTO getTraineeDetails(int userId) {
		UserDTO objUserDTO = hs.getTraineeDetails(userId);
		return objUserDTO;
	}

	public List<UserEducationDetailsBO> getTraineeEduDetails(int userId) {
		List<UserEducationDetailsBO> listEducation = hs.getTraineeEduDetails(userId);
		return listEducation;
	}

	public Map<Integer, String> getStreams(int key) throws DatabaseException, SQLException {
		Map<Integer, String> mapStreams = hs.getStreams(key);
		return mapStreams;
	}

	public Map<Integer, String> getSpecializations() throws DatabaseException, SQLException {
		Map<Integer, String> mapSpecializations = hs.getSpecializations();
		return mapSpecializations;
	}

	public String updateEducation(List<EducationDetailsDTO> listEducation, Integer userId) {
		String res = hs.updateEducation(listEducation, userId);
		return res;
	}

	public Map<Integer, String> getSpecializations(int key) throws DatabaseException, SQLException {
		Map<Integer, String> mapSpecializations = hs.getSpecializations(key);
		return mapSpecializations;
	}

	public List<JobPostingResultVO> viewJobPostings(int clientId, int addressId)
			throws SQLException, DatabaseException, ParseException, java.text.ParseException {
		JobPostingResultVO jobPostResultVO = null;
		List<JobPostingResultDTO> jobPostResultDTOList = null;
		List<JobPostingResultVO> jobPostResultVOList = null;
		jobPostResultDTOList = hs.viewJobPostings(clientId, addressId);
		jobPostResultVOList = new ArrayList<>();
		Iterator itr = jobPostResultDTOList.iterator();
		while (itr.hasNext()) {
			JobPostingResultDTO jobPostResultDTO = (JobPostingResultDTO) itr.next();
			jobPostResultVO = new JobPostingResultVO();
			jobPostResultVO.setJobPostingId(Integer.valueOf(jobPostResultDTO.getJobPostingId()).toString());
			jobPostResultVO.setClientName(jobPostResultDTO.getClientName());
			jobPostResultVO.setLocation(jobPostResultDTO.getLocation());
			jobPostResultVO.setCpName(jobPostResultDTO.getCpName());
			jobPostResultVO.setCpMobile(Long.valueOf(jobPostResultDTO.getCpMobile()).toString());
			jobPostResultVO.setCpEmail(jobPostResultDTO.getCpEmail());
			jobPostResultVO.setDescription(jobPostResultDTO.getDescription());

			String ds1 = jobPostResultDTO.getExpDate();
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
			String ds2 = sdf2.format(sdf1.parse(ds1));

			String ds3 = jobPostResultDTO.getPostDate();
			String ds4 = sdf2.format(sdf1.parse(ds3));

			jobPostResultVO.setExpDate(ds2);
			jobPostResultVO.setPostDate(ds4);
			jobPostResultVO.setNoOfVacancies(Integer.valueOf(jobPostResultDTO.getNoOfVacancies()).toString());
			jobPostResultVO.setClientAddressId(Integer.valueOf(jobPostResultDTO.getClientAddressId()).toString());
			jobPostResultVOList.add(jobPostResultVO);
		}

		return jobPostResultVOList;
	}

	public String deleteJobPostById(int jobId) throws DatabaseException, SQLException {
		String result = null;
		result = hs.deleteJobPostById(jobId);
		return result;
	}

	public String updateJobPostById(JobPostingChangeVO jobPostingChangeVO) throws DatabaseException, SQLException {
		JobPostingChangeDTO jobPostingChangeDTO = null;
		String result = null;

		jobPostingChangeDTO = new JobPostingChangeDTO();
		jobPostingChangeDTO.setJobPostId(Integer.parseInt(jobPostingChangeVO.getJobPostId()));
		jobPostingChangeDTO.setDescription(jobPostingChangeVO.getDescription());
		jobPostingChangeDTO.setExpectedDate(jobPostingChangeVO.getExpectedDate());
		jobPostingChangeDTO.setPostDate(jobPostingChangeVO.getPostDate());
		jobPostingChangeDTO.setNoOfVacancies(Integer.valueOf(jobPostingChangeVO.getNoOfVacancies()));

		result = hs.updateJobPostById(jobPostingChangeDTO);
		return result;
	}

	public Map<Integer, String> getAllClients() throws DatabaseException, SQLException {
		Map<Integer, String> map = new HashMap<>();
		map = hs.getAllClients();
		return map;
	}

	public List<LocationVO> getClientLocations(int clientId) throws DatabaseException, SQLException {
		List<LocationDTO> ldto = new ArrayList<>();
		List<LocationVO> lvo = new ArrayList<>();
		LocationDTO dto = null;
		LocationVO vo = null;
		ldto = hs.getClientLocations(clientId);
		Iterator itr = ldto.iterator();
		while (itr.hasNext()) {
			dto = new LocationDTO();
			vo = new LocationVO();
			dto = (LocationDTO) itr.next();
			vo.setAddressId(Integer.valueOf(dto.getAddressId()).toString());
			vo.setAddress(dto.getAddress());
			vo.setPinCode(Integer.valueOf(dto.getPinCode()).toString());
			vo.setCity(dto.getCity());
			vo.setState(dto.getState());
			vo.setCountry(dto.getCountry());
			vo.setClientAddressId(Integer.valueOf(dto.getClientAddressId()).toString());

			lvo.add(vo);
		}
		return lvo;
	}

	public List sendData() throws DatabaseException, SQLException {
		List list = null;
		list = hs.viewBatch();
		return list;
	}

	public int sendId(int batchId) throws SQLException, DatabaseException {
		int count = hs.sendBatchId(batchId);
		return count;
	}

	public int updateBatch(BatchDTO dto) throws SQLException, DatabaseException {
		int update = hs.updateBatch(dto);
		return update;
	}

	public int addBatch(BatchDTO dto) throws SQLException, DatabaseException {
		int update = hs.addBatch(dto);
		return update;
	}

	public List getBatchData(int bid) throws DatabaseException, SQLException {
		List batchDto = hs.retrieveToUpdate(bid);
		return batchDto;
	}

	/*
	 * @author Tanaji
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * This method is used to getting a batch details from database using map object
	 * inside that calling a serviceIMpl getBatch(id) method getting a batch details
	 * based on id
	 */
	public Map<BatchDTO, BatchDTO> getBatchs() throws ClassNotFoundException, SQLException, DatabaseException {
		return hs.getBatchs();
	}

	/*
	 * @author Tanaji
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * This method is used to getting a technology details from database using map
	 * object inside that calling a serviceIMpl getTechnpology method
	 */
	public Map<TechnologyDTO, TechnologyDTO> getTech(int bid)
			throws SQLException, DatabaseException, ClassNotFoundException {
		return hs.getTech(bid);
	}

	/*
	 * @author Tanaji
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * This method is used to storing technology and batch details in database using
	 * 
	 */
	public String insertBatchtech(int bid, int techid) throws DatabaseException, SQLException {
		return hs.insertBatchandTech(bid, techid);
	}

	/*
	 * @author Tanaji
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * This method is used to storing technology and batch details in database using
	 * 
	 */

	public List<AssignVo> getAllAssignedTechAndBatches() throws DatabaseException, SQLException {
		// use service
		List<AssignVo> list = hs.fetchAllBatchesAndTechnologies();
		return list;
	}

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * ViewTechnology() method is used to get the data from HrServiceIMPL class.
	 */
	public List<TechnologyDTO> viewTechnology() throws DatabaseException, SQLException {
		return hs.viewTechnology();
	}

	/*
	 * /*@author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java editTechnology() method is used to get the data
	 * from EditTechnology controller class.
	 */
	public List<TechnologyDTO> editTechnology(int tid) throws DatabaseException, SQLException {
		return hs.editTechnology(tid);
	}

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * updateTechnology() method is used to get the data from UpdateTechnology
	 * controller class.
	 */
	public int updateTechnology(int techid, String techname) throws DatabaseException, SQLException {
		return hs.updateTechnology(techid, techname);
	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java
	 * 
	 * insertTech() method is used to insert the data into Technology table.
	 */
	public int insertTech(TechnologyVO techvo) throws SQLException, DatabaseException {
		TechnologyDTO tdto = new TechnologyDTO();
		tdto.setTechnology(techvo.getTechnology());
		return hs.insertTech(tdto);
	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java deleteTech() method is used to insert the data
	 * into Technology table.
	 */
	public int deleteTech(int techid) throws SQLException, DatabaseException {
		TechnologyDTO tdto = new TechnologyDTO();
		tdto.setTechnologyId(techid);
		return hs.deleteTech(tdto);
	}

	public List<BatchDTO> getBatchByHr() throws DatabaseException, SQLException {
		return hs.getBatchByHr();
	}

	public List<TechnologyDTO> getTechnologies() throws DatabaseException, SQLException {
		return hs.getTechnologies();
	}

	public List<Integer> getyop() throws SQLException, DatabaseException {
		return hs.getyop();
	}

	public List<String> getSpecilization() throws SQLException, DatabaseException {
		return hs.getSpecilization();
	}

	public List<String> getStream() throws SQLException, DatabaseException {
		return hs.getStream();
	}

	public List viewTraineeDetails(BatchTechnologyDTO btdto) throws DatabaseException, SQLException {
		return hs.viewTraineeDetails(btdto);
	}

	public List<JobPostingDTO> getRequirementDetails(int pid) throws DatabaseException, SQLException {
		return hs.getRequirementDetails(pid);
	}

	public InterviewRoundDTO getinterviewRounds(int jobpostid) throws DatabaseException, SQLException {
		return hs.getinterviewRounds(jobpostid);
	}

	

	public List<UserDTO> getSelectedTrainees() throws DatabaseException, SQLException {
		return hs.getSelectedTrainees();
	}

	public int insertEligibleTraiees(int userid, int pid) throws DatabaseException, SQLException {
		// TODO Auto-generated method stub
		return hs.insertEligibleTraiees(userid, pid);
	}
}
