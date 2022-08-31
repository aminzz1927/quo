package com.quo.service;



import com.quo.entity.Emp;

import com.quo.exceptions.LoginException;

public interface UserService {
	boolean save(Emp e);
}
