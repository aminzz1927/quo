package com.quo.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quo.entity.Emp;

/**
 * 
 * @author 韩宛廷
 *
 */

public interface EmpMapper {

	
    @Select("select * from emp where eno = #{arg0} and pwd = #{arg1}")
	Emp getByEnoAndPwd(String eno, String pwd);


	@Update("update emp set pwd=#{pwd} where eno=#{eno}")
	int changePwd(Emp emp);
	

}
