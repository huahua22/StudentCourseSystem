package com.siso.edu.course.bean;

import java.util.Date;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class Classes {
private int class_no;
private String class_name;
private String depart_name;
private Date add_time;
public int getClass_no() {
	return class_no;
}
public void setClass_no(int class_no) {
	this.class_no = class_no;
}
public String getClass_name() {
	return class_name;
}
public void setClass_name(String class_name) {
	this.class_name = class_name;
}
public String getDepart_name() {
	return depart_name;
}
public void setDepart_name(String depart_name) {
	this.depart_name = depart_name;
}
public Date getAdd_time() {
	return add_time;
}
public void setAdd_time(Date add_time) {
	this.add_time = add_time;
}
}
