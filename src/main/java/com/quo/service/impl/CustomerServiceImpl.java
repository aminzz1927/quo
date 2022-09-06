package com.quo.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Customer;
import com.quo.entity.Customer2;
import com.quo.entity.Dept;
import com.quo.entity.ProductSeries2;
import com.quo.mapper.CustomerMapper;
import com.quo.mapper.DeptMapper;
import com.quo.service.CustomerService;
import com.quo.service.DeptService;
import com.quo.utils.SqlSessionUtil;

/**
 * 
 * @author 韩宛廷
 *
 */
 
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper cmapper;
	
	/**
	 * 获取所有的顾客信息
	 * @return
	 */
	@Override
	public List<Customer2> getAll() {
		return cmapper.getAll();
	}
	
	/**
	 * 获取单个顾客信息
	 * @return
	 */
	@Override
	public Customer getByCid(int cid) {
		return 	cmapper.getByCid(cid);
	}

}
