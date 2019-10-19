package com.siso.edu.course.service;

import com.siso.edu.course.bean.Admin;

public interface AdminService {

	public Admin getAdmin(String account,String password);//登录验证
	public void updatePassword(String adminNo,String newPassword);//修改密码
}
