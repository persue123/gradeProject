package top.lionstudio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import top.lionstudio.tool.JsonTool;
import top.lionstudio.tool.RequestTool;

@Service
public class DoctorService {
	
	@Value("${URL_GRADMS}")
	private String URL_GRADMS;
	
	public Map requestDoctorAnswerProclaimForm(int userId) {
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("userId", userId+""));
		nvps.add(new BasicNameValuePair("CMD", "docform"));
		String content=RequestTool.HttpsPostForMap(nvps, URL_GRADMS);
		if(content==null||content.equals("")||content.equals("error")) 
			return null;
		else 
			return (Map) JsonTool.fromJson(content, Map.class);
			
	}
	public Map requestAllDoctors() {
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("CMD", "doclist"));
		String content=RequestTool.HttpsPostForMap(nvps, URL_GRADMS);
		System.out.println(content);
		if(content==null||content.equals("")||content.equals("error")) 
			return null;
		else 
			return (Map) JsonTool.fromJson(content, Map.class);
	}
	
}
