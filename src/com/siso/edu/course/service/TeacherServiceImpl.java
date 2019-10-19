package com.siso.edu.course.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.db.ConnectionDB;
import com.siso.edu.course.utils.TimeConvert;

/**
 * @author xuwanru
 * @date 2018年7月22日
 */
public class TeacherServiceImpl implements TeacherService {
    ConnectionDB connDB = ConnectionDB.getInstance();
    Connection conn = connDB.getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    CourseService courseService = new CourseServiceImpl();
    ChooseService chooseService = new ChooseServiceImpl();

    @Override
    public Teacher getTeacher(String teacherNo) {
        String sql = "select * from teacher where teacher_no=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacherNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacher_no(rs.getString("teacher_no"));
                teacher.setTeacher_name(rs.getString("teacher_name"));
                teacher.setTeacher_contact(rs.getString("teacher_contact"));
                teacher.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
                return teacher;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Teacher getTeacher(String account, String password) {
        String sql = "select * from teacher where teacher_no=? and password=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacher_no(rs.getString("teacher_no"));
                teacher.setTeacher_name(rs.getString("teacher_name"));
                teacher.setTeacher_contact(rs.getString("teacher_contact"));
                teacher.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
                teacher.setPassword(rs.getString("password"));
                return teacher;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Teacher> getTeachers() {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        String sql = "select * from teacher";
        try {
            Statement state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setTeacher_no(rs.getString("teacher_no"));
                teacher.setTeacher_name(rs.getString("teacher_name"));
                teacher.setTeacher_contact(rs.getString("teacher_contact"));
                teacher.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
                teacher.setPassword(rs.getString("password"));
                teacherList.add(teacher);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return teacherList;
    }

    @Override
    public void deleteTeacher(String teacherNo) {
        chooseService.deleteChooseByTeacherNo(teacherNo);
        courseService.deleteCourseByTeacherNo(teacherNo);
        String sql = "DELETE FROM teacher WHERE teacher_no=?";
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
    public void updateTeacher(Teacher teacher) {
        String sql = "update teacher set teacher_name=? ,teacher_contact=? where teacher_no=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getTeacher_name());
            ps.setString(2, teacher.getTeacher_contact());
            ps.setString(3, teacher.getTeacher_no());
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void updateTeacherPassword(String teacherNo, String newpassword) {
        String sql = "update teacher set password=? where admin_no=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, newpassword);
            ps.setString(2, teacherNo);
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void addTeacher(Teacher teacher) {
        String sql = "insert into teacher(teacher_no,teacher_name,teacher_contact,add_time) "
          + "values(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getTeacher_no());
            ps.setString(2, teacher.getTeacher_name());
            ps.setString(3, teacher.getTeacher_contact());
            ps.setDate(4, TimeConvert.convertUtilToSql(teacher.getAdd_time()));
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
