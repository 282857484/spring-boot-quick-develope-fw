package com.sec.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.sec.dao.SysRoleRepository;
import com.sec.dao.SysRouteRuleRepository;
import com.sec.domain.SysRole;
import com.sec.domain.SysRouteAuthoriseType;
import com.sec.domain.SysRouteRule;
import com.sec.security.CustomUserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{//1
	
	@Autowired
	SysRoleRepository sysRoleRepo;
	@Autowired
	SysRouteRuleRepository sysRouteRuleRepo;
	
	@Bean
	UserDetailsService customUserService(){ //2
		return new CustomUserService(); 
	}
	// 认证 鉴定-Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("hb").password("123456").
		auth.userDetailsService(customUserService()); //3
		
	}
	// 授权-authorize
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().denyAll();
		http
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.permitAll() //5
			.and()
			.logout().permitAll(); //6
		// ........................................................
//		http.authorizeRequests().antMatchers("/").hasAnyAuthority("ADMIN","USER");
//		http.authorizeRequests().antMatchers("/message").hasAuthority("ADMIN");
		// ........................................................
//		List<SysRole> sysRoleList = sysRoleRepo.findAll();
//		for(SysRole sysRole : sysRoleList){
//			for(SysRouteRule sysRoute : sysRole.getRouteRules()){
//				System.out.println("$$$sysRole$$$ : "+ sysRole.getName() + "$$$sysRoute$$$ : " +sysRoute.getRoute());
//				switch(sysRoute.getType()){
//				case SysRouteAuthoriseType.hasRole: // 一般不使用这个,需要前缀ROLE_
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).hasRole(sysRole.getName());
//					break;
//				case SysRouteAuthoriseType.hasAuthenticated:
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).hasAuthority(sysRole.getName());
//					break;
//				case SysRouteAuthoriseType.authenticated:
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).authenticated();
//					break;
//				case SysRouteAuthoriseType.permitAll:
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).permitAll();
//					break;
//				case SysRouteAuthoriseType.denyAll:
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).denyAll();
//					break;
//				case SysRouteAuthoriseType.hasIpAddress:
//					http.authorizeRequests().antMatchers(sysRoute.getRoute()).hasIpAddress(sysRole.getName());
//					break;
//				}
//			}
//		}
		// ........................................................
		List<SysRouteRule> sysRouteRuleList = sysRouteRuleRepo.findAll();
		for(SysRouteRule sysRouteRule : sysRouteRuleList){
			switch(sysRouteRule.getType()){
			case SysRouteAuthoriseType.hasRole: // 一般不使用这个,需要前缀ROLE_
				http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).hasAnyRole(sysRouteRule.getSysRoleList().toArray(new String[sysRouteRule.getSysRoleList().size()]));
				break;
			case SysRouteAuthoriseType.hasAuthenticated:
				http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).hasAnyAuthority(sysRouteRule.getSysRoleList().toArray(new String[sysRouteRule.getSysRoleList().size()]));
				break;
			case SysRouteAuthoriseType.authenticated:
				http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).authenticated();
				break;
			case SysRouteAuthoriseType.permitAll:
				http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).permitAll();
				break;
			case SysRouteAuthoriseType.denyAll:
				http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).denyAll();
				break;
			case SysRouteAuthoriseType.hasIpAddress:
				for(SysRole sysRole : sysRouteRule.getSysRoleList()){
					http.authorizeRequests().antMatchers(sysRouteRule.getRoute()).hasIpAddress(sysRole.getName());
				}
				break;
			}
		}
		
		
		http.authorizeRequests()
			.anyRequest().authenticated(); //4
		System.out.println("@@@@@@@@@"+http.getSharedObjects());
	}


}
