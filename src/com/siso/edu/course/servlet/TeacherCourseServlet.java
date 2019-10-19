package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Course;
import com.siso.edu.course.bean.CourseBean;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TeacherCourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		CourseService courseService = new CourseServiceImpl();
		List<Course> courseList = courseService.getCourseByTeacherNo(LoginServlet.NOW_TEACHER.getTeacher_no());
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for (int i = 0; i < courseList.size(); i++) {
			CourseBean courseBean = new CourseBean();
			courseBean.setCourse_no(courseList.get(i).getCourse_no());
			courseBean.setCourse_name(courseList.get(i).getCourse_name());
			courseBean.setUp_limit(courseList.get(i).getUp_limit());
			courseBean.setCourse_status(courseList.get(i).getCourse_status());
			courseBean.setTeacher_no(courseList.get(i).getTeacher().getTeacher_no());
			courseBean.setTeacher_name(courseList.get(i).getTeacher().getTeacher_name());
			;
			array.add(JSONObject.fromObject(courseBean));
		}
		System.out.println(array.toString());
		out.print(array.toString());
		out.flush();
		out.close();
	}

}
