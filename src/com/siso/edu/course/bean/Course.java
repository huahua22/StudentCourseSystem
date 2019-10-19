package com.siso.edu.course.bean;

import java.util.Date;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class Course {
	private int course_no;
	private String course_name;
	private int up_limit;
	private String course_status;
	private Teacher teacher;
	private Date add_time;

	public int getCourse_no() {
		return course_no;
	}

	public void setCourse_no(int course_no) {
		this.course_no = course_no;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getUp_limit() {
		return up_limit;
	}

	public void setUp_limit(int up_limit) {
		this.up_limit = up_limit;
	}

	public String getCourse_status() {
		return course_status;
	}

	public void setCourse_status(String course_status) {
		this.course_status = course_status;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getAdd_time() {
		return add_time;
	}

	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
}
