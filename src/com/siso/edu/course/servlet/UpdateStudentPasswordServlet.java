package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

public class UpdateStudentPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String newpassword2 = request.getParameter("newpassword2");
		if (oldpassword.equals("") || newpassword.equals("") || newpassword2.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
		} else {
			if (oldpassword.equals(LoginServlet.NOW_STUDENT.getPassword())) {
				if (newpassword.equals(newpassword2)) {
					StudentService studentService = new StudentServiceImpl();

					studentService.updateStudentPassword(LoginServlet.NOW_STUDENT.getStudent_no(), newpassword);
					if (session.getAttribute("permission") == null) {
						JOptionPane.showMessageDialog(null, "登录已失效");
						response.sendRedirect("login.jsp");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次输入的密码不同");

				}
			} else {
				JOptionPane.showMessageDialog(null, "旧密码错误！");

			}
		}
	}

}
