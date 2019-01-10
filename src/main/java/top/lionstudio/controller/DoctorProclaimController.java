package top.lionstudio.controller;


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
import top.lionstudio.service.DoctorService;
import top.lionstudio.tool.MapTool;

@RestController
public class DoctorProclaimController {
	@Autowired
	private DoctorService doctorService;


	@RequestMapping(value = "/doctor/getdoctorproclaim", method = RequestMethod.POST)
	public @ResponseBody Object getdoctorproclaim(@RequestBody Map<String, Object> map, @SessionAttribute("USER") WechatUser user) {
	//	ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
		int id = Integer.parseInt(map.get("id")+"") ;
		
		return MapTool.getSuccessRes(doctorService.requestDoctorAnswerProclaimForm(id));
	}
	
	@RequestMapping(value = "/doctor/getdoctorlist", method = RequestMethod.POST)
	public @ResponseBody Object getdoctorlist(@RequestBody Map<String, Object> map, @SessionAttribute("USER") WechatUser user) {
	//	ZwWechatUser user = (ZwWechatUser) httpsession.getAttribute("USER");
	//	int id = user.getUserid();
	
		return MapTool.getSuccessRes(doctorService.requestAllDoctors());
	}
	
	

}
