package com.siso.edu.course.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

public class StudentInforServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService = new StudentServiceImpl();
		List<Student> studentList = studentService.getStudentList(LoginServlet.NOW_STUDENT.getClasses().getClass_no());
	    request.setAttribute("studentList", studentList);
	    request.getRequestDispatcher("student/class_infor.jsp").forward(request, response);
	}

}
