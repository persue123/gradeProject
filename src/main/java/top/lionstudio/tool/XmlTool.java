package top.lionstudio.tool;





import java.sql.Timestamp;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlTool {
	private static XmlTool parser;

	public static XmlTool getParserInstance() {
		if (parser == null)
			parser = new XmlTool();
		return parser;
	}



	public static String obj2xml(Object msg) {
		String result = "";
		try {
			Field[] properties = msg.getClass().getDeclaredFields();
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("xml");
			Element temp;
			String tempvalue = "";

			for (int i = 0; i < properties.length; i++) {
				Method meth = msg.getClass().getMethod("get" + properties[i].getName().substring(0, 1).toUpperCase()
						+ properties[i].getName().substring(1, properties[i].getName().length()));
				tempvalue = meth.invoke(msg).toString();
				if (!tempvalue.equals("")) {
					temp = root.addElement(properties[i].getName());
					temp.setText(tempvalue);
				} else {

				}

			}
			result = document.asXML();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;

	}

	public static void xml2obj(String strXml, Object object) {

		@SuppressWarnings("rawtypes")
		Class c = object.getClass();
		try {
			Document document = DocumentHelper.parseText(strXml);
			Element root = document.getRootElement();
			@SuppressWarnings("rawtypes")
			Iterator iter = root.elementIterator();

			while (iter.hasNext()) {

				Element ele = (Element) iter.next();
				Field field = null;
				String fieldname = underline2Camel(ele.getName(), true);

				System.out.println("xml节点名:" + ele.getName());
				System.out.println("xml节点值:" + ele.getText());
				System.out.println("Obj转驼峰对应项:" + underline2Camel(ele.getName(), true));
				try {
					field = c.getDeclaredField(fieldname);
				} catch (Exception e) {
					System.out.println(fieldname + "项不存在，continue");
					System.out.println("--------------------");
					continue;

				}
				@SuppressWarnings("unchecked")
				Method method = c.getDeclaredMethod(
						"set" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1, fieldname.length()),
						field.getType());

				if (method != null) {
					Class<?>[] parameterTypes = method.getParameterTypes();

					String parameterName = parameterTypes[0].toString();

					switch (parameterName) {
					case "int":
						System.out.println("项类型：" + parameterName);
						method.invoke(object, Integer.parseInt(ele.getText()));
						break;
					case "class java.lang.Integer":
						System.out.println("项类型：" + parameterName);
						method.invoke(object, Integer.parseInt(ele.getText()));
						break;
					case "double":
						System.out.println("项类型：" + parameterName);
						method.invoke(object, Double.parseDouble(ele.getText()));
						break;
					case "class java.lang.String":
						System.out.println("项类型：" + parameterName);
						method.invoke(object, ele.getText());
						break;
					case "class java.security.Timestamp":
						System.out.println("项类型：" + parameterName);
						method.invoke(object, new Timestamp(Long.parseLong(ele.getText()) * 1000));
						break;
					default:
						break;
					}
					System.out.println("对应get方法存在:" + method.getName() + "注入成功");
				} else {
					System.out.println("对应get方法不存在");
				}
				System.out.println("--------------------");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static String underline2Camel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0))
					: Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString().replace("_$n", "");
	}

	public static String camel2Underline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}

}
