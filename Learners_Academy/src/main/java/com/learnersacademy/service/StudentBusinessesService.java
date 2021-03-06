package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.bean.StudentBean;
import com.learnersacademy.dao.StudentDao;

public class StudentBusinessesService {
	
	StudentDao dao = new StudentDao();
	
	public boolean saveStudent(StudentBean bean)
	{
		return dao.insertStudent(bean);
	}
	
	public int deleteStudent(StudentBean bean)
	{
		return dao.deleteStudentByFirstName(bean.getFirstName());
	}
	
	public StudentBean viewStudent(int slNo)
	{
		return dao.getStudentByslNo(slNo);
	}
	
	public List<StudentBean> viewAllStudent()
	{
		return dao.getAllStudents();
	}
	
	

}
