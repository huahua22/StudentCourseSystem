package com.siso.edu.course.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* @author   xuwanru
*  @date  2018骞�7鏈�22鏃�
*/
public class ConnectionDB {
	
	private Connection conn = null;//鏁版嵁搴撹繛鎺ュ璞�
	private String user = "root";//鐢ㄦ埛鍚�
	private String password="123456";//杩炴帴瀵嗙爜
	private String url="jdbc:mysql://127.0.0.1:3306/coursedb?useUnicode=true&characterEncoding=utf8";//鏁版嵁搴撹矾寰�
	private static  ConnectionDB connDB = null;
	/**
	 * 鑾峰彇ConnectionDB瀵硅薄
	 * @return
	 */
	public static ConnectionDB getInstance(){
		if(connDB==null){
			connDB = new ConnectionDB();
		}
		return connDB;	
	}
	
	/**
	 * 鑾峰彇杩炴帴瀵硅薄
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");//鍔犺浇椹卞姩
			conn=DriverManager.getConnection(url, user, password);//鑾峰彇杩炴帴瀵硅薄
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 鍏抽棴鏁版嵁搴撹繛鎺�
	 */
	public void closeConnection(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
