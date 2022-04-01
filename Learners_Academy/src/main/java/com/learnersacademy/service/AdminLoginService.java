package com.learnersacademy.service;

import com.learnersacademy.bean.AdminBean;
import com.learnersacademy.dao.AdminDao;

public class AdminLoginService {
	
	AdminDao admDao = new AdminDao();
	
	public boolean login(AdminBean beanFromUser)
	{
		boolean user = false;
		AdminBean beanFromDB = admDao.getAdminByUserName(beanFromUser.getUserName());
		
		if(beanFromDB != null)
		{
			if(beanFromUser.getUserName().equals(beanFromDB.getUserName())
					&& beanFromUser.getPassword().equals(beanFromDB.getPassword()))
			{
				user = true;
			}
		}
		
		return user;
	}
	
	
	
	public void logout()
	{
		
	}
	
	

}
