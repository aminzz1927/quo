package com.quo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quo.entity.Customer;
import com.quo.entity.Role;




@Repository
public interface CustomerMapper {

	List<Customer> getAll();

}
