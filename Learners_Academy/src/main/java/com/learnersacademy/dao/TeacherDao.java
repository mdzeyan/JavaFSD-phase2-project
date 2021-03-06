package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.learnersacademy.bean.TeacherBean;
import com.learnersacademy.util.DBConnection;

public class TeacherDao {
	
	public static void main(String[] args) {
		//TeacherDao dao = new TeacherDao();
		
		//List<TeacherBean> listOfStudents = new ArrayList<TeacherBean>();
	    //listOfStudents = dao.getAllTeachers();
		
		
		//System.out.println(bean.getSlNo());
		//System.out.println(bean.getFirstName());
		//System.out.println(bean.getLastName());
		//for(TeacherBean teacherbean : listOfStudents)
		//{
		//	System.out.println(teacherbean.getFirstName());
		//}
		
		//TeacherBean bean = new TeacherBean();
	    //bean.setSlNo(6);
		//bean.setFirstName("khurshid");;
		//bean.setLastName("alam");
		//System.out.println(dao.insertTeacher(bean));
		//System.out.println(dao.deleteTeacherByFirstName("khurshid"));
		
		
	}
	
	/**
	 * this method is used to get  teacher details by serial number  	
	 * @return
	 */
	
	public TeacherBean getTeacherByslNo(int slNo)
	{
		TeacherBean bean = new TeacherBean();
		
			try{
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String qury = "select * from teacher_tb where slNo=" + slNo;
				ResultSet rs = stmt.executeQuery(qury);
				if(rs.next())
				{
					bean.setSlNo(rs.getInt(1));
					bean.setFirstName(rs.getString(2));
					bean.setLastName(rs.getString(3));
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

	/**
	 * this method is used to get all teacher details 	
	 * @return
	 */

	public List<TeacherBean> getAllTeachers()
	{
		
		List<TeacherBean> listOfStudents = new ArrayList<TeacherBean>();
		
		try{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String qury = "select * from teacher_tb";
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next())
			{
				TeacherBean bean = new TeacherBean();
				bean.setSlNo(rs.getInt(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				
				listOfStudents.add(bean);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return listOfStudents;
	}

/**
* this method is used to insert value into teacher table	
* @param been
* @return
*/
	
	public boolean insertTeacher(TeacherBean bean)
	{
		boolean insertStatus = false;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "insert into teacher_tb values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setInt(1, bean.getSlNo());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			int count = pstmt.executeUpdate();
			if(count > 0)
			{
				insertStatus = true;
			}	
			System.out.println("Rows impacted: "+count);
		}
		
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return insertStatus;
	}

/**
* this method is used to delete teacher from teacher table 	
* @param empId
* @return
*/
	
	public int deleteTeacherByFirstName(String firstName)
	{
		int deleteCount = 0;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "delete teacher_tb where firstName=?";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setString(1, firstName);
			deleteCount = pstmt.executeUpdate();	
			System.out.println("Rows impacted: "+deleteCount);
		}
		
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return deleteCount;
	}

}
