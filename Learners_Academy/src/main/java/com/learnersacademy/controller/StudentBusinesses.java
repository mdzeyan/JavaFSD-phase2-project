package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.bean.StudentBean;
import com.learnersacademy.service.StudentBusinessesService;


public class StudentBusinesses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	StudentBusinessesService service = new StudentBusinessesService();

    public StudentBusinesses() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post from StudentServlet");
        String buttonValue = request.getParameter("button");
       
        
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			StudentBean bean = new StudentBean();
			bean.setSlNo(slNo);
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			
			boolean insertStatus = service.saveStudent(bean);
			
			if(insertStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdAddSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdAddFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Delete"))
		{
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			StudentBean bean = new StudentBean();
			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			
			int deletetStatus = service.deleteStudent(bean);
			if(deletetStatus > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdDelSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdDelFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Find"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			
			StudentBean bean = service.viewStudent(slNo);
			if(bean == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("stdObj", bean);
				RequestDispatcher rd = request.getRequestDispatcher("/FindStudentsDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(buttonValue.equalsIgnoreCase("Find All"))
		{
			List <StudentBean> list = service.viewAllStudent();
			if(list == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/StdNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("listOfStdObj", list);
				RequestDispatcher rd = request.getRequestDispatcher("/FindAllStudentsDetails.jsp");
				rd.forward(request, response);
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
