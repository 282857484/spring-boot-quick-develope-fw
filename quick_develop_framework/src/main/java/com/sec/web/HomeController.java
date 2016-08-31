package com.sec.web;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sec.domain.Msg;

@Controller
public class HomeController {
//	@Autowired
//	private SettingUrlResController s;
	
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method after Construct") ;
//	  s.SettingUrlRes();
	}
	
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Pre Destory ...");
	}
	
	@RequestMapping("/")
	public String index(Model model){
//		s.SettingUrlRes();
		Msg msg =  new Msg("测试标题","测试内容","额外信息对所有人显示");
		model.addAttribute("msg", msg);
		return "home";
	}
	@RequestMapping("/index")
	public String indexX(Model model){
		Msg msg =  new Msg("测试标题","测试内容","额外信息对所有人显示");
		model.addAttribute("msg", msg);
		return "home";
	}

	@RequestMapping("/index/abc")
	public String indexXX(Model model){
		Msg msg =  new Msg("测试标题","测试内容","额外信息对所有人显示");
		model.addAttribute("msg", msg);
		return "home";
	}
	@RequestMapping("/message")
	public String message(Model model){
//		s.SettingUrlRes();
		Msg msg =  new Msg("标题","内容","额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return "message";
	}
}
