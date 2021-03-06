package com.jeecms.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.FastDateFormat;

/**
 * 时间工具类
 * @Description:
 *@author Tom
 * @date:   2018年8月8日 下午12:54:41     
 * @Copyright:  江西金磊科技发展有限公司  All rights reserved. 
 * Notice 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class DateUtils  extends org.apache.commons.lang3.time.DateUtils{
	public static final String COM_YMD_PATTERN = "yyyyMMdd";
	public static final String COM_Y_M_D_PATTERN = "yyyy-MM-dd";
	public static final String COM_YMDHMS_PATTERN = "yyyyMMdd HH:mm:ss";
	public static final String COM_Y_M_D_H_M_S_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String COM_SECOND_PATTERN = "yyMMddHHmmss";
	public static final String COM_MILLISECOND_PATTERN = "yyyyMMddHHmmssmmmm";
	

	private DateUtils(){}
	
	/**
	 * 
	 * @Title: 指定格式，将时间字符串转换时间   
	 * @Description: 
	 * @param: @param dateStr
	 * @param: @param pattern
	 * @param: @return      
	 * @return: Date
	 */
	public static Date parseDate(String dateStr,String pattern){
		try {
			return FastDateFormat.getInstance(pattern).parse(dateStr);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	/**
	 * 
	 * @Title: 指定格式，将时间字符串转换时间   ，默认yyyy-MM-dd
	 * @Description: 
	 * @param: @param dateStr
	 * @param: @return      
	 * @return: Date
	 */
	public static Date parseDate(String dateStr){
		try {
			return FastDateFormat.getInstance(COM_Y_M_D_PATTERN).parse(dateStr);
		} catch (ParseException e) {
			return new Date();
		}
	}
	
	/**
	 * 
	 * @Title: 指定格式，将时间转换字符串   
	 * @Description: 
	 * @param: @param date
	 * @param: @param pattern
	 * @param: @return      
	 * @return: String
	 */
	public static String formatDate(Date  date,String pattern){
		return FastDateFormat.getInstance(pattern).format(date);
	}
	
	/**
	 * 
	 * @Title: 指定格式，将时间转换字符串   ，默认yyyy-MM-dd
	 * @Description: 
	 * @param: @param date
	 * @param: @param pattern
	 * @param: @return      
	 * @return: String
	 */
	public static String formatDate(Date  date){
		return FastDateFormat.getInstance(COM_Y_M_D_PATTERN).format(date);
	}
	
	
	private static int getDateField(Date date, int field) {
		Calendar c = getCalendar();
		c.setTime(date);
		return c.get(field);
	}
	
	
	/**
	 * 获取两个时间的秒数差
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Integer getSecondBetweenDate(Date d1,Date d2){
		Long second=(d2.getTime()-d1.getTime())/1000;
		return second.intValue();
	}
	
	
	/**
	 * 获取指定日期之间相差分钟数,返回double
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return
	 * @return: Double 返回负数表示 end 在begin之前 ，0.0 两时间相等 ，正数begin在end之前
	 */
	public static Double getDiffMinuteTwoDate(Date begin, Date end) {
		return (end.getTime() - begin.getTime()) / 1000 / 60.0;
	}

	/**
	 * 获取指定日期之间相差分钟数,返回int
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return
	 * @return: int 返回负数表示 end 在begin之前 ，0两时间相等 ，正数begin在end之前
	 */
	public static Integer getDiffIntMinuteTwoDate(Date begin, Date end) {
		return (int) ((end.getTime() - begin.getTime()) / 1000 / 60);
	}
	
	/**
	 * 获取指定日期之间相差小时数,返回int
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return
	 * @return: int 返回负数表示 end 在begin之前 ，0两时间相等 ，正数begin在end之前
	 */
	public static Double getDiffHourTwoDate(Date begin, Date end) {
		return getDiffMinuteTwoDate(begin, end)/60;
	}
	
	/**
	 * 获取指定日期之间相差小时数,返回int
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return
	 * @return: int 返回负数表示 end 在begin之前 ，0两时间相等 ，正数begin在end之前
	 */
	public static Integer getDiffIntHourTwoDate(Date begin, Date end) {
		return  getDiffHourTwoDate(begin, end).intValue();
	}
	
	/**
	 * 计算指定时间的年份差（只考虑年份数）
	 * @Title: getYearsBetweenDate   
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return      
	 * @return: int
	 */
	public static int getYearsBetweenDate(Date begin, Date end) {
		int bYear = getDateField(begin, Calendar.YEAR);
		int eYear = getDateField(end, Calendar.YEAR);
		return eYear - bYear;
	}

	public static int getMonthsBetweenDate(Date begin, Date end) {
//		int bMonth = getDateField(begin, Calendar.MONTH);
//		int eMonth = getDateField(end, Calendar.MONTH);
//		return eMonth - bMonth;
		return 0;
	}

	public static int getWeeksBetweenDate(Date begin, Date end) {
//		int bWeek = getDateField(begin, Calendar.WEEK_OF_YEAR);
//		int eWeek = getDateField(end, Calendar.WEEK_OF_YEAR);
//		return eWeek - bWeek;
		return 0;
	}

	/**
	 * 计算指定日期之间相差天数,不足一天，不计算一天
	 * @Title: getDaysBetweenDate   
	 * @Description: 
	 * @param: @param begin
	 * @param: @param end
	 * @param: @return      
	 * @return: int
	 */
	public static int getDaysBetweenDate(Date begin, Date end) {
		return (int) ((end.getTime()-begin.getTime())/(1000 * 60 * 60 * 24));
	}
	
	

	/**
	 * 获取指定时间的指定N年后的第一天的终止时间(具体到时间00:00:00)
	 * @param date 指定时间
	 * @param amount  可正、可负
	 * @return
	 */
	public static Date getSpecficYearStart(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, amount);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取指定时间的指定N年后的最后一天的终止时间(具体到时间23:59:59)
	 * @param date 指定时间
	 * @param amount可正、可负
	 * @return
	 */
	public static Date getSpecficYearEnd(Date date, int amount) {
		Date temp = getStartDate(getSpecficYearStart(date, amount + 1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(temp);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}

	/**
	 *  获取指定时间的指定N月后的第一天的开始时间(具体到时间00:00:00)
	 * @param date 指定时间
	 * @param amount可正、可负
	 * @return
	 */
	public static Date getSpecficMonthStart(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取指定时间的指定N月后的最后一天的终止时间(具体到时间23:59:59)
	 * @param date 指定时间
	 * @param amount  可正、可负
	 * @return
	 */
	public static Date getSpecficMonthEnd(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getSpecficMonthStart(date, amount + 1));
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}

	/**
	 *  获取指定时间的指定N周后的开始时间（这里星期一为一周的开始,具体到时间00:00:00）
	 * @param date 指定时间
	 * @param amount 可正、可负
	 * @return
	 */
	public static Date getSpecficWeekStart(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取指定时间的指定N周后的最后时间（这里星期日为一周的最后一天,具体到时间23:59:59）
	 * @param date 指定时间
	 * @param amount 可正、可负
	 * @return
	 */
	public static Date getSpecficWeekEnd(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getFinallyDate(cal.getTime());
	}

	/**
	 * 获取指定时间的指定N天后的开始时间(具体到N天后的 00:00:00)
	 * @param date 指定时间
	 * @param amount 可正、可负
	 * @return
	 */
	public static Date getSpecficDateStart(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, amount);
		return getStartDate(cal.getTime());
	}
	
	/**
	 * 获取指定时间的指定N天后的最后时间(具体到N天后的23:59:59)
	 * @param date 指定时间
	 * @param amount 可正、可负
	 * @return
	 */
	public static Date getSpecficDateEnd(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, amount);
		return getFinallyDate(cal.getTime());
	}
	
	/***
	 * 获取指定时间的指定N天后的时间
	 * @Title: getSpecficDate  
	 * @param date
	 * @param amount
	 * @return      
	 * @return: Date
	 */
	public static Date getSpecficDate(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, amount);
		return cal.getTime();
	}

	/**
	 * 得到指定日期的一天的的最后时刻23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFinallyDate(Date date) {
		String temp = FastDateFormat.getInstance(COM_YMD_PATTERN).format(date);
		temp += " 23:59:59";
		try {
			return FastDateFormat.getInstance(COM_YMDHMS_PATTERN).parse(temp);
		} catch (ParseException e) {
			return new Date();
		}
	}

	/**
	 * 得到指定日期的一天的开始时刻00:00:00
	 * @param date
	 * @return
	 */
	public static Date getStartDate(Date date) {
		String temp = FastDateFormat.getInstance(COM_YMD_PATTERN).format(date);
		temp += " 00:00:00";
		try {
			return FastDateFormat.getInstance(COM_YMDHMS_PATTERN).parse(temp);
		} catch (Exception e) {
			return new Date();
		}
	}
	
	/**
	 * 
	 * @Title: 获取指定日期N分钟前的时间   
	 * @Description: 
	 * @param: @param date
	 * @param: @param minute
	 * @param: @return      
	 * @return: Date
	 */
	public static Date getMinuteBeforeTime(Date date, int minute) {
		Date beforeTime = new Date(date.getTime() - 60000*minute); //minute分钟前的时间
		return beforeTime;
	}
	
	/**
	 * 
	 * @Title: 获取指定日期N分钟后的时间   
	 * @Description: 
	 * @param: @param date
	 * @param: @param minute
	 * @param: @return      
	 * @return: Date
	 */
	public static Date getMinuteAfterTime(Date date, int minute) {
		Date beforeTime = new Date(date.getTime() + 60000*minute); //minute分钟后的时间
		return beforeTime;
	}
	
	/***
	 * 获取N小时后时间
	 * @Title: getHourAfterTime  
	 * @param date
	 * @param hour
	 * @return      
	 * @return: Date
	 */
	public static Date getHourAfterTime(Date date, int hour) {
		Date beforeTime = new Date(date.getTime() + 60000*60*hour); //hour分钟后的时间
		return beforeTime;
	}

	/**
	 * 判断日期是否为同一天
	 * @param date  指定比较日期
	 * @param compareDate
	 * @return
	 */
	public static boolean isInDate(Date date, Date compareDate) {
		int compare=compareDate.compareTo(date);
		if ((compareDate.after(getStartDate(date))
				&& compareDate.before(getFinallyDate(date)))||compare==0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * @Title: 获取当前年份   
	 * @param: @param calendar
	 * @param: @return      
	 * @return: int
	 */
	public static int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * @Title: 获取当前月份   
	 * @param: @param calendar
	 * @param: @return      
	 * @return: int
	 */
	public static int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONDAY) + 1;
	}

	/**
	 * @Title: 获取当前日期  
	 * @param: @param calendar
	 * @param: @return      
	 * @return: int
	 */
	public static int getDate(Calendar calendar) {
		return calendar.get(Calendar.DATE);
	}

	/**
	 * @Title: 获取当前小时数 
	 * @param: @param calendar
	 * @param: @return      
	 * @return: int
	 */
	public static int getHour(Calendar calendar) {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(Calendar calendar) {
		return calendar.get(Calendar.MINUTE);
	}

	public static int getSecond(Calendar calendar) {
		return calendar.get(Calendar.SECOND);
	}

	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}
	
	

	public static void main(String args[]) throws InterruptedException {
		System.out.println(getSpecficDate(Calendar.getInstance().getTime(), -1));;
		System.out.println(getHourAfterTime(Calendar.getInstance().getTime(), 24));
	}
}


