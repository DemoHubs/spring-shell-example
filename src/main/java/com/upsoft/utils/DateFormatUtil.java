package com.upsoft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	public static final String YYYY_MM_DD_HH_MM_SS="yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static String format(long time){
		return format.format(new Date(time));
	}
	public static Long format(String dateString) throws ParseException{
			Date d=format.parse(dateString);
			return d.getTime();
	}
	public static Long format(String dateString,String pattern) throws ParseException{
		return new SimpleDateFormat(pattern).parse(dateString).getTime();
	}
}
