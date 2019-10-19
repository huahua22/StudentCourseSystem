package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.ChooseBean;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.CourseService;
import com.siso.edu.course.service.CourseServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuwanru 2018年8月1日
 */
public class GetChooseInfor extends HttpServlet {

	public static int CHOOSE =0;
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
		int chooseId = Integer.parseInt(request.getParameter("chooseId"));
		GetChooseInfor.CHOOSE=chooseId;
		String chooseName = request.getParameter("chooseName");

		// 课程查找
		if (chooseId == 1) {
			
			CourseService courseService = new CourseServiceImpl();
			List<Course> courseList = courseService.getAllCourses();
			PrintWriter out = response.getWriter();
			JSONArray array = new JSONArray();
			for (int i = 0; i < courseList.size(); i++) {
				ChooseBean chooseBean = new ChooseBean();
				chooseBean.setId(courseList.get(i).getCourse_no());
				chooseBean.setName(courseList.get(i).getCourse_name());
				array.add(JSONObject.fromObject(chooseBean));
			}
			System.out.println(array.toString());
			out.print(array.toString());
			out.flush();
			out.close();
		}
		// 学号查找
		else if (chooseId == 2) {
			StudentService studentService = new StudentServiceImpl();
			List<Student> studentList = studentService.getStudentList();
			PrintWriter out = response.getWriter();
			JSONArray array2 = new JSONArray();
			for (int i = 0; i < studentList.size(); i++) {
				ChooseBean chooseBean = new ChooseBean();
				chooseBean.setId(i + 1);
				chooseBean.setName(studentList.get(i).getStudent_no());
				array2.add(JSONObject.fromObject(chooseBean));
			}
			System.out.println(array2.toString());
			out.print(array2.toString());
			out.flush();
			out.close();

		}
	}

}
