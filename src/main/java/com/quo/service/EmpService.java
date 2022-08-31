package com.quo.service;

import java.util.List;


import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;

/**
 * 
 * @author 韩宛廷
 *
 */
public interface EmpService {

	Emp login(int eno, String pwd) throws LoginException;

	

    void changePwd(Emp emp) throws LoginException;
}
