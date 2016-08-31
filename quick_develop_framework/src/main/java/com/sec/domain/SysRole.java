package com.sec.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SysRole {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
//	@OneToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
//	private List<SysRouteRule> routeRules;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<SysRouteRule> getRouteRules() {
//		return routeRules;
//	}
//	public void setRouteRules(List<SysRouteRule> routeRules) {
//		this.routeRules = routeRules;
//	}

}

