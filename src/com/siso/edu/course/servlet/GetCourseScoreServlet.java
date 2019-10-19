package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.ChooseScoreBean;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuwanru 2018年8月2日
 */
public class GetCourseScoreServlet extends HttpServlet {

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
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		ChooseService chooseService = new ChooseServiceImpl();
		List<Choose> chooseList = new ArrayList<Choose>();
		System.out.println(courseId);
		System.out.println(courseName);
		if (courseId == 0) {
			 chooseList = chooseService.getChoose(LoginServlet.NOW_STUDENT.getStudent_no());

		} else {
			Choose choose = chooseService.getChoose(LoginServlet.NOW_STUDENT.getStudent_no(), courseName);
			chooseList.add(choose);
		}
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for (int i = 0; i < chooseList.size(); i++) {
			ChooseScoreBean chooseScoreBean = new ChooseScoreBean();
			Course course = chooseList.get(i).getCourse();
			chooseScoreBean.setCourse_no(course.getCourse_no());
			chooseScoreBean.setCourse_name(course.getCourse_name());
			chooseScoreBean.setTeacher_no(course.getTeacher().getTeacher_no());
			chooseScoreBean.setTeacher_name(course.getTeacher().getTeacher_name());
			chooseScoreBean.setScore(chooseList.get(i).getScore());
			array.add(JSONObject.fromObject(chooseScoreBean));
		}
		System.out.println(array.toString());
		out.print(array.toString());
		out.flush();
		out.close();

	}

}
