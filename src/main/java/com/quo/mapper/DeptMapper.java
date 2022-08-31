package com.quo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quo.entity.Dept;




@Repository
public interface DeptMapper {

	
	List<Dept> getAll();

}
