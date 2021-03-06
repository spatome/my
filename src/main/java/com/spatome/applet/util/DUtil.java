package com.spatome.applet.util;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期工具
 */
public class DUtil {
	public static final String YM_DATE_FORMAT = "yyyy-MM";
	public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String LONG_DATE_FORMAT_NOMM = "yyyy-MM-dd HH:mm";
	public static final String ORDER_DATE_FORMAT = "yyyyMMddHH";
	public static final String LONG_DATE_FORMAT_NO_SPLIT = "yyyyMMddHHmmss";
	public static final String APP_FORMAT = "MM-dd HH:mm";

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static String formatDate(Date date) {
		if (date == null) {
			return null;
		}

		return DateFormatUtils.format(date, LONG_DATE_FORMAT);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static Date parseFormat(String time) {
		if (time == null || time.length() == 0)
			return null;
		try {
			Date date = DateUtils.parseDate(time, LONG_DATE_FORMAT);
			return date;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误:" + time);
		}
	}

	public static String formatDateApp(Date date) {
		if (date == null) {
			return null;
		}

		return DateFormatUtils.format(date, APP_FORMAT);
	}

	public static Date parseFormatApp(String time) {
		if (time == null || time.length() == 0)
			return null;
		try {
			Date date = DateUtils.parseDate(time, LONG_DATE_FORMAT);
			return date;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误:" + time);
		}
	}

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static String formatDateNoMM(Date date) {
		if (date == null) {
			return null;
		}

		return DateFormatUtils.format(date, LONG_DATE_FORMAT_NOMM);
	}

	/**
	 * yyyy-MM-dd HH:mm
	 */
	public static Date parseFormatNoMM(String time) {
		if (time == null || time.length() == 0)
			return null;
		try {
			Date date = DateUtils.parseDate(time, LONG_DATE_FORMAT_NOMM);
			return date;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误:" + time);
		}
	}

	/**
	 * yyyy-MM-dd
	 */
	public static String formatShortDate(Date date) {
		if (date == null) {
			return null;
		}

		return DateFormatUtils.format(date, SHORT_DATE_FORMAT);
	}

	/**
	 * yyyy-MM-dd
	 */
	public static Date parseShortFormat(String time) {
		if (time == null || time.length() == 0)
			return null;
		try {
			Date date = DateUtils.parseDate(time, SHORT_DATE_FORMAT);
			return date;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误:" + time);
		}
	}

	// public static Date parseLongDateNoSplit(String time)
	// {
	// if (time == null || time.length() <= 0)
	// return null;
	// try
	// {
	// Date date = LONG_DATE_FORMAT_NO_SPLIT.parse(time);
	// return date;
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// throw new RuntimeException("格式化时间错误");
	// }
	// }
	//
	// public static Date parseFormatNoMM(String time)
	// {
	// if (time == null || time.length() <= 0)
	// return null;
	// try
	// {
	// Date date = LONG_DATE_FORMAT_NOMM.parse(time);
	// return date;
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// throw new RuntimeException("格式化时间错误");
	// }
	// }
	//
	// public static Date parseFormat(String time)
	// {
	// if (time == null || time.length() <= 0)
	// return null;
	// try
	// {
	// Date date = LONG_DATE_FORMAT.parse(time);
	// return date;
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// throw new RuntimeException("格式化时间错误", ex);
	// }
	// }
	//
	// public static String formatDateNoMM(Date date)
	// {
	// return LONG_DATE_FORMAT_NOMM.format(date);
	// }
	//
	// public static String formatShortDate(Date date)
	// {
	// return formatDate(date, SHORT_DATE_FORMAT);
	// }
	//
	// public static String formatYMDate(Date date)
	// {
	// if (date == null)
	// {
	// return null;
	// }
	// return formatDate(date, YM_DATE_FORMAT);
	// }
	//
	// public static Date parseFormatShort(String time)
	// {
	// if (time == null || time.length() <= 0)
	// return null;
	// try
	// {
	// Date date = SHORT_DATE_FORMAT.parse(time);
	// return date;
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// throw new RuntimeException("格式化时间错误", ex);
	// }
	// }
	//
	// public static Date parseFormatYM(String time)
	// {
	// if (time == null || time.length() <= 0)
	// return null;
	// try
	// {
	// Date date = YM_DATE_FORMAT.parse(time);
	// return date;
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// throw new RuntimeException("格式化时间错误", ex);
	// }
	// }
	//
	// public static String formatDate(Date date, DateFormat format)
	// {
	// if (date == null)
	// {
	// return "";
	// }
	// return format.format(date);
	// }
	//
	// public static Date getCurrentDateShort()
	// {
	// Calendar cal = Calendar.getInstance();
	// cal.setTime(new Date());
	// cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
	// cal.get(Calendar.DATE), 0, 0, 0);
	// cal.set(Calendar.MILLISECOND, 0);
	// return cal.getTime();
	// }
	//
	// /**
	// * 获取某天的开始时间
	// * @return
	// */
	// public static Date getSomeDayStartTimes(Date date)
	// {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(date);
	// calendar.set(Calendar.HOUR_OF_DAY, 00);
	// calendar.set(Calendar.MINUTE, 0);
	// calendar.set(Calendar.SECOND, 0);
	// return calendar.getTime();
	// }
	//
	// /**
	// * 获取某天的结束时间
	// * @return
	// */
	// public static Date getSomeDayEndTimes(Date date)
	// {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(date);
	// calendar.set(Calendar.HOUR_OF_DAY, 23);
	// calendar.set(Calendar.MINUTE, 59);
	// calendar.set(Calendar.SECOND, 59);
	// return calendar.getTime();
	// }
	//
	// /**
	// * 获取多少天前的开始时间
	// * @param dayCount
	// * @return
	// */
	// public static Date getSomeDayStartTime(int dayCount)
	// {
	// Calendar calendar = Calendar.getInstance();
	// calendar.setTime(new Date());
	// calendar.add(Calendar.DATE, dayCount);
	// calendar.set(Calendar.HOUR_OF_DAY, 00);
	// calendar.set(Calendar.MINUTE, 0);
	// calendar.set(Calendar.SECOND, 0);
	// return calendar.getTime();
	// }
	//
	// /**
	// * <pre>
	// * 增加天数
	// * </pre>
	// * @param date 原始日期
	// * @param days 增加的天数
	// * @return 增加days天后的日期
	// */
	// public static Date addDate(Date date, int days)
	// {
	// Calendar c = Calendar.getInstance();
	// c.setTime(date);
	// c.add(Calendar.DATE, days);
	// return c.getTime();
	// }
	//
	// /**
	// * <pre>
	// * 增加num秒后的时间
	// * </pre>
	// * @param date
	// * @param second
	// * @return
	// */
	// public static Date addSecond(Date date, long num)
	// {
	// long time = date.getTime() + num * 1000;
	// return new Date(time);
	// }
	//
	// /**
	// * <pre>
	// * 两个日期之间的连续日期
	// * </pre>
	// * @param begin
	// * @param end
	// * @return
	// */
	// public static List<String> getDaysListBetweenDates(String begin, String
	// end)
	// {
	// List<String> dateList = new ArrayList<String>();
	// Date d1;
	// Date d2;
	// try
	// {
	// d1 = DateUtils.parseDate(begin, "yyyy-MM-dd");
	// d2 = DateUtils.parseDate(end, "yyyy-MM-dd");
	// if (d1.compareTo(d2) > 0)
	// {
	// return dateList;
	// }
	// do
	// {
	// dateList.add(DateFormatUtils.format(d1, "yyyy-MM-dd"));
	// d1 = DateUtils.addDays(d1, 1);
	// }
	// while (d1.compareTo(d2) <= 0);
	// }
	// catch (Exception e)
	// {
	// throw new SException("9999", "日期转换失败");
	// }
	//
	// return dateList;
	// }
	//
	// /**
	// * <pre>
	// * begin天之前的dayCount
	// * </pre>
	// * @param begin
	// * @param dayCount
	// * @return
	// */
	// public static List<String> getDaysListBetweenDatesBefore(String begin,
	// int dayCount)
	// {
	// List<String> dateList = new ArrayList<String>();
	// if(dayCount<=0){
	// return dateList;
	// }
	//
	// try
	// {
	// Date d1 = DateUtil.parseFormatShort(begin);
	// for (int i = 1; i <= dayCount; i++)
	// {
	// d1 = DateUtils.addDays(d1, -1);
	// dateList.add(DateUtil.formatShortDate(d1));
	// }
	// Collections.reverse(dateList);
	// }
	// catch (Exception e)
	// {
	// throw new SException("9999", "日期转换失败");
	// }
	//
	// return dateList;
	// }
	//
	// public static List<String> getMonthList(int year, int month){
	// List<String> result = new ArrayList<String>();
	//
	// Calendar c = Calendar.getInstance();
	// c.set(Calendar.YEAR, year);
	// c.set(Calendar.MONTH, month-1);
	// c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
	// result.add(DateUtil.SHORT_DATE_FORMAT.format(c.getTime()));
	//
	// c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
	// result.add(DateUtil.SHORT_DATE_FORMAT.format(c.getTime()));
	//
	// return result;
	// }

	public static void main(String[] args) {
	}
}