package com.quo.mapper;

import org.springframework.stereotype.Repository;

import com.quo.entity.Emp;
@Repository
public interface UserMapper {
	int save(Emp e);
}
