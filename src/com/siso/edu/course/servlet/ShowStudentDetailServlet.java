package com.siso.edu.course.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.ClassService;
import com.siso.edu.course.service.ClassServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;


/**
 * @author xuwanru
 * 2018年7月24日
 */
public class ShowStudentDetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentNo = request.getParameter("student_no");
		System.out.println("test1:"+studentNo);
		StudentService studentService = new StudentServiceImpl();
		ChooseService chooseService  = new ChooseServiceImpl();
		Student student = studentService.getStudent(studentNo);
		List<Choose> chooses = chooseService.getChoose(studentNo);		
		request.setAttribute("student", student);
		request.setAttribute("chooses", chooses);
		request.getRequestDispatcher("student/showStudentDetail.jsp").forward(request, response);
	}

}
