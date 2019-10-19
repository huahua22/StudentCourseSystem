package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.siso.edu.course.bean.Admin;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.service.AdminService;
import com.siso.edu.course.service.AdminServiceImpl;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;
import com.siso.edu.course.service.TeacherService;
import com.siso.edu.course.service.TeacherServiceImpl;

/**
 * @author xuwanru 2018年7月24日
 */
public class LoginServlet extends HttpServlet {
	public static Teacher NOW_TEACHER = new Teacher();
	public static Student NOW_STUDENT = new Student();
	public static Admin NOW_ADMIN = new Admin();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println(account);
		System.out.println(password);
		int choose = Integer.parseInt(request.getParameter("role"));
		// 学生登录
		if (choose == 1) {
			System.out.println("学生登录");
			StudentService studentService = new StudentServiceImpl();
			Student student = studentService.getStudent(account, password);
			if (student == null) {
				
				request.setAttribute("message", "密码或账号错误！请重新登录！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				NOW_STUDENT = student;
				HttpSession session = request.getSession();
				session.setAttribute("student", student);
				request.getRequestDispatcher("student/student_index.jsp").forward(request, response);
			}
		}
		// 教师登录
		else if (choose == 2) {
			TeacherService teacherService = new TeacherServiceImpl();
			Teacher teacher = teacherService.getTeacher(account, password);
			if (teacher == null) {
				request.setAttribute("message", "密码或账号错误！请重新登录！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				NOW_TEACHER = teacher;
				HttpSession session = request.getSession();
				session.setAttribute("teacher", teacher);
				request.getRequestDispatcher("teacher/teacher_index.jsp").forward(request, response);
			}
		}
		// 管理员登录
		else if (choose == 3) {
			AdminService adminService = new AdminServiceImpl();
			Admin admin = adminService.getAdmin(account, password);
			if (admin == null) {
				request.setAttribute("message", "密码或账号错误！请重新登录！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				NOW_ADMIN = admin;
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				request.getRequestDispatcher("admin/admin_index.jsp").forward(request, response);
			}
		}

	}

}
