package com.quo.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quo.dto.MenuDto;
import com.quo.entity.SystemSettings;

/** 

* @author zhoumin

*/

public interface SystemMapper {

	//获取审核金额和有效期限
	@Select("select * from systemsettings")
	SystemSettings getSystemSettings();

	//更新审核金额和有效期限
	@Update("update systemsettings set amountCheck=#{amountCheck},expiry=#{expiry}")
	boolean updateSystemSettings(SystemSettings systemSettings);

	//获取登录信息及权限
	@Select("select e.ename,d.dname,r.rname,a.mid from emp e left join \r\n"
			+ "dept d on e.dno=d.dno left join role r on e.rid=r.rid left join \r\n"
			+ "authority a on e.rid=a.rid where eno=#{eno}")
	MenuDto getMenuDto(int eno);



}
