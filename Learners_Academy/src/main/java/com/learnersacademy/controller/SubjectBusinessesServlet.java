package com.learnersacademy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.bean.SubjectBean;
import com.learnersacademy.service.SubjectBusinessesService;


public class SubjectBusinessesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectBusinessesService Service = new SubjectBusinessesService();
       

    public SubjectBusinessesServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get from TeacherServlet");
        String buttonValue = request.getParameter("button");
       
        
		if(buttonValue.equalsIgnoreCase("Save"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			String subjectName = request.getParameter("subjectName");
			
			SubjectBean bean = new SubjectBean();
			bean.setSlNo(slNo);
			bean.setSubjectName(subjectName);
			
			boolean insertStatus = Service.saveSubject(bean);
			
			if(insertStatus)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjAddSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjAddFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Delete"))
		{
			String subjectName = request.getParameter("subjectName");
			
			SubjectBean bean = new SubjectBean();
			bean.setSubjectName(subjectName);
			
			int deletetStatus = Service.deleteSubject(bean);
			if(deletetStatus > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjDelSucess.html");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjDelFail.html");
				rd.forward(request, response);
			}
			
		}
		else if(buttonValue.equalsIgnoreCase("Find"))
		{
			int slNo = Integer.parseInt(request.getParameter("slNo"));
			
			SubjectBean bean = Service.viewSubject(slNo);
			if(bean == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("stdObj", bean);
				RequestDispatcher rd = request.getRequestDispatcher("/FindSubjectDetails.jsp");
				rd.forward(request, response);
			}
		}
		else if(buttonValue.equalsIgnoreCase("Find All"))
		{
			List<SubjectBean> list = Service.viewAllSubject();
			if(list == null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("/SubjNtFound.html");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("listOfStdObj", list);
				RequestDispatcher rd = request.getRequestDispatcher("/FindAllSubjectsDetails.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
