package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;
import com.siso.edu.course.utils.GetRequestBody;

/**
 * @author xuwanru 2018年8月2日
 */
public class StudentChooseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 設置编码格式防止乱码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String requestBody = GetRequestBody.getRequestInfo(request);

		int courseNo = Integer.parseInt(requestBody);
		CourseService courseService = new CourseServiceImpl();
		Course course = courseService.getCourse(courseNo);
		ChooseService chooseService = new ChooseServiceImpl();

		Choose choose =chooseService.getChoose(LoginServlet.NOW_STUDENT.getStudent_no(), course.getCourse_name());
		//Choose choose = chooseService.getChoose("2016001", course.getCourse_name());
		PrintWriter out = response.getWriter();
		if (choose == null) {
			choose = new Choose();
			choose.setStudent_no(LoginServlet.NOW_STUDENT.getStudent_no());
			//choose.setStudent_no("2016001");
			choose.setCourse(course);
			choose.setChoose_time(new Date());
			chooseService.addChoose(choose);
			out.print("选课成功！");
		} else {
			out.print("你已选了该课，请重新选择！");
		}
		out.flush();
		out.close();
	}

}
