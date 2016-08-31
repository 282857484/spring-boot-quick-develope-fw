package com.sec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);

}
