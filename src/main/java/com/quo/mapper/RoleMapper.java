package com.quo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quo.entity.Role;




@Repository
public interface RoleMapper {

	
	List<Role> getAll();

}
