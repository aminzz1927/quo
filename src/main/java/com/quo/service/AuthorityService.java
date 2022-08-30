package com.quo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quo.entity.Authority;


@Service
public interface AuthorityService {

	public List<Authority> findListByRoleId(Integer rid);

	
}
