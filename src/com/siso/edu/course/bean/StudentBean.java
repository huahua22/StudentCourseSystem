package com.siso.edu.course.bean;

import java.util.Date;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class StudentBean {
public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
private String student_no;
private String password;
private String student_name;
private String student_contact;
private String depart_name;
private String className;
private int classNo;
public String getStudent_no() {
	return student_no;
}
public void setStudent_no(String student_no) {
	this.student_no = student_no;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getStudent_contact() {
	return student_contact;
}
public void setStudent_contact(String student_contact) {
	this.student_contact = student_contact;
}

public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public int getClassNo() {
	return classNo;
}
public void setClassNo(int classNo) {
	this.classNo = classNo;
}
	
}
