package com.nacre.pms.servicei;

import java.sql.SQLException;

import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;

public interface AuthenticationServicei {
	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException;

	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException;

	public int changeData(ChangeBean cb) throws DatabaseException, SQLException;

	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException;
}
