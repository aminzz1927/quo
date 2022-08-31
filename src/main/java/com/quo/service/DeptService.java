package com.quo.service;

import java.util.List;

import com.quo.entity.Dept;




public interface DeptService {
	/**
	 * 获取所有的部门
	 * @return
	 */
	List<Dept> getAll();
}
