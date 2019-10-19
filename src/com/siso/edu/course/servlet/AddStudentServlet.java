package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.ClassService;
import com.siso.edu.course.service.ClassServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String studentNo = request.getParameter("studentNo");
		String studentName = request.getParameter("studentName");
		String studentContact = request.getParameter("studentContact");
		int classNo = Integer.parseInt(request.getParameter("classNo"));
		StudentService studentService = new StudentServiceImpl();
		Student student = studentService.getStudent(studentNo);
		if (studentNo.equals("") || studentName.equals("") || studentContact.equals("")) {
			request.setAttribute("message", "不能为空!");
			request.getRequestDispatcher("admin/add_student.jsp").forward(request, response);
		} else {
			if (student != null) {// 学号存在
				request.setAttribute("message", "学号已存在！");
				request.getRequestDispatcher("admin/add_student.jsp").forward(request, response);
			} else {
				student = new Student();
				student.setStudent_no(studentNo);
				student.setStudent_name(studentName);
				student.setStudent_contact(studentContact);
				ClassService classService = new ClassServiceImpl();
				Classes item = classService.getClass(classNo);
				student.setClasses(item);
				student.setAdd_time(new Date());
				studentService.addStudent(student);
				request.getRequestDispatcher("studentListServlet").forward(request, response);
			}
		}
	}

}
