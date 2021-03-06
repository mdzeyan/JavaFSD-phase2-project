package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.bean.ClassBean;
import com.learnersacademy.bean.StudentBean;
import com.learnersacademy.service.ClassBusinessesService;
import com.learnersacademy.service.StudentBusinessesService;


public class ClassBusinessesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClassBusinessesService service = new ClassBusinessesService();
       
    public ClassBusinessesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get from StudentServlet");
        String buttonValue = request.getParameter("button");
       
        
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			String allocatedTeacher = request.getParameter("allocatedTeacher");
			String allocatedSubject = request.getParameter("allocatedSubject");
			String allocatedClass = request.getParameter("allocatedClass");
			
			ClassBean bean = new ClassBean();
			bean.setSlNo(slNo);
			bean.setAllocatedSubject(allocatedSubject);
			bean.setAllocatedTeacher(allocatedTeacher);
			bean.setAllocatedClass(allocatedClass);
			
			boolean insertStatus = service.saveClass(bean);
			
			if(insertStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassAllotSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/ClassAllotFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Delete"))
		{
			String allocatedTeacher = request.getParameter("allocatedTeacher");
			
			ClassBean bean = new ClassBean();
			bean.setAllocatedTeacher(allocatedTeacher);
			
			
			int deletetStatus = service.deleteClass(bean);
			if(deletetStatus > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/AllotClassDelSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/AllotClassDelFail.html");
				rd.forward(request, response);
			}
			
		}
		
		else if(buttonValue.equalsIgnoreCase("Find All"))
		{
			List <ClassBean> list = service.viewAllClasses();
			if(list == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/AllotClassNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("listOfStdObj", list);
				RequestDispatcher rd = request.getRequestDispatcher("/FindAllotClassStudentsDetails.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
