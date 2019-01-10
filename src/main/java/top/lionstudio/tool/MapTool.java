package top.lionstudio.tool;





import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class MapTool {
	// todo 扩展到普通class，级联真的太烦人了
	public static Map<String, String> Obj2Map(Object object, String... strings) {
		String[] namelist = strings;
		Map<String, String> resmap = new HashMap<>();
		for (String pname : namelist) {

			Method meth;
			try {
				meth = object.getClass()
						.getMethod("get" + pname.substring(0, 1).toUpperCase() + pname.substring(1, pname.length()));
				if (meth == null) {
					System.out.println(pname + "变量不可达");
					continue;
				}

				String tempvalue = meth.invoke(object).toString();
				resmap.put(pname, tempvalue);
			} catch (Exception e) {
				System.out.println(pname + "变量错误");
				e.printStackTrace();
			}

		}
		return resmap;
	}
	public static Map<String,Object> Array2Map(Object[] array, String... strings){
		if(array==null||array.length==0) {
			System.out.println("数组为空");
			return null;
		}
		if(array.length!=strings.length) {
			System.out.println("下标数目不相同");
			return null;
		}
		Map<String,Object> map=new HashMap<>();
		for(int i=0;i<array.length;i++) {
			map.put(strings[i], array[i]);
		}
		return map;
	}
	@SuppressWarnings("rawtypes")
	public static ArrayList<Map> AArray2MapArray(List<Object[]> array, String... strings){
		if(array==null||array.size()==0)
			return null;
	
	
		ArrayList<Map> ar_map=new ArrayList<>();
		
		for(Object[] ob:array) {
			ar_map.add(Array2Map(ob, strings));
		}
		return ar_map;
	}
	
	public static Map<String, Object> getErrorRes(String describeStr) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("status", 0);
		resMap.put("data", describeStr);
		return resMap;
	}

	@SuppressWarnings("unchecked")
	public static Map<String,Object> Obj2Map(Object object){
		Gson gson=new Gson();
		return gson.fromJson(gson.toJson(object), Map.class);
	}
	public static Map<String, Object> getSuccessRes(Object data) {
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("status", 1);
		resMap.put("data", data);
		System.out.println(new Gson().toJson(resMap));
		return resMap;
	}
	
	

}
