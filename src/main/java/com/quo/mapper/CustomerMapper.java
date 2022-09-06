package com.quo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quo.entity.Customer;
import com.quo.entity.Customer2;
import com.quo.entity.ProductSeries2;
import com.quo.entity.Role;




@Repository
public interface CustomerMapper {
//获取所有顾客信息
	List<Customer2> getAll();
	//获取单个顾客信息
	Customer getByCid(int cid);
}
