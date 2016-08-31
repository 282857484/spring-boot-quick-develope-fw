package com.sec.web;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.sec.dao.SysRouteRepository;
import com.sec.domain.SysRoute;

@Controller
public class SettingUrlResController {
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
//	@Autowired
//	private RepositoryRestHandlerMapping repositoryRestHandlerMapping;
//	@Autowired
//	private BasePathAwareHandlerMapping basePathAwareHandlerMapping;
//	@Autowired
//	private EndpointHandlerMapping endpointHandlerMapping;
//	@Autowired
//	private SimpleUrlHandlerMapping simpleUrlHandlerMapping;
	
	@Autowired
	private SysRouteRepository sysRouteRepo;
	
	public void SettingUrlRes(){
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
//		map.putAll(repositoryRestHandlerMapping.getHandlerMethods());
//		map.putAll(basePathAwareHandlerMapping.getHandlerMethods());
//		map.putAll(endpointHandlerMapping.getHandlerMethods());
		
//		simpleUrlHandlerMapping.getHandlerMap();
		
		System.out.println("********************************************");
		System.out.println(map);
		Iterator<Entry<RequestMappingInfo, HandlerMethod>>  it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<RequestMappingInfo, HandlerMethod> en = it.next();
			SysRoute sysRoute = new SysRoute();
			sysRoute.setRoute(en.getKey().getPatternsCondition().toString().substring(1, en.getKey().getPatternsCondition().toString().length()-1));
			sysRoute.setRequesttype(en.getKey().getMethodsCondition().toString());
			sysRouteRepo.save(sysRoute);
			System.out.println("key : " + en.getKey());
			System.out.println("value : " + en.getValue());
//			System.out.println("value : " + en.getValue().getMethod());
//			System.out.println("value : " + en.getValue().getShortLogMessage());
//			System.out.println("value : " + en.getValue().getBeanType());
		}
		System.out.println("********************************************");
	}

	
	public void SettingUrlRes(Map<RequestMappingInfo, HandlerMethod> map){
//		map.putAll(repositoryRestHandlerMapping.getHandlerMethods());
//		map.putAll(basePathAwareHandlerMapping.getHandlerMethods());
//		map.putAll(endpointHandlerMapping.getHandlerMethods());
		
//		simpleUrlHandlerMapping.getHandlerMap();
		
		System.out.println("********************************************");
		System.out.println(map);
		Iterator<Entry<RequestMappingInfo, HandlerMethod>>  it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<RequestMappingInfo, HandlerMethod> en = it.next();
			SysRoute sysRoute = new SysRoute();
			sysRoute.setRoute(en.getKey().getPatternsCondition().toString().substring(1, en.getKey().getPatternsCondition().toString().length()-1));
			sysRoute.setRequesttype(en.getKey().getMethodsCondition().toString());
			sysRouteRepo.save(sysRoute);
			System.out.println("key : " + en.getKey());
			System.out.println("value : " + en.getValue());
//			System.out.println("value : " + en.getValue().getMethod());
//			System.out.println("value : " + en.getValue().getShortLogMessage());
//			System.out.println("value : " + en.getValue().getBeanType());
		}
		System.out.println("********************************************");
	}
}
