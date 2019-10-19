package com.siso.edu.course.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.Student;
import com.siso.edu.course.service.StudentService;
import com.siso.edu.course.service.StudentServiceImpl;

/**
 * @author xuwanru 2018年7月24日
 */
public class StudentListServlet extends HttpServlet {
	// 表中数据
	private int rowCount = 0;
	// 每页的数据条
	private int pageSize = 5;
	// 总页数
	private int pageCount = 0;
	// 当前页
	private int pageNow = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService studentService = new StudentServiceImpl();
		rowCount = studentService.getTotalPages();
		String changePageNow = request.getParameter("changePageNow");
		if (changePageNow != null) {
			pageNow = Integer.parseInt(changePageNow);
			if (pageNow < 0) {
				pageNow = 0;
			}
			if (pageNow > (pageCount - 1) * pageSize) {
				pageNow = (pageCount - 1) * pageSize;
			}
		}

		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}
		List<Student> list = studentService.getAllStudent(pageNow, pageSize);
		request.setAttribute("studentList", list);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageCount", pageCount);
		request.getRequestDispatcher("admin/student_manager.jsp").forward(request, response);
	}

}
