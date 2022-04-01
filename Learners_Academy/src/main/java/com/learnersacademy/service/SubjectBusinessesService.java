package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.bean.SubjectBean;
import com.learnersacademy.dao.SubjectDao;


public class SubjectBusinessesService {
	
	  SubjectDao dao = new SubjectDao();
		
		public boolean saveSubject(SubjectBean bean)
		{
			return dao.insertSubject(bean);
		}
		
		public int deleteSubject(SubjectBean bean)
		{
			return dao.deleteSubjectBySubjectName(bean.getSubjectName());
		}
		
		public SubjectBean viewSubject(int slNo)
		{
			return dao.getSubjectByslNo(slNo);
		}
		
		public List<SubjectBean> viewAllSubject()
		{
			return dao.getAllSubjects();
		}

}
