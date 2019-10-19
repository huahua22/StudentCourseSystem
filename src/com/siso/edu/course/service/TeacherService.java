package com.siso.edu.course.service;

import java.util.List;

import com.siso.edu.course.bean.Teacher;

/**
 * @author xuwanru
 * @date 2018年7月22日
 */
public interface TeacherService {
	public void addTeacher(Teacher teacher);//录入教师
	public Teacher getTeacher(String teacherNo);//根据教师编号获取对象

	public List<Teacher> getTeachers();

	public Teacher getTeacher(String account, String password);// 登录验证
	public void deleteTeacher(String teacherNo);//根据教师编号删除
	public void updateTeacher(Teacher teacher);//修改
	public void updateTeacherPassword(String teacherNo,String newpassword);//修改密码

}
