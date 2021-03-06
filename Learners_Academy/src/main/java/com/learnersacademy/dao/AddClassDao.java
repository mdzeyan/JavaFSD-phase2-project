package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.bean.AddClassBean;
import com.learnersacademy.util.DBConnection;

public class AddClassDao {
	
	public static void main(String[] args) {
		AddClassDao dao = new AddClassDao();
		
		//List<TeacherBean> listOfStudents = new ArrayList<TeacherBean>();
	    //listOfStudents = dao.getAllTeachers();
		
		
		//System.out.println(bean.getSlNo());
		//System.out.println(bean.getFirstName());
		//System.out.println(bean.getLastName());
		//for(TeacherBean teacherbean : listOfStudents)
		//{
		//	System.out.println(teacherbean.getFirstName());
		//}
		
		AddClassBean bean = new AddClassBean();
	    bean.setSlNo(1);
		bean.setClassName("2A");
		
		System.out.println(dao.insertClass(bean));
		//System.out.println(dao.deleteTeacherByFirstName("khurshid"));
		
		
	}	

	/**
	 * this method is used to get all Class details 	
	 * @return
	 */

	public List<AddClassBean> getAllClasses()
	{
		
		List<AddClassBean> listOfClass = new ArrayList<AddClassBean>();
		
		try{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String qury = "select * from addclass_tb";
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next())
			{
				AddClassBean bean = new AddClassBean();
				bean.setSlNo(rs.getInt(1));
				bean.setClassName(rs.getString(2));
				
				listOfClass.add(bean);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return listOfClass;
	}

/**
* this method is used to insert value into Class table	
* @param been
* @return
*/
	
	public boolean insertClass(AddClassBean bean)
	{
		boolean insertStatus = false;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "insert into addclass_tb values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setInt(1, bean.getSlNo());
			pstmt.setString(2, bean.getClassName());
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
* this method is used to deleteClass from Class table 	
* @param empId
* @return
*/
	
	public int deleteClassByClassName(String className)
	{
		int deleteCount = 0;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "delete addclass_tb where className=?";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setString(1, className);
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
