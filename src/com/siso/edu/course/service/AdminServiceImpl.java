package com.siso.edu.course.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.siso.edu.course.bean.Admin;
import com.siso.edu.course.bean.Teacher;
import com.siso.edu.course.db.ConnectionDB;
import com.siso.edu.course.utils.TimeConvert;

public class AdminServiceImpl implements AdminService {
	ConnectionDB connDB = ConnectionDB.getInstance();
	Connection conn = connDB.getConnection();
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public Admin getAdmin(String account, String password) {
		String sql = "select * from admin where admin_no=? and password=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdmin_no(rs.getString("admin_no"));
				admin.setPassword(rs.getString("password"));
				admin.setAdmin_name(rs.getString("admin_name"));
				admin.setAdmin_contact(rs.getString("admin_contact"));
				admin.setAdd_time(TimeConvert.convertSqlToUtil(rs.getDate("add_time")));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String adminNo, String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update admin set password=? where admin_no=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, adminNo);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
