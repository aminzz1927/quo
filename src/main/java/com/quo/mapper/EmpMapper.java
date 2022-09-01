package com.quo.mapper;

import java.util.List;



import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.quo.entity.Emp;

/**
 * 
 * @author 韩宛廷
 *
 */
@Repository
public interface EmpMapper {

	
    @Select("select * from emp where eno = #{arg0} and pwd = #{arg1}")
	Emp getByEnoAndPwd(int eno, String pwd);


	@Update("update emp set pwd=#{pwd} where eno=#{eno}")
	int changePwd(Emp emp);
	
}
