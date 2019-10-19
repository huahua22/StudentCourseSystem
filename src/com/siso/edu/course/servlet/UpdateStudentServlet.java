package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.ClassService;
import com.siso.edu.course.service.ClassServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

/**
 * @author xuwanru
 * 2018年7月24日
 */
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String studentNo = request.getParameter("studentNo");
		String studentName = request.getParameter("studentName");
		String studentContact =request.getParameter("studentContact");
		String className=request.getParameter("className");
		ClassService classService = new ClassServiceImpl();
		Classes item = classService.getClassByClassName(className);
		StudentService studentService = new StudentServiceImpl();
		Student student =studentService.getStudent(studentNo);
		student.setStudent_name(studentName);
		student.setStudent_contact(studentContact);
		student.setClasses(item);
		studentService.updateStudent(student);
		request.getRequestDispatcher("studentListServlet").forward(request, response);
		
	}

}
