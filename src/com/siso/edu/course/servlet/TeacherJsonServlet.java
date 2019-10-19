package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.bean.TeacherBean;
import com.siso.edu.course.service.TeacherService;
import com.siso.edu.course.service.TeacherServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuwanru 2018年8月4日
 */
public class TeacherJsonServlet extends HttpServlet {

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
		TeacherService teacherService = new TeacherServiceImpl();
		List<Teacher> teacherList = teacherService.getTeachers();
		
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for(int i=0;i<teacherList.size();i++){
			TeacherBean teacherBean = new TeacherBean();
			teacherBean.setTeacher_no(teacherList.get(i).getTeacher_no());
			teacherBean.setTeacher_name(teacherList.get(i).getTeacher_name());
			teacherBean.setTeacher_contact(teacherList.get(i).getTeacher_contact());
			teacherBean.setPassword(teacherList.get(i).getPassword());
			array.add(JSONObject.fromObject(teacherBean));
		}
		//System.out.println(array.toString());
		out.print(array.toString());
		out.flush();
		out.close();
	}

}
