package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.bean.AddClassBean;
import com.learnersacademy.service.AddClassBusinessesService;



public class AddClassBusinessesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddClassBusinessesService Service = new AddClassBusinessesService();
       

    public AddClassBusinessesServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get from TeacherServlet");
        String buttonValue = request.getParameter("button");
       
        
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			String className = request.getParameter("className");
			
			AddClassBean bean = new AddClassBean();
			bean.setSlNo(slNo);
			bean.setClassName(className);
			
			boolean insertStatus = Service.saveAddClass(bean);
			
			if(insertStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassAddSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassAddFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Delete"))
		{
			String className = request.getParameter("className");
			
			AddClassBean bean = new AddClassBean();
			bean.setClassName(className);
			
			int deletetStatus = Service.deleteAddClass(bean);
			if(deletetStatus > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassDelSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassDelFail.html");
				rd.forward(request, response);
			}
			
		}
		//else if(buttonValue.equalsIgnoreCase("Find"))
		//{
			//int slNo = Integer.parseInt(request.getParameter("slNo"));
			
			//SubjectBean bean = Service.viewSubject(slNo);
			//if(bean == null)
			//{
			//	RequestDispatcher rd = request.getRequestDispatcher("/SubjNtFound.html");
			//	rd.forward(request, response);
			//}
			//else
			//{
			//	request.setAttribute("stdObj", bean);
			//	RequestDispatcher rd = request.getRequestDispatcher("/FindSubjectDetails.jsp");
			//	rd.forward(request, response);
			//}
		//}
		else if(buttonValue.equalsIgnoreCase("Find All"))
		{
			List<AddClassBean> list = Service.viewAllAddClass();
			if(list == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("listOfStdObj", list);
				RequestDispatcher rd = request.getRequestDispatcher("/FindAllClassesDetails.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
