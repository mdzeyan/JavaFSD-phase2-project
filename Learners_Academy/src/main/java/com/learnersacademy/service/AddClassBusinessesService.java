package com.learnersacademy.service;

import java.util.List;

import com.learnersacademy.bean.AddClassBean;
import com.learnersacademy.dao.AddClassDao;


public class AddClassBusinessesService {
	
	 AddClassDao dao = new AddClassDao();
		
		public boolean saveAddClass(AddClassBean bean)
		{
			return dao.insertClass(bean);
		}
		
		public int deleteAddClass(AddClassBean bean)
		{
			return dao.deleteClassByClassName(bean.getClassName());
		}
		
		public List<AddClassBean> viewAllAddClass()
		{
			return dao.getAllClasses();
		}

}
