package com.quo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quo.dto.AuthorityDto;
import com.quo.entity.Authority;


@Service
public interface AuthorityService {

	public List<AuthorityDto> findListByRoleId(Integer rid);

	
}
