package com.sec.domain;
/**
 * 1-角色访问授权
 * 2-授权访问授权
 * 3-登陆后可访问
 * 4-可以任意访问
 * 5-不可访问
 * 6-IP可访问
 */
public interface SysRouteAuthoriseType {

	int hasRole = 1;
	int hasAuthenticated = 2;
	int authenticated = 3;
	int permitAll = 4;
	int denyAll = 5;
	int hasIpAddress = 6;
}
