package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
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

/**
 * @author xuwanru 2018年8月3日
 */
public class TeacherSelectStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String studentNo = request.getParameter("studentNo");
		String courseName = request.getParameter("courseName");
		System.out.println(studentNo);
		System.out.println(courseName);
		ChooseService chooseService = new ChooseServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		
		Choose choose = chooseService.getChoose(studentNo, courseName);
		Student student = studentService.getStudent(studentNo);
		ChooseInforBean chooseInforBean = new ChooseInforBean();
		
		chooseInforBean.setStudent_no(student.getStudent_no());
		chooseInforBean.setStudent_name(student.getStudent_name());
		chooseInforBean.setClass_name(student.getClasses().getClass_name());
		chooseInforBean.setCourse_name(choose.getCourse().getCourse_name());
		
		request.setAttribute("choose", chooseInforBean);
		request.getRequestDispatcher("teacher/add_score.jsp").forward(request, response);	
	}

}
