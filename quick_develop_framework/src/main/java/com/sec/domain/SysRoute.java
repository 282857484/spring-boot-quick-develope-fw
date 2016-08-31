package com.sec.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SysRoute {

	@Id
	@GeneratedValue
	private Long id;
	private String requesttype;
	private String route;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "SysRoute [id=" + id + ", requesttype=" + requesttype + ", route=" + route + "]";
	}
	
	
}
