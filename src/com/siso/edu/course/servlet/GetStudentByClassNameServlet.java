package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.bean.StudentBean;
import com.siso.edu.course.service.ClassService;
import com.siso.edu.course.service.ClassServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetStudentByClassNameServlet extends HttpServlet {

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
		int classId = Integer.parseInt(request.getParameter("classId"));
		String className = request.getParameter("className");
		StudentService studentService = new StudentServiceImpl();
		List<Student> studentList = new ArrayList<Student>();
		System.out.println("className:" + className);
		if (classId == 0) {
             studentList = studentService.getStudentList();
		}else{
			ClassService classService = new ClassServiceImpl();
			Classes item = classService.getClassByClassName(className);
			studentList = studentService.getStudentList(item.getClass_no());
		}
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for (int i = 0; i < studentList.size(); i++) {

			// array.add(JSONObject.fromObject(studentList.get(i)));
			StudentBean stuBean = new StudentBean();
			stuBean.setStudent_no(studentList.get(i).getStudent_no());
			stuBean.setStudent_name(studentList.get(i).getStudent_name());
			stuBean.setStudent_contact(studentList.get(i).getStudent_contact());
			stuBean.setDepart_name(studentList.get(i).getClasses().getDepart_name());
			stuBean.setClassName(studentList.get(i).getClasses().getClass_name());
			stuBean.setClassNo(studentList.get(i).getClasses().getClass_no());
			array.add(JSONObject.fromObject(stuBean));
		}
		out.print(array.toString());
		out.flush();
		out.close();
	}

}
