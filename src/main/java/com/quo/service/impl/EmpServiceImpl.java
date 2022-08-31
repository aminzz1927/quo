package com.quo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quo.entity.Emp;
import com.quo.exceptions.LoginException;
import com.quo.mapper.EmpMapper;
import com.quo.service.EmpService;

import com.quo.utils.MD5;

import com.quo.utils.SqlSessionUtil;
/**
 * 
 * @author 韩宛廷
 *
 */

public class EmpServiceImpl implements EmpService {

	private EmpMapper empDao = SqlSessionUtil.getCurrentSqlSession().getMapper(EmpMapper.class);
	

	@Override
	public Emp login(int eno, String pwd) throws LoginException {
		// 用户名和密码是否正确
		Emp emp = empDao.getByEnoAndPwd(eno, pwd);
		if(emp == null){
			throw new LoginException("IDまたはパスワードが正しくありません。");
		}
		return emp;
	}

        


	@Override
	public void changePwd(Emp emp) throws LoginException{
		if(empDao.changePwd(emp)<=0) {
			throw new LoginException("密码更新失败");
		}
		
	}
	}
		
	

	
	














