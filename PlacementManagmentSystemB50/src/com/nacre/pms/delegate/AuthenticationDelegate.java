/**
 * 
 */
package com.nacre.pms.delegate;

import java.sql.SQLException;

import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;
import com.nacre.pms.servicei.AuthenticationServicei;
import com.nacre.pms.servicei.serviceimpl.AuthenticationServiceimpl;

public class AuthenticationDelegate {
	AuthenticationServicei auths = new AuthenticationServiceimpl();

	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException {
		return auths.login(lb);
	}

	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException {
		return auths.forgetData(email);
	}

	public int changeData(ChangeBean cb) throws SQLException, DatabaseException {
		return auths.changeData(cb);
	}

	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException {
		return auths.informationRetreival(ibean);
	}
}
