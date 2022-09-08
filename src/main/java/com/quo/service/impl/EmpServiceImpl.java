package com.quo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quo.entity.Emp;
import com.quo.entity.EmpLogin;
import com.quo.exceptions.LoginException;
import com.quo.mapper.DeptMapper;
import com.quo.mapper.EmpMapper;
import com.quo.service.EmpService;

import com.quo.utils.MD5;

import com.quo.utils.SqlSessionUtil;
/**
 * 
 * @author 韩宛廷
 *
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper emapper;
	
	@Override
	public EmpLogin login(int eno, String pwd) throws LoginException {
		// 用户名和密码是否正确
		EmpLogin emplogin = emapper.getByEnoAndPwd(eno, pwd);
		if(emplogin == null){
			throw new LoginException("IDまたはパスワードが正しくありません。");
		}
		return emplogin;
	}

        


	@Override
	public void changePwd(Emp emp) throws LoginException{
		if(emapper.changePwd(emp)<=0) {
			throw new LoginException("密码更新失败");
		}
		
	}
	}
		
	

	
	














