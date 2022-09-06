package com.quo.service;

import java.util.List;

import com.quo.entity.Customer;
import com.quo.entity.Role;



public interface CustomerService {
	/**
	 * 获取所有的职位
	 * @return
	 */
	List<Customer> getAll();
}
