package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.ChooseInforBean;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.ChooseService;
import com.siso.edu.course.service.ChooseServiceImpl;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChooseListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		ChooseService chooseService = new ChooseServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		int chooseId = Integer.parseInt(request.getParameter("chooseId"));
		String chooseName = request.getParameter("chooseName");
		System.out.println(chooseId);
		System.out.println(chooseName);
		System.out.println(GetChooseInfor.CHOOSE);
		if (GetChooseInfor.CHOOSE == 1) {
			List<Choose> chooseList = chooseService.getChooseByCourseNo(chooseId);
			if (chooseList.size() == 0) {// 无数据
				request.getRequestDispatcher("admin/choose_center.jsp").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				JSONArray array = new JSONArray();
				for (int i = 0; i < chooseList.size(); i++) {
					ChooseInforBean chooseInforBean = new ChooseInforBean();
					Student student = studentService.getStudent(chooseList.get(i).getStudent_no());
					chooseInforBean.setStudent_no(chooseList.get(i).getStudent_no());
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
		} else if (GetChooseInfor.CHOOSE == 2) {
			List<Choose> chooseList = chooseService.getChoose(chooseName);
			if (chooseList.size() == 0) {// 无数据
				request.getRequestDispatcher("admin/choose_center.jsp").forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				JSONArray array2 = new JSONArray();
				for (int i = 0; i < chooseList.size(); i++) {
					ChooseInforBean chooseInforBean = new ChooseInforBean();
					Student student = studentService.getStudent(chooseList.get(i).getStudent_no());
					chooseInforBean.setStudent_no(chooseList.get(i).getStudent_no());
					chooseInforBean.setStudent_name(student.getStudent_name());
					chooseInforBean.setClass_name(student.getClasses().getClass_name());
					chooseInforBean.setCourse_name(chooseList.get(i).getCourse().getCourse_name());
					chooseInforBean.setTeacher_name(chooseList.get(i).getCourse().getTeacher().getTeacher_name());
					chooseInforBean.setScore(chooseList.get(i).getScore());
					array2.add(JSONObject.fromObject(chooseInforBean));
				}
				out.print(array2.toString());
				out.flush();
				out.close();
			}
		}

	}

}
