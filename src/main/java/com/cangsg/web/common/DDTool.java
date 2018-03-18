package com.cangsg.web.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DDTool {
	static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static final SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	public static String CurrentSimpleDateFormat() {
		return df.format(System.currentTimeMillis());
	}

	public static Date CurrentDateTime() {
		Date nowTime = new Date(System.currentTimeMillis());
		return nowTime;
	}
	
	public static String SimpleDateFormat(long timestamp) {
		return df.format(timestamp);
	}
	
	public static String MSDateFormat(long timestamp) {
		return df2.format(timestamp);
	}
}
