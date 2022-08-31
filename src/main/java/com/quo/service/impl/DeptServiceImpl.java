package com.quo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Dept;
import com.quo.mapper.DeptMapper;
import com.quo.service.DeptService;
import com.quo.utils.SqlSessionUtil;


 
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper dmapper;
	
	@Override
	public List<Dept> getAll() {
		return dmapper.getAll();
	}

}
