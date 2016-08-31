package com.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.domain.SysRouteRule;

public interface SysRouteRuleRepository extends JpaRepository<SysRouteRule, Long>{
	
}