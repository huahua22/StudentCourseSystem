package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;


/**
 * @author xuwanru
 * 2018年7月24日
 */
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNo = request.getParameter("student_no");
		ChooseService chooseService = new ChooseServiceImpl();
		chooseService.deleteStudentChoose(studentNo);
		StudentService studentService =new StudentServiceImpl();
		studentService.deleteStudent(studentNo);
		response.sendRedirect("studentListServlet");//请求重定向
	}

}
