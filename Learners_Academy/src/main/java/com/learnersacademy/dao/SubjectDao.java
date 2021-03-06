package com.learnersacademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.learnersacademy.bean.SubjectBean;
import com.learnersacademy.util.DBConnection;

public class SubjectDao {
	
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
	 * this method is used to get  Subject details by serial number  	
	 * @return
	 */
	
	public SubjectBean getSubjectByslNo(int slNo)
	{
		SubjectBean bean = new SubjectBean();
		
			try{
				Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();
				String qury = "select * from subject_tb where slNo=" + slNo;
				ResultSet rs = stmt.executeQuery(qury);
				if(rs.next())
				{
					bean.setSlNo(rs.getInt(1));
					bean.setSubjectName(rs.getString(2));
					
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
	 * this method is used to get all Subject details 	
	 * @return
	 */

	public List<SubjectBean> getAllSubjects()
	{
		
		List<SubjectBean> listOfStudents = new ArrayList<SubjectBean>();
		
		try{
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String qury = "select * from subject_tb";
			ResultSet rs = stmt.executeQuery(qury);
			
			while(rs.next())
			{
				SubjectBean bean = new SubjectBean();
				bean.setSlNo(rs.getInt(1));
				bean.setSubjectName(rs.getString(2));
				
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
* this method is used to insert value into Subject table	
* @param been
* @return
*/
	
	public boolean insertSubject(SubjectBean bean)
	{
		boolean insertStatus = false;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "insert into subject_tb values(?,?)";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setInt(1, bean.getSlNo());
			pstmt.setString(2, bean.getSubjectName());
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
* this method is used to delete Subject from Subject table 	
* @param empId
* @return
*/
	
	public int deleteSubjectBySubjectName(String subjectName)
	{
		int deleteCount = 0;
		try{
			Connection con = DBConnection.getConnection();
			String qury = "delete subject_tb where subjectName=?";
			PreparedStatement pstmt = con.prepareStatement(qury);
			pstmt.setString(1, subjectName);
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
