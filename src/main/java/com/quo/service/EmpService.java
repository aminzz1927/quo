package com.quo.service;

import java.util.List;


import com.quo.entity.Emp;
import com.quo.entity.EmpLogin;
import com.quo.exceptions.LoginException;

/**
 * 
 * @author 韩宛廷
 *
 */
public interface EmpService {

	EmpLogin login(int enoint, String pwd) throws LoginException;

	

    void changePwd(Emp emp) throws LoginException;
}
