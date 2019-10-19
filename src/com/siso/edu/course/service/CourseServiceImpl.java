package com.siso.edu.course.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Course;
import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.db.ConnectionDB;
import com.siso.edu.course.utils.TimeConvert;

/**
 * @author xuwanru
 * @date 2018年7月22日
 */
public class CourseServiceImpl implements CourseService {
	ConnectionDB connDB = ConnectionDB.getInstance();
	Connection conn = connDB.getConnection();
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public Course getCourse(String courseName) {
		String sql = "select * from course where course_name =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, courseName);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_no(rs.getInt("course_no"));
				course.setCourse_name(rs.getString("course_name"));
				course.setUp_limit(rs.getInt("up_limit"));
				course.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				String teacherNo = rs.getString("teacher_no");
				TeacherService teacherService = new TeacherServiceImpl();
				Teacher teacher = teacherService.getTeacher(teacherNo);
				course.setTeacher(teacher);
				return course;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addCourse(Course course) {
		String sql = "insert into course(course_name,up_limit,course_status,teacher_no,add_time) "
				+ "values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, course.getCourse_name());
			ps.setInt(2, course.getUp_limit());
			ps.setString(3, course.getCourse_status());
			ps.setString(4, course.getTeacher().getTeacher_no());
			ps.setDate(5, TimeConvert.convertUtilToSql(course.getAdd_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showAllCourses() {
		try {
			Statement state = conn.createStatement();
			String sql = "select course_no,course_name,up_limit,course_status,course.teacher_no,teacher_name,course.add_time "
					+ "from course join teacher on course.teacher_no = teacher.teacher_no";
			rs = state.executeQuery(sql);
			while (rs.next()) {
				System.out.print("课程id：" + rs.getInt("course_no"));
				System.out.print("\t课程名：" + rs.getString("course_name"));
				System.out.print(" \t人数上限：" + rs.getInt("up_limit"));
				System.out.print("\t课程状态：" + rs.getString("course_status"));
				System.out.print("\t教师编号：" + rs.getString("teacher_no"));
				System.out.print("\t教师名字：" + rs.getString("teacher_name"));
				System.out.println("\t添加时间：" + rs.getString("add_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Course getCourse(int courseNo) {
		String sql = "SELECT * from course where course_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, courseNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course course = new Course();
				course.setCourse_no(rs.getInt("course_no"));
				course.setCourse_name(rs.getString("course_name"));
				course.setUp_limit(rs.getInt("up_limit"));
				course.setCourse_status(rs.getString("course_status"));
				TeacherService teacherService = new TeacherServiceImpl();
				Teacher teacher = teacherService.getTeacher(rs.getString("teacher_no"));
				course.setTeacher(teacher);
				course.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				return course;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courseList = new ArrayList<Course>();
		String sql = "select * from course";
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				Course item = new Course();
				item.setCourse_no(rs.getInt("course_no"));
				item.setCourse_name(rs.getString("course_name"));
				item.setUp_limit(rs.getInt("up_limit"));
				item.setCourse_status(rs.getString("course_status"));
				TeacherService teacherService = new TeacherServiceImpl();
				Teacher teacher = teacherService.getTeacher(rs.getString("teacher_no"));
				item.setTeacher(teacher);
				item.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				courseList.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public void deleteCourseByTeacherNo(String teacherNo) {
		String sql = "delete from course where teacher_no =?";
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
	public List<Course> getCourseByTeacherNo(String teacherNo) {
		String sql = "select * from course where teacher_no =?";
		List<Course> courseList = new ArrayList<Course>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Course item = new Course();
				item.setCourse_no(rs.getInt("course_no"));
				item.setCourse_name(rs.getString("course_name"));
				item.setUp_limit(rs.getInt("up_limit"));
				item.setCourse_status(rs.getString("course_status"));
				TeacherService teacherService = new TeacherServiceImpl();
				Teacher teacher = teacherService.getTeacher(rs.getString("teacher_no"));
				item.setTeacher(teacher);
				item.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				courseList.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return courseList;
	}

}
