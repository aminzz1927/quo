package com.quo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quo.dto.AuthorityDto;
import com.quo.entity.Authority;


@Service
public interface AuthorityService {

	public List<Integer> findListByRoleId(Integer rid);

	public void deleteByRoleId(Integer rid);

	public boolean addAuthority(Authority authority);

	public List<String> getPerms(Integer rid);

	
}
