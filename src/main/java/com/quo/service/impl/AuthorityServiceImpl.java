package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.dto.AuthorityDto;
import com.quo.entity.Authority;
import com.quo.mapper.AuthorityMapper;
import com.quo.service.AuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService{
	
	@Autowired
	private AuthorityMapper authorityMapper;

	@Override
	public List<Integer> findListByRoleId(Integer rid) {
		// TODO Auto-generated method stub
		return authorityMapper.findListByRoleId(rid);
	}

	@Override
	public void deleteByRoleId(Integer rid) {

		authorityMapper.deleteByRoleId(rid);
		
		
	}

	@Override
	public boolean addAuthority(Authority authority) {
		// TODO Auto-generated method stub
		return authorityMapper.addAuthority(authority);
	}

}
