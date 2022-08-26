package com.quo.service;

import java.util.List;

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;


public interface EmpService {

	Emp login(String eno, String pwd) throws LoginException;

	

    void changePwd(Emp emp) throws LoginException;
}
