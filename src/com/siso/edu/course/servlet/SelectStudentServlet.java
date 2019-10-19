package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

/**
 * @author xuwanru
 * 2018年7月24日
 */
public class SelectStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
	String studentNo = request.getParameter("student_no");
	StudentService studentService = new StudentServiceImpl();
	Student student = studentService.getStudent(studentNo);
	request.setAttribute("student", student);
	request.getRequestDispatcher("admin/updateStudent.jsp").forward(request, response);
	}

}
