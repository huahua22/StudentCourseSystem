package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.service.TeacherService;
import com.siso.edu.course.service.TeacherServiceImpl;

/**
 * @author xuwanru 2018年8月1日
 */
public class UpdateTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String teacherNo = request.getParameter("teacherNo");
         
		String teacherName = request.getParameter("teacherName");
		String teacherContact = request.getParameter("teacherContact");
		TeacherService teacherService = new TeacherServiceImpl();
		Teacher teacher = teacherService.getTeacher(teacherNo);
		teacher.setTeacher_name(teacherName);
		teacher.setTeacher_contact(teacherContact);
		teacherService.updateTeacher(teacher);
		request.getRequestDispatcher("teacherListServlet").forward(request, response);

	}

}
