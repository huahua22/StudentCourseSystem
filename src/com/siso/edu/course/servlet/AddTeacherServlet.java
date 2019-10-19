package com.siso.edu.course.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.siso.edu.course.bean.Course;
import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;
import com.siso.edu.course.service.TeacherService;
import com.siso.edu.course.service.TeacherServiceImpl;

/**
 * @author xuwanru 2018年8月4日
 */
public class AddTeacherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String teacherNo = request.getParameter("teacherNo");
		String teacherName= request.getParameter("teacherName");
		String teacherContact = request.getParameter("teacherContact");
		System.out.println(teacherNo + " " + teacherName + " " + teacherContact);
		TeacherService teacherService = new TeacherServiceImpl();
		
		if (teacherNo.equals("") || teacherName.equals("")||teacherContact.equals("")) {
			request.setAttribute("message", "不能为空！");
			request.getRequestDispatcher("admin/add_teacher.jsp").forward(request, response);
		} else {
			if (StringUtils.isNumeric(teacherContact) == true) {
				
				Teacher teacher = teacherService.getTeacher(teacherNo);
				if (teacher != null) {
					request.setAttribute("message", "工号已存在！");
					request.getRequestDispatcher("admin/add_teacher.jsp").forward(request, response);
				} else {
					teacher = new Teacher();
					teacher.setTeacher_no(teacherNo);
					teacher.setTeacher_name(teacherName);
					teacher.setTeacher_contact(teacherContact);
					teacher.setAdd_time(new Date());
					teacherService.addTeacher(teacher);
					request.setAttribute("message", "录入成功！");
					request.getRequestDispatcher("teacherListServlet").forward(request, response);
				}
			} else {
				request.setAttribute("message", "非法输入！请输入数字！");
				request.getRequestDispatcher("admin/add_teacher.jsp").forward(request, response);
			}
		}
	}

}
