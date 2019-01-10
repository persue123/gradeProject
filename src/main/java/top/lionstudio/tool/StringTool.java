package top.lionstudio.tool;



import java.util.HashMap;
import java.util.Map;

public class StringTool {

	private static long result = 0;
	// HashMap
	private static Map<String, Long> unitMap = new java.util.HashMap<String, Long>();
	private static Map<String, Long> numMap = new java.util.HashMap<String, Long>();

	// 字符串分离
	private static String stryi = new String();
	private static String stryiwan = new String();
	private static String stryione = new String();
	private static String strwan = new String();
	private static String strone = new String();

	private static boolean isEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}

	public static String filterEmoji(String source) {
		// 我觉得昵称里放emoji很蠢。我也不打算存储他。不过如果 有人在内容里用emoji 那他就真太可怕了
		StringBuilder buf = null;
		int len = source.length();
		for (int i = 0; i < len; i++) {
			char codePoint = source.charAt(i);
			if (isEmojiCharacter(codePoint)) {
				if (buf == null) {
					buf = new StringBuilder(source.length());
				}
				buf.append(codePoint);
			}
		}
		if (buf == null) {
			return source;
		} else {
			if (buf.length() == len) {
				buf = null;
				return source;
			} else {
				return buf.toString();
			}
		}
	}

	public static Map<String, Object> DistinguishWords(String result, String[] column) {
		// genius
		// perfect
		String nowStr = "";
		String Tcolumn = "";
		result=result.replace(" ", "");
		Map<String, Object> resmap = new HashMap<>();
		for (int i = 0; i < result.length(); i++) {
			nowStr += result.charAt(i);
			for (String itcolumn : column) {
				if (nowStr.endsWith(itcolumn)) {
					if (Tcolumn != "") {
						String value=nowStr.substring(0, nowStr.length() - itcolumn.length());
						resmap.put(Tcolumn, value);
					}
					Tcolumn = itcolumn;
					nowStr = "";
				}
			}
			if (i == result.length() - 1)
				resmap.put(Tcolumn, nowStr);
		}
		return resmap;
	}

	private static void ChangeChnString(String chnStr) {
		// unit
		unitMap.put("十", 10L);
		unitMap.put("百", 100L);
		unitMap.put("千", 1000L);
		unitMap.put("万", 10000L);
		unitMap.put("亿", 100000000L);
		// num
		numMap.put("零", 0L);
		numMap.put("一", 1L);
		numMap.put("二", 2L);
		numMap.put("三", 3L);
		numMap.put("四", 4L);
		numMap.put("五", 5L);
		numMap.put("六", 6L);
		numMap.put("七", 7L);
		numMap.put("八", 8L);
		numMap.put("九", 9L);

		// 去零
		for (int i = 0; i < chnStr.length(); i++) {
			if ('零' == (chnStr.charAt(i))) {
				chnStr = chnStr.substring(0, i) + chnStr.substring(i + 1);
			}
		}
		// 分切成三部分
		int index = 0;
		boolean yiflag = true;
		boolean yiwanflag = true; // 亿字节中存在万
		boolean wanflag = true;
		for (int i = 0; i < chnStr.length(); i++) {
			if ('亿' == (chnStr.charAt(i))) {
				// 存在亿前面也有小节的情况
				stryi = chnStr.substring(0, i);
				if (chnStr.indexOf('亿' + "") > chnStr.indexOf('万' + "")) {
					stryi = chnStr.substring(0, i);
					for (int j = 0; j < stryi.length(); j++) {
						if ('万' == (stryi.charAt(j))) {
							yiwanflag = false;
							stryiwan = stryi.substring(0, j);
							stryione = stryi.substring(j + 1);
						}
					}
				}
				if (yiwanflag) {// 亿字节中没有万，直接赋值
					stryione = stryi;
				}
				index = i + 1;
				yiflag = false;// 分节完毕
				strone = chnStr.substring(i + 1);

			}
			if ('万' == (chnStr.charAt(i)) && chnStr.indexOf('亿' + "") < chnStr.indexOf('万' + "")) {
				strwan = chnStr.substring(index, i);
				strone = chnStr.substring(i + 1);
				wanflag = false;// 分节完毕
			}
		}
		if (yiflag && wanflag) {// 没有处理
			strone = chnStr;
		}
	}

	// 字符串转换为数字
	private static long chnStrToNum(String str) {
		long strreuslt = 0;
		long value1 = 0;
		long value2 = 0;
		long value3 = 0;
		if (str.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < str.length(); i++) {
			char bit = str.charAt(i);
			// 数字
			if (numMap.containsKey(bit + "")) {
				value1 = numMap.get(bit + "");
				if (i == str.length() - 1) {
					strreuslt += value1;
				}

			}
			// 单位
			else if (unitMap.containsKey(bit + "")) {
				value2 = unitMap.get(bit + "");
				if (value1 == 0 && value2 == 10L) {
					value3 = 1 * value2;
				} else {
					value3 = value1 * value2;
					// 清零避免重复读取
					value1 = 0;
				}
				strreuslt += value3;
			}
		}
		return strreuslt;
	}

	// 组合数字
	private static long StrToNum(String chnStr) {
		//包含单位时
	
		
		ChangeChnString(chnStr);
		long stryiwanresult = chnStrToNum(stryiwan);
		long stryioneresult = chnStrToNum(stryione);
		long strwanresult = chnStrToNum(strwan);
		long stroneresult = chnStrToNum(strone);
		result = (stryiwanresult + stryioneresult) * 100000000 + strwanresult * 10000 + stroneresult;
		// 重置
		stryi = "";
		strwan = "";
		strone = "";
		return result;
	}
	
	public static String str2Num(String str) {
		//从字符串中截取出数字
		String matchstr= "十百千万亿零一二三四五六七八九";
		String numstr="";
		
		for (int i = 0; i < str.length(); i++) {
			String T=str.charAt(i)+"";
			if(matchstr.contains(T)) {
				numstr+=T;
			}
			if((!numstr.equals("")&&!matchstr.contains(T))||i==str.length()-1) {
			  return StrToNum(numstr)+"";
			}
		}
		return "";
		
	}
	
	public static String str2strAndnum(String str){
		//从字符串中替换数字
				String matchstr= "十百千万亿零一二三四五六七八九";
				String numstr="";
				String num="";
				
				for (int i = 0; i < str.length(); i++) {
					String T=str.charAt(i)+"";
					if(matchstr.contains(T)) {
						numstr+=T;
					}
					if((!numstr.equals("")&&!matchstr.contains(T))||i==str.length()-1) {
						num= StrToNum(numstr)+"";
					}
				}
				return str.replace(numstr, num);
	}
}
