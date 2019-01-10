package top.lionstudio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import top.lionstudio.tool.JsonTool;
import top.lionstudio.tool.RequestTool;

@Service
public class NewsService {
	@Value("${URL_GRADMS}")
	private String URL_GRADMS;
	
	public List<Map> requestNewsList(String type) {
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("CMD", "newsList"));
		nvps.add(new BasicNameValuePair("type", type));
		String content=RequestTool.HttpsPostForMap(nvps, URL_GRADMS);
		if(content==null||content.equals("")||content.equals("error")) 
			return null;
		else 
			return  (List<Map>) JsonTool.fromJson(content, List.class);
			
	}
	
	public String requestNewsDetail(String newsId) {
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("CMD", "newsDetail"));
		nvps.add(new BasicNameValuePair("id", newsId));
		String content=RequestTool.HttpsPostForMap(nvps, URL_GRADMS);
		System.out.println(content);
		if(content==null||content.equals("")||content.equals("error")) 
			return null;
		else 
			return   content;
			
	}
}
