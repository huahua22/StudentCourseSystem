package com.siso.edu.course.bean;

import java.util.Date;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class Teacher {
	private String teacher_no;
	private String password;
	private String teacher_name;
	private String teacher_contact;
	private Date add_time;
	public String getTeacher_no() {
		return teacher_no;
	}
	public void setTeacher_no(String teacher_no) {
		this.teacher_no = teacher_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public String getTeacher_contact() {
		return teacher_contact;
	}
	public void setTeacher_contact(String teacher_contact) {
		this.teacher_contact = teacher_contact;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}

}
