package com.learnersacademy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learnersacademy.bean.AdminBean;
import com.learnersacademy.service.AdminLoginService;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("post from AdminServlet");
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		AdminBean beanFromUser = new AdminBean();
		beanFromUser.setUserName(userName);
		beanFromUser.setPassword(passWord);
		
		AdminLoginService service = new AdminLoginService();
		boolean user = service.login(beanFromUser);
		
		HttpSession session = request.getSession();
		
		if(!user)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/LoginError.html");
			rd.forward(request, response);
		}
		else if(user)
		{
			session.setAttribute("userName", userName);
			RequestDispatcher rd = request.getRequestDispatcher("/AdminHome.html");
			rd.forward(request, response);
		}
		
	}

}
