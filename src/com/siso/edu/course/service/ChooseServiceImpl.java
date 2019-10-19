package com.siso.edu.course.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siso.edu.course.bean.Choose;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.db.ConnectionDB;
import com.siso.edu.course.utils.TimeConvert;

/**
 * @author xuwanru
 * @date 2018年7月22日
 */
public class ChooseServiceImpl implements ChooseService {

	ConnectionDB connDB = ConnectionDB.getInstance();
	Connection conn = connDB.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public void addChoose(Choose choose) {
		String sql = "insert into choose(student_no,course_no,choose_time) values(?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, choose.getStudent_no());
			ps.setInt(2, choose.getCourse().getCourse_no());
			ps.setDate(3, TimeConvert.convertUtilToSql(choose.getChoose_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showAllChooses() {
		String sql = "select choose.student_no,student_name,course_name,course.teacher_no,teacher_name,choose_time "
				+ "from choose join student on choose.student_no = student.student_no "
				+ "join course on choose.course_no = course.course_no "
				+ "join teacher on course.teacher_no = teacher.teacher_no";
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				System.out.print("学号：" + rs.getString("student_no"));
				System.out.print("\t姓名：" + rs.getString("student_name"));
				System.out.print("\t课程名：" + rs.getString("course_name"));
				System.out.print("\t教师编号：" + rs.getString("teacher_no"));
				System.out.print("\t教师姓名：" + rs.getString("teacher_name"));
				System.out.println("\t选课时间：" + rs.getString("choose_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Choose getChoose(String studentNo, String courseName) {
		String sql = "select student_no,course_name,ifnull(score ,0),choose_time  "
				+ "from choose join course on choose.course_no = course.course_no  "
				+ "where choose.student_no=? and course.course_name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			ps.setString(2, courseName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Choose choose = new Choose();
				choose.setStudent_no(rs.getString("student_no"));
				CourseService courseService = new CourseServiceImpl();
				Course course = courseService.getCourse(courseName);
				choose.setCourse(course);
				choose.setScore(rs.getInt("ifnull(score ,0)"));
				choose.setChoose_time(TimeConvert.convertSqlToUtil(rs.getDate("choose_time")));
				return choose;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateScore(Choose choose) {
		String sql = "update choose set score=? where student_no=? and course_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, choose.getScore());
			ps.setString(2, choose.getStudent_no());
			ps.setInt(3, choose.getCourse().getCourse_no());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showAllScore() {
		String sql = "select choose.student_no,student_name,course_name,score "
				+ "from choose join student on choose.student_no  = student.student_no "
				+ "join course on choose.course_no = course.course_no";
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				System.out.print("学号：" + rs.getString("student_no"));
				System.out.print("\t姓名：" + rs.getString("student_name"));
				System.out.print("\t课程名：" + rs.getString("course_name"));
				System.out.println("\t分数：" + rs.getInt("score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void searchScore(String studentNo) {
		String sql = "select student.student_no,student_name,course_name,course.teacher_no,teacher_name,score from choose "
				+ "join student on choose.student_no = student.student_no "
				+ "join course on choose.course_no = course.course_no "
				+ "join teacher on course.teacher_no = teacher.teacher_no " + "where student.student_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("学号：" + rs.getString("student_no"));
				System.out.print("\t姓名：" + rs.getString("student_name"));
				System.out.print("\t课程名：" + rs.getString("course_name"));
				System.out.print("\t教师编号：" + rs.getString("teacher_no"));
				System.out.print("\t教师姓名：" + rs.getString("teacher_name"));
				System.out.println("\t分数：" + rs.getInt("score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void searchAvgAndSumScore(String studentNo) {
		String sql = "select  choose.student_no,student.student_name,classes.class_name,avg(score),sum(score) from "
				+ "choose join student on choose.student_no = student.student_no "
				+ "join classes on student.class_no = classes.class_no " + "where student.student_no=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print("学号：" + rs.getString("student_no"));
				System.out.print("\t姓名：" + rs.getString("student_name"));
				System.out.print("\t班级：" + rs.getString("class_name"));
				System.out.print("\t平均分：" + rs.getString("avg(score)"));
				System.out.println("\t总分：" + rs.getInt("sum(score)"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean isChoose(String studentNo) {
		int count = 0;
		String sql = "select  count(1) from choose where student_no=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count(1)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void deleteStudentChoose(String studentNo) {
		String sql = "delete from choose where student_no =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void deleteChooseByTeacherNo(String teacherNo) {
		String sql = "DELETE FROM choose WHERE course_no IN(SELECT course_no FROM course WHERE teacher_no=?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherNo);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Choose> getChoose(String studentNo) {
		List<Choose> chooses = new ArrayList<Choose>();
		String sql = "select student_no,course_no,score from choose where student_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Choose choose = new Choose();
				choose.setStudent_no(rs.getString("student_no"));
				CourseService courseService = new CourseServiceImpl();
				Course course = courseService.getCourse(rs.getInt("course_no"));
				choose.setCourse(course);
				choose.setScore(rs.getInt("score"));
				chooses.add(choose);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chooses;
	}

	@Override
	public List<Choose> getChooseByCourseNo(int courseNo) {
		List<Choose> chooses = new ArrayList<Choose>();
		String sql = "select student_no,course_no,score from choose where course_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Choose choose = new Choose();
				choose.setStudent_no(rs.getString("student_no"));
				CourseService courseService = new CourseServiceImpl();
				Course course = courseService.getCourse(rs.getInt("course_no"));
				choose.setCourse(course);
				choose.setScore(rs.getInt("score"));
				chooses.add(choose);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chooses;
	}

	@Override
	public List<Choose> getChooseByTeacherNo(String teacherNo) {
		List<Choose> chooses = new ArrayList<Choose>();
		String sql="select student.student_no,choose.course_no,score "
				+ "from choose join student on choose.student_no = student.student_no "
		        + "join course on choose.course_no = course.course_no "
				+"join teacher on course.teacher_no = teacher.teacher_no "
		        +"where course.teacher_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherNo);
			rs = ps.executeQuery();
			while(rs.next()){
				Choose choose = new Choose();
				choose.setStudent_no(rs.getString("student_no"));
				CourseService courseService = new CourseServiceImpl();
				Course course = courseService.getCourse(rs.getInt("course_no"));
				choose.setCourse(course);
				choose.setScore(rs.getInt("score"));
				chooses.add(choose);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return chooses;
	}
}
