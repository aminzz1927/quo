package com.quo.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Customer;
import com.quo.entity.Dept;
import com.quo.mapper.CustomerMapper;
import com.quo.mapper.DeptMapper;
import com.quo.service.CustomerService;
import com.quo.service.DeptService;
import com.quo.utils.SqlSessionUtil;


 
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper cmapper;
	
	@Override
	public List<Customer> getAll() {
		return cmapper.getAll();
	}

}
