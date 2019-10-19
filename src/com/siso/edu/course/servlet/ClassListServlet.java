package com.siso.edu.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siso.edu.course.bean.ClassBean;
import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.service.ClassService;
import com.siso.edu.course.service.ClassServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xuwanru
 * 2018年7月29日
 */
public class ClassListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		ClassService classService = new ClassServiceImpl();
		List<Classes> classList = classService.getClassList();
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		for(int i=0;i<classList.size();i++){
			ClassBean classBean = new ClassBean();
			classBean.setClass_no(classList.get(i).getClass_no());
			classBean.setClass_name(classList.get(i).getClass_name());
			classBean.setDepart_name(classList.get(i).getDepart_name());
			//array.add(JSONObject.fromObject(classList.get(i)));
			array.add(JSONObject.fromObject(classBean));
		}
		//System.out.println(array.toString());
		out.print(array.toString());
		out.flush();
		out.close();
		
		
		
	}
}
