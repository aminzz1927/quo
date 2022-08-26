package com.quo.utils;

import java.io.IOException;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis的工具类。
 * 
 * @author Administrator
 *
 */
public class SqlSessionUtil {

	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

	/**
	 * 类加载的时候，加载mybatis的核心配置文件，初始化SqlSessionFactory对象。
	 * 该对象只被创建一次，不能销毁，不能重建。所以将代码放到静态代码块当中。
	 */
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("/com/quo/config/mybatis-config.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取当前线程中的SqlSession对象
	 * 
	 * @return
	 */
	public static SqlSession getCurrentSqlSession() {
		SqlSession sqlSession = local.get();
		if (sqlSession == null) {
			sqlSession = factory.openSession();
			local.set(sqlSession);
		}
		return sqlSession;
	}

	/**
	 * 关闭资源
	 * 
	 * @param sqlSession
	 */
	public static void close(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.close();
			local.remove(); // 解除当前线程和SqlSession对象的绑定关系。原因是：线程在Tomcat服务器中可以被重复使用。(Tomcat有一个线程池)
		}
	}

	/**
	 * 回滚事务
	 * 
	 * @param sqlSession
	 */
	public static void rollback(SqlSession sqlSession) {
		if (sqlSession != null) {
			sqlSession.rollback();
		}
	}
}
