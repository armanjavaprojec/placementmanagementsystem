package com.nacre.pms.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.nacre.pms.daoi.daoimpl.HrDaoIMPL;
import com.nacre.pms.db_util.DbUtil;
import com.nacre.pms.exception.DatabaseException;

public class ViewTechnologyTest {
	public static void main(String[] ar) throws DatabaseException, SQLException
	{
		Connection con=DbUtil.getConnection();
		System.out.println("hii");
		HrDaoIMPL dao=new HrDaoIMPL();
		//dao.editTechnology(con);
	}

}
