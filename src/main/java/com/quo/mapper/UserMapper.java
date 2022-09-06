package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import com.quo.entity.Dept;
import com.quo.entity.Emp;
import com.quo.entity.EmpDto;
import com.quo.entity.EmpDto2;
import com.quo.entity.ProductSeries2;
@Repository
public interface UserMapper {
	//添加新用户
	int save(EmpDto e);
	//获取所有用户信息
@Select("select e.ename,e.eno,e.tel,e.email ,d.dname,r.rname from emp e left join role r on e.rid=r.rid left join dept d on r.dno=d.dno order by eno desc ")
	List<Emp> getEmpAll();
	//获取单个用户信息
	 @Select("select e.ename,d.dname,r.rname,e.eno,e.tel,e.email from emp e left join role r on e.rid=r.rid left join dept d on r.dno=d.dno where eno=#{eno} order by eno desc  ")
	Emp getByEno(int eno);
	//更新用户信息
	 int update(EmpDto  ed);
	 //查询用户密码
	 @Select("select  pwd from emp  where eno = #{eno} ")
		EmpDto2 getPwdByEno(int eno);
	 //重置用户密码
	 @Update("update emp set pwd='670b14728ad9902aecba32e22fa4f6bd' where eno=#{eno}")
		int changeEmpPwd(int eno);
	 //删除单个用户
	    int deleteByEno(int eno);
	    //删除单个用户
		boolean deleteByEnos(int[] enos);
}

