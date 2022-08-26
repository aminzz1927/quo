package com.quo.utils;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

public class TransactionHandler implements InvocationHandler {

	private Object target;

	public TransactionHandler(Object target) {
		this.target = target;
	}

	// 为什么是成员方法
	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		SqlSession sqlSession = null;
		Object retValue = null;
		try {
			sqlSession = SqlSessionUtil.getCurrentSqlSession();
			// 执行真正service方法。
			retValue = method.invoke(target, args); 
			sqlSession.commit();
		} catch (Exception e) {
			SqlSessionUtil.rollback(sqlSession);
			e.printStackTrace();
			// 继续将异常上抛给controller
			throw e.getCause(); // 注意：一定要将原始的LoginException抛出。(e.getCause()得根异常。)
		} finally {
			SqlSessionUtil.close(sqlSession);
		}
		return retValue;
	}

}
