package com.siso.edu.course.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.siso.edu.course.service.AdminService;
import com.siso.edu.course.service.AdminServiceImpl;

public class UpdateAdminPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String newpassword2 = request.getParameter("newpassword2");
		System.out.println(oldpassword);
		System.out.println(newpassword);
		if (oldpassword.equals("")|| newpassword.equals("")|| newpassword2.equals("")) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
		} else {
			if (oldpassword.equals(LoginServlet.NOW_ADMIN.getPassword())) {
				if (newpassword.equals(newpassword2)) {
					AdminService adminService = new AdminServiceImpl();

					adminService.updatePassword(LoginServlet.NOW_ADMIN.getAdmin_no(), newpassword);
					if (session.getAttribute("permission") == null) {
						JOptionPane.showMessageDialog(null, "登录已失效");
						response.sendRedirect("login.jsp");
					}
				} else {
					JOptionPane.showMessageDialog(null, "两次输入的密码不同");
					System.out.println("两次输入的密码不同");
				}
			} else {
				JOptionPane.showMessageDialog(null, "旧密码错误！");
				System.out.println("旧密码错误！");
			}
		}
	}

}
