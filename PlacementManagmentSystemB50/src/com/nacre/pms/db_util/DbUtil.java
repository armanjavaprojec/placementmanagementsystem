package com.nacre.pms.db_util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.nacre.pms.exception.DatabaseException;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This class contains all the utility methods for
 *         database connection.
 */
public class DbUtil {
	private DbUtil() {

	}

	/*
	 * Database user name.
	 */
	private static String UNAME;

	/*
	 * Database password.
	 */
	private static String PWD;

	/*
	 * Database driver class name i.e com.mysql.jdbc.Driver .
	 */
	private static String DRIVER;

	/*
	 * Database connection url name i.e jdbc:mysql://hostname:3306/schemaname .
	 */
	private static String URL;

	/*
	 * static block to load database connection parameters from database.properties
	 * file.
	 */
	static {
		Properties p = new Properties();
		try {
			p.load(DbUtil.class.getClassLoader().getResourceAsStream(DBConstants.PROP_PATH_MYSQL));
			UNAME = p.getProperty(DBConstants.PROP_USERNAME);
			PWD = p.getProperty(DBConstants.PROP_PASSWORD);
			URL = p.getProperty(DBConstants.PROP_URL);
			DRIVER = p.getProperty(DBConstants.PROP_DRIVER);
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// dblogger.error(DBConstants.DRIVER_LOAD_ERR_MSG);
		} catch (IOException e) {
			// dblogger.error(DBConstants.PROP_LOAD_ERR_MSG);
		}
	}

	/*
	 * This method is used to get The connection
	 */
	public static Connection getConnection() throws DatabaseException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, UNAME, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DatabaseException("Not able to connect to database now plz try after some time");
		}
		return connection;
	}

	/*
	 * This method is used to close the connection
	 */
	public static void closeConnection(Connection connection) throws DatabaseException {
		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DatabaseException("Not able to connect to database now plz try after some time");
			}
	}
}