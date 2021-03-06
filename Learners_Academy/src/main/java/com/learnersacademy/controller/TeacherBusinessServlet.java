package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.bean.TeacherBean;
import com.learnersacademy.service.TeacherBusinessesService;

public class TeacherBusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherBusinessesService service = new TeacherBusinessesService();
       
    public TeacherBusinessServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get from TeacherServlet");
        String buttonValue = request.getParameter("button");
       
        
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			TeacherBean bean = new TeacherBean();
			bean.setSlNo(slNo);
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			
			boolean insertStatus = service.saveTeacher(bean);
			
			if(insertStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TeacAddSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TeacAddFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Delete"))
		{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			TeacherBean bean = new TeacherBean();
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			
			int deletetStatus = service.deleteTeacher(bean);
			if(deletetStatus > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TeacDelSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/TeacDelFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Find"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			
			TeacherBean bean = service.viewTeacher(slNo);
			if(bean == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/teacNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("stdObj", bean);
				RequestDispatcher rd = request.getRequestDispatcher("/FindTeacherDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(buttonValue.equalsIgnoreCase("Find All"))
		{
			List<TeacherBean> list = service.viewAllTeachers();
			if(list == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/teacNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("listOfStdObj", list);
				RequestDispatcher rd = request.getRequestDispatcher("/FindAllTeachersDetails.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
