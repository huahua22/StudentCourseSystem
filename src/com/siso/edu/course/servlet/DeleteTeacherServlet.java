package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;
import com.siso.edu.course.service.TeacherService;
import com.siso.edu.course.service.TeacherServiceImpl;

public class DeleteTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String teacherNo = request.getParameter("teacher_no");
		CourseService courseService  = new CourseServiceImpl();
		courseService.deleteCourseByTeacherNo(teacherNo);
		TeacherService teacherService = new TeacherServiceImpl();
		teacherService.deleteTeacher(teacherNo);
		response.sendRedirect("teacherListServlet");//请求重定向
	}

}
