package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.learnersacademy.bean.AdminBean;
import com.learnersacademy.util.DBConnection;

public class AdminDao {
	
	public static void main(String[] args) {
		
		String user = "zeyan";
		AdminDao admDao = new AdminDao();
		AdminBean admin =  admDao.getAdminByUserName(user);
		
		System.out.println(admin.getUserName());
		System.out.println(admin.getPassword());		
		
	}
	

	public AdminBean getAdminByUserName(String userName)
	{
		AdminBean bean = new AdminBean();
		try{
			Connection con = DBConnection.getConnection();
			String qury = "select * from admin_tb where username=?";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				bean.setUserName(rs.getString(1));
				bean.setPassword(rs.getString(2));
			}
			else
			{
				bean = null;
			}
			
		}
		
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return bean;
	}	

}
