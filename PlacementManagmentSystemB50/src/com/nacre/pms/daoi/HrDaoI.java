package com.nacre.pms.daoi;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.BatchBO;
import com.nacre.pms.bo.EducationDetailsBO;
import com.nacre.pms.bo.InterviewRoundBO;
import com.nacre.pms.bo.JobPostingBO;
import com.nacre.pms.bo.JobPostingChangeBO;
import com.nacre.pms.bo.JobPostingResultBO;
import com.nacre.pms.bo.TechnologyBO;
import com.nacre.pms.bo.UserBO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.BatchTechnologyDTO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.LocationDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.AssignVo;
import com.nacre.pms.vo.PlacedResultVO;
import com.nacre.pms.vo.TechnologyFilterVO;

public interface HrDaoI {
	public Map<Integer, String> getAllBatch(Connection con) throws DatabaseException, SQLException;

	public List<TechnologyFilterVO> getTechnology(int batchId, Connection con) throws SQLException, DatabaseException;

	public List<PlacedResultVO> viewPlaced(int batchId, int techId, Connection con)
			throws SQLException, DatabaseException;

	public List<Object> getJobPostingRelatedDataToHR(Connection con) throws SQLException, DatabaseException;

	public void setReadNotification(StatusDTO sdto, Connection con) throws SQLException, DatabaseException;

	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto, Connection con)
			throws SQLException, DatabaseException;

	public Map getBatch(Connection con) throws SQLException, DatabaseException;

	public Map getTechnology(Connection con, int batch_id) throws SQLException, DatabaseException;

	public Map getCountry(Connection con) throws SQLException, DatabaseException;

	public Map getState(Connection con, int country_id) throws SQLException, DatabaseException;

	public Map getCity(Connection con, int state_id) throws SQLException, DatabaseException;

	public Map getGraduationStream(Connection con) throws SQLException, DatabaseException;

	public Map getPGraduationStream(Connection con) throws SQLException, DatabaseException;

	public Map getGraduationSpecilization(Connection con, int gid) throws SQLException, DatabaseException;

	public Map getPGraduationSpecilization(Connection con, int pgid) throws SQLException, DatabaseException;

	public String hrAddTraineePostGraduation(Connection con, EducationDetailsBO eduDetailsBO)
			throws SQLException, DatabaseException, FileNotFoundException;

	public String hrAddTraineeGraduation(Connection con, EducationDetailsBO eduDetailsBO)
			throws SQLException, DatabaseException, FileNotFoundException;

	public Map<Integer, String> getBatches(Connection con) throws SQLException;

	public Map<Integer, String> getAssignedTechnologies(int batchKey, Connection con) throws SQLException;

	public List<UserDTO> returnTrainees(int batchId, int techId, Connection con) throws SQLException;

	public int deleteTrainee(int userId, Connection con) throws SQLException;

	public Map<Integer, String> getStreams(int key, Connection con) throws SQLException;

	public Map<Integer, String> getSpecializations(Connection con) throws SQLException;

	public Map<Integer, String> getSpecializations(int key, Connection con) throws SQLException;

	public String deleteJobPostById(int jobId, Connection con) throws DatabaseException, SQLException;

	public String updateJobPostById(JobPostingChangeBO jobPostingChangeBO, Connection con)
			throws DatabaseException, SQLException;

	public String addJobPosting(JobPostingChangeBO jobPostingChangeBO, Connection con)
			throws DatabaseException, SQLException;

	public Map<Integer, String> getAllClients(Connection con) throws DatabaseException, SQLException;

	public List<LocationDTO> getClientLocations(int clientId, Connection con) throws SQLException, DatabaseException;

	public List<JobPostingResultBO> viewJobPostings(int cleintId, int addressId, Connection con)
			throws SQLException, DatabaseException;

	/*
	 * Batch Functionality
	 */

	public List retrieveToUpdate(int bid, Connection con) throws SQLException;

	public List viewBatch(Connection con) throws SQLException;

	public int sendBatchId(int batchId, Connection con) throws SQLException, DatabaseException;

	public int updateBatch(BatchDTO dto, Connection con) throws SQLException, DatabaseException;

	public int addBatch(BatchDTO dto, Connection con) throws SQLException, DatabaseException;

	/*
	 * insertTech method is used to insert the data into Technology table.
	 */
	public int insertTech(TechnologyDTO tdto, Connection con) throws SQLException, DatabaseException;

	/*
	 * viewTechnology method is used to get the data from technology table.
	 */
	public List<TechnologyDTO> viewTechnology(Connection con) throws DatabaseException, SQLException;

	/*
	 * editTechnology method is used to get the data from technology table.
	 */
	public List<TechnologyDTO> editTechnology(int tid, Connection con) throws SQLException;

	/*
	 * updateTechnology method is used to modify the data.
	 */
	public int updateTechnology(int techid, String techname, Connection con) throws SQLException;

	/*
	 * deleteTech method is used to delete the data from Technology table.
	 */
	public int deleteTech(TechnologyDTO tdto, Connection con) throws SQLException, DatabaseException;

// method for getting batche's from database
	Map<BatchDTO, BatchDTO> fetchBatchs(Connection con) throws ClassNotFoundException, SQLException, DatabaseException;

	// method for getting technology's from database

	Map<TechnologyDTO, TechnologyDTO> getTech(int bid, Connection con)
			throws ClassNotFoundException, SQLException, DatabaseException;

	// method to storing batch & technology
	public int storeBatchandTech(int bid, int techid, Connection con) throws SQLException;

	public List<FeedbackDTO> retriveFeedbacks(Connection con)throws SQLException;
	// int insertTech(TechnologyDTO tdto, Connection con) throws SQLException,
	// DatabaseException;

	public List<BatchBO> getBatchByHr(Connection con) throws SQLException;

	public List<TechnologyBO> getTechnologies(Connection con) throws SQLException;

	public List<EducationDetailsBO> viewTraineeDetails(BatchTechnologyDTO btdto, Connection con) throws SQLException;

	public List<JobPostingBO> getRequirementDetails(Connection con, int pid) throws SQLException;

	public InterviewRoundBO getInteviewRounds(Connection con, int jobpostid) throws SQLException;

	public int insertEligibleTraiees(Connection con, int userid, int jobpost) throws DatabaseException, SQLException;

	public List getyop(Connection con) throws SQLException;

	public List getSpecilization(Connection con) throws SQLException;

	public List getStream(Connection con) throws SQLException;

	public List<UserBO> getSelectedTraiees(Connection con) throws SQLException;

	public UserBO getSelectedTraineeEmail(Connection con, int userid) throws SQLException;

	public List<AssignVo> retAllBatchesAndTechnologies(Connection con) throws SQLException;

	
	

}
