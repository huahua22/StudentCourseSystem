package com.siso.edu.course.bean;

import java.util.Date;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class Choose {
private  String Student_no;
private Course course;
private int score;
private Date choose_time;
public String getStudent_no() {
	return Student_no;
}
public void setStudent_no(String student_no) {
	Student_no = student_no;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public Date getChoose_time() {
	return choose_time;
}
public void setChoose_time(Date choose_time) {
	this.choose_time = choose_time;
}

}
