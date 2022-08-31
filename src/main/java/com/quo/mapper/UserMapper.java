package com.quo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
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
}
