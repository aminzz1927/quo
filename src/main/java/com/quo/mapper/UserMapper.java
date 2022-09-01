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
	int save(Emp e);
	
	 @Select("select eno,ename,dname,rname,tel,email from emp e left join dept d on e.dno=d.dno  left join role r on e.rid=r.rid order by eno desc")
	List<EmpDto2> getEmpAll();
	 
	 @Select("select  eno,ename,dno,rid,tel,email from emp e where eno = #{eno} order by eno desc")
	EmpDto getByEno(int eno);
	 
	 int update(EmpDto  ed);
	 
	 @Select("select  pwd from emp  where eno = #{eno} ")
		Emp getPwdByEno(int eno);
	 
	 @Update("update emp set pwd='670b14728ad9902aecba32e22fa4f6bd' where eno=#{eno}")
		int changeEmpPwd(int eno);
}
