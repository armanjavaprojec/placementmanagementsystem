package com.nacre.pms.servicei.serviceimpl;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.AddressBO;
import com.nacre.pms.bo.BatchBO;
import com.nacre.pms.bo.BatchTechnologyBO;
import com.nacre.pms.bo.CityBO;
import com.nacre.pms.bo.CountryBO;
import com.nacre.pms.bo.EducationDetailsBO;
import com.nacre.pms.bo.EducationTypeBO;
import com.nacre.pms.bo.EducationalTypeDetailsBO;
import com.nacre.pms.bo.InterviewRoundBO;
import com.nacre.pms.bo.JobPostingBO;
import com.nacre.pms.bo.JobPostingChangeBO;
import com.nacre.pms.bo.JobPostingResultBO;
import com.nacre.pms.bo.SpecializationBO;
import com.nacre.pms.bo.StateBO;
import com.nacre.pms.bo.StreamBO;
import com.nacre.pms.bo.TechnologyBO;
import com.nacre.pms.bo.UserBO;
import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.daoi.HrDaoI;
import com.nacre.pms.daoi.TraineeDaoI;
import com.nacre.pms.daoi.daoimpl.HrDaoIMPL;
import com.nacre.pms.daoi.daoimpl.TraineeDaoIMPL;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.CityDTO;
import com.nacre.pms.dto.ClientAddressDTO;
import com.nacre.pms.dto.ClientDTO;
import com.nacre.pms.dto.CountryDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.EducationTypeDTO;
import com.nacre.pms.dto.EducationalTypeDetailsDTO;
import com.nacre.pms.dto.FilterTraieesDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingChangeDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.JobPostingResultDTO;
import com.nacre.pms.dto.LevelDTO;
import com.nacre.pms.dto.LocationDTO;
import com.nacre.pms.dto.SpecializationDTO;
import com.nacre.pms.dto.StateDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.StreamDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.servicei.HrServiceI;
import com.nacre.pms.vo.AssignVo;
import com.nacre.pms.vo.PlacedResultVO;
import com.nacre.pms.vo.TechnologyFilterVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class is used to develop the HR
 *         Functionalities
 */
public class HrServiceIMPL implements HrServiceI {
	HrDaoI hd = new HrDaoIMPL();
	Connection con = null;

	@Override
	public List<PlacedResultVO> viewPlaced(int batchId, int techId) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		List<PlacedResultVO> placedResultVOlist = null;
		placedResultVOlist = hd.viewPlaced(batchId, techId, con);
		DbUtil.closeConnection(con);
		return placedResultVOlist;
	}

	@Override
	public Map<Integer, String> getAllBatch() throws DatabaseException, SQLException {
		Map<Integer, String> map = new HashMap<>();
		con = DbUtil.getConnection();
		map = hd.getAllBatch(con);
		DbUtil.closeConnection(con);
		return map;
	}

	@Override
	public List<TechnologyFilterVO> getTechnology1(int batchId) throws DatabaseException, SQLException {
		List<TechnologyFilterVO> list = new ArrayList<>();
		con = DbUtil.getConnection();
		list = hd.getTechnology(batchId, con);
		DbUtil.closeConnection(con);
		return list;
	}

	/**
	 * getJobPostingRelatedDataToHR() method is used to show all CLient notification
	 * to HR
	 */
	@Override
	public List<Object> getJobPostingRelatedDataToHR() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		List<Object> list = hd.getJobPostingRelatedDataToHR(con);
		DbUtil.closeConnection(con);
		return list;
	}

	/**
	 * setReadNotification(StatusDTO sdto) method is used for showing all
	 * notification viewd
	 */
	@Override
	public void setReadNotification(StatusDTO sdto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		hd.setReadNotification(sdto, con);
		DbUtil.closeConnection(con);
	}

	/**
	 * setReadNotification() method is used for showing single notification viewed
	 */
	@Override
	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		hd.setReadNotification(sdto, jdto, con);
		DbUtil.closeConnection(con);
	}
	// Upto atul functionality

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java ViewTechnology() method is used to get the data
	 * from technologyDaoIMPL class.
	 */
	@Override
	public List<TechnologyDTO> viewTechnology() throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List l = hd.viewTechnology(con);
		DbUtil.closeConnection(con);
		return l;
	}

	/*
	 * @author Ritushree
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java editTechnology() method is used to get the data
	 * from HrDelegate class.
	 */
	@Override
	public List<TechnologyDTO> editTechnology(int tid) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List l = hd.editTechnology(tid, con);
		DbUtil.closeConnection(con);
		return l;
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
	public int updateTechnology(int techid, String techname) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		int i = hd.updateTechnology(techid, techname, con);
		DbUtil.closeConnection(con);
		return i;
	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java insertTech() method is used to insert the data in
	 * Technology table.
	 */
	@Override
	public int insertTech(TechnologyDTO tdto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		int i = hd.insertTech(tdto, con);
		DbUtil.closeConnection(con);
		return i;
	}

	/*
	 * @author Mounika
	 * 
	 * @version 1.0.0 2018
	 * 
	 * @author Nacre Batch 50 Java deleteTech() method is used to insert the data in
	 * Technology table.
	 */
	@Override
	public int deleteTech(TechnologyDTO tdto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		int i = hd.deleteTech(tdto, con);
		DbUtil.closeConnection(con);
		return i;
	}

	@Override
	public Map<Integer, String> getBatches() throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapBatches = hd.getBatches(con);
		DbUtil.closeConnection(con);
		return mapBatches;
	}

	@Override
	public Map<Integer, String> getAssignedTechnologies(int key) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapTechnologies = hd.getAssignedTechnologies(key, con);
		DbUtil.closeConnection(con);
		return mapTechnologies;
	}

	@Override
	public List<UserDTO> returnTR(int batchId, int techId) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List<UserDTO> objAllTRInfo = hd.returnTrainees(batchId, techId, con);
		DbUtil.closeConnection(con);
		return objAllTRInfo;
	}

	@Override
	public int deleteTrainee(int userId) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		int res = hd.deleteTrainee(userId, con);
		DbUtil.closeConnection(con);
		return res;
	}

	@Override
	public UserDTO getTraineeDetails(int userId) {
		TraineeDaoI objTraineeDaoI = new TraineeDaoIMPL();
		UserDTO objUserDTO = objTraineeDaoI.getTraineeDetails(userId);
		return objUserDTO;
	}

	@Override
	public List<UserEducationDetailsBO> getTraineeEduDetails(int userId) {
		TraineeDaoI objTraineeDaoI = new TraineeDaoIMPL();
		List<UserEducationDetailsBO> listEducation = objTraineeDaoI.getTraineeEduDetails(userId);
		return listEducation;
	}

	@Override
	public Map<Integer, String> getStreams(int key) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapStreams = hd.getStreams(key, con);
		DbUtil.closeConnection(con);
		return mapStreams;
	}

	@Override
	public Map<Integer, String> getSpecializations() throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapSpecializations = hd.getSpecializations(con);
		DbUtil.closeConnection(con);
		return mapSpecializations;
	}

	@Override
	public String updateEducation(List<EducationDetailsDTO> listEducation, Integer userId) {
		TraineeDaoI objTraineeDaoI = new TraineeDaoIMPL();
		String res = objTraineeDaoI.updateEducationNewMethod(listEducation, userId);
		return res;
	}

	@Override
	public Map<Integer, String> getSpecializations(int key) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		Map<Integer, String> mapSpecializations = hd.getSpecializations(key, con);
		DbUtil.closeConnection(con);
		return mapSpecializations;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return batches in the form of key,value from the DAO
	 */
	@Override
	public Map getBatch() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getBatch(con);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Technologies in the form of key,value from the DAO
	 */
	@Override
	public Map getTechnology(int batch_id) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getTechnology(con, batch_id);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return countries in the form of key,value from the DAO
	 */
	@Override
	public Map getCountry() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getCountry(con);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return States in the form of key,value from the DAO
	 */
	@Override
	public Map getState(int country_id) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getState(con, country_id);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Cities in the form of key,value from the DAO
	 */
	@Override
	public Map getCity(int state_id) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getCity(con, state_id);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Streams in the form of key,value from the DAO
	 */
	@Override
	public Map getGraduationStream() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getGraduationStream(con);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Streams in the form of key,value from the DAO
	 */
	@Override
	public Map getPGraduationStream() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getPGraduationStream(con);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Graduation Specailizations in the form of key,value from the DAO
	 */
	@Override
	public Map getGraduationSpecilization(int gid) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getGraduationSpecilization(con, gid);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return Post Graduation Specailizations in the form of key,value from the DAO
	 */
	@Override
	public Map getPGraduationSpecilization(int pgid) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.getPGraduationSpecilization(con, pgid);
		DbUtil.closeConnection(con);
		return m;
	}

	/**
	 * @author Latha
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return
	 */
	@Override
	public String hrAddTraineePostGraduation(EducationDetailsDTO eduDetailsDto)
			throws SQLException, DatabaseException, FileNotFoundException {
		con = DbUtil.getConnection();
		BatchBO bbo = new BatchBO();
		bbo.setBatchId(eduDetailsDto.getUserDTO().getBatchTechnology().getBatch().getBatchId());
		TechnologyBO tbo = new TechnologyBO();
		tbo.setTechnologyId(eduDetailsDto.getUserDTO().getBatchTechnology().getTechnology().getTechnologyId());
		BatchTechnologyBO btbo = new BatchTechnologyBO();
		btbo.setBatch(bbo);
		btbo.setTechnology(tbo);
		CountryBO countryBO = new CountryBO();
		countryBO
				.setCountryId(eduDetailsDto.getUserDTO().getAddress().getCity().getState().getCountry().getCountryId());
		StateBO stateBO = new StateBO();
		stateBO.setStateId(eduDetailsDto.getUserDTO().getAddress().getCity().getState().getStateId());
		stateBO.setCountry(countryBO);
		CityBO cityBO = new CityBO();
		cityBO.setCityId(eduDetailsDto.getUserDTO().getAddress().getCity().getCityId());
		cityBO.setState(stateBO);
		AddressBO addressBO = new AddressBO();
		addressBO.setLocation(eduDetailsDto.getUserDTO().getAddress().getLocation());
		addressBO.setPincode(eduDetailsDto.getUserDTO().getAddress().getPincode());
		addressBO.setCity(cityBO);
		UserBO userBO = new UserBO();
		userBO.setFirstname(eduDetailsDto.getUserDTO().getFirstname());
		userBO.setLastname(eduDetailsDto.getUserDTO().getLastname());
		userBO.setEmail(eduDetailsDto.getUserDTO().getEmail());
		userBO.setDate(eduDetailsDto.getUserDTO().getDate());
		userBO.setMobileNo(eduDetailsDto.getUserDTO().getMobileNo());
		userBO.setImage(eduDetailsDto.getUserDTO().getImage());
		userBO.setGender(eduDetailsDto.getUserDTO().getGender());
		userBO.setAddress(addressBO);
		userBO.setBatchTechnology(btbo);
		List<EducationalTypeDetailsDTO> edutDto = eduDetailsDto.getEducationalTypeDetailsDTOList();
		StreamBO sstream = new StreamBO();
		StreamBO hstream = new StreamBO();
		StreamBO gstream = new StreamBO();
		StreamBO pgstream = new StreamBO();
		SpecializationBO sspecilization = new SpecializationBO();
		SpecializationBO hspecilization = new SpecializationBO();
		SpecializationBO gspecilization = new SpecializationBO();
		SpecializationBO pgspecilization = new SpecializationBO();
		EducationTypeBO edsscbo = new EducationTypeBO();
		EducationTypeBO ehscbo = new EducationTypeBO();
		EducationTypeBO egraduation = new EducationTypeBO();
		EducationTypeBO epgraduation = new EducationTypeBO();
		EducationalTypeDetailsBO edutypedetailssscBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailshscBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailsgBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailspgBO = new EducationalTypeDetailsBO();
		EducationDetailsBO edubo = new EducationDetailsBO();
		for (Iterator iterator = edutDto.iterator(); iterator.hasNext();) {
			EducationalTypeDetailsDTO educationalTypeDetailsDTO = (EducationalTypeDetailsDTO) iterator.next();
			int etype = educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId();
			if (etype == 1) {
				sstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				sspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				sspecilization.setStreamBO(sstream);
				edsscbo.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailssscBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailssscBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailssscBO.setEducationTypeBO(edsscbo);
				edutypedetailssscBO.setUserBO(userBO);
				edutypedetailssscBO.setSpecializationBO(sspecilization);
			} else if (etype == 2) {
				hstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				hspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				hspecilization.setStreamBO(hstream);

				ehscbo.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailshscBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailshscBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailshscBO.setEducationTypeBO(ehscbo);
				edutypedetailshscBO.setUserBO(userBO);
				edutypedetailshscBO.setSpecializationBO(hspecilization);
			} else if (etype == 3) {
				gstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				gspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				gspecilization.setStreamBO(gstream);

				egraduation.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailsgBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailsgBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailsgBO.setEducationTypeBO(egraduation);
				edutypedetailsgBO.setUserBO(userBO);
				edutypedetailsgBO.setSpecializationBO(gspecilization);
			} else if (etype == 4) {
				pgstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				pgspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				pgspecilization.setStreamBO(pgstream);

				epgraduation.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailspgBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailspgBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailspgBO.setEducationTypeBO(epgraduation);
				edutypedetailspgBO.setUserBO(userBO);
				edutypedetailspgBO.setSpecializationBO(pgspecilization);
			}

		}

		List<EducationalTypeDetailsBO> listbo = new ArrayList<>();
		listbo.add(edutypedetailssscBO);
		listbo.add(edutypedetailshscBO);
		listbo.add(edutypedetailsgBO);
		listbo.add(edutypedetailspgBO);

		EducationDetailsBO edudetailsbo = new EducationDetailsBO();
		edudetailsbo.setEducationalTypeDetailsBOList(listbo);
		edudetailsbo.setUserBO(userBO);

		String s = hd.hrAddTraineePostGraduation(con, edudetailsbo);
		DbUtil.closeConnection(con);
		return s;
	}

	/**
	 * @author Rama
	 * @version 1.0.0 2018
	 * @author Nacre Batch 50 Java
	 * @return
	 */
	@Override
	public String hrAddTraineeGraduation(EducationDetailsDTO eduDetailsDto)
			throws SQLException, DatabaseException, FileNotFoundException {

		con = DbUtil.getConnection();

		BatchBO bbo = new BatchBO();
		bbo.setBatchId(eduDetailsDto.getUserDTO().getBatchTechnology().getBatch().getBatchId());

		TechnologyBO tbo = new TechnologyBO();
		tbo.setTechnologyId(eduDetailsDto.getUserDTO().getBatchTechnology().getTechnology().getTechnologyId());

		BatchTechnologyBO btbo = new BatchTechnologyBO();
		btbo.setBatch(bbo);
		btbo.setTechnology(tbo);

		CountryBO countryBO = new CountryBO();
		countryBO
				.setCountryId(eduDetailsDto.getUserDTO().getAddress().getCity().getState().getCountry().getCountryId());

		StateBO stateBO = new StateBO();
		stateBO.setStateId(eduDetailsDto.getUserDTO().getAddress().getCity().getState().getStateId());
		stateBO.setCountry(countryBO);

		CityBO cityBO = new CityBO();
		cityBO.setCityId(eduDetailsDto.getUserDTO().getAddress().getCity().getCityId());
		cityBO.setState(stateBO);

		AddressBO addressBO = new AddressBO();
		addressBO.setLocation(eduDetailsDto.getUserDTO().getAddress().getLocation());
		addressBO.setPincode(eduDetailsDto.getUserDTO().getAddress().getPincode());
		addressBO.setCity(cityBO);

		UserBO userBO = new UserBO();
		userBO.setFirstname(eduDetailsDto.getUserDTO().getFirstname());
		userBO.setLastname(eduDetailsDto.getUserDTO().getLastname());
		userBO.setEmail(eduDetailsDto.getUserDTO().getEmail());
		userBO.setDate(eduDetailsDto.getUserDTO().getDate());
		userBO.setMobileNo(eduDetailsDto.getUserDTO().getMobileNo());
		userBO.setImage(eduDetailsDto.getUserDTO().getImage());
		userBO.setGender(eduDetailsDto.getUserDTO().getGender());
		userBO.setAddress(addressBO);
		userBO.setBatchTechnology(btbo);

		List<EducationalTypeDetailsDTO> edutDto = eduDetailsDto.getEducationalTypeDetailsDTOList();

		StreamBO sstream = new StreamBO();
		StreamBO hstream = new StreamBO();
		StreamBO gstream = new StreamBO();
		StreamBO pgstream = new StreamBO();

		SpecializationBO sspecilization = new SpecializationBO();
		SpecializationBO hspecilization = new SpecializationBO();
		SpecializationBO gspecilization = new SpecializationBO();
		SpecializationBO pgspecilization = new SpecializationBO();

		EducationTypeBO edsscbo = new EducationTypeBO();
		EducationTypeBO ehscbo = new EducationTypeBO();
		EducationTypeBO egraduation = new EducationTypeBO();
		EducationTypeBO epgraduation = new EducationTypeBO();

		EducationalTypeDetailsBO edutypedetailssscBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailshscBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailsgBO = new EducationalTypeDetailsBO();
		EducationalTypeDetailsBO edutypedetailspgBO = new EducationalTypeDetailsBO();

		EducationDetailsBO edubo = new EducationDetailsBO();

		for (Iterator iterator = edutDto.iterator(); iterator.hasNext();) {
			EducationalTypeDetailsDTO educationalTypeDetailsDTO = (EducationalTypeDetailsDTO) iterator.next();

			int etype = educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId();

			if (etype == 1) {
				sstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				sspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				sspecilization.setStreamBO(sstream);

				edsscbo.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailssscBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailssscBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailssscBO.setEducationTypeBO(edsscbo);
				edutypedetailssscBO.setUserBO(userBO);
				edutypedetailssscBO.setSpecializationBO(sspecilization);

			} else if (etype == 2) {
				hstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				hspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				hspecilization.setStreamBO(hstream);

				ehscbo.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailshscBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailshscBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailshscBO.setEducationTypeBO(ehscbo);
				edutypedetailshscBO.setUserBO(userBO);
				edutypedetailshscBO.setSpecializationBO(hspecilization);
			} else if (etype == 3) {
				gstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				gspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				gspecilization.setStreamBO(gstream);

				egraduation.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailsgBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailsgBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailsgBO.setEducationTypeBO(egraduation);
				edutypedetailsgBO.setUserBO(userBO);
				edutypedetailsgBO.setSpecializationBO(gspecilization);
			} else if (etype == 4) {
				pgstream.setStreamId(educationalTypeDetailsDTO.getSpecializationDTO().getObjStreamDTO().getStreamId());
				pgspecilization
						.setSpecializationId(educationalTypeDetailsDTO.getSpecializationDTO().getSpecializationId());
				pgspecilization.setStreamBO(gstream);

				epgraduation.setGraduDetailsId(educationalTypeDetailsDTO.getEducationTypeDTO().getGraduDetailsId());
				edutypedetailspgBO.setPercentage(educationalTypeDetailsDTO.getPercentage());
				edutypedetailspgBO.setYop(educationalTypeDetailsDTO.getYop());
				edutypedetailspgBO.setEducationTypeBO(epgraduation);
				edutypedetailspgBO.setUserBO(userBO);
				edutypedetailspgBO.setSpecializationBO(pgspecilization);
			}

		}

		List<EducationalTypeDetailsBO> listbo = new ArrayList<>();
		listbo.add(edutypedetailssscBO);
		listbo.add(edutypedetailshscBO);
		listbo.add(edutypedetailsgBO);
		listbo.add(edutypedetailspgBO);
		EducationDetailsBO edudetailsbo = new EducationDetailsBO();
		edudetailsbo.setEducationalTypeDetailsBOList(listbo);
		edudetailsbo.setUserBO(userBO);

		String s = hd.hrAddTraineeGraduation(con, edudetailsbo);
		DbUtil.closeConnection(con);
		return s;
	}

	@Override
	public String addJobPosting(JobPostingChangeDTO jobPostingChangeDTO) throws DatabaseException, SQLException {
		JobPostingChangeBO jobPostingChangeBO = null;
		String result = null;

		jobPostingChangeBO = new JobPostingChangeBO();
		jobPostingChangeBO.setDescription(jobPostingChangeDTO.getDescription());
		jobPostingChangeBO.setExpectedDate(jobPostingChangeDTO.getExpectedDate());
		jobPostingChangeBO.setPostDate(jobPostingChangeDTO.getPostDate());
		jobPostingChangeBO.setNoOfVacancies(jobPostingChangeDTO.getNoOfVacancies());
		jobPostingChangeBO.setClientAddressId(jobPostingChangeDTO.getClientAddressId());
		con = DbUtil.getConnection();
		result = hd.addJobPosting(jobPostingChangeBO, con);
		DbUtil.closeConnection(con);
		return result;
	}

	@Override
	public List<JobPostingResultDTO> viewJobPostings(int clientId, int addressId)
			throws SQLException, DatabaseException {
		List<JobPostingResultDTO> jobPostResultDTOList = null;
		List<JobPostingResultBO> jobPostResultBOList = null;
		JobPostingResultDTO jobPostResultDTO = null;
		JobPostingResultBO jobPostResultBO = null;
		jobPostResultDTOList = new ArrayList<>();
		con = DbUtil.getConnection();
		jobPostResultBOList = hd.viewJobPostings(clientId, addressId, con);
		Iterator itr = jobPostResultBOList.iterator();
		while (itr.hasNext()) {
			jobPostResultBO = (JobPostingResultBO) itr.next();
			jobPostResultDTO = new JobPostingResultDTO();
			jobPostResultDTO.setJobPostingId(jobPostResultBO.getJobPostingId());
			jobPostResultDTO.setClientName(jobPostResultBO.getClientName());
			jobPostResultDTO.setLocation(jobPostResultBO.getLocation());
			jobPostResultDTO.setCpName(jobPostResultBO.getCpName());
			jobPostResultDTO.setCpMobile(jobPostResultBO.getCpMobile());
			jobPostResultDTO.setCpEmail(jobPostResultBO.getCpEmail());
			jobPostResultDTO.setDescription(jobPostResultBO.getDescription());
			jobPostResultDTO.setExpDate(jobPostResultBO.getExpDate());
			jobPostResultDTO.setPostDate(jobPostResultBO.getPostDate());
			jobPostResultDTO.setNoOfVacancies(jobPostResultBO.getNoOfVacancies());
			jobPostResultDTO.setClientAddressId(jobPostResultBO.getClientAddressId());

			jobPostResultDTOList.add(jobPostResultDTO);
		}
		DbUtil.closeConnection(con);
		return jobPostResultDTOList;
	}

	@Override
	public String deleteJobPostById(int jobId) throws DatabaseException, SQLException {
		String result = null;
		con = DbUtil.getConnection();
		result = hd.deleteJobPostById(jobId, con);
		DbUtil.closeConnection(con);
		return result;
	}

	@Override
	public String updateJobPostById(JobPostingChangeDTO jobPostingChangeDTO) throws DatabaseException, SQLException {
		String result = null;
		con = DbUtil.getConnection();
		JobPostingChangeBO jobPostingChangeBO = new JobPostingChangeBO();
		jobPostingChangeBO.setJobPostId(jobPostingChangeDTO.getJobPostId());
		jobPostingChangeBO.setDescription(jobPostingChangeDTO.getDescription());
		jobPostingChangeBO.setExpectedDate(jobPostingChangeDTO.getExpectedDate());
		jobPostingChangeBO.setPostDate(jobPostingChangeDTO.getPostDate());
		jobPostingChangeBO.setNoOfVacancies(jobPostingChangeDTO.getNoOfVacancies());

		result = hd.updateJobPostById(jobPostingChangeBO, con);
		DbUtil.closeConnection(con);
		return result;
	}

	@Override
	public Map<Integer, String> getAllClients() throws DatabaseException, SQLException {
		Map<Integer, String> map = new HashMap<>();
		con = DbUtil.getConnection();
		map = hd.getAllClients(con);
		DbUtil.closeConnection(con);
		return map;
	}

	@Override
	public List<LocationDTO> getClientLocations(int clientId) throws DatabaseException, SQLException {
		List<LocationDTO> list = new ArrayList<>();
		con = DbUtil.getConnection();
		list = hd.getClientLocations(clientId, con);
		DbUtil.closeConnection(con);
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			LocationDTO lvo = (LocationDTO) itr.next();
		}
		return list;
	}

	/*
	 * batch functionalities
	 */

	@Override
	public List viewBatch() throws DatabaseException, SQLException {
		List list = null;
		con = DbUtil.getConnection();
		list = hd.viewBatch(con);
		DbUtil.closeConnection(con);
		return list;
	}

	@Override
	public int sendBatchId(int batchId) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		int count = hd.sendBatchId(batchId, con);
		DbUtil.closeConnection(con);
		return count;
	}

	@Override
	public int updateBatch(BatchDTO dto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		int update = hd.updateBatch(dto, con);
		DbUtil.closeConnection(con);
		return update;

	}

	@Override
	public int addBatch(BatchDTO dto) throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		int update = hd.addBatch(dto, con);
		DbUtil.closeConnection(con);
		return update;

	}

	@Override
	public List retrieveToUpdate(int bid) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List batchDto = hd.retrieveToUpdate(bid, con);
		DbUtil.closeConnection(con);
		return batchDto;

	}

	/*
	 * This method is used to getting a batch details from database using map object
	 * inside that calling a daoIMpl getBatch(id) method getting a batch details
	 * based on id
	 */

	@Override
	public Map<BatchDTO, BatchDTO> getBatchs() throws ClassNotFoundException, SQLException, DatabaseException {
		con = DbUtil.getConnection();
		Map m = hd.fetchBatchs(con);
		DbUtil.closeConnection(con);
		return m;
	}

	/*
	 * This method is used to getting a technology details from database using map
	 * object inside that calling a daoIMpl getTechnpology method
	 */

	@Override
	public Map<TechnologyDTO, TechnologyDTO> getTech(int bid)
			throws ClassNotFoundException, SQLException, DatabaseException {

		// getting connection
		con = DbUtil.getConnection();
		Map m = hd.getTech(bid, con);
		DbUtil.closeConnection(con);
		return m;
	}

	/*
	 * This method is used to storing a technology and batch to database based on
	 * id's inside that calling a daoIMpl InsertBatchAndTech method
	 */

	@Override
	public String insertBatchandTech(int bid, int techid) throws DatabaseException, SQLException {
		int res = 0;
		// getting connection
		con = DbUtil.getConnection();
		res = hd.storeBatchandTech(bid, techid, con);
		DbUtil.closeConnection(con);

		if (res >= 1) {
			return "assigning batch with technology sucessfull";
		} else {
			return "assigning batch with technology failure!, try again...";
		}
	}

	@Override
	public List<AssignVo> fetchAllBatchesAndTechnologies() throws DatabaseException, SQLException {
		// getting connection
		con = DbUtil.getConnection();
		// use dao
		List<AssignVo> list = hd.retAllBatchesAndTechnologies(con);
		DbUtil.closeConnection(con);
		return list;
	}

	/*
	 * Author akhila
	 *
	 */

	public List<BatchDTO> getBatchByHr() throws DatabaseException, SQLException {
		List lbo = new ArrayList();
		con = DbUtil.getConnection();
		List<BatchBO> ba = hd.getBatchByHr(con);
		BatchDTO bdto = null;
		for (BatchBO batchbo : ba) {
			bdto = new BatchDTO();
			bdto.setBatchId(batchbo.getBatchId());
			bdto.setBatch(batchbo.getBatch());
			lbo.add(bdto);
		}
		DbUtil.closeConnection(con);
		return lbo;
	}

	public List<TechnologyDTO> getTechnologies() throws DatabaseException, SQLException {
		List techl = new ArrayList();
		con = DbUtil.getConnection();
		List<TechnologyBO> ta = hd.getTechnologies(con);
		TechnologyDTO tdto = null;
		for (TechnologyBO techbo : ta) {
			tdto = new TechnologyDTO();
			tdto.setTechnologyId(techbo.getTechnologyId());
			tdto.setTechnology(techbo.getTechnology());
			techl.add(tdto);
		}
		DbUtil.closeConnection(con);
		return techl;
	}

	public List<Integer> getyop() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		List l = hd.getyop(con);
		DbUtil.closeConnection(con);
		return l;
	}

	public List<String> getSpecilization() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		List l = hd.getSpecilization(con);
		DbUtil.closeConnection(con);
		return l;
	}

	public List<String> getStream() throws SQLException, DatabaseException {
		con = DbUtil.getConnection();
		List l = hd.getStream(con);
		DbUtil.closeConnection(con);
		return l;
	}

	public List<EducationDetailsDTO> viewTraineeDetails(BatchTechnologyDTO btdto)
			throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List<EducationDetailsDTO> ltrainee = new ArrayList();
		List<EducationDetailsBO> educationalDetailsBoList = hd.viewTraineeDetails(btdto, con);
				EducationDetailsDTO educationDetailsDTO = null;
		for (EducationDetailsBO edb : educationalDetailsBoList) {
			educationDetailsDTO = new EducationDetailsDTO();
			UserBO userBO = edb.getUserBO();
			UserDTO userDTO = new UserDTO();

			userDTO.setUserid(userBO.getUserid());
			userDTO.setFirstname(userBO.getFirstname());
			userDTO.setEmail(userBO.getEmail());
			List<EducationalTypeDetailsBO> etdboList = edb.getEducationalTypeDetailsBOList();
			List<EducationalTypeDetailsDTO> etdDTOList = new ArrayList<>();

			StreamDTO sdto = null;
			SpecializationDTO spdto = null;
			EducationTypeDTO etypedto = null;

			for (EducationalTypeDetailsBO etdBO : etdboList) {
				EducationalTypeDetailsDTO educationalTypeDetailsDTO = new EducationalTypeDetailsDTO();
				spdto = new SpecializationDTO();
				etypedto = new EducationTypeDTO();
				sdto = new StreamDTO();

				spdto.setSpecialization(etdBO.getSpecializationBO().getSpecialization());
				spdto.setObjStreamDTO(sdto);

				sdto.setStream(etdBO.getSpecializationBO().getStreamBO().getStream());

				etypedto.setGraduationType(etdBO.getEducationTypeBO().getGraduationType());
				educationalTypeDetailsDTO.setEducationTypeDTO(etypedto);
				educationalTypeDetailsDTO.setPercentage(etdBO.getPercentage());
				educationalTypeDetailsDTO.setSpecializationDTO(spdto);
				educationalTypeDetailsDTO.setYop(etdBO.getYop());

				etdDTOList.add(educationalTypeDetailsDTO);
			}

			educationDetailsDTO.setUserDTO(userDTO);
			educationDetailsDTO.setEducationalTypeDetailsDTOList(etdDTOList);

			ltrainee.add(educationDetailsDTO);

		}
		DbUtil.closeConnection(con);
		return ltrainee;

	}

	public List<JobPostingDTO> getRequirementDetails(int pid) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List<JobPostingBO> requirementbao = hd.getRequirementDetails(con,pid);
		ClientDTO cdto = null;
		ClientAddressDTO caddto = null;
		AddressDTO adto = null;
		CityDTO citdto = null;
		StateDTO stdto = null;
		CountryDTO coudto = null;
		JobPostingDTO jpdto = null;
		LevelDTO ldto = null;
		List<JobPostingDTO> ljpdto = null;
		ljpdto = new ArrayList();
		for (JobPostingBO jpbo : requirementbao) {
			cdto = new ClientDTO();
			caddto = new ClientAddressDTO();
			adto = new AddressDTO();
			citdto = new CityDTO();
			stdto = new StateDTO();
			coudto = new CountryDTO();
			ldto = new LevelDTO();
			jpdto = new JobPostingDTO();

			cdto.setClientName(jpbo.getClientaddress().getClient().getClientName());
			String level = jpbo.getClientaddress().getClient().getCompanyLevel().getLevel();
			ldto.setLevel(level);
			cdto.setCompanyLevel(ldto);
			cdto.setClientDescription(jpbo.getClientaddress().getClient().getClientDescription());

			String country = jpbo.getClientaddress().getAddrs().getCity().getState().getCountry().getCountry();
			coudto.setCountry(country);
			String state = jpbo.getClientaddress().getAddrs().getCity().getState().getState();
			stdto.setState(state);
			stdto.setCountry(coudto);
			String city = jpbo.getClientaddress().getAddrs().getCity().getCity();
			citdto.setCity(city);
			citdto.setState(stdto);
			adto.setCity(citdto);
			adto.setLocation(jpbo.getClientaddress().getAddrs().getLocation());
			adto.setPincode(jpbo.getClientaddress().getAddrs().getPincode());
			caddto.setAddress(adto);
			caddto.setClient(cdto);
			jpdto.setClientaddress(caddto);
			jpdto.setDescription(jpbo.getDescription());
			jpdto.setJobPostId(jpbo.getJobPostId());
			jpdto.setExpectedDate(jpbo.getExpectedDate());
			jpdto.setVacancies(jpbo.getVacancies());
			ljpdto.add(jpdto);
		}
		DbUtil.closeConnection(con);
		return ljpdto;
	}

	public int insertEligibleTraiees(int userid, int jobpost)
			throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		int i=hd.insertEligibleTraiees(con,userid,jobpost);
		DbUtil.closeConnection(con);
		return i;

	}

	public InterviewRoundDTO getinterviewRounds(int jobpostid) throws DatabaseException, SQLException {
		ClientDTO cdto = new ClientDTO();
		ClientAddressDTO cadto = new ClientAddressDTO();
		JobPostingDTO jpdto = new JobPostingDTO();
		InterviewRoundDTO interview = new InterviewRoundDTO();
		con = DbUtil.getConnection();
		InterviewRoundBO roundbo = hd.getInteviewRounds(con, jobpostid);
		String cname = roundbo.getJobPost().getClientaddress().getClient().getClientName();
		cdto.setClientName(cname);
		cadto.setClient(cdto);
		jpdto.setClientaddress(cadto);
		interview.setJobPost(jpdto);
		interview.setRoundId(roundbo.getRoundId());
		interview.setDate(roundbo.getDate());
		interview.setRoundNo(roundbo.getRoundNo());
		interview.setDescription(roundbo.getDescription());
		DbUtil.closeConnection(con);
		return interview;
	}

	public List<EducationDetailsDTO> filterTrainees(FilterTraieesDTO fdto, BatchTechnologyDTO batchtechid)
			throws DatabaseException, SQLException {
		// boolean flag = true;
		HrServiceI hs = new HrServiceIMPL();
		String edutype = null;
		String stream = null;
		String special = null;
		float percentage = 0.0f;
		int yop = 0;
		int count = 0;
		List<EducationDetailsDTO> detailsdto = hs.viewTraineeDetails(batchtechid);
		detailsdto.forEach(System.out::println);

		List<EducationDetailsDTO> matchedProfileDetailsDTOList = null;
		matchedProfileDetailsDTOList = new ArrayList<>();
		int sscYop = 0;
		float sscPer = 0.0f;
		float hscPercentage = 0.0f;
		int hscyop = 0;
		int sscYOPArray[] = new int[fdto.getGradYop().length];
		String gradutionStream = " ";
		String[] graduationStream = new String[fdto.getGradStream().length];
		String graduationSpecialization = " ";
		String[] gspecialization = new String[fdto.getGradSpecialization().length];
		float graPercentage = 0.0f;
		int graduationyop = 0;
		float pgPercentage = 0.0f;
		int pgyop = 0;
		String pgradutionStream = " ";

		String[] pgraduationStream = new String[fdto.getPostStream().length];
		String pgraduationSpecialization = " ";
		String[] pgspecialization = new String[fdto.getPostSpecialization().length];

		// check the matched records..

		for (EducationDetailsDTO edd : detailsdto) {
			System.out.println("details" + edd);
			System.out.println(fdto);
			boolean sscperstatus = false;
			boolean sscyopstatus = false;

			boolean hscperstatus = false;
			boolean hscyopstatus = false;

			boolean gradperstatus = false;
			boolean gradyopstatus = false;
			boolean gradspestatus = false;
			boolean gradstreamstatus = false;

			boolean pgperstatus = false;
			boolean pgyopstatus = false;
			boolean pgspestatus = false;
			boolean pgstreamstatus = false;

			List<EducationalTypeDetailsDTO> educationTypeDeatilsList = edd.getEducationalTypeDetailsDTOList();

			float sscPercentage = 0;
			for (EducationalTypeDetailsDTO etddto : educationTypeDeatilsList) {

				if (etddto.getEducationTypeDTO().getGraduationType().equals("ssc") && fdto.getSscPercentage() > 0.0f) {
					sscPercentage = etddto.getPercentage();
					sscYop = etddto.getYop();
					sscPer = fdto.getSscPercentage();
					if (fdto.getSscPercentage() <= sscPercentage) {
						sscperstatus = true;

					}
					sscYOPArray = fdto.getSscYop();

					/*
					 * graPercentage = etddto.getPercentage(); graduationyop = etddto.getYop();
					 * 
					 * // percentage checking if (graPercentage >= fdto.getGradPercentge()) {
					 * gradperstatus = true;
					 * 
					 * }
					 */

				}
				if (etddto.getEducationTypeDTO().getGraduationType().equals("hsc") && fdto.getHscPercentage() > 0.0f) {
					hscPercentage = etddto.getPercentage();
					hscyop = etddto.getYop();

					if (hscPercentage >= fdto.getHscPercentage()) {
						hscperstatus = true;
						// matchedProfileDetailsDTOList.add(edd);
					}

					for (int hscYopassing : fdto.getHscyop()) {
						if (hscYopassing == hscyop) {
							hscyopstatus = true;
							break;
						}

					}

				}
				// for grad spec new
				if (etddto.getEducationTypeDTO().getGraduationType().equals("graduation")
						&& fdto.getGradSpecialization()[0] != " ") {
					String specialz = null;
					for (int i = 0; i < fdto.getGradSpecialization().length; i++) {
						String gspec[] = new String[fdto.getGradSpecialization().length];
						gspec = fdto.getGradSpecialization();

						for (String string : gspec) {
							specialz = string;
							if (specialz.equals(etddto.getSpecializationDTO().getSpecialization().toString())) {
								gradspestatus = true;
								break;
							}
						}

					}

				}

				// for post specialization new
				if (etddto.getEducationTypeDTO().getGraduationType().equals("postgraduation")
						&& fdto.getPostSpecialization()[0] != " ") {
					String pspecialz = null;
					for (int i = 0; i < fdto.getPostSpecialization().length; i++) {
						String pspec[] = new String[fdto.getPostSpecialization().length];
						pspec = fdto.getPostSpecialization();

						for (String string : pspec) {
							pspecialz = string;
							if (pspecialz.equals(etddto.getSpecializationDTO().getSpecialization().toString())) {
								pgspestatus = true;
								break;
							}
						}

					}

				}

//for graduation stream new
				if (etddto.getEducationTypeDTO().getGraduationType().equals("graduation")
						&& fdto.getGradStream()[0] != " ") {
					String streamz = null;
					for (int i = 0; i < fdto.getGradStream().length; i++) {
						String gstream[] = new String[fdto.getGradStream().length];
						gstream = fdto.getGradStream();

						for (String string : gstream) {
							streamz = string;
							if (streamz
									.equals(etddto.getSpecializationDTO().getObjStreamDTO().getStream().toString())) {
								gradstreamstatus = true;
								break;
							}
						}

					}

				}

				if (etddto.getEducationTypeDTO().getGraduationType().equals("postgraduation")
						&& fdto.getPostStream()[0] != " ") {
					String pstreamz = null;
					for (int i = 0; i < fdto.getPostStream().length; i++) {
						String pstream[] = new String[fdto.getPostStream().length];
						pstream = fdto.getPostStream();

						for (String string : pstream) {
							pstreamz = string;
							if (pstreamz
									.equals(etddto.getSpecializationDTO().getObjStreamDTO().getStream().toString())) {
								pgstreamstatus = true;
								break;
							}
						}

					}

				}

//for graduation yop new
				if (etddto.getEducationTypeDTO().getGraduationType().equals("graduation") && fdto.getGradYop()[0] > 0) {
					for (int i = 0; i < fdto.getGradYop().length; i++) {
						int gyop[] = new int[fdto.getGradYop().length];
						gyop = fdto.getGradYop();

						if (gyop[i] == etddto.getYop()) {
							gradyopstatus = true;
							break;

						}

					}

				}
				// for graduation percentage
				if (etddto.getEducationTypeDTO().getGraduationType().equals("graduation")
						&& fdto.getGradPercentge() > 0.0f) {
					graPercentage = etddto.getPercentage();

					// percentage checking
					if (graPercentage >= fdto.getGradPercentge()) {
						gradperstatus = true;
						// matchedProfileDetailsDTOList.add(edd);
					}

				} // yop checking

				if (etddto.getEducationTypeDTO().getGraduationType().equals("postgraduation")
						&& fdto.getPostPercentage() > 0.0f) {
					pgPercentage = etddto.getPercentage();
					pgyop = etddto.getYop();

					// percentage checking
					if (pgPercentage >= fdto.getPostPercentage()) {
						pgperstatus = true;
					}

					// yop checking

					for (int pgYopassing : fdto.getPostYop()) {
						if (pgYopassing == pgyop) {
							pgyopstatus = true;
							break;
						}

					}

					if (etddto.getEducationTypeDTO().getGraduationType().equals("postgraduation"))
						// stream is checking

						pgradutionStream = etddto.getSpecializationDTO().getObjStreamDTO().getStream();

					pgraduationStream = fdto.getPostStream();

					for (String gstream : pgraduationStream) {
						if (pgradutionStream.equals(gstream)) {
							pgstreamstatus = true;
							break;
						}
					}

					// specialization is checking...

					pgraduationSpecialization = etddto.getSpecializationDTO().getSpecialization();
					pgspecialization = fdto.getPostSpecialization();

					for (String pgs : pgspecialization) {
						if (pgs.equals(pgraduationSpecialization)) {
							pgspestatus = true;

						}
					}

				} else {
				}


			}

			// ssc percentage && sscyop

			if (fdto.getSscPercentage() > 0.0f && fdto.getHscPercentage() > 0.0f && fdto.getGradPercentge() > 0.0f
					&& fdto.getPostPercentage() > 0.0f) {
				if (sscperstatus && hscperstatus && gradperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getHscPercentage() > 0.0f
					&& fdto.getGradPercentge() > 0.0f) {
				if (sscperstatus && hscperstatus && gradperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getGradPercentge() > 0.0f
					&& fdto.getPostPercentage() > 0.0f) {
				if (sscperstatus && gradperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getHscPercentage() > 0.0f && fdto.getGradPercentge() > 0.0f
					&& fdto.getPostPercentage() > 0.0f) {
				if (hscperstatus && gradperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getHscPercentage() > 0.0f
					&& fdto.getPostPercentage() > 0.0f) {
				if (sscperstatus && hscperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getHscPercentage() > 0.0f) {
				if (sscperstatus && hscperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getGradPercentge() > 0.0f) {
				if (sscperstatus && gradperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f && fdto.getPostPercentage() > 0.0f) {
				if (sscperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getHscPercentage() > 0.0f && fdto.getGradPercentge() > 0.0f) {
				if (hscperstatus && gradperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getHscPercentage() > 0.0f && fdto.getPostPercentage() > 0.0f) {
				if (hscperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getGradPercentge() > 0.0f && fdto.getPostPercentage() > 0.0f) {
				if (gradperstatus && pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getSscPercentage() > 0.0f) {
				if (sscperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getHscPercentage() > 0.0f) {
				if (hscperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getGradPercentge() > 0.0f) {
				if (gradperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getPostPercentage() > 0.0f) {
				if (pgperstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getGradYop()[0] > 0) {
				if (gradyopstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getPostYop()[0] > 0) {
				if (pgyopstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getGradSpecialization()[0] != " ") {
				if (gradspestatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getGradStream()[0] != " ") {
				if (gradstreamstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			}

			else if (fdto.getPostSpecialization()[0] != " ") {
				if (pgspestatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			} else if (fdto.getPostStream()[0] != " ") {
				if (pgstreamstatus) {
					matchedProfileDetailsDTOList.add(edd);
				}
			}

			else {
			}

		}

		return matchedProfileDetailsDTOList;
	}

	public List<UserDTO> getSelectedTrainees() throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		List<UserDTO> udtolist = new ArrayList<>();
		UserDTO udto = null;
		List<UserBO> ubo = hd.getSelectedTraiees(con);
		for (UserBO userBO : ubo) {
			udto = new UserDTO();
			udto.setEmail(userBO.getEmail());
			udtolist.add(udto);
		}
		DbUtil.closeConnection(con);
		return udtolist;
	}
}
