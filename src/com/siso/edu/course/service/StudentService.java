package com.siso.edu.course.service;

import java.util.List;

import com.siso.edu.course.bean.Student;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public interface StudentService {
	public void addStudent(Student student);//添加学生
    public void showAllStudents();//显示所有学生信息
    public Student getStudent(String studentNo);//根据学号获得对象
    public void updateStudent(Student student);//修改学生
    public void deleteStudent(String  studentNo);//根据学号删除学生
    public Student getStudent(String account,String password);//登录验证
    public List<Student> getStudentList();//获得所有学生对象
    public void updateStudentPassword(String studentNo,String newPassword);//修改密码
    public List<Student> getStudentList(int classNo);//获取某班学生
    public int getTotalPages();//总页数
    public List<Student> getAllStudent(int startIndex,int pageSize);
}
