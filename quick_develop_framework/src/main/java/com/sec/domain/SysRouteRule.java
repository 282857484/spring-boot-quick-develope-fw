package com.sec.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SysRouteRule {

	@Id
	@GeneratedValue
	private Long id;
	private String routename;
	
	@ManyToMany(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
	private List<SysRole> sysRoleList;
	
	@ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.REMOVE},fetch = FetchType.EAGER)
	private SysRoute route;
	/**
	 * 1-角色访问授权
	 * 2-地址访问授权
	 * 3-登陆后可访问
	 * 4-可以任意访问
	 * 5-不可访问
	 * 6-IP可访问
	 */
	private int type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRoute() {
		return route.getRoute();
	}
	public void setRoute(String route) {
		this.route.setRoute(route);
	}
	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}
	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}
	public void setRoute(SysRoute route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "SysRouteRule [id=" + id + ", routename=" + routename + ", sysRoleList=" + sysRoleList + ", route="
				+ route + ", type=" + type + "]";
	}
	
	
}
