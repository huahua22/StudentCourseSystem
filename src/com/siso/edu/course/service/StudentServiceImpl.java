package com.siso.edu.course.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siso.edu.course.bean.Classes;
import com.siso.edu.course.bean.Student;
import com.siso.edu.course.db.ConnectionDB;
import com.siso.edu.course.utils.TimeConvert;

/**
 * @author xuwanru
 * @date 2018年7月21日
 */
public class StudentServiceImpl implements StudentService {
	ConnectionDB connDB = ConnectionDB.getInstance();
	Connection conn = connDB.getConnection();// 获取连接对象
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	@Override
	public void addStudent(Student student) {
		String sql = "insert into student(student_no,student_name,student_contact,class_no,add_time)"
				+ "values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);// 预编译
			ps.setString(1, student.getStudent_no());
			ps.setString(2, student.getStudent_name());
			ps.setString(3, student.getStudent_contact());
			ps.setInt(4, student.getClasses().getClass_no());
			ps.setDate(5, TimeConvert.convertUtilToSql(student.getAdd_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void showAllStudents() {
		// TODO Auto-generated method stub
		try {
			Statement state = conn.createStatement();
			String sql = "select student.student_no,student_name,student_contact,classes.class_name,student.add_time from student "
					+ "join classes on student.class_no = classes.class_no";
			rs = state.executeQuery(sql);
			while (rs.next()) {
				System.out.print("学号：" + rs.getString("student_no"));
				System.out.print("\t姓名：" + rs.getString("student_name"));
				System.out.print("\t联系方式：" + rs.getString("student_contact"));
				System.out.print("\t班级：" + rs.getString("class_name"));
				System.out.println("\t添加时间：" + rs.getString("add_time"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Student getStudent(String studentNo) {
		// TODO Auto-generated method stub
		String sql = "select * from student where student_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, studentNo);
			rs = ps.executeQuery();
			Student student = new Student();
			while (rs.next()) {
				student.setStudent_no(rs.getString("student_no"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_contact(rs.getString("student_contact"));
				student.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				int class_no = rs.getInt("class_no");
				ClassService classService = new ClassServiceImpl();
				student.setClasses(classService.getClass(class_no));
				student.setPassword(rs.getString("password"));
				return student;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateStudent(Student student) {
		String sql = "update student set  student_name=?,student_contact=?,class_no=? where student_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student.getStudent_name());
			ps.setString(2, student.getStudent_contact());
			ps.setInt(3, student.getClasses().getClass_no());
			ps.setString(4, student.getStudent_no());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(String studentNo) {
		String sql = "delete from student where student_no=?";
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
	public Student getStudent(String account, String password) {
		// TODO Auto-generated method stub
		String sql = "select * from student where student_no=? and password=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudent_no(rs.getString("student_no"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_contact(rs.getString("student_contact"));
				ClassService classService = new ClassServiceImpl();
				Classes item = classService.getClass(rs.getInt("class_no"));
				student.setClasses(item);
				student.setPassword(rs.getString("password"));
				student.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				return student;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student";
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				Student stu = new Student();
				stu.setStudent_no(rs.getString("student_no"));
				stu.setStudent_name(rs.getString("student_name"));
				stu.setStudent_contact(rs.getString("student_contact"));
				ClassService classService = new ClassServiceImpl();
				Classes item = classService.getClass(rs.getInt("class_no"));
				stu.setClasses(item);
				stu.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				studentList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public void updateStudentPassword(String studentNo, String newPassword) {
		String sql = "update student set password=? where student_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, studentNo);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int getTotalPages() {
		String sql = "select * from student";

		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Student> getAllStudent(int startIndex, int pageSize) {
		List<Student> stuList = new ArrayList<Student>();
		String sql = "select * from student limit ?,?";
		try {
			PreparedStatement pstate = conn.prepareStatement(sql);
			pstate.setInt(1, startIndex);
			pstate.setInt(2, pageSize);
			ResultSet rs = pstate.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudent_no(rs.getString("student_no"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_contact(rs.getString("student_contact"));
				ClassService classService = new ClassServiceImpl();
				Classes item = classService.getClass(rs.getInt("class_no"));
				student.setClasses(item);
				student.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				stuList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public List<Student> getStudentList(int classNo) {
		// TODO Auto-generated method stub
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student where class_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setStudent_no(rs.getString("student_no"));
				stu.setStudent_name(rs.getString("student_name"));
				stu.setStudent_contact(rs.getString("student_contact"));
				ClassService classService = new ClassServiceImpl();
				Classes item = classService.getClass(rs.getInt("class_no"));
				stu.setClasses(item);
				stu.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				studentList.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

}
