package com.nacre.pms.servicei.serviceimpl;

import java.sql.Connection;
import java.sql.SQLException;

import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.daoi.AuthenticationDaoi;
import com.nacre.pms.daoi.daoimpl.AuthenticationDaoimpl;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;
import com.nacre.pms.servicei.AuthenticationServicei;
import com.nacre.pms.util.EmailUtilty;
import com.nacre.pms.util.StringConstants;

public class AuthenticationServiceimpl implements AuthenticationServicei {

	AuthenticationDaoi authd = new AuthenticationDaoimpl();
	Connection con = null;

	@Override
	public UserDTO login(LoginBean lb) throws DatabaseException, SQLException, InvalidException {
		con = DbUtil.getConnection();
		UserDTO udto = authd.login(con, lb);
		DbUtil.closeConnection(con);
		return udto;

	}

	@Override
	public Boolean forgetData(String email) throws DatabaseException, SQLException, DataNotFoundException {
		con = DbUtil.getConnection();
		String password = authd.forgetdata(con, email);
		DbUtil.closeConnection(con);
		return EmailUtilty.sendEmail(email, StringConstants._FORGOT_PWD_SUBJECT,
				StringConstants._FORGOT_PWD_MSG + password);
	}

	@Override
	public int changeData(ChangeBean cb) throws DatabaseException, SQLException {
		con = DbUtil.getConnection();
		int i = authd.changedata(con, cb);
		DbUtil.closeConnection(con);
		return i;
	}

	@Override
	public UserDTO informationRetreival(Integer ibean) throws DatabaseException, SQLException, InvalidException {
		con = DbUtil.getConnection();
		UserDTO udto = authd.informationRetreival(con, ibean);
		DbUtil.closeConnection(con);
		return udto;
	}

}
