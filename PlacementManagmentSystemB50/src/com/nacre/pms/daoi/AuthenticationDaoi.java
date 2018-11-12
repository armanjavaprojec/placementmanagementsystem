/**
 * 
 */
package com.nacre.pms.daoi;

import java.sql.Connection;
import java.sql.SQLException;

import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;

/**
 * @author B.Rakesh kumar
 * @AuthenticationDaoi is the interface for which AuthenticationDaoimpl is providing the implementation and is 
 * used to connect with the database to retreive the values from the database. 
 *
 */

public interface AuthenticationDaoi {
	
	/**
	 * @author B.Rakesh kumar
	 * @param con,lb Accepts java.sql.connection,com.nacre.online_assesment.LoginBean
	 * @return userDTO object to get the column's data from the db
	 * @throws InvalidException  occurs when user enters invalid data
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 * @throws SQLException occurs when problems when connecting with database
	 */
    UserDTO login(Connection con, LoginBean lb) throws SQLException, DatabaseException, InvalidException;
    
    /**
	 * @author B.Rakesh kumar
	 * @param con,fbean Accepts java.sql.connection,com.nacre.online_assesment.ForgetBean
	 * @return userDTO object to get the column's data from the db
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
     * @throws DataNotFoundException 
	 */
	String forgetdata(Connection con, String email) throws SQLException,DatabaseException, DataNotFoundException;

	/**
	 * @author B.Rakesh kumar
	 * @param con,cb Accepts java.sql.connection,com.nacre.online_assesment.ChangeBean
	 * @return int to know how many columns effected in database
	 * @throws SQLException  occurs when problem occurs while connecting with the database
	 * @throws DatabaseException occurs when problem occurs while interacting with  database
	 */
	int changedata(Connection con, ChangeBean cb) throws SQLException,DatabaseException;

	UserDTO informationRetreival(Connection con, Integer id) throws SQLException, InvalidException, DatabaseException;

}
