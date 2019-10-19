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
 * @date 2018年7月22日
 */
public class ClassServiceImpl implements ClassService {
	ConnectionDB connDB = ConnectionDB.getInstance();
	Connection conn = connDB.getConnection();
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	@Override
	public Classes getClass(int classNo) {
		// TODO Auto-generated method stub
		String sql = "select * from classes where class_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classNo);
			rs = ps.executeQuery();
			Classes classItem = new Classes();
			while (rs.next()) {
				classItem.setClass_no(rs.getInt("class_no"));
				classItem.setClass_name(rs.getString("class_name"));
				classItem.setDepart_name(rs.getString("depart_name"));
				classItem.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
			}
			return classItem;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Classes getClassByClassName(String className) {
		String sql = "select * from classes where class_name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, className);
			rs = ps.executeQuery();
			while (rs.next()) {
				Classes classItem = new Classes();
				classItem.setClass_no(rs.getInt("class_no"));
				classItem.setClass_name(rs.getString("class_name"));
				classItem.setDepart_name(rs.getString("depart_name"));
				classItem.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				return classItem;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Classes> getClassList() {
		// TODO Auto-generated method stub
		List<Classes> classList = new ArrayList<Classes>();
		String sql = "select class_no,class_name,depart_name from classes";
		try {
			Statement state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				Classes item = new Classes();
				item.setClass_no(rs.getInt("class_no"));
				item.setClass_name(rs.getString("class_name"));
				item.setDepart_name(rs.getString("depart_name"));
				System.out.println(item.getClass_name());
				System.out.println(item.getDepart_name());
				//item.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				classList.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classList;
	}
}
