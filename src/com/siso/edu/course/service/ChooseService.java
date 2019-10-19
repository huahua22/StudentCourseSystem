package com.siso.edu.course.service;

import java.util.List;

import com.siso.edu.course.bean.Choose;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public  interface  ChooseService {
	public void addChoose(Choose choose);//选课
    public void showAllChooses();//显示选课所有信息
    public Choose  getChoose(String studentNo,String courseName);//根据学号，课程名查找对象
    public void updateScore(Choose choose);//录入分数
    public void showAllScore();
    public void searchScore(String studentNo);//按学号查成绩
    public void searchAvgAndSumScore(String studentNo);//查平均分和总分
    public boolean isChoose(String studentNo);//存在该学号的选课信息
    public void deleteStudentChoose(String studentNo);//根据学号删除选课信息
    
    public List<Choose> getChoose(String studentNo);//根据学号查找对象选的所有课
    public List<Choose> getChooseByCourseNo(int courseNo);//根据课程id查找对象选的所有课
    public List<Choose> getChooseByTeacherNo(String teacherNo);//根据教师编号查找对象
    public  void  deleteChooseByTeacherNo(String teacherNo);
   

}
