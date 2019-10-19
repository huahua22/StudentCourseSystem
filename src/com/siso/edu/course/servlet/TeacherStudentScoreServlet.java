package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.ChooseInforBean;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuwanru 2018年8月3日
 */
public class TeacherStudentScoreServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		int courseNo = Integer.parseInt(request.getParameter("chooseId"));
		String courseName = request.getParameter("chooseName");
		System.out.println(courseNo);
		System.out.println(courseName);
		ChooseService chooseService = new ChooseServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		List<Choose> chooseList = chooseService.getChooseByCourseNo(courseNo);
		// List<Choose> chooseList =
		// chooseService.getChooseByTeacherNo(LoginServlet.NOW_TEACHER.getTeacher_no());
		// List<Choose> chooseList = chooseService.getChooseByTeacherNo("001");
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for (int i = 0; i < chooseList.size(); i++) {
			Student student = studentService.getStudent(chooseList.get(i).getStudent_no());
			ChooseInforBean chooseInforBean = new ChooseInforBean();

			chooseInforBean.setStudent_no(student.getStudent_no());
			chooseInforBean.setStudent_name(student.getStudent_name());
			chooseInforBean.setClass_name(student.getClasses().getClass_name());
			chooseInforBean.setCourse_name(chooseList.get(i).getCourse().getCourse_name());
			chooseInforBean.setTeacher_name(chooseList.get(i).getCourse().getTeacher().getTeacher_name());
			chooseInforBean.setScore(chooseList.get(i).getScore());
			array.add(JSONObject.fromObject(chooseInforBean));

		}
		out.print(array.toString());
		out.flush();
		out.close();
	}

}
