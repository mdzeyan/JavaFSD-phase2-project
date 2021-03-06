package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.bean.ClassBean;
import com.learnersacademy.util.DBConnection;

public class ClassDao {
	
	public static void main(String[] args) {
		ClassDao dao = new ClassDao();
		//StudentBean bean = dao.getStudentByslNo(1);
		//System.out.println(bean.getSlNo());
		//System.out.println(bean.getFirstName());
		//System.out.println(bean.getLastName());
		//for(StudentBean studentbean : listOfStudents)
		//{
			//System.out.println(studentbean.getFirstName());
		//}
		
		ClassBean bean = new ClassBean();
	    bean.setSlNo(3);
		bean.setAllocatedTeacher("alok kumar");
		bean.setAllocatedSubject("math");
		bean.setAllocatedClass("9A");
		System.out.println(dao.insertClass(bean));
		//int slNo = 2;
		//System.out.println(dao.deleteClassByAllocatedTeacher("alok kumar"));
		
		
	}

	/**
	 * this method is used to get all students details 	
	 * @return
	 */

	public List<ClassBean> getAllClasses()
	{
		
		List<ClassBean> listOfClasses = new ArrayList<ClassBean>();
		
		try{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String qury = "select * from class_tb";
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next())
			{
				ClassBean bean = new ClassBean();
				bean.setSlNo(rs.getInt(1));
				bean.setAllocatedClass(rs.getString(4));
				bean.setAllocatedSubject(rs.getString(3));
				bean.setAllocatedTeacher(rs.getString(2));
				
				listOfClasses.add(bean);
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return listOfClasses;
	}

/**
* this method is used to insert value into student table	
* @param been
* @return
*/
	
	public boolean insertClass(ClassBean bean)
	{
		boolean insertStatus = false;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "insert into class_tb values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setInt(1, bean.getSlNo());
			pstmt.setString(2, bean.getAllocatedTeacher());
			pstmt.setString(3, bean.getAllocatedSubject());
			pstmt.setString(4, bean.getAllocatedClass());
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
* this method is used to delete student from student table 	
* @param empId
* @return
*/
	
	public int deleteClassByAllocatedTeacher(String allocatedTeacher)
	{
		int deleteCount = 0;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "delete class_tb where allocatedTeacher=?";
			
			PreparedStatement pstmt = con.prepareStatement(qury);
			
			pstmt.setString(1, allocatedTeacher);
			
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
