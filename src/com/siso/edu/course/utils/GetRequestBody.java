package com.siso.edu.course.utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuwanru
 * 2018年8月3日
 */
public class GetRequestBody {

	public static String getRequestInfo(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		BufferedReader reader;
		try {
			reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			return new String(json);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return "";

	}

}
