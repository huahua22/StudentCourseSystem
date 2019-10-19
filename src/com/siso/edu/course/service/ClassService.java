package com.siso.edu.course.service;

import java.util.List;

import com.siso.edu.course.bean.Classes;

/**
 * @author xuwanru
 * @date 2018年7月22日
 */
public interface ClassService {
	public Classes getClass(int classNo);// 根据id获得对象

	public Classes getClassByClassName(String className);// 根据班级获得对象

	public List<Classes> getClassList();// 获取所有对象
}
