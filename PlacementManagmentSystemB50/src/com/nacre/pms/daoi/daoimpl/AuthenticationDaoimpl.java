/**
 * 
 */
package com.nacre.pms.daoi.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.log.SysoCounter;
import com.nacre.pms.bo.ChangeBean;
import com.nacre.pms.bo.LoginBean;
import com.nacre.pms.daoi.AuthenticationDaoi;
import com.nacre.pms.db_util.SQLQueryConstants;
import com.nacre.pms.dto.AddressDTO;
import com.nacre.pms.dto.BatchDTO;
import com.nacre.pms.dto.RoleDTO;
import com.nacre.pms.dto.StatusDTO;
import com.nacre.pms.dto.TechnologyDTO;
import com.nacre.pms.dto.UserDTO;
import com.nacre.pms.exception.DataNotFoundException;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.exception.InvalidException;
import com.nacre.pms.test.MyEmailValidate;
import com.nacre.pms.util.ErrorMessages;

public class AuthenticationDaoimpl implements AuthenticationDaoi {
	@Override
	public UserDTO login(Connection con, LoginBean lb) throws SQLException, DatabaseException, InvalidException {
		// TODO Auto-generated method stub
		
		PreparedStatement pst =null; 
		boolean isEmail= MyEmailValidate.validateEmailAddress(lb.getEmail());
			if(isEmail==true){
				System.out.println("CHANDU through Mail");
				pst= con.prepareStatement(SQLQueryConstants.DATA_RETREIVAL_QRY_LOGIN);
			}else{
				pst=con.prepareStatement(SQLQueryConstants.DATA_RETREIVAL_QRY_LOGIN_USING_MOBILE);
			}
		
		pst.setString(1, lb.getEmail());
		pst.setString(2, lb.getPassword());
		ResultSet rs=pst.executeQuery();
		if (rs != null) 
		{
			if (rs.next()) 
			{
				UserDTO rd=new UserDTO();
				
				rd.setUserid(rs.getInt(1));
				rd.setFirstname(rs.getString(2));
				rd.setLastname(rs.getString(3));
				rd.setEmail(rs.getString(4));
				rd.setPassword(rs.getString(5));
				rd.setMobileNo(rs.getString(6));
				rd.setGender(rs.getInt(7));
				rd.setImage(rs.getString(8));
				rd.setDate(rs.getDate(9));
		
				RoleDTO rd1=new RoleDTO();
				System.out.println(rs.getInt(10));
				System.out.println(rs.getString(11));
				rd1.setRoleId(rs.getInt(10));
				rd1.setRole(rs.getString(11));
				rd.setRole(rd1);
				
				
				return rd;
			}else
			{
				throw new InvalidException(ErrorMessages._ERR_INVALID_LOGIN);
				
			}
		} else
		    {
				throw new DatabaseException(ErrorMessages._ERR_DB_CON);
				
			}
		
		

}
	 
	@Override
	public String forgetdata(Connection con,String email) throws SQLException, DatabaseException,DataNotFoundException {
		
		PreparedStatement pst=con.prepareStatement(SQLQueryConstants.QRY_TO_RETREIVE_FIRSTNAME__PASSWORD);
		pst.setString(1, email);
		ResultSet rs = pst.executeQuery();
		
		if (rs != null) {
			if (rs.next()) {
			
				return 	rs.getString(2);
			}else{
				throw new DataNotFoundException("Data is not Found");
			}
		} else {
			System.out.println("ResultSet have No records");
			throw new DatabaseException("Record not Found");
		}


	}
	
	@Override
	public int changedata(Connection con, ChangeBean cb) throws SQLException {
		// TODO Auto-generated method stub
		String sql=null;
		boolean isEmail= MyEmailValidate.validateEmailAddress(cb.getEmail());
		if(isEmail==true){
		 sql=SQLQueryConstants.QRY_TO_UPDATE_PASSWORD;
		}else
		{
			sql=SQLQueryConstants.QRY_TO_UPDATE_PASSWORD_USING_MOBILE;
		}
		String email= cb.getEmail();
		String oldpassword=cb.getOldPassword();
		String newpassword=cb.getNewPassword();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,newpassword);
		pst.setString(2,email);
		pst.setString(3,oldpassword);
		int rs=pst.executeUpdate();
		return rs;
		
	}
	@Override
	public UserDTO informationRetreival(Connection con, Integer id) throws SQLException, InvalidException, DatabaseException {
		System.out.println("in dao method");
		PreparedStatement pst=con.prepareStatement(SQLQueryConstants.INFORMATION_RETREIVAL);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		if (rs != null) 
		{
			if (rs.next()) 
			{
				UserDTO rd=new UserDTO();
				
				rd.setUserid(rs.getInt(1));
				rd.setFirstname(rs.getString(2));
				rd.setLastname(rs.getString(3));
				rd.setEmail(rs.getString(4));
				rd.setPassword(rs.getString(5));
				rd.setMobileNo(rs.getString(6));
				rd.setGender(rs.getInt(7));
				rd.setImage(rs.getString(8));
				rd.setDate(rs.getDate(9));
				
				RoleDTO rd1=new RoleDTO();
				System.out.println(rs.getInt(11));
				rd1.setRoleId(rs.getInt(11));
				rd.setRole(rd1);
				AddressDTO ado=new AddressDTO();
				System.out.println(rs.getInt(12));
				ado.setAddressId(rs.getInt(12));
				rd.setAddress(ado);
				StatusDTO sdo=new StatusDTO();
				System.out.println(rs.getInt(13));
				sdo.setStatusId(rs.getInt(13));
				rd.setStatus(sdo);
				 BatchDTO bd=new BatchDTO();
				 System.out.println(rs.getInt(14));
				 bd.setBatchId(rs.getInt(14));
				 
				 TechnologyDTO tdo=new TechnologyDTO();
				 System.out.println(rs.getInt(15));
				 tdo.setTechnologyId(rs.getInt(15));
				
				 return rd;
			}else
			{
				throw new InvalidException("some thing went wrong ");
			}
		}else
		{
			throw new DatabaseException("Exception occured while connecting with the database");
		}
				 
				
		
		
		
	}
}
