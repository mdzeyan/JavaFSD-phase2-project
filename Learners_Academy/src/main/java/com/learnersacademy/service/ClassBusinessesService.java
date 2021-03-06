package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.bean.ClassBean;
import com.learnersacademy.dao.ClassDao;


public class ClassBusinessesService {
	
    ClassDao dao = new ClassDao();
	
	public boolean saveClass(ClassBean bean)
	{
		return dao.insertClass(bean);
	}
	
	public int deleteClass(ClassBean bean)
	{
		return dao.deleteClassByAllocatedTeacher(bean.getAllocatedTeacher());
	}
	
	public List<ClassBean> viewAllClasses()
	{
		return dao.getAllClasses();
	}

}
