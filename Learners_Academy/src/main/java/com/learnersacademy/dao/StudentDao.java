package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.bean.StudentBean;
import com.learnersacademy.util.DBConnection;

public class StudentDao {
	
	
	public static void main(String[] args) {
		//StudentDao dao = new StudentDao();
		//StudentBean bean = dao.getStudentByslNo(1);
		//System.out.println(bean.getSlNo());
		//System.out.println(bean.getFirstName());
		//System.out.println(bean.getLastName());
		//for(StudentBean studentbean : listOfStudents)
		//{
			//System.out.println(studentbean.getFirstName());
		//}
		
		//StudentBean bean = new StudentBean();
	    //bean.setSlNo(12);
		//bean.setFirstName("nawab");;
		//bean.setLastName("alam");
		//System.out.println(dao.insertStudent(bean));
		//System.out.println(dao.deleteStudentByFirstName("nawab"));
		
		
	}
	
	/**
	 * this method is used to get details student by serial number  	
	 * @return
	 */
	
	public StudentBean getStudentByslNo(int slNo)
	{
		StudentBean bean = new StudentBean();
		
			try{
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String qury = "select * from Student_tb where slNo=" + slNo;
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
	 * this method is used to get all students details 	
	 * @return
	 */

	public List<StudentBean> getAllStudents()
	{
		
		List<StudentBean> listOfStudents = new ArrayList<StudentBean>();
		
		try{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String qury = "select * from student_tb";
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next())
			{
				StudentBean bean = new StudentBean();
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
* this method is used to insert value into student table	
* @param been
* @return
*/
	
	public boolean insertStudent(StudentBean bean)
	{
		boolean insertStatus = false;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "insert into student_tb values(?,?,?)";
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
* this method is used to delete student from student table 	
* @param empId
* @return
*/
	
	public int deleteStudentByFirstName(String firstName)
	{
		int deleteCount = 0;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "delete student_tb where firstName=?";
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
