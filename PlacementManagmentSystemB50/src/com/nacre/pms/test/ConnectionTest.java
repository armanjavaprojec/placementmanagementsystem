package com.nacre.pms.test;

import java.sql.Connection;

import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.exception.DatabaseException;

/**
 * 
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Java B50
 * This class is used for Testing the Connection
 */
public class ConnectionTest {
	public static void main(String[] args) throws DatabaseException {
		Connection con=DbUtil.getConnection();
		System.out.println("Connection "+con);
	}

}
