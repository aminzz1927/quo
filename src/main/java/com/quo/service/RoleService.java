package com.quo.service;

import java.util.List;

import com.quo.entity.Role;



public interface RoleService {
	/**
	 * 获取所有的职位
	 * @return
	 */
	List<Role> getAll();
}
