package top.lionstudio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import top.lionstudio.entity.WechatUser;
import top.lionstudio.service.NewsService;
import top.lionstudio.tool.MapTool;

@RestController
public class NewsController {
	//news
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/news/newsList", method = RequestMethod.POST)
	public @ResponseBody Object newsList(@RequestBody Map<String, Object> map, @SessionAttribute("USER") WechatUser user) {
		//push all
		String type=(String) map.get("type");
		List<Map> resultlist=newsService.requestNewsList(type);
		
		return MapTool.getSuccessRes(resultlist);
		
	}
	
	@RequestMapping(value = "/news/newsDetail", method = RequestMethod.POST)
	public @ResponseBody Object newsDetail(@RequestBody Map<String, Object> map, HttpSession httpsession) {
		String newsid=map.get("newsid")+"";
		return MapTool.getSuccessRes(newsService.requestNewsDetail(newsid));
	}
}
