package com.quo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quo.entity.Authority;
@Repository
public interface AuthorityMapper {
	public List<Authority> findListByRoleId(Integer rid);
}
