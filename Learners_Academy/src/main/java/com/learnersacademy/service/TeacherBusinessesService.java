package com.learnersacademy.service;

import java.util.List;


import com.learnersacademy.bean.TeacherBean;
import com.learnersacademy.dao.TeacherDao;

public class TeacherBusinessesService {
	
    TeacherDao dao = new TeacherDao();
	
	public boolean saveTeacher(TeacherBean bean)
	{
		return dao.insertTeacher(bean);
	}
	
	public int deleteTeacher(TeacherBean bean)
	{
		return dao.deleteTeacherByFirstName(bean.getFirstName());
	}
	
	public TeacherBean viewTeacher(int slNo)
	{
		return dao.getTeacherByslNo(slNo);
	}
	
	public List<TeacherBean> viewAllTeachers()
	{
		return dao.getAllTeachers();
	}

}
