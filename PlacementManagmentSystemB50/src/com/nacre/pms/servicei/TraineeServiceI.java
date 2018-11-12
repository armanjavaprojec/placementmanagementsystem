package com.nacre.pms.servicei;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public interface TraineeServiceI {
	public String registerTraineesByExcel(List<EducationDetailsDTO> listDto);

	public UserDTO getTraineeForEdit(String email);

	public Map getCountry();

	public Map getState(int country_id);

	public Map getCity(int state_id);

	public String updateTraineeDetails(UserDTO userDTO);

	public List<Object> getClientData(int id) throws SQLException, DatabaseException;

	public int setStatus(StatusDTO sdto, JobPostingDTO jdto, int uid) throws DatabaseException, SQLException;

	public int setStatusFeedback(StatusDTO sdto, JobPostingDTO jdto, FeedbackDTO fdto, int uid)
			throws SQLException, DatabaseException;

	public void setReadNotification(StatusDTO sdto,int id) throws SQLException, DatabaseException;

	public void setReadNotification(StatusDTO sdto, JobPostingDTO jdto,int id) throws SQLException, DatabaseException;

	public List<ShowRoundDataTOTraineeVO> getRoundDataToShowTrainee(int id) throws SQLException, DatabaseException;

	public void setReadRoundNotification(StatusDTO sdto, int id) throws SQLException, DatabaseException;

	public void setReadRoundNotification(StatusDTO sdto, JobPostingDTO jdto, InterviewRoundDTO irdto,int id)
			throws SQLException, DatabaseException;

	public Map<Integer, String> getClientName(int clientid);

	public Map<Integer, String> getClientName(int clientid, int userId);

	public int addFeedBack(FeedbackDTO objFeedbackDTO);
}
