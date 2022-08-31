package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Role;
import com.quo.mapper.DeptMapper;
import com.quo.mapper.RoleMapper;
import com.quo.service.RoleService;
import com.quo.utils.SqlSessionUtil;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper rmapper;
	
	@Override
	public List<Role> getAll() {
		return rmapper.getAll();
	}

}
