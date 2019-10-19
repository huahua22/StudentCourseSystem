package com.siso.edu.course.service;

import java.util.List;

import com.siso.edu.course.bean.Course;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public interface CourseService {
	public Course  getCourse(String courseName);//根据课程名获取对象
	public void addCourse(Course course);//添加课程
	public void showAllCourses();//显示所有对象
	public Course getCourse(int courseNo);//根据id获取对象
	public List<Course> getAllCourses();//获取所有课程对象
	public void deleteCourseByTeacherNo(String teacherNo);//根据教师删除课程
	public List<Course> getCourseByTeacherNo(String teacherNo);//根据教师编号查找课程

}
