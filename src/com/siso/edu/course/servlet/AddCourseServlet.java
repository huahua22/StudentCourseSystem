package com.siso.edu.course.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
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
public class AddCourseServlet extends HttpServlet {

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
		String courseName = request.getParameter("courseName");
		String teacherNo = request.getParameter("teacherNo");
		String upLimit = request.getParameter("upLimit");
		String courseStatus = request.getParameter("courseStatus");
		//System.out.println(courseName + " " + upLimit + " " + teacherNo);
		CourseService courseService = new CourseServiceImpl();
		TeacherService teacherService = new TeacherServiceImpl();
		Teacher teacher = teacherService.getTeacher(teacherNo);
		Course course = courseService.getCourse(courseName);
		if (courseName.equals("") || upLimit.equals("")||courseStatus.equals("")) {
			request.setAttribute("message", "不能为空！");
			request.getRequestDispatcher("admin/add_course.jsp").forward(request, response);
		} else {
			if (StringUtils.isNumeric(upLimit) == true) {
				if (course != null) {
					request.setAttribute("message", "已存在该课程！");
					request.getRequestDispatcher("admin/add_course.jsp").forward(request, response);
				} else {
					course = new Course();
					course.setCourse_name(courseName);
					course.setUp_limit(Integer.parseInt(upLimit));
					course.setCourse_status(courseStatus);
					course.setTeacher(teacher);
					course.setAdd_time(new Date());
					courseService.addCourse(course);
					request.setAttribute("message", "开设成功！");
					request.getRequestDispatcher("admin/course_manager.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("message", "非法输入！请输入数字！");
				request.getRequestDispatcher("admin/add_course.jsp").forward(request, response);
			}
		}
	}

}
