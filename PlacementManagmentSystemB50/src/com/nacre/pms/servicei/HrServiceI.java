package com.nacre.pms.servicei;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.FilterTraieesDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingChangeDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.JobPostingResultDTO;
import com.nacre.pms.dto.LocationDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.AssignVo;
import com.nacre.pms.vo.PlacedResultVO;
import com.nacre.pms.vo.TechnologyFilterVO;

public interface HrServiceI {
	public Map<Integer, String> getAllBatch() throws DatabaseException, SQLException;

	public List<TechnologyFilterVO> getTechnology1(int batchId) throws DatabaseException, SQLException;

	public List<PlacedResultVO> viewPlaced(int batchId, int techId) throws SQLException, DatabaseException;

	public List<Object> getJobPostingRelatedDataToHR() throws SQLException, DatabaseException;

	public void setReadNotification(StatusDTO sdto) throws SQLException, DatabaseException;

	public Map<Integer, String> getBatches() throws DatabaseException, SQLException;

	public Map<Integer, String> getAssignedTechnologies(int key) throws DatabaseException, SQLException;

	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto) throws SQLException, DatabaseException;

	public List<UserDTO> returnTR(int batchId, int techId) throws DatabaseException, SQLException;

	public int deleteTrainee(int userId) throws DatabaseException, SQLException;

	public UserDTO getTraineeDetails(int userId);

	public List<UserEducationDetailsBO> getTraineeEduDetails(int userId);

	public Map<Integer, String> getStreams(int key) throws DatabaseException, SQLException;

	public Map<Integer, String> getSpecializations() throws DatabaseException, SQLException;

	public String updateEducation(List<EducationDetailsDTO> listEducation, Integer userId);

	public Map<Integer, String> getSpecializations(int key) throws DatabaseException, SQLException;

	public Map getBatch() throws SQLException, DatabaseException;

	public Map getTechnology(int batch_id) throws SQLException, DatabaseException;

	public Map getCountry() throws SQLException, DatabaseException;

	public Map getState(int country_id) throws SQLException, DatabaseException;

	public Map getCity(int state_id) throws SQLException, DatabaseException;

	public Map getGraduationStream() throws SQLException, DatabaseException;

	public Map getPGraduationStream() throws SQLException, DatabaseException;

	public Map getGraduationSpecilization(int gid) throws SQLException, DatabaseException;

	public Map getPGraduationSpecilization(int pgid) throws SQLException, DatabaseException;

	public String hrAddTraineePostGraduation(EducationDetailsDTO eduDetailsDto)
			throws SQLException, DatabaseException, FileNotFoundException;

	public String hrAddTraineeGraduation(EducationDetailsDTO eduDetailsDto)
			throws SQLException, DatabaseException, FileNotFoundException;

	public String deleteJobPostById(int jobId) throws DatabaseException, SQLException;

	public String updateJobPostById(JobPostingChangeDTO jobPostingChangeDTO) throws DatabaseException, SQLException;

	public String addJobPosting(JobPostingChangeDTO jobPostingChangeDTO) throws DatabaseException, SQLException;

	public Map<Integer, String> getAllClients() throws DatabaseException, SQLException;

	public List<LocationDTO> getClientLocations(int clientId) throws DatabaseException, SQLException;

	public List<JobPostingResultDTO> viewJobPostings(int clientId, int addressId)
			throws SQLException, DatabaseException;

	public List retrieveToUpdate(int bid) throws DatabaseException, SQLException;

	public List viewBatch() throws DatabaseException, SQLException;

	public int sendBatchId(int batchId) throws SQLException, DatabaseException;

	public int updateBatch(BatchDTO dto) throws SQLException, DatabaseException;

	public int addBatch(BatchDTO dto) throws SQLException, DatabaseException;

	public List<TechnologyDTO> viewTechnology() throws DatabaseException, SQLException;

	public List<TechnologyDTO> editTechnology(int tid) throws DatabaseException, SQLException;

	public int updateTechnology(int techid, String techname) throws DatabaseException, SQLException;

	public int insertTech(TechnologyDTO tdto) throws SQLException, DatabaseException;

	public int deleteTech(TechnologyDTO tdto) throws SQLException, DatabaseException;

	public Map<BatchDTO, BatchDTO> getBatchs() throws ClassNotFoundException, SQLException, DatabaseException;

	public Map<TechnologyDTO, TechnologyDTO> getTech(int bid)
			throws ClassNotFoundException, SQLException, DatabaseException;

	public String insertBatchandTech(int bid, int techid) throws DatabaseException, SQLException;

	public List<AssignVo> fetchAllBatchesAndTechnologies() throws DatabaseException, SQLException;

	



public List<BatchDTO> getBatchByHr() throws DatabaseException, SQLException;
	public List<TechnologyDTO> getTechnologies() throws DatabaseException, SQLException;
	public List viewTraineeDetails(BatchTechnologyDTO btdto) throws DatabaseException, SQLException;
	public List<JobPostingDTO> getRequirementDetails(int pid) throws DatabaseException, SQLException;
	public InterviewRoundDTO getinterviewRounds(int jobpostid) throws DatabaseException, SQLException;
	//public List<EducationDetailsDTO> filterTrainees(FilterTraieesDTO fdto);
	public List<EducationDetailsDTO> filterTrainees(FilterTraieesDTO filterdto, BatchTechnologyDTO batchtechid) throws DatabaseException, SQLException;
 	public int insertEligibleTraiees(int userid,int jobpost) throws DatabaseException, SQLException;
 	public List<UserDTO>getSelectedTrainees() throws DatabaseException, SQLException;
 	public List<Integer> getyop() throws SQLException, DatabaseException;
 	public List<String> getSpecilization() throws SQLException, DatabaseException;
 	public List<String> getStream() throws SQLException, DatabaseException;



}