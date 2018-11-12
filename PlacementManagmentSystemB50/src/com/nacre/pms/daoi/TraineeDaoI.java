package com.nacre.pms.daoi;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.nacre.pms.bo.TraineeBO;
import com.nacre.pms.bo.UserEducationDetailsBO;
import com.nacre.pms.dto.EducationDetailsDTO;
import com.nacre.pms.dto.FeedbackDTO;
import com.nacre.pms.dto.InterviewRoundDTO;
import com.nacre.pms.dto.JobPostingDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.vo.ShowRoundDataTOTraineeVO;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This Interface is used to dvelop the Trainee
 *         Functionalities
 */
public interface TraineeDaoI {

public List<Object> getClientData(Connection con, int id) throws SQLException, DatabaseException;
public int setStatusFeedback(StatusDTO sdto,JobPostingDTO jdto,FeedbackDTO fdto, int uid) throws SQLException, DatabaseException;
	public int setStatus(StatusDTO sdto,JobPostingDTO jdto, int uid) throws SQLException, DatabaseException;
public TraineeBO getTraineeForEdit(String email, Connection con);

	public Map<Integer, String> getCountry(Connection con);

	public Map<Integer, String> getState(Connection con, int country_id);

	public Map<Integer, String> getCity(Connection con, int state_id);

	public int updateTraineeDetails(Connection con, TraineeBO userBO);

public void setReadNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException;
	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto,int id) throws SQLException, DatabaseException;

	UserDTO getTraineeDetails(int userId);
	List<UserEducationDetailsBO> getTraineeEduDetails(int userId);
	String updateEducation(List<EducationDetailsDTO> listEducation, Integer userId);
	String updateEducationNewMethod(List<EducationDetailsDTO> listEducation, Integer userId);
	public List<ShowRoundDataTOTraineeVO> getRoundDataToShowTrainee(int id) throws SQLException, DatabaseException;


	public void setReadRoundNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException;
	
	public void setReadRoundNotification(StatusDTO sdto, JobPostingDTO jdto,InterviewRoundDTO irdto,int id) throws SQLException, DatabaseException;
		
   





	public Map<Integer,String> getClientName(int clientid);
	
	public Map<Integer,String> getClientName(int clientid, int userId);
	
	public int addFeedBack(FeedbackDTO objFeedbackDTO);
	int[] insertTraineesByBatchProcess(List<TraineeBO> listBO, Connection con);
}
