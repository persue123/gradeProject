package top.lionstudio.tool;

import com.google.gson.Gson;

public class JsonTool {
	private static Gson gson=new Gson();
	
	public static String toJson(Object object) {
		if(gson==null)
			gson=new Gson();
		return gson.toJson(object);
	}
	
	@SuppressWarnings("unchecked")
	public static Object fromJson(String json,@SuppressWarnings("rawtypes") Class c) {
		if(gson==null)
			gson=new Gson();
		return gson.fromJson(json,c);
	}

}
