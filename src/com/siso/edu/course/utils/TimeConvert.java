package com.siso.edu.course.utils;

/**
* @author   xuwanru
*  @date  2018年7月22日
*/
public class TimeConvert {
	/**
	 * util.Date转化为sqlDate
	 * @param date
	 * @return
	 */
	public static java.sql.Date convertUtilToSql(java.util.Date date){
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	/**
	 * sqlDate转化为util.Date
	 * @param date
	 * @return
	 */
	public static java.util.Date convertSqlToUtil(java.sql.Date date){
		java.util.Date utilDate  = new java.util.Date(date.getTime());
		return utilDate;
	}

}
