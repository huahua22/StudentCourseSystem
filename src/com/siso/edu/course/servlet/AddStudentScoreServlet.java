package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;

/**
 * @author xuwanru 2018年8月3日
 */
public class AddStudentScoreServlet extends HttpServlet {

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
		String courseName=request.getParameter("courseName");
		System.out.println(studentNo+","+courseName);
		if(StringUtils.isNumeric(request.getParameter("studentScore"))==true){
		  int score = Integer.parseInt(request.getParameter("studentScore"));
		  ChooseService chooseService = new ChooseServiceImpl();
		  CourseService courseService = new CourseServiceImpl();
		  Choose choose = new Choose();
		  Course course = courseService.getCourse(courseName);
		  choose.setStudent_no(studentNo);
		  choose.setCourse(course);
		  choose.setScore(score);
		  chooseService.updateScore(choose);
		  System.out.println("录入成功！");
		  request.getRequestDispatcher("teacher/teacher_student.jsp");
		}else{
			request.setAttribute("message", "非法输入!请重新输入");
			request.getRequestDispatcher("teacherSelectStudent").forward(request, response);
		}
		
	}

}
