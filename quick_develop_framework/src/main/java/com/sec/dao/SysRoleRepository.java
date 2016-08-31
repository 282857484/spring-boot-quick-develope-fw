package com.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.domain.SysRole;

public interface SysRoleRepository  extends JpaRepository<SysRole, Long> {
	SysRole findByName(String name);
}
