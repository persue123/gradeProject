package top.lionstudio.tool;






import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期操作类
 * 
 * @author douxiaobin
 */
public class DateTimeTool {

	/** 日期格式 yyyy-MM-dd */
	public static final String DateFormat1 = "yyyy-MM-dd";
	public static final String DataFormat2="yyyy-MM-dd HH:mm:ss";
	public static final String DataFormat3="yyyy-MM-dd HH:mm";
	
	public static final String DataFormat4="yyyy-MM";
	public static final String DataFormat5="yyyy-MM-dd-HH-mm-ss";
	public static final String DataFormat6="yyyyMMddHHmmss";
	public static final String DataFormat8="MM-dd HH:mm";
	public static final String HHmm="HH:mm";
	public static final String HHMM="HH点mm分";
	
	
	
	public static Date getDateFromHHMM(String hhmm) {
		Date now=new Date();
		String datestr=getFormatDate(now,DateFormat1)+" "+hhmm+":00";
		return getDateFromStr(datestr, DataFormat2);
		
		
	}
	
	public static Date changeDate2Today(Date date) {
		return getDateFromStr(getFormatDate(date,DateFormat1), DateFormat1);
	}
	
	/**
	 * 根据日期字符返回日期对象
	 * 
	 * @param datestr
	 *            比如：2006-02-03
	 * @param format
	 *            比如yyyy-MM-dd
	 * @return
	 */
	public static Date getDateFromStr(String datestr, String format) {
		if (datestr == null || "".equalsIgnoreCase(datestr)) {
			return null;
		}

		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		Date result = null;
		try {
			result = dateformat.parse(datestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 根据日期字符返回日期对象yyyy-mm-dd  yyyy/mm/dd皆可
	 * 
	 * @param datestr
	 *            比如：2006-02-03
	 * @param format
	 *            比如yyyy-MM-dd
	 * @return
	 */
	public static Date getDateFromAllStr(String datestr ) {
		String format="yyyy-MM-dd";
		if (datestr == null || "".equalsIgnoreCase(datestr)) {
			return null;
		}else{
			if(datestr.indexOf(String.valueOf('/')) == -1){
				if((datestr.split("-").length-1)==1)
					format="yyyy-MM";
				else
					format="yyyy-MM-dd";
			}else{
				if((datestr.split("/").length-1)==1)
					format="yyyy/MM";
				else
					format="yyyy/MM/dd";
			}
		}
		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		Date result = null;
		try {
			result = dateformat.parse(datestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return result;
	}
	
	

	/**
	 * 格式化日期
	 * 
	 * @param indate
	 * @param format
	 *            比如yyyy-MM-dd
	 * @return 比如：2006-02-03
	 */
	public static String getFormatDate(Date indate, String format) {
		if (indate==null) 
			return "";
		
		SimpleDateFormat dateformat = new SimpleDateFormat(format);

		return dateformat.format(indate);
	}

	/**
	 * 得到当前时间
	 * 
	 * @return
	 */
	public static Date getCurrentTime() {
		return new Date();
	}

	/**
	 * 日期加减年数
	 * 
	 * @param inDate
	 * @param addYear
	 * @return
	 */
	public static Date addYearS(final Date inDate, final int addYear) {

		return addDateS(inDate, addYear, Calendar.YEAR);
	}

	/**
	 * 日期加减月数
	 * 
	 * @param inDate
	 * @param addMonth
	 * @return
	 */
	public static Date addMonthS(final Date inDate, final int addMonth) {

		return addDateS(inDate, addMonth, Calendar.MONTH);
	}

	/**
	 * 日期加减天数
	 * 
	 * @param inDate
	 * @param addDay
	 * @return
	 */
	public static Date addDayS(final Date inDate, final int addDay) {

		return addDateS(inDate, addDay, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 日期加减小时数
	 * 
	 * @param inDate
	 * @param addDay
	 * @return
	 */
	public static Date addHourS(final Date inDate, final int addDay) {

		return addDateS(inDate, addDay, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 计算日期加减
	 * 
	 * @param inDate
	 * @param addDate
	 * @param field
	 * @return
	 */
	private static Date addDateS(final Date inDate, final int addDate,
			final int field) {

		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(inDate);

		calendar.add(field, addDate);

		return calendar.getTime();
	}

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @param fromDate
	 *            开始日
	 * @param toDate
	 *            结束日
	 * @param blnAbs
	 *            是否取绝对值
	 * @return
	 */
	public static int calcDays(Date fromDate, Date toDate, boolean blnAbs) {

		long miliSeconds1 = fromDate.getTime();
		long miliSeconds2 = toDate.getTime();

		if (fromDate.compareTo(toDate) > 0 && blnAbs == false) {
			// 不足2天算1天
			return (int) ((miliSeconds2 - miliSeconds1) / 86400000);
		}

		// 超过1天算2天
		return (int) (Math.abs(miliSeconds2 - miliSeconds1 - 1) / 86400000) + 1;
	}

	/**
	 * 计算两个日期之间的天数 （过一个0点算一天）
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static int calcDays(Date fromDate, Date toDate) {
		long miliSeconds1 = DateTimeTool.getFirstTimeOfDay(fromDate).getTime();
		long miliSeconds2 = DateTimeTool.getFirstTimeOfDay(toDate).getTime();

		return (int) ((miliSeconds2 - miliSeconds1) / 86400000);

	}

	/**
	 * 计算两个日期之间的年数
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public static int calcYears(Date fromDate, Date toDate) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(fromDate);
		int years = 0;
		Date temp = null;
		if (fromDate.before(toDate)) {
			temp = DateTimeTool.addYearS(fromDate, 1);
			while (!temp.after(toDate)) {
				temp = DateTimeTool.addYearS(temp, 1);
				years++;
			}
		} else {
			temp = DateTimeTool.addYearS(fromDate, -1);
			while (!temp.before(toDate)) {
				temp = DateTimeTool.addYearS(temp, -1);
				years--;
			}
		}

		return years;

	}

	/**
	 * 得到本年的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 得到本月的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 得到本天的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFirstTimeOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 得到日期的年份
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 得到日期的月份 (1-12)
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 得到日期是年中的第几周的
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 得到日期是一年中的第几天 (1-366)
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_YEAR);
	}

	/**
	 * 得到日期是一月中的第几天 (1-31)
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 得到日期是一周中的第几天(星期日开始，是1)
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 得到时间是一天中的哪个小时
	 * 
	 * @param date
	 * @return
	 */
	public static int getHourOfDay(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);

		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 根据输入的毫秒数，得到 "星期几",如“星期二”
	 */
	public static String getWeekDay(Date date) {
		SimpleDateFormat weekFormatter = new SimpleDateFormat("E");

		return weekFormatter.format(date);
	}

	/**
	 * 根据数字得到对应的星期名字
	 * 
	 * @param i
	 * @return
	 */
	public static String getWeekName(int i) {
		switch (i) {
		case 1:
			return "星期日";
		case 2:
			return "星期一";
		case 3:
			return "星期二";
		case 4:
			return "星期三";
		case 5:
			return "星期四";
		case 6:
			return "星期五";
		case 7:
			return "星期六";

		default:
			return "无效数字";
		}
	}

	/**
	 * 根据数字得到对应的时间段名字
	 * 
	 * @param i
	 * @return
	 */
	public static String getHourInterzone(int i) {
		switch (i) {
		case 0:
			return "00:00-01:00";
		case 1:
			return "01:00-02:00";
		case 2:
			return "02:00-03:00";
		case 3:
			return "03:00-04:00";
		case 4:
			return "04:00-05:00";
		case 5:
			return "05:00-06:00";
		case 6:
			return "06:00-07:00";
		case 7:
			return "07:00-08:00";
		case 8:
			return "08:00-09:00";
		case 9:
			return "09:00-10:00";
		case 10:
			return "10:00-11:00";
		case 11:
			return "11:00-12:00";
		case 12:
			return "12:00-13:00";
		case 13:
			return "13:00-14:00";
		case 14:
			return "14:00-15:00";
		case 15:
			return "15:00-16:00";
		case 16:
			return "16:00-17:00";
		case 17:
			return "17:00-18:00";
		case 18:
			return "18:00-19:00";
		case 19:
			return "19:00-20:00";
		case 20:
			return "20:00-21:00";
		case 21:
			return "21:00-22:00";
		case 22:
			return "22:00-23:00";
		case 23:
			return "23:00-24:00";

		default:
			return "无效数字";
		}
	}
	public static String getMonthStr(int month){
		String monthStr=null;
		if(month==Calendar.JANUARY){
			monthStr="January";
		}else if(month==Calendar.FEBRUARY){
			monthStr="February";
		}else if(month==Calendar.MARCH){
			monthStr="March";
		}else if(month==Calendar.APRIL){
			monthStr="April";
		}else if(month==Calendar.MAY){
			monthStr="May";
		}else if(month==Calendar.JUNE){
			monthStr="June";
		}else if(month==Calendar.JULY){
			monthStr="July";
		}else if(month==Calendar.AUGUST){
			monthStr="August";
		}else if(month==Calendar.SEPTEMBER){
			monthStr="September";
		}else if(month==Calendar.OCTOBER){
			monthStr="October";
		}else if(month==Calendar.NOVEMBER){
			monthStr="November";
		}else if(month==Calendar.DECEMBER){
			monthStr="December";
		}
		return monthStr;
	}
	
	public static String getShortCutMonthStr(int month){
		String monthStr=null;
		if(month==Calendar.JANUARY){
			monthStr="Jan.";
		}else if(month==Calendar.FEBRUARY){
			monthStr="Feb.";
		}else if(month==Calendar.MARCH){
			monthStr="Mar.";
		}else if(month==Calendar.APRIL){
			monthStr="Apr.";
		}else if(month==Calendar.MAY){
			monthStr="May";
		}else if(month==Calendar.JUNE){
			monthStr="Jun.";
		}else if(month==Calendar.JULY){
			monthStr="Jul.";
		}else if(month==Calendar.AUGUST){
			monthStr="Aug.";
		}else if(month==Calendar.SEPTEMBER){
			monthStr="Sept.";
		}else if(month==Calendar.OCTOBER){
			monthStr="Oct.";
		}else if(month==Calendar.NOVEMBER){
			monthStr="Nov.";
		}else if(month==Calendar.DECEMBER){
			monthStr="Dec.";
		}
		return monthStr;
	}
	
	/**
	 * 判断一个字符串是否是日期加时间的格式
	 * 日期格式为yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static Boolean isStringDateFormate(String str)
	{
		String strRex = "(\\d{4})-(0?\\d|1[12])-(0?[1-9]|[12][0-9]|3[01])\\s([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])";
		Pattern pattern = Pattern.compile(strRex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * 判断一个字符串是否是日期加时间的格式
	 * 日期格式为MM/dd/yyyy HH:mm和MM/dd/yy HH:mm
	 * @param str
	 * @return
	 */
	public static Boolean isStringDateFormate2(String str)
	{
		String strRex = "(0?\\d|1[12])/(0?[1-9]|[12][0-9]|3[01])/(\\d{4}|\\d{2})\\s([0-1]?[0-9]|2[0-3]):([0-5][0-9])";
		Pattern pattern = Pattern.compile(strRex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	/**
	 * 截取两个日期之间的天数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDaysBetweenDate(Date beginDate, Date endDate){
		return (int) ((endDate.getTime() - beginDate.getTime()) / (3600L * 1000 * 24));
	}
	
	//wj add
	public static String getChineseYear(String year) {
		char[] tempArray = year.toCharArray();
		String dateCN = "";
		for (char c : tempArray) {
			switch (c) {
			case '1':
				dateCN += "一";
				break;
			case '2':
				dateCN += "二";
				break;
			case '3':
				dateCN += "三";
				break;
			case '4':
				dateCN += "四";
				break;
			case '5':
				dateCN += "五";
				break;
			case '6':
				dateCN += "六";
				break;
			case '7':
				dateCN += "七";
				break;
			case '8':
				dateCN += "八";
				break;
			case '9':
				dateCN += "九";
				break;
			case '0':
				dateCN += "〇";
				break;
			}
		}
		return dateCN + "年";
	}
	public static String getChineseMonth(Integer month) {
		String monthCN = "";

		switch (month) {
		case 1:
			monthCN = "一月";
			break;
		case 2:
			monthCN = "二月";
			break;
		case 3:
			monthCN = "三月";
			break;
		case 4:
			monthCN = "四月";
			break;
		case 5:
			monthCN = "五月";
			break;
		case 6:
			monthCN = "六月";
			break;
		case 7:
			monthCN = "七月";
			break;
		case 8:
			monthCN = "八月";
			break;
		case 9:
			monthCN = "九月";
			break;
		case 10:
			monthCN = "十月";
			break;
		case 11:
			monthCN = "十一月";
			break;
		case 12:
			monthCN = "十二月";
			break;
		}
		return monthCN;
	}

	public static String getChineseDay(Integer day) {
		String dayCN = "";
		int temp = day;
		int i = temp / 10;
		if (i > 0) {

			switch (i) {
			case 1:
				dayCN += "十";
				break;
			case 2:
				dayCN += "二十";
				break;
			case 3:
				dayCN += "三十";
				break;
			}
			temp = temp - i * 10;
		}
		switch (temp) {
		case 1:
			dayCN += "一日";
			break;
		case 2:
			dayCN += "二日";
			break;
		case 3:
			dayCN += "三日";
			break;
		case 4:
			dayCN += "四日";
			break;
		case 5:
			dayCN += "五日";
			break;
		case 6:
			dayCN += "六日";
			break;
		case 7:
			dayCN += "七日";
			break;
		case 8:
			dayCN += "八日";
			break;
		case 9:
			dayCN += "九日";
			break;
		}
		return dayCN;
	}
}
